/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function WallpaperMan(){
    makeFolderElm=function(path){
        str='';
        console.log(path);
        //get_files
        $.ajax({
            type: 'GET',
            url: "FileOperationHandler",
            data: "operation=get_files&id=" + path,
            success: function(htmldir){
                for(dat in htmldir){
                    console.log(htmldir[dat]['attr']['id'].replace("file_",""));
                    str+='<li id="'+htmldir[dat]['attr']['id']+'"><div><img '
                    +'src="ImageBytes?id='+encodeURI(htmldir[dat]['attr']['id'].replace("file_",""))+'" /><div>'
                    +htmldir[dat]["data"]+'</li>';
                }
                $('#FolderView').html(str);
                $('#FolderView li').dblclick(function(){
                    id=$(this).attr('id').replace("file_","");
                    $('#workarea').css("background-image", "url(ImageBytes?id="+encodeURI(id)+")");
                    var dataRequestObject= "value=ImageBytes?id="+encodeURI(id)+"&key=wallpaper";
                    $.ajax({
                        type:'POST',
                        url:"GetPath", //calling servlet
                        cache:false,
                        data:dataRequestObject,
                        success:function(htmldat){},
                        error:function(xhr,ajaxOptions){
                            alert(xhr.status + " :: " + xhr.statusText);
                        }
                    });
                });
            }
        });
    }
    if(WallpaperMan.wallpap==null){
        WallpaperMan.wallpap=Window({
            'option':{
                'title':'Change Wallpaper',
                height:410,
                width:570
            },
            'content':'helo',
            "ajax":false
        });
    }else{
        WallpaperMan.wallpap.dialog( "open" )
    }
    wall_id= $(WallpaperMan.wallpap).attr("id");
    $('#windowe_content'+wall_id).html("<ul class=\"WallpaperView\" id=\"FolderView\">"+
        "</ul>");
    makeFolderElm("/Home/WallPaper");
//edit=this;
    
}
WallpaperMan.wallpap=null;