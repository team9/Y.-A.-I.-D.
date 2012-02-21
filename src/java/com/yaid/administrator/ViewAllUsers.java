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

/**
 *
 * @author TTT
 */
public class ViewAllUsers extends HttpServlet {

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
            out.println("<title>Servlet ViewAllUsers</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewAllUsers at " + request.getContextPath () + "</h1>");
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

        response.setContentType("text/html");
        try {
            System.out.println("qwert");
            String operation = request.getParameter("operation");
            String userid = request.getParameter("userid");
            System.out.println("Operation : " + operation);
            System.out.println("UserID : " + userid);
            if (operation.equals("showSingleUser")) {
                System.out.println("qwerty");
                selectSingleUser(userid);

            }


//            System.out.println("\t Query : " + preparedStatement);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ViewAllUsers Error : " + e);
        }


        /** 
         * Returns a short description of the servlet.
         * @return a String containing servlet description
         */
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    public void selectSingleUser(String userid) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        Connection connect = null;
        System.out.println("UserID2 : " + Integer.parseInt(userid));
        try {
            connect = DbConnection.getDbConnection();
            preparedStatement = connect.prepareStatement("select * from yaid.users where userid=?");
            preparedStatement.setInt(1, Integer.parseInt(userid));
            resultSet = preparedStatement.executeQuery();
            //System.out.println("UserID3 : " + user.getInt("userid"));
            showUserDetails(resultSet);
        } catch (Exception e) {
            System.out.println("View Single User Error : " + e);
        } finally {
        }
    }

    public void showUserDetails(ResultSet user) {
        try {

            PrintWriter pw = null;
            pw.println("<div>");
            pw.println("<label> User ID : </label>" + user.getInt("userid"));
            pw.println("</br>");
            pw.println("<label> Email : </label>" + user.getString("email"));
            pw.println("</br>");
            pw.println("<label> Password : </label>" + user.getString("password"));
            pw.println("</br>");
        } catch (Exception e) {
            System.out.println("Show User Details Error : " + e);
        }
    }
}
