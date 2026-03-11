//package Bank.Management.System;
//
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.*;
//import java.io.FileOutputStream;
//import java.sql.*;
//import java.util.Vector;
//
//public class CustomerAccount extends JFrame {
//    String cardNumber, pin;
//
//    public CustomerAccount(String cardNumber, String pin) {
//        this.cardNumber = cardNumber;
//        this.pin = pin;
//
//        setTitle("Customer Account Overview");
//        setSize(1300, 1000);
//        setLocation(0, 0);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLayout(new BorderLayout());
//
//        JPanel detailsPanel = new JPanel();
//        detailsPanel.setLayout(new GridLayout(0, 2, 10, 5));
//        detailsPanel.setBorder(BorderFactory.createTitledBorder("Customer Details"));
//        detailsPanel.setBackground(new Color(240, 240, 240));
//
//        // Labels for customer details
//        JLabel nameLabel = new JLabel();
//        JLabel fatherLabel = new JLabel();
//        JLabel dobLabel = new JLabel();
//        JLabel genderLabel = new JLabel();
//        JLabel emailLabel = new JLabel();
//        JLabel maritalLabel = new JLabel();
//        JLabel addressLabel = new JLabel();
//        JLabel cityLabel = new JLabel();
//        JLabel stateLabel = new JLabel();
//        JLabel pinLabel = new JLabel();
//        JLabel religionLabel = new JLabel();
//        JLabel categoryLabel = new JLabel();
//        JLabel incomeLabel = new JLabel();
//        JLabel educationLabel = new JLabel();
//        JLabel occupationLabel = new JLabel();
//        JLabel seniorLabel = new JLabel();
//        JLabel existLabel = new JLabel();
//        JLabel panLabel = new JLabel();
//        JLabel aadharLabel = new JLabel();
//        JLabel accTypeLabel = new JLabel();
//        JLabel cardNumLabel = new JLabel();
//        JLabel pinNumLabel = new JLabel();
//        JLabel servicesLabel = new JLabel();
//        JLabel statusLabel = new JLabel();
//
//        // Add labels to panel
//        detailsPanel.add(new JLabel("Name:")); detailsPanel.add(nameLabel);
//        detailsPanel.add(new JLabel("Father's Name:")); detailsPanel.add(fatherLabel);
//        detailsPanel.add(new JLabel("DOB:")); detailsPanel.add(dobLabel);
//        detailsPanel.add(new JLabel("Gender:")); detailsPanel.add(genderLabel);
//        detailsPanel.add(new JLabel("Email:")); detailsPanel.add(emailLabel);
//        detailsPanel.add(new JLabel("Marital Status:")); detailsPanel.add(maritalLabel);
//        detailsPanel.add(new JLabel("Address:")); detailsPanel.add(addressLabel);
//        detailsPanel.add(new JLabel("City:")); detailsPanel.add(cityLabel);
//        detailsPanel.add(new JLabel("State:")); detailsPanel.add(stateLabel);
//        detailsPanel.add(new JLabel("Pin Code:")); detailsPanel.add(pinLabel);
//        detailsPanel.add(new JLabel("Religion:")); detailsPanel.add(religionLabel);
//        detailsPanel.add(new JLabel("Category:")); detailsPanel.add(categoryLabel);
//        detailsPanel.add(new JLabel("Income:")); detailsPanel.add(incomeLabel);
//        detailsPanel.add(new JLabel("Education:")); detailsPanel.add(educationLabel);
//        detailsPanel.add(new JLabel("Occupation:")); detailsPanel.add(occupationLabel);
//        detailsPanel.add(new JLabel("Senior Citizen:")); detailsPanel.add(seniorLabel);
//        detailsPanel.add(new JLabel("Existing Account:")); detailsPanel.add(existLabel);
//        detailsPanel.add(new JLabel("PAN:")); detailsPanel.add(panLabel);
//        detailsPanel.add(new JLabel("Aadhar:")); detailsPanel.add(aadharLabel);
//        detailsPanel.add(new JLabel("Account Type:")); detailsPanel.add(accTypeLabel);
//        detailsPanel.add(new JLabel("Card Number:")); detailsPanel.add(cardNumLabel);
//        detailsPanel.add(new JLabel("PIN:")); detailsPanel.add(pinNumLabel);
//        detailsPanel.add(new JLabel("Services Availed:")); detailsPanel.add(servicesLabel);
//        detailsPanel.add(new JLabel("Account Status:")); detailsPanel.add(statusLabel);
//
//        // Fetch data
//        try {
//            Conn c = new Conn();
//            String query = "SELECT * FROM login WHERE Card_No = '" + cardNumber + "' AND Pin = '" + pin + "'";
//            ResultSet rs = c.s.executeQuery(query);
//
//            if (rs.next()) {
//                String formno = rs.getString("Formno");
//
//                ResultSet r1 = c.s.executeQuery("SELECT * FROM signingup WHERE Formno = '" + formno + "'");
//                if (r1.next()) {
//                    nameLabel.setText(r1.getString("Name"));
//                    fatherLabel.setText(r1.getString("Father_name"));
//                    dobLabel.setText(r1.getString("DOB"));
//                    genderLabel.setText(r1.getString("Gender"));
//                    emailLabel.setText(r1.getString("Email"));
//                    maritalLabel.setText(r1.getString("Marital"));
//                    addressLabel.setText(r1.getString("Address"));
//                    cityLabel.setText(r1.getString("City"));
//                    stateLabel.setText(r1.getString("State"));
//                    pinLabel.setText(r1.getString("Pin"));
//                }
//
//                ResultSet r2 = c.s.executeQuery("SELECT * FROM signuptwo WHERE Formno = '" + formno + "'");
//                if (r2.next()) {
//                    religionLabel.setText(r2.getString("Religion"));
//                    categoryLabel.setText(r2.getString("Category"));
//                    incomeLabel.setText(r2.getString("Income"));
//                    educationLabel.setText(r2.getString("Education"));
//                    occupationLabel.setText(r2.getString("Occupation"));
//                    panLabel.setText(r2.getString("Pan"));
//                    aadharLabel.setText(r2.getString("Aadhar"));
//                    seniorLabel.setText(r2.getString("Senior_Citizen"));
//                    existLabel.setText(r2.getString("Existing_Account"));
//                }
//
//                ResultSet r3 = c.s.executeQuery("SELECT * FROM signupthree WHERE Formno = '" + formno + "'");
//                if (r3.next()) {
//                    accTypeLabel.setText(r3.getString("Account_Type"));
//                    cardNumLabel.setText(r3.getString("Card_No"));
//                    pinNumLabel.setText(r3.getString("Pin"));
//                    servicesLabel.setText(r3.getString("Facility"));
//                    statusLabel.setText(r3.getString("Account_Status"));
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "Invalid Card Number or PIN");
//                setVisible(false);
//                return;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // Transaction History Table
//        DefaultTableModel model = new DefaultTableModel(new String[]{"Date", "Type", "Amount"}, 0);
//        JTable table = new JTable(model);
//        JScrollPane scrollPane = new JScrollPane(table);
//        scrollPane.setBorder(BorderFactory.createTitledBorder("Transaction History"));
//        scrollPane.setPreferredSize(new Dimension(930, 200));
//
//        try {
//            Conn c = new Conn();
//            ResultSet r4 = c.s.executeQuery("SELECT * FROM deposit WHERE pin = '" + pin + "'");
//            while (r4.next()) {
//                model.addRow(new Object[]{r4.getString("date"), r4.getString("type"), r4.getString("amount")});
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // Block/Unblock Button
//        JButton toggleStatus = new JButton("Toggle Block/Unblock");
//        toggleStatus.addActionListener(e -> {
//            try {
//                Conn c = new Conn();
//                String current = statusLabel.getText();
//                String newStatus = current.equalsIgnoreCase("Blocked") ? "Active" : "Blocked";
//                c.s.executeUpdate("UPDATE signupthree SET Account_Status = '" + newStatus + "' WHERE Card_No = '" + cardNumber + "'");
//                statusLabel.setText(newStatus);
//                JOptionPane.showMessageDialog(null, "Account status updated to: " + newStatus);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        });
//
//        JPanel bottomPanel = new JPanel(new BorderLayout());
//        bottomPanel.add(scrollPane, BorderLayout.CENTER);
//        bottomPanel.add(toggleStatus, BorderLayout.SOUTH);
//
//        add(detailsPanel, BorderLayout.CENTER);
//        add(bottomPanel, BorderLayout.SOUTH);
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        new LogIn();  // This opens the actual login screen
//    }
//}







