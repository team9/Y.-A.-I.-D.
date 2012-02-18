package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;

public final class index_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


public int nullIntconv(String str)
{   
    int conv=0;
    if(str==null)
    {
        str="0";
    }
    else if((str.trim()).equals("null"))
    {
        str="0";
    }
    else if(str.equals(""))
    {
        str="0";
    }
    try{
        conv=Integer.parseInt(str);
    }
    catch(Exception e)
    {
    }
    return conv;
}

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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');


    Connection conn = null;
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yaid","root", "root");

    ResultSet rsPagination = null;
    ResultSet rsRowCnt = null;
    
    PreparedStatement psPagination=null;
    PreparedStatement psRowCnt=null;
    
    int iShowRows=5;  // Number of records show on per page
    int iTotalSearchRecords=10;  // Number of pages index shown
    
    int iTotalRows=nullIntconv(request.getParameter("iTotalRows"));
    int iTotalPages=nullIntconv(request.getParameter("iTotalPages"));
    int iPageNo=nullIntconv(request.getParameter("iPageNo"));
    int cPageNo=nullIntconv(request.getParameter("cPageNo"));
    
    int iStartResultNo=0;
    int iEndResultNo=0;
    
    if(iPageNo==0)
    {
        iPageNo=0;
    }
    else{
        iPageNo=Math.abs((iPageNo-1)*iShowRows);
    }
    

    
    String sqlPagination="SELECT SQL_CALC_FOUND_ROWS * FROM users limit "+iPageNo+","+iShowRows+"";

    psPagination=conn.prepareStatement(sqlPagination);
    rsPagination=psPagination.executeQuery();
    
    //// this will count total number of rows
     String sqlRowCnt="SELECT FOUND_ROWS() as cnt";
     psRowCnt=conn.prepareStatement(sqlRowCnt);
     rsRowCnt=psRowCnt.executeQuery();
     
     if(rsRowCnt.next())
      {
         iTotalRows=rsRowCnt.getInt("cnt");
      }

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Pagination of JSP page</title>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<form name=\"frm\">\n");
      out.write("<input type=\"hidden\" name=\"iPageNo\" value=\"");
      out.print(iPageNo);
      out.write("\">\n");
      out.write("<input type=\"hidden\" name=\"cPageNo\" value=\"");
      out.print(cPageNo);
      out.write("\">\n");
      out.write("<input type=\"hidden\" name=\"iShowRows\" value=\"");
      out.print(iShowRows);
      out.write("\">\n");
      out.write("<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" >\n");
      out.write("<tr>\n");
      out.write("<td>Serial</td>\n");
      out.write("<td>Email</td>\n");
      out.write("<td>Password</td>\n");
      out.write("</tr>\n");

  while(rsPagination.next())
  {
  
      out.write("\n");
      out.write("    <tr>\n");
      out.write("        <td>");
      out.print(rsPagination.getInt("userid"));
      out.write("</td>\n");
      out.write("      <td>");
      out.print(rsPagination.getString("email"));
      out.write("</td>\n");
      out.write("      <td>");
      out.print(rsPagination.getString("password"));
      out.write("</td>\n");
      out.write("    </tr>\n");
      out.write("    ");
 
 }
 
      out.write('\n');

  //// calculate next record start record  and end record 
        try{
            if(iTotalRows<(iPageNo+iShowRows))
            {
                iEndResultNo=iTotalRows;
            }
            else
            {
                iEndResultNo=(iPageNo+iShowRows);
            }
           
            iStartResultNo=(iPageNo+1);
            iTotalPages=((int)(Math.ceil((double)iTotalRows/iShowRows)));
        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


      out.write("\n");
      out.write("<tr>\n");
      out.write("<td colspan=\"3\">\n");
      out.write("<div>\n");

        //// index of pages 
        
        int i=0;
        int cPage=0;
        if(iTotalRows!=0)
        {
        cPage=((int)(Math.ceil((double)iEndResultNo/(iTotalSearchRecords*iShowRows))));
        
        int prePageNo=(cPage*iTotalSearchRecords)-((iTotalSearchRecords-1)+iTotalSearchRecords);
        if((cPage*iTotalSearchRecords)-(iTotalSearchRecords)>0)
        {
         
      out.write("\n");
      out.write("          <a href=\"index.jsp?iPageNo=");
      out.print(prePageNo);
      out.write("&cPageNo=");
      out.print(prePageNo);
      out.write("\"> << Previous</a>\n");
      out.write("         ");

        }
        
        for(i=((cPage*iTotalSearchRecords)-(iTotalSearchRecords-1));i<=(cPage*iTotalSearchRecords);i++)
        {
          if(i==((iPageNo/iShowRows)+1))
          {
          
      out.write("\n");
      out.write("           <a href=\"index.jsp?iPageNo=");
      out.print(i);
      out.write("\" style=\"cursor:pointer;color: red\"><b>");
      out.print(i);
      out.write("</b></a>\n");
      out.write("          ");

          }
          else if(i<=iTotalPages)
          {
          
      out.write("\n");
      out.write("           <a href=\"index.jsp?iPageNo=");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</a>\n");
      out.write("          ");
 
          }
        }
        if(iTotalPages>iTotalSearchRecords && i<iTotalPages)
        {
         
      out.write("\n");
      out.write("         <a href=\"index.jsp?iPageNo=");
      out.print(i);
      out.write("&cPageNo=");
      out.print(i);
      out.write("\"> >> Next</a> \n");
      out.write("         ");

        }
        }
      
      out.write("\n");
      out.write("<b>Rows ");
      out.print(iStartResultNo);
      out.write(' ');
      out.write('-');
      out.write(' ');
      out.print(iEndResultNo);
      out.write("   Total Result  ");
      out.print(iTotalRows);
      out.write(" </b>\n");
      out.write("</div>\n");
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("</form>\n");
      out.write("</body>\n");
      out.write("</html>\n");

    try{
         if(psPagination!=null){
             psPagination.close();
         }
         if(rsPagination!=null){
             rsPagination.close();
         }
         
         if(psRowCnt!=null){
             psRowCnt.close();
         }
         if(rsRowCnt!=null){
             rsRowCnt.close();
         }
         
         if(conn!=null){
          conn.close();
         }
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }

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
