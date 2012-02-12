/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function Explorer(div_id,path){
    //$(document).ready(function() {
    this.div_id=div_id;
    this.window=$('#windowe_content'+ div_id);
    
    this.explorerData={};
    this.path=path;
    this.selected=[];
    this.clipBoard={};

    
    htmlStr="<div class=\"TreeView\" id=\"TreeView"+ div_id +"\"></div>"+
    "<div>"+
    "<span class=\"ui-widget-header ui-corner-all toolbar\" id=\"toolBar"+ div_id +"\">"+
    "<input type=\"text\" class=\"path_text\" id=\"path_text"+ div_id +"\" />"+
    "<button id=\"home"+ div_id +"\">Home</button>"+
    "<button id=\"back"+ div_id +"\">Back</button>"+
    "<button id=\"new_file"+ div_id +"\">New File</button>"+
    "<button id=\"new_folder"+ div_id +"\">New Folder</button>"+
    "<button id=\"delete"+ div_id +"\">Delete</button>"+
    "<button id=\"cut"+ div_id +"\">Cut</button>"+
    "<button id=\"copy"+ div_id +"\">Copy</button>"+
    "<button id=\"paste"+ div_id +"\">Paste</button>"+

    "</span></div>"+
    "<ul class=\"FolderView\" id=\"FolderView"+ div_id +"\">"+

    "</ul>"
    this.window.append(htmlStr);
    var explore=this;
    
    
    $(function(){
        $('#FolderView'+ div_id ).sortable();
        
        $("#TreeView"+ div_id ).jstree({ 
            "json_data" : {
                "ajax" : {
                    "url" : "FileOperationHandler",
                    "success" : function (data) {
                        for(dat in data){
                            data[dat]['attr']['id']=div_id+data[dat]['attr']['id'];
                        }
                        return data;
                    },
                    "data":function (n){
                        return {
                            "operation" : "get_folder",
                            "id" : n.attr ? n.attr("id").replace(div_id +"node_","") : "/"
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
            //console.log(data.rslt.obj.attr("id").replace(div_id+"node_",""));
            console.log(explore);
            explore.makeFolderElm(data.rslt.obj.attr("id").replace(div_id+"node_",""));
                        
        });

        //Associate a context menue to the FolderView.
        $.contextMenu({
            selector: '#FolderView'+ div_id+' li',
            callback: function(key, options) {
                //explore.selectFile(this,null);
                console.log(key,options,this);
                if(key == "rename") {
                    explore.fileRename(this);
                }
                else if(key == "widget") {
                    Window({
                        'option':{
                            'title':'Widgets',
                            height:250, 
                            width:430
                        },
                        'content':'widget_manager.html',
                        "ajax":true
                    });
                }
                else if(key == "wallpaper") {
                    Window({
                        'option':{
                            'title':'Wallpapers',
                            height:320, 
                            width:450
                        },
                        'content':'wallpaper_manager.html',
                        "ajax":true
                    });
                }
                        
            },
            items: {
                "create": {
                    "name": "Create", 
                    "icon": "theme",
                    "items": {
                        "folder": {
                            "name": "Folder"
                        },
                        "document": {
                            "name": "Document"
                        }
                    }
                },
                "rename" : {
                    "name" : "Rename", 
                    "icon" : "widget"
                },
                "copy" : {
                    "name" : "Copy", 
                    "icon" : "widget"
                },
                "cut": {
                    "name": "Cut", 
                    "icon": "wallpaper"
                },
                "delete" : {
                    "name" : "Delete", 
                    "icon" : "widget"
                },
                "paste" : {
                    "name" : "Paste", 
                    "icon" : "widget"
                },
                "properties" : {
                    "name" : "Properties", 
                    "icon" : "widget"
                }
            }
        });
        
        //toolbar related stuff.
        $("#toolBar"+ div_id ).jScroll({
            speed : "fast"
        });
        //console.log($("#toolBar"+ div_id));
        $("#path_text"+ div_id).button();
        $( "#home" + div_id).button({
            text: false,
            icons: {
                primary: "ui-icon-home"
            }
        }).click(function(){
            explore.makeFolderElm("/");
        });
        $( "#back" + div_id).button({
            text: false,
            icons: {
                primary: "ui-icon-arrowthick-1-w"
            }
        }).click(function(){
            explore.makeFolderElm(explore.explorerData[explore.path]["parrentfolder"]);
        });
        $( "#new_file" + div_id ).button({
            text: false,
            icons: {
                primary: "ui-icon-document"
            }
        }).click(function(){
            FileName=explore.selectName("NewDocument",".txt");        
            explore.createNewFile(explore.path,FileName,"","make_files");
        });
        $( "#new_folder" + div_id).button({
            text: false,
            icons: {
                primary: "ui-icon-folder-open"
            }
        }).click(function(){
            //
            explore.createNewFile(explore.path,"NewDirectory","","make_dir");
        });
        $( "#copy" + div_id).button({
            text: false,
            icons: {
                primary: "ui-icon-copy"
            }
        }).click(function(){
            explore.copyFiles();
        });

        $( "#delete" + div_id).button({
            text: false,
            icons: {
                primary: "ui-icon-trash"
            }
        });
        $( "#cut" + div_id).button({
            text: false,
            icons: {
                primary: "ui-icon-scissors"
            }
        }).click(function(){
            explore.cutFiles();
        });
        $( "#paste" + div_id).button({
            text: false,
            icons: {
                primary: "ui-icon-clipboard"
            }
        });
        explore.makeFolderElm(path);
    });
}

Explorer.prototype.makeFolderElm = function(path){
    str='';
    parrent=this.path;
    console.log(path);
    var explore=this;
    if(this.explorerData[path]==undefined){
        //get_files
        $.ajax({
            type: 'GET',
            url: "FileOperationHandler",								 
            data: "operation=get_files&id=" +  encodeURI(path),
            success: function (htmldir){
                explore.loadFolderElm(htmldir,path);
                explore.explorerData[path]={
                    "contents":htmldir,
                    "parrentfolder":parrent
                };
                        
            }
        });
    }else if(path!=""){
        explore.loadFolderElm(explore.explorerData[path]["contents"],path);
    }
};

Explorer.prototype.loadFolderElm=function(htmldir,path){
    var explore=this;
    str="";
    for(dat in htmldir){
        str+='<li id="'+explore.div_id+htmldir[dat]['attr']['id']+'" type="'+htmldir[dat]['attr']['rel']+'"><div><img '
        +'src="'+htmldir[dat]['attr']['img']+'" /><div id="text_'+explore.div_id+htmldir[dat]['attr']['id']+'" >'
        +htmldir[dat]["data"]+'</li>';
    }
    $('#FolderView'+ explore.div_id).html(str);
    
    //associate various actions to clicks.
    $('#FolderView'+ explore.div_id +' li').dblclick(function(){
        id=$(this).attr('id');
        if($(this).attr('type')==='folder'){
            //console.log($(this).attr('id'));
            explore.makeFolderElm(id.replace(explore.div_id+"file_",""));
        }else if($(this).attr('type')==='image'){
            imageViewer(id.replace(explore.div_id+"file_",""));
        }else{
            console.log(id+' is a file');
        }
    }).mousedown(function(event) {
        /*if (e.which === 3) {
            explore.selectFile(this,e);
        } */
        explore.selectFile(this,event);
    });

    this.path=path;
    $("#path_text"+ this.div_id).val(path);
};

Explorer.prototype.selectName= function (fileName,extn){
    var i=-1,j=1,explorer=this;
    filesInFolder=explorer.explorerData[explorer.path]["contents"];
    do{
        for(i=0 ;i<filesInFolder.length;i++){
            if(filesInFolder[i]["data"]===fileName+j+extn){
                j++;
                break;
            }
        }
        console.log(i+"  "+fileName+j+extn);
        if(i===filesInFolder.length){
            break;
        }
    }while(true);
    return fileName+j+extn;
};

Explorer.prototype.createNewFile=function (path,newName,content,operation){
    var explorer=this;
    $.ajax({
        type: 'GET',
        url: "FileOperationHandler",								 
        data: "operation="+operation+"&id=" + encodeURI(path)+"&newname="+
        encodeURI(newName)+"&content="+encodeURI(content),
        success: function (htmldir){
            console.log("new file created.");
            console.log(htmldir);
            explorer.explorerData[path]["contents"].push(htmldir);
            explorer.loadFolderElm(explorer.explorerData[path]["contents"],path);
        //FileExplorer.explorerData[path]={"contents":htmldir,"parrentfolder":parrent};
                        
        }
    });
};

Explorer.prototype.fileRename = function (oldFile){
    explore=this;
    var renameReq=function(newName){
        if(newName!=val){
            path=oldFile.attr("id").replace(explore.div_id+"file_","")
            newNamePath=explore.path+"/"+newName;
            console.log(newName);
            $.ajax({
                type: 'GET',
                url: "FileOperationHandler",								 
                data: "operation=rename_files&id=" +  encodeURI(path)+"&newname="+encodeURI(newNamePath),
                success: function (htmldir){
                    console.log(htmldir);
                    if(htmldir['status']=="success"){
                        id.html(newName);
                    }else {
                        id.html(val);
                    }
                },
                error: function(jqXHR, textStatus, errorThrown){
                    console.log(jqXHR, textStatus, errorThrown)
                }
            });
        }else {
            id.html(val);
        }
    };
    id=(oldFile).children( "div" ).children( "div" );
    val=id.html();
    id.html("<form ><input type='text'name='newName'class='rename-form' value='"+val+"' autocomplete='off'/></form>")
    textbox=$(".rename-form");
    textbox.focus();
    textbox.focus(function(){
        this.select();
    }).focusout(function(){
        renameReq(textbox.val());
    });
    id.children('form').submit(function(){
        //console.log(textbox.val());
        renameReq(textbox.val());
        return false;
    });
};


Explorer.prototype.selectFile = function (fileElm,event){
    var explore =this;
    if (event.ctrlKey ){
        rmIndex=explore.selected.indexOf(fileElm);
        if(rmIndex!=-1 ){
            $(explore.selected.splice(rmIndex,1)).removeClass("selectedElm"); 
            console.log(rmIndex);
        }else {
            $(fileElm).addClass("selectedElm");
            explore.selected.push(fileElm);
        }

    } else if(!event.ctrlKey && explore.selected!=[]){
        do{ 
            elm=explore.selected.pop();
            $(elm).removeClass("selectedElm");
        }while(elm);
        $(fileElm).addClass("selectedElm");
        explore.selected.push(fileElm);
    }
    console.log(explore.selected);
};

Explorer.prototype.copyFiles = function (){
    
    if(this.selected!=[]){
        this.clipBoard['files']=this.selected;
        this.clipBoard['operation']='copy';
    }
    console.log(this.clipBoard);
};

Explorer.prototype.cutFiles = function (){
    if(this.selected!=[]){
        this.clipBoard['files']=this.selected;
        this.clipBoard['operation']='cut';
        $(".selectedElm").addClass("to_be_cut")
    }
    console.log(this.clipBoard);
};

Explorer.prototype.pasteFiles = function (toLoc){
    var pastReq=function(){
        
    };
    if(this.clipBoard!={}){
        if(this.clipBoard['operation']==='cut'){
            pastReq("cut",toLoc);
        }else if(this.clipBoard['operation']==='copy'){
            pastReq("copy",toLoc);
        }
    }
    console.log(this.clipBoard);
};