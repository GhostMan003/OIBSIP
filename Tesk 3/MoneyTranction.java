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

public class MoneyTranction extends JFrame implements ActionListener {

    private JLabel imagelabel, textlabel;
    private JButton depositButton, withdrawlButton, statementButton, pinchangeButton, exitButton, balanceButton,
            fastcaseButton;
    private final String pinNO, bankString, cardNO;

    public MoneyTranction(String PIN_NO, String bankString, String cardNO) {

        this.cardNO = cardNO;
        this.pinNO = PIN_NO;
        this.bankString = bankString;
        setLayout(null);

        // import ATM interface image
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Icon/Interface1.jpg"));
        Image image2 = image1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        imagelabel = new JLabel(image3);
        imagelabel.setBounds(0, 0, 800, 700);
        add(imagelabel);

        // Text on image label
        textlabel = new JLabel("Select Your Transaction Process");
        textlabel.setFont(new Font("serif", Font.PLAIN, 20));
        textlabel.setBounds(180, 145, 800, 25);
        textlabel.setForeground(Color.white);
        imagelabel.add(textlabel);

        // Left side Buttons
        // Deposit Button
        depositButton = new JButton("DEPOSIT");
        depositButton.setFont(new Font("Relaway", Font.PLAIN, 20));
        depositButton.setBackground(Color.lightGray);
        depositButton.setForeground(Color.black);
        depositButton.setBorder(new BevelBorder(BevelBorder.LOWERED));
        depositButton.setBounds(180, 220, 180, 30);
        depositButton.addActionListener(this);
        imagelabel.add(depositButton);
        // Fast cash Button
        fastcaseButton = new JButton("FAST CASH");
        fastcaseButton.setFont(new Font("Relaway", Font.PLAIN, 20));
        fastcaseButton.setBackground(Color.lightGray);
        fastcaseButton.setForeground(Color.black);
        fastcaseButton.setBorder(new BevelBorder(BevelBorder.LOWERED));
        fastcaseButton.setBounds(180, 260, 180, 30);
        fastcaseButton.addActionListener(this);
        imagelabel.add(fastcaseButton);
        // Pin change Button
        pinchangeButton = new JButton("PIN CHNAGE");
        pinchangeButton.setFont(new Font("Relaway", Font.PLAIN, 20));
        pinchangeButton.setBackground(Color.lightGray);
        pinchangeButton.setForeground(Color.black);
        pinchangeButton.setBorder(new BevelBorder(BevelBorder.LOWERED));
        pinchangeButton.setBounds(180, 300, 180, 30);
        pinchangeButton.addActionListener(this);
        imagelabel.add(pinchangeButton);

        // Right side Buttons
        // Withdrawl Button
        withdrawlButton = new JButton("WITHDRAWL");
        withdrawlButton.setFont(new Font("Relaway", Font.PLAIN, 20));
        withdrawlButton.setBackground(Color.lightGray);
        withdrawlButton.setForeground(Color.black);
        withdrawlButton.setBorder(new BevelBorder(BevelBorder.LOWERED));
        withdrawlButton.setBounds(430, 220, 190, 30);
        withdrawlButton.addActionListener(this);
        imagelabel.add(withdrawlButton);
        // statement Button
        statementButton = new JButton("E-STATEMENT");
        statementButton.setFont(new Font("Relaway", Font.PLAIN, 20));
        statementButton.setBackground(Color.lightGray);
        statementButton.setForeground(Color.black);
        statementButton.setBorder(new BevelBorder(BevelBorder.LOWERED));
        statementButton.setBounds(430, 260, 190, 30);
        statementButton.addActionListener(this);
        imagelabel.add(statementButton);
        // Balance check Button
        balanceButton = new JButton("BALANCE");
        balanceButton.setFont(new Font("Relaway", Font.PLAIN, 20));
        balanceButton.setBackground(Color.lightGray);
        balanceButton.setForeground(Color.black);
        balanceButton.setBorder(new BevelBorder(BevelBorder.LOWERED));
        balanceButton.setBounds(430, 300, 190, 30);
        balanceButton.addActionListener(this);
        imagelabel.add(balanceButton);
        // Exit Button
        exitButton = new JButton("EXIT");
        exitButton.setFont(new Font("Relaway", Font.PLAIN, 20));
        exitButton.setBackground(Color.lightGray);
        exitButton.setForeground(Color.black);
        exitButton.setBorder(new BevelBorder(BevelBorder.LOWERED));
        exitButton.setBounds(430, 340, 190, 30);
        exitButton.addActionListener(this);
        imagelabel.add(exitButton);

        setSize(800, 700);
        setLocation(350, 50);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource() == depositButton) {
            setVisible(false);
            new CashDeposite(pinNO, bankString, cardNO).setVisible(true);
        } else if (ac.getSource() == withdrawlButton) {
            setVisible(false);
            new CashWithdrawl(pinNO, bankString, cardNO).setVisible(true);
        } else if (ac.getSource() == fastcaseButton) {
            setVisible(false);
            new CashFast(pinNO, bankString, cardNO).setVisible(true);
            ;
        } else if (ac.getSource() == statementButton) {
            setVisible(false);
            new CheckStatement(pinNO, bankString, cardNO).setVisible(true);
        } else if (ac.getSource() == pinchangeButton) {
            setVisible(false);
            new ChangePIN(pinNO, bankString, cardNO).setVisible(true);
            ;
        } else if (ac.getSource() == balanceButton) {
            setVisible(false);
            new CheckBalance(pinNO, bankString, cardNO).setVisible(true);
        } else if (ac.getSource() == exitButton) {
            setVisible(false);
            new Log_in().setVisible(true);
        }

    }
}
