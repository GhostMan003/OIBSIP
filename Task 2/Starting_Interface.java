import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Starting_Interface extends JFrame implements ActionListener{

    private JLabel startLabel,ruletextLabel,rulesLabel,starttextLabel;
    private JButton startButton,exitButton;

    Starting_Interface() {
        setTitle("Game starting point");
        setLayout(null);

        startLabel = new JLabel("Number Guessing Game");
        startLabel.setFont(new Font("osward", Font.BOLD,30));
        startLabel.setBounds(170,30,500,35);
        add(startLabel);

        //Rule text
        ruletextLabel = new JLabel("Rules: ");
        ruletextLabel.setFont(new Font("osward", Font.PLAIN,20));
        ruletextLabel.setBounds(30,90,150,15);
        add(ruletextLabel);
        //Rule 1
        rulesLabel = new JLabel("1. You have to Guess a number between 1 to 100");
        rulesLabel.setFont(new Font("osward", Font.PLAIN,20));
        rulesLabel.setBounds(50,130,500,25);
        add(rulesLabel);
        //Rule 2
        rulesLabel = new JLabel("2. You have only 10 attempts.");
        rulesLabel.setFont(new Font("osward", Font.PLAIN,20));
        rulesLabel.setBounds(50,170,500,25);
        add(rulesLabel);
        //Rule 3
        rulesLabel = new JLabel("3. Here are Five Rounds.");
        rulesLabel.setFont(new Font("osward", Font.PLAIN,20));
        rulesLabel.setBounds(50,210,600,25);
        add(rulesLabel);
        //Rule 4
        rulesLabel = new JLabel("4. Not able to Guess the number in 10 attempts not Eligible to go next.");
        rulesLabel.setFont(new Font("Relaway", Font.PLAIN,20));
        rulesLabel.setBounds(50,250,700,25);
        add(rulesLabel);

        starttextLabel = new JLabel("Click Start to Play");
        starttextLabel.setFont(new Font("setif", Font.BOLD,15));
        starttextLabel.setBounds(140,320,250,20);
        add(starttextLabel);

        //start Button 
        startButton = new JButton("Start");
        startButton.setFont( new Font("Osward", Font.BOLD,35));
        startButton.setBounds(130,350,150,45);
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.addActionListener(this);
        add(startButton);
        //exit Button 
        exitButton = new JButton("Quit");
        exitButton.setFont( new Font("Osward", Font.BOLD,35));
        exitButton.setBounds(430,350,150,45);
        exitButton.setBackground(Color.BLACK);
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(this);
        add(exitButton);


        setSize(700,450);
        setLocation(500, 170);
        setUndecorated(true);
        getContentPane().setBackground(Color.white);
    }

    public void actionPerformed(ActionEvent ac) {

        if (ac.getSource() == exitButton){
            System.exit(0);
        }
        else {
            setVisible(false);
            new Round_1().setVisible(true);
        }
    
    }
    public static void main(String[] args) {
        new Starting_Interface().setVisible(true);
    }
}
