package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CSVManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请选择操作：");
        System.out.println("1. 在指定后缀后添加内容");
        System.out.println("2. 过滤 .com 之后的内容");
        System.out.println("3. 在每一行开头添加内容");
        System.out.println("4. 在每一行末尾添加内容"); // 新增选项
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        String inputFileName = "/Users/arrest_document/Documents/Hero404not_tools/quchong/src/main/output4.csv";   // 输入的 CSV 文件名
        String outputFileName = "/Users/arrest_document/Documents/Hero404not_tools/quchong/src/main/output4.csv"; // 输出的 CSV 文件名
        String suffix = ".com";               // 指定的后缀
        String addition = "/admin";                 // 添加的内容

        if (choice == 1 || choice == 3 || choice == 4) { // 修改条件，添加选项 4
            System.out.print("请输入要添加的内容：");
            addition = scanner.nextLine();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String modifiedLine;
                if (choice == 1) {
                    int index = line.indexOf(suffix);
                    modifiedLine = (index != -1) ? line.substring(0, index + suffix.length()) + addition : line;
                } else if (choice == 2) {
                    int index = line.indexOf(suffix);
                    modifiedLine = (index != -1) ? line.substring(0, index + suffix.length()) : line;
                } else if (choice == 3) {
                    modifiedLine = addition + line;
                } else if (choice == 4) { // 新增选项 4
                    modifiedLine = line + addition;
                } else {
                    System.out.println("无效选择。");
                    return;
                }

                writer.write(modifiedLine);
                writer.newLine();
            }

            System.out.println("操作完成，已将结果写入 " + outputFileName);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
