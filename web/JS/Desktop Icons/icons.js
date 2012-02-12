function onselectIcon(obj){
    if( $(obj).attr('id') == "mycomputer" ) {
alert('My Computer');
    }
    if( $(obj).attr('id') == "calculator" ) {
alert('Calculatro');
    }
    if( $(obj).attr('id') == "notepad" ) {
alert('Notepad');
    }
}

function makeIcon(){
    str='';
    for(dat in dirStr){
        str+='<li id="'+dirStr[dat]['attr']['id']+'" ondblclick="'+dirStr[dat]['ondbclick']+'"><div><img src="'+dirStr[dat]['img']+'" /><div>'
        +dirStr[dat]["data"]+'</li>';
    }
    $('#IconView').html(str);
}

var dirStr=[
{
    "data" : "My Computer",
    "attr" : {
        'id' : "mycomputer"
    },
    "img" : "images/icons/mycomputer.png",
    "ondbclick" : "onselectIcon(this)"
},
{
    "data" : "Calculator",
    "attr" : {
        'id' : "calculator"
    },
    "img" : "images/icons/calculator.png",
    "ondbclick" : "onselectIcon(this)"
},
{
    "data" : "Notepad",
    "attr" : {
        "id" : "notepad"
    },
    "img" : "images/icons/notepad.png",
    "ondbclick" : "onselectIcon(this)"
}
];

$(document).ready(function() {
    $('#IconView').sortable();
    makeIcon();
});