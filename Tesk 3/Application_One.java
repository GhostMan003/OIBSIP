package ATM.Interface.System;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.toedter.calendar.IDateEditor;
import com.toedter.calendar.JDateChooser;

import java.util.Random;

public class Application_One extends JFrame implements ActionListener {

    private JTextField textField0, textField1, textField2, textField3, textField4, textField5, textField6, textField7;
    private JLabel fromNo1, fromNo2, text0, text1, text2, contact_Label, text3, text4, text5, text6, text7, text8,
            text9;
    private JDateChooser dateChooser;
    private JRadioButton maleButton, femaleButton, othersButton, marriedButton, singleButton;
    private ButtonGroup gendergroup, maritalStatus;
    private JButton nextButton, backButton;
    private Random random = new Random();
    private final Integer ran;

    public Application_One() {

        setLayout(null);
        setTitle("New Account Application From");

        // Application from no Random level
        ran = Math.abs((random.nextInt(90000)) + 10000);
        fromNo1 = new JLabel("APPLICATIOIN NO: " + ran);
        fromNo1.setFont(new Font("Serif", Font.BOLD, 40));
        fromNo1.setBounds(150, 10, 600, 50);
        add(fromNo1);

        // personal Details level
        fromNo2 = new JLabel("Fill Personal Details");
        fromNo2.setFont(new Font("Osward", Font.BOLD, 30));
        fromNo2.setBounds(250, 65, 600, 30);
        add(fromNo2);

        // Name Details
        text0 = new JLabel("Name: ");
        text0.setFont(new Font("Osward", Font.TRUETYPE_FONT, 20));
        text0.setBounds(80, 120, 400, 40);
        add(text0);
        // Name text field
        textField0 = new JTextField();
        textField0.setBorder(new BevelBorder(BevelBorder.LOWERED));
        textField0.setFont(new Font("Raleway", Font.PLAIN, 19));
        textField0.setBounds(250, 126, 350, 30);
        add(textField0);

        // Father's Name Details
        text1 = new JLabel("Father's Name: ");
        text1.setFont(new Font("Osward", Font.TRUETYPE_FONT, 20));
        text1.setBounds(80, 160, 400, 40);
        add(text1);
        // Father's Name text field
        textField1 = new JTextField();
        textField1.setBorder(new BevelBorder(BevelBorder.LOWERED));
        textField1.setFont(new Font("Raleway", Font.PLAIN, 19));
        textField1.setBounds(250, 168, 350, 30);
        add(textField1);

        // Date of Birth Details
        text2 = new JLabel("Date of Birth: ");
        text2.setFont(new Font("Osward", Font.TRUETYPE_FONT, 20));
        text2.setBounds(80, 200, 400, 40);
        add(text2);
        // DOB calender chooser
        dateChooser = new JDateChooser();
        dateChooser.setFont(new Font("Raleway", Font.TRUETYPE_FONT, 17));
        dateChooser.setBounds(250, 210, 150, 30);
        add(dateChooser);

        // Gendar Details
        text3 = new JLabel("Gender: ");
        text3.setFont(new Font("Osward", Font.TRUETYPE_FONT, 20));
        text3.setBounds(80, 240, 400, 40);
        add(text3);
        // Gender Radio Buttons
        maleButton = new JRadioButton("Male");
        maleButton.setBounds(250, 252, 80, 20);
        maleButton.setFont(new Font("Osward", Font.BOLD, 20));
        maleButton.setBackground(new Color(241, 241, 245));
        add(maleButton);
        femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(375, 252, 100, 20);
        femaleButton.setFont(new Font("Osward", Font.BOLD, 20));
        femaleButton.setBackground(new Color(241, 241, 245));
        add(femaleButton);
        othersButton = new JRadioButton("Others");
        othersButton.setBounds(510, 252, 100, 20);
        othersButton.setFont(new Font("Osward", Font.BOLD, 20));
        othersButton.setBackground(new Color(241, 241, 245));
        add(othersButton);
        // choose only one button
        gendergroup = new ButtonGroup();
        gendergroup.add(maleButton);
        gendergroup.add(femaleButton);
        gendergroup.add(othersButton);

        // Email ID Details
        text4 = new JLabel("Email Address: ");
        text4.setFont(new Font("Osward", Font.TRUETYPE_FONT, 20));
        text4.setBounds(80, 280, 400, 40);
        add(text4);
        // Email add text field
        textField2 = new JTextField();
        textField2.setBorder(new BevelBorder(BevelBorder.LOWERED));
        textField2.setFont(new Font("Raleway", Font.PLAIN, 19));
        textField2.setBounds(250, 290, 350, 30);
        add(textField2);

        // Contact number Details
        contact_Label = new JLabel("Contact No: ");
        contact_Label.setFont(new Font("Osward", Font.TRUETYPE_FONT, 20));
        contact_Label.setBounds(80, 320, 400, 40);
        add(contact_Label);
        // contact no text field
        textField3 = new JTextField();
        textField3.setBorder(new BevelBorder(BevelBorder.LOWERED));
        textField3.setFont(new Font("Raleway", Font.PLAIN, 19));
        textField3.setBounds(250, 331, 350, 30);
        add(textField3);

        // Marital Status Details
        text5 = new JLabel("Marital Status: ");
        text5.setFont(new Font("Osward", Font.TRUETYPE_FONT, 20));
        text5.setBounds(80, 360, 400, 40);
        add(text5);
        // Marital Radio Button
        marriedButton = new JRadioButton("Married");
        marriedButton.setBounds(430, 370, 100, 22);
        marriedButton.setFont(new Font("Osward", Font.BOLD, 20));
        marriedButton.setBackground(new Color(241, 241, 245));
        add(marriedButton);
        singleButton = new JRadioButton("Single");
        singleButton.setBounds(280, 370, 140, 25);
        singleButton.setFont(new Font("Osward", Font.BOLD, 20));
        singleButton.setBackground(new Color(241, 241, 245));
        add(singleButton);
        // choose only one button
        maritalStatus = new ButtonGroup();
        maritalStatus.add(marriedButton);
        maritalStatus.add(singleButton);

        // Address Details
        text6 = new JLabel("Address : ");
        text6.setFont(new Font("Osward", Font.TRUETYPE_FONT, 20));
        text6.setBounds(80, 400, 400, 40);
        add(text6);
        // Address text field
        textField4 = new JTextField();
        textField4.setBorder(new BevelBorder(BevelBorder.LOWERED));
        textField4.setFont(new Font("Raleway", Font.PLAIN, 19));
        textField4.setBounds(250, 410, 350, 30);
        add(textField4);

        // City Details
        text7 = new JLabel("City: ");
        text7.setFont(new Font("Osward", Font.TRUETYPE_FONT, 20));
        text7.setBounds(80, 440, 400, 40);
        add(text7);
        // City text field
        textField5 = new JTextField();
        textField5.setBorder(new BevelBorder(BevelBorder.LOWERED));
        textField5.setFont(new Font("Raleway", Font.PLAIN, 19));
        textField5.setBounds(250, 450, 350, 30);
        add(textField5);

        // State Details
        text9 = new JLabel("State: ");
        text9.setFont(new Font("Osward", Font.TRUETYPE_FONT, 20));
        text9.setBounds(80, 485, 400, 40);
        add(text9);
        // State text field
        textField6 = new JTextField();
        textField6.setBorder(new BevelBorder(BevelBorder.LOWERED));
        textField6.setFont(new Font("Raleway", Font.PLAIN, 19));
        textField6.setBounds(250, 495, 350, 30);
        add(textField6);

        // PinCode Details
        text8 = new JLabel("Pin Code: ");
        text8.setFont(new Font("Osward", Font.TRUETYPE_FONT, 20));
        text8.setBounds(80, 525, 400, 40);
        add(text8);
        // Pin Code text field
        textField7 = new JTextField();
        textField7.setBorder(new BevelBorder(BevelBorder.LOWERED));
        textField7.setFont(new Font("Raleway", Font.PLAIN, 19));
        textField7.setBounds(250, 535, 350, 30);
        add(textField7);

        // Next Buttom
        nextButton = new JButton("NEXT");
        nextButton.setFont(new Font("Osward", Font.BOLD, 15));
        nextButton.setBounds(480, 600, 120, 40);
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
        nextButton.addActionListener(this);
        add(nextButton);

        // Back Buttom
        backButton = new JButton("BACK");
        backButton.setFont(new Font("Osward", Font.BOLD, 15));
        backButton.setBounds(250, 600, 120, 40);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);

