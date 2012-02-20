/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yaid.administrator;

import com.yaid.db.DbConnection;
import java.io.File;
import java.sql.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TTT
 */
public class DeleteUser extends HttpServlet {

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
            out.println("<title>Servlet DeleteUser</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteUser at " + request.getContextPath () + "</h1>");
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

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        HttpSession session = request.getSession(true);
        Connection connect = null;
        PrintWriter pw = null;
        File targetUserDirectory = null;
        boolean check = false;
        response.setContentType("text/html;charset=UTF-8");
        pw = response.getWriter();
        response.setContentType("text/html");
        try {
            String id = request.getParameter("targetid");
            String mail = null;

            System.out.println("user id : " + id);

            connect = DbConnection.getDbConnection();

            preparedStatement = connect.prepareStatement("select * from yaid.users where userid=?");
            preparedStatement.setInt(1, Integer.parseInt(id));
            System.out.println("Statement : " + preparedStatement);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                mail = resultSet.getString("email");
            }
//             String uid = email.substring(0, email.indexOf("@"));
            // mail = "ert";
           mail = mail.substring(0, mail.indexOf("@")); //cropping of adress part after '@' symbol
//             
            preparedStatement = connect.prepareStatement("delete from yaid.users where userid=?");
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.executeUpdate();

            //targetUserDirectory = new File("UserData/" + mail);
            targetUserDirectory = new File("./UserData/" + mail);
            check = deleteDir(targetUserDirectory);
          
            if (check) {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Deletion of user from database completed successfully!');");
                pw.println("</script>");
            } else {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Deletion of user from database completed failed!!!');");
                 pw.println("</script>");
            }
            //pw.println("window.location='administratorViewUsers.jsp';");
           
            response.sendRedirect("administratorViewUsers.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Deletion of user Error : " + e);
        }
    }

    public static boolean deleteDir(File dir) {

        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                System.out.println("Content " + i + ": " + children[i]);
            }
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
//                if (!success) {
//                    return false;
//                }
            }
        }
        // The directory is now empty so delete it
        return dir.delete();
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
