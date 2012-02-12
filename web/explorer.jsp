<html lang='en'>
    <head>
        <!--<link rel="stylesheet" href="css/ui-lightness/jquery-ui-1.8.16.custom.css" type="text/css" />
        <script src="js/jquery.js"></script>
        <script src="js/jquery.ui.js"></script>-->

        <!--<script type="text/javascript" src="js/jquery.cookie.js"></script>
                <script type="text/javascript" src="js/jquery.hotkeys.js"></script>
        <!--<link type="text/css" rel="stylesheet" href="syntax/!style.css"/>
                <link type="text/css" rel="stylesheet" href="!style.css"/>
                <script type="text/javascript" src="syntax/!script.js"></script>-->

        <script>
            
            var FileExplorer=new Object();
            FileExplorer.explorerData={};
            FileExplorer.path="/";
            FileExplorer.selected=[];
            
            function selectName(){
                var FileName="NewDocument",i=-1,j=1;
                filesInFolder=FileExplorer.explorerData[FileExplorer.path]["contents"];
                do{
                    for(i in filesInFolder){
                        if(filesInFolder[i]["data"]===FileName+j+".txt"){
                            i=filesInFolder.length;
                            break;
                        }
                    }console.log(i+"  "+FileName+j+".txt");
                    if(i===filesInFolder.length){
                        j++;
                    }
                }while(i===filesInFolder.length);
            }
            
            function createNewFile(path,newName,content,operation){
                $.ajax({
                    type: 'GET',
                    url: "FileOperationHandler",								 
                    data: "operation="+operation+"&id=" + encodeURI(path)+"&newname="+
                        encodeURI(newName)+"&content="+encodeURI(content),
                    success: function (htmldir){
                        console.log("new file created.");
                        console.log(htmldir);
                        FileExplorer.explorerData[path]["contents"].push(htmldir);
                        loadFolderElm(FileExplorer.explorerData[path]["contents"],path);
                        //FileExplorer.explorerData[path]={"contents":htmldir,"parrentfolder":parrent};
                        
                    }
                });
            }
            
            function loadFolderElm(htmldir,path){                
                str="";
                for(dat in htmldir){
                    str+='<li id="'+htmldir[dat]['attr']['id']+'" type="'+htmldir[dat]['attr']['rel']+'"><div><img '
                        +'src="'+htmldir[dat]['attr']['img']+'" /><div>'
                        +htmldir[dat]["data"]+'</li>';
                }
                $('.FolderView').html(str);
                
                $('.FolderView li').dblclick(function(){
                    id=$(this).attr('id');
                    if($(this).attr('type')==='folder'){
                        //console.log($(this).attr('id'));
                        makeFolderElm(id.replace("file_",""));
                    }else if($(this).attr('type')==='image'){
                        imageViewer(id.replace("file_",""));
                    }else{
                        console.log(id+' is a file');
                    }
                    //selectId="#"+id.replace("file_","node_")+" ins";
                    //console.log(selectId);
                    //$(selectId).trigger('click');
                });
                $('.FolderView li').click(function(){              
                    $(obj).addClass("selectedElm");
                    if(FileExplorer.selected!=[]){
                        do{ 
                            elm=FileExplorer.selected.pop();
                            $(elm).removeClass("selectedElm");
                        }while(elm);
                    }
                    FileExplorer.selected.push(this);
                });
                FileExplorer.path=path;
                $(".path_text").val(path);
            }
    
            
            function makeFolderElm(path){
                str='';
                parrent=FileExplorer.path;
                console.log(path);
                if(FileExplorer.explorerData[path]==undefined){
                    //get_files
                    $.ajax({
                        type: 'GET',
                        url: "FileOperationHandler",								 
                        data: "operation=get_files&id=" +  encodeURI(path),
                        success: function (htmldir){loadFolderElm(htmldir,path);
                            FileExplorer.explorerData[path]={"contents":htmldir,"parrentfolder":parrent};
                        
                        }
                    });
                }else if(path!=""){
                    loadFolderElm(FileExplorer.explorerData[path]["contents"],path);
                }
                
            }

            $(document).ready(function() {
                $('.FolderView').sortable();
                //$('#FolderView').selectable();
   	
                $(".TreeView").jstree({ 
                    "json_data" : {
                        "ajax" : {
                            "url" : "FileOperationHandler",
                            "success" : function (data) { console.log(data);return data; },
                            "data":function (n){return {
                                    "operation" : "get_folder",
                                    "id" : n.attr ? n.attr("id").replace("node_","") : "/"
                                };
                            }
                        }

                    },
                    "themes": {
                        "theme":"apple",
                        "url" :"CSS/themes/apple/style.css"
                    },
                    "plugins" : [ "themes", "json_data", "ui" ]
                }).bind("select_node.jstree", function (e, data) { //alert();
                    console.log(data.rslt.obj.attr("id").replace("node_",""));
                    makeFolderElm(data.rslt.obj.attr("id").replace("node_",""));
                        
                });
                    
                //Associate a context menue to the FolderView.
                $.contextMenu({
                    selector: '.FolderView li',
                    callback: function(key, options) {
                        if(key == "folder") {
                            //alert('Folder created');
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
                        "rename" : { "name" : "Rename", "icon" : "widget"},
                        "copy" : { "name" : "Copy", "icon" : "widget"},
                        "cut": {"name": "Cut", "icon": "wallpaper"},
                        "delete" : { "name" : "Delete", "icon" : "widget"},
                        "paste" : { "name" : "Paste", "icon" : "widget"},
                        "properties" : { "name" : "Properties", "icon" : "widget"}
                    }
                });
			
                
                //The tool bar at the top.
                $("#toolBar").jScroll({speed : "fast"});
                console.log($("#toolBar"));
                $(".path_text").button();
                $( "#home" ).button({
                    text: false,
                    icons: {
                        primary: "ui-icon-home"
                    }
                }).click(function(){
                    makeFolderElm("/");
                });
                $( "#back" ).button({
                    text: false,
                    icons: {
                        primary: "ui-icon-arrowthick-1-w"
                    }
                }).click(function(){
                    makeFolderElm(FileExplorer.explorerData[FileExplorer.path]["parrentfolder"]);
                });
                $( "#new_file" ).button({
                    text: false,
                    icons: {
                        primary: "ui-icon-document"
                    }
                }).click(function(){
                    FileName="NewDocument";
                    createNewFile(FileExplorer.path,FileName+j+".txt","","make_files");
                });
                $( "#new_folder" ).button({
                    text: false,
                    icons: {
                        primary: "ui-icon-folder-open"
                    }
                }).click(function(){
                    //
                    createNewFile(FileExplorer.path,"NewDirectory","","make_dir");
                });
                $( "#copy" ).button({
                    text: false,
                    icons: {
                        primary: "ui-icon-copy"
                    }
                })

                $( "#delete" ).button({
                    text: false,
                    icons: {
                        primary: "ui-icon-trash"
                    }
                });
                $( "#cut" ).button({
                    text: false,
                    icons: {
                        primary: "ui-icon-scissors"
                    }
                });
                $( "#paste" ).button({
                    text: false,
                    icons: {
                        primary: "ui-icon-clipboard"
                    }
                });
               
                //the home directery is listed.
                makeFolderElm(FileExplorer.path);
            });
   
        </script>
    </head>
    <body>
        <div class="TreeView"></div>
        <div>
            <span class="ui-widget-header ui-corner-all toolbar" id="toolBar">
                <input type="text" class="path_text" />
                <button id="home">Home</button>
                <button id="back">Back</button>
                <button id="new_file">New File</button>
                <button id="new_folder">New Folder</button>
                <button id="delete">Delete</button>
                <button id="cut">Cut</button>
                <button id="copy">Copy</button>
                <button id="paste">Paste</button>

            </span></div>
        <ul class="FolderView">

        </ul>




    </body>
</html>