<!DOCTYPE html>
<html lang="en">
<head>
<title>Arithmetic Evaluator</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<style>
header {
  //background-color: white;
  padding: 2px;
  text-align: center;
  font-size: 20px;
  color: black;
}

.center {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 50%;
}

section:after {
  content: "";
  display: table;
  clear: both;
}

body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

button:hover {
  opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
  padding: 14px 20px;
  background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
  padding: 16px;
}

/* Clear floats */
.clearfix::after {
  content: "";
  clear: both;
  display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
  .cancelbtn, .signupbtn {
     width: 100%;
  }
}


</style>
<body bgcolor="white">

<header>
<h1>Arithmetic Calculator</h1>
</header>
<form  style="border:1px solid #ccc">
  <div class="container">
    <h1 color="white">Sign Up</h1>
    <p color="white">Please fill in this form to create an account.</p>
    <hr>

    <label for="InstitutionName"><b>Institution Name</b></label>
    <input type="text" placeholder="Institution Name" id="institutionName" name="institutionName" required>


    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="emailID" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

    <label for="psw-repeat"><b>Repeat Password</b></label>
    <input type="password" placeholder="Repeat Password" name="psw-repeat" required>
    
    <p>By creating an account you agree to our <a href="#" style="color:black">Terms & Privacy</a>.</p>

    <div class="clearfix">
      <button type="button" class="cancelbtn">Cancel</button>
      <button type="button" class="signupbtn" onclick="return signupAdmin()">Sign Up</button>
    </div>
  </div>
</form>

</body>

<script>
$( document ).ready(function() {
	checkAndAlertError("${message}");
 }
 
 function signupAdmin() {
	 
 }
</script>
</html>