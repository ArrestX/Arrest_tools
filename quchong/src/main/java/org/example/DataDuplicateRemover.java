package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DataDuplicateRemover {
    public static void main(String[] args) {
        String inputFile = "/Users/arrest_document/Documents/Hero404not_tools/quchong/src/main/input.csv";
        String outputFile = "/Users/arrest_document/Documents/Hero404not_tools/quchong/src/main/output.csv";

        try {
            Set<String> uniqueData = new HashSet<>();

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming data is in the first column, you can modify this based on your actual data structure
                String[] parts = line.split(",");
                String data = parts[0].trim();
                uniqueData.add(data);
            }
            reader.close();

            FileWriter writer = new FileWriter(outputFile);
            for (String data : uniqueData) {
                writer.write(data + "\n");
            }
            writer.close();

            System.out.println("重复数据已被移除并保存到 " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
