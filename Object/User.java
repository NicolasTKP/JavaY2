package com.mycompany.JavaY2.Object;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class User {

    public String role;
    public String password;
    public String username;
    public String user_id;


    User(){
    }
    User(String user_id, String username, String password, String role){
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
}
