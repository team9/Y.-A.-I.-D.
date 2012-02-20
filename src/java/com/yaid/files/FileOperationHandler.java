/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yaid.files;

import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vignesh
 */
public class FileOperationHandler extends HttpServlet {

    private String startPath = "./UserData";

    public String getFolders(String path) {

        String jsondata = null;//"[{\"attr\":{\"id\":\"node_395\",\"rel\":\"folder\"},\"data\":\"New node\",\"state\":\"\"},{\"attr\":{\"id\":\"node_397\",\"rel\":\"folder\"},\"data\":\"New node\",\"state\":\"closed\"},{\"attr\":{\"id\":\"node_399\",\"rel\":\"default\"},\"data\":\"New node\",\"state\":\"\"},{\"attr\":{\"id\":\"node_398\",\"rel\":\"default\"},\"data\":\"New node\",\"state\":\"\"}]";

        String state = null;
        File dir = new File(startPath + path);
        File[] chld = dir.listFiles();
        jsondata = "[";
        System.out.println("helo " + startPath + path);
        path = (path.endsWith("/")) ? path : path + "/";
        for (int i = 0; i < chld.length; i++) {
            if (chld[i].isDirectory()) {
                jsondata += (jsondata.length() > 5) ? "," : "";
                state = (chld[i].list().length != 0) ? "closed" : "";
                jsondata += "{\"attr\":{\"id\":\"node_" + path + chld[i].getName() + "/\",\"rel\":\"folder\"},\"data\":\"" + chld[i].getName() + "\",\"state\":\"" + state + "\"}";
                //chld[i].isDirectory();
                System.out.println(path + chld[i].getName());

            }
        }
        jsondata += "]";
        System.out.println(jsondata);
        return jsondata;
    }

    public String renameFile(String path, String newName) {
        String jsondata = null;//"[{\"attr\":{\"id\":\"node_395\",\"rel\":\"folder\"},\"data\":\"New node\",\"state\":\"\"},{\"attr\":{\"id\":\"node_397\",\"rel\":\"folder\"},\"data\":\"New node\",\"state\":\"closed\"},{\"attr\":{\"id\":\"node_399\",\"rel\":\"default\"},\"data\":\"New node\",\"state\":\"\"},{\"attr\":{\"id\":\"node_398\",\"rel\":\"default\"},\"data\":\"New node\",\"state\":\"\"}]";

        String state = null;
        File dir = new File(startPath + path);
        File newfile = new File(startPath + newName);
        String type;
        if (dir.renameTo(newfile)) {
            if (newfile.isDirectory()) {
                type = "\"rel\":\"folder\",\"img\":\"images/icons/gnome-fs-directory.png\"";
            } else if (newfile.getName().endsWith(".jpg") || newfile.getName().endsWith(".png")) {
                type = "\"rel\":\"image\",\"img\":\"ImageBytes?id=" + path + newfile.getName() + "\"";
            } else if (newfile.getName().endsWith(".ogg") || newfile.getName().endsWith(".wmv")
                    || newfile.getName().endsWith(".avi") || newfile.getName().endsWith(".mov")) {
                type = "\"rel\":\"vedio\",\"img\":\"images/icons/video.png\"";
            } else {
                type = "\"rel\":\"file\",\"img\":\"images/icons/ascii.png\"";
            }
            jsondata = "{\"attr\":{\"id\":\"file_" + path + newfile.getName() + "\"," + type + "},\"data\":\"" + newfile.getName() + "\",\"state\":\"" + state + "\"}";
            //chld[i].isDirectory();
        }
        System.out.println(jsondata + " " + dir + " " + newfile);
        return jsondata;
    }

