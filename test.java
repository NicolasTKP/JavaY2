package com.mycompany.JavaY2;

import com.mycompany.JavaY2.Class.Edit;
import com.mycompany.JavaY2.Class.Query;
import com.mycompany.JavaY2.Object.ObjectList;

import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class test {
    public static void main(String[] args) {
        String inputValue = JOptionPane.showInputDialog("Enter a value:");

        // Check if the user entered something
        if (inputValue != null && !inputValue.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "You entered: " + inputValue);
        } else {
            JOptionPane.showMessageDialog(null, "No value entered!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
//
//        System.out.println(Query.getLatestOrderID());
        String[] options = Query.getPendingPR();
        if (options.length>0){
            String choice = (String) JOptionPane.showInputDialog(
                    null,
                    "Select an option:",
                    "Dropdown Selection",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
        }else {
            JOptionPane.showMessageDialog(null, "No pending PR", "Warning", JOptionPane.WARNING_MESSAGE);
        }


    }
}
