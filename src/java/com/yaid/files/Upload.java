/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yaid.files;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author TTT
 */
public class Upload extends HttpServlet {

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
    private String uploadPath = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        ServletFileUpload uploadHandler = new ServletFileUpload(new DiskFileItemFactory());
        HttpSession session = request.getSession(true);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String location = request.getParameter("toloc");

            if (location != null) {
                String uid = "/" + (String) session.getAttribute("userID");
                if (uid != null) {
                    session.setAttribute("uploadPath", uid+location);
                    System.out.println("Upload location set:  ./UserData" + uid+uploadPath + "/" + "file");
                }
            } else {
                    if (!ServletFileUpload.isMultipartContent(request)) {
                        throw new IllegalArgumentException("Request is not multipart, please 'multipart/form-data' enctype for your form.");
                    }
                    uploadPath = (String) session.getAttribute("uploadPath");
                    List<FileItem> items = uploadHandler.parseRequest(request);
                    for (FileItem item : items) {
                        if (!item.isFormField()) {
                            System.out.println("Upload location:  ./UserData" + uploadPath + "/" + item.getName());
                            File file = new File("./UserData" + uploadPath + "/" + item.getName());
                            item.write(file);
                            out.write("{\"name\":\"" + item.getName() + "\",\"type\":\""
                                    + item.getContentType() + "\",\"size\":\"" + item.getSize() + "\"}");
                            break; // assume we only get one file at a time
                        }
                    }
                }
            }  catch (FileUploadException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);

        } finally {
            out.close();
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
