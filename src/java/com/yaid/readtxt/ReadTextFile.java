/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yaid.readtxt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Amal Joy
 */
public class ReadTextFile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        //String filename = "/WEB-INF/message.properties";
        String filename = "/UserData/manu/Home/hello.txt";
        ServletContext context = getServletContext();

        InputStream inp = context.getResourceAsStream(filename);
        if (inp != null) {
            InputStreamReader isr = new InputStreamReader(inp);
            BufferedReader reader = new BufferedReader(isr);
            PrintWriter pw = response.getWriter();
            pw.println("<html><head><title>Read Text File</title></head><body bgcolor='cyan'></body></html>");
            String text = "";

            while ((text = reader.readLine()) != null) {
                pw.println("<h2><i><b>" + text + "</b></i></b><br>");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    }
}
