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
import java.sql.ResultSet;

import java.text.SimpleDateFormat;

import java.util.Date;


public class CashWithdrawl extends JFrame implements ActionListener {

    private JLabel imagelabel, textlabel;
    private JTextField textField;
    private JButton withdrawlButton, backButton;
    private final String pinNo, bankString, cardNO;

    public CashWithdrawl(String PinNO, String bankString, String cardNO) {

        this.pinNo = PinNO;
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
        textlabel = new JLabel("Enter Amount You Want to WITHDRAW");
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

        // Withdrawl Button
        withdrawlButton = new JButton();
        withdrawlButton = new JButton("WITHDRAWL");
        withdrawlButton.setFont(new Font("Relaway", Font.PLAIN, 20));
        withdrawlButton.setBackground(Color.lightGray);
        withdrawlButton.setForeground(Color.black);
        withdrawlButton.setBorder(new BevelBorder(BevelBorder.LOWERED));
        withdrawlButton.setBounds(180, 330, 190, 30);
        withdrawlButton.addActionListener(this);
        imagelabel.add(withdrawlButton);

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
        if (ac.getSource() == withdrawlButton) {

            String amountnoString = textField.getText();
            // Date dateString = new Date();
            // SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // String formattedDate = format.format(dateString);
            if (amountnoString.equals("")) {
                JOptionPane.showMessageDialog(null, "Amount Box is Empty");
            } else {
                try {
                    ConnectionManager conn = new ConnectionManager();
                    ResultSet rs = conn.statement.executeQuery("SELECT * FROM Transaction_Table WHERE Card_Number = '"
                            + cardNO + "'AND PIN_NO = '" + pinNo + "' ");
                    int balance = 0;
                    while (rs.next()) {
                        if (rs.getString("Type").equals("Deposited")) {
                            balance += Integer.parseInt(rs.getString("Amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("Amount"));
                        }
                    }

                    if (ac.getSource() != backButton && balance < Integer.parseInt(amountnoString)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    Date dateString = new Date();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String formattedDate = format.format(dateString);
                    String quaryString = "insert into Transaction_Table values('" + cardNO + "','" + pinNo + "','"
                            + formattedDate + "','Withdrawl','" + amountnoString + "')";
                    conn.statement.executeUpdate(quaryString);
                    JOptionPane.showMessageDialog(null, "Rs " + amountnoString + " Withdrawl Successfully ");

                    setVisible(false);
                    new MoneyTranction(pinNo, bankString, cardNO).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if (ac.getSource() == backButton) {
            setVisible(false);
            new MoneyTranction(pinNo, bankString, cardNO).setVisible(true);
            ;
        }

    }

}
