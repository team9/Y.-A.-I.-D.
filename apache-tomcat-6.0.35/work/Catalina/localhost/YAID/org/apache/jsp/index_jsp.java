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

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Virtual Desktop</title>\r\n");
      out.write("        <meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("        <link href=\"CSS/RegistrationLogin/RegistrationLogin.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\r\n");
      out.write("        <script src=\"JQUERY/jquery.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script type=\"text/javascript\"  src=\"JQUERY/jquery.js\"></script>\r\n");
      out.write("        <script>\r\n");
      out.write("      \r\n");
      out.write("         \r\n");
      out.write("            \r\n");
      out.write("            function validateEmailID(address) {\r\n");
      out.write(" \r\n");
      out.write("                var reg = /^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})$/;\r\n");
      out.write("                //var address = document.forms[form_id].elements[email].value;\r\n");
      out.write("                if(reg.test(address) == false) {\r\n");
      out.write("                    //alert(\"Please enter a valid email ID !!!\");\r\n");
      out.write("                    $(\"#warnings\").show();\r\n");
      out.write("                    $(\"#warnings\").html(\"Please enter a valid email ID !!!\");\r\n");
      out.write("                    return false;\r\n");
      out.write("                }\r\n");
      out.write("                return true;\r\n");
      out.write("            }\r\n");
      out.write("    \r\n");
      out.write("            $(document).ready(function (){\r\n");
      out.write("                $('#LoginDetails').submit(function () {\r\n");
      out.write("                    var address = document.getElementById(\"emailid\").value;\r\n");
      out.write("                    var password = document.getElementById(\"password\").value;\r\n");
      out.write("                    \r\n");
      out.write("                    if(validateEmailID(address)== true) {\r\n");
      out.write("                        if(document.LoginDetails.password.value == \"\") {\r\n");
      out.write("                            $(\"#warnings\").show();\r\n");
      out.write("                            // $(\"warnings\").style.backgroundColor=\"white\";\r\n");
      out.write("                            $(\"#warnings\").html(\"Please enter your password !!!\");\r\n");
      out.write("                            return false;\r\n");
      out.write("                        \r\n");
      out.write("                        }\r\n");
      out.write("                        else  {\r\n");
      out.write("                            var parameters= {\r\n");
      out.write("                                \"emailid\":address,\r\n");
      out.write("                                \"password\" :password\r\n");
      out.write("                            };\r\n");
      out.write("                           \r\n");
      out.write("                            $.ajax({\r\n");
      out.write("                                type:'POST',\r\n");
      out.write("                                url:\"Login\", //calling servlet\r\n");
      out.write("                                data: parameters,\r\n");
      out.write("                                cache:false,\r\n");
      out.write("                                success:function(htmldat){\r\n");
      out.write("                                    console.log(\"Response : \" + htmldat );\r\n");
      out.write("                                    if(htmldat == \"invalidUser\")\r\n");
      out.write("                                    {   $(\"#warnings\").show();\r\n");
      out.write("                                        $(\"#warnings\").html(\"Invalid user ID and password !!!\");\r\n");
      out.write("                                    }\r\n");
      out.write("                                    else if(htmldat == \"ordinaryUser\")  \r\n");
      out.write("                                        window.location =\"desktop.jsp\" ;\r\n");
      out.write("                                    else if(htmldat == \"admin\") \r\n");
      out.write("                                        window.location ='administratorViewUsers.jsp' ;\r\n");
      out.write("                                    \r\n");
      out.write("                                },\r\n");
      out.write("                                error:function(xhr,ajaxOptions){\r\n");
      out.write("                                    alert(xhr.status + \" :: \" + xhr.statusText);\r\n");
      out.write("                                }\r\n");
      out.write("                            }); \r\n");
      out.write("                        \r\n");
      out.write("                        }\r\n");
      out.write("                    } \r\n");
      out.write("                   \r\n");
      out.write("                    return  false;\r\n");
      out.write("                });\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                 \r\n");
      out.write("          \r\n");
      out.write("          \r\n");
      out.write("           \r\n");
      out.write("          \r\n");
      out.write("            \r\n");
      out.write("\r\n");
      out.write("                $('#RegistrationDetails').submit(function () {\r\n");
      out.write("                    var regaddress = document.getElementById(\"regEmailid\").value;\r\n");
      out.write("                    var regpassword = document.getElementById(\"regPassword\").value;\r\n");
      out.write("                    var regconfirmpassword = document.getElementById(\"confirmPassword\").value;\r\n");
      out.write("            \r\n");
      out.write("                    //alert(\"hai :\" + regaddress + regpassword + regconfirmpassword);\r\n");
      out.write("                    //validateEmailID(document.RegistrationDetails.regEmailid.value);\r\n");
      out.write("                    // alert(\"hello\");\r\n");
      out.write("                    if(validateEmailID(regaddress)== true) {\r\n");
      out.write("                        if(regpassword != regconfirmpassword) {\r\n");
      out.write("                            $(\"#warnings\").show();\r\n");
      out.write("                   \r\n");
      out.write("                            $(\"#warnings\").html(\"The values in password and confirm password fields doesn't match !!!\");\r\n");
      out.write("                       \r\n");
      out.write("                            //alert(\"hello2222\");\r\n");
      out.write("                            return false;\r\n");
      out.write("                        }\r\n");
      out.write("                        else if(regaddress==\"\" || regpassword==\"\" || regconfirmpassword==\"\") {\r\n");
      out.write("                            $(\"#warnings\").show();\r\n");
      out.write("                   \r\n");
      out.write("                            $(\"#warnings\").html(\"None of the fields can be empty !!!\");\r\n");
      out.write("                        \r\n");
      out.write("                            return false;\r\n");
      out.write("                        }\r\n");
      out.write("                        else {\r\n");
      out.write("                            var parameters= {\r\n");
      out.write("                                \"regEmailid\":document.RegistrationDetails.regEmailid.value,\r\n");
      out.write("                                \"regPassword\" :document.RegistrationDetails.regPassword.value\r\n");
      out.write("                            };\r\n");
      out.write("                            $.ajax({\r\n");
      out.write("                                type:'POST',\r\n");
      out.write("                                url:\"Registration\", //calling servlet\r\n");
      out.write("                                data: parameters,\r\n");
      out.write("                                cache:false,\r\n");
      out.write("                                success:function(htmldat){\r\n");
      out.write("                                    //alert(\"Response : \" + htmldat );\r\n");
      out.write("                                    if(htmldat == \"UserAlreadyExists\")\r\n");
      out.write("                                    {   $(\"#warnings\").show();\r\n");
      out.write("                                        $(\"#warnings\").html(\"The same user ID already exists... Retry registration with another user ID !!!\");\r\n");
      out.write("                                        \r\n");
      out.write("                                        return false;\r\n");
      out.write("                                    }\r\n");
      out.write("                                    else if(htmldat == \"SuccessfulRegistration\") {\r\n");
      out.write("                                        alert(\"Registration successful... You may login now...\");\r\n");
      out.write("                                        window.location ='index.jsp';\r\n");
      out.write("                                    }\r\n");
      out.write("                            \r\n");
      out.write("                           \r\n");
      out.write("                                    \r\n");
      out.write("                                },\r\n");
      out.write("                                error:function(xhr,ajaxOptions){\r\n");
      out.write("                                    alert(xhr.status + \" :: \" + xhr.statusText);\r\n");
      out.write("                                }\r\n");
      out.write("                            }); return false;\r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("                    return false;\r\n");
      out.write("                });\r\n");
      out.write("            });\r\n");
      out.write("            function loadRegistrationForm() {\r\n");
      out.write("                //document.RegistrationDetails.style.display='block';\r\n");
      out.write("                //document.LoginDetails.style.display='none';\r\n");
      out.write("                $(\"#warnings\").hide();\r\n");
      out.write("                $(\"#LoginDetails\").hide();\r\n");
      out.write("                $(\"#RegistrationDetails\").show();\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("        </script>\r\n");
      out.write("        <style>\r\n");
      out.write("            #RegistrationDetails {\r\n");
      out.write("                display: none;\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div id=\"wrapper\">\r\n");
      out.write("            <div id=\"logo\">\r\n");
      out.write("                <h1>Virtual Desktop</h1>\r\n");
      out.write("                <p>The Complete Solution For Your Portability</p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"menu\">\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li><a href=\"#\" class=\"active\">Home</a></li>\r\n");
      out.write("<!--                    <li><a href=\"#\">About US</a></li>-->\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"header\">&nbsp;</div>\r\n");
      out.write("            <div id=\"page\">\r\n");
      out.write("                <div id=\"content\">\r\n");
      out.write("                    <h2>Welcome . . .</h2><br />\r\n");
      out.write("                    <p class=\"byline\">Establish your computer on web !</p>\r\n");
      out.write("                    <p><strong>Virtual Desktop</strong> is an cloud desktop application that is molded on the SaaS cloud computing architecture. Virtual Desktop is an Open Source Platform designed to hold a wide variety of Web Applications. Virtual Desktop was visualized to be a new definition of an Operating System, where everything inside it can be accessed from everywhere within a seamless network, the internet. All you need to do is login into your Virtual Desktop server with a normal Internet Browser, and you have access to your personal desktop, with your applications, documents, music, movies... just like you left it. In other words \"your anywhere, anytime personalized desktop\".</p>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <p>&nbsp;</p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div id=\"sidebar\">\r\n");
      out.write("                    <h3>Unlock Your Webtop . . . </h3>\r\n");
      out.write("                    <br />\r\n");
      out.write("                    <div id=\"warnings\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div style=\"padding-left: 20px;\">\r\n");
      out.write("                        <form name=\"LoginDetails\" id=\"LoginDetails\"  >\r\n");
      out.write("                            <label>Email ID  : </label><input type=\"text\" id=\"emailid\" name=\"emailid\" class=\"more\" size=\"60\" />\r\n");
      out.write("                            <label>Password  : </label><input type=\"password\" id=\"password\" name=\"password\" class=\"more\"/>\r\n");
      out.write("                            <br />\r\n");
      out.write("                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  \r\n");
      out.write("                            <input type=\"submit\" value=\"Login\" class=\"submit\" size=\"70px;\"/> \r\n");
      out.write("                            <p><a href=\"#\" class=\"button\" onclick=\"return loadRegistrationForm()\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Register</a> </p>\r\n");
      out.write("\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div style=\"padding-left: 20px;\">\r\n");
      out.write("                        <form name=\"RegistrationDetails\" id=\"RegistrationDetails\" action=\"Registration\" method=\"post\">\r\n");
      out.write("                            <label>Email ID  : </label><input type=\"text\" id=\"regEmailid\" name=\"regEmailid\" class=\"more\" size=\"60\" />\r\n");
      out.write("                            <label>Password  : </label><input type=\"password\" id=\"regPassword\" name=\"regPassword\" class=\"more\"/>\r\n");
      out.write("                            <label>Confirm Password  : </label><input type=\"password\" id=\"confirmPassword\" name=\"confirmPassword\" class=\"more\"/>\r\n");
      out.write("                            <br />\r\n");
      out.write("                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \r\n");
      out.write("                            <input type=\"submit\" value=\"Register\" class=\"submit\" size=\"70px;\"/> \r\n");
      out.write("                            <input type=\"button\" value=\"Cancel\" class=\"submit\" size=\"70px;\" onclick=\"window.location.href='index.jsp';\"/> \r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div style=\"clear: both;\">&nbsp;</div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"footer\">\r\n");
      out.write("                <p>Design by <strong>The VATOMS</strong> </p>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
