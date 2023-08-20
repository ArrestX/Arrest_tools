package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class IPDuplicateRemover {
    public static void main(String[] args) {
        String inputFile = "/Users/arrest_document/Documents/Hero404not_tools/quchong/src/main/input.csv";
        String outputFile = "/Users/arrest_document/Documents/Hero404not_tools/quchong/src/main/output.csv";

        try {
            Set<String> uniqueIPs = new HashSet<>();

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String ip = parts[0].trim(); // Assuming IP address is in the first column
                uniqueIPs.add(ip);
            }
            reader.close();

            FileWriter writer = new FileWriter(outputFile);
            for (String ip : uniqueIPs) {
                writer.write(ip + "\n");
            }
            writer.close();

            System.out.println("Duplicate IP addresses removed and saved to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
