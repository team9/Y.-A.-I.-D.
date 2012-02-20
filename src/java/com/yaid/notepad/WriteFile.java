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

    public void write(String path, String text) throws IOException {
        Writer output = null;
        File file = new File(path);
        output = new BufferedWriter(new FileWriter(file));
        output.write(text);
        output.close();
    }
}