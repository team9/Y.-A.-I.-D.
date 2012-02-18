<%-- 
    Document   : viewUsers
    Created on : 17 Feb, 2012, 10:42:11 PM
    Author     : TTT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/Administrator/administratorViewUsers.css" />
        <title>View Users</title>
        
        
        <script>
            $(document).ready(function() {                        // When the HTML DOM is ready loading, then execute the following function...
                              // Locate HTML DOM element with ID "somebutton" and assign the following function to its "click" event...
                    $.get('ViewAllUsers', function(responseText) { // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
                        $('#users').text(responseText);         // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
                    });
                });
        
        </script>
        
    </head>
    <body>
        <div><jsp:include page="administratorPanel.jsp" /></div>
        <h1>Users</h1>
        <div id="header"></div>
        <div id="users" >
            

            <form action="ViewAllUsers" method="post">
                <input type="submit" value="View All"/>
            </form>



        </div>
        <div id="footer"></div>
    </body>
</html>
