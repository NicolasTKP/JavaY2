package com.mycompany.JavaY2.Object;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class User {

    private String role;
    private String password;
    private String username;
    private String user_id;


    public User(){
    }
    public User(String user_id, String username, String password, String role){
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public boolean anyMatch(String keyword){
        Set<String> valuesToCheck = new HashSet<>(Arrays.asList(
                this.username.toLowerCase(),
                this.user_id.toLowerCase(),
                this.role.toLowerCase(),
                this.password.toLowerCase()
        ));
        return valuesToCheck.contains(keyword);
    }

    public String getRole(){
        return this.role;
    }

    public void setRole(String role){
        this.role = role;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUserID(){
        return this.user_id;
    }

    public void setUserID(String userID){
        this.user_id = userID;
    }
    
}
