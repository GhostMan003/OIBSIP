package ATM.Interface.System;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.ResultSet;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CashFast extends JFrame implements ActionListener {

    private JLabel imagelabel, textlabel;
    private JButton rs100Button, rs200Button, rs500Button, rs1000Button, rs2000Button, rs5000Button, rs10000Button,
            backButton;
    private final String pinNO, bankString, cardNO;

    public CashFast(String PIN_NO, String bankString, String cardNO) {

        this.pinNO = PIN_NO;
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
        textlabel = new JLabel("Select Withdrawl Amount");
        textlabel.setFont(new Font("serif", Font.PLAIN, 20));
        textlabel.setBounds(180, 145, 800, 25);
        textlabel.setForeground(Color.white);
        imagelabel.add(textlabel);

        // Left side Buttons
        // Rs 100 Button
        rs100Button = new JButton("Rs. 100");
        rs100Button.setFont(new Font("Relaway", Font.PLAIN, 20));
        rs100Button.setBackground(Color.lightGray);
        rs100Button.setForeground(Color.black);
        rs100Button.setBorder(new BevelBorder(BevelBorder.LOWERED));
        rs100Button.setBounds(180, 220, 180, 30);
        rs100Button.addActionListener(this);
        imagelabel.add(rs100Button);
        // Rs 200 Button
        rs200Button = new JButton("Rs. 200");
        rs200Button.setFont(new Font("Relaway", Font.PLAIN, 20));
        rs200Button.setBackground(Color.lightGray);
        rs200Button.setForeground(Color.black);
        rs200Button.setBorder(new BevelBorder(BevelBorder.LOWERED));
        rs200Button.setBounds(180, 260, 180, 30);
        rs200Button.addActionListener(this);
        imagelabel.add(rs200Button);
        // Rs 500 Button
        rs500Button = new JButton("Rs. 500");
        rs500Button.setFont(new Font("Relaway", Font.PLAIN, 20));
        rs500Button.setBackground(Color.lightGray);
        rs500Button.setForeground(Color.black);
        rs500Button.setBorder(new BevelBorder(BevelBorder.LOWERED));
        rs500Button.setBounds(180, 300, 180, 30);
        rs500Button.addActionListener(this);
        imagelabel.add(rs500Button);
        // Rs 1000 Button
        rs1000Button = new JButton("Rs. 1000");
        rs1000Button.setFont(new Font("Relaway", Font.PLAIN, 20));
        rs1000Button.setBackground(Color.lightGray);
        rs1000Button.setForeground(Color.black);
        rs1000Button.setBorder(new BevelBorder(BevelBorder.LOWERED));
        rs1000Button.setBounds(180, 340, 180, 30);
        rs1000Button.addActionListener(this);
        imagelabel.add(rs1000Button);

        // Right side Buttons
        // Rs 2000 Button
        rs2000Button = new JButton("Rs. 2000");
        rs2000Button.setFont(new Font("Relaway", Font.PLAIN, 20));
        rs2000Button.setBackground(Color.lightGray);
        rs2000Button.setForeground(Color.black);
        rs2000Button.setBorder(new BevelBorder(BevelBorder.LOWERED));
        rs2000Button.setBounds(430, 220, 190, 30);
        rs2000Button.addActionListener(this);
        imagelabel.add(rs2000Button);
        // Rs 5000 Button
        rs5000Button = new JButton("Rs. 5000");
        rs5000Button.setFont(new Font("Relaway", Font.PLAIN, 20));
        rs5000Button.setBackground(Color.lightGray);
        rs5000Button.setForeground(Color.black);
        rs5000Button.setBorder(new BevelBorder(BevelBorder.LOWERED));
        rs5000Button.setBounds(430, 260, 190, 30);
        rs5000Button.addActionListener(this);
        imagelabel.add(rs5000Button);
        // Rs 10000 check Button
        rs10000Button = new JButton("Rs. 10000");
        rs10000Button.setFont(new Font("Relaway", Font.PLAIN, 20));
        rs10000Button.setBackground(Color.lightGray);
        rs10000Button.setForeground(Color.black);
        rs10000Button.setBorder(new BevelBorder(BevelBorder.LOWERED));
        rs10000Button.setBounds(430, 300, 190, 30);
        rs10000Button.addActionListener(this);
        imagelabel.add(rs10000Button);
        // Back Button
        backButton = new JButton("BACK");
        backButton.setFont(new Font("Relaway", Font.PLAIN, 20));
        backButton.setBackground(Color.lightGray);
        backButton.setForeground(Color.black);
        backButton.setBorder(new BevelBorder(BevelBorder.LOWERED));
        backButton.setBounds(430, 340, 190, 30);
        backButton.addActionListener(this);
        imagelabel.add(backButton);

        setSize(800, 700);
        setLocation(350, 50);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource() == backButton) {
            setVisible(false);
            new MoneyTranction(pinNO, bankString, cardNO).setVisible(true);
            ;
        } else {
            String amountString = ((JButton) ac.getSource()).getText().substring(4);
            try {
                ConnectionManager conn = new ConnectionManager();
                ResultSet rs = conn.statement.executeQuery("SELECT * FROM Transaction_Table WHERE Card_Number = '"
                        + cardNO + "'AND PIN_NO = '" + pinNO + "' ");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("Type").equals("Deposited")) {
                        balance += Integer.parseInt(rs.getString("Amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("Amount"));
                    }
                }

                if (ac.getSource() != backButton && balance < Integer.parseInt(amountString)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date dateString = new Date();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = format.format(dateString);
                String quaryString = "insert into Transaction_Table values('" + cardNO + "','" + pinNO + "','"
                        + formattedDate + "','Withdrawl','" + amountString + "')";
                conn.statement.executeUpdate(quaryString);
                JOptionPane.showMessageDialog(null, "Rs " + amountString + " Withdrawl Successfully "
                        + "\nYour Current Balance: " + (balance - (Integer.parseInt(amountString))));

                setVisible(false);
                new MoneyTranction(pinNO, bankString, cardNO).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

}
