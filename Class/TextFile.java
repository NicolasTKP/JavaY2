package com.mycompany.JavaY2.Class;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TextFile {

    public static void addLine(String path, String line){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
            bw.newLine();
            bw.write(line);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
