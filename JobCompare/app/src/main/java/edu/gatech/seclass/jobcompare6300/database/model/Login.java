package edu.gatech.seclass.jobcompare6300.database.model;

import java.io.Serializable;

public class Login  implements Serializable {

    private static final long serialVersionUID = 3198099950959560099L;

    private String username;
    private String password;

    public Login(){
        setUsername("Team082");
        setPassword(password = "Spring22#");
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
