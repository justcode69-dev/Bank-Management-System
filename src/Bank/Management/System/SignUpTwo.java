package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener {

    long random;
    JTextField panTextField, aadhar_noTextField;
    JButton next;
    JRadioButton senior_citizen_yes, senior_citizen_no, account_yes, account_no;
    JComboBox religion, category, income, education, occupation;
    String formno;

    SignUpTwo(String formno) {
        this.formno = formno;

        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        // Load Background Image
        ImageIcon bgIcon = new ImageIcon(getClass().getResource("/icons/setback.png"));
        Image bgImage = bgIcon.getImage();

        JPanel bgPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        bgPanel.setLayout(null);
        setContentPane(bgPanel);

//        // Frosted Glass Panel
//        JPanel glass = new JPanel();
//        glass.setBounds(50, 20, 730, 730);
//        glass.setBackground(new Color(255, 255, 255, 80)); // Semi-transparent white
//        glass.setLayout(null);
//        bgPanel.add(glass);

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Railway", Font.BOLD, 25));
        additionalDetails.setForeground(Color.BLACK);
        additionalDetails.setBounds(350, 50, 400, 30);
        add(additionalDetails);


        JLabel Religion = new JLabel("Religion:");
        Religion.setFont(new Font("Railway", Font.BOLD, 16));
        Religion.setForeground(Color.WHITE);
        Religion.setBounds(100, 140, 100, 30);
        add(Religion);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Others"};
        religion = new JComboBox(valReligion);
        religion.setBackground(Color.WHITE);
        religion.setBounds(300, 140, 300, 30);
        add(religion);


        JLabel Category = new JLabel("Category:");
        Category.setFont(new Font("Railway", Font.BOLD, 16));
        Category.setForeground(Color.WHITE);
        Category.setBounds(100, 180, 200, 30);
        add(Category);

        String valcategory[] = {"General", "OBC", "SC", "ST", "Others"};
        category = new JComboBox(valcategory);
        category.setBackground(Color.WHITE);
        category.setBounds(300, 180, 300, 30);
        add(category);


        JLabel Income = new JLabel("Income:");
        Income.setFont(new Font("Railway", Font.BOLD, 16));
        Income.setForeground(Color.WHITE);
        Income.setBounds(100, 220, 200, 30);
        add(Income);

        String valincome[] = {"NULL", "<200000", "<400000", "<800000", "<1000000", "1500000+"};
        income = new JComboBox(valincome);
        income.setBackground(Color.WHITE);
        income.setBounds(300, 220, 300, 30);
        add(income);


        JLabel Education = new JLabel("Education:");
        Education.setFont(new Font("Railway", Font.BOLD, 16));
        Education.setForeground(Color.WHITE);
        Education.setBounds(100, 260, 103, 30);
        add(Education);

        String valeducation[] = {"NULL", "BELOW 10TH", "10TH PASS", "12TH PASS", "GRADUATE", "POST GRADUATE", "PhD"};
        education = new JComboBox(valeducation);
        education.setBackground(Color.WHITE);
        education.setBounds(300, 260, 300, 30);
        add(education);


        JLabel Occupation = new JLabel("Occupation:");
        Occupation.setFont(new Font("Railway", Font.BOLD, 16));
        Occupation.setForeground(Color.WHITE);
        Occupation.setBounds(100, 300, 200, 30);
        add(Occupation);

        String valoccupation[] = {"Salaried", "Self-Employed", "Business", "Student", "House Wife", "Retired", "Other", "None"};
        occupation = new JComboBox(valoccupation);
        occupation.setBackground(Color.WHITE);
        occupation.setBounds(300, 300, 300, 30);
        add(occupation);


        JLabel pan_number = new JLabel("Pan Number:");
        pan_number.setFont(new Font("Railway", Font.BOLD, 16));
        pan_number.setForeground(Color.WHITE);
        pan_number.setBounds(100, 340, 200, 30);
        add(pan_number);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Railway", Font.BOLD, 16));
        panTextField.setBounds(300, 340, 300, 30);
        add(panTextField);


        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Railway", Font.BOLD, 16));
        aadhar.setForeground(Color.WHITE);
        aadhar.setBounds(100, 380, 200, 30);
        add(aadhar);

        aadhar_noTextField = new JTextField();
        aadhar_noTextField.setFont(new Font("Railway", Font.BOLD, 16));
        aadhar_noTextField.setBounds(300, 380, 300, 30);
        add(aadhar_noTextField);


        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Railway", Font.BOLD, 16));
        senior.setForeground(Color.WHITE);
        senior.setBounds(100, 420, 200, 30);
        add(senior);

        senior_citizen_yes = new JRadioButton("YES");
        senior_citizen_yes.setBounds(300, 420, 100, 30);
        senior_citizen_yes.setBackground(Color.WHITE);
        add(senior_citizen_yes);

        senior_citizen_no = new JRadioButton("NO");
        senior_citizen_no.setBounds(500, 420, 100, 30);
        senior_citizen_no.setBackground(Color.WHITE);
        add(senior_citizen_no);

        ButtonGroup SeniorGroup = new ButtonGroup();
        SeniorGroup.add(senior_citizen_yes);
        SeniorGroup.add(senior_citizen_no);


        JLabel account = new JLabel("Existing Account:");
        account.setFont(new Font("Railway", Font.BOLD, 16));
        account.setForeground(Color.WHITE);
        account.setBounds(100, 460, 200, 30);
        add(account);

        account_yes = new JRadioButton("YES");
        account_yes.setBounds(300, 460, 100, 30);
        account_yes.setBackground(Color.WHITE);
        add(account_yes);

        account_no = new JRadioButton("NO");
        account_no.setBounds(500, 460, 100, 30);
        account_no.setBackground(Color.WHITE);
        add(account_no);

        ButtonGroup AccountGroup = new ButtonGroup();
        AccountGroup.add(account_yes);
        AccountGroup.add(account_no);


        next = new JButton("Next");
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Railway", Font.BOLD, 14));
        next.setBounds(620, 560, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(1000, 700);
        setLocation(150, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();

        String seniorCitizen = senior_citizen_yes.isSelected() ? "YES" : "NO";
        String existingAccount = account_yes.isSelected() ? "YES" : "NO";

        String pan = panTextField.getText();
        String aadhar = aadhar_noTextField.getText();

        try {
            if (pan.equals("") || aadhar.equals("")) {
                JOptionPane.showMessageDialog(null, "PAN and Aadhar must be filled");
            } else {
                Conn c = new Conn();
                String query = "INSERT INTO signuptwo (formno, religion, category, income, education, occupation, pan, aadhar, Senior_Citizen, Existing_Account) VALUES('" +formno+ "' , '" +sreligion + "', '" + scategory + "', '" + sincome + "', '" + seducation + "', '" + soccupation + "', '" + pan + "', '" + aadhar + "', '" + seniorCitizen + "', '" + existingAccount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Saved Successfully");

                setVisible(false);

                 new SignUpThree(formno).setVisible(true); // If you have next page

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignUpTwo("");
    }
}