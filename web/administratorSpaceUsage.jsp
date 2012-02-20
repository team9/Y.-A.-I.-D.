<!DOCTYPE html>
<html>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
    <%@ page import="java.sql.PreparedStatement"  %>
    <%@ page import="java.sql.ResultSet" %>
    <%@ page import="java.sql.Connection" %>
    <%@ page import="java.sql.DriverManager" %>
    <head>
        <script type="text/javascript"  src="JQUERY/jquery.js"></script>
        <script>
            $(document).ready(function (){
            $('#spaceUsageForm').submit(function (data) {
                 var parameters= {
                "targetid":document.getElementById("targetid").value
                };
                if(document.getElementById("targetid").value == "0") {
                    alert("Please choose a user");
                    return false;
                }
                $.ajax({
                    type:'POST',
                    url:"SpaceUsage", //calling servlet
                    cache:false,
                    data:parameters,
                    success:function(htmldat){
                        alert(htmldat);
                    },
                    error:function(xhr,ajaxOptions){
                        alert(xhr.status + " :: " + xhr.statusText);
                    }
                });
            return  false;
            });
            
            });
            
           
        </script>

        <title>Space Usage</title>
    </head>
    <body>
        <div><jsp:include page="administratorPanel.jsp" /></div>
        <!--        <form action="SpaceUsage" method="post" >-->

        Select a user
        <%  Connection conn = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yaid", "vd", "vd");
            ResultSet rsPagination = null;
            ResultSet rsRowCnt = null;

            PreparedStatement psPagination = null;
            PreparedStatement psRowCnt = null;
            psPagination = conn.prepareStatement("SELECT * FROM YAID.USERS");
            rsPagination = psPagination.executeQuery();
        %>
        <div id="chooseUser" >
            <form action="SpaceUsage" method="post" id="spaceUsageForm"  name="spaceUsageForm" >
                <select name="targetid" id="targetid">
                    <option selected="selected" value="0">Please pick a user</option>
                    <% while (rsPagination.next()) {%>
                    <option value="<%=rsPagination.getInt("userid")%>"><%=rsPagination.getInt("userid")%>) <%=rsPagination.getString("email")%></option>
                    <%
                        }
                    %>
                </select>

                <input type="submit" value="Calculate Space Usage" />
            </form>


        </div>
        <div id="personalSpaceUsage">
            sdfsdf
        </div>
        <div id="totalSpaceUsage">
        </div>


    </body>
</html>