<html>
<head>
<title>admin's dashboard</title>
<link rel="stylesheet" href="/arithmetic-evaluator/css/dashboard.css">
<link rel="stylesheet" href="/arithmetic-evaluator/css/style_common.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	
	<div class="grid-container">
		<header class="header">
			<nav class="navbar navbar-inverse" style="margin-bottom:0px !important; ">
  				<div class="container-fluid">
    				<div class="navbar-header">
      					<a class="navbar-brand titleText" href="#">Arithmetic Evaluator</a>
    				</div>
    				<ul class="nav navbar-nav navbar-right">
    				<li class="active fontSansSerif"><a href="#">Dashboard</a></li>
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
		</header>
		<main class="main">
			<div class="main-cards">
				<div class="w3-card-4" onclick="goToListTeachersPage()" style="height: 600px">
					<div class="w3-container w3-center" style="background-color: whitesmoke">
						<h1>Manage Teachers</h1>
					</div>
					<img src="/arithmetic-evaluator/image/teachers.jpg" alt="Alps" style="width: 100%">
				</div>

				<div class="w3-card-4" onclick="goToListStudentsPage()" style="height: 590">
					<div class="w3-container w3-center" style="background-color: whitesmoke">
						<h1>Manage Students</h1>
					</div>
					<img src="/arithmetic-evaluator/image/students.jpg" alt="Alps" style="width: 100%">
				
				</div>
			</div>
		</main>
			</div>
	<script>

function goToListTeachersPage(){
    window.location="/arithmetic-evaluator/admin/listTeachers_page.action";
}

function goToListStudentsPage(){
    window.location="/arithmetic-evaluator/admin/listStudents_page.action";
}

</script>

</body>
</html>