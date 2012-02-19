<%-- 
    Document   : notepad
    Created on : 19 Feb, 2012, 3:02:03 PM
    Author     : Amal Joy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notepad</title>
        <script type="text/javascript"  src="JQUERY/jquery.js"></script>
        <script type="text/javascript" src="JS/Text Editor/nicEdit.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {nicEditors.allTextAreas() });
        </script>
    </head>
    <body>
        <form name ="notepad">
        <textarea name="area" cols="80" rows="16"></textarea>
        <input type="button" value="Add New Text" onClick="addtext();">
        </form>
    </body>
</html>
