package ATM.Interface.System;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

public class E_Statement extends JFrame {

    private JLabel maxLabel, banknameLabel, cardLabel;

    public E_Statement(String pinNO, String bankString, String cardNO) {

        setTitle("Mini Statement");
        setLayout(null);

        // Bank Name
        banknameLabel = new JLabel(bankString);
        banknameLabel.setFont(new Font("osward", Font.BOLD, 25));
        banknameLabel.setBounds(160, 20, 300, 30);
        add(banknameLabel);

        // card number Label
        cardLabel = new JLabel();
        cardLabel.setFont(new Font("osward", Font.TYPE1_FONT, 15));
        cardLabel.setBounds(30, 80, 500, 15);
        add(cardLabel);

        // Statement
        maxLabel = new JLabel();

        try {
            ConnectionManager con = new ConnectionManager();
            ResultSet rs = con.statement.executeQuery(
                    ("select * from Log_In where Card_Number = '" + cardNO + "' and PIN_NO = '" + pinNO + "'"));// "+pinNO+"
            while (rs.next()) {
                cardLabel.setText("Card Number: " + "XXXX-XXXX-XXXX-" + rs.getString("Card_Number").substring(11));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            ConnectionManager con = new ConnectionManager();
            ResultSet rs = con.statement.executeQuery("select * from Transaction_Table where Card_Number = '" + cardNO
                    + "' and PIN_NO = '" + pinNO + "' order by DATE DESC limit 10");//
            int i = 10;
            while (rs.next() && 0 < i) {
                maxLabel.setText(maxLabel.getText() + "<html>" + rs.getString("DATE") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + rs.getString("Type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + rs.getString("Amount") + "<br><br>" + "<html>");
                i--;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        maxLabel.setFont(new Font("Arial", Font.BOLD, 15));
        maxLabel.setBounds(30, 0, 500, 600);
        add(maxLabel);

        setSize(500, 600);
        setLocation(150, 40);
        getContentPane().setBackground(new Color(241, 241, 245));
        setVisible(true);
    }

}
