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
		<h1 style="color: black" align="center">Forgot Password Page</h1>
	</header>
	<form id="set-password-form" action="resetPassword.action">
		<style="border: 1px solid black" method="post">
		<div class="container">
			<h1 style="color: black">Reset Password</h1>
			<hr>
			<label for="emailID"><b style="color: black">Email ID</b></label>
			<input type="text" name = "emailID" placeholder="Email ID" required/>

			<label for="oldPassword"><b style="color: black">Old Password</b></label>
            <input type="password" name = "oldPassword" placeholder="old password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required/>>

			<label for="newPassword"><b style="color: black">New Password</b></label>
			<input type="password" id="newPassword" placeholder="Enter New Password" name="newPassword" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required/> <br/>

			<label for="confirmPassword"> <b style="color: black">Comfirm Password</b> </label>
			<input type="password"  id="confirmPassword" placeholder="Confirm Password" name="confirmPassword" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required/>

		</div>

		<div class="clearfix" style="margin-left: 25%;">
			<button type="button" class="cancelbtn" onclick="cancelFunction()">Cancel</button>
			<button class="signupbtn" onclick="submitFunction()">Submit</button>
		</div>
	</form>
<script>

	function myFunction() {
		alert("Password Set!");
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
		document.getElementById("set-password-form").submit();
	}

	function cancelFunction() {
		window.location = "/arithmetic-evaluator/login_page.action";
	}
</script>
</body>
</html>