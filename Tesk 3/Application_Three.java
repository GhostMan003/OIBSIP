package ATM.Interface.System;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.Random;

public class Application_Three extends JFrame implements ActionListener {

    private JLabel fromNO, detailstext, acTypetext, cardtext, carddetails, cardNo, pintext, pindetails, pinNo,
            servicestext;
    private JRadioButton saving, fixed, current, recurring;
    private ButtonGroup typegroup;
    private JCheckBox cardservice, internetbanking, mobilebanking, alerts, cheqbook, estatement, tremCheckBox;
    private JButton submit, cancel;
    private String fromNoString;
    private final Random random = new Random();
    private CardNumber cardNO = new CardNumber();
    private final String pinnumber = "" + Math.abs((random.nextInt(9000)) + 1000);

    public Application_Three(String fromNo_String) {
        this.fromNoString = fromNo_String;
        setLayout(null);
        setTitle("Third Application From");

        // Application No
        fromNO = new JLabel("From No:" + fromNoString);
        fromNO.setFont(new Font("Arial", Font.BOLD, 15));
        fromNO.setBackground(Color.BLACK);
        fromNO.setBounds(620, 5, 200, 20);
        add(fromNO);

        // Account Details level
        detailstext = new JLabel("Fill Account Details");
        detailstext.setFont(new Font("Osward", Font.BOLD, 30));
        detailstext.setBounds(240, 30, 600, 30);
        add(detailstext);

        // Account Type text
        acTypetext = new JLabel("Account Type: ");
        acTypetext.setFont(new Font("Osward", Font.TRUETYPE_FONT, 20));
        acTypetext.setBounds(80, 140, 400, 40);
        add(acTypetext);

        // Radio buttons
        saving = new JRadioButton("Saving Account");
        saving.setFont(new Font("Raleway", Font.PLAIN, 15));
        saving.setBackground(new Color(241, 241, 245));
        saving.setBounds(300, 150, 150, 25);
        add(saving);
        recurring = new JRadioButton("Recuring Deposit Account");
        recurring.setFont(new Font("Raleway", Font.PLAIN, 15));
        recurring.setBackground(new Color(241, 241, 245));
        recurring.setBounds(500, 150, 250, 25);
        add(recurring);
        fixed = new JRadioButton("Fixed Deposit Account");
        fixed.setFont(new Font("Raleway", Font.PLAIN, 15));
        fixed.setBackground(new Color(241, 241, 245));
        fixed.setBounds(300, 200, 200, 25);
        add(fixed);
        current = new JRadioButton("Current Account");
        current.setFont(new Font("Raleway", Font.PLAIN, 15));
        current.setBackground(new Color(241, 241, 245));
        current.setBounds(500, 200, 150, 25);
        add(current);

        // Radio buttons Group
        typegroup = new ButtonGroup();
        typegroup.add(saving);
        typegroup.add(recurring);
        typegroup.add(fixed);
        typegroup.add(current);

        // card no text
        cardtext = new JLabel("CARD NO: ");
        cardtext.setFont(new Font("Osward", Font.TRUETYPE_FONT, 20));
        cardtext.setBounds(80, 250, 400, 40);
        add(cardtext);
        carddetails = new JLabel("(Your 16-digit card number will be displayed on the ATM card)");
        carddetails.setFont(new Font("Osward", Font.BOLD, 10));
        carddetails.setBounds(310, 290, 400, 15);
        add(carddetails);
        // card demo number
        cardNo = new JLabel("XXXX-XXXX-XXXX-" + cardNO.F4digit);
        cardNo.setFont(new Font("Osward", Font.PLAIN, 20));
        cardNo.setBounds(310, 250, 400, 40);
        add(cardNo);

        // pin no text
        pintext = new JLabel("PIN: ");
        pintext.setFont(new Font("Osward", Font.TRUETYPE_FONT, 20));
        pintext.setBounds(80, 320, 400, 40);
        add(pintext);
        pindetails = new JLabel("(4-digit Passward)");
        pindetails.setFont(new Font("Osward", Font.BOLD, 10));
        pindetails.setBounds(310, 360, 400, 15);
        add(pindetails);
        // pin demo number
        pinNo = new JLabel("XXXX");
        pinNo.setFont(new Font("Osward", Font.PLAIN, 20));
        pinNo.setBounds(310, 320, 400, 40);
        add(pinNo);

        // services text
        servicestext = new JLabel("Services Required: ");
        servicestext.setFont(new Font("Osward", Font.TRUETYPE_FONT, 20));
        servicestext.setBounds(80, 385, 400, 40);
        add(servicestext);

        cardservice = new JCheckBox("ATM CARD SERVICE");
        cardservice.setFont(new Font("Raleway", Font.PLAIN, 15));
        cardservice.setBackground(new Color(241, 241, 245));
        cardservice.setBounds(300, 390, 200, 25);
        add(cardservice);
        internetbanking = new JCheckBox("Interner Banking");
        internetbanking.setFont(new Font("Raleway", Font.PLAIN, 15));
        internetbanking.setBackground(new Color(241, 241, 245));
        internetbanking.setBounds(500, 390, 250, 25);
        add(internetbanking);
        mobilebanking = new JCheckBox("Mobile Banking");
        mobilebanking.setFont(new Font("Raleway", Font.PLAIN, 15));
        mobilebanking.setBackground(new Color(241, 241, 245));
        mobilebanking.setBounds(300, 440, 200, 25);
        add(mobilebanking);
        alerts = new JCheckBox("E-MAIL & SMS Alerts");
        alerts.setFont(new Font("Raleway", Font.PLAIN, 15));
        alerts.setBackground(new Color(241, 241, 245));
        alerts.setBounds(500, 440, 200, 25);
        add(alerts);
        cheqbook = new JCheckBox("Cheque Book");
        cheqbook.setFont(new Font("Raleway", Font.PLAIN, 15));
        cheqbook.setBackground(new Color(241, 241, 245));
        cheqbook.setBounds(300, 490, 200, 25);
        add(cheqbook);
        estatement = new JCheckBox("E-Statement");
        estatement.setFont(new Font("Raleway", Font.PLAIN, 15));
        estatement.setBackground(new Color(241, 241, 245));
        estatement.setBounds(500, 490, 150, 25);
        add(estatement);

        // trem agree check box
        tremCheckBox = new JCheckBox(
                "I hereby confirm that, to the best of my knowledge, the information submitted above is accurate.");
        tremCheckBox.setFont(new Font("Osward", Font.TRUETYPE_FONT, 10));
        tremCheckBox.setBackground(new Color(241, 241, 245));
        tremCheckBox.setBounds(200, 555, 600, 15);
        add(tremCheckBox);

        // submit buttom
        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.TRUETYPE_FONT, 20));
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.setBounds(230, 590, 150, 40);
        submit.addActionListener(this);
        add(submit);
        // cancel buttom
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.TRUETYPE_FONT, 20));
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(480, 590, 150, 40);
        cancel.addActionListener(this);
        add(cancel);

        setSize(800, 700);
        setVisible(true);
        setLocation(350, 50);
        getContentPane().setBackground(new Color(241, 241, 245));

    }

    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource() == submit) {
            String accountTypeString = null;
            if (saving.isSelected()) {
                accountTypeString = "Saving Account";
            } else if (current.isSelected()) {
                accountTypeString = "Current Account";
            } else if (fixed.isSelected()) {
                accountTypeString = "Fixed Account";
            } else if (recurring.isSelected()) {
                accountTypeString = "Recurring Account";
            }

            String features = "";
            if (cardservice.isSelected()) {
                features = "ATM CARD/" + features;
            }
            if (internetbanking.isSelected()) {
                features = "Internet Banking/" + features;
            }
            if (mobilebanking.isSelected()) {
                features = "Mobile Banking/" + features;
            }
            if (alerts.isSelected()) {
                features = "E-MAIL and SMS Alerts/" + features;
            }
            if (cheqbook.isSelected()) {
                features = "Cheque Book/" + features;
            }
            if (estatement.isSelected()) {
                features = "E-Statement/" + features;
            }

            try {
                if (typegroup.isSelected(null)) {
                    JOptionPane.showMessageDialog(null, "Please choose any one Account Type");
                } else if (features.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please choose at least one Feature");
                } else if (tremCheckBox.isSelected() == false) {
                    JOptionPane.showMessageDialog(null, "You Forget a Check Box");
                } else {
                    ConnectionManager connection = new ConnectionManager();
                    String query1_String = "INSERT INTO Application_Three VALUES ('" + fromNoString + "','"
                            + accountTypeString + "', '" + cardNO.number + "', '" + pinnumber + "', '" + features
                            + "')";
                    String query2_String = "INSERT INTO Log_In VALUES ('" + fromNoString + "','" + cardNO.number
                            + "', '" + pinnumber + "')";
                    connection.statement.executeUpdate(query1_String);
                    connection.statement.executeUpdate(query2_String);

                    JOptionPane.showMessageDialog(null, "Card NUmber: " + cardNO.number + "\nPIN: " + pinnumber);

                    setVisible(false);
                    new CashDeposite(pinnumber, "", cardNO.number).setVisible(true);
                }

            } catch (Exception e) {

                e.getStackTrace();
            }

        } else if (ac.getSource() == cancel) {
            //If click cancel then this command will delete all details you have entered.
            try {
                 ConnectionManager connectionManager = new ConnectionManager();
                 String quary1_del = "delete from Application_One where From_NO =
                 '"+fromNoString+"')";
                 String quary2_del = "delete from Application_Two where From_NO =
                 '"+fromNoString+"')";
                 connectionManager.statement.executeUpdate(quary1_del);
                 connectionManager.statement.executeUpdate(quary2_del);

                setVisible(false);
                new Log_in().setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

}
