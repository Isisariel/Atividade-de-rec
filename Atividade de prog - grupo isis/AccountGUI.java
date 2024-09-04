package com.deitel.ch17;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AccountGUI {
    private final JFrame frame;
    private final JTextField accountField;
    private final JTextField firstNameField;
    private final JTextField lastNameField;
    private final JTextField balanceField;
    private final JButton saveButton;
    private final JButton displayButton;

    public AccountGUI() {
        frame = new JFrame("Account Record");
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel accountLabel = new JLabel("Account:");
        accountLabel.setBounds(10, 10, 80, 25);
        frame.add(accountLabel);

        accountField = new JTextField();
        accountField.setBounds(100, 10, 160, 25);
        frame.add(accountField);

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(10, 40, 80, 25);
        frame.add(firstNameLabel);

        firstNameField = new JTextField();
        firstNameField.setBounds(100, 40, 160, 25);
        frame.add(firstNameField);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(10, 70, 80, 25);
        frame.add(lastNameLabel);

        lastNameField = new JTextField();
        lastNameField.setBounds(100, 70, 160, 25);
        frame.add(lastNameField);

        JLabel balanceLabel = new JLabel("Balance:");
        balanceLabel.setBounds(10, 100, 80, 25);
        frame.add(balanceLabel);

        balanceField = new JTextField();
        balanceField.setBounds(100, 100, 160, 25);
        frame.add(balanceField);

        saveButton = new JButton("Save");
        saveButton.setBounds(10, 130, 250, 25);
        frame.add(saveButton);

        displayButton = new JButton("Display");
        displayButton.setBounds(10, 160, 250, 25);
        frame.add(displayButton);

        saveButton.addActionListener((ActionEvent e) -> {
            saveAccountRecord();
        });

        displayButton.addActionListener((ActionEvent e) -> {
            CreateTextFile.displayFileContents();
        });

        frame.setVisible(true);
    }

    private void saveAccountRecord() {
        try {
            int account = Integer.parseInt(accountField.getText());
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            double balance = Double.parseDouble(balanceField.getText());

            AccountRecord record = new AccountRecord(account, firstName, lastName, balance);
            CreateTextFile.saveToFile(record);

            JOptionPane.showMessageDialog(frame, "Account record saved successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input. Please enter valid numbers for account and balance.");
        }
    }

    public static void main(String[] args) {
        new AccountGUI();
    }
}