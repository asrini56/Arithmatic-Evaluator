<!DOCTYPE html>
<html>
<head>
<title>Teacher List</title>
</head>
<body>
<style>
    body{
        background-color: darkgrey;
    }
    table, th, td {
        border: 1px solid black;
    border-collapse: collapse;
    }
    th, td {
        padding: 5px;
        text-align: center;
    }
    th{
        background-color: #4C669F;
    }
.button1{
    font-family: "Roboto", sans-serif;
    text-transform: uppercase;
    outline: 0;
    background: #6E7C9A;
    width: 100%;
    border: 0;
    padding: 15px;
    color: #FFFFFF;
    font-size: 14px;
    cursor: pointer;

}

table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="../js/common.js"></script>
<script type="text/javascript">
	window.onload = function() {
	     var url="listTeachers.action";
    	 sendAjaxRequest(url, function(resp){
            var x = "<table>";
            x+="<tr><th>EMAIL</th><th>FIRST NAME</th><th>LAST NAME</th></tr>"
    	    $.each(resp.teachers, function() {
    	        x+= "<tr>";
                x += "<td>" + this.email + "</td>";
                x += "<td>" + this.firstName + "</td>";
                x += "<td>" + this.lastName + "</td>";
                x += "</tr>";
            });
            x += "</table>";
    		$("#teacher1").html(x);
    	 });

     };

 function buttonclick(){
         window.location="addTeacher_page.action";
     }
</script>
	<h1 align="center">List of Teachers</h1>
	<div id="teacher1" style="color: green; font-size: 25px;"></div>
	<br><br><br>
        <button type="submit" class="button button1" onclick="buttonclick()" >Create Teacher</button>

</body>
</html>