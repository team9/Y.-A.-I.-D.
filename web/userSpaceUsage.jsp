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
        <link rel="stylesheet" type="text/css" href="CSS/User/userSpaceUsage.css" />
        <script>
            var serverCapacity = 2*1024;
            $(document).ready(function (){
                var htmldat;
                var parameters1= {
                    "targetid":"85",
                    "operation" : "getUsersSpaceUsage"
                };
                $.ajax({
                    type:'POST',
                    url:"SpaceUsage", //calling servlet
                    cache:false,
                    data:parameters1,
                    success:function(htmldat){
                        //alert("Size" + htmldat );
                        $("#usedSpace").html(Math.round(htmldat/(1024*1024)*100)/100 + "MB");
                        $("#personalSpaceUsageGraph").progressbar({value:((Math.round(htmldat/(1024*1024)))/serverCapacity*100 *1)/1}); 
                        
                    },
                    error:function(xhr,ajaxOptions){
                        alert(xhr.status + " :: " + xhr.statusText);
                    }
                });
            });
            
           
        </script>

        <title>Space Usage</title>
    </head>
    <body>







        <div id="personalSpaceUsage">
            
                
                <div id="personalSpaceUsageValue">
                    <div class="row"><div class="data"> Alloted space </div><div class="data">MB</div></div>
                    <div class="row"><div  class="data"> Used space </div><div id="usedSpace" class="data">MB</div></div>
                    <div class="row"><div class="data"> Free space </div><div class="data">MB</div></div>
                    <div class="row"><div class="data"> Percentage used </div><div class="data">MB</div></div>
                    <div class="row"><div class="data"> Percentage used </div><div class="data">MB</div></div>
                </div>
            </div>
            <div id="personalSpaceUsageGraph" >
            </div>
        

    </body>
</html>