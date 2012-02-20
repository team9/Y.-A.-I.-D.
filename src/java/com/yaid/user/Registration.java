package com.yaid.user;

import com.yaid.ser.*;

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
        PreparedStatement preparedStatement = null;
        Connection connect = null;
        PrintWriter pw = null;
        ResultSet resultSet = null;
        Boolean accountExists = false;
        try {
            connect = DbConnection.getDbConnection();
            //UserDetailsBean udb = new UserDetailsBean();
            //String uid = request.getParameter("userid");
            //udb.setUserID(uid);
            String psw = request.getParameter("regPassword");
            //udb.setUserPassword(psw);
            String email = request.getParameter("regEmailid");
            //udb.setUserEmail(email);
            pw = response.getWriter();
            preparedStatement = connect.prepareStatement("select * from YAID.USERS where email = ?");
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getString("email").equals(email)) {
                    System.out.println("\t email in DB : " + resultSet.getString("email"));
                    response.setContentType("text/html");
                    pw.println("<script type=\"text/javascript\">");
                    pw.println("alert('Another user with same user ID exists... Please redo registration with another ID!!!');");
                    pw.println("</script>");
                    response.sendRedirect("index.jsp");
                    accountExists = true;
                    break;
                }

            }

            if (accountExists == false) {

                preparedStatement = connect.prepareStatement("insert into YAID.USERS values(NULL,?,?)");
                preparedStatement.setString(1, psw);
                preparedStatement.setString(2, email);
                preparedStatement.executeUpdate();
                String uid = email.substring(0, email.indexOf("@"));
                System.out.println("Hello : " + uid);
                initializeDirectory(uid);
                initialSerialization(uid);

                response.setContentType("text/html");
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Registratoin successful... You may login now...');");
                //pw.println("window.location='index.jsp';");
                pw.println("</script>");
                response.sendRedirect("index.jsp");

            }
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

    public void initialSerialization(String uid) {
        System.out.println("The user id is: " + uid);
        User u = new User();
        u.wallpaper_path = "ImageBytes?id=/vig/My Files/WallPaper/feathers.jpg";
        SerializeUser.serialize(u, uid);
    }

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
