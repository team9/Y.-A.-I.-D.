 var img_id=null;
function imageViewer(path){
   // if(img_id===null){
    img_id = Window({
        'option':{
            'title':'Image Viewer',
            height:450,
            width:600
        },
        'content':'<div class="image_viewer"  /></div>'
        });
    //}
        $('.image_viewer').css("background-image", "url(ImageBytes?id="+encodeURI(path)+")");
    console.log(img_id);

}