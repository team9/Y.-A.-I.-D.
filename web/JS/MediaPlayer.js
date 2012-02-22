/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function MediaPlayer(path){
    if(MediaPlayer.plr_id===null){
        MediaPlayer.plr_id = Window({
            'option':{
                'title':'Media Player',
                height:350,
                width:550
            } ,
            'content':''
        //'content':'<a class="media {width:480, height:280}" href="ImageBytes?id='+encodeURI(path) +'">Vedio Playing</a> '
        });
        MediaPlayer.fv_plr=$('#windowe_content'+$(MediaPlayer.plr_id).attr("id")).flareVideo();
    }else{
        //content='<a class="media {width:480, height:280}" href="ImageBytes?id='+encodeURI(path) +'">Vedio Playing</a> '
        //MediaPlayer.setContent(content);
        MediaPlayer.plr_id.dialog( "open" )
    }
    //$('a.media').media();
    MediaPlayer.fv_plr.load([
    {
        src:  'ImageBytes?id='+encodeURI(path),
        type: MediaPlayer.setType(path)
    }
    ]);
//console.log(MediaPlayer.plr_id);

}
MediaPlayer.plr_id=null;
MediaPlayer.fv_plr=null;

MediaPlayer.setType= function(path){
    //$('#windowe_content'+$(MediaPlayer.plr_id).attr("id")).html(content);

    if (path.match(/.wmv$/)){
        return "video/ogg";
    }else if(path.match(/.flv$/)){
        return "video/x-flv";
    }else if(path.match(/.avi$/)){
        return "video/ogg";
    }else if(path.match(/.mov$/)){
        return "video/ogg";
    } else if(path.match(/.ogg$/)){
        return "video/ogg";
    } else if(path.match(/.mp4$/)){
        return "video/mp4";
    } else if(path.match(/.mp3$/)){
        return "audio/mpeg3";
    } 
    
}
