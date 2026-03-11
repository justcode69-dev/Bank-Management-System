package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LogIn extends JFrame implements ActionListener {

    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;

//    JPanel backgroundPanel;

    LogIn() {
        setTitle("BANK SERVER");
        setSize(720, 720);
        setLocation(300, 0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

//        setContentPane(backgroundPanel);
//
//        // Trigger login when Enter is pressed
//        getRootPane().setDefaultButton(login);
//
//        setVisible(true);


        // Background image
        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/icons/setback.png"));
        Image backgroundImage = backgroundIcon.getImage();

        // Panel with background image
        JPanel backgroundPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(null);

        // Frosted panel for inputs and buttons
        JPanel glassPanel = new JPanel();
        glassPanel.setLayout(null);
        glassPanel.setBackground(new Color(0, 0, 0, 80)); // semi-transparent black
        glassPanel.setBounds(150, 200, 420, 300);
        backgroundPanel.add(glassPanel);

        // WELCOME TEXT
        JLabel text = new JLabel("WELCOME TO BANK SERVER");
        text.setFont(new Font("Georgia", Font.BOLD, 30));
        text.setForeground(Color.WHITE);
        text.setBounds(125, 120, 500, 40);
        backgroundPanel.add(text);

        // CARD NO
        JLabel cardNo = new JLabel("Account No:");
        cardNo.setFont(new Font("Railway", Font.BOLD, 22));
        cardNo.setForeground(Color.WHITE);
        cardNo.setBounds(20, 30, 300, 40);
        glassPanel.add(cardNo);

        cardTextField = new JTextField();
        cardTextField.setBounds(160, 35, 220, 30);
        glassPanel.add(cardTextField);

        // PIN
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Railway", Font.BOLD, 22));
        pin.setForeground(Color.WHITE);
        pin.setBounds(20, 90, 300, 40);
        glassPanel.add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(160, 95, 220, 30);
        glassPanel.add(pinTextField);

        // LOGIN BUTTON
        login = new JButton("SIGN IN");
        login.setBounds(50, 160, 300, 35);
        styleButton(login);
        login.addActionListener(this);
        glassPanel.add(login);

        // CLEAR BUTTON
        clear = new JButton("CLEAR");
        clear.setBounds(50, 210, 140, 30);
        styleButton(clear);
        clear.addActionListener(this);
        glassPanel.add(clear);

        // SIGNUP BUTTON
        signup = new JButton("SIGN UP");
        signup.setBounds(210, 210, 140, 30);
        styleButton(signup);
        signup.addActionListener(this);
        glassPanel.add(signup);

        setContentPane(backgroundPanel);
        setVisible(true);
    }

    private void styleButton(JButton button) {
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(66, 0, 131));
        button.setBorder(BorderFactory.createLineBorder(new Color(180, 0, 255)));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignUpOne().setVisible(true);
        } else if (ae.getSource() == login) {
            String cardNumber = cardTextField.getText();
            String pin = pinTextField.getText();

            try {
                Conn c = new Conn();
                String query = "SELECT * FROM login WHERE Card_No = '" + cardNumber + "' AND Pin = '" + pin + "'";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new CustomerAccount(cardNumber, pin);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Card Number or PIN");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new LogIn();
    }
}

