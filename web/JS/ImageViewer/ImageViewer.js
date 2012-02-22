var img_id=null;
function imageViewer(path){
    // if(img_id===null){
    img_id = Window({
        'option':{
            'title':'Image Viewer',
            height:450,
            width:600
        },
        'content':'Loading...'
    });
    //}
    $('#windowe_content'+$(img_id).attr("id")).html(
        '<div class="image_viewer" id="image_viewer'+img_id.attr('id')+'"  /></div>');
    
    //$('#image_viewer'+img_id.attr('id')).css("background-image",
      //  "url(ImageBytes?id="+encodeURI(path)+")");
      $('#image_viewer'+img_id.attr('id')).html("<img src='ImageBytes?id="+encodeURI(path)+"'></img>")
//console.log(img_id);

}