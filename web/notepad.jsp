<%-- 
    Document   : notepad
    Created on : 19 Feb, 2012, 3:02:03 PM
    Author     : Amal Joy
--%>

<%@page import="com.yaid.notepad.WriteFile"%>
<%@page import="com.yaid.notepad.ReadFile"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%
            String textdata = "";
            ReadFile rf = new ReadFile();
            textdata = rf.read();
            //out.println(textdata);
            WriteFile wf = new WriteFile();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notepad</title>

        <script type="text/javascript"  src="JQUERY/jquery.js"></script>
        <script type="text/javascript" src="JS/Text Editor/nicEdit.js"></script>

        <script type="text/javascript">
            $(document).ready(function() {
                //nicEditors.allTextAreas();
                new nicEditor({fullPanel : true, onSave : function(content, id, instance) {
                        alert('save button clicked for element '+id+' = '+content)
                    } }).panelInstance('mytxtarea');
            });
            var text = "<%=textdata%>";
            $(function() {
                nicEditors.findEditor('mytxtarea').setContent(text);
            });
        </script>
    </head>

    <body>
        <textarea name="area" id="mytxtarea" cols="80" rows="16"></textarea>
    </body>

</html>
