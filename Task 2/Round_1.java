import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Round_1 extends JFrame implements ActionListener {

    private final int randomNumber;
    private int attemptsLeft;
    private int attemptslimit;
    private int score;

    private JLabel guessLabel, textLabel;
    private JTextField guessField;
    private JButton guessButton, nextButton;

    public Round_1() {
        randomNumber = (int) (Math.random() * 100) + 1;
        attemptsLeft = 0;
        attemptslimit = 10;
        score = 0;
        setLayout(null);

        // Round number
        textLabel = new JLabel("Round 1");
        textLabel.setFont(new Font("serif", Font.BOLD, 35));
        textLabel.setBounds(180, 30, 200, 40);
        add(textLabel);

        // Text
        guessLabel = new JLabel("Guess a Number between (1 to 100) in " + attemptslimit + " attemsts: ");
        guessLabel.setFont(new Font("Relaway", Font.TRUETYPE_FONT, 20));
        guessLabel.setBounds(10, 100, 500, 20);
        add(guessLabel);

        // Text field
        guessField = new JTextField();
        guessField.setFont(new Font("Osward", Font.BOLD, 45));
        guessField.setBorder(new BevelBorder(BevelBorder.RAISED));
        guessField.setBounds(130, 180, 200, 50);
        add(guessField);

        // Guess Button
        guessButton = new JButton("Guess");
        guessButton.setFont(new Font("Osward", Font.PLAIN, 35));
        guessButton.setBounds(50, 280, 150, 45);
        guessButton.addActionListener(this);
        add(guessButton);

        // Next Button
        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Osward", Font.PLAIN, 35));
        nextButton.setBounds(250, 280, 150, 45);
        nextButton.addActionListener(this);
        nextButton.setEnabled(false);
        add(nextButton);

        getContentPane().setBackground(Color.lightGray);
        setSize(500, 400);
        setLocation(500, 170);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        String numberString = guessField.getText();
        try {
            if (numberString.equals("")) {
                JOptionPane.showMessageDialog(null, "Forget to enter the number");
            } else if (ae.getSource() == guessButton) {
                int guess = Integer.parseInt(guessField.getText());

                if (guess == randomNumber) {
                    score += (attemptslimit - attemptsLeft);
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number.");

                    guessButton.setEnabled(false);
                    nextButton.setEnabled(true);
                    guessField.setEnabled(false);
                } else if (attemptsLeft == attemptslimit) {
                    JOptionPane.showMessageDialog(null, "Sorry, you have reached the maximum number of attempts.");
                    resetGame();
                } else if (guess < randomNumber) {
                    JOptionPane.showMessageDialog(null, "Too low! Attempt: " + (attemptsLeft + 1));
                    guessField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Too high! Attempt: " + (attemptsLeft + 1));
                    guessField.setText("");
                }
                attemptsLeft++;
            } else if (ae.getSource() == nextButton) {
                setVisible(false);
                String scoreString = "" + score;
                new Round_2(scoreString).setVisible(true);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void resetGame() {
        setVisible(false);
        new Starting_Interface().setVisible(true);
    }

}
