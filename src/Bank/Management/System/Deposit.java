package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    String pinNumber;
    TextField textField;
    JButton deposit, cancel, exit, clear;

    Deposit(String pinNumber){
        this.pinNumber = pinNumber;

        // ATM background image
        ImageIcon I1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
        Image I2 = I1.getImage().getScaledInstance(720, 720, Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel background = new JLabel(I3);
        background.setBounds(0, 0, 720, 720);
        add(background);

        // Label
        JLabel label1 = new JLabel("Enter Amount You Want To Deposit");
        label1.setFont(new Font("System", Font.BOLD, 22));
        label1.setBounds(100, 180, 400, 35);
        background.add(label1);

        // Amount Input Field
        textField = new TextField();
        textField.setBounds(160, 240, 220, 25);
        textField.setFont(new Font("Raleway", Font.BOLD, 20));
        background.add(textField);

        // Deposit Button
        deposit = new JButton("Deposit");
        deposit.setBounds(130, 334, 100, 23);
        deposit.setFont(new Font("Arial", Font.BOLD, 16));
        deposit.setBackground(Color.WHITE);
        deposit.addActionListener(this);
        background.add(deposit);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(130, 389, 100, 23);
        cancel.setFont(new Font("Arial", Font.BOLD, 16));
        cancel.setBackground(Color.WHITE);
        cancel.addActionListener(this);
        background.add(cancel);

        // Clear Button
        clear = new JButton("Clear");
        clear.setBounds(310, 334, 100, 23);
        clear.setFont(new Font("Arial", Font.BOLD, 16));
        clear.setBackground(Color.WHITE);
        clear.addActionListener(this);  // Action listener added
        background.add(clear);

        // Exit Button
        exit = new JButton("Exit");
        exit.setBounds(310, 389, 100, 23);
        exit.setFont(new Font("Arial", Font.BOLD, 16));
        exit.setBackground(Color.WHITE);
        exit.addActionListener(this);  // Action listener added
        background.add(exit);

        // Frame Settings
        setLayout(null);
        setSize(720, 720);
        setLocation(300, 0);
        setUndecorated(false); // Keep true if no title bar needed
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amount = textField.getText();
            Date date = new Date();

            if (e.getSource() == deposit) {
                if (amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter The Amount You Want To Deposit.");
                } else {
                    Conn conn = new Conn();
                    conn.s.executeUpdate("INSERT INTO deposit VALUES('" + pinNumber + "', '" + date + "', 'Deposit', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Deposited Successfully");
                    setVisible(false);
                }
            } else if (e.getSource() == cancel) {
                setVisible(false);
            } else if (e.getSource() == clear) {
                textField.setText("");  // Clear text field
            } else if (e.getSource() == exit) {
                System.exit(0);  // Close application
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Deposit("");  // For testing
    }
}
