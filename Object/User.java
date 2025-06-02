package com.mycompany.JavaY2.Object;

import com.mycompany.JavaY2.login;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class User implements IUser {

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
    
    @Override
    public boolean anyMatch(String keyword){
        Set<String> valuesToCheck = new HashSet<>(Arrays.asList(
                this.username.toLowerCase(),
                this.user_id.toLowerCase(),
                this.role.toLowerCase(),
                this.password.toLowerCase()
        ));
        return valuesToCheck.contains(keyword);
    }
    
    @Override
    public String getRole(){
        return this.role;
    }

    @Override
    public void setRole(String role){
        this.role = role;
    }
    
    @Override
    public String getPassword(){
        return this.password;
    }

    @Override
    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String getUsername(){
        return this.username;
    }
    
    @Override
    public void setUsername(String username){
        this.username = username;
    }

    @Override    
    public String getUserID(){
        return this.user_id;
    }
    
    @Override
    public void setUserID(String userID){
        this.user_id = userID;
    }
    
    @Override    
    public void login(){
        new login().setVisible(true);
    }
    
}
