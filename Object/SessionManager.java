package com.mycompany.JavaY2.Object;

public class SessionManager {
    private static SessionManager instance;
    public String username;
    public String password;
    public String role;
    public String userID;
    public boolean raising_pr;

    private SessionManager() {}

    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
            instance.raising_pr = false;
        }
        return instance;
    }

    public static synchronized void clearCache() {
        instance = new SessionManager();
    }

}
