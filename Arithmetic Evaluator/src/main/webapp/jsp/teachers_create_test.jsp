<html>
   <head>
	<title>Arithmetic Evaluator</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="/arithmetic-evaluator/css/operations.css">
<link rel="stylesheet" href="/arithmetic-evaluator/css/style_common.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
         
   </head>
   <body>
		<nav class="navbar navbar-inverse" style="margin-bottom:0px !important">
       		<div class="container-fluid">
          	<div class="navbar-header">
              <a class="navbar-brand titleText" href="#">Arithmetic Evaluator</a>
          	</div>
          	<ul class="nav navbar-nav navbar-right">
    				
    				<li><a href="/arithmetic-evaluator/admin/dashboard_page.action">Dashboard</a></li>
    				<li class="#"><a href="#">Tests</a></li>
    				<li class="active fontSansSerif"><a href="#">Create Test</a></li>
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
  	<nav>
		<h1 class="splitHeading"> Question Bricks </h1>

			<div id="operationsDiv" class="operationsDiv" ondragenter="return dragEnter(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
			
				<div id="questionbox1" class="questionsBox" draggable="true" ondragenter="return dragEnter(event)" ondragstart="return dragStart(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)" ">
     				<form>
     					<h1>Question #</h1>
     					<input type="textarea" name="question" placeholder="Enter question here.."></input><br><br>
     					
     					<input type="radio" name="options"><input type="text" name="option1" placeholder="Option1" /></input><br>
     					<input type="radio" name="options"><input type="text" name="option2" placeholder="Option2"/></input><br>
     					<input type="radio" name="options"><input type="text" name="option3" placeholder="Option3"/></input><br>
     					<input type="radio" name="options"><input type="text" name="option4" placeholder="Option4"/></input><br>
     					<p> Please choose the right answer!</p>
     				</form>
				</div>


    			
  </nav>
  <nav>
	<h1 class="splitHeading">Canvas</h1>
		<div id="boxB" ondragenter="return dragEnter(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)" ondragstart="return dragStart(event)">

		</div>	
		
		<div class="deleteAction">
			<!--  <span class="deleteBtnHover">Select a button to delete it</span>-->
			<button type="button" id="delete" class="btn btn-success canvasButton deleteButton" onClick="deleteSelectedButton()" >Delete Button</button>
		</div>
		<br><br>
		<button type="button" id="submit" onClick="evaluvate()" class="btn btn-success canvasButton">Submit</button>
  </nav>	

  <nav>
    <h1 class="splitHeading">Result</h1>
    <div class="expressionResultDiv" ><span id="expressionResult"></span></div>
    <button type="button" id="publish" class="btn btn-success canvasButton">Publish</button>
   </nav>
</section>

	<footer style="bottom:0px; width:100%; position:fixed;">
  			<p style="text-align:center"><span class="glyphicon glyphicon-copyright-mark"></span>  Copyright</p>
		</footer>

<script src="/arithmetic-evaluator/js/common.js"></script>
<script>
var cloneCount = 0;
var selectedBtn;
function dragStart(ev) {
    ev.dataTransfer.effectAllowed='move';
    ev.dataTransfer.setData("Text", ev.target.getAttribute('id'));
    ev.dataTransfer.setDragImage(ev.target,0,0);
    return true;
 }
 function dragEnter(ev) {
    event.preventDefault();
    return true;
 }
 function dragOver(ev) {
    return false;
 }
 function dragDrop(ev) {
    var src = ev.dataTransfer.getData("Text");
    console.log(src);
    $btn = $('#' + src).clone();
 
    $btn.attr('id', 'id'+ cloneCount)
    $btn.attr('onClick','selectedButton("id'+cloneCount+'")');
    $btn.addClass("performOperation");
    $btn.removeAttr("draggable");
    $btn.removeAttr("ondragenter");
    $btn.removeAttr("ondragstart");
    $btn.removeAttr("ondrop");
    $btn.removeAttr("ondragover");
    cloneCount++;
    
	$( "#boxB").append($btn);
    return false;
 }
 
 function evaluvate(){
	 
	 
 }

 function selectedButton(id){
	 selectedBtn = id;
 }
 
 function deleteSelectedButton() { 
	 $('#' + selectedBtn).remove();
	 selectedBtn = "";
 }

// Get the modal
	var modal = document.getElementById("myModal");

	// Get the button that opens the modal
	var btn = document.getElementById("myBtn");

	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];

	// When the user clicks on the button, open the modal
	btn.onclick = function() {
	  modal.style.display = "block";
	}

	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
	  modal.style.display = "none";
	}

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	  if (event.target == modal) {
	    modal.style.display = "none";
	  }
	}

</script>
   </body>
</html>
