package ATM.Interface.System;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Application_Two extends JFrame implements ActionListener {
    private JTextField aadhartext, pantext;
    private JLabel fromnotext, textLebel, religionLabel, castLabel, incometLabel, educationLebel, occupationLabel,
            panLabel, aadharLabel;
    private JButton next;
    private JComboBox comboreligion, combocatagory, combojob, comboincome, comboeducaton;
    private final String fromNoString;

    public Application_Two(String fromNo_String) {

        this.fromNoString = fromNo_String;
        setLayout(null);
        setTitle("Second Application From");

        // Application No
        fromnotext = new JLabel("From No:" + fromNoString);
        fromnotext.setFont(new Font("Arial", Font.BOLD, 15));
        fromnotext.setBounds(620, 5, 200, 20);
        add(fromnotext);

        // Details Label
        textLebel = new JLabel("Fill Additonal Details");
        textLebel.setFont(new Font("Osward", Font.BOLD, 30));
        textLebel.setBounds(210, 30, 600, 30);
        add(textLebel);

        // Religion lebel Details
        religionLabel = new JLabel("Religion: ");
        religionLabel.setFont(new Font("Osward", Font.TRUETYPE_FONT, 20));
        religionLabel.setBounds(80, 140, 400, 40);
        add(religionLabel);
        // combo box for religion
        String valrelString[] = { "Other", "Hindu", "Muslim", "Christian" };
        comboreligion = new JComboBox(valrelString);
        comboreligion.setForeground(Color.black);
        comboreligion.setBorder(new BevelBorder(BevelBorder.LOWERED));
        comboreligion.setBounds(250, 148, 350, 30);
        add(comboreligion);

        // catagory Details
        castLabel = new JLabel("Catagory: ");
        castLabel.setFont(new Font("Osward", Font.TRUETYPE_FONT, 20));
        castLabel.setBounds(80, 190, 400, 40);
        add(castLabel);
        // combo box for catagory
        String valcast[] = { "Other", "General", "OBC", "SC", "ST" };
        combocatagory = new JComboBox(valcast);
        combocatagory.setForeground(Color.black);
        combocatagory.setBorder(new BevelBorder(BevelBorder.LOWERED));
        combocatagory.setBounds(250, 198, 350, 30);
        add(combocatagory);

        // occupation Details
        occupationLabel = new JLabel("Occupation: ");
        occupationLabel.setFont(new Font("Osward", Font.TRUETYPE_FONT, 20));
        occupationLabel.setBounds(80, 240, 400, 40);
        add(occupationLabel);
        // combo box for occupation
        String valjob[] = { "Other", "Salaried", "Self-Employed", "Business", "Student" };
        combojob = new JComboBox(valjob);
        combojob.setForeground(Color.black);
        combojob.setBorder(new BevelBorder(BevelBorder.LOWERED));
        combojob.setBounds(250, 245, 350, 30);
        add(combojob);

        // Income Details
        incometLabel = new JLabel("Income: ");
        incometLabel.setFont(new Font("Osward", Font.TRUETYPE_FONT, 20));
        incometLabel.setBounds(80, 290, 400, 40);
        add(incometLabel);
        // combo box for income
        String valincome[] = { "None", "< 1,50,000", "< 2,50,000", "< 5,00,000", "< 7,00,000", "> 10,00,000" };
        comboincome = new JComboBox(valincome);
        comboincome.setForeground(Color.black);
        comboincome.setBorder(new BevelBorder(BevelBorder.LOWERED));
        comboincome.setBounds(250, 295, 350, 30);
        add(comboincome);

        // Education Qualification Details
        educationLebel = new JLabel("Educational ");
        educationLebel.setFont(new Font("Osward", Font.TRUETYPE_FONT, 20));
        educationLebel.setBounds(80, 340, 400, 40);
        add(educationLebel);
        educationLebel = new JLabel("Qualification: ");
        educationLebel.setFont(new Font("Osward", Font.TRUETYPE_FONT, 20));
        educationLebel.setBounds(80, 362, 400, 40);
        add(educationLebel);
        // Education combo box
        String valeducaton[] = { "Other", "Secondary", "High-Secondary", "Under-Graduation", "Post-Graducation",
                "P.H.D" };
        comboeducaton = new JComboBox(valeducaton);
        comboeducaton.setForeground(Color.black);
        comboeducaton.setBorder(new BevelBorder(BevelBorder.LOWERED));
        comboeducaton.setBounds(250, 368, 350, 30);
        add(comboeducaton);

        // pan number Details
        panLabel = new JLabel("PAN Number: ");
        panLabel.setFont(new Font("Osward", Font.TRUETYPE_FONT, 20));
        panLabel.setBounds(80, 410, 400, 40);
        add(panLabel);
        // pan text field
        pantext = new JTextField();
        pantext.setBorder(new BevelBorder(BevelBorder.LOWERED));
        pantext.setFont(new Font("Raleway", Font.PLAIN, 19));
        pantext.setBounds(250, 420, 350, 30);
        add(pantext);

        // aadhar number Details
        aadharLabel = new JLabel("Aadhar Number: ");
        aadharLabel.setFont(new Font("Osward", Font.TRUETYPE_FONT, 20));
        aadharLabel.setBounds(80, 460, 400, 40);
        add(aadharLabel);
        // aadhartext field
        aadhartext = new JTextField();
        aadhartext.setBorder(new BevelBorder(BevelBorder.LOWERED));
        aadhartext.setFont(new Font("Raleway", Font.PLAIN, 19));
        aadhartext.setBounds(250, 470, 350, 30);
        add(aadhartext);

        // Next Buttom
        next = new JButton("NEXT");
        next.setFont(new Font("Osward", Font.BOLD, 15));
        next.setBounds(320, 580, 120, 40);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        setSize(800, 700);
        setVisible(true);
        setLocation(350, 50);
        getContentPane().setBackground(new Color(241, 241, 245));

    }

    public void actionPerformed(ActionEvent ac) {
        String religion_String = (String) comboreligion.getSelectedItem();// take text value
        String catagory_String = (String) combocatagory.getSelectedItem();
        String occupation_String = (String) combojob.getSelectedItem();
        String income_String = (String) comboincome.getSelectedItem();
        String study_String = (String) comboeducaton.getSelectedItem();
        String pan_String = pantext.getText();
        String aadhar_String = aadhartext.getText();

        try {
            if (religion_String.equals("Other")) {
                JOptionPane.showMessageDialog(null, "Select Religion");
            } else if (catagory_String.equals("Other")) {
                JOptionPane.showMessageDialog(null, "Select Catagory");
            } else if (occupation_String.equals("Other")) {
                JOptionPane.showMessageDialog(null, "Select Occupation");
            } else if (income_String.equals("None")) {
                JOptionPane.showMessageDialog(null, "Select Income");
            } else if (study_String.equals("Other")) {
                JOptionPane.showMessageDialog(null, "Select Qualification");
            } else if (pan_String.equals("")) {
                JOptionPane.showMessageDialog(null, "Fill PAN No");
            } else if (aadhar_String.equals("")) {
                JOptionPane.showMessageDialog(null, "Fill Aadhar No");
            } else {
                // connect to Database using JDBC connection
                ConnectionManager connectionManager = new ConnectionManager();
                String query_String = "INSERT INTO Application_Two VALUES ('" + fromNoString + "','" + religion_String
                        + "','" + catagory_String + "', '" + occupation_String + "', '" + income_String + "', '"
                        + study_String + "', '" + pan_String + "', '" + aadhar_String + "')";
                connectionManager.statement.executeUpdate(query_String);

                setVisible(false);
                new Application_Three(fromNoString).setVisible(true);
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    // public static void main(String[] args) throws Exception {
    //     new Application_Two("");
    // }
}
