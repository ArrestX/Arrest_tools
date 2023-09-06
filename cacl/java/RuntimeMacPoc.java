package org.cacl;


import java.io.IOException;

public class RuntimeMacPoc {
    public static void main(String[] args) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("open", "-a", "Calculator");
            processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}