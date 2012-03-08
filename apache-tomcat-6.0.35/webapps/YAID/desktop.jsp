<%@page import="com.yaid.ser.DeserializeUser"%>
<%@page import="com.yaid.ser.User" %>
<%
    String uid = (String) session.getAttribute("userID");
    
    System.out.println("The Session user in jsp is : " + uid);
    User objreturn = null;
    objreturn = DeserializeUser.deserialize(uid);
    System.out.println("The wallpath is :" + objreturn.wallpaper_path);
%>

<html>
    <head>
        <title>YAID</title>

        <script src="JQUERY/jquery.js" type="text/javascript"></script>
        <script src="JQUERY/jquery.ui.js" type="text/javascript"></script>
        <script src="JQUERY/jquery.contextMenu.js" type="text/javascript"></script>
        <script src="JQUERY/jquery.jscroll.min.js" type="text/javascript"></script>
        <script src="JQUERY/fileupload/jquery.fileupload.js" type="text/javascript"></script>
        <script src="JQUERY/fileupload/jquery.fileupload-ui.js" type="text/javascript"></script>
        <script src="JQUERY/jquery.flash.js" type="text/javascript"></script>
        <script src="JQUERY/flarevideo.js" type="text/javascript"></script> 

        <script type="text/javascript" src="JS/startMenu/jquery.metadata.js"></script>
        <script type="text/javascript" src="JS/startMenu/jquery.hoverIntent.js"></script>
        <script type="text/javascript" src="JS/startMenu/mbMenu.js"></script>
        <script type="text/javascript" src="JS/startMenu/startmenu.js"></script>
        <script type="text/javascript" src="JS/Window/Window.js"></script>
        <script type="text/javascript" src="JS/Window/YAIDContext.js"></script>
        <script type="text/javascript" src="JS/Window/Explorer.js"></script>
        <script type="text/javascript" src="JS/jquery.jstree.js"></script>
        <script type="text/javascript" src="JS/ImageViewer/ImageViewer.js"></script>
        <script type="text/javascript" src="JS/MediaPlayer.js"></script>
        <!--        <script src="http://github.com/malsup/media/raw/master/jquery.media.js?v0.92"></script>-->
        <!--        <script type="text/javascript" src="JS/jquery.metadata.js"></script> -->
        <script type="text/javascript" src="JS/YAIDUpload.js"></script>
        <script type="text/javascript" src="JS/YAIDNotpad.js"></script>
        <script type="text/javascript" src="JS/Clock/jquery.clock.js" ></script>
        <script type="text/javascript" src="JS/Clock/clock.js" ></script>
        <script type="text/javascript" src="JS/Calendar/calendar.js" ></script>
        <script type="text/javascript" src="JS/DesktopIcons/icons.js" ></script>
        <script type="text/javascript" src="JS/TextEditor/nicEdit.js"></script>
        <script type="text/javascript" src="JS/wallpaperMan.js"></script>
        <script type="text/javascript" src="JS/WidgetMan.js"></script>
        <script type="text/javascript" src="JS/openSpaceUsage.js"></script>


        <link rel="stylesheet" href="CSS/jquery.contextMenu.css" type="text/css" />
        <link rel="stylesheet" href="CSS/ui-lightness/jquery-ui-1.8.16.custom.css" type="text/css" />
        <link rel="stylesheet" type="text/css" href="CSS/startmenu/menu_black.css" media="screen" />  
        <link rel="stylesheet" type="text/css" href="CSS/startmenu/startmenu.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="CSS/Window/window.css"/>
        <link rel="stylesheet" type="text/css" href="CSS/Desktop Icons/icons.css"/>
        <link rel="stylesheet" type="text/css" href="CSS/Window/explorer.css"/>
        <link rel="stylesheet" href="CSS/jquery.fileupload-ui.css">
        <link rel="stylesheet" href="CSS/flarevideo.css" type="text/css" />
        <link rel="stylesheet" href="CSS/flarevideo.default.css" type="text/css" />
        <link href="CSS/Calculator/Calculator.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css" href="CSS/User/userSpaceUsage.css" />

        <style>
            body{ 
                font: 70.5% "Trebuchet MS", sans-serif; 			
            }
        </style>
        <script type="text/javascript">
            
            $(document).ready(function() {
                
//                var userSpaceLimit = 2*1024;
//                var parameters= {
//                    "targetid": "85",
//                    "operation" : "getUsersSpaceUsage"
//                };
//                $.ajax({
//                    type:'POST',
//                    url:"SpaceUsage", //calling servlet
//                    cache:false,
//                    data:parameters,
//                    success:function(htmldat){
//                        var userOccupiedSpace = Math.round(htmldat/(1024*1024)*100)/100;
//                        $("#spaceUsageValue").html(userOccupiedSpace + "MB / " + userSpaceLimit + "MB (" + Math.round(userOccupiedSpace/userSpaceLimit*100*1)/1 +"%)");
//                        $("#spaceUsageGraph").progressbar({value:((Math.round(htmldat/(1024*1024)))/userSpaceLimit*100 *1)/1}); 
//                        
//                    },
//                    error:function(xhr,ajaxOptions){
//                        alert(xhr.status + " :: " + xhr.statusText);
//                    }
//                });
//                    
                    
                $('#analog-clock').clock({
                    offset: '+5.5',
                    type: 'analog'
                });
                $('head').append('<link rel="stylesheet" href="CSS/clock/white.css" type="text/css" />');
                
                var clock = "<%=objreturn.clock_set%>";
                var calender = "<%= objreturn.calender_set%>";

                if(clock == "hide") {
                    $('#analog-clock').hide();
                }else if(clock == "show") {
                    $('#analog-clock').show();
                }

                if(calender == "hide") {
                    $('#datepicker').hide();
                } else if(calender == "show") {
                    $('#datepicker').show();
                }

                //$('#workarea').css("background-image", "url(ImageBytes?id=/UserData/vig/My%20Files/WallPaper/dream.jpg)");
                $('#workarea').css("background-image", "url('<%= objreturn.wallpaper_path%>')");
            });

            $(function(){
                $.contextMenu({
                    selector: '#workarea',
                    callback: function(key, options) {
                        if(key == "folder") {
                            ;   //alert('Folder created');
                        }
                        else if(key == "widget") {
                            WidgetMan();
                        }
                        else if(key == "wallpaper") {
                            //                            Window({'option':{'title':'Wallpapers',height:320, width:450},'content':'wallpaper_manager.html',"ajax":true});
                            WallpaperMan();
                        }
                        else if(key=="upload") {
                            Window({'option':{'title':'File Upload',height:320, width:450},'content':'JQUERY/fileUpload/fileUpload.html',"ajax":true});
                        }
                        
                    },
                    items: {
                        //                        "create": {
                        //                            "name": "Create", "icon": "theme",
                        //                            "items": {
                        //                                "folder": {"name": "Folder"},
                        //                                "document": {"name": "Document"}
                        //                            }
                        //                        },
                        "widget" : { "name" : "Widgets", "icon" : "widget"},
                        "wallpaper": {"name": "Change Wallpaper", "icon": "wallpaper"},
                        
                    }
                });
            });


            function hideStartMenu() {
                if($('#startmenu').is(":visible") ) {
                    $('#startmenu').toggle();
                }
            }
            
            function openFileBrowser() {
               new Explorer("/");
            }
            
            
            
            function openWidgetManager() {
                WidgetMan();
            }
            
            function openCalculator() {
                Window({'option':{
                    'title':'Calculator',
                     resizable: false,
                    height:410,
                    width:390
                },
                'content':'Calculator.htm',
                "ajax":true}).draggable();
            }
            
            
            function openTextEditor() {
                Window({'option':{'title':'Text Editor',height:470, width:500},'content':'Notepad.html',"ajax":true}).draggable();
            }
            
            function openWallpapers() {
                WallpaperMan();
            }
            
            
        </script>


    </head>
    <body>

        <div id="workarea" style=" position: absolute;top: 0px; left: 0px; right: 0px; bottom: 0px;" onclick="return hideStartMenu()">

            <ul id="IconView">

            </ul>

            <div id="analog-clock" class="analog">
                <div class="context-menu-clock box menu-1" style="width: 150px; height: 150px;">
                    <div class="hour"></div>
                    <div class="min"></div>
                    <div class="sec"></div>
                    <div class="meridiem"></div>
                </div>
            </div>

            <div class ="context-menu-calendar box menu-1" id="datepicker" style="width: 50px; position: fixed; left:700px; top:300px;"></div>

            <div id="startmenu" >


                <div class="wrapper">
                    <div id="startMenuHeader" ><strong>Start Off !</strong></div>
                    <!-- start vertical menu -->
                    <div class="vertMenu" style="float: left;">  <!--Left half of start menu -->
                        <table class="rootVoices vertical" cellspacing='0' cellpadding='0' border='0'>
                            <tr><td class="rootVoice {menu: 'empty'}"  onclick="openFileBrowser()">Home</td></tr>
                            <tr><td class="rootVoice {menu: 'empty'}" onclick="openSpaceUsage()">Space Usage</td></tr>
                            <tr><td class="rootVoice {menu: 'empty'}"  onclick="openWallpapers()">Wallpapers</td></tr>

                        </table>
                    </div>
                    <div id="divider_vertical" style="float: left;">
                    </div>
                    <div class="vertMenu" style="float: left;">  <!--Right half of start menu -->
                        <table class="rootVoices vertical" cellspacing='0' cellpadding='0' border='0'>
                            <!--                            <tr><td class="rootVoice {menu: 'Menu_R_1'}" >Applications</td></tr>-->
                            <tr><td class="rootVoice {menu: 'empty'}" onclick="openCalculator()">Calculator</td></tr>
                            <tr><td class="rootVoice {menu: 'empty'}"  onclick="openWidgetManager()">Widget Manager</td></tr>

                        </table>
                    </div>
                    <div id="divider_horizontal">
                        <a></a>
                    </div>
                    <div id="My_Start_Menu_Base">
                        <!--                        <div id="My_Start_Menu_Base_Left">
                                                    <input type="button" value="Home Page"/>
                                                </div>-->
                        <div id="My_Start_Menu_Base_Right">
                            <form action="Logout" method="post">
                                <input type="submit" value="" class="submit" size="70px;"/> 
                            </form>
                        </div>
                    </div>
                    <!-- end vertical menu -->

                    <!-- menues -->
