<html>
    <head>
        <title>YAID</title>

        <script src="JQUERY/jquery.js" type="text/javascript"></script>
        <script src="JQUERY/jquery.ui.js" type="text/javascript"></script>
        <script src="JQUERY/jquery.contextMenu.js" type="text/javascript"></script>

        <script type="text/javascript" src="JS/startMenu/jquery.metadata.js"></script>
        <script type="text/javascript" src="JS/startMenu/jquery.hoverIntent.js"></script>
        <script type="text/javascript" src="JS/startMenu/mbMenu.js"></script>
        <script type="text/javascript" src="JS/startMenu/startmenu.js"></script>
        <script type="text/javascript" src="JS/Window/Window.js"></script>
        <script type="text/javascript" src="JS/Clock/jquery.clock.js" ></script>
        <script type="text/javascript" src="JS/Clock/clock.js" ></script>
        <script type="text/javascript" src="JS/Calendar/calendar.js" ></script>
        <script type="text/javascript" src="JS/Desktop Icons/icons.js" ></script>

        <link rel="stylesheet" href="CSS/jquery.contextMenu.css" type="text/css" />
        <link rel="stylesheet" href="CSS/ui-lightness/jquery-ui-1.8.16.custom.css" type="text/css" />
        <link rel="stylesheet" type="text/css" href="CSS/startmenu/menu_black.css" media="screen" />  
        <link rel="stylesheet" type="text/css" href="CSS/startmenu/startmenu.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="CSS/Window/window.css"/>
        <link rel="stylesheet" type="text/css" href="CSS/Desktop Icons/icons.css"/>

        <script type="text/javascript">

            $(document).ready(function() {
                $('#analog-clock').clock({
                    offset: '+5.5',
                    type: 'analog'
                });
                $('head').append('<link rel="stylesheet" href="CSS/clock/white.css" type="text/css" />');
                $('#analog-clock').hide();
                $('#datepicker').hide();
                $('#workarea').css("background-image", "url(ImageBytes?id=/UserData/vig/My%20Files/WallPaper/dream.jpg)");
            });

            $(function(){
                $.contextMenu({
                    selector: '#workarea',
                    callback: function(key, options) {
                        if(key == "folder") {
                            ;   //alert('Folder created');
                        }
                        else if(key == "widget") {
                            Window({'option':{'title':'Widgets',height:250, width:430},'content':'widget_manager.html',"ajax":true});
                        }
                        else if(key == "wallpaper") {
                            Window({'option':{'title':'Wallpapers',height:320, width:450},'content':'wallpaper_manager.html',"ajax":true});
                        }
                        
                    },
                    items: {
                        "create": {
                            "name": "Create", "icon": "theme",
                            "items": {
                                "folder": {"name": "Folder"},
                                "document": {"name": "Document"}
                            }
                        },
                        "widget" : { "name" : "Widgets", "icon" : "widget"},
                        "wallpaper": {"name": "Change Wallpaper", "icon": "wallpaper"}
                    }
                });
            });


            function hideStartMenu() {
                if($('#startmenu').is(":visible") ) {
                    $('#startmenu').toggle();
                }
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

            <div class ="context-menu-calendar box menu-1" id="datepicker" style="width: 50px; position: fixed; left:100px; top:300px;"></div>

            <div id="startmenu" >


                <div class="wrapper">

                    <!-- start vertical menu -->
                    <div class="vertMenu" style="float: left;">
                        <table class="rootVoices vertical" cellspacing='0' cellpadding='0' border='0'>
                            <tr><td class="rootVoice {menu: 'Menu_0_1'}" >My Space</td></tr>
                            <tr><td class="rootVoice {menu: 'Menu_0_2'}" >Settings</td></tr>
                            <tr><td class="rootVoice {menu: 'Menu_0_3'}" >Widget Manager</td></tr>
                        </table>
                    </div>
                    <div id="divider_vertical" style="float: left;">
                    </div>
                    <div class="vertMenu" style="float: left;">
                        <table class="rootVoices vertical" cellspacing='0' cellpadding='0' border='0'>
                            <tr><td class="rootVoice {menu: 'Menu_0_1'}" >Applications</td></tr>
                            <tr><td class="rootVoice {menu: 'Menu_0_2'}" >Wallpapers</td></tr>

                        </table>
                    </div>
                    <div id="divider_horizontal">
                        <a></a>
                    </div>
                    <div id="My_Start_Menu_Base">
                        <div id="My_Start_Menu_Base_Left">
                            <input type="button" value="Home Page" />
                        </div>
                        <div id="My_Start_Menu_Base_Right">
                            <input type="button" value="Log Off"  size="80px"/>
                        </div>
                    </div>
                    <!-- end vertical menu -->

                    <!-- menues -->
                    <div id="Menu_0_1" class="mbmenu">
                        <a rel="title" >titleA</a>
                        <a>A1</a>
                        <a>A2</a>
                        <a rel="separator"> </a> <!-- menuvoice separator-->
                        <a class="{menu:'Menu_6'}">A3</a>
                        <a class="{menu:'Menu_5', img: '24-book-blue-check.png'}">A4</a>
                    </div>



                    <div id="Menu_5" class="mbmenu" >
                        <a rel="text">
                            <form>
                                <!--<img src="images/browser.png" alt="img" style="position:absolute;margin-top:-20px; margin-left:-25px;margin-bottom:10px"/><br/>-->
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
                        <a rel="separator"> </a> <!-- menuvoice separator-->
                        <a>F2</a>
                        <a>F3</a>
                        <a>F4</a>
                    </div>

                </div>
            </div>

        </div>

        <div id="startbuttondiv" style="width: 50px;position: absolute;bottom: 10px;left: 0px;height: 30px; " >
            <button id="startbutton" ><img src="images/startButton/start.png" width="50px" height="30px" ></button> 
        </div>
        <!--<div id="taskbar"  style=" position: absolute; border: 1px solid; height:20px; bottom: 0px; left: 1px; right: 1px; height: 5%;">
            

            
            <div  id="minimizedtasks" style="width: 950px; float: left; border: #000000;">minimized tasks</div>
            <div  id="notifications" style="width: 200px; float: left; border: #000000;">notifications</div>
            <div  id="datetime" style="width: 100px; float: left; border: #000000;">datetime</div> 
        </div>  -->



        <div id="dialog_window_minimized_container" class="ui-widget-header ui-corner-all" onclick="return hideStartMenu()"></div>


    </body>
</html>