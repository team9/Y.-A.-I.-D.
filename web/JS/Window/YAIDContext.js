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
            } else if(key == "copy") {
                explore.editFiles("copy");
            } else if(key == "cut") {
                explore.editFiles("cut");
            }else if(key == "delete") {
                $.each(explore.selected,function(index,value){
                    //console.log($(value).attr("id").replace(explore.div_id+"file_",""));
                    explore.removeFile($(value).attr("id").replace(explore.div_id+"file_",""));
                });
            }
                        
        },
        items: {
            "download" : {
                "name" : "Download", 
                "icon" : "download"
            },"sep1": "---------",
            "rename" : {
                "name" : "Rename", 
                "icon" : "rename"
            },
            "copy" : {
                "name" : "Copy", 
                "icon" : "copy"
            },
            "cut": {
                "name": "Cut", 
                "icon": "cut"
            },"sep2": "---------",
            "delete" : {
                "name" : "Delete", 
                "icon" : "delete"
            }/*,
            "properties" : {
                "name" : "Properties", 
                "icon" : "widget"
            }*/
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
            if(key == "folder") {
                FolderName=explore.selectName("NewDirectory","");
                explore.createNewFile(explore.path,FolderName,"","make_dir");
            } else if(key == "document") {
                FileName=explore.selectName("NewDocument",".txt");        
            explore.createNewFile(explore.path,FileName,"","make_files");
                
            } else if(key == "paste") {
                explore.pasteFiles(explore.path);
            }
        //
        },
        items: {
           
            "folder": {
                "name": "Folder",
                "icon" : "folder"
            },
            "document": {
                "name": "Document",
                "icon" : "document"
            },
            "sep1": "---------",
            "paste" : {
                "name" : "Paste", 
                "icon" : "paste"
            }
        }
    });
}