<!--                    <div id="Menu_R_1" class="mbmenu">
                        <a rel="title" class="{menu:'', img: '../images/icons/applications.png'}">Applications</a>
                        <a class="{menu:'', img: '../images/icons/calculator.png'}"  onclick="openCalculator()">Calculator</a>

                                                <a rel="separator"> </a>  menuvoice separator
                                                <a class="{menu:'Menu_6'}">A3</a>
                                                <a class="{menu:'Menu_5', img: '24-book-blue-check.png'}">A4</a>

                        <a class="{menu:'', img: '../images/icons/video.png'}">Video Player</a>
                        <a class="{menu:'', img: '../images/icons/audio.png'}">Audio Player</a>
                    </div>-->



                    <!--                    <div id="Menu_5" class="mbmenu" >
                                            <a rel="text">
                                                <form>
                                                    <img src="images/browser.png" alt="img" style="position:absolute;margin-top:-20px; margin-left:-25px;margin-bottom:10px"/><br/>
                                                    <input id="myInput" type="text" name="tuoTesto" value="you can have input inside" />
                                                    <input type="button" name="tuoTesto" value="submit" onclick="$.fn.removeMbMenu($.mbMenu.options.actualOpenedMenu,true);" />
                                                    <table>
                                                        <tr><td><input type="checkbox" checked value="aaa"/></td><td>checkbox 1</td></tr>
                                                        <tr><td><input type="checkbox" value="aaa"/></td><td>checkbox 1</td></tr>
                                                        <tr><td><input type="checkbox" value="aaa"/></td><td>checkbox 1</td></tr>
                                                        <tr><td><input type="checkbox" value="aaa"/></td><td>checkbox 1</td></tr>
                                                    </table>
                                                    <br>
                                                    <br/>* form fields value are not preserved once you close the menu!
                                                </form>
                                            </a>
                                            <a rel="separator"> </a>
                                            <a class="{action: 'showMessage(\'menu_3.1\')', img: 'iconDone.png'}">menu_3.1</a>
                                            <a id="aaa" class="{menu:'sub_menu_2'}"  >submenu</a>
                                            <a class="{action: 'showMessage(\'menu_3.4\')'}">menu_3.4 con testo veramente molto lungo menu_3.4 con testo veramente molto lungo</a>
                                        </div>

                                        <div id="Menu_6" class="mbmenu">
                                            <a rel="title" >titleF</a>
                                            <a>F1</a>
                                            <a rel="separator"> </a>  menuvoice separator
                                            <a>F2</a>
                                            <a>F3</a>
                                            <a>F4</a>
                                        </div>-->

                </div>
            </div>

        </div>
        <div id="taskbar">
            <div id="startbuttondiv" style="width: 50px;position: absolute;bottom: 10px;left: 0px;height: 30px; " >
                <button id="startbutton" ><img src="images/startButton/start.png" width="50px" height="30px" ></button> 
            </div>
            <!--<div id="taskbar"  style=" position: absolute; border: 1px solid; height:20px; bottom: 0px; left: 1px; right: 1px; height: 5%;">



                <div  id="minimizedtasks" style="width: 950px; float: left; border: #000000;">minimized tasks</div>
                <div  id="notifications" style="width: 200px; float: left; border: #000000;">notifications</div>
                <div  id="datetime" style="width: 100px; float: left; border: #000000;">datetime</div> 
            </div>  -->



            <div id="dialog_window_minimized_container" class="ui-widget-header ui-corner-all" style="float: left; height: 35px; font-weight: thick;" onclick="return hideStartMenu()">

<!--                <div id="spaceDetails"  style="padding-top:  10px; border-left: double black; float: right; padding-left:  10px; height: 25px; ">
                    <div id="spaceUsageGraph" style="width: 300px; float: right; border: double black; height: 10px; ">
                    </div>
                    <div id="spaceUsageValue" style="width: 150px; float: right;">
                        
                    </div>
                    <div id="spaceUsageText" style="width: 110px; float: right;">
                        User Space Usage :
                    </div>
                        
                </div>-->
            </div>
        </div>
    </body>
</html>