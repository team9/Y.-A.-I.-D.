<!DOCTYPE html>
<html>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
    <%@ page import="java.sql.PreparedStatement"  %>
    <%@ page import="java.sql.ResultSet" %>
    <%@ page import="java.sql.Connection" %>
    <%@ page import="java.sql.DriverManager" %>
    <head>
        <script type="text/javascript"  src="JQUERY/jquery.js"></script>
        <script type="text/javascript"  src="JQUERY/jquery.ui.js"></script>
        <link rel="stylesheet" href="CSS/ui-lightness/jquery-ui-1.8.16.custom.css" type="text/css" />
        <link rel="stylesheet" type="text/css" href="CSS/Administrator/administratorSpaceUsage.css" />
        <script>
            var serverCapacity = 2*1024;
            $(document).ready(function (){
                $("#personalSpaceUsageValue").html("Please choose a user from the above drop-downlist");
                //----------- Display Personal Space usage on request ------------ //
            
                $('#spaceUsageForm').submit(function (data) {
                    var parameters= {
                        "targetid":document.getElementById("targetid").value,
                        "operation" : "getUsersSpaceUsage"
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
                            //alert("Size" + htmldat );
                            $("#personalSpaceUsageValue").html(Math.round(htmldat/(1024*1024)*100)/100 + "MB");
                            $("#personalSpaceUsageGraph").progressbar({value:((Math.round(htmldat/(1024*1024)))/serverCapacity*100 *1)/1}); 
                        
                        },
                        error:function(xhr,ajaxOptions){
                            alert(xhr.status + " :: " + xhr.statusText);
                        }
                    });
                    return  false;
                });
            
                //----------- end ------------ //
            
                //----------- Display Server Space usage automaticall ------------ //
                var parameters= {
                    "operation" : "getServerSpaceUsage"
                };
                $.ajax({
                    type:'POST',
                    url:"SpaceUsage", //calling servlet
                    cache:false,
                    data:parameters,
                    success:function(htmldat){
                        //alert("Size" + htmldat );
                        $("#serverSpaceUsageValue").append(Math.round(htmldat/(1024*1024)*100)/100 + "MB");
                        $("#serverSpaceUsageGraph").progressbar({value: ((Math.round(htmldat/(1024*1024)))/serverCapacity*100 *1)/1  }); 
                        
                    },
                    error:function(xhr,ajaxOptions){
                        alert(xhr.status + " :: " + xhr.statusText);
                    }
                });
                //----------- end ------------ //
            
            });
            
           
        </script>

        <title>Space Usage</title>
    </head>
    <body>
        <div><jsp:include page="administratorPanel.jsp" /></div>
        <!--        <form action="SpaceUsage" method="post" >-->


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
            <div style="width: 100px; float: left;">Select a user</div>
            <div style="float: left">
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
        </div>
        <div id="seperator1">
        </div>
        <div id="personalSpaceUsage">
            <div id="personalSpaceUsageDetails" >
                <div style="width:170px; float: left;">   Personal Space Usage : 
                </div>
                <div id="personalSpaceUsageValue">
                </div>
            </div>
            <div id="personalSpaceUsageGraph" >
            </div>
        </div>
        <div id="seperator2">
        </div>
        <div id="serverSpaceUsage">
            <div id="serverSpaceUsageDetails" >
                <div style="width:170px; float: left;">   Server Space Usage : 
                </div>
                <div id="serverSpaceUsageValue">
                </div>
            </div>

            <div id="serverSpaceUsageGraph" >

            </div>
        </div>


    </body>
</html>