    public String makeFile(String path, String newName) {
        String jsondata = null;
        try {
            String state = null;
            String type = null;
            path = (path.endsWith("/")) ? path : path + "/";
            File dir = new File(startPath + path + newName);//createNewFile() 
            //[] chld = dir.listFiles();
            jsondata = "{";
            System.out.println("helo " + startPath + path + newName);
            if (dir.createNewFile() == true) {
                type = "\"rel\":\"file\",\"img\":\"images/icons/ascii.png\"";


                jsondata += "\"attr\":{\"id\":\"file_" + path + newName + "\"," + type + "},\"data\":\""
                        + newName + "\",\"state\":\"" + state + "\"";
                jsondata += "}";
            }
            System.out.println(jsondata);

        } catch (IOException ex) {
            Logger.getLogger(FileOperationHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return jsondata;
        }
    }

    public String makeDirectory(String path, String newName) {
        String jsondata = null;
        try {
            String state = null;
            String type = null;
            path = (path.endsWith("/")) ? path : path + "/";
            File dir = new File(startPath + path + newName);//createNewFile() 
            //[] chld = dir.listFiles();
            jsondata = "{";
            System.out.println("helo " + startPath + path + newName);
            if (dir.mkdir() == true) {
                type = "\"rel\":\"folder\",\"img\":\"images/icons/gnome-fs-directory.png\"";


                jsondata += "\"attr\":{\"id\":\"file_" + path + newName + "\"," + type + "},\"data\":\""
                        + newName + "\",\"state\":\"" + state + "\"";
                jsondata += "}";
            }
            System.out.println(jsondata);

        } finally {
            return jsondata;
        }
    }

    public String getAllFiles(String path) {
        String jsondata = null;//"[{\"attr\":{\"id\":\"node_395\",\"rel\":\"folder\"},\"data\":\"New node\",\"state\":\"\"},{\"attr\":{\"id\":\"node_397\",\"rel\":\"folder\"},\"data\":\"New node\",\"state\":\"closed\"},{\"attr\":{\"id\":\"node_399\",\"rel\":\"default\"},\"data\":\"New node\",\"state\":\"\"},{\"attr\":{\"id\":\"node_398\",\"rel\":\"default\"},\"data\":\"New node\",\"state\":\"\"}]";

        String state = null;
        File dir = new File(startPath + path);
        File[] chld = dir.listFiles();
        String type;
        jsondata = "[";
        System.out.println("helo " + startPath + path);
        path = (path.endsWith("/")) ? path : path + "/";
        for (int i = 0; i < chld.length; i++) {
            if (chld[i].isDirectory()) {
                type = "\"rel\":\"folder\",\"img\":\"images/icons/gnome-fs-directory.png\"";
            } else if (chld[i].getName().endsWith(".jpg") || chld[i].getName().endsWith(".png")) {
                type = "\"rel\":\"image\",\"img\":\"ImageBytes?id=" + path + chld[i].getName() + "\"";
            }  else if (chld[i].getName().endsWith(".txt") || chld[i].getName().endsWith(".rtf")) {
                type = "\"rel\":\"doc\",\"img\":\"images/icons/ascii.png\"";
            } else if (chld[i].getName().endsWith(".ogg") || chld[i].getName().endsWith(".wmv")
                    || chld[i].getName().endsWith(".avi") || chld[i].getName().endsWith(".mov")) {
                type = "\"rel\":\"vedio\",\"img\":\"images/icons/video.png\"";
            } else {
                type = "\"rel\":\"file\",\"img\":\"images/icons/ascii.png\"";
            }
            jsondata += (jsondata.length() > 5) ? "," : "";
            jsondata += "{\"attr\":{\"id\":\"file_" + path + chld[i].getName() + "\"," + type + "},\"data\":\"" + chld[i].getName() + "\",\"state\":\"" + state + "\"}";
            //chld[i].isDirectory();

            System.out.println(path + chld[i].getName());

        }
        jsondata += "]";
        System.out.println(jsondata);
        return jsondata;
    }

    public String getAllImages(String path) {
        String jsondata = null;//"[{\"attr\":{\"id\":\"node_395\",\"rel\":\"folder\"},\"data\":\"New node\",\"state\":\"\"},{\"attr\":{\"id\":\"node_397\",\"rel\":\"folder\"},\"data\":\"New node\",\"state\":\"closed\"},{\"attr\":{\"id\":\"node_399\",\"rel\":\"default\"},\"data\":\"New node\",\"state\":\"\"},{\"attr\":{\"id\":\"node_398\",\"rel\":\"default\"},\"data\":\"New node\",\"state\":\"\"}]";

        String state = null;
        File dir = new File(startPath + path);
        File[] chld = dir.listFiles();
        String type;
        jsondata = "[";
        System.out.println("helo " + startPath + path);
        path = (path.endsWith("/")) ? path : path + "/";
        for (int i = 0; i < chld.length; i++) {
            if (chld[i].isDirectory()) {
                //type="\"rel\":\"folder\",\"img\":\"images/icons/gnome-fs-directory.png\"";
                continue;
            } else if (chld[i].getName().endsWith(".jpg")) {
                type = "\"rel\":\"image\",\"img\":\"ImageBytes?id=" + path + chld[i].getName() + "\"";
            } else {
                //type="\"rel\":\"file\",\"img\":\"images/icons/ascii.png\"";
                continue;
            }
            jsondata += (jsondata.length() > 5) ? "," : "";
            jsondata += "{\"attr\":{\"id\":\"file_" + path + chld[i].getName() + "\"," + type + "},\"data\":\"" + chld[i].getName() + "\",\"state\":\"" + state + "\"}";
            //chld[i].isDirectory();

            System.out.println(path + chld[i].getName());

        }
        jsondata += "]";
        System.out.println(jsondata);
        return jsondata;
    }

    public void copyFolder(File src, File dest) throws IOException {

        if (src.isDirectory()) {

            //if directory not exists, create it
            if (!dest.exists()) {
                dest.mkdir();
                System.out.println("Directory copied from "
                        + src + "  to " + dest);
            }

            //list all the directory contents
            String files[] = src.list();

            for (String file : files) {
                //construct the src and dest file structure
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                //recursive copy
                copyFolder(srcFile, destFile);
            }

        } else {
            //if file, then copy it
            //Use bytes stream to support all file types
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];

            int length;
            //copy the file content in bytes 
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            in.close();
            out.close();
            System.out.println("File copied from " + src + " to " + dest);
        }

    }

