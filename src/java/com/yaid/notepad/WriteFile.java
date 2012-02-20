/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yaid.notepad;

import java.io.*;

/**
 *
 * @author Amal Joy
 */
public class WriteFile {

    public String writetext = "";

    public void write() throws IOException {
        Writer output = null;
        File file = new File("./UserData/manu/Home/hello.txt");
        output = new BufferedWriter(new FileWriter(file));
        output.write(writetext);
        output.close();
        System.out.println("Your file has been written");
    }
}
