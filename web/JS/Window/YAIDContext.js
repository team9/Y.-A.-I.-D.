/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var YAIDContext = new Object();

YAIDContext.forFileElm=function(explore){
    div_id=explore.div_id;
    $.contextMenu({
        selector: '#FolderView'+ div_id+' li',
        callback: function(key, options) {
            //explore.selectFile(this,null);
            console.log(key,options,this);
            if(key == "rename") {
                explore.fileRename(this);
            } else if(key == "download") {
                explore.downloadFile($(this).attr("id").replace(explore.div_id+"file_",""));
            } else if(key == "widget") {
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
            "download" : {
                "name" : "download", 
                "icon" : "widget"
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
        
}

YAIDContext.forFileView=function(explore){
    div_id=explore.div_id;
    $.contextMenu({
        selector: '#FolderView'+ div_id,
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
}