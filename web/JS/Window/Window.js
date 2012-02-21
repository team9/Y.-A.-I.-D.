var _init = $.ui.dialog.prototype._init;
$.ui.dialog.prototype._init = function() {
    //Run the original initialization code
    _init.apply(this, arguments);
			 
    //set some variables for use later
    var dialog_element = this;
    var dialog_id = this.uiDialogTitlebar.next().attr('id');
    var dialog_max=false;
    var dialog_size={};
    var curposs;			   
			   
    //append our maximize icon
    this.uiDialogTitlebar.append('<a href="#" id="' + dialog_id +
        '-maxbutton" class="ui-dialog-titlebar-maximize ui-corner-all">'+
        '<span class="ui-icon ui-icon-extlink"></span></a>');			 
			   
    $('#' + dialog_id + '-maxbutton').hover(function() {
        $(this).addClass('ui-state-hover');
    }, function() {
        $(this).removeClass('ui-state-hover');
    }).click(function() {
        if(dialog_max){
            dialog_element.option( "height", dialog_size["height"]);
            dialog_element.option( "width",  dialog_size["width"]);
            curposs=dialog_element.option( "position");
            dialog_element.option( "position", curposs );
            dialog_max=false;
        } else {
            dialog_size["height"]=dialog_element.option( "height");
            dialog_size["width"]=dialog_element.option( "width");
            dialog_element.option( "height", $(document).height()-50);
            dialog_element.option( "width",  $(document).width() );
            curposs=dialog_element.option("position");
            dialog_element.option( "position", 'top' );
            dialog_max=true;
        }

    });
    //<a href="#" class="ui-dialog-titlebar-close ui-corner-all" role="button"><span class="ui-icon ui-icon-closethick">close</span></a>
			   
    //append our minimize icon
    this.uiDialogTitlebar.append('<a href="#" id="' + dialog_id +
        '-minbutton" class="ui-dialog-titlebar-minimize ui-corner-all">'+
        '<span class="ui-icon ui-icon-minusthick"></span></a>');
			 
    //append our minimized state
    $('#dialog_window_minimized_container').append(
        '<div class="dialog_window_minimized ui-widget ui-state-default ui-corner-all" id="' +
        dialog_id + '_minimized">' + this.uiDialogTitlebar.find('.ui-dialog-title').text() +
        '<span class="ui-icon ui-icon-newwin"></div>');
			 
    //create a hover event for the minimize button so that it looks good
    $('#' + dialog_id + '-minbutton').hover(function() {
        $(this).addClass('ui-state-hover');
    }, function() {
        $(this).removeClass('ui-state-hover');
    }).click(function() {
        //add a click event as well to do our "minimalization" of the window
        dialog_element.close();
        $('#' + dialog_id + '_minimized').show();
    });
    //    $("#"+dialog_id).find("a.ui-dialog-titlebar-close").click(function(event){
    //        console.log(event);
    //        event.preventDefault();
    //        $("#"+dialog_id + "_minimized").hide();
    //        //this.close();        
    //    });
    //create another click event that maximizes our minimized window
    $('#' + dialog_id + '_minimized').click(function() {
        //$(this).hide();
        if(dialog_element.isOpen()){
            dialog_element.close();
            $('#' + dialog_id + '_minimized').show();
        }else{
            dialog_element.open();
        }
    });
};
			
function Window(arg){
    try{
        var div_count = $('.dialog_window').length + 1;
								 
        //generate a unique id based on the total number
        var div_id = 'dialog_window_' + div_count;
						 
        //get the title of the new window from our form, as well as the content
        var div_content="<div id='windowe_content"+ div_id +"'> Loading,Please Wait.</div>";
        $('body').append('<div class="dialog_window" id="' + div_id + '">' + div_content + '</div>');
        if(arg['ajax']==true){
            urlstr=arg['content'];
            //alert(urlstr);
            $.ajax({
                type: 'GET',
                url: urlstr,								 
                data:'',
                success: function(html){
                    // alert(html);
                    $('#windowe_content'+ div_id).html(html);
                }
            });
        }else{
            $('#windowe_content'+ div_id).html(arg['content'])	;						
        }
						 
        //initialize our new dial
        var dialog = $('#' + div_id).dialog(arg['option']).bind( "dialogclose", function(event, ui) {
            console.log(this,ui);
            $("#"+div_id + "_minimized").hide();
        }).bind( "dialogopen", function(event, ui) {
            $('#' + div_id + '_minimized').show();
        });
        /*{
						   width: 'auto',
						   height: 'auto',
						   title : div_title

						});*/
        console.log(dialog);
        return dialog;

    }
    catch(e){
        console.log(e);
    }
}
Window.actualDia=null;