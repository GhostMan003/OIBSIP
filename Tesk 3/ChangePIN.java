package ATM.Interface.System;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePIN extends JFrame implements ActionListener {

    private JLabel imagelabel, textLabel, oldpinLabel, pinLabel, repinLabel;
    private JPasswordField oldpinField, pinField, reenterpinField;
    private JButton pinchangeButton, backButton, removeButton;
    private final String pinNO, bankString, cardNO;

    public ChangePIN(String pinNO, String bankString, String cardNO) {

        this.pinNO = pinNO;
        this.bankString = bankString;
        this.cardNO = cardNO;

        setLayout(null);

        // import ATM interface image
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Icon/Interface1.jpg"));
        Image image2 = image1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        imagelabel = new JLabel(image3);
        imagelabel.setBounds(0, 0, 800, 700);
        add(imagelabel);

        // TextLabel
        textLabel = new JLabel("Want to change your PIN");
        textLabel.setFont(new Font("serif", Font.TRUETYPE_FONT, 25));
        textLabel.setForeground(Color.WHITE);
        textLabel.setBounds(250, 145, 800, 30);
        imagelabel.add(textLabel);

        // Old PinLabel
        oldpinLabel = new JLabel("OLD PIN: ");
        oldpinLabel.setFont(new Font("Raleway", Font.TRUETYPE_FONT, 15));
        oldpinLabel.setForeground(Color.WHITE);
        oldpinLabel.setBounds(180, 190, 400, 15);
        imagelabel.add(oldpinLabel);
        // old pinField
        oldpinField = new JPasswordField();
        oldpinField.setFont(new Font("Osward", Font.PLAIN, 30));
        oldpinField.setBounds(180, 210, 200, 30);
        oldpinField.setForeground(Color.black);
        oldpinField.setBorder(new BevelBorder(BevelBorder.LOWERED));
        imagelabel.add(oldpinField);

        // PinLabel
        pinLabel = new JLabel("NEW PIN: ");
        pinLabel.setFont(new Font("Raleway", Font.TRUETYPE_FONT, 15));
        pinLabel.setForeground(Color.WHITE);
        pinLabel.setBounds(180, 260, 400, 15);
        imagelabel.add(pinLabel);
        // pinField
        pinField = new JPasswordField();
        pinField.setFont(new Font("Osward", Font.PLAIN, 30));
        pinField.setBounds(180, 280, 200, 30);
        pinField.setForeground(Color.black);
        pinField.setBorder(new BevelBorder(BevelBorder.LOWERED));
        imagelabel.add(pinField);

        // Re Enter Pin Label
        repinLabel = new JLabel("CONFIRM PIN: ");
        repinLabel.setFont(new Font("Raleway", Font.TRUETYPE_FONT, 15));
        repinLabel.setForeground(Color.WHITE);
        repinLabel.setBounds(180, 330, 400, 15);
        imagelabel.add(repinLabel);
        // Re Enter Field
        reenterpinField = new JPasswordField();
        reenterpinField.setFont(new Font("Osward", Font.PLAIN, 30));
        reenterpinField.setBounds(180, 350, 200, 30);
        reenterpinField.setForeground(Color.black);
        reenterpinField.setBorder(new BevelBorder(BevelBorder.LOWERED));
        imagelabel.add(reenterpinField);

        // pin Change button
        pinchangeButton = new JButton("PIN CHANGE");
        pinchangeButton.setFont(new Font("Raleway", Font.TRUETYPE_FONT, 25));
        pinchangeButton.setBounds(430, 210, 190, 35);
        pinchangeButton.setBackground(Color.LIGHT_GRAY);
        pinchangeButton.setForeground(Color.BLACK);
        pinchangeButton.setBorder(new BevelBorder(BevelBorder.RAISED));
        pinchangeButton.addActionListener(this);
        imagelabel.add(pinchangeButton);

        // Back button
        backButton = new JButton("BACK");
        backButton.setFont(new Font("Raleway", Font.TRUETYPE_FONT, 25));
        backButton.setBounds(430, 280, 190, 35);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);
        backButton.setBorder(new BevelBorder(BevelBorder.RAISED));
        backButton.addActionListener(this);
        imagelabel.add(backButton);

        // Remove button
        removeButton = new JButton("REMOVE");
        removeButton.setFont(new Font("Raleway", Font.TRUETYPE_FONT, 25));
        removeButton.setBounds(430, 345, 190, 35);
        removeButton.setBackground(Color.LIGHT_GRAY);
        removeButton.setForeground(Color.BLACK);
        removeButton.setBorder(new BevelBorder(BevelBorder.RAISED));
        removeButton.addActionListener(this);
        imagelabel.add(removeButton);

        setSize(800, 700);
        setLocation(350, 50);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ac) {

        if (ac.getSource() == pinchangeButton) {
            try {
                String oldpinString = oldpinField.getText();
                String newpinString = pinField.getText();
                String repinString = reenterpinField.getText();

                if (oldpinString.equals(pinNO)) {
                    if (!newpinString.equals(repinString)) {
                        JOptionPane.showMessageDialog(null, "Entered PIN not match");
                        return;
                    }
                    if (newpinString.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please enter New PIN");
                    }
                    if (repinString.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please Confirm your PIN");
                    }

                    ConnectionManager conn = new ConnectionManager();
                    String quary1String = "update Transaction_Table set PIN_NO = '" + repinString + "' where PIN_NO = '"
                            + pinNO + "'";
                    String quary2String = "update Log_In set PIN_NO = '" + repinString + "' where PIN_NO = '" + pinNO
                            + "'";
                    String quary3String = "update Application_Three set PIN_NO = '" + repinString + "' where PIN_NO = '"
                            + pinNO + "'";

                    conn.statement.executeUpdate(quary1String);
                    conn.statement.executeUpdate(quary2String);
                    conn.statement.executeUpdate(quary3String);

                    JOptionPane.showMessageDialog(null, "PIN changed successfully");

                    setVisible(false);
                    new MoneyTranction(repinString, bankString, cardNO).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect OLD PIN");
                }

            } catch (Exception e) {
                e.getStackTrace();
            }
        } else if (ac.getSource() == removeButton) {
            oldpinField.setText("");
            pinField.setText("");
            reenterpinField.setText("");
        } else {
            setVisible(false);
            new MoneyTranction(pinNO, bankString, cardNO).setVisible(true);
        }
    }
}
