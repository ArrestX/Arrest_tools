package org.example;

import java.io.*;

public class TextFileFilter {
    public static void main(String[] args) {
        String inputFilePath = "/Users/arrest_document/Documents/Hero404not_tools/quchong/src/main/input.txt";    // 输入文件路径
        String outputFilePath = "/Users/arrest_document/Documents/Hero404not_tools/quchong/src/main/output.txt";  // 输出文件路径

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("metermall")) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
