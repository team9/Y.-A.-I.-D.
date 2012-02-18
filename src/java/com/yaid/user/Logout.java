/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yaid.user;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TTT
 */
public class Logout extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
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

        HttpSession theSession = null;
        PrintWriter pw = null;
        try {
            theSession = request.getSession(false);
            pw = response.getWriter();
            // print out the session id
            if (theSession != null) {
                System.out.println("<BR>Session Id: " + theSession.getId());
                synchronized (theSession) {
                    // invalidating a session destroys it
                    theSession.invalidate();
                    System.out.println("<BR>Session destroyed");
                }

            }
            System.out.println("hai");
            response.setContentType("text/html");
            pw.println("<script type=\"text/javascript\">");
            pw.println("window.location='index.jsp';");
            pw.println("</script>");
            System.out.println("haaaaaaaaaai");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Login Error : " + e);
        }
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
