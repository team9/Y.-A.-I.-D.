var myForm,
formData;
var changeWallPaper,
w1;
function changeBackground() {
    formData = [
    {
        type:"setings",
        position:"label-right"
    },

    {
        
        type: "input",
        name:"URLtext",
        label:"Image Location",
        value:"Enter your URL here....",
        width:"200"
    },
    {
        type:"block", 
        inputwidth:"300",
        width:300,
        height:30,
        list:[

        {
            type: "button",
            name:"okButton",
        
            value:"ok"
        },
        {
            type:"newColumn"
        },

        {
            type: "button",
            name:"cancelButton",
        
            value:"cancel"
        }]
    }
    
    ];
    try {
        changeWallPaper = new dhtmlXWindows();
        //changeWallPaper.enableAutoViewport(false);
        changeWallPaper.attachViewportTo("winVP");
        w1 = changeWallPaper.createWindow("w1", 10, 10, 400, 200);
        myForm = w1.attachForm(formData);
        myForm.attachEvent("onButtonClick",function(id){
            if(id=="okButton") {
                var URLtext = myForm.getItemValue("URLtext");
                //alert(URLtext);
                $('#workarea').css('background-image','url('+URLtext+')');
                changeWallPaper.window('w1').close();
            }
            else if(id=="cancelButton")
                changeWallPaper.window('w1').close();
                  
        //else if(id=="okButton") {
        }
        )
    }
    catch(e){
        alert(e);
    }
    
}
            

