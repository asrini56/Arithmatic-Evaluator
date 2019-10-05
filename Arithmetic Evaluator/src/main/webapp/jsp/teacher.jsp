<html>
   <head>
	<title>Arithmetic Evaluator</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="../css/teachers.css">
<link rel="stylesheet" href="../css/operations.css">

</head>
   <body>
		<nav class="navbar navbar-inverse" style="margin-bottom:0px !important">
       		<div class="container-fluid">
          	<div class="navbar-header">
              <a class="navbar-brand titleText" href="#">Arithmetic Evaluator</a>
          	</div>
          	<ul class="nav navbar-nav navbar-right">
    				
    				<li><a href="/arithmetic-evaluator/admin/dashboard_page.action">Dashboard</a></li>
    				<li class="active fontSansSerif"><a href="#">Teachers</a></li>
    				<li><a href="/arithmetic-evaluator/admin/addTeacher_page.action">Create Teacher Account</a></li>
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
	
		<section>
			<div class="table-users" id="teacher1"></div>
		</section>

		<footer style="bottom:0px; width:100%; position:fixed;">
  			<p style="text-align:center"><span class="glyphicon glyphicon-copyright-mark"></span>  Copyright</p>
		</footer>
		
	<script src="../js/common.js"></script>
	<script type="text/javascript">
	$( document ).ready(function() {
		var message = "${message}";
		if(message) {
			alert(message);
		}
	});
		window.onload = function() {
	    	var url="listTeachers.action";
    	 	sendAjaxRequest(url, function(resp){
    	 		var tableContent = '<div class="header">Institution Teachers</div>' +
    	 							'<table cellspacing="0">' + 
    	 								'<tr>' +
    	 	      							'<th>First Name</th>' +
    	 	      							'<th>Last Name</th>' +
    	 	      							'<th>Email-ID</th>' +
    	 	    						'</tr>';
    	 		
				$.each(resp.teachers, function() {
    	 	    tableContent += '<tr>';
    	 	   	tableContent += '<td>' + this.firstName + '</td>';
    	 	  	tableContent += '<td>' + this.lastName + '</td>';
    	 	   	tableContent += '<td>' + this.email + '</td>';
    	 	   	tableContent += "</tr>";
    	 	    });
				tableContent += "</table>";
    			$("#teacher1").html(tableContent);
    	 	});
     	};

 		function buttonclick(){
         	window.location="addTeacher_page.action";
     	}
 	</script>
	</body>
</html>
