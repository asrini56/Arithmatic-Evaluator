<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/arithmetic-evaluator/css/login_css.css">
<link rel="stylesheet" href="/arithmetic-evaluator/css/style_common.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<title>Login</title>
<style>
    
</style>

</head>
<body>
	<header class="header">
		<nav class="navbar navbar-inverse" style="margin-bottom:0px !important; ">
  			<div class="container-fluid">
    			<div class="navbar-header">
    				<a class="navbar-brand titleText" href="#">Arithmetic Evaluator</a>
    			</div>
			</div>
		</nav>
	</header>
	<div class="login-page">
    	<div class="form">
        	<form class="register-form" action="login.action" method="post">
            	<div class="imgcontainer">
    				<img src="https://icon-library.net/images/head-icon/head-icon-11.jpg" alt="Avatar" class="avatar">
  				</div>
               	<input name ="emailID" type="text" placeholder="user name" required />
               	<input name="password" type="password" placeholder="password" required/>
                <button name="login" onclick="loginFunction()">LOGIN</button>
				<a href="#" id="myBtn">Not Registered. Click here!</a>
			</form>
			<div id="myModal" class="modal">
				<div class="modal-content">
					<div class="modal-header">
						<span class="close">&times;</span>
						<h2>Create an account!</h2>
					</div>
					<div class="modal-body">
						<h4>Are you a student or instructor and have not registered? contact your institute administrator!</h4>
						<p> Note! institute administrators create an account for their students and instructors</p>
						<br>
						<br>
						<h4>Are you an institute administrator? <a href="admin/signup_page.action">Click here to Sign up and create institution account!</a></h4>
					</div>
				</div>
			</div>
			<h2>OR</h2>
   			<p>Try Our site as a</p>
    	</div>
  		<div class="btn-grp">
           	<button class="button button1" onclick="Function1grade()"> <h4> 1ST GRADE STUDENT </h4></button>
			<button class="button button1" onclick="Function6grade()"> <h4> 6TH GRADE STUDENT </h4></button>
  			<button class="button button1" onclick="Function9grade()"> <h4> 9TH GRADE STUDENT </h4></button>
  		</div>
  		<br/> <br/><br/><br/><br/>
  		<footer class="footer"><span class="glyphicon glyphicon-copyright-mark"></span>  Copyright</footer>
	</div>
	
<script>

$( document ).ready(function() {
	var message = "${message}";
	if(message) {
		alert(message);
	}
});

var modal = document.getElementById("myModal");
var btn = document.getElementById("myBtn");
var span = document.getElementsByClassName("close")[0];

btn.onclick = function() {
  modal.style.display = "block";
}

span.onclick = function() {
  modal.style.display = "none";
}

window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}

function loginFunction() {
	document.getElementById("register-form").submit();
}

function Function1grade(){
	window.location.assign("grade1/operations_page.action")
}

function Function6grade(){
	window.location.assign("grade6/operations_page.action")
}

function Function9grade(){
	window.location.assign("grade9/operations_page.action")
}
var ctx = "<%=request.getContextPath()%>"
history.pushState(null, null, ctx +"/login_page.action");

</script>
</body> 
</html>