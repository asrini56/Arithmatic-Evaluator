<html>
<head>
<title>student's dashboard</title>
<link rel="stylesheet" href="/arithmetic-evaluator/css/dashboard.css">
<link rel="stylesheet" href="/arithmetic-evaluator/css/students_dashboard.css">
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
                <div class="card" onclick="goToPractiseMathsPage()" style="height: 450px">
					<div class="w3-container w3-center" style="background-color: whitesmoke">
						<h1>Practise Maths</h1>
					</div>
					<img src="/arithmetic-evaluator/image/practisemaths.jpg"alt="Alps" style="width: 100%">
				</div>
                
				<div class="card" onclick="goToTakeTestsPage()" style="height: 450px">
					<div class="w3-container w3-center" style="background-color: whitesmoke">
						<h1>Take Tests</h1>
					</div>
					<img src="/arithmetic-evaluator/image/taketest.jpg" alt="Alps" style="width: 100%">
				</div>

				<div class="card" onclick="goToViewScoresPage()" style="height: 450px">
					<div class="w3-container w3-center" style="background-color: whitesmoke">
						<h1>View Test Scores</h1>
					</div>
					<img src="/arithmetic-evaluator/image/viewscores.jpg" alt="Alps" style="width: 100%">
				</div>
			</div>
		</main>
		<footer class="footer"></footer>
	</div>
	<script>
function goToPractiseMathsPage(){
    window.location="/arithmetic-evaluator/grade1/operations_page.action";
}
function goToTakeTestsPage(){
    window.location="/arithmetic-evaluator/student/taketests_page.action";
}
function goToViewScoresPage(){
    alert("Page under construction, kindly bear with us!")
}
</script>

</body>
</html>