    public boolean deleteFolder(File resource) throws IOException {

        if (resource.isDirectory()) {
            File[] childFiles = resource.listFiles();
            for (File child : childFiles) {
                deleteFolder(child);
            }

        }
        return resource.delete();
    }

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
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        try {
            String operation = request.getParameter("operation");
            String filePath = request.getParameter("id");
            String fileName = request.getParameter("newname");
            String fileContent = request.getParameter("content");
            //filePath = (filePath.equals("1") ? "/" : filePath);
            Map params = request.getParameterMap();
            Iterator i = params.keySet().iterator();
            if (filePath != null) {
                filePath = filePath.replace("%20", " ");
            }
            if (fileName != null) {
                fileName = fileName.replace("%20", " ");
            }
            while (i.hasNext()) {
                String key = (String) i.next();
                String value = ((String[]) params.get(key))[ 0];
                System.out.println("Key: " + key + " Value: " + value);
            }
            System.out.println(operation + " " + filePath + fileName);
            if (operation.equals("get_folder")) {
                out.println(getFolders(filePath));
            } else if (operation.equals("get_files")) {
                out.print(getAllFiles(filePath));
            } else if (operation.equals("get_images")) {
                out.print(getAllImages(filePath));
            } else if (operation.equals("make_files") && fileName != null) {
                out.print(makeFile(filePath, fileName));
            } else if (operation.equals("make_dir") && fileName != null) {
                out.print(makeDirectory(filePath, fileName));
            } else if (operation.equals("rename_files") && fileName != null) {
                out.print(renameFile(filePath, fileName));
            } else if (operation.equals("copy") && fileName != null) {
                File src = new File(startPath + filePath);
                File dest = new File(startPath + fileName + "/" + src.getName());
                copyFolder(src, dest);
                out.print(getAllFiles(fileName));
            } else if (operation.equals("cut") && fileName != null) {
                File src = new File(startPath + filePath);
                File dest = new File(startPath + fileName + "/" + src.getName());
                copyFolder(src, dest);
                deleteFolder(src);
                out.print(getAllFiles(fileName));
            }

        } catch (Exception e) {
            e.printStackTrace();
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
