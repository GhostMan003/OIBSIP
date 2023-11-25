package ATM.Interface.System;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame{
    
    private JLabel miniLabel,banknameLabel,cardLabel;

    MiniStatement(String pinNO,String bankString,String cardNO) {

        setTitle("Mini Statement");
        setLayout(null);

        //Bank Name
        banknameLabel = new JLabel(bankString);
        banknameLabel.setFont(new Font("osward", Font.BOLD,25));
        banknameLabel.setBounds(160,20,300,30);
        add(banknameLabel);

        //card number Label
        cardLabel = new JLabel();
        cardLabel.setFont(new Font("osward",Font.TYPE1_FONT,20));
        cardLabel.setBounds(30,80,500,20);
        add(cardLabel);

        //Statement 
        miniLabel = new JLabel();

        try {
            ConnectionManager con = new ConnectionManager();
            ResultSet rs = con.statement.executeQuery(("select * from Log_In where Card_Number = '"+cardNO+"'"));
            while (rs.next()) {
                cardLabel.setText("Card Number: "+"XXXX-XXXX-XXXX-"+rs.getString("Card_Number").substring(11));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        try {
            ConnectionManager con = new ConnectionManager();
            ResultSet rs = con.statement.executeQuery("select * from Transaction_Table where Card_Number = '"+cardNO+"' order by DATE DESC limit 5");
            int i = 5;
            while (rs.next() && 0<i) {
                miniLabel.setText(miniLabel.getText()+"<html>"+rs.getString("DATE")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Amount")+"<br><br>"+"<html>");
                i--;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        miniLabel.setFont(new Font("Arial",Font.BOLD,15));
        miniLabel.setBounds(30,70,400,300);
        add(miniLabel);


        setSize(500,400);
        setLocation(150, 40);
        getContentPane().setBackground(new Color(241,241,245));
        setVisible(true);

    }
}
