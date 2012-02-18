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
        },
        'content':'<a class="media {width:480, height:280}" href="ImageBytes?id='+encodeURI(path) +'">Vedio Playing</a> '
        });
    }else{
        content='<a class="media {width:480, height:280}" href="ImageBytes?id='+encodeURI(path) +'">Vedio Playing</a> '
        MediaPlayer.setContent(content);
    }
    $('a.media').media();
    console.log(MediaPlayer.plr_id);

}
MediaPlayer.plr_id=null;

MediaPlayer.setContent= function(content){
    $('#windowe_content'+$(MediaPlayer.plr_id).attr("id")).html(content);
}
