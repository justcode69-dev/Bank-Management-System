package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignUpThree extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7, c8;
    JButton Submit, Cancel;
    String formno;

    SignUpThree(String formno) {
        this.formno = formno;
        setTitle("Account Sign up - Page 3");
        setSize(850, 720);
        setLocation(250, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

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

        // Frosted Glass Panel
        JPanel glass = new JPanel();
        glass.setBounds(50, 20, 730, 650);
        glass.setBackground(new Color(255, 255, 255, 180)); // Semi-transparent white
        glass.setLayout(null);
        bgPanel.add(glass);

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(250, 10, 400, 40);
        glass.add(l1);

        JLabel Type = new JLabel("Account Type");
        Type.setFont(new Font("Raleway", Font.BOLD, 22));
        Type.setBounds(100, 60, 200, 30);
        glass.add(Type);

        r1 = new JRadioButton("Saving Account");
        r2 = new JRadioButton("Fixed Deposit Account");
        r3 = new JRadioButton("Current Account");
        r4 = new JRadioButton("Recurring Deposit Account");

        JRadioButton[] radios = {r1, r2, r3, r4};
        int[] y = {100, 100, 140, 140};
        int[] x = {100, 350, 100, 350};

        ButtonGroup group = new ButtonGroup();
        for (int i = 0; i < radios.length; i++) {
            radios[i].setFont(new Font("Raleway", Font.BOLD, 16));
            radios[i].setBackground(new Color(255, 255, 255, 255));
            radios[i].setBounds(x[i], y[i], 240, 20);
            group.add(radios[i]);
            glass.add(radios[i]);
        }

        JLabel card = new JLabel("Account Number");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 200, 250, 30);
        glass.add(card);

        JLabel cardDetail = new JLabel("YOUR 16 DIGIT ACCOUNT NUMBER.");
        cardDetail.setFont(new Font("Raleway", Font.BOLD, 8));
        cardDetail.setBounds(100, 220, 250, 30);
        glass.add(cardDetail);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-6969");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(300, 200, 250, 30);
        glass.add(number);

        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 270, 250, 30);
        glass.add(pin);

        JLabel pinDetail = new JLabel("YOUR 4 DIGIT PIN NUMBER.");
        pinDetail.setFont(new Font("Raleway", Font.BOLD, 8));
        pinDetail.setBounds(100, 290, 250, 30);
        glass.add(pinDetail);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(300, 270, 250, 30);
        glass.add(pnumber);

        JLabel service = new JLabel("Services Required:");
        service.setFont(new Font("Raleway", Font.BOLD, 22));
        service.setBounds(100, 350, 250, 30);
        glass.add(service);

        c1 = new JCheckBox("ATM CARD");
        c2 = new JCheckBox("INTERNET BANKING");
        c3 = new JCheckBox("MOBILE BANKING");
        c4 = new JCheckBox("EMAIL & SMS SERVICES");
        c5 = new JCheckBox("CHEQUE BOOK");
        c6 = new JCheckBox("E-STATEMENT");
        c7 = new JCheckBox("CREDIT CARD");
        c8 = new JCheckBox("I HEREBY DECLARE THAT THE ABOVE DETAILS ARE CORRECT.");

        JCheckBox[] checks = {c1, c2, c3, c4, c5, c6, c7};
        int[] cx = {100, 100, 100, 100, 400, 400, 400};
        int[] cy = {385, 425, 465, 505, 465, 385, 425};

        for (int i = 0; i < checks.length; i++) {
            checks[i].setFont(new Font("Raleway", Font.BOLD, 16));
            checks[i].setBackground(new Color(255, 255, 255, 180));
            checks[i].setBounds(cx[i], cy[i], 250, 30);
            glass.add(checks[i]);
        }

        c8.setFont(new Font("Raleway", Font.BOLD, 16));
        c8.setBackground(new Color(255, 255, 255, 180));
        c8.setBounds(100, 560, 550, 30);
        glass.add(c8);

        Submit = new JButton("Submit");
        Submit.setBounds(100, 610, 100, 30);
        Submit.setFont(new Font("Raleway", Font.BOLD, 14));
        Submit.setBackground(Color.WHITE);
        Submit.setForeground(Color.BLACK);
        Submit.addActionListener(this);
        glass.add(Submit);

        Cancel = new JButton("Cancel");
        Cancel.setBounds(400, 610, 100, 30);
        Cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        Cancel.setBackground(Color.WHITE);
        Cancel.setForeground(Color.BLACK);
        Cancel.addActionListener(this);
        glass.add(Cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Submit) {
            String accountType = null;
            if (r1.isSelected()) accountType = "Saving Account";
            else if (r2.isSelected()) accountType = "Fixed Deposit Account";
            else if (r3.isSelected()) accountType = "Current Account";
            else if (r4.isSelected()) accountType = "Recurring Deposit Account";

            if (accountType == null) {
                JOptionPane.showMessageDialog(null, "Account Type is Required");
                return;
            }

            if (!c8.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please confirm the declaration.");
                return;
            }

            Random random = new Random();
            String cardnumber = "" + (Math.abs(random.nextLong() % 90000000L) + 5040936000000000L);
            String pinNumber = "" + (Math.abs(random.nextLong() % 9000L) + 1000L);

            StringBuilder facility = new StringBuilder();
            if (c1.isSelected()) facility.append("ATM CARD, ");
            if (c2.isSelected()) facility.append("INTERNET BANKING, ");
            if (c3.isSelected()) facility.append("MOBILE BANKING, ");
            if (c4.isSelected()) facility.append("EMAIL & SMS SERVICES, ");
            if (c5.isSelected()) facility.append("CHEQUE BOOK, ");
            if (c6.isSelected()) facility.append("E-STATEMENT, ");
            if (c7.isSelected()) facility.append("CREDIT CARD");

            try {
                Conn conn = new Conn();
                String query = "INSERT INTO signupthree VALUES('" + formno + "', '" + accountType + "', '" + cardnumber + "', '" + pinNumber + "', '" + facility + "', 'Active')";

                conn.s.executeUpdate(query);

                String loginQuery = "INSERT INTO login VALUES('" + formno + "', '" + cardnumber + "', '" + pinNumber + "')";
                conn.s.executeUpdate(loginQuery);

                JOptionPane.showMessageDialog(null, "Account Number: " + cardnumber + "\nPIN: " + pinNumber);
                setVisible(false);
                new Deposit(pinNumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == Cancel) {
            setVisible(false);
            new LogIn().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignUpThree("");
    }
}
