package com.mycompany.JavaY2.Object;

public class SessionManager {
    private static SessionManager instance;
    public String username;
    public String password;
    public String role;
    public String userID;

    private SessionManager() {}

    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

}
