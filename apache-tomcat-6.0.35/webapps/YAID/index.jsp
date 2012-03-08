<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Virtual Desktop</title>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <link href="CSS/RegistrationLogin/RegistrationLogin.css" rel="stylesheet" type="text/css" media="screen" />
        <script src="JQUERY/jquery.js" type="text/javascript"></script>
        <script type="text/javascript"  src="JQUERY/jquery.js"></script>
        <script>
      
         
            
            function validateEmailID(address) {
 
                var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
                //var address = document.forms[form_id].elements[email].value;
                if(reg.test(address) == false) {
                    //alert("Please enter a valid email ID !!!");
                    $("#warnings").show();
                    $("#warnings").html("Please enter a valid email ID !!!");
                    return false;
                }
                return true;
            }
    
            $(document).ready(function (){
                $('#LoginDetails').submit(function () {
                    var address = document.getElementById("emailid").value;
                    var password = document.getElementById("password").value;
                    
                    if(validateEmailID(address)== true) {
                        if(document.LoginDetails.password.value == "") {
                            $("#warnings").show();
                            // $("warnings").style.backgroundColor="white";
                            $("#warnings").html("Please enter your password !!!");
                            return false;
                        
                        }
                        else  {
                            var parameters= {
                                "emailid":address,
                                "password" :password
                            };
                           
                            $.ajax({
                                type:'POST',
                                url:"Login", //calling servlet
                                data: parameters,
                                cache:false,
                                success:function(htmldat){
                                    console.log("Response : " + htmldat );
                                    if(htmldat == "invalidUser")
                                    {   $("#warnings").show();
                                        $("#warnings").html("Invalid user ID and password !!!");
                                    }
                                    else if(htmldat == "ordinaryUser")  
                                        window.location ="desktop.jsp" ;
                                    else if(htmldat == "admin") 
                                        window.location ='administratorViewUsers.jsp' ;
                                    
                                },
                                error:function(xhr,ajaxOptions){
                                    alert(xhr.status + " :: " + xhr.statusText);
                                }
                            }); 
                        
                        }
                    } 
                   
                    return  false;
                });
                
                
                 
          
          
           
          
            

                $('#RegistrationDetails').submit(function () {
                    var regaddress = document.getElementById("regEmailid").value;
                    var regpassword = document.getElementById("regPassword").value;
                    var regconfirmpassword = document.getElementById("confirmPassword").value;
            
                    //alert("hai :" + regaddress + regpassword + regconfirmpassword);
                    //validateEmailID(document.RegistrationDetails.regEmailid.value);
                    // alert("hello");
                    if(validateEmailID(regaddress)== true) {
                        if(regpassword != regconfirmpassword) {
                            $("#warnings").show();
                   
                            $("#warnings").html("The values in password and confirm password fields doesn't match !!!");
                       
                            //alert("hello2222");
                            return false;
                        }
                        else if(regaddress=="" || regpassword=="" || regconfirmpassword=="") {
                            $("#warnings").show();
                   
                            $("#warnings").html("None of the fields can be empty !!!");
                        
                            return false;
                        }
                        else {
                            var parameters= {
                                "regEmailid":document.RegistrationDetails.regEmailid.value,
                                "regPassword" :document.RegistrationDetails.regPassword.value
                            };
                            $.ajax({
                                type:'POST',
                                url:"Registration", //calling servlet
                                data: parameters,
                                cache:false,
                                success:function(htmldat){
                                    //alert("Response : " + htmldat );
                                    if(htmldat == "UserAlreadyExists")
                                    {   $("#warnings").show();
                                        $("#warnings").html("The same user ID already exists... Retry registration with another user ID !!!");
                                        
                                        return false;
                                    }
                                    else if(htmldat == "SuccessfulRegistration") {
                                        alert("Registration successful... You may login now...");
                                        window.location ='index.jsp';
                                    }
                            
                           
                                    
                                },
                                error:function(xhr,ajaxOptions){
                                    alert(xhr.status + " :: " + xhr.statusText);
                                }
                            }); return false;
                        }
                    }
                    return false;
                });
            });
            function loadRegistrationForm() {
                //document.RegistrationDetails.style.display='block';
                //document.LoginDetails.style.display='none';
                $("#warnings").hide();
                $("#LoginDetails").hide();
                $("#RegistrationDetails").show();
            }
            
        </script>
        <style>
            #RegistrationDetails {
                display: none;
            }
        </style>
    </head>
    <body>
        <div id="wrapper">
            <div id="logo">
                <h1>Virtual Desktop</h1>
                <p>The Complete Solution For Your Portability</p>
            </div>
            <div id="menu">
                <ul>
                    <li><a href="#" class="active">Home</a></li>
<!--                    <li><a href="#">About US</a></li>-->
                </ul>
            </div>
            <div id="header">&nbsp;</div>
            <div id="page">
                <div id="content">
                    <h2>Welcome . . .</h2><br />
                    <p class="byline">Establish your computer on web !</p>
                    <p><strong>Virtual Desktop</strong> is an cloud desktop application that is molded on the SaaS cloud computing architecture. Virtual Desktop is an Open Source Platform designed to hold a wide variety of Web Applications. Virtual Desktop was visualized to be a new definition of an Operating System, where everything inside it can be accessed from everywhere within a seamless network, the internet. All you need to do is login into your Virtual Desktop server with a normal Internet Browser, and you have access to your personal desktop, with your applications, documents, music, movies... just like you left it. In other words "your anywhere, anytime personalized desktop".</p>


                    <p>&nbsp;</p>
                </div>
                <div id="sidebar">
                    <h3>Unlock Your Webtop . . . </h3>
                    <br />
                    <div id="warnings">
                    </div>
                    <div style="padding-left: 20px;">
                        <form name="LoginDetails" id="LoginDetails"  >
                            <label>Email ID  : </label><input type="text" id="emailid" name="emailid" class="more" size="60" />
                            <label>Password  : </label><input type="password" id="password" name="password" class="more"/>
                            <br />
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
                            <input type="submit" value="Login" class="submit" size="70px;"/> 
                            <p><a href="#" class="button" onclick="return loadRegistrationForm()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Register</a> </p>

                        </form>
                    </div>
                    <div style="padding-left: 20px;">
                        <form name="RegistrationDetails" id="RegistrationDetails" action="Registration" method="post">
                            <label>Email ID  : </label><input type="text" id="regEmailid" name="regEmailid" class="more" size="60" />
                            <label>Password  : </label><input type="password" id="regPassword" name="regPassword" class="more"/>
                            <label>Confirm Password  : </label><input type="password" id="confirmPassword" name="confirmPassword" class="more"/>
                            <br />
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                            <input type="submit" value="Register" class="submit" size="70px;"/> 
                            <input type="button" value="Cancel" class="submit" size="70px;" onclick="window.location.href='index.jsp';"/> 
                        </form>
                    </div>
                </div>
                <div style="clear: both;">&nbsp;</div>
            </div>
            <div id="footer">
                <p>Design by <strong>The VATOMS</strong> </p>
            </div>
        </div>
    </body>
</html>
