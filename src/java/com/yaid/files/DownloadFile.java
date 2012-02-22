/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yaid.files;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vignesh
 */
public class DownloadFile extends HttpServlet {

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

        /*
         * TODO output your page here. You may use following sample code.
         */
        HttpSession session = request.getSession(true);
        String uid = "/" + (String) session.getAttribute("userID");
        if (uid != null) {
            String filename = "./UserData"+ uid+ request.getParameter("id");
            File f = new File(filename);

            if (f.isDirectory()) {
                f = zipFile(f);
                downloadFile(f, request, response);
                f.delete();
            } else {
                downloadFile(f, request, response);
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

    private File zipFile(File f) {
        File outFolder = new File(f.getName() + ".zip");
        try {
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outFolder)));
            BufferedInputStream in = null;
            byte[] data = new byte[1000];
            String files[] = f.list();
            for (int i = 0; i < files.length; i++) {
                in = new BufferedInputStream(new FileInputStream(f.getPath() + "/" + files[i]), 1000);
                out.putNextEntry(new ZipEntry(files[i]));
                int count;
                while ((count = in.read(data, 0, 1000)) != -1) {
                    out.write(data, 0, count);
                }
                out.closeEntry();
            }
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outFolder;
    }

    private void downloadFile(File f, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletOutputStream op = response.getOutputStream();
        try {
            int length = 0;

            ServletContext context = getServletConfig().getServletContext();
            String mimetype = context.getMimeType(f.getAbsolutePath());

            //
            //  Set the response and go!
            response.setContentType((mimetype != null) ? mimetype : "application/octet-stream");
            response.setContentLength((int) f.length());
            response.setHeader("Content-Disposition", "attachment; filename=\"" + f.getName() + "\"");

            //  Stream to the requester.
            byte[] bbuf = new byte[1024];
            DataInputStream in = new DataInputStream(new FileInputStream(f));

            while ((in != null) && ((length = in.read(bbuf)) != -1)) {
                op.write(bbuf, 0, length);
            }

            in.close();
        } finally {

            op.flush();
            op.close();

        }

    }
}
