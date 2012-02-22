$(function() {
    $( "#datepicker" ).datepicker();
    $( "#datepicker" ).draggable();
});

$(function(){
    $.contextMenu({
        selector: '.context-menu-calendar',
        callback: function(key, options) {
            if(key == "lock") {
                $( "#datepicker" ).draggable({
                    disabled: true
                });
                $( "#datepicker" ).removeClass("ui-state-disabled");
            }
            else if(key == "unlock")
                $( "#datepicker" ).draggable({
                    disabled: false
                });
            else if(key == "close") {
                $( "#datepicker" ).hide();
                var dataCalender= "value=hide&key=calenderset";
                $.ajax({
                    type:'POST',
                    url:"GetPath", //calling servlet
                    cache:false,
                    data:dataCalender,
                    success:function(htmldat){},
                    error:function(xhr,ajaxOptions){
                        alert(xhr.status + " :: " + xhr.statusText);
                    }
                });
            }
        },
        items: {
            "lock": {
                "name": "Lock",
                "icon": "lock"
            },
            "unlock": {
                "name": "Unlock",
                "icon": "unlock"
            },
            "close": {
                "name": "Close",
                "icon": "close"
            }
        }
    });
});
