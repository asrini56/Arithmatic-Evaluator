<html>
<head>
<title>admin's dashboard</title>
<link rel="stylesheet" href="/arithmetic-evaluator/css/dashboard.css">
<link rel="stylesheet" href="/arithmetic-evaluator/css/operations.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

.card {
	/* Add shadows to create the "card" effect */
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	transition: 0.3s;
}

/* On mouse-over, add a deeper shadow */
.card:hover {
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}

/* Add some padding inside the card container */
.container {
	padding: 2px 16px;
}

#myImg {
	border-radius: 5px;
	cursor: pointer;
	transition: 0.3s;
}

#myImg:hover {
	opacity: 0.7;
}

.grid-container {
	display: grid;
	grid-template-columns: auto; /* Side nav is hidden on mobile */
	grid-template-rows: 50px 1fr 50px;
	grid-template-areas: 'header' 'main' 'footer';
	height: 100vh;
}
/* 
  .sidenav {
    display: none;
    grid-area: sidenav;
    background-color: #394263;
  } */
.main-cards {
	column-count: 1;
	column-gap: 20px;
	margin: 20px;
}

/* Non-mobile styles, 750px breakpoint */
@media only screen and (min-width: 46.875em) {
	/* Show the sidenav */
	.grid-container {
		grid-template-columns: 0px 1fr;
		/* Show the side nav for non-mobile screens */
		grid-template-areas: "sidenav header" "sidenav main" "sidenav footer";
	}
	/*  .sidenav {
      display: flex;
      flex-direction: column;
    }
  }*/
	/* Medium-sized screen breakpoint (tablet, 1050px) */
	@media only screen and (min-width: 65.625em) {
		/* Break out main cards into two columns */
		.main-cards {
			column-count: 2;
		}
	}
}
</style>
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
		<div class="main-header">
			<div class="main-header__heading">Hello User</div>
		</div>

		<div class="main-cards">
			<div class="w3-card-4" onclick="goToListTeachersPage()" style="height: 500px">
				<img src="/arithmetic-evaluator/image/teachers.jpg" alt="Alps" style="width: 100%">
				<div class="w3-container w3-center"
					style="background-color: whitesmoke">
					<p>TEACHERS</p>
				</div>
			</div>

			<div class="w3-card-4" onclick="goToListStudentsPage()" style="height: 500px">
				<img src="/arithmetic-evaluator/image/students.jpg" alt="Alps" style="width: 100%">
				<div class="w3-container w3-center"
					style="background-color: whitesmoke">
					<p>STUDENTS</p>
				</div>
			</div>
		</div>

		</main>
		<footer class="footer" style="text-align:center; font-size:20px; padding-top:10px;"><span class="glyphicon glyphicon-copyright-mark"></span>  Copyright</p></footer>
	</div>
	<script>

function goToListTeachersPage(){
    window.location="/arithmetic-evaluator/admin/listTeachers_page.action";
}

function goToListStudentsPage(){
    alert("Page under construction, kindly bear with us!")
}

</script>

</body>
</html>