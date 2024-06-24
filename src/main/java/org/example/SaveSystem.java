package org.example;

import java.io.*;
import java.util.Scanner;

public class SaveSystem {
    private File file;

    public SaveSystem(String name) {
        file = new File(name);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String readFile() {
        try {
            StringBuilder content = new StringBuilder();
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                if (content.length() > 0) {
                    content.append("\n");
                }
                content.append(scan.nextLine());
            }
            scan.close();
            return content.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeFile(String content) {
        try {
            FileWriter yazici = new FileWriter(file, false);
            BufferedWriter bufferedYazici = new BufferedWriter(yazici);
            bufferedYazici.write(content);
            bufferedYazici.close();
            yazici.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearFile() {
        try {
            FileWriter yazici = new FileWriter(file, false);
            BufferedWriter bufferedYazici = new BufferedWriter(yazici);
            bufferedYazici.write("");
            bufferedYazici.close();
            yazici.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
