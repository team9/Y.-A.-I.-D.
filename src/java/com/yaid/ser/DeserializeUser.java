/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yaid.ser;

import java.io.*;

/**
 *
 * @author Amal Joy
 */
public class DeserializeUser {

    public static User deserialize(String uid) {
        User uu = null;
        try {
            FileInputStream fileIn = new FileInputStream("./UserData/" + uid + "/Settings/" + uid + ".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            uu = (User) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("User class not found");
            c.printStackTrace();
            return null;
        }
        System.out.println("Deserialized User...");
        System.out.println("Wallpaper path: " + uu.wallpaper_path);
        //System.out.println("Clock: " + u.clock);
        //System.out.println("Calendar: " + u.calendar);
        return uu;
    }
}