        getContentPane().setBackground(Color.LIGHT_GRAY);

        setSize(800, 700);
        setLocation(350, 50);// 350,50
        getContentPane().setBackground(new Color(241, 241, 245));
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ac) {
        String fromNo_String = "" + ran;// long to String
        String name_String = textField0.getText();
        String fname_String = textField1.getText();
        String dob_String = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        JTextField dateEditor = (JTextField) dateChooser.getDateEditor();
        ((IDateEditor) dateEditor).setDateFormatString("dd//MM//yyyy");
        dateChooser.updateUI();
        String gender_String = null;
        if (maleButton.isSelected()) {
            gender_String = "Male";
        } else if (femaleButton.isSelected()) {
            gender_String = "Female";
        } else if (othersButton.isSelected()) {
            gender_String = "Other";
        }
        String email_String = textField2.getText();
        String contact_String = textField3.getText();
        String marital_String = null;
        if (marriedButton.isSelected()) {
            marital_String = "Married";
        } else if (singleButton.isSelected()) {
            marital_String = "Single";
        }
        String address_String = textField4.getText();
        String city_String = textField5.getText();
        String state_String = textField6.getText();
        String pin_String = textField7.getText();

        try {
            if (ac.getSource() == backButton) {
                setVisible(false);
                new Log_in().setVisible(true);
            } else if (name_String.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your name");
            } else if (fname_String.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your Father's name");
            } else if (dob_String.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your Date of Birth");
            } else if (gendergroup.isSelected(null)) {
                JOptionPane.showMessageDialog(null, "Please Choose your Gender");
            } else if (email_String.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your Email ID");
            } else if (contact_String.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your Contact No");
            } else if (maritalStatus.isSelected(null)) {
                JOptionPane.showMessageDialog(null, "Please Choose your Marital Status");
            } else if (address_String.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your Address");
            } else if (city_String.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your City");
            } else if (state_String.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your State");
            } else if (pin_String.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your Pin Code");

            } else {
                // connect to Database using JDBC connection
                ConnectionManager connectionManager = new ConnectionManager();
                String query_String = "INSERT INTO Application_One VALUES ('" + fromNo_String + "','" + name_String
                        + "', '" + fname_String + "', '" + dob_String + "', '" + gender_String + "', '" + email_String
                        + "', '" + contact_String + "'  ,'" + marital_String + "', '" + address_String + "', '"
                        + city_String + "', '" + state_String + "', '" + pin_String + "')";
                connectionManager.statement.executeUpdate(query_String);

                setVisible(false);
                new Application_Two(fromNo_String).setVisible(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // public static void main(String[] args) {
    //     new Application_One();
    // }
}