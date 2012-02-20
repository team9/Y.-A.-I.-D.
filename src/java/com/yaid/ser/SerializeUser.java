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
public class SerializeUser {

    public static void serialize(User u, String uid) {
        System.out.println("Before Serializing....");
        System.out.println("Wallpaper path is " + u.wallpaper_path);
        //u.wallpaper_path = "path string";
        //u.clock = 111;
        //u.calendar = 99;
        try {
            FileOutputStream fileOut = new FileOutputStream("./UserData/" + uid + "/Settings/" + uid + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(u);
            out.close();
            fileOut.close();
            System.out.println("Object is serialized & stored in 'User.ser'");
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
