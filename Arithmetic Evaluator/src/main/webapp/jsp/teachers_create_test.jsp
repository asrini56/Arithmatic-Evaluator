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
    				
    				<li><a href="/arithmetic-evaluator/teacher/dashboard.action">Dashboard</a></li>
    				<li class="#"><a href="/arithmetic-evaluator/teacher/viewtests_page.action">Tests</a></li>
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
  	<nav style="min-height:800px !important">
		<h1 class="splitHeading"> Question Bricks </h1>
		<h2 style="text-align: center;">Drag test component to Canvas section</h2>
			<div id="operationsDiv" class="operationsDiv" ondragenter="return dragEnter(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
			
				<div id="questionbox1" class="questionsBox" draggable="true" ondragenter="return dragEnter(event)" ondragstart="return dragStart(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)" ondragstart="return dragStart(event)">
     				<form>
     					<h1>Question #</h1>
     					<input type="textarea" name="question" id="question" disabled></input><br><br>
     					
     					<input type="radio" name="options" id="answerOpt1"/><input type="text" name="option1" id="option1" disabled /><br>
     					<input type="radio" name="options" id="answerOpt2"/><input type="text" name="option2" id="option2" disabled/><br>
     					<input type="radio" name="options" id="answerOpt3"/><input type="text" name="option3" id="option3" disabled/><br>
     					<input type="radio" name="options" id="answerOpt4"/><input type="text" name="option4" id="option4"  disabled/><br>
     					<p> Drag into canvas!</p>
     				</form>
				</div>
				<div id="questionbox2" class="questionsBox hide" draggable="true" ondragenter="return dragEnter(event)" ondragstart="return dragStart(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)" ondragstart="return dragStart(event)">
     				<form>
     					<h1>Question #</h1>
     					<input type="textarea" name="question" id="question" placeholder="Enter question here.."></input><br><br>
     					
     					<input type="radio" name="options" id="answerOpt1"/><input type="text" name="option1" id="option1" placeholder="Option1" /><br>
     					<input type="radio" name="options" id="answerOpt2"/><input type="text" name="option2" id="option2" placeholder="Option2"/><br>
     					<input type="radio" name="options" id="answerOpt3"/><input type="text" name="option3" id="option3" placeholder="Option3"/><br>
     					<input type="radio" name="options" id="answerOpt4"/><input type="text" name="option4" id="option4" placeholder="Option4"/><br>
     					<p> Please choose the right answer!</p>
     				</form>
				</div>
		</div>

    			
  </nav>
  <nav style="min-height:800px !important">
	<h1 class="splitHeading">Canvas</h1>
		<div id="message" class="alert alert-info display-none"></div>
		<div id="boxB" style ="min-height:570px !important" ondragenter="return dragEnter(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)" ondragstart="return dragStart(event)">
		</div>
		
		<div class="deleteAction" style="margin-top:20px; border-top: 1px solid grey; padding:5px;">
			<button type="button" id="delete"
					class="btn btn-success canvasButton deleteButton glyphicon glyphicon-trash"
					onClick="deleteSelectedButton()"></button>
		</div>
		<br><br>
		<button type="button" id="preview" onClick="preview()" class="btn btn-success canvasButton">Preview</button>
  </nav>	

  <nav style="min-height:800px !important">
    <h1 class="splitHeading">Preview</h1>
    <div class= "questionPreviewTemplateDiv" style="display:none">
    		<div class="questionPreviewTemplate" id="questionPreviewTemplate">
    			<h2>Question : <span id="previewQuestion"></span></h2>
    			<h3> Option1: <span id="previewOption1"></span><br></h3>
    			<h3> Option2: <span id="previewOption2"></span><br></h3>
    			<h3> Option3: <span id="previewOption3"></span><br></h3>
    			<h3> Option4: <span id="previewOption4"></span><br></h3>
    			<h3> Answer is: <span id="previewAnswer"></span><br/></h3>
    			<hr>
    		</div>
    	</div>
    <div class="previewDiv" id="previewDiv" style ="min-height:600px !important">
    </div>
    <button type="button" id="publish" onClick="saveDialogBox()" class="btn btn-success canvasButton">Publish</button>
   	</nav>
	</section>

	<div id="myModal" class="saveAssignmentDialog">	
		<div class="saveAssignmentDialog-content">
			<span class="saveAssignmentDialog-close">&times;</span>
			<table>
				<tr style="height:40px">
					<td><label>Test Name</label></td> 
					<td><input type="text" id="testName"/></td>
				</tr>
				<tr style="height:40px">
					<td><label>Test for Grade</label></td> 
					<td>
						<select id="testForGrade">
 							<option value = "1">Grade 1</option>
  							<option value ="6">Grade 6</option>
  							<option value="9">Grade 9</option> 
						</select>
					</td>
				</tr>
				<tr style="height:40px">
					<td></td>
					<td><button type="button" id="preview" onClick="publish()" class="btn btn-success canvasButton">Save Test</button></td>
				</tr>
			</table>
		</div>
	</div>
	
		

	<script src="/arithmetic-evaluator/js/common.js"></script>
	<script>
		var cloneCount = 0;
		var selectedBtn;
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
			
			$btn = $('#questionbox2').clone();

			$btn.attr('id', 'id' + cloneCount)
			$btn.attr('onClick', 'selectedButton("id' + cloneCount + '")');
			$btn.addClass("performOperation");
			$btn.removeClass("hide");
			$btn.removeAttr("draggable");
			$btn.removeAttr("ondragenter");
			$btn.removeAttr("ondragstart");
			$btn.removeAttr("ondrop");
			$btn.removeAttr("ondragover");

			cloneCount++;

			$("#boxB").append($btn);
			return false;
		}
		
		function preview() {
			$("#previewDiv").text("");
			$(".performOperation").each(function(index) {
				var question = $(this).find("#question").val();
				var option1 = $(this).find("#option1").val().trim();
				var option2 = $(this).find("#option2").val().trim();
				var option3 = $(this).find("#option3").val().trim();
				var option4 = $(this).find("#option4").val().trim();
				var answer = "";
				
				if(question === "") {
					$("#message").text("One of the question's description is empty ");
					$("#message").show();
					setTimeout(function() {$("#message").hide();}, 5000);
					return;
				}
				if(option1 === "" || option2 === "" || option3 ==="" || option4 ==="" ) {
					$("#message").text("Enter all 4 options for the question - " + question);
					$("#message").show();
					setTimeout(function() {$("#message").hide();}, 5000);
					return;
				}
				
				
				var radio1Value = $(this).find("#answerOpt1").is(':checked');
				var radio2Value = $(this).find("#answerOpt2").is(':checked');
				var radio3Value = $(this).find("#answerOpt3").is(':checked');
				var radio4Value = $(this).find("#answerOpt4").is(':checked');
				
				if(radio1Value){
					answer = option1;
				} else if(radio2Value){
					answer = option2;
				} else if(radio3Value){
					answer = option3;
				} else if(radio4Value){
					answer = option4;
				} else {
					$("#message").text("Select an answer for the question " + question);
					$("#message").show();
					setTimeout(function() {$("#message").hide();}, 5000);
					return;
				}
				
				$previewElement = $('#questionPreviewTemplate').clone();
				$previewElement.find("#previewQuestion").text(question);
				$previewElement.find("#previewOption1").text(option1);
				$previewElement.find("#previewOption2").text(option2);
				$previewElement.find("#previewOption3").text(option3);
				$previewElement.find("#previewOption4").text(option4);
				$previewElement.find("#previewAnswer").text(answer);
				$("#previewDiv").append($previewElement);
				
			});
		}

		function saveDialogBox(){
			if(!validate()){
				return;
			}
			var modal = document.getElementById("myModal");
			var span = document.getElementsByClassName("saveAssignmentDialog-close")[0];			
			modal.style.display = "block";
			span.onclick = function() {
			  modal.style.display = "none";
			}
			window.onclick = function(event) {
			  if (event.target == modal) {
			    modal.style.display = "none";
			  }
			}			
		}

		function validate() {
			$(".performOperation").each(function(index) {
				var question = $(this).find("#question").val();
				var option1 = $(this).find("#option1").val().trim();
				var option2 = $(this).find("#option2").val().trim();
				var option3 = $(this).find("#option3").val().trim();
				var option4 = $(this).find("#option4").val().trim();
				var answer = "";
				
				if(question === "") {
					$("#message").text("One of the question's description is empty ");
					$("#message").show();
					setTimeout(function() {$("#message").hide();}, 5000);
					return false;
				}
				if(option1 === "" || option2 === "" || option3 ==="" || option4 ==="" ) {
					$("#message").text("Enter all 4 options for the question - " + question);
					$("#message").show();
					setTimeout(function() {$("#message").hide();}, 5000);
					return false;
				}
			});
			return true;
		}
		function publish() {
			var allQuestions = [];
			$(".performOperation").each(function(index) {
				var question = $(this).find("#question").val();
				var option1 = $(this).find("#option1").val().trim();
				var option2 = $(this).find("#option2").val().trim();
				var option3 = $(this).find("#option3").val().trim();
				var option4 = $(this).find("#option4").val().trim();
				var answer = "";
				
				if(question === "") {
					$("#message").text("One of the question's description is empty ");
					$("#message").show();
					setTimeout(function() {$("#message").hide();}, 5000);
					return;
				}
				if(option1 === "" || option2 === "" || option3 ==="" || option4 ==="" ) {
					$("#message").text("Enter all 4 options for the question - " + question);
					$("#message").show();
					setTimeout(function() {$("#message").hide();}, 5000);
					return;
				}
				
				
				var radio1Value = $(this).find("#answerOpt1").is(':checked');
				var radio2Value = $(this).find("#answerOpt2").is(':checked');
				var radio3Value = $(this).find("#answerOpt3").is(':checked');
				var radio4Value = $(this).find("#answerOpt4").is(':checked');
				
				if(radio1Value){
					answer = 1;
				} else if(radio2Value){
					answer = 2;
				} else if(radio3Value){
					answer = 3;
				} else if(radio4Value){
					answer = 4;
				} else {
					$("#message").text("Select an answer for the question " + question);
					$("#message").show();
					setTimeout(function() {$("#message").hide();}, 5000);
					return;
				}
				
				var questionObj = new Object();
				questionObj.question=question;
				questionObj.option1=option1;
				questionObj.option2=option2;
				questionObj.option3=option3;
				questionObj.option4=option4;
				questionObj.answer=answer;
				allQuestions.push(questionObj);
				var json = new Object();
				json.questions = allQuestions;
				
				var testName = $("#testName").val();
				var grade = $("#testForGrade").val();
				var params = "testName="+testName+ "&testForGrade="+ grade + "&questionsJSONAsString=" +  encodeURIComponent(JSON.stringify(json));
				var url = "/arithmetic-evaluator/teacher/test/add.action?" + params;
				console.log("url" + url);
				sendAjaxRequest(url, function(resp) {
					var response = resp.message;
					console.log(response);
					var modal = document.getElementById("myModal");
					modal.style.display = "none";
					$("#message").text(response);
					$("#message").show();
					setTimeout(function() {$("#message").hide();}, 5000);
				});
			});
			
			
		}
		function selectedButton(id) {
			selectedBtn = id;
		}

		function deleteSelectedButton() {
			$('#' + selectedBtn).remove();
			selectedBtn = "";
		}

	</script>
</body>
</html>
