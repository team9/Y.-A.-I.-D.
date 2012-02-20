<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ page import="java.sql.PreparedStatement"  %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<script src="JQUERY/jquery.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="CSS/Administrator/administratorViewUsers.css" />
<script type="text/javascript">
    
    //    $(document).ready(function() {
    //        
    //        $("#SelectUser").click(function(){
    //            $.ajax({
    //                    
    //                type: 'POST',
    //                url: "ViewAllUsers",								 
    //                data: "operation=showSingleUser&userid=40",
    //                success: function (){
    //                                
    //                }
    //            });
    //        })
    //    });
                
    //    function showDetails() {
    //        var serial = document.getElementById('userSerialValue').value;
    //        var email =  document.getElementById('userEmailValue').value;
    //        var password =  document.getElementById('userPasswordValue').value;
    //        alert("HAi : " + serial + "   " +email +"   "+ password);
    //        //alert("hai");
    //    }
    
    
   function validateTarget() {
                if( document.getElementById("targetid").value == 0) {
                    alert("Please choose a user!");
                    return false;
                }
                return true;
            }
            
        
</script>

<%!
    public int nullIntconv(String str) {
        int conv = 0;
        if (str == null) {
            str = "0";
        } else if ((str.trim()).equals("null")) {
            str = "0";
        } else if (str.equals("")) {
            str = "0";
        }
        try {
            conv = Integer.parseInt(str);
        } catch (Exception e) {
        }
        return conv;
    }
%>
<%

    Connection conn = null;
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yaid", "vd", "vd");

    ResultSet rsPagination = null;
    ResultSet rsRowCnt = null;

    PreparedStatement psPagination = null;
    PreparedStatement psRowCnt = null;

    int iShowRows = 5;  // Number of records show on per page
    int iTotalSearchRecords = 10;  // Number of pages index shown

    int iTotalRows = nullIntconv(request.getParameter("iTotalRows"));
    int iTotalPages = nullIntconv(request.getParameter("iTotalPages"));
    int iPageNo = nullIntconv(request.getParameter("iPageNo"));
    int cPageNo = nullIntconv(request.getParameter("cPageNo"));

    int iStartResultNo = 0;
    int iEndResultNo = 0;

    if (iPageNo == 0) {
        iPageNo = 0;
    } else {
        iPageNo = Math.abs((iPageNo - 1) * iShowRows);
    }



    String sqlPagination = "SELECT SQL_CALC_FOUND_ROWS * FROM users limit " + iPageNo + "," + iShowRows + "";

    psPagination = conn.prepareStatement(sqlPagination);
    rsPagination = psPagination.executeQuery();

    //// this will count total number of rows
    String sqlRowCnt = "SELECT FOUND_ROWS() as cnt";
    psRowCnt = conn.prepareStatement(sqlRowCnt);
    rsRowCnt = psRowCnt.executeQuery();

    if (rsRowCnt.next()) {
        iTotalRows = rsRowCnt.getInt("cnt");
    }
%>

<title>View Users</title>

