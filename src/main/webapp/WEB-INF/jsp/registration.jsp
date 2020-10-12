<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Form</title>

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.0/css/bootstrapValidator.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script	src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js"></script>
</head>

<style>
    #success_message{ display: none;}
</style>

    <script>
    function checkPass()
    {
        //Store the password field objects into variables ...
        var pass1 = document.getElementById('pass1');
        var pass2 = document.getElementById('pass2');
        //Store the Confimation Message Object ...
        var message = document.getElementById('confirmMessage');
        //Set the colors we will be using ...
        var goodColor = "#66cc66";
        var badColor = "#ff6666";
        //Compare the values in the password field
        //and the confirmation field
        if(pass1.value == pass2.value){
            //The passwords match.
            //Set the color to the good color and inform
            //the user that they have entered the correct password
            pass2.style.backgroundColor = goodColor;
            message.style.color = goodColor;
            message.innerHTML = "Passwords Match"
        }else{
            //The passwords do not match.
            //Set the color to the bad color and
            //notify the user.
            pass2.style.backgroundColor = badColor;
            message.style.color = badColor;
            message.innerHTML = "Passwords Do Not Match!"
        }
    }
    function validatephone(phone)
    {
        var maintainplus = '';
        var numval = phone.value
        if ( numval.charAt(0)=='+' )
        {
            var maintainplus = '';
        }
        curphonevar = numval.replace(/[\\A-Za-z!"£$%^&\,*+_={};:'@#~,.Š\/<>?|`¬\]\[]/g,'');
        phone.value = maintainplus + curphonevar;
        var maintainplus = '';
        phone.focus;
    }
    // validates text only
    function Validate(txt) {
        txt.value = txt.value.replace(/[^a-zA-Z-'\n\r.]+/g, '');
    }
    // validate email
    function email_validate(email)
    {
        var regMail = /^([_a-zA-Z0-9-]+)(\.[_a-zA-Z0-9-]+)*@([a-zA-Z0-9-]+\.)+([a-zA-Z]{2,3})$/;

        if(regMail.test(email) == false)
        {
            document.getElementById("status").innerHTML    = "<span class='warning'>Email address is not valid yet.</span>";
        }
        else
        {
            document.getElementById("status").innerHTML	= "<span class='valid'>Thanks, you have entered a valid Email address!</span>";
        }
    }
    // validate date of birth
    function dob_validate(dob)
    {
        var regDOB = /^(\d{1,2})[-\/](\d{1,2})[-\/](\d{4})$/;

        if(regDOB.test(dob) == false)
        {
            document.getElementById("statusDOB").innerHTML	= "<span class='warning'>DOB is only used to verify your age.</span>";
        }
        else
        {
            document.getElementById("statusDOB").innerHTML	= "<span class='valid'>Thanks, you have entered a valid DOB!</span>";
        }
    }
    // validate address
    function add_validate(address)
    {
        var regAdd = /^(?=.*\d)[a-zA-Z\s\d\/]+$/;

        if(regAdd.test(address) == false)
        {
            document.getElementById("statusAdd").innerHTML	= "<span class='warning'>Address is not valid yet.</span>";
        }
        else
        {
            document.getElementById("statusAdd").innerHTML	= "<span class='valid'>Thanks, Address looks valid!</span>";
        }
    }



    /*
    $(function () {
        $('#txtFirstName').keydown(function (e) {

            if ( e.ctrlKey || e.altKey) {
                e.preventDefault();
            } else {
                var key = e.keyCode;
                if (!((key == 8) || (key == 32) || (key >= 35 && key <= 40) || (key >= 65 && key <= 90))) {
                    e.preventDefault();
                }
            }
        });
    });
    */

    function isNumberKey(evt,id)
    {
        try{
            var charCod = (evt.which) ? evt.which : event.keyCode;

            if(charCod==46 || charCod==32){
                var txt=document.getElementById(id).value;
                return true;
            }
            var regex = new RegExp("^[a-zA-Z]+$");
            var str = String.fromCharCode(!evt.charCode ? evt.which : evt.charCode);
            if (regex.test(str)) {
                return true;
            }
            else
            {
                evt.preventDefault();
                alert('Please Enter Alphabate');
                return false;
            }

        }catch(w){
            alert(w);
        }
    }




</script>



<script>
    $('#phone_number').attr('data-original-title', 'phone number is required')
        .tooltip('fixTitle')
        .tooltip('show');
</script>


<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">


        <div class="collapse navbar-collapse" id="myNavbar"></div>
    </div>
</nav>

    <div class="container" style="margin-top: 80px;">
        <div style="background-color:f2f3f8;" class="row panel  col-md-8 col-md-offset-2">
            <div class="panel">
                <div class="row  col-md-8 col-md-offset-2">
                    <form:form method="post" modelAttribute="oUsers"
                               name="oUsers" action="/add">
                        <div class="panel-body"><fieldset><legend class="text-center">SIGN UP</legend>

                            <div class="col-md-12 text-center">
                                <strong style="color: red"><%out.print(session.getAttribute("SignUpMessage"));%></strong>
                            </div>
                            <div class="form-group">
                                <label for="username"><span class="req">* </span> Full Name:</label>
                                <form:input type="text" path="user_name"  id="txtFirstName" class="form-control" onkeypress="return isNumberKey(event,this.id)"   required="required" placeholder="Full Name"/>

                                <div id="errLast"></div>
                            </div>

                            <div class="form-group">
                                <label for="email"><span class="req">* </span>Email</label>
                                <form:input type="mailid" path="email" class="form-control" required="required" id = "mailid"  placeholder="Email" onchange="email_validate(this.value);"/>
                                <div class="status" id="status"></div>
                            </div>
                            <div class="form-group">
                                <label><span class="req">* </span>Mobile No:</label>
                                <form:input  type="tel" title="01676365375" pattern="\+?(88)?0?1[56789][0-9]{8}\b"  path="phone" class="form-control" placeholder="Mobile No" id="phone_number"  required="required"/>
                            </div>
                            <div class="form-group">
                                <label for="password"><span class="req">* </span> Password</label>
                                <form:input type="password" path="password" class="form-control inputpass" id="pass1"  required="required" placeholder="Password" minlength="8" maxlength="16"/>
                                <p style="font-size: x-small">Password between 8 and 20 characters; must contain at least one lowercase letter, one uppercase letter, one numeric digit, and one special character, but cannot contain whitespace.</p>
                                <div id="errLast"></div>
                                <label for="password"><span class="req">* </span>Confirm  Password: </label>
                                <input required name="confirmpassword" type="password" class="form-control inputpass"  required="required" minlength="8" maxlength="16" placeholder="Enter again to validate"  id="pass2" onkeyup="checkPass(); return false;" />
                                <span id="confirmMessage" class="confirmMessage"></span>

                            </div>


                            <div class="form-group">

                                <input type="checkbox" required name="terms" onchange="this.setCustomValidity(validity.valueMissing ? 'Please indicate that you accept the Terms and Conditions' : '');" id="field_terms">   <label for="terms">I agree with the <a href="" title="Read our terms and conditions by clicking on this link">terms and conditions</a> for Registration.</label>
                            </div>


                            <div class="form-group">
                                <div class="row">
                                    <div class="col-sm-6 col-sm-offset-3">
                                        <input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-primary" value="Sign Up Now">
                                    </div>
                                </div>
                            </div>

                        </fieldset>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>

</div><!-- /.container -->
</body>
</html>
