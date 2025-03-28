package com.mycompany.JavaY2;

import com.mycompany.JavaY2.Class.Edit;
import com.mycompany.JavaY2.Class.Query;
import com.mycompany.JavaY2.Class.TextFile;
import com.mycompany.JavaY2.Object.ObjectList;

import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class test {
    public static void main(String[] args) {
        String path = "src/main/java/com/mycompany/JavaY2/TextFile/purchase_orders";
        TextFile.deleteLine(path, "I001", 2);


    }
}
