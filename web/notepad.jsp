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
        <script type="text/javascript" src="JS/TextEditor/nicEdit.js"></script>

        <script type="text/javascript">

            $(document).ready(function() {
                //nicEditors.allTextAreas();
                new nicEditor({fullPanel : true, onSave : function(content, id, instance) {
                        var dataSave= "path=./UserData/manu/Home/hello.txt&operation=save&data="+content;
                        $.ajax({
                            type:'POST',
                            url:"FileServlet", //calling servlet
                            cache:false,
                            data:dataSave,
                            success:function(htmldat){},
                            error:function(xhr,ajaxOptions){
                                alert(xhr.status + " :: " + xhr.statusText);
                            }
                        });
                    } }).panelInstance('mytxtarea');
            });

            $(function() {
                var dataOpen= "path=./UserData/manu/Home/hello.txt&operation=open";
                $.ajax({
                    type:'POST',
                    url:"FileServlet", //calling servlet
                    cache:false,
                    data:dataOpen,
                    success:function(readtext){ nicEditors.findEditor('mytxtarea').setContent(readtext); },
                    error:function(xhr,ajaxOptions){
                        alert(xhr.status + " :: " + xhr.statusText);
                    }
                });
            });

        </script>
    </head>

    <body>
        <textarea name="area" id="mytxtarea" cols="88" rows="16"></textarea>
    </body>

</html>
