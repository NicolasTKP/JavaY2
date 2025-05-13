package com.mycompany.JavaY2;

import com.mycompany.JavaY2.Class.Edit;
import com.mycompany.JavaY2.Class.Query;
import com.mycompany.JavaY2.Class.Search;
import com.mycompany.JavaY2.Class.TextFile;
import com.mycompany.JavaY2.Object.ObjectList;
import com.mycompany.JavaY2.Object.SessionManager;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class test {
    public static void main(String[] args) throws IOException {
        List<String> linesList = Files.readAllLines(Paths.get("src/main/java/com/mycompany/JavaY2/TextFile/items"));

        String item_name = "orange,apple";
        String su = "SU002";

        StringBuilder res = new StringBuilder();

        String[] split_item_name = item_name.split(",");

        for (String item:split_item_name){
            for (String line:linesList){
                String[] lines = line.split("\\|");
                String name = lines[1];
                String supplier = lines[6];
                if (item.equals(name) && su.equals(supplier)){
                    String item_id = lines[0];
                    if (!res.isEmpty()){
                        res.append(",");
                    }
                    res.append(item_id);
                }
            }
        }

        System.out.println(res.toString());


    }
}
