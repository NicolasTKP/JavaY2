package com.mycompany.JavaY2;

import com.mycompany.JavaY2.Class.Edit;
import com.mycompany.JavaY2.Class.Query;
import com.mycompany.JavaY2.Class.TextFile;
import com.mycompany.JavaY2.Object.ObjectList;
import com.mycompany.JavaY2.Object.SessionManager;

import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class test {
    public static void main(String[] args) {
        SessionManager.getInstance().username = "hello";
        System.out.println(SessionManager.getInstance().username);


    }
}
