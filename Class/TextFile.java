package com.mycompany.JavaY2.Class;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TextFile {

    public static void addLine(String path, String line){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
            bw.newLine();
            bw.write(line);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteLine(String path, String target, int targetColumn){
        try {
            List<String> linesList = Files.readAllLines(Paths.get(path));
            BufferedWriter bw = new BufferedWriter(new FileWriter(path, false));
            boolean flag = true;

            for (String line:linesList) {
                if (line.split("\\|")[targetColumn].strip().equals(target.strip())){
                    continue;
                }
                if (flag){
                    bw.write(line);
                    flag = false;
                }else{
                    bw.newLine();
                    bw.write(line);
                }
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
