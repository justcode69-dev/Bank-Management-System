package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener {

    long random;
    JTextField nameTextField, fnameTextField, emailTextField, PnumberTextField ,addressTextField, cityTextField, stateTextField, pinTextField;
    JButton next;
    JRadioButton male, female, other, married, unmarried, Others;
    JDateChooser dateChooser;

    SignUpOne() {

        setTitle("SIGN UP - PAGE 1");
        setSize(1000, 700);
        setLocation(150, 10);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

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

        Random ran = new Random();
        random = (Math.abs(ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Railway", Font.BOLD, 30));
        formno.setForeground(Color.WHITE);
        formno.setBounds(250, 10, 600, 40);
        bgPanel.add(formno);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Railway", Font.BOLD, 22));
        personalDetails.setForeground(Color.WHITE);
        personalDetails.setBounds(350, 50, 400, 30);
        bgPanel.add(personalDetails);

        // The rest of your labels and fields (same as you wrote)
        // Just replace 'add(component);' with 'bgPanel.add(component);'
        // Also set foreground colors to white if needed for visibility

        JLabel name = new JLabel("NAME:");
        name.setFont(new Font("Railway", Font.BOLD, 16));
        name.setForeground(Color.WHITE);
        name.setBounds(100, 140, 100, 30);
        bgPanel.add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Railway", Font.BOLD, 16));
        nameTextField.setBounds(300, 140, 300, 30);
        bgPanel.add(nameTextField);


        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Railway", Font.BOLD, 16));
        fname.setForeground(Color.WHITE);
        fname.setBounds(100, 180, 200, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Railway", Font.BOLD, 16));
        fnameTextField.setBounds(300, 180, 300, 30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Railway", Font.BOLD, 16));
        dob.setForeground(Color.WHITE);
        dob.setBounds(100, 220, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 220, 300, 30);
        dateChooser.setBackground(Color.WHITE);
        add(dateChooser);


        JLabel PNumber = new JLabel("Contact Number:");
        PNumber.setFont(new Font("Railway", Font.BOLD, 16));
        PNumber.setForeground(Color.WHITE);
        PNumber.setBounds(100, 260, 150, 30);
        add(PNumber);

        PnumberTextField = new JTextField();
        PnumberTextField.setFont(new Font("Railway", Font.BOLD, 16));
        PnumberTextField.setBounds(300, 260, 300, 30);
        add(PnumberTextField);

        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Railway", Font.BOLD, 16));
        email.setForeground(Color.WHITE);
        email.setBounds(100, 300, 100, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Railway", Font.BOLD, 16));
        emailTextField.setBounds(300, 300, 300, 30);
        add(emailTextField);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Railway", Font.BOLD, 16));
        gender.setForeground(Color.WHITE);
        gender.setBounds(100, 340, 100, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 340, 95, 30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(400, 340, 95, 30);
        female.setBackground(Color.white);
        add(female);

        other = new JRadioButton("Others");
        other.setBounds(500, 340, 100, 30);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Railway", Font.BOLD, 16));
        marital.setForeground(Color.WHITE);
        marital.setBounds(100, 380, 200, 30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 380, 95, 30);
        married.setBackground(Color.white);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400, 380, 95, 30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        Others = new JRadioButton("Others");
        Others.setBounds(500, 380, 100, 30);
        Others.setBackground(Color.white);
        add(Others);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(Others);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Railway", Font.BOLD, 16));
        address.setForeground(Color.WHITE);
        address.setBounds(100, 420, 200, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Railway", Font.BOLD, 16));
        addressTextField.setBounds(300, 420, 300, 30);
        add(addressTextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Railway", Font.BOLD, 16));
        city.setForeground(Color.WHITE);
        city.setBounds(100, 460, 200, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Railway", Font.BOLD, 16));
        cityTextField.setBounds(300, 460, 300, 30);
        add(cityTextField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Railway", Font.BOLD, 16));
        state.setForeground(Color.WHITE);
        state.setBounds(100, 500, 200, 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Railway", Font.BOLD, 16));
        stateTextField.setBounds(300, 500, 300, 30);
        add(stateTextField);

        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Railway", Font.BOLD, 16));
        pincode.setForeground(Color.WHITE);
        pincode.setBounds(100, 540, 200, 30);
        add(pincode);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Railway", Font.BOLD, 16));
        pinTextField.setBounds(300, 540, 300, 30);
        add(pinTextField);


        next = new JButton("Next");
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Railway", Font.BOLD, 14));
        next.setBounds(620, 580, 80, 30);
        next.addActionListener(this);
        bgPanel.add(next);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

        String gender = null;
        if (male.isSelected()) gender = "Male";
        else if (female.isSelected()) gender = "Female";
        else if (other.isSelected()) gender = "Other";

        String email = emailTextField.getText();

        String marital = null;
        if (married.isSelected()) marital = "Married";
        else if (unmarried.isSelected()) marital = "Unmarried";
        else if (Others.isSelected()) marital = "Other";

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        String Pnumber = PnumberTextField.getText();


        try {
            if (name.equals("") || fname.equals("") || dob.equals("") || Pnumber.equals("") || email.equals("") || address.equals("") || city.equals("") || state.equals("") || pin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
            } else {
                Conn c = new Conn();
                String query = "INSERT INTO signingup(formno, name, father_name, dob, gender, contact_number, email, marital, address, city, state, pin) VALUES('" + formno + "', '" + name + "', '" + fname + "', '" + dob + "', '" + gender + "','" + Pnumber + "', '" + email + "', '" + marital + "', '" + address + "', '" + city + "', '" + state + "', '" + pin + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Form Submitted Successfully");

                setVisible(false);
                new SignUpTwo(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void main(String[] args) {
        new SignUpOne();
    }
}
