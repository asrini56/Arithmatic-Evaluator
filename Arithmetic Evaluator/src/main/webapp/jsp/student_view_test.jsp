<html>
   <head>
	<title>Arithmetic Evaluator</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="/arithmetic-evaluator/css/test_details.css">
<link rel="stylesheet" href="/arithmetic-evaluator/css/style_common.css">
<script src="/arithmetic-evaluator/js/common.js"></script>

</head>
   <body style="min-width:100%">
		<nav class="navbar navbar-inverse" style="margin-bottom:0px !important">
       		<div class="container-fluid">
          	<div class="navbar-header">
              <a class="navbar-brand titleText" href="#">Arithmetic Evaluator</a>
          	</div>
          	<ul class="nav navbar-nav navbar-right">
    				
    				<li><a href="/arithmetic-evaluator/student/dashboard.action">Dashboard</a></li>
    				<li class="active fontSansSerif"><a href="#">Take Test</a></li>
    				<li class=""><a href="#">View Scores</a></li>
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

		<section style="display:inline-block; text-align:center; margin-left:23%">
			<div id="message" class="alert alert-info display-none"></div>
			<div class="table-users" id="teacher1"></div>
		</section>

		<footer class="footer" style="position:absolute !important; bottom:0px"><span class="glyphicon glyphicon-copyright-mark"></span>  Copyright</footer>

	
	<script type="text/javascript">
	$( document ).ready(function() {
		var message = "${message}";
		if(message) {
			$("#message").text(message);
			$("#message").show();
			setTimeout(function() {$("#message").hide();}, 5000);
		}
	});

	window.onload = function() {
		fetchGradeTestDetails();
 	};

	function fetchGradeTestDetails() {
		var url="gradetestdetails.action";
		sendAjaxRequest(url, function(resp){
		    console.log(resp);
	 		var tableContent = '<div class="header">Test Details</div>' +
	 							'<table cellspacing="0">' +
	 								'<tr>' +
	 	      							'<th>Test Id</th>' +
	 	      							'<th>Test Name</th>' +
	 	      							'<th>Test For Grade</th>' +
	 	    						'</tr>';

			$.each(resp.testDetails, function() {
	 	    tableContent += '<tr>';
	 	   	tableContent += '<td>' + this.testId + '</td>';
	 	  	tableContent += '<td>' + this.testName + '</td>';
	 	   	tableContent += '<td>' + this.grade + '</td>';
	 	    tableContent += "</tr>";
	 	    });
			tableContent += "</table>";
			$("#teacher1").html(tableContent);
	 	});
	}

 		function buttonclick(){
         	window.location="addTeacher_page.action";
     	}
 	</script>
	</body>
</html>
