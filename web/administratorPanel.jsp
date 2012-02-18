

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Administrator Panel</title>
        <link rel="stylesheet" type="text/css" href="CSS/Administrator/administratorPanel.css" />
        <link rel='icon' type='image/gif' href='images/icons/admin.ico'>
    </head>
    <body>
  
        <div id="maindiv">
<div id="logout"><form action="Logout" method="post"><input type="submit" value="Log Off"/></form></div>
            <div id="tabs">
                
                <ul id="tabs">
                    <li id="tab1"><a href="administratorViewUsers.jsp">View Users</a></li>
                    <li id="tab2"><a href="administratorProfile.jsp">My Profile</a></li>
                    <li id="tab3"><a href="administratorSpaceUsage.jsp">Space Usage</a></li>

                </ul>
            </div>

        </div>

    </body>
</html>
