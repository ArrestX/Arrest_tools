package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

public class ProcessCSV {

    public static void main(String[] args) {
        String inputFilePath = "/Users/arrest_document/Documents/Hero404not_tools/spiderExcelcolum/file/output.csv";
        String outputFilePath = "/Users/arrest_document/Documents/Hero404not_tools/spiderExcelcolum/file/output2.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Check if the line is a valid IPv4 address
                if (isValidIPv4(line)) {
                    writer.write(line);
                    writer.newLine();
                }
            }

            System.out.println("CSV processing complete.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Check if a string is a valid IPv4 address
    private static boolean isValidIPv4(String ip) {
        String ipv4Regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        return Pattern.matches(ipv4Regex, ip);
    }
}
