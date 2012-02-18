/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yaid.ser;

/**
 *
 * @author Amal Joy
 */
public class User implements java.io.Serializable {

    static final long serialVersionUID = 1L;
    public String wallpaper_path;
    //public int clock;
    //public int calendar;

    /*public void print(User u) {
        System.out.println("Wallpaper path is " + wallpaper_path);
        System.out.println("Type is " + type);
        SerializeUser s = new SerializeUser();
        s.serialize(u);
        DeserializeUser d = new DeserializeUser();
        d.deserialize();
    }*/

    public void defaultValues(User u, String uid) {
        SerializeUser s = new SerializeUser();
        s.serialize(u,uid);
    }

    public User loginTime(String uid) {
        User u = null;
        DeserializeUser d = new DeserializeUser();
        u = d.deserialize(uid);
        return u;
    }
}
