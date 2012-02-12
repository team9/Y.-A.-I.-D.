/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yaid.user;

/**
 *
 * @author TTT
 */
public class UserDetailsBean {

    String userID;
    String userPassword;
    String userEmail;

    public String getUserID() {
        return (this.userID);
    }

    public String getUserPassword() {
        return (this.userPassword);
    }

    public String getUserEmail() {
        return (this.userEmail);
    }

    public void setUserID(String id) {
        this.userID = id;
    }

    public void setUserPassword(String password) {
        this.userPassword = password;
    }

    public void setUserEmail(String email) {
        this.userEmail = email;
    }
}
