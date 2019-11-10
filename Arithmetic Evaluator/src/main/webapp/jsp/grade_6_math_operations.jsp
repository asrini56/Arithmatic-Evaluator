<html>
   <head>
	<title>Arithmetic Evaluator</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="/arithmetic-evaluator/css/grade_6_math_operations.css">
<link rel="stylesheet" href="/arithmetic-evaluator/css/style_common.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="/arithmetic-evaluator/js/common.js"></script>
         
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
		<nav style="text-align:center;">
			<h3 class="splitHeading">Operations</h3>
			<div class="overAllOperations" >
			<div id="syllabusDiv" class="syllabusDiv" >
				<span> <b>Select Syllabus </b></span><br/>
				<hr>
				<button class="btn btn-primary active">Basic Math</button> <br/>
				<button class="btn btn-primary">Bodmass</button><br/>
				<button class="btn btn-primary">Area</button><br/>
			</div>
			<div class="vl">
			</div>
			<div id="operationsDiv" class="operationsDiv"
				ondragenter="return dragEnter(event)"
				ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
				<div id="num1" class="numbersBox" draggable="true"
					ondragenter="return dragEnter(event)"
					ondragstart="return dragStart(event)"
					ondrop="return dragDrop(event)" ondragover="return dragOver(event)"">
					<button style="background-color: #438687">1</button>
				</div>

				<div id="num2" class="numbersBox" draggable="true"
					ondragenter="return dragEnter(event)"
					ondragstart="return dragStart(event)"
					ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
					<button type="button" style="background-color: #438687">2</button>
				</div>

				<div id="num3" class="numbersBox" draggable="true"
					ondragenter="return dragEnter(event)"
					ondragstart="return dragStart(event)"
					ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
					<button type="button" style="background-color: #438687">3</button>
				</div>

				<div id="num4" class="numbersBox" draggable="true"
					ondragenter="return dragEnter(event)"
					ondragstart="return dragStart(event)"
					ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
					<button type="button" style="background-color: #438687">4</button>
				</div>

				<div id="num5" class="numbersBox" draggable="true"
					ondragenter="return dragEnter(event)"
					ondragstart="return dragStart(event)"
					ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
					<button type="button" style="background-color: #438687">5</button>
				</div>
				<br> <br>
				<div id="num6" class="numbersBox" draggable="true"
					ondragenter="return dragEnter(event)"
					ondragstart="return dragStart(event)"
					ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
					<button type="button" style="background-color: #438687">6</button>
				</div>

				<div id="num7" class="numbersBox" draggable="true"
					ondragenter="return dragEnter(event)"
					ondragstart="return dragStart(event)"
					ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
					<button type="button" style="background-color: #438687">7</button>
				</div>

				<div id="num8" class="numbersBox" draggable="true"
					ondragenter="return dragEnter(event)"
					ondragstart="return dragStart(event)"
					ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
					<button type="button" style="background-color: #438687">8</button>
				</div>

				<div id="num9" class="numbersBox" draggable="true"
					ondragenter="return dragEnter(event)"
					ondragstart="return dragStart(event)"
					ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
					<button type="button" style="background-color: #438687">9</button>
				</div>

				<div id="num10" class="numbersBox" draggable="true"
					ondragenter="return dragEnter(event)"
					ondragstart="return dragStart(event)"
					ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
					<button type="button" style="background-color: #438687">10</button>
				</div>

				<br /> <br /> <br /> <br>
				<hr>
				<div style="margin-left: 7%">
					<div id="add" class="operationsBox" draggable="true"
						ondragenter="return dragEnter(event)"
						ondragstart="return dragStart(event)"
						ondrop="return dragDrop(event)"
						ondragover="return dragOver(event)">
						<button type="button">+</button>
					</div>
					<div id="subtract" class="operationsBox" draggable="true"
						ondragenter="return dragEnter(event)"
						ondragstart="return dragStart(event)"
						ondrop="return dragDrop(event)"
						ondragover="return dragOver(event)">
						<button type="button">-</button>
					</div>
					<div id="div" class="operationsBox" draggable="true"
						ondragenter="return dragEnter(event)"
						ondragstart="return dragStart(event)"
						ondrop="return dragDrop(event)"
						ondragover="return dragOver(event)">
						<button type="button">/</button>
					</div>
					<div id="mul" class="operationsBox" draggable="true"
						ondragenter="return dragEnter(event)"
						ondragstart="return dragStart(event)"
						ondrop="return dragDrop(event)"
						ondragover="return dragOver(event)">
						<button type="button">x</button>
					</div>
				</div>
			</div>
			</div>
		</nav>
		<nav style="text-align:center;">
			<h3 class="splitHeading">Canvas</h3>
			<div id="boxB" ondragenter="return dragEnter(event)"
				ondrop="return dragDrop(event)" ondragover="return dragOver(event)"
				ondragstart="return dragStart(event)"></div>

			<div class="deleteAction">
				<button type="button" id="delete"
					class="btn btn-success canvasButton deleteButton glyphicon glyphicon-trash"
					onClick="deleteSelectedButton()"></button>
			</div>
			<br>
			<br>
			<button type="button" id="submit" onClick="evaluate1()"
				class="btn btn-success canvasButton">Submit</button>
		</nav>
		<nav style="min-width: 400px !important; max-width: 400px !important; text-align:center;">
			<h3 class="splitHeading">Result</h3>
			<div class="expressionResultDiv">
				<span id="expressionResult"></span>
			</div>
		</nav>
	</section>
	
	<script>
		var cloneCount = 0;
		var selectedBtn = "";
		function dragStart(ev) {
			ev.dataTransfer.effectAllowed = 'move';
			ev.dataTransfer.setData("Text", ev.target.getAttribute('id'));
			ev.dataTransfer.setDragImage(ev.target, 0, 0);
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
			var $lastVal;
			$btn = $('#' + src).clone();
			$btn.attr('id', 'id' + cloneCount)
			$btn.attr('onClick', 'selectedButton("id' + cloneCount + '")');
			$btn.addClass("performOperation");
			$btn.removeAttr("draggable");
			$btn.removeAttr("ondragenter");
			$btn.removeAttr("ondragstart");
			$btn.removeAttr("ondrop");
			$btn.removeAttr("ondragover");
			if($.isNumeric(($btn.text().trim()))){
				$(".performOperation").each(function(index) {
					$lastVal = $(this);
				});
				if($lastVal != null) {
					if($.isNumeric($lastVal.text().trim())){
						var val = $lastVal.text().trim();
						$lastVal.remove();
						$btn.find("button").text(val + $btn.text().trim());
					}
				}
			}
			cloneCount++;

			$("#boxB").append($btn);
			return false;
		}

		function evaluate1() {
			var expression = "";
			$(".performOperation").each(function(index) {
				expression += $(this).text().trim();
			});

			expression = expression.replace("x", "*");
			expression = encodeURIComponent(expression);
			var url = "/arithmetic-evaluator/grade1/operations/evaluvate.action?expression="
					+ expression;
			sendAjaxRequest(url, function(resp) {
				var result = resp.response;
				console.log(result);
				$("#expressionResult").html(result);
			});

		}

		function selectedButton(id) {
			selectedBtn = id;
		}

		function deleteSelectedButton() {
			if(selectedBtn == ""){
				window.alert("Select a button to delete it");
			} else {
				$('#' + selectedBtn).remove();
			}
			selectedBtn = "";
		}

		var modal = document.getElementById("myModal");

		var btn = document.getElementById("myBtn");

		var span = document.getElementsByClassName("close")[0];

		btn.onclick = function() {
			modal.style.display = "block";
		}

		span.onclick = function() {
			modal.style.display = "none";
		}

		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>
</body>
</html>
