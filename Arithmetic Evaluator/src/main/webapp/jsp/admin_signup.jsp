<!DOCTYPE html>
<html lang="en">
<head>
<title>Arithmetic Evaluator</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/style_admin.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


<body bgcolor="white">

<header>
<h1 style="color:black" align="center">Arithmetic Evaluator</h1>
</header>
<form  id="myForm" action="signup.action" style="border:1px solid black">
    <div class="container">
        <h1 style="color:black">Sign Up Page</h1>
        <h2 style="color:black">Please fill the form</h2>
        <hr>
        <label for="InstitutionName"><b style="color:black">Institution Name</b></label>
        <input type="text" placeholder="Institution Name" name="institutionName" required>


        <label for="emailID"><b style="color:black">Email</b></label>
        <input type="text" placeholder="Enter Email" name="emailID" required>

        <label for="password"><b style="color:black">Password</b></label>
        <input type="password" id="password" name="password" placeholder="Enter Password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>

        <div id="message" style="background-color:white">
          <h3>Password must contain the following:</h3>
          <p id="letter" class="invalid">A <b>lowercase</b> letter</p>
          <p id="capital" class="invalid">A <b>capital (uppercase)</b> letter</p>
          <p id="number" class="invalid">A <b>number</b></p>
          <p id="length" class="invalid">Minimum <b>8 characters</b></p>
        </div>

    </div>

     <div class="clearfix">
          <button type="button" class="cancelbtn" onclick="cancelFunction()">Cancel</button>
          <button class="signupbtn" onclick="submitFunction()">Sign Up</button>
    </div>
</form>
<script>
function myFunction() {
  alert("Sign up complete!");
}

$( document ).ready(function() {
	var message = "${message}";
	if(message) {
		alert(message);
	}
});

var myInput = document.getElementById("password");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");

// When the user clicks on the password field, show the message box
myInput.onfocus = function() {
  document.getElementById("message").style.display = "block";
}

// When the user clicks outside of the password field, hide the message box
myInput.onblur = function() {
  document.getElementById("message").style.display = "none";
}

// When the user starts to type something inside the password field
myInput.onkeyup = function() {
  // Validate lowercase letters
  var lowerCaseLetters = /[a-z]/g;
  if(myInput.value.match(lowerCaseLetters)) {
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
  }

  // Validate capital letters
  var upperCaseLetters = /[A-Z]/g;
  if(myInput.value.match(upperCaseLetters)) {
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }

  // Validate numbers
  var numbers = /[0-9]/g;
  if(myInput.value.match(numbers)) {
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }

  // Validate length
  if(myInput.value.length >= 8) {
    length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }
}


function submitFunction() {
  document.getElementById("myForm").submit();
}

function cancelFunction() {
	window.location="/arithmetic-evaluator/login_page.action";
}

</script>
</body>
</html>