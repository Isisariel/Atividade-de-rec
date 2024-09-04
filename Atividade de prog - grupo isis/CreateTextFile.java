package com.deitel.ch17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class CreateTextFile {
    private static final String FILE_NAME = "account_records.txt";

    public static void saveToFile(AccountRecord record) {
        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            out.println(record); // Usa o método toString() da AccountRecord para formatar a saída
            out.println(); // Adiciona uma linha em branco para melhor legibilidade
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void displayFileContents() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            StringBuilder contents = new StringBuilder("Contents of the file:\n");
            while ((line = reader.readLine()) != null) {
                contents.append(line).append("\n");
            }
            JOptionPane.showMessageDialog(null, contents.toString());
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error reading from file: " + e.getMessage());
        }
    }
}