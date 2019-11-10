<!DOCTYPE html>
<html lang="en">
<head>
<title>Arithmetic Evaluator</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/arithmetic-evaluator/css/style_admin.css">
<link rel="stylesheet" href="/arithmetic-evaluator/css/style_common.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<body bgcolor="white">

	<header class="header">
		<nav class="navbar navbar-inverse" style="margin-bottom:0px !important; ">
  			<div class="container-fluid">
    			<div class="navbar-header">
    				<a class="navbar-brand titleText" href="#">Arithmetic Evaluator</a>
    			</div>
			</div>
		</nav>
	</header>
	<header>
		<h1 style="color: black" align="center">Sign Up Page</h1>
	</header>
	<form id="myForm" action="signup.action"
		style="border: 1px solid black;" method="post">
		<div class="container">
			<h1 style="color: black">Institution Admin</h1>
			<hr>
			<label for="InstitutionName"><b style="color: black">Institution Name</b></label> 
			<input type="text" placeholder="Institution Name" name="institutionName" required/> <br/> 
			
			<label for="emailID"> <b style="color: black">Email</b> </label> 
			<input type="text" placeholder="Enter Email" name="emailID" required/> 
			
			<label for="password"><b style="color: black">Password</b></label> 
			<input type="password" id="password" name="password" placeholder="Enter Password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required>
		</div>

		<div class="clearfix" style="margin-left: 25%;">
			<button type="button" class="cancelbtn" onclick="cancelFunction()">Cancel</button>
			<button class="signupbtn" onclick="validateAndSubmitFunction()">Sign Up</button>
		</div>
	</form>
<script>

	function myFunction() {
		alert("Sign up complete!");
	}

	$(document).ready(function() {
		var message = "${message}";
		if (message) {
			alert(message);
		}
	});

	function validateAndSubmitFunction() {

		if (validate()) {
			submitFunction()
		} else {
			return false;
		}
	}

	function submitFunction() {
		document.getElementById("myForm").submit();
	}

	function cancelFunction() {
		window.location = "/arithmetic-evaluator/login_page.action";
	}
</script>
</body>
</html>