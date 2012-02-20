package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.yaid.ser.DeserializeUser;
import com.yaid.ser.User;

public final class desktop_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");

            String uid = (String) session.getAttribute("userID");
            System.out.println("The Session user in jsp is : " + uid);
            User objreturn = null;
            objreturn = DeserializeUser.deserialize(uid);
            System.out.println("The wallpath is :" + objreturn.wallpaper_path);

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>YAID</title>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"JQUERY/jquery.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"JQUERY/jquery.ui.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"JQUERY/jquery.contextMenu.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"JQUERY/jquery.jscroll.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\" src=\"JS/startMenu/jquery.metadata.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"JS/startMenu/jquery.hoverIntent.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"JS/startMenu/mbMenu.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"JS/startMenu/startmenu.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"JS/Window/Window.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"JS/Window/YAIDContext.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"JS/Window/Explorer.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"JS/jquery.jstree.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"JS/ImageViewer/ImageViewer.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"JS/MediaPlayer.js\"></script>\r\n");
      out.write("        <!--        <script type=\"text/javascript\" src=\"JS/jquery.metadata.js\"></script> -->\r\n");
      out.write("        <script type=\"text/javascript\" src=\"JS/YAIDUpload.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"JS/YAIDNotpad.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"JS/Clock/jquery.clock.js\" ></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"JS/Clock/clock.js\" ></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"JS/Calendar/calendar.js\" ></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"JS/DesktopIcons/icons.js\" ></script>\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/jquery.contextMenu.css\" type=\"text/css\" />\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/ui-lightness/jquery-ui-1.8.16.custom.css\" type=\"text/css\" />\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/startmenu/menu_black.css\" media=\"screen\" />  \r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/startmenu/startmenu.css\" media=\"screen\" />\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/Window/window.css\"/>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/Desktop Icons/icons.css\"/>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/Window/explorer.css\"/>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/jquery.fileupload-ui.css\">\r\n");
      out.write("        <style>\r\n");
      out.write("            body{ \r\n");
      out.write("                font: 70.5% \"Trebuchet MS\", sans-serif; \t\t\t\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("            $(document).ready(function() {\r\n");
      out.write("                $('#analog-clock').clock({\r\n");
      out.write("                    offset: '+5.5',\r\n");
      out.write("                    type: 'analog'\r\n");
      out.write("                });\r\n");
      out.write("                $('head').append('<link rel=\"stylesheet\" href=\"CSS/clock/white.css\" type=\"text/css\" />');\r\n");
      out.write("                $('#analog-clock').hide();\r\n");
      out.write("                $('#datepicker').hide();\r\n");
      out.write("                //$('#workarea').css(\"background-image\", \"url(ImageBytes?id=/UserData/vig/My%20Files/WallPaper/dream.jpg)\");\r\n");
      out.write("                $('#workarea').css(\"background-image\", \"url('");
      out.print( objreturn.wallpaper_path);
      out.write("')\");\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            $(function(){\r\n");
      out.write("                $.contextMenu({\r\n");
      out.write("                    selector: '#workarea',\r\n");
      out.write("                    callback: function(key, options) {\r\n");
      out.write("                        if(key == \"folder\") {\r\n");
      out.write("                            ;   //alert('Folder created');\r\n");
      out.write("                        }\r\n");
      out.write("                        else if(key == \"widget\") {\r\n");
      out.write("                            Window({'option':{'title':'Widgets',height:250, width:430},'content':'widget_manager.html',\"ajax\":true});\r\n");
      out.write("                        }\r\n");
      out.write("                        else if(key == \"wallpaper\") {\r\n");
      out.write("                            Window({'option':{'title':'Wallpapers',height:320, width:450},'content':'wallpaper_manager.html',\"ajax\":true});\r\n");
      out.write("                        }\r\n");
      out.write("                        else if(key==\"upload\") {\r\n");
      out.write("                            Window({'option':{'title':'File Upload',height:320, width:450},'content':'JQUERY/fileUpload/fileUpload.html',\"ajax\":true});\r\n");
      out.write("                        }\r\n");
      out.write("                        \r\n");
      out.write("                    },\r\n");
      out.write("                    items: {\r\n");
      out.write("                        \"create\": {\r\n");
      out.write("                            \"name\": \"Create\", \"icon\": \"theme\",\r\n");
      out.write("                            \"items\": {\r\n");
      out.write("                                \"folder\": {\"name\": \"Folder\"},\r\n");
      out.write("                                \"document\": {\"name\": \"Document\"}\r\n");
      out.write("                            }\r\n");
      out.write("                        },\r\n");
      out.write("                        \"widget\" : { \"name\" : \"Widgets\", \"icon\" : \"widget\"},\r\n");
      out.write("                        \"wallpaper\": {\"name\": \"Change Wallpaper\", \"icon\": \"wallpaper\"},\r\n");
      out.write("                        \"upload\": {\"name\": \"Upload Files\", \"icon\": \"upload\"}\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            function hideStartMenu() {\r\n");
      out.write("                if($('#startmenu').is(\":visible\") ) {\r\n");
      out.write("                    $('#startmenu').toggle();\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            function openFileBrowser() {\r\n");
      out.write("                Window({'option':{'title':'Widgets',height:250, width:430},'content':'window.html',\"ajax\":true});\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            function openSettings() {\r\n");
      out.write("                \r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            function openWidgetManager() {\r\n");
      out.write("                Window({'option':{'title':'Widgets',height:250, width:430},'content':'widget_manager.html',\"ajax\":true});\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            function openCalculator() {\r\n");
      out.write("                Window({'option':{'title':'Calculator',height:470, width:500},'content':'Calculator.htm',\"ajax\":true}).draggable();\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            function openTextEditor() {\r\n");
      out.write("                Window({'option':{'title':'Text Editor',height:470, width:500},'content':'Notepad.html',\"ajax\":true}).draggable();\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"workarea\" style=\" position: absolute;top: 0px; left: 0px; right: 0px; bottom: 0px;\" onclick=\"return hideStartMenu()\">\r\n");
      out.write("\r\n");
      out.write("            <ul id=\"IconView\">\r\n");
      out.write("\r\n");
      out.write("            </ul>\r\n");
      out.write("\r\n");
      out.write("            <div id=\"analog-clock\" class=\"analog\">\r\n");
      out.write("                <div class=\"context-menu-clock box menu-1\" style=\"width: 150px; height: 150px;\">\r\n");
      out.write("                    <div class=\"hour\"></div>\r\n");
      out.write("                    <div class=\"min\"></div>\r\n");
      out.write("                    <div class=\"sec\"></div>\r\n");
      out.write("                    <div class=\"meridiem\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class =\"context-menu-calendar box menu-1\" id=\"datepicker\" style=\"width: 50px; position: fixed; left:100px; top:300px;\"></div>\r\n");
      out.write("\r\n");
      out.write("            <div id=\"startmenu\" >\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <div class=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("                    <!-- start vertical menu -->\r\n");
      out.write("                    <div class=\"vertMenu\" style=\"float: left;\">  <!--Left half of start menu -->\r\n");
      out.write("                        <table class=\"rootVoices vertical\" cellspacing='0' cellpadding='0' border='0'>\r\n");
      out.write("                            <tr><td class=\"rootVoice {menu: ''}\"  onclick=\"openFileBrowser()\">Home</td></tr>\r\n");
      out.write("                            <tr><td class=\"rootVoice {menu: 'Menu_L_2'}\" >Settings</td></tr>\r\n");
      out.write("                            <tr><td class=\"rootVoice {menu: 'Menu_L_3'}\"  onclick=\"openWidgetManager()\">Widget Manager</td></tr>\r\n");
      out.write("                        </table>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div id=\"divider_vertical\" style=\"float: left;\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"vertMenu\" style=\"float: left;\">  <!--Right half of start menu -->\r\n");
      out.write("                        <table class=\"rootVoices vertical\" cellspacing='0' cellpadding='0' border='0'>\r\n");
      out.write("                            <tr><td class=\"rootVoice {menu: 'Menu_R_1'}\" >Applications</td></tr>\r\n");
      out.write("                            <tr><td class=\"rootVoice {menu: 'Menu_R_2'}\" >Wallpapers</td></tr>\r\n");
      out.write("\r\n");
      out.write("                        </table>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div id=\"divider_horizontal\">\r\n");
      out.write("                        <a></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div id=\"My_Start_Menu_Base\">\r\n");
      out.write("                        <!--                        <div id=\"My_Start_Menu_Base_Left\">\r\n");
      out.write("                                                    <input type=\"button\" value=\"Home Page\"/>\r\n");
      out.write("                                                </div>-->\r\n");
      out.write("                        <div id=\"My_Start_Menu_Base_Right\">\r\n");
      out.write("                            <form action=\"Logout\" method=\"post\">\r\n");
      out.write("                                <input type=\"submit\" value=\"Log Off\" class=\"submit\" size=\"70px;\"/> \r\n");
      out.write("                            </form>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- end vertical menu -->\r\n");
      out.write("\r\n");
      out.write("                    <!-- menues -->\r\n");
      out.write("                    <div id=\"Menu_R_1\" class=\"mbmenu\">\r\n");
      out.write("                        <a rel=\"title\" >Applications</a>\r\n");
      out.write("                        <a  onclick=\"openCalculator()\">Calculator</a>\r\n");
      out.write("                        <a onclick=\"openTextEditor()\">Text Editor</a>\r\n");
      out.write("                        <!--                        <a rel=\"separator\"> </a>  menuvoice separator-->\r\n");
      out.write("                        <!--                        <a class=\"{menu:'Menu_6'}\">A3</a>\r\n");
      out.write("                                                <a class=\"{menu:'Menu_5', img: '24-book-blue-check.png'}\">A4</a>-->\r\n");
      out.write("                        <a>Image Viewer</a>\r\n");
      out.write("                        <a>Video Player</a>\r\n");
      out.write("                        <a>Audio Player</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <div id=\"Menu_5\" class=\"mbmenu\" >\r\n");
      out.write("                        <a rel=\"text\">\r\n");
      out.write("                            <form>\r\n");
      out.write("                                <!--<img src=\"images/browser.png\" alt=\"img\" style=\"position:absolute;margin-top:-20px; margin-left:-25px;margin-bottom:10px\"/><br/>-->\r\n");
      out.write("                                <input id=\"myInput\" type=\"text\" name=\"tuoTesto\" value=\"you can have input inside\" />\r\n");
      out.write("                                <input type=\"button\" name=\"tuoTesto\" value=\"submit\" onclick=\"$.fn.removeMbMenu($.mbMenu.options.actualOpenedMenu,true);\" />\r\n");
      out.write("                                <table>\r\n");
      out.write("                                    <tr><td><input type=\"checkbox\" checked value=\"aaa\"/></td><td>checkbox 1</td></tr>\r\n");
      out.write("                                    <tr><td><input type=\"checkbox\" value=\"aaa\"/></td><td>checkbox 1</td></tr>\r\n");
      out.write("                                    <tr><td><input type=\"checkbox\" value=\"aaa\"/></td><td>checkbox 1</td></tr>\r\n");
      out.write("                                    <tr><td><input type=\"checkbox\" value=\"aaa\"/></td><td>checkbox 1</td></tr>\r\n");
      out.write("                                </table>\r\n");
      out.write("                                <br>\r\n");
      out.write("                                <br/>* form fields value are not preserved once you close the menu!\r\n");
      out.write("                            </form>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <a rel=\"separator\"> </a>\r\n");
      out.write("                        <a class=\"{action: 'showMessage(\\'menu_3.1\\')', img: 'iconDone.png'}\">menu_3.1</a>\r\n");
      out.write("                        <a id=\"aaa\" class=\"{menu:'sub_menu_2'}\"  >submenu</a>\r\n");
      out.write("                        <a class=\"{action: 'showMessage(\\'menu_3.4\\')'}\">menu_3.4 con testo veramente molto lungo menu_3.4 con testo veramente molto lungo</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div id=\"Menu_6\" class=\"mbmenu\">\r\n");
      out.write("                        <a rel=\"title\" >titleF</a>\r\n");
      out.write("                        <a>F1</a>\r\n");
      out.write("                        <a rel=\"separator\"> </a> <!-- menuvoice separator-->\r\n");
      out.write("                        <a>F2</a>\r\n");
      out.write("                        <a>F3</a>\r\n");
      out.write("                        <a>F4</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"startbuttondiv\" style=\"width: 50px;position: absolute;bottom: 10px;left: 0px;height: 30px; \" >\r\n");
      out.write("            <button id=\"startbutton\" ><img src=\"images/startButton/start.png\" width=\"50px\" height=\"30px\" ></button> \r\n");
      out.write("        </div>\r\n");
      out.write("        <!--<div id=\"taskbar\"  style=\" position: absolute; border: 1px solid; height:20px; bottom: 0px; left: 1px; right: 1px; height: 5%;\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div  id=\"minimizedtasks\" style=\"width: 950px; float: left; border: #000000;\">minimized tasks</div>\r\n");
      out.write("            <div  id=\"notifications\" style=\"width: 200px; float: left; border: #000000;\">notifications</div>\r\n");
      out.write("            <div  id=\"datetime\" style=\"width: 100px; float: left; border: #000000;\">datetime</div> \r\n");
      out.write("        </div>  -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div id=\"dialog_window_minimized_container\" class=\"ui-widget-header ui-corner-all\" onclick=\"return hideStartMenu()\"></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
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
