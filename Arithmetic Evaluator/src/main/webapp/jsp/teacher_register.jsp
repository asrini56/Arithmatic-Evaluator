<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="/arithmetic-evaluator/css/style_common.css">
<link rel="stylesheet" href="/arithmetic-evaluator/css/teacher_register.css">

<script>
$( document ).ready(function() {
	var message = "${message}";
	if(message) {
		alert(message);
	}
});
</script>
</head>
<body>
<nav class="navbar navbar-inverse" style="margin-bottom:0px !important">
       		<div class="container-fluid">
          	<div class="navbar-header">
              <a class="navbar-brand titleText" href="#">Arithmetic Evaluator</a>
          	</div>
          	<ul class="nav navbar-nav navbar-right">
    				
    				<li><a href="/arithmetic-evaluator/admin/dashboard_page.action">Dashboard</a></li>
    				<li><a href="/arithmetic-evaluator/admin/listTeachers_page.action">Teachers</a></li>
    				<li class="active fontSansSerif"><a href="addTeacher_page.action">Create Teacher Account</a></li>
    				<li>
    					<div class="dropdown">
 							<a href="#" class="dropbtn">
        						<span class="glyphicon glyphicon-user" style="padding-top:16%; margin-right:30px;"></span>
        					</a>
  							<div class="dropdown-content">
    							<a href= "/arithmetic-evaluator/" id="myBtn"><span class="glyphicon glyphicon-log-in"></span> Logout</a>
  							</div>
						</div>
      				</li>
    			</ul>
        	</div>
  		</nav>
 
<form name="teacherRegisterForm" action="addTeachers.action">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create a teacher account.</p>
    <hr>
    <input type="text" placeholder="Enter First Name" name="firstName" required>
    <input type="text" placeholder="Enter Last Name" name="lastName" required>
    <input type="text" placeholder="Enter Email" name="emailID" required>
    <hr>
    <button type="button" class="registerbtn" onclick="location.href ='/arithmetic-evaluator/admin/listTeachers_page.action';" formnovalidate>Cancel</button>
    <button type="submit" class="registerbtn">Register Teacher</button>
  </div>
  <br/> <br/><br/><br/><br/>
  <footer class="footer"><span class="glyphicon glyphicon-copyright-mark"></span>  Copyright</footer>
</form>
</body>
</html>
