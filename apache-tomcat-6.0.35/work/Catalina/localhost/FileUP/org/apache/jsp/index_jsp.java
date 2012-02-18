package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>jQuery File Upload Example</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/themes/base/jquery-ui.css\" id=\"theme\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"fileupload/jquery.fileupload-ui.css\">\n");
      out.write("        <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.5.0/jquery.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/jquery-ui.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"fileupload/jquery.fileupload.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"fileupload/jquery.fileupload-ui.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form id=\"file_upload\" action=\"Upload\" method=\"POST\" enctype=\"multipart/form-data\">\n");
      out.write("            <div id=\"drop_zone_1\">\n");
      out.write("                <input id=\"file_1\" type=\"file\" name=\"file_1\" multiple/>\n");
      out.write("                <div>Upload files</div>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"drop_zone_2\">\n");
      out.write("                <input id=\"file_2\" type=\"file\" name=\"file_2\" multiple/>\n");
      out.write("                <div>Upload files</div>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"drop_zone_3\">\n");
      out.write("                <input id=\"file_3\" type=\"file\" name=\"file_3\" multiple/>\n");
      out.write("                <div>Upload files</div>\n");
      out.write("            </div>\n");
      out.write("            <button>Upload</button>\n");
      out.write("\n");
      out.write("            <table id=\"files_1\" style=\"background:yellow;\"></table>\n");
      out.write("            <table id=\"files_2\" style=\"background:gold;\"></table>\n");
      out.write("            <table id=\"files_3\" style=\"background:orange;\"></table>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("            /*global $ */\n");
      out.write("            $(function () {\n");
      out.write("                var initFileUpload = function (suffix) {\n");
      out.write("                    $('#file_upload').fileUploadUI({\n");
      out.write("                        namespace: 'file_upload_' + suffix,\n");
      out.write("                        fileInputFilter: '#file_' + suffix,\n");
      out.write("                        dropZone: $('#drop_zone_' + suffix),\n");
      out.write("                        uploadTable: $('#files_' + suffix),\n");
      out.write("                        downloadTable: $('#files_' + suffix),\n");
      out.write("                        buildUploadRow: function (files, index) {\n");
      out.write("                            return $('<tr><td>' + files[index].name + '<\\/td>' +\n");
      out.write("                                '<td class=\"file_upload_progress\"><div><\\/div><\\/td>' +\n");
      out.write("                                '<td class=\"file_upload_cancel\">' +\n");
      out.write("                                '<button class=\"ui-state-default ui-corner-all\" title=\"Cancel\">' +\n");
      out.write("                                '<span class=\"ui-icon ui-icon-cancel\">Cancel<\\/span>' +\n");
      out.write("                                '<\\/button><\\/td><\\/tr>');\n");
      out.write("                        },\n");
      out.write("                        buildDownloadRow: function (file) {\n");
      out.write("                            return $('<tr><td>' + file.name + '<\\/td><\\/tr>');\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                };\n");
      out.write("                initFileUpload(1);\n");
      out.write("                initFileUpload(2);\n");
      out.write("                initFileUpload(3);\n");
      out.write("            });\n");
      out.write("        </script> \n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
