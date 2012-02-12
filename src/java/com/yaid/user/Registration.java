package com.yaid.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import com.yaid.db.DbConnection;
import java.io.*;

/**
 *
 * @author TTT
 */
public class Registration extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

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
        try {
            //UserDetailsBean udb = new UserDetailsBean();
            //String uid = request.getParameter("userid");
            //udb.setUserID(uid);
            String psw = request.getParameter("regPassword");
            //udb.setUserPassword(psw);
            String email = request.getParameter("regEmailid");
            //udb.setUserEmail(email);
            PreparedStatement preparedStatement = null;
            Connection connect = DbConnection.getDbConnection();
            preparedStatement = connect.prepareStatement("insert into YAID.USERS values(NULL,?,?)");
            preparedStatement.setString(1, psw);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
            initializeDirectory(email);
            response.sendRedirect("index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
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

    public void initializeDirectory(String userid) {
        try {
            String strDirectoy = "UserData/" + userid;
            boolean success1 = (new File(strDirectoy)).mkdirs();
            strDirectoy = "UserData/" + userid + "/Home";
            boolean success2 = (new File(strDirectoy)).mkdirs();
            strDirectoy = "UserData/" + userid + "/Desktop";
            boolean success3 = (new File(strDirectoy)).mkdirs();
            strDirectoy = "UserData/" + userid + "/Settings";
            boolean success4 = (new File(strDirectoy)).mkdirs();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
}
