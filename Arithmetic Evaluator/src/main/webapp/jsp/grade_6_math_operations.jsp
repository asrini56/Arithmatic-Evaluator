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
					<button id="basicMathBtn" class="btn btn-primary active" onClick="basicMathClicked()">Basic Math</button> <br/>
					<button id="pemdasBtn" class="btn btn-primary" onClick="pemdasClicked()">PEMDAS</button><br/>
					<button id="areasBtn" class="btn btn-primary" onClick="areasClicked()">Areas</button><br/>
				</div>
				<div class="vl"></div>
				<div id="basicMathDiv">
					<div id="operationsDiv" class="operationsDiv"
						ondragenter="return dragEnter(event)"
						ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
						<div id="num1" class="numbersBox" draggable="true"
							ondragenter="return dragEnter(event)"
							ondragstart="return dragStart(event)"
							ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
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
							<button type="button" style="background-color: #438687">0</button>
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
				<div id="pemdasDiv" class="hide">
					<div id="operationsDiv" class="operationsDiv"
						ondragenter="return dragEnter(event)"
						ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
						<div id="num1" class="numbersBox" draggable="true"
							ondragenter="return dragEnter(event)"
							ondragstart="return dragStart(event)"
							ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
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
							<button type="button" style="background-color: #438687">0</button>
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
							<br>
							<div id="exp" class="operationsBox" draggable="true"
								ondragenter="return dragEnter(event)"
								ondragstart="return dragStart(event)"
								ondrop="return dragDrop(event)"
								ondragover="return dragOver(event)">
								<button type="button">^</button>
							</div>
							<div id="paranthesis" class="operationsBox" style="width:60px !important" draggable="true"
								ondragenter="return dragEnter(event)"
								ondragstart="return dragStart(event)"
								ondrop="return dragDrop(event)"
								ondragover="return dragOver(event)">
								<button type="button">( ... )</button>
							</div>
							<div id="openPara" class="operationsBox hide">
								<button type="button">(</button>
							</div>
							<div id="closePara" class="operationsBox hide">
								<button type="button">)</button>
							</div>
						</div>
					</div>
				</div>
				<div id="areasDiv" class="hide">
					<div class="shapesDiv">
						<table>
							<tr style="border-bottom: 1px solid grey;">
								<td style="padding:10px">
									<span style="margin-left:15px; font-size:12px !important;">Square</span><br/>
									<div id="square" class="square shape" draggable="true" ondragenter="return dragEnter(event)"
								 	ondragstart="return dragStart(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
									</div>
									
								</td>
								<td>
									<span style="margin-left:15px; margin-top:10px; font-size:12px !important;">Rectangle</span><br/>
									<div id="rectangle" class="rectangle shape" draggable="true" ondragenter="return dragEnter(event)"
								 	ondragstart="return dragStart(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
									</div>
								</td>
							</tr>
						 	<tr>
							<td style="padding:10px">
								<span style="margin-left:15px; font-size:12px !important;">Triangle</span><br/>
								<div id="triangle" class="triangle" draggable="true" ondragenter="return dragEnter(event)"
								 	ondragstart="return dragStart(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
								</div>
							</td>
							<td>
								<span style="margin-left:15px; font-size:12px !important;">Circle</span><br/>
								<div id="circle" class="circle shape" draggable="true" ondragenter="return dragEnter(event)"
								 	ondragstart="return dragStart(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
								</div>
							</td>
							</tr>
						</table>
						<div id="square_area_div" class="isShape sq fl hide">
							<div class="square shape"></div>
							<div style="margin-top:20px; float:left">
								<label>side:</label>
								<input id="sqside" type="text"  size="5" placeholder="1"/>
								<span>(unit)</span>
							</div><br/><br/><br/><br/>
							<span class="fl">Area = side x side</span>
						</div>
						<div id="rectangle_area_div" class="isShape rec fl hide">
							<div class="rectangle shape"></div>
							<div style="margin-top:10px; float:left">
								<label>length:</label>
								<input id="rlength" type="text" placeholder="1" size="5"/>
								<span>(unit)</span><br/>
								<label>breadth:</label>
								<input id="rbreadth" type="text" placeholder="1" size="5"/>
								<span>(unit)</span>
							</div><br/><br/><br/>
							<span class="fl">Area = length x breadth</span>
						</div>
						<div id="triangle_area_div" class="isShape tri fl hide">
							<div class="triangle"></div>
							<div style="margin-top:10px; float:left">
								<label>base:</label>
								<input id="tbase" type="text" placeholder="1" size="5"></input>
								<span>(unit)</span><br/>
								<label>height:</label>
								<input id="theight" type="text" placeholder="1" size="5"/>
								<span>(unit)</span>
							</div><br/><br/><br/>
							<span class="fl">Area = 1/2 (base x height)</span>
						</div>
						<div id="circle_area_div" class="isShape cir fl hide">
							<div class="circle shape"></div>
							<div style="margin-top:20px; float:left">
								<label>radius:</label>
								<input id="cradius" type="text" placeholder="1" size="5"/>
								<span>(unit)</span>
							</div><br/><br/><br/>
							<span class="fl">Area = pi(3.14) * radius x radius</span>
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
					onClick="deleteSelectedButton()"  title="Delete button"></button>
			</div>
			<br/>
			<br/>
			<button type="button" id="submit" onClick="evaluate1()"
				class="btn btn-success canvasButton">Submit
			</button>
			<br/>
			<br/>
			<div class="reset">
				<button type="button" id="delete"
					class="btn btn-success canvasButton deleteButton glyphicon glyphicon-refresh"
					onClick="resetButton()" title="Reset Expression">&nbsp;<span>Reset</span></button>
			</div>
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
		function cloneAndAddShape(shape) {
			resetButton();
			$btn = $('#' + shape + '_area_div').clone();
			$btn.removeClass("hide");
			$btn.addClass("performOperation");
			if(shape = "square") {
				$btn.find("#sqside").attr('id', 'side');
			}
			if(shape = "rectangle") {
				$btn.find("#rlength").attr('id', 'length');
				$btn.find("#rbreadth").attr('id', 'breadth');
			}
			if(shape = "triangle") {
				$btn.find("#tbase").attr('id', 'base');
				$btn.find("#theight").attr('id', 'height');
			}
			if(shape = "circle") {
				$btn.find("#cradius").attr('id', 'radius');
			}
			$("#boxB").append($btn);
		}

		function isShapeDiv(shape) {
			if(shape =="square" || shape=="triangle" || shape == "rectangle" || shape== "circle"){
				return true;
			}
		}
		function dragDrop(ev) {
			var src = ev.dataTransfer.getData("Text");
			if(isShapeDiv(src)){
				cloneAndAddShape(src);
				return;
			}
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
			} else if(src == "paranthesis") {
				var $lastVal;
				var firstElement = true;
				$(".performOperation").each(function(index) {
					if(firstElement == true) {
						$openPara = $('#openPara').clone();
						$openPara.addClass("performOperation");
						$openPara.removeClass("hide");
						$openPara.attr('id', 'id' + cloneCount)
						$openPara.attr('onClick', 'selectedButton("id' + cloneCount + '")');
						$openPara.insertBefore($(this));
						firstElement = false;
					}
					$lastVal = $(this);
				});
				$closePara = $('#closePara').clone();
				$closePara.removeClass("hide");
				$closePara.addClass("performOperation");
				cloneCount++;
				$closePara.attr('id', 'id' + cloneCount)
				$closePara.insertAfter($lastVal);
				$closePara.attr('onClick', 'selectedButton("id' + cloneCount + '")');
				cloneCount++;
				cloneCount++;
				return false;
			}
			cloneCount++;
			$("#boxB").append($btn);
			return false;
		}

		function evaluate1() {
			var expression = "";
			var hasShape = false;
			$(".performOperation").each(function(index) {
				if($(this).hasClass("isShape")){
					evaluateArea();
					hasShape = true;
					return;
				} else {
					expression += $(this).text().trim();
				}
			});
			if(hasShape){
				return;
			}
			expression = expression.replace("x", "*");
			expression = expression.replace("X", "*");
			console.log(expression);
			expression = encodeURIComponent(expression);
			var url = "/arithmetic-evaluator/grade1/operations/evaluvate.action?expression="
					+ expression;
			sendAjaxRequest(url, function(resp) {
				var result = resp.response;
				$("#expressionResult").html(result);
			});

		}
		
		function evaluateArea() {
			var expression = "";
			$(".performOperation").each(function(index) {
				if($(this).hasClass("sq")) {
					var side = $('#side').val();
					expression = side * side;
					
				} else if($(this).hasClass("rec")) {
					var length = $('#length').val();
					var breadth = $('#breadth').val();
					expression = length * breadth;
					
				} else if($(this).hasClass("tri")) {
					var base = $('#base').val();
					var height = $('#height').val();
					expression = 0.5 * base * height;
				} else if($(this).hasClass("cir")) {
					var radius = $('#radius').val();
					expression = 3.14 * radius;
				}
			});
			
			expression = encodeURIComponent(expression);
			var url = "/arithmetic-evaluator/grade1/operations/evaluvate.action?expression="
					+ expression;
			sendAjaxRequest(url, function(resp) {
				var result = resp.response;
				$("#expressionResult").html(result);
			});
		}

		function pemdasClicked() {
			$('#basicMathDiv').addClass('hide');
			$('#areasDiv').addClass('hide');
			
			$('#pemdasDiv').removeClass('hide');
			
			$('#pemdasBtn').addClass('active');
			$('#basicMathBtn').removeClass('active');
			$('#areasBtn').removeClass('active');
		}
		function basicMathClicked(){
			$('#areasDiv').addClass('hide');
			$('#pemdasDiv').addClass('hide');
			
			$('#basicMathDiv').removeClass('hide');
			
			$('#basicMathBtn').addClass('active');
			$('#areasBtn').removeClass('active');
			$('#pemdasBtn').removeClass('active');
		}
		function areasClicked() {
			$('#basicMathDiv').addClass('hide');
			$('#pemdasDiv').addClass('hide');
			
			$('#areasDiv').removeClass('hide');
			
			$('#areasBtn').addClass('active');
			$('#basicMathBtn').removeClass('active');
			$('#pemdasBtn').removeClass('active');
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
		
		function resetButton() {
			$(".performOperation").each(function(index) {
				$(this).remove();
			});
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
