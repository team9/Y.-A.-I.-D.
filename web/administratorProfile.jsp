<%-- 
    Document   : viewUsers
    Created on : 17 Feb, 2012, 10:42:11 PM
    Author     : TTT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="CSS/Administrator/administratorProfile.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrator Profile</title>
        <script type="text/javascript"  src="JQUERY/jquery.js"></script>


        <script>
            $(document).ready(function (){
                $('#newPasswordDetails').submit(function (data) {
                 
                    if(document.getElementById("oldPassword").value =="" || document.getElementById("newPassword").value =="" || document.getElementById("confirmPassword").value == "") {
                        alert("None of the fields can be empty !!!");
                        return false;
                    }
                    if(document.getElementById("newPassword").value != document.getElementById("confirmPassword").value) {
                        alert("New password and Confirm password do not match !!!");
                        return false;
                    }

                });
            });
        </script>
    </head>
    <body>
        <div><jsp:include page="administratorPanel.jsp" /></div>
        <div id="page">
        <h2>Administrator Profile</h2>
        <div id="header"></div>
        <div id="descrption" style="height:  50px;">
            Kindly enter your password details
        </div>
        <div id="passwordChangeDetails" >
            <form id="newPasswordDetails" name="newPasswordDetails" action="ChangeAdministratorProfile" method="post">
                <div style="width: 400px;">
                    <div style="width: 200px; float: left; ">Old Password :</div>
                    <div style="width: 200px; float: left;"><input type="password" name="oldPassword" id="oldPassword" /></div>
                </div>
                <div style="width: 400px;">
                    <div style="width: 200px; float: left;">New Password : </div>
                    <div style="width: 200px; float: left;"><input type="password"  name="newPassword" id="newPassword" /></div>
                </div>
                <div style="width: 400px;">
                    <div style="width: 200px; float: left;">Confirm Password :</div>
                    <div style="width: 200px; float: left; "><input type="password"  name="confirmPassword" id="confirmPassword" /></div>
                </div>
                <div style="width: 400px; height: 120px;">

                </div>
                <div style="width: 400px; height: 50px; vertical-align: middle;">
                    <center>
                        <input type="submit" value="Save Changes" />
                    </center>
                </div>
            </form>
        </div>
        <div id="footer"></div>
        </div>
    </body>
</html>
