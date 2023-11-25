package ATM.Interface.System;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.ResultSet;

public class Log_in extends JFrame implements ActionListener {

    private JButton sign_in, sign_up, card_remove, pin_remove, exitButton;
    private JTextField card_text;
    private JPasswordField pin_text;
    private JLabel card_no, text, BankName, pin_no;
    private JComboBox bankcombo;
    private final String valBank[] = { "None", "SBI", "BOB", "UCO", "AXIS", "HDFC", "BOI" };

    public Log_in() {
        setTitle("ATM");
        setLayout(null);

        // Bank Logo1 Datails
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(40, 20, 100, 100);
        add(l1);

        // near logo title label
        text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Monospaced", Font.BOLD, 60));
        text.setBounds(150, 10, 600, 140);
        add(text);

        // Bank Logo2 Datails
        Image i5 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);
        l2.setBounds(665, 20, 100, 100);
        add(l2);

        // choose Bank name label
        BankName = new JLabel("CHOOSE BANK: ");
        BankName.setFont(new Font("Serif", Font.BOLD, 30));
        BankName.setBounds(90, 10, 400, 350);
        add(BankName);
        // choose Bank name text field
        bankcombo = new JComboBox(valBank);
        bankcombo.setForeground(Color.black);
        bankcombo.setBorder(new BevelBorder(BevelBorder.RAISED));
        bankcombo.setBounds(350, 175, 100, 30);
        add(bankcombo);

        // card_no text label
        card_no = new JLabel("CARD NO: ");
        card_no.setFont(new Font("Serif", Font.BOLD, 30));
        card_no.setBounds(90, 10, 300, 500);
        add(card_no);
        // card text field
        card_text = new JTextField();
        card_text.setBounds(270, 250, 250, 30);
        card_text.setFont(new Font("Arial", Font.PLAIN, 26));
        add(card_text);
        // card Remove Button
        card_remove = new JButton("Remove");
        card_remove.setBounds(530, 250, 90, 30);
        card_remove.addActionListener(this);
        add(card_remove);

        // pin_no text label
        pin_no = new JLabel("PIN NO: ");
        pin_no.setFont(new Font("Serif", Font.BOLD, 30));
        pin_no.setBounds(90, 10, 300, 600);
        add(pin_no);
        // pin text field
        pin_text = new JPasswordField();
        pin_text.setBounds(270, 300, 100, 30);
        pin_text.setFont(new Font("Arial", Font.PLAIN, 26));
        add(pin_text);
        // pin Remove Button
        pin_remove = new JButton("Remove");
        pin_remove.setBounds(380, 300, 90, 30);
        pin_remove.addActionListener(this);
        add(pin_remove);

        JLabel textLabel1 = new JLabel(
                ">>> Don't have an account then create it by clicking Sign-Up button and get your ATM CARD NO and PIN.");
        textLabel1.setFont(new Font("Arial", Font.PLAIN, 13));
        textLabel1.setBounds(90, 360, 700, 15);
        add(textLabel1);
        JLabel textLabel2 = new JLabel(">>> Otherwise Enter your CARD NO and PIN.");
        textLabel2.setFont(new Font("Arial", Font.PLAIN, 13));
        textLabel2.setBounds(270, 380, 700, 15);
        add(textLabel2);

        // Log In Button
        sign_in = new JButton("Log in");
        sign_in.setFont(new Font("Osward", Font.BOLD, 25));
        sign_in.setBounds(90, 430, 190, 45);
        sign_in.setBackground(Color.BLACK);
        sign_in.setForeground(Color.WHITE);
        sign_in.addActionListener(this);
        add(sign_in);

        // sign up Button
        sign_up = new JButton("Sign Up");
        sign_up.setFont(new Font("Osward", Font.BOLD, 25));
        sign_up.setBounds(435, 430, 190, 45);
        sign_up.setBackground(Color.BLACK);
        sign_up.setForeground(Color.WHITE);
        sign_up.addActionListener(this);
        add(sign_up);

        // Exit Button
        exitButton = new JButton("EXIT");
        exitButton.setFont(new Font("Osward", Font.BOLD, 25));
        exitButton.setBounds(260, 500, 200, 45);
        exitButton.setBackground(Color.BLACK);
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(this);
        add(exitButton);

        getContentPane().setBackground(Color.LIGHT_GRAY);

        setSize(800, 600);
        setLocation(350, 130);
        setUndecorated(true);
    }

    public void actionPerformed(ActionEvent ac) {

        String card_String = card_text.getText();
        String pin_String = pin_text.getText();
        String bank_String = (String) bankcombo.getSelectedItem();

        if (ac.getSource() == exitButton) {
            System.exit(0);
        } else if (ac.getSource() == sign_in) {
            if (bank_String.equals("None")) {
                JOptionPane.showMessageDialog(null, "Choose Your Bank");
            } else if (card_String.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter your Card Number");
            } else if (pin_String.equals("")) {
                JOptionPane.showMessageDialog(null, "You Forget to Enter your PIN Number");
            } else if (pin_String.equals("")) {
                JOptionPane.showMessageDialog(null, "You Forget to Enter your PIN Number");
            } else {
                ConnectionManager conn = new ConnectionManager();
                String quaryString = "select * from Log_In where Card_Number = '" + card_String + "' and PIN_NO = '"
                        + pin_String + "'";
                try {
                    ResultSet resultSet = conn.statement.executeQuery(quaryString);
                    if (resultSet.next()) {
                        setVisible(false);
                        new MoneyTranction(pin_String, bank_String, card_String).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect Entry");
                    }

                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
        } else if (ac.getSource() == sign_up) {
            setVisible(false);
            new Application_One().setVisible(true);
        } else if (ac.getSource() == card_remove) {
            card_text.setText("");
            pin_text.setText("");
        } else if (ac.getSource() == pin_remove) {
            pin_text.setText("");
        }

    }

    public static void main(String[] args) {
        new Log_in().setVisible(true);
    }

}