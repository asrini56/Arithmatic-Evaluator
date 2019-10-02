<!DOCTYPE html>
<html>
<head>
<title>Teacher List</title>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="../js/common.js"></script>
<script type="text/javascript">
	function callMyAction() {
    	 var url="listTeachers.action";
    	 sendAjaxRequest(url, function(resp){
    		console.log(resp);
    		var result = resp.response;
    		console.log(result);
    		$("#teacher1").html(result);
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