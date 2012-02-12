$(function() {
    $( "#analog-clock" ).draggable();
});

$(function(){
    $.contextMenu({
        selector: '.context-menu-clock',
        callback: function(key, options) {
            if(key == "theme1")
                $('head').append('<link rel="stylesheet" href="CSS/clock/white.css" type="text/css" />');
            else if(key == "theme2")
                $('head').append('<link rel="stylesheet" href="CSS/clock/yellow.css" type="text/css" />');
            else if(key == "theme3")
                $('head').append('<link rel="stylesheet" href="CSS/clock/green.css" type="text/css" />');
            else if(key == "theme4")
                $('head').append('<link rel="stylesheet" href="CSS/clock/violet.css" type="text/css" />');
            else if(key == "theme5")
                $('head').append('<link rel="stylesheet" href="CSS/clock/pink.css" type="text/css" />');
            else if(key == "lock") {
                $( "#analog-clock" ).draggable({
                    disabled: true
                });
                $( "#analog-clock" ).removeClass("ui-state-disabled");
            }
            else if(key == "unlock")
                $( "#analog-clock" ).draggable({
                    disabled: false
                });
            else if(key == "close")
                $( "#analog-clock" ).hide();
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
            "theme": {
                "name": "Theme",
                "icon": "theme",
                "items": {
                    "theme1": {
                        "name": "White"
                    },
                    "theme2": {
                        "name": "Yellow"
                    },
                    "theme3": {
                        "name": "Green"
                    },
                    "theme4": {
                        "name": "Violet"
                    },
                    "theme5": {
                        "name": "Pink"
                    }
                }
            },
            "sep1": "---------",
            "close": {
                "name": "Close",
                "icon": "close"
            }
        }
    });
});

