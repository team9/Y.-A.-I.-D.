/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yaid.administrator;

import com.yaid.db.DbConnection;
import java.io.File;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;

/**
 *
 * @author TTT
 */
public class SpaceUsage extends HttpServlet {

    static long size1 = 0;
    static long fileCount = 0;
    static int fileNo = 1;

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
            out.println("<title>Servlet SpaceUsage</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SpaceUsage at " + request.getContextPath () + "</h1>");
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
        Connection connect = null;
        String mail = null;
        String operation = null;
        String targetID = null;
        String userDirectory = null;
        String serverSpace = null;
        PrintWriter pw = null;
        response.setContentType("text/html;charset=UTF-8");
        pw = response.getWriter();
        try {
            connect = DbConnection.getDbConnection();
            operation = request.getParameter("operation");
            if(operation.equals("getUsersSpaceUsage")) {
            targetID = request.getParameter("targetid");
            //System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> Target ID : " + mail);
            preparedStatement = connect.prepareStatement("select * from yaid.users where userid=?");
            preparedStatement.setInt(1, Integer.parseInt(targetID));
            System.out.println("Statement : " + preparedStatement);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                mail = resultSet.getString("email");
            }
//             String uid = email.substring(0, email.indexOf("@"));
            // mail = "ert";
            mail = mail.substring(0, mail.indexOf("@")); //cropping of adress part after '@' symbol
            userDirectory = "./UserData/" + mail;
            System.out.println("Target ID : " + mail);
            displaySizeOfDir(userDirectory);
            
            //response.sendRedirect("administratorSpaceUsage.jsp");
          
            pw.print(sizeOfDir(new File(userDirectory)));
//            response.sendRedirect("administratorSpaceUsage.jsp");
//            response.setContentType("text/html");
//            pw.print("<<<<<<<<<<<<<<<<<<<<<<hai>>>>>>>>>>>>>>>>>>>>");

            } else if(operation.equals("getServerSpaceUsage")) {
                serverSpace = "./UserData";
                displaySizeOfDir(serverSpace);
                pw.print(sizeOfDir(new File(serverSpace)));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Space Usage Error : " + e);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    public static void displaySizeOfDir(String target) {
        File targetUserDirectory = null;
        boolean check = false;
        long size = 0;
        float sizeInKB = 0;
        float sizeInMB = 0;
        float sizeInGB = 0;
        targetUserDirectory = new File(target);
        size = sizeOfDir(targetUserDirectory);
        sizeInKB = size / 1024;
        sizeInMB = sizeInKB / 1024;
        sizeInGB = sizeInMB / 1024;

        System.out.println("Directory size      : " + size);
        System.out.println("Directory size in KB: " + sizeInKB);
        System.out.println("Directory size in MB: " + sizeInMB);
        System.out.println("Directory size in GB: " + sizeInGB);
        System.out.println("File Count          : " + fileCount);
//        File file = new File("./java/123.txt");
//        long filesize = file.length();
//        long filesizeInKB = filesize / 1024;
//        System.out.println(">>>>>>>>>>>>>>>> Size of File is: " + filesizeInKB + " KB");
    }

    public static long sizeOfDir(File dir) {
        long totalsize = 0;
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                System.out.println(fileNo + ")  " + children[i]);

            }
            for (int i = 0; i < children.length; i++) {
                //totalsize += sizeOfDir(new File(dir, children[i]));
                totalsize += sizeOfDir(new File(dir, children[i]));
//                if (!success) {
//                    return false;
//                }
                //fileCount++;
            }
            return (totalsize);
        }
        // The directory is now empty so delete it
        fileCount++;
        fileNo++;
        return dir.length();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