//package Bank.Management.System;
//
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.*;
//import java.sql.*;
//import java.util.Vector;
//
//public class CustomerAccount extends JFrame {
//    String cardNumber, pin;
//    JLabel balanceLabel;
//    JTable table;
//    DefaultTableModel model;
//
//    public CustomerAccount(String cardNumber, String pin) {
//        this.cardNumber = cardNumber;
//        this.pin = pin;
//
//        setTitle("Customer Account Overview");
//        setSize(1300, 1000);
//        setLocation(0, 0);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLayout(new BorderLayout());
//
//        JPanel detailsPanel = new JPanel();
//        detailsPanel.setLayout(new GridLayout(0, 2, 10, 5));
//        detailsPanel.setBorder(BorderFactory.createTitledBorder("Customer Details"));
//        detailsPanel.setBackground(new Color(240, 240, 240));
//
//        JLabel nameLabel = new JLabel();
//        JLabel emailLabel = new JLabel();
//        JLabel addressLabel = new JLabel();
//        JLabel balanceTextLabel = new JLabel("Current Balance:");
//        balanceLabel = new JLabel();
//
//        JButton editButton = new JButton("Edit Details");
//        JButton saveButton = new JButton("Save Changes");
//        saveButton.setEnabled(false);
//
//        JTextField emailField = new JTextField();
//        JTextField addressField = new JTextField();
//
//        editButton.addActionListener(e -> {
//            emailField.setText(emailLabel.getText());
//            addressField.setText(addressLabel.getText());
//            detailsPanel.remove(emailLabel);
//            detailsPanel.remove(addressLabel);
//            detailsPanel.add(emailField, 3);
//            detailsPanel.add(addressField, 7);
//            saveButton.setEnabled(true);
//            validate();
//        });
//
//        saveButton.addActionListener(e -> {
//            try {
//                Conn c = new Conn();
//                String updateQuery = "UPDATE signingup SET Email = '" + emailField.getText() + "', Address = '" + addressField.getText() + "' WHERE Card_No = '" + cardNumber + "'";
//                c.s.executeUpdate(updateQuery);
//                JOptionPane.showMessageDialog(null, "Details updated successfully.");
//                setVisible(false);
//                new CustomerAccount(cardNumber, pin);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        });
//
//        detailsPanel.add(new JLabel("Name:"));
//        detailsPanel.add(nameLabel);
//        detailsPanel.add(new JLabel("Email:"));
//        detailsPanel.add(emailLabel);
//        detailsPanel.add(new JLabel("Address:"));
//        detailsPanel.add(addressLabel);
//        detailsPanel.add(balanceTextLabel);
//        detailsPanel.add(balanceLabel);
//        detailsPanel.add(editButton);
//        detailsPanel.add(saveButton);
//
//        try {
//            Conn c = new Conn();
//            String query = "SELECT * FROM signingup WHERE Card_No = '" + cardNumber + "' AND Pin = '" + pin + "'";
//            ResultSet rs = c.s.executeQuery(query);
//            if (rs.next()) {
//                nameLabel.setText(rs.getString("Name"));
//                emailLabel.setText(rs.getString("Email"));
//                addressLabel.setText(rs.getString("Address"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // Transaction Table
//        model = new DefaultTableModel(new String[]{"Date", "Type", "Amount"}, 0);
//        table = new JTable(model);
//        JScrollPane scrollPane = new JScrollPane(table);
//        scrollPane.setBorder(BorderFactory.createTitledBorder("Transaction History"));
//        scrollPane.setPreferredSize(new Dimension(1200, 300));
//
//        loadTransactions();
//        calculateBalance();
//
//        JPanel bottomPanel = new JPanel(new FlowLayout());
//
//        String[] filterOptions = {"All", "Deposit", "Withdrawal"};
//        JComboBox<String> filterBox = new JComboBox<>(filterOptions);
//        filterBox.addActionListener(e -> applyFilter(filterBox.getSelectedItem().toString()));
//
//        JButton exportButton = new JButton("Export Transactions (PDF)");
//        exportButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "PDF Export coming soon!"));
//
//        bottomPanel.add(new JLabel("Filter: "));
//        bottomPanel.add(filterBox);
//        bottomPanel.add(exportButton);
//
//        add(detailsPanel, BorderLayout.NORTH);
//        add(scrollPane, BorderLayout.CENTER);
//        add(bottomPanel, BorderLayout.SOUTH);
//
//        setVisible(true);
//    }
//
//    private void loadTransactions() {
//        try {
//            Conn c = new Conn();
//            ResultSet r = c.s.executeQuery("SELECT * FROM deposit WHERE Pin = '" + pin + "'");
//            while (r.next()) {
//                String date = r.getString("date");
//                String type = r.getString("type");
//                String amount = r.getString("amount");
//
//                Vector<String> row = new Vector<>();
//                row.add(date);
//                row.add(type);
//                row.add(amount);
//
//                model.addRow(row);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void applyFilter(String type) {
//        model.setRowCount(0);
//        try {
//            Conn c = new Conn();
//            String query = type.equals("All") ? "SELECT * FROM deposit WHERE Pin = '" + pin + "'" :
//                    "SELECT * FROM deposit WHERE Pin = '" + pin + "' AND type = '" + type + "'";
//            ResultSet r = c.s.executeQuery(query);
//            while (r.next()) {
//                Vector<String> row = new Vector<>();
//                row.add(r.getString("date"));
//                row.add(r.getString("type"));
//                row.add(r.getString("amount"));
//                model.addRow(row);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void calculateBalance() {
//        double balance = 0;
//        try {
//            Conn c = new Conn();
//            ResultSet r = c.s.executeQuery("SELECT * FROM deposit WHERE Pin = '" + pin + "'");
//            while (r.next()) {
//                String type = r.getString("type");
//                double amount = Double.parseDouble(r.getString("amount"));
//                if (type.equals("Deposit")) balance += amount;
//                else balance -= amount;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        balanceLabel.setText("₹" + String.format("%.2f", balance));
//    }
//
//    public static void main(String[] args) {
//        new LogIn();
//    }
//}



