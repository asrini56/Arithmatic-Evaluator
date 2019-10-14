<html>
   <head>
	<title>Arithmetic Evaluator</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<link rel="stylesheet" href="/arithmetic-evaluator/css/operations.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
         
   </head>
   <body>
		<nav class="navbar navbar-inverse" style="margin-bottom:0px !important">
  			<div class="container-fluid">
    			<div class="navbar-header">
      				<a class="navbar-brand titleText" href="#">Arithmetic Evaluator</a>
    			</div>
    			<ul class="nav navbar-nav navbar-right">
    				<li class="active fontSansSerif"><a href="#">Home</a></li>
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

<!-- The Modal -->
			<div id="myModal" class="modal">
	<!-- Modal content -->
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
  	<nav>
		<h1 class="splitHeading"> Operations </h1>

			<div id="operationsDiv" class="operationsDiv" ondragenter="return dragEnter(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
			
				<div id="num1" class="numbersBox" draggable="true" ondragenter="return dragEnter(event)" ondragstart="return dragStart(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)" ">
     				<button style="background-color:#438687">1</button>
				</div>

    			<div id="num2" class="numbersBox" draggable="true" ondragenter="return dragEnter(event)" ondragstart="return dragStart(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
    				<button type="button" style="background-color:#438687">2</button>
				</div>
				
				<div id="num3" class="numbersBox" draggable="true" ondragenter="return dragEnter(event)" ondragstart="return dragStart(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
    				<button type="button" style="background-color:#438687">3</button>
				</div>
				
				<div id="num4" class="numbersBox" draggable="true" ondragenter="return dragEnter(event)" ondragstart="return dragStart(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
    				<button type="button" style="background-color:#438687">4</button>
				</div>
				
				<div id="num5" class="numbersBox" draggable="true" ondragenter="return dragEnter(event)" ondragstart="return dragStart(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
    				<button type="button" style="background-color:#438687">5</button>
				</div>
				<br><br>
				<div id="num6" class="numbersBox" draggable="true" ondragenter="return dragEnter(event)" ondragstart="return dragStart(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
    				<button type="button" style="background-color:#438687">6</button>
				</div>
				
				<div id="num7" class="numbersBox" draggable="true" ondragenter="return dragEnter(event)" ondragstart="return dragStart(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
    				<button type="button" style="background-color:#438687">7</button>
				</div>
				
				<div id="num8" class="numbersBox" draggable="true" ondragenter="return dragEnter(event)" ondragstart="return dragStart(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
    				<button type="button" style="background-color:#438687">8</button>
				</div>
				
				<div id="num9" class="numbersBox" draggable="true" ondragenter="return dragEnter(event)" ondragstart="return dragStart(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
    				<button type="button" style="background-color:#438687">9</button>
				</div>
				
				<div id="num10" class="numbersBox" draggable="true" ondragenter="return dragEnter(event)" ondragstart="return dragStart(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
    				<button type="button" style="background-color:#438687">10</button>
				</div>
				
				<br/> <br/> <br/> <br> <hr>
				<div style="margin-left:7%">
					<div id="add" class="operationsBox" draggable="true" ondragenter="return dragEnter(event)" ondragstart="return dragStart(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
    					<button type="button" style="background-color:#438687">+</button>
					</div>
					<div id="subtract" class="operationsBox" draggable="true" ondragenter="return dragEnter(event)" ondragstart="return dragStart(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
    					<button type="button" style="background-color:#438687">-</button>
					</div>
					<div id="div" class="operationsBox" draggable="true" ondragenter="return dragEnter(event)" ondragstart="return dragStart(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
    					<button type="button" style="background-color:#438687">/</button>
					</div>
					<div id="mul" class="operationsBox" draggable="true" ondragenter="return dragEnter(event)" ondragstart="return dragStart(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
    					<button type="button" style="background-color:#438687">x</button>
					</div>
				</div>
			</div>
  </nav>
  <nav>
	<h1 class="splitHeading">Canvas</h1>
		<div id="boxB" ondragenter="return dragEnter(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)" ondragstart="return dragStart(event)">
		</div>	
		
		<div class="deleteAction">
			
			<button type="button" id="delete" class="btn btn-success canvasButton deleteButton glyphicon glyphicon-trash" onClick="deleteSelectedButton()" ></button>
		</div>
		<br><br>
		<button type="button" id="submit" onClick="evaluvate()" class="btn btn-success canvasButton">Submit</button>
  </nav>	

  <nav>
    <h1 class="splitHeading">Result</h1>
    <div class="expressionResultDiv" ><span id="expressionResult"></span></div>
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
	 var expression = "";
	 $( ".performOperation" ).each(function( index ) {
		 expression += $( this ).text().trim();
		});
	 
	 expression = expression.replace("x", "*");
	 expression = encodeURIComponent(expression);
	 console.log("Final Expression is " + expression);
	 var url="/arithmetic-evaluator/grade1/operations/evaluvate.action?expression=" + expression;
	 sendAjaxRequest(url, function(resp){
		var result = resp.response;
		console.log(result);
		$("#expressionResult").html(result);
	 });
	 
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
