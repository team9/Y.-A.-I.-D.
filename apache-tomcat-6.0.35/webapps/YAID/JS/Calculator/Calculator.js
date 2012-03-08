// global vars
var strEmpty = "";

// main functions
$(document).ready(function () {

    // ANIMATE THE HEADER
    $("div.inf").fadeTo(1000, 0.25,
    function () {$("div.inf").fadeTo(500, 1.00);});

    // TOGGLE ARTICLE
    $("div.panel").slideToggle("slow");

    // TOGGLE INSTRUCTION PANEL
    $("div.inf").click(function ()
    {$("div.panel").slideToggle("slow");});

    // APPEND THE NUM INTO BUFFER TEXTBOX
    $("div#keyPad button.keyPad_btnNormal").click(function () {
        var btn = $(this).html();
        $(keyPad_UserInput).val($(keyPad_UserInput).val() + btn);
        $(keyPad_UserInput).focus();

    });

    // CLEAR LAST CHAR IN INPUT TBOX
    $("div#keyPad button.keyPad_btnBack").click(function () {
        var str = $(keyPad_UserInput).val();
        $(keyPad_UserInput).val(str.substring(0, str.length - 1));
        $(keyPad_UserInput).focus();

    });

    // CLEAR ENTIRE INPUT TBOX
    $("div#keyPad button.keyPad_btnClr").click(function () {
        $(keyPad_UserInput).val(strEmpty);
        $(keyPad_UserInput).focus();

    });

    // SPACE BAR BUTTON
    $("div#keyPad button.keyPad_btnSpace").click(function () {
        $(keyPad_UserInput).val($(keyPad_UserInput).val() + " ");
        $(keyPad_UserInput).focus();
    });

    // FROM INPUT BOX TO MEM
    $("div#keyPad button#keyPad_btnToMem").click(function () {
        $(keyPad_Mem).val($(keyPad_UserInput).val());
        $(keyPad_UserInput).val(strEmpty);
        $(keyPad_UserInput).focus();
    });

    // FROM MEM TO INPUT BOX 
    $("div#keyPad button#keyPad_btnFromMem").click(function () {
        $(keyPad_UserInput).val($(keyPad_UserInput).val() + $(keyPad_Mem).val());
        $(keyPad_Mem).val(strEmpty);
        $(keyPad_UserInput).focus();
    });

    // CALCULATE 4 ARITHMETIC OPERATIONS
    $("button#keyPad_btnEnter").click(function () {
        var inputBox = $(keyPad_UserInput);
        var arrVal;
        var x1;
        var x2;
        var retVal = "ERROR! CHECK INPUT";

        // VALIDATE INPUT USING SPLIT FUNCTION AND REGULAR EXPRESSION
        arrVal = inputBox.val().split(/[+-\/*%]+/);
        if (arrVal.length > 2) {inputBox.val(retVal);return;}

        // parse to get 2 operands
        x1 = parseFloat(arrVal[0]);
        x2 = parseFloat(arrVal[1]);

        // "+"
        if (inputBox.val().indexOf('+') >= 0) {retVal = x1 + x2;}
        // "-"
        else if (inputBox.val().indexOf('-') >= 0) {retVal = x1 - x2;}
        // "*"
        else if (inputBox.val().indexOf('*') >= 0) {retVal = x1 * x2;}
        // "/"
        else if (inputBox.val().indexOf('/') >= 0) {retVal = x1 / x2;}
        else if (inputBox.val().indexOf('%') >= 0) {retVal = x1 % x2; }

        inputBox.val(retVal);
        inputBox.focus();
    });

    // FUNCTION KEYS' EVENT HANDLER
    $("button.keyPad_btnCommand").click(function () {
        var inputBox = $(keyPad_UserInput);
        var x = parseFloat(inputBox.val());
        var retVal = "ERROR";

        switch (this.id) {
            case 'keyPad_btnInverseSign':retVal = -x;break;       // +/-
            case 'keyPad_btnInverse':retVal = 1 / x;break;        // 1/X
            case 'keyPad_btnSquare':retVal = x * x;break;         // X^2
            case 'keyPad_btnSquareRoot':retVal = Math.sqrt(x);break;  // SQRT(X)
            case 'keyPad_btnCube':retVal = x * x * x;break;       // X^3
            case 'keyPad_btnCubeRoot':var tmp = 1 / 3;retVal = Math.pow(x, tmp);break; // POW (X, 1/3)
            case 'keyPad_btnLog':retVal = Math.log(x);break;      // LOG (N) - NATURAL
            case 'keyPad_btnExp':retVal = Math.exp(x);break;      // E^(X)
            case 'keyPad_btnSin':retVal = Math.sin(x);break;      // SIN(X)
            case 'keyPad_btnCosin':retVal = Math.cos(x);break;    // COS(X) 
            case 'keyPad_btnTg':retVal = Math.tan(x);break;       // TAN(X)
            //case 'keyPad_btnCtg':retVal = Math.round(Math.random());break;//retVal = 1 / Math.tan(x); break;  // COT(X)
            default:break;
        }
        inputBox.val(retVal);
        inputBox.focus();
    });
})