package Bank.Management.System;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

public class CustomerAccount extends JFrame {
    String cardNumber, pin;
    JLabel balanceLabel;
    JTable table;
    DefaultTableModel model;

    public CustomerAccount(String cardNumber, String pin) {
        this.cardNumber = cardNumber;
        this.pin = pin;

        setTitle("Customer Account Overview");
        setSize(1300, 1000);
        setLocation(0, 0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel detailsPanel = new JPanel(new GridLayout(0, 2, 10, 5));
        detailsPanel.setBorder(BorderFactory.createTitledBorder("Customer Details"));
        detailsPanel.setBackground(new Color(240, 240, 240));

        // --- Labels
        JLabel nameLabel = new JLabel();
        JLabel fatherLabel = new JLabel();
        JLabel dobLabel = new JLabel();
        JLabel genderLabel = new JLabel();
//        JLabel Pnumber = new JLabel();
        JLabel emailLabel = new JLabel();
        JLabel maritalLabel = new JLabel();
        JLabel addressLabel = new JLabel();
        JLabel cityLabel = new JLabel();
        JLabel stateLabel = new JLabel();
        JLabel pinLabel = new JLabel();
        JLabel religionLabel = new JLabel();
        JLabel categoryLabel = new JLabel();
        JLabel incomeLabel = new JLabel();
        JLabel educationLabel = new JLabel();
        JLabel occupationLabel = new JLabel();
        JLabel seniorLabel = new JLabel();
        JLabel existLabel = new JLabel();
        JLabel panLabel = new JLabel();
        JLabel aadharLabel = new JLabel();
        JLabel accTypeLabel = new JLabel();
        JLabel cardNumLabel = new JLabel();
        JLabel pinNumLabel = new JLabel();
        JLabel servicesLabel = new JLabel();
        JLabel statusLabel = new JLabel();
        balanceLabel = new JLabel();

        // Editable fields
        JTextField emailField = new JTextField();
        JTextField addressField = new JTextField();
        JButton editButton = new JButton("Edit Email/Address");
        JButton saveButton = new JButton("Save Changes");
        saveButton.setEnabled(false);

        editButton.addActionListener(e -> {
            emailField.setText(emailLabel.getText());
            addressField.setText(addressLabel.getText());

            detailsPanel.remove(emailLabel);
            detailsPanel.remove(addressLabel);
            detailsPanel.add(emailField, 5);
            detailsPanel.add(addressField, 7);

            saveButton.setEnabled(true);
            detailsPanel.revalidate();
            detailsPanel.repaint();
        });

        saveButton.addActionListener(e -> {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("UPDATE signingup SET Email = '" + emailField.getText() + "', Address = '" + addressField.getText() + "' WHERE Card_No = '" + cardNumber + "'");
                JOptionPane.showMessageDialog(null, "Details updated.");
                setVisible(false);
                new CustomerAccount(cardNumber, pin);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Add all labels
        detailsPanel.add(new JLabel("Name:")); detailsPanel.add(nameLabel);
        detailsPanel.add(new JLabel("Father's Name:")); detailsPanel.add(fatherLabel);
        detailsPanel.add(new JLabel("DOB:")); detailsPanel.add(dobLabel);
        detailsPanel.add(new JLabel("Gender:")); detailsPanel.add(genderLabel);
//        detailsPanel.add(new JLabel("Contact Number:")); detailsPanel.add(PnumberLabel);
        detailsPanel.add(new JLabel("Email:")); detailsPanel.add(emailLabel);
        detailsPanel.add(new JLabel("Marital Status:")); detailsPanel.add(maritalLabel);
        detailsPanel.add(new JLabel("Address:")); detailsPanel.add(addressLabel);
        detailsPanel.add(new JLabel("City:")); detailsPanel.add(cityLabel);
        detailsPanel.add(new JLabel("State:")); detailsPanel.add(stateLabel);
        detailsPanel.add(new JLabel("Pin Code:")); detailsPanel.add(pinLabel);
        detailsPanel.add(new JLabel("Religion:")); detailsPanel.add(religionLabel);
        detailsPanel.add(new JLabel("Category:")); detailsPanel.add(categoryLabel);
        detailsPanel.add(new JLabel("Income:")); detailsPanel.add(incomeLabel);
        detailsPanel.add(new JLabel("Education:")); detailsPanel.add(educationLabel);
        detailsPanel.add(new JLabel("Occupation:")); detailsPanel.add(occupationLabel);
        detailsPanel.add(new JLabel("Senior Citizen:")); detailsPanel.add(seniorLabel);
        detailsPanel.add(new JLabel("Existing Account:")); detailsPanel.add(existLabel);
        detailsPanel.add(new JLabel("PAN:")); detailsPanel.add(panLabel);
        detailsPanel.add(new JLabel("Aadhar:")); detailsPanel.add(aadharLabel);
        detailsPanel.add(new JLabel("Account Type:")); detailsPanel.add(accTypeLabel);
        detailsPanel.add(new JLabel("Card Number:")); detailsPanel.add(cardNumLabel);
        detailsPanel.add(new JLabel("PIN:")); detailsPanel.add(pinNumLabel);
        detailsPanel.add(new JLabel("Services Availed:")); detailsPanel.add(servicesLabel);
        detailsPanel.add(new JLabel("Account Status:")); detailsPanel.add(statusLabel);
        detailsPanel.add(new JLabel("Current Balance:")); detailsPanel.add(balanceLabel);
        detailsPanel.add(editButton); detailsPanel.add(saveButton);

        // Fetch Data
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM login WHERE Card_No = '" + cardNumber + "' AND Pin = '" + pin + "'");
            if (rs.next()) {
                String formno = rs.getString("Formno");

                ResultSet r1 = c.s.executeQuery("SELECT * FROM signingup WHERE Formno = '" + formno + "'");
                if (r1.next()) {
                    nameLabel.setText(r1.getString("Name"));
                    fatherLabel.setText(r1.getString("Father_name"));
                    dobLabel.setText(r1.getString("DOB"));
                    genderLabel.setText(r1.getString("Gender"));
//                    PnumberLabel.setText(r1.getString("Contact Number"));
                    emailLabel.setText(r1.getString("Email"));
                    maritalLabel.setText(r1.getString("Marital"));
                    addressLabel.setText(r1.getString("Address"));
                    cityLabel.setText(r1.getString("City"));
                    stateLabel.setText(r1.getString("State"));
                    pinLabel.setText(r1.getString("Pin"));
                }

                ResultSet r2 = c.s.executeQuery("SELECT * FROM signuptwo WHERE Formno = '" + formno + "'");
                if (r2.next()) {
                    religionLabel.setText(r2.getString("Religion"));
                    categoryLabel.setText(r2.getString("Category"));
                    incomeLabel.setText(r2.getString("Income"));
                    educationLabel.setText(r2.getString("Education"));
                    occupationLabel.setText(r2.getString("Occupation"));
                    panLabel.setText(r2.getString("Pan"));
                    aadharLabel.setText(r2.getString("Aadhar"));
                    seniorLabel.setText(r2.getString("Senior_Citizen"));
                    existLabel.setText(r2.getString("Existing_Account"));
                }

                ResultSet r3 = c.s.executeQuery("SELECT * FROM signupthree WHERE Formno = '" + formno + "'");
                if (r3.next()) {
                    accTypeLabel.setText(r3.getString("Account_Type"));
                    cardNumLabel.setText(r3.getString("Card_No"));
                    pinNumLabel.setText(r3.getString("Pin"));
                    servicesLabel.setText(r3.getString("Facility"));
                    statusLabel.setText(r3.getString("Account_Status"));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Card or PIN");
                setVisible(false);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Transaction Table
        model = new DefaultTableModel(new String[]{"Date", "Type", "Amount"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Transaction History"));
        scrollPane.setPreferredSize(new Dimension(930, 200));
        loadTransactions();
        calculateBalance();

        // Block/Unblock
        JButton toggleStatus = new JButton("Toggle Block/Unblock");
        toggleStatus.addActionListener(e -> {
            try {
                Conn c = new Conn();
                String current = statusLabel.getText();
                String newStatus = current.equalsIgnoreCase("Blocked") ? "Active" : "Blocked";
                c.s.executeUpdate("UPDATE signupthree SET Account_Status = '" + newStatus + "' WHERE Card_No = '" + cardNumber + "'");
                statusLabel.setText(newStatus);
                JOptionPane.showMessageDialog(null, "Account status updated to: " + newStatus);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Filter and Export
        String[] filterOptions = {"All", "Deposit", "Withdrawal"};
        JComboBox<String> filterBox = new JComboBox<>(filterOptions);
        filterBox.addActionListener(e -> applyFilter(filterBox.getSelectedItem().toString()));

        JButton exportButton = new JButton("Export Transactions (PDF)");
        exportButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "PDF Export coming soon!"));

        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.add(new JLabel("Filter:"));
        bottomPanel.add(filterBox);
        bottomPanel.add(exportButton);
        bottomPanel.add(toggleStatus);

        add(detailsPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
        add(bottomPanel, BorderLayout.NORTH);
        setVisible(true);
    }

    private void loadTransactions() {
        model.setRowCount(0);
        try {
            Conn c = new Conn();
            ResultSet r = c.s.executeQuery("SELECT * FROM deposit WHERE Pin = '" + pin + "'");
            while (r.next()) {
                model.addRow(new Object[]{r.getString("date"), r.getString("type"), r.getString("amount")});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void applyFilter(String type) {
        model.setRowCount(0);
        try {
            Conn c = new Conn();
            String query = type.equals("All") ? "SELECT * FROM deposit WHERE Pin = '" + pin + "'" :
                    "SELECT * FROM deposit WHERE Pin = '" + pin + "' AND type = '" + type + "'";
            ResultSet r = c.s.executeQuery(query);
            while (r.next()) {
                model.addRow(new Object[]{r.getString("date"), r.getString("type"), r.getString("amount")});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void calculateBalance() {
        double balance = 0;
        try {
            Conn c = new Conn();
            ResultSet r = c.s.executeQuery("SELECT * FROM deposit WHERE Pin = '" + pin + "'");
            while (r.next()) {
                double amt = Double.parseDouble(r.getString("amount"));
                if (r.getString("type").equalsIgnoreCase("Deposit")) balance += amt;
                else balance -= amt;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        balanceLabel.setText("₹" + String.format("%.2f", balance));
    }

    public static void main(String[] args) {
        new LogIn();
    }
}


//package Bank.Management.System;
//
//import javax.swing.*;
//import javax.swing.table.*;
//import java.awt.*;
//import java.sql.*;
//
//public class CustomerAccount extends JFrame {
//    String cardNumber, pin;
//    JLabel balanceLabel;
//    JTable table;
//    DefaultTableModel model;
//
//    public CustomerAccount(String cardNumber, String pin) {
//        this.cardNumber = cardNumber;
//        this.pin = pin;
//
//        // -- Modern look & feel
//        try { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); } catch(Exception ignored){}
//
//        setTitle("💳 Customer Account Overview");
//        setSize(1300, 950);
//        setLocation(60, 20);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLayout(new BorderLayout(10,10));
//
//        Color headerBlue = new Color(35, 60, 120);
//        Color darkText = new Color(20, 32, 50);
//        Color lightGray = new Color(250, 250, 252);
//
//        // ---------- DETAILS PANEL ----------
//        JPanel detailsPanel = new JPanel(new GridBagLayout());
//        detailsPanel.setPreferredSize(new Dimension(600, 780));
//        detailsPanel.setBorder(BorderFactory.createTitledBorder(
//                BorderFactory.createLineBorder(headerBlue, 2, true),
//                "👤 Customer Details",
//                0, 0,
//                new Font("Segoe UI", Font.BOLD, 22),
//                headerBlue
//        ));
//        detailsPanel.setBackground(lightGray);
//
//        GridBagConstraints gc = new GridBagConstraints();
//        gc.insets = new Insets(8,20,8,20); // Spacing between fields
//
//        Font labelFont = new Font("Segoe UI Semibold", Font.PLAIN, 16);
//        Font valueFont = new Font("Segoe UI", Font.PLAIN, 16);
//
//        JLabel[] valueLabels = new JLabel[24];
//        String[] fieldNames = {"Name", "Father's Name", "DOB", "Gender", "Email", "Marital Status", "Address", "City", "State", "Pin Code", "Religion", "Category", "Income", "Education", "Occupation", "Senior Citizen", "Existing Account", "PAN", "Aadhar", "Account Type", "Card Number", "PIN", "Services Availed", "Account Status"};
//        for(int i=0; i<24; i++) valueLabels[i] = new JLabel(" "); // assign later
//
//        // arrange in two columns for max readability
//        for(int i=0;i<12;i++){
//            gc.gridx = 0; gc.gridy = i;
//            gc.anchor = GridBagConstraints.LINE_END;
//            JLabel lbl = new JLabel(fieldNames[i]+": ");
//            lbl.setFont(labelFont); lbl.setForeground(darkText);
//            detailsPanel.add(lbl, gc);
//            gc.gridx = 1; gc.anchor = GridBagConstraints.LINE_START;
//            valueLabels[i].setFont(valueFont); valueLabels[i].setForeground(headerBlue);
//            detailsPanel.add(valueLabels[i], gc);
//
//            gc.gridx = 2; // column 3
//            JLabel lbl2 = new JLabel(fieldNames[12+i]+": ");
//            lbl2.setFont(labelFont); lbl2.setForeground(darkText);
//            detailsPanel.add(lbl2, gc);
//            gc.gridx = 3; gc.anchor = GridBagConstraints.LINE_START;
//            valueLabels[12+i].setFont(valueFont); valueLabels[12+i].setForeground(headerBlue);
//            detailsPanel.add(valueLabels[12+i], gc);
//        }
//
//        // ---------- BALANCE PANEL ----------
//        JPanel balancePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        balancePanel.setBackground(lightGray);
//        JLabel balanceTitle = new JLabel("💰 Current Balance: ");
//        balanceTitle.setFont(new Font("Segoe UI Semibold", Font.BOLD, 22));
//        balanceTitle.setForeground(headerBlue);
//        balanceLabel = new JLabel();
//        balanceLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
//        balanceLabel.setForeground(new Color(0, 160, 80));
//        balancePanel.add(balanceTitle);
//        balancePanel.add(balanceLabel);
//
//        // Editable fields
//        JTextField emailField = new JTextField(18);
//        JTextField addressField = new JTextField(18);
//        JButton editButton = createButton("✏️ Edit Email/Address", new Color(39,130,230), Color.WHITE);
//        JButton saveButton = createButton("💾 Save Changes", new Color(24,160,120), Color.WHITE);
//        saveButton.setEnabled(false);
//
//        editButton.addActionListener(e -> {
//            emailField.setText(valueLabels[4].getText());
//            addressField.setText(valueLabels[6].getText());
//            detailsPanel.remove(valueLabels[4]); // email
//            detailsPanel.remove(valueLabels[6]); // address
//            gc.gridx = 1; gc.gridy = 2;
//            detailsPanel.add(emailField, gc);
//            gc.gridy = 3;
//            detailsPanel.add(addressField, gc);
//            saveButton.setEnabled(true);
//            detailsPanel.revalidate();
//            detailsPanel.repaint();
//        });
//        saveButton.addActionListener(e -> {
//            try {
//                Conn c = new Conn();
//                c.s.executeUpdate("UPDATE signingup SET Email = '" + emailField.getText() + "', Address = '" + addressField.getText() + "' WHERE Card_No = '" + cardNumber + "'");
//                JOptionPane.showMessageDialog(this, "✅ Details updated.", "Update Success", JOptionPane.INFORMATION_MESSAGE);
//                setVisible(false);
//                new CustomerAccount(cardNumber, pin);
//            } catch (Exception ex) { ex.printStackTrace(); }
//        });
//        gc.gridx = 1; gc.gridy = 12; gc.gridwidth=2;
//        detailsPanel.add(editButton, gc);
//        gc.gridx = 3; gc.gridwidth=1;
//        detailsPanel.add(saveButton, gc);
//
//        // FETCH DATA AND SET LABELS
//        try {
//            Conn c = new Conn();
//            ResultSet rs = c.s.executeQuery("SELECT * FROM login WHERE Card_No = '" + cardNumber + "' AND Pin = '" + pin + "'");
//            if (rs.next()) {
//                String formno = rs.getString("Formno");
//                ResultSet r1 = c.s.executeQuery("SELECT * FROM signingup WHERE Formno = '" + formno + "'");
//                if (r1.next()) {
//                    valueLabels[0].setText(r1.getString("Name"));
//                    valueLabels[1].setText(r1.getString("Father_name"));
//                    valueLabels[2].setText(r1.getString("DOB"));
//                    valueLabels[3].setText(r1.getString("Gender"));
//                    valueLabels[4].setText(r1.getString("Email"));
//                    valueLabels[5].setText(r1.getString("Marital"));
//                    valueLabels[6].setText(r1.getString("Address"));
//                    valueLabels[7].setText(r1.getString("City"));
//                    valueLabels[8].setText(r1.getString("State"));
//                    valueLabels[9].setText(r1.getString("Pin"));
//                }
//                ResultSet r2 = c.s.executeQuery("SELECT * FROM signuptwo WHERE Formno = '" + formno + "'");
//                if (r2.next()) {
//                    valueLabels[10].setText(r2.getString("Religion"));
//                    valueLabels[11].setText(r2.getString("Category"));
//                    valueLabels[12].setText(r2.getString("Income"));
//                    valueLabels[13].setText(r2.getString("Education"));
//                    valueLabels[14].setText(r2.getString("Occupation"));
//                    valueLabels[15].setText(r2.getString("Senior_Citizen"));
//                    valueLabels[16].setText(r2.getString("Existing_Account"));
//                    valueLabels[17].setText(r2.getString("Pan"));
//                    valueLabels[18].setText(r2.getString("Aadhar"));
//                }
//                ResultSet r3 = c.s.executeQuery("SELECT * FROM signupthree WHERE Formno = '" + formno + "'");
//                if (r3.next()) {
//                    valueLabels[19].setText(r3.getString("Account_Type"));
//                    valueLabels[20].setText(r3.getString("Card_No"));
//                    valueLabels[21].setText(r3.getString("Pin"));
//                    valueLabels[22].setText(r3.getString("Facility"));
//                    valueLabels[23].setText(r3.getString("Account_Status"));
//                }
//            } else {
//                JOptionPane.showMessageDialog(this, "❌ Invalid Card or PIN", "Login Error", JOptionPane.ERROR_MESSAGE);
//                setVisible(false);
//                return;
//            }
//        } catch (Exception e) { e.printStackTrace(); }
//
//        // --------------- TRANSACTION TABLE ----------------
//        model = new DefaultTableModel(new String[]{"📅 Date", "Type", "Amount"}, 0);
//        table = new JTable(model);
//        table.setFont(new Font("Consolas", Font.PLAIN, 15));
//        table.setRowHeight(26);
//
//        // - JTable Styling for Modern Look
//        JTableHeader th = table.getTableHeader();
//        th.setFont(new Font("Segoe UI Semibold", Font.BOLD, 17));
//        th.setBackground(headerBlue);
//        th.setForeground(Color.WHITE);
//        th.setPreferredSize(new Dimension(100, 40));
//        table.setGridColor(new Color(230,230,230));
//        table.setShowHorizontalLines(true);
//
//        // alternate row color
//        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
//            @Override
//            public Component getTableCellRendererComponent(JTable tab, Object value, boolean isSelected, boolean hasFocus, int row, int col){
//                Component c = super.getTableCellRendererComponent(tab, value, isSelected, hasFocus, row, col);
//                if(isSelected) c.setBackground(new Color(173, 216, 255));
//                else c.setBackground(row%2==0 ? Color.WHITE : new Color(240,245,250));
//                setBorder(noFocusBorder);
//                return c;
//            }
//        });
//
//        JScrollPane scrollPane = new JScrollPane(table);
//        scrollPane.setPreferredSize(new Dimension(930, 235));
//        scrollPane.setBorder(BorderFactory.createTitledBorder(
//                BorderFactory.createMatteBorder(2,0,0,0,headerBlue),
//                "Transaction History",
//                0,2,
//                new Font("Segoe UI",Font.BOLD,20),
//                headerBlue
//        ));
//        loadTransactions();
//        calculateBalance();
//
//        // --------- Toggle Account Status Button --------
//        JButton toggleStatus = createButton("🔒 Toggle Block/Unblock", new Color(240,100,60), Color.WHITE);
//        toggleStatus.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
//        toggleStatus.addActionListener(e -> {
//            try {
//                Conn c = new Conn();
//                String current = valueLabels[23].getText();
//                String newStatus = current.equalsIgnoreCase("Blocked") ? "Active" : "Blocked";
//                c.s.executeUpdate("UPDATE signupthree SET Account_Status = '" + newStatus + "' WHERE Card_No = '" + cardNumber + "'");
//                valueLabels[23].setText(newStatus);
//                JOptionPane.showMessageDialog(this, "Account status updated to: " + newStatus, "Status Update", JOptionPane.INFORMATION_MESSAGE);
//            } catch (Exception ex) { ex.printStackTrace(); }
//        });
//
//        // -------- Filter & Export Bar -------
//        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.LEFT, 25, 5));
//        topBar.setBackground(new Color(238, 244, 252));
//        String[] filterOptions = {"All", "Deposit", "Withdrawal"};
//        JComboBox<String> filterBox = new JComboBox<>(filterOptions);
//        filterBox.setFont(new Font("Segoe UI", Font.PLAIN, 16));
//        filterBox.addActionListener(e -> applyFilter(filterBox.getSelectedItem().toString()));
//        JButton exportButton = createButton("⬇️ Export (PDF)", new Color(100,130,220), Color.WHITE);
//        exportButton.setToolTipText("Export as PDF");
//        exportButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "PDF Export coming soon!"));
//
//        topBar.add(new JLabel("Filter:"));
//        topBar.add(filterBox);
//        topBar.add(exportButton);
//        topBar.add(toggleStatus);
//
//        // Layout
//        JPanel mainContent = new JPanel(new BorderLayout(0,10));
//        mainContent.setBackground(lightGray);
//        mainContent.add(detailsPanel, BorderLayout.CENTER);
//        mainContent.add(balancePanel, BorderLayout.SOUTH);
//
//        add(topBar, BorderLayout.NORTH);
//        add(mainContent, BorderLayout.CENTER);
//        add(scrollPane, BorderLayout.SOUTH);
//
//        setVisible(true);
//    }
//
//    // --- Button builder for consistent style ---
//    private JButton createButton(String text, Color bg, Color fg){
//        JButton b = new JButton(text);
//        b.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
//        b.setBackground(bg); b.setForeground(fg);
//        b.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
//        b.setFocusPainted(false);
//        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        return b;
//    }
//
//    private void loadTransactions() {
//        model.setRowCount(0);
//        try {
//            Conn c = new Conn();
//            ResultSet r = c.s.executeQuery("SELECT * FROM deposit WHERE Pin = '" + pin + "'");
//            while (r.next()) {
//                model.addRow(new Object[]{r.getString("date"), r.getString("type"), r.getString("amount")});
//            }
//        } catch (Exception e) { e.printStackTrace(); }
//    }
//    private void applyFilter(String type) {
//        model.setRowCount(0);
//        try {
//            Conn c = new Conn();
//            String query = type.equals("All") ? "SELECT * FROM deposit WHERE Pin = '" + pin + "'" :
//                    "SELECT * FROM deposit WHERE Pin = '" + pin + "' AND type = '" + type + "'";
//            ResultSet r = c.s.executeQuery(query);
//            while (r.next()) {
//                model.addRow(new Object[]{r.getString("date"), r.getString("type"), r.getString("amount")});
//            }
//        } catch (Exception e) { e.printStackTrace(); }
//    }
//    private void calculateBalance() {
//        double balance = 0;
//        try {
//            Conn c = new Conn();
//            ResultSet r = c.s.executeQuery("SELECT * FROM deposit WHERE Pin = '" + pin + "'");
//            while (r.next()) {
//                double amt = Double.parseDouble(r.getString("amount"));
//                if (r.getString("type").equalsIgnoreCase("Deposit")) balance += amt;
//                else balance -= amt;
//            }
//        } catch (Exception e) { e.printStackTrace(); }
//        balanceLabel.setText("₹" + String.format("%.2f", balance));
//    }
//    public static void main(String[] args) {
//        new LogIn();
//    }
//}
