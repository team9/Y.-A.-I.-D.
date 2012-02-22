/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yaid.ser;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Amal Joy
 */
public class GetPath extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public String wallpaper_path;
    public String key;
    public String clock_set;
    public String calender_set;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        try {
            wallpaper_path = request.getParameter("value");
            clock_set = request.getParameter("value");
            calender_set = request.getParameter("value");
            key = request.getParameter("key");
            if (key.equals("wallpaper")) {
                out.println("SUCCESS: path = " + wallpaper_path + " and key = " + key);
                String uid = (String) session.getAttribute("userID");
                User u = DeserializeUser.deserialize(uid);
                u.wallpaper_path = wallpaper_path;
                SerializeUser.serialize(u, uid);
            }
            if (key.equals("clockset")) {
                out.println("SUCCESS: path = " + clock_set + " and key = " + key);
                String uid = (String) session.getAttribute("userID");
                User u = DeserializeUser.deserialize(uid);
                u.clock_set = clock_set;
                SerializeUser.serialize(u, uid);
            }
            if (key.equals("calenderset")) {
                out.println("SUCCESS: path = " + calender_set + " and key = " + key);
                String uid = (String) session.getAttribute("userID");
                User u = DeserializeUser.deserialize(uid);
                u.calender_set = calender_set;
                SerializeUser.serialize(u, uid);
            }
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
