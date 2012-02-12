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
            else if(key == "close")
                $( "#datepicker" ).hide();
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
