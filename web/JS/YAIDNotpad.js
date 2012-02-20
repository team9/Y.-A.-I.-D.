/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function YAIDNotepad(path){
    this.path=path;
    this.notepad=Window({
        'option':{
            'title':'Notepad',
            height:410,
            width:570
        },
        'content':'helo',
        "ajax":false
    });
    this.note_id= $(this.notepad).attr("id");
    $('#windowe_content'+this.note_id).html("<textarea name=\"area\" id=\""+this.note_id+
        "mytxtarea\" cols=\"88\" rows=\"16\"></textarea>");
    edit=this;
    new nicEditor({
        fullPanel : true, 
        onSave : function(content, id, instance) {
            var dataSave= {
                "path":edit.path,
                "operation":"save",
                "data":content
            };//"path=./UserData/manu/Home/hello.txt&operation=save&data="+content;
            $.ajax({
                type:'POST',
                url:"FileServlet", //calling servlet
                cache:false,
                data:dataSave,
                success:function(htmldat){},
                error:function(xhr,ajaxOptions){
                    alert(xhr.status + " :: " + xhr.statusText);
                }
            });
        }
    }).panelInstance(this.note_id+'mytxtarea');
    if(path){
        this.openFiles();
    }
    $("#"+this.note_id+'mytxtarea').focus();
}
YAIDNotepad.prototype.openFiles=function(){
    var dataOpen= {
        "path":this.path,
        "operation":"open"
    };
    //"path=./UserData/manu/Home/hello.txt&operation=open";
    edit=this;
    $.ajax({
        type:'POST',
        url:"FileServlet", //calling servlet
        cache:false,
        data:dataOpen,
        success:function(readtext){
            nicEditors.findEditor(edit.note_id+'mytxtarea').setContent(readtext);
        },
        error:function(xhr,ajaxOptions){
            alert(xhr.status + " :: " + xhr.statusText);
        }
    });
}