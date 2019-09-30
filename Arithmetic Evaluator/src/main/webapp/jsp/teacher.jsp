<!DOCTYPE html>
<html>
<head>
<title>Teacher List</title>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript">
	function callMyAction() {
	alert("Successful callMyAction!!");
		$.ajax({
			type : "GET",
			url : "http://localhost:8080/arithmetic-evaluator/admin/listTeachers.action",
			success : function(itr) {
			alert("Successful ajax call!!");
				var x = "<ol>";
				$.each(itr.teachers, function() {
					x += "<li>" + this + "</li>";
				});
				x += "</ol>";
				$("#teacher1").html(x);
			},
			error : function(itr) {
				alert("No values found..!!");
			}
		});
	}
</script>
</head>
<body style="margin-left: 15%;">
	<h1>Teacher</h1>
	<button type="submit" onclick="callMyAction()">Call Me</button>
	<div id="teacher1" style="color: green; font-size: 25px;"></div>
</body>
</html>