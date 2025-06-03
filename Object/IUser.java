/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.JavaY2.Object;

/**
 *
 * @author User
 */
public interface IUser {

    boolean anyMatch(String keyword);

    String getRole();
    void setRole(String role);

    String getPassword();
    void setPassword(String password);

    String getUsername();
    void setUsername(String username);

    String getUserID();
    void setUserID(String userID);

    void login();
    
}