</head>
<body>
    <div><jsp:include page="administratorPanel.jsp" /></div>
    <div id="viewUsersLeft">
    <div id="viewList">
        <form name="frm">
            <input type="hidden" name="iPageNo" value="<%=iPageNo%>">
            <input type="hidden" name="cPageNo" value="<%=cPageNo%>">
            <input type="hidden" name="iShowRows" value="<%=iShowRows%>">
            <div width="100%" cellpadding="0" cellspacing="0" border="0" >
                <div  id="headings">
                    <div id="headingSerial">Serial</div>
                    <div id="headingEmail">Email</div>
                    <div id="headingPassword">Password</div>
                </div>
                <%
                    while (rsPagination.next()) {
                %>
                <br/>

                <div id="usersdetails" onclick="return showDetails()">    
                    <div id="userSerial"><%=rsPagination.getInt("userid")%>
                        <input type="hidden" id="userSerialValue" value="<%=rsPagination.getInt("userid")%>"  /> 
                    </div>
                    <div id="userEmail"><%=rsPagination.getString("email")%>
                        <input type="hidden" id="userEmailValue" value="<%=rsPagination.getString("email")%>"  /> 
                    </div>
                    <div id="userPassword"><%=rsPagination.getString("password")%>
                        <input type="hidden" id="userPasswordValue" value="<%=rsPagination.getString("password")%>"  /> 
                    </div>
                </div>
                <%
                    }
                %>
                <br/>

                <%
                    //// calculate next record start record  and end record 
                    try {
                        if (iTotalRows < (iPageNo + iShowRows)) {
                            iEndResultNo = iTotalRows;
                        } else {
                            iEndResultNo = (iPageNo + iShowRows);
                        }

                        iStartResultNo = (iPageNo + 1);
                        iTotalPages = ((int) (Math.ceil((double) iTotalRows / iShowRows)));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                %>
            </div>

        </form>
    </div>
    <div id="pageNavigation">
        <div colspan="3">
            <div>
                <%
                    //// index of pages 

                    int i = 0;
                    int cPage = 0;
                    if (iTotalRows != 0) {
                        cPage = ((int) (Math.ceil((double) iEndResultNo / (iTotalSearchRecords * iShowRows))));

                        int prePageNo = (cPage * iTotalSearchRecords) - ((iTotalSearchRecords - 1) + iTotalSearchRecords);
                        if ((cPage * iTotalSearchRecords) - (iTotalSearchRecords) > 0) {
                %>
                <a href="administratorViewUsers.jsp?iPageNo=<%=prePageNo%>&cPageNo=<%=prePageNo%>"> << Previous</a>
                <%
                    }

                    for (i = ((cPage * iTotalSearchRecords) - (iTotalSearchRecords - 1)); i <= (cPage * iTotalSearchRecords); i++) {
                        if (i == ((iPageNo / iShowRows) + 1)) {
                %>
                <a href="administratorViewUsers.jsp?iPageNo=<%=i%>" style="cursor:pointer;color: red"><b><%=i%></b></a>
                <%
                } else if (i <= iTotalPages) {
                %>
                <a href="administratorViewUsers.jsp?iPageNo=<%=i%>"><%=i%></a>
                <%
                        }
                    }
                    if (iTotalPages > iTotalSearchRecords && i < iTotalPages) {
                %>
                <a href="administratorViewUsers.jsp?iPageNo=<%=i%>&cPageNo=<%=i%>"> >> Next</a> 
                <%
                        }
                    }
                %>
                <b>Rows <%=iStartResultNo%> - <%=iEndResultNo%>   Total Result  <%=iTotalRows%> </b>

            </div>

        </div>
    </div>
</div>


    <div id="verticalSeperator"></div>
    <div id="banUser">
    
            <div id="allDetails">
                Select a user
                <%  psPagination = conn.prepareStatement("SELECT * FROM YAID.USERS");
                    rsPagination = psPagination.executeQuery();
                %>
                <form action="DeleteUser" method="post" id="deleteUser"  onsubmit="return validateTarget()">
                    <select name="targetid" id="targetid">
                        <option selected="selected" value="0">Please pick a user</option>
                        <% while (rsPagination.next()) {%>
                        <option value="<%=rsPagination.getInt("userid")%>"><%=rsPagination.getInt("userid")%>) <%=rsPagination.getString("email")%></option>
                        <%
                            }
                        %>
                    </select>
               
                    <input type="submit" value="Bar this user" />
                </form>




            </div>
       
    </div>
    <div id="horizontalSeperator"></div>



    <%
        try {
            if (psPagination != null) {
                psPagination.close();
            }
            if (rsPagination != null) {
                rsPagination.close();
            }

            if (psRowCnt != null) {
                psRowCnt.close();
            }
            if (rsRowCnt != null) {
                rsRowCnt.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>