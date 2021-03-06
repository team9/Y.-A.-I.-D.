/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yaid.files;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ImageBytes extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String uid = "/" + (String) session.getAttribute("userID");
        if (uid != null) {
            String path = "./UserData" + uid + request.getParameter("id");
            if (path.endsWith(".jpg")) {
                response.setContentType("image/jpeg");
            } else if (path.endsWith(".wmv")) {
                response.setContentType("video/x-ms-wmv");
                System.out.println("video/x-ms-wmv");
            } else if (path.endsWith(".png")) {
                response.setContentType("image/png");
                System.out.println("image/png");
            } else if (path.endsWith(".mov")) {
                response.setContentType("video/quicktime");
                System.out.println("video/x-ms-wmv");
            } else if (path.endsWith(".flv")) {
                response.setContentType("video/x-flv");
                System.out.println("video/x-ms-wmv");
            } else if (path.endsWith(".avi")) {
                response.setContentType("video/avi");
                System.out.println("video/x-ms-wmv");
            } else if (path.endsWith(".ogg")) {
                response.setContentType("application/ogg");
            } else if (path.endsWith(".mp3")) {
                response.setContentType("audio/mpeg3");
            } else if (path.endsWith(".mp4")) {
                response.setContentType("video/mp4");
            } else {
                response.setContentType("image/jpeg");
            }
            OutputStream out = response.getOutputStream();
            File file = new File(path);
            DataInputStream dis = new DataInputStream(new FileInputStream(file));
            try {
                //File length
                int size = (int) file.length();
                if (size > Integer.MAX_VALUE) {
                    System.out.println("File is to larger");
                }
                byte[] bytes = new byte[size];
                dis.read(bytes);
                out.write(bytes);
                // Ensure all the bytes have been read in
                if (size < bytes.length) {
                    System.out.println("Could not completely read: " + file.getName());
                }

            } catch (Exception e) {
                e.getMessage();
            } finally {
                out.close();
                dis.close();
            }
        }
    }
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
