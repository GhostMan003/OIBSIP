package ATM.Interface.System;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.text.SimpleDateFormat;

import java.util.Date;

public class CashDeposite extends JFrame implements ActionListener {

    private JLabel imagelabel, textlabel;
    private JTextField textField;
    private JButton depositButton, backButton;
    private final String pinNO, bankString, cardNO;

    public CashDeposite(String PinNO, String bankString, String cardNO) {

        this.pinNO = PinNO;
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

        // Text on image label
        textlabel = new JLabel("Enter Amount You Want to DEPOSIT");
        textlabel.setFont(new Font("Relaway", Font.PLAIN, 20));
        textlabel.setBounds(180, 145, 850, 25);
        textlabel.setForeground(Color.white);
        imagelabel.add(textlabel);

        // Amount field
        textField = new JTextField();
        textField.setFont(new Font("Relaway", Font.PLAIN, 30));
        textField.setBounds(180, 190, 310, 30);
        textField.setForeground(Color.black);
        textField.setBorder(new BevelBorder(BevelBorder.LOWERED));
        imagelabel.add(textField);

        // Deposite Button
        depositButton = new JButton();
        depositButton = new JButton("DEPOSIT");
        depositButton.setFont(new Font("Relaway", Font.PLAIN, 20));
        depositButton.setBackground(Color.lightGray);
        depositButton.setForeground(Color.black);
        depositButton.setBorder(new BevelBorder(BevelBorder.LOWERED));
        depositButton.setBounds(180, 330, 190, 30);
        depositButton.addActionListener(this);
        imagelabel.add(depositButton);

        // Back Button
        backButton = new JButton();
        backButton = new JButton("BACK");
        backButton.setFont(new Font("Relaway", Font.PLAIN, 20));
        backButton.setBackground(Color.lightGray);
        backButton.setForeground(Color.black);
        backButton.setBorder(new BevelBorder(BevelBorder.LOWERED));
        backButton.setBounds(430, 330, 190, 30);
        backButton.addActionListener(this);
        imagelabel.add(backButton);

        setSize(800, 700);
        setLocation(350, 50);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource() == depositButton) {

            String amountnoString = textField.getText();
            Date dateString = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = format.format(dateString);
            if (amountnoString.equals("")) {
                JOptionPane.showMessageDialog(null, "Amount Box is Empty");
            } else {
                try {
                    ConnectionManager connection = new ConnectionManager();
                    String quarySting = "insert into Transaction_Table values ('" + cardNO + "','" + pinNO + "','"
                            + formattedDate + "','Deposited','" + amountnoString + "')";
                    connection.statement.executeUpdate(quarySting);
                    JOptionPane.showMessageDialog(null, "Money is Credited Successfully");
                    setVisible(false);
                    new MoneyTranction(pinNO, bankString, cardNO).setVisible(true);

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if (ac.getSource() == backButton) {
            setVisible(false);
            new MoneyTranction(pinNO, bankString, cardNO).setVisible(true);
        }
    }

    // public static void main(String[] args) {
    //     new CashDeposite("","","");
    // }

}
