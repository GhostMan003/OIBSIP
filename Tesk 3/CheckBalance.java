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

import java.sql.ResultSet;

public class CheckBalance extends JFrame implements ActionListener {

    private JLabel imageLabel, balanceLabel;
    private JButton backButton;
    private final String pinNO, bankString, cardNO;

    public CheckBalance(String pinNO, String bankString, String cardNO) {

        this.pinNO = pinNO;
        this.bankString = bankString;
        this.cardNO = cardNO;
        setLayout(null);

        // import ATM interface image
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Icon/Interface1.jpg"));
        Image image2 = image1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        imageLabel = new JLabel(image3);
        imageLabel.setBounds(0, 0, 800, 700);
        add(imageLabel);

        ConnectionManager conn = new ConnectionManager();
        int balance = 0;

        try {
            ResultSet rs = conn.statement.executeQuery("SELECT * FROM Transaction_Table WHERE Card_Number = '" + cardNO
                    + "' AND PIN_NO = '" + pinNO + "' ");

            while (rs.next()) {
                if (rs.getString("Type").equals("Deposited")) {
                    balance += Integer.parseInt(rs.getString("Amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("Amount"));
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        // Balance Label
        balanceLabel = new JLabel("Your Balance: " + balance);
        balanceLabel.setFont(new Font("serif", Font.BOLD, 20));
        balanceLabel.setForeground(Color.white);
        balanceLabel.setBounds(230, 150, 800, 30);
        imageLabel.add(balanceLabel);

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
        setVisible(false);
        new MoneyTranction(pinNO, bankString, cardNO).setVisible(true);
    }

}
