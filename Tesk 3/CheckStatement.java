package ATM.Interface.System;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckStatement extends JFrame implements ActionListener {

    private JLabel imageLabel, textLabel;
    private JButton miniButton, maxButton, backButton;
    private final String pinNO, bankString, cardNO;

    public CheckStatement(String pinNO, String bankString, String cardNO) {

        this.pinNO = pinNO;
        this.cardNO = cardNO;
        this.bankString = bankString;
        setLayout(null);

        // import ATM interface image
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Icon/Interface1.jpg"));
        Image image2 = image1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        imageLabel = new JLabel(image3);
        imageLabel.setBounds(0, 0, 800, 700);
        add(imageLabel);

        // Text on image label
        textLabel = new JLabel("Money Transaction Statement");
        textLabel.setFont(new Font("serif", Font.PLAIN, 20));
        textLabel.setBounds(180, 145, 800, 25);
        textLabel.setForeground(Color.white);
        imageLabel.add(textLabel);

        // Last 3 transaction Mini Statement Button
        miniButton = new JButton("Mini Statement");
        miniButton.setFont(new Font("Relaway", Font.PLAIN, 25));
        miniButton.setBackground(Color.lightGray);
        miniButton.setForeground(Color.black);
        miniButton.setBorder(new BevelBorder(BevelBorder.LOWERED));
        miniButton.setBounds(180, 280, 190, 35);
        miniButton.addActionListener(this);
        imageLabel.add(miniButton);

        // Last 10 transaction statement Button
        maxButton = new JButton("Statement");
        maxButton.setFont(new Font("Relaway", Font.PLAIN, 25));
        maxButton.setBackground(Color.lightGray);
        maxButton.setForeground(Color.black);
        maxButton.setBorder(new BevelBorder(BevelBorder.LOWERED));
        maxButton.setBounds(180, 330, 190, 35);
        maxButton.addActionListener(this);
        imageLabel.add(maxButton);

        // Back button
        backButton = new JButton("BACK");
        backButton.setFont(new Font("Raleway", Font.TRUETYPE_FONT, 25));
        backButton.setBounds(430, 330, 190, 35);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);
        backButton.setBorder(new BevelBorder(BevelBorder.RAISED));
        backButton.addActionListener(this);
        imageLabel.add(backButton);

        setSize(800, 700);
        setLocation(350, 50);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource() == backButton) {
            setVisible(false);
            new MoneyTranction(pinNO, bankString, cardNO).setVisible(true);
        } else if (ac.getSource() == miniButton) {
            new MiniStatement(pinNO, bankString, cardNO).setVisible(true);
            return;
        } else if (ac.getSource() == maxButton) {
            new E_Statement(pinNO, bankString, cardNO).setVisible(true);
            return;
        }

    }

    // public static void main(String[] args) {
    //     new CheckStatement("","","");
    // }
}
