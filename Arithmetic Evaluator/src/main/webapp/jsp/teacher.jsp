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
      				<a class="navbar-brand" href="/arithmetic-evaluator/admin/dashboard_page.action">Arithmetic Evaluator</a>
    			</div>
    			<ul class="nav navbar-nav">
      				<li class="" style="border-right:1px;border-right-color: white;"><a href="/arithmetic-evaluator/admin/dashboard_page.action">Home</a></li>
      				<li class="active" style="border-right:1px;border-right-color: white;"><a href="1.html">Teachers</a></li>
    			</ul>
    			<ul class="nav navbar-nav navbar-right">
      				<li><a href="addTeacher_page.action">Create Teacher Account</a></li>
    			</ul>
  			</div>

			<div id="myModal" class="modal">
  			<div class="modal-content">
    			<span class="close">&times;</span>
    			<div class="form">
					<form class="register-form">
						<div class="imgcontainer">
    						<img src="https://icon-library.net/images/head-icon/head-icon-11.jpg" alt="Avatar" class="avatar">
  						</div>
               			<input type="text" placeholder="user name"/>
               			<input type="password" placeholder="password"/>
                		<button>LOGIN</button>                   
				   	 <span class="acc"> Not Registered? <a href="#">Create an institute</a></span>
    
					</form>
  				</div>
			</div>
			</div>
		</nav>
	
		<section>
			<div class="table-users" id="teacher1"></div>
		</section>

		<footer style="bottom:0px; position:absolute; width:100%">
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
