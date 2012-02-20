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
public class ReadFile {

    private String text = "";

    public String read(String path) {
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream(path);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                //text = text.concat("<div>");
                text = text.concat(strLine);
                //text = text.concat("</div>");
            }
            //Close the input stream
            in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
        return text;
    }
}
