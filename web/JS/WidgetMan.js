/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function WidgetMan(){

    function makeIcon(){
        str='';
        for(dat in dirStr){
            str+='<li id="'+dirStr[dat]['attr']['id']+'"><div><img src="'+dirStr[dat]['img']+'" /><div>'
            +dirStr[dat]["data"]+'</li>';
        }
        $('#WidgetView').html(str);
        $('#WidgetView li').dblclick(function(){
            console.log("work");
            if( $(this).attr('id') == "clock" ) 
                $('#analog-clock').show();
            if( $(this).attr('id') == "calendar" )
                $('#datepicker').show();
        })
    }
    var dirStr=[
    {
        "data" : "Clock",
        "attr" : {
            'id' : "clock"
        },
        "img" : "images/icons/clock_icon.png",
        "ondbclick" : "onselectIcon(this)"
    },
    {
        "data" : "Calendar",
        "attr" : {
            "id" : "calendar"
        },
        "img" : "images/icons/calendar_icon.png",
        "ondbclick" : "onselectIcon(this)"
    }
    ];
    if(WidgetMan.wallpap==null){
        WidgetMan.wallpap=Window({
            'option':{
                'title':'Widget Manager',
                height:250, 
                width:430
            },
            'content':'helo',
            "ajax":false
        });
    }else{
        WidgetMan.wallpap.dialog( "open" )
    }
    wall_id= $(WidgetMan.wallpap).attr("id");
    $('#windowe_content'+wall_id).html("<ul  id=\"WidgetView\">"+
        "</ul>");
    $('#WidgetView').sortable();
    makeIcon();
//edit=this;
    
}
WidgetMan.wallpap=null;
