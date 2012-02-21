/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yaid.administrator;

import com.yaid.db.DbConnection;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TTT
 */
public class ChangeAdministratorProfile extends HttpServlet {

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
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChangeAdministratorProfile</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangeAdministratorProfile at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
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
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        Connection connect = null;
        HttpSession session = request.getSession(true);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = null;
        pw = response.getWriter();
        response.setContentType("text/html");
        try {
            String oldPassword = request.getParameter("oldPassword");
            String newPassword = request.getParameter("newPassword");

            System.out.println("oldPassword : " + oldPassword);
            System.out.println("newPassword : " + newPassword);
            String temp = (String) session.getAttribute("userID");
            temp = "admin" + "@admin.com";
            connect = DbConnection.getDbConnection();


            preparedStatement = connect.prepareStatement("select password,email from yaid.users where email=?");
            preparedStatement.setString(1, temp);
            resultSet = preparedStatement.executeQuery();
            System.out.println("\t Query : " + preparedStatement);
            while (resultSet.next()) {

                if (resultSet.getString("password").equals(oldPassword)) {
                    preparedStatement = connect.prepareStatement("UPDATE yaid.users SET password=? where email=?");
                    preparedStatement.setString(1, newPassword);
                    preparedStatement.setString(2, temp);
                    System.out.println("\t Query2 : " + preparedStatement);
                    preparedStatement.executeUpdate();
                    pw.println("<script type=\"text/javascript\">");
                    pw.println("alert('New password successfully saved !  Please wait while you get redirected back !');");
                    pw.println("window.location='administratorProfile.jsp';");
                    pw.println("</script>");

                } else {
                    pw.println("<script type=\"text/javascript\">");
                    pw.println("alert('Invalid password !!!');");
                    pw.println("window.location='administratorProfile.jsp';");
                    pw.println("</script>");
                }
                break;
            }
        } catch (Exception e) {
            System.out.println("View Single User Error : " + e);
        } finally {
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
