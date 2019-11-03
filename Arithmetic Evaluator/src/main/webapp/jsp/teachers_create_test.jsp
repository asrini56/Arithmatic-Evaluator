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
     					<input type="textarea" name="question" id="question" placeholder="Enter question here.."></input><br><br>
     					
     					<input type="radio" name="options" id="answerOpt1"><input type="text" name="option1" id="option1" placeholder="Option1" /></input><br>
     					<input type="radio" name="options" id="answerOpt1"><input type="text" name="option2" id="option2" placeholder="Option2"/></input><br>
     					<input type="radio" name="options" id="answerOpt1"><input type="text" name="option3" id="option3" placeholder="Option3"/></input><br>
     					<input type="radio" name="options" id="answerOpt1"><input type="text" name="option4" id="option4" placeholder="Option4"/></input><br>
     					<p> Please choose the right answer!</p>
     				</form>
				</div>
		</div>

    			
  </nav>
  <nav>
	<h1 class="splitHeading">Canvas</h1>
		<div id="message" class="alert alert-info display-none"></div>
		<div id="boxB" ondragenter="return dragEnter(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)" ondragstart="return dragStart(event)">
		</div>	
		
		
		<div class="deleteAction">
			<!--  <span class="deleteBtnHover">Select a button to delete it</span>-->
			<button type="button" id="delete" class="btn btn-success canvasButton deleteButton" onClick="deleteSelectedButton()" >Delete Button</button>
		</div>
		<br><br>
		<button type="button" id="preview" onClick="preview()" class="btn btn-success canvasButton">Preview</button>
  </nav>	

  <nav>
    <h1 class="splitHeading">Result</h1>
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
    <div class="previewDiv" id="previewDiv">
    </div>
    <button type="button" id="publish" class="btn btn-success canvasButton">Publish</button>
   </nav>
</section>

	<footer class="footer"><span class="glyphicon glyphicon-copyright-mark"></span>  Copyright</footer>

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
			console.log(src);
			$btn = $('#' + src).clone();

			$btn.attr('id', 'id' + cloneCount)
			$btn.attr('onClick', 'selectedButton("id' + cloneCount + '")');
			$btn.addClass("performOperation");
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
				
				console.log(option1 + " " + option2 + " " + option3 + " " + option4)
				if(option1 === "" || option2 === "" || option3 ==="" || option4 ==="" ) {
					console.log("Here");
					$("#message").text("Enter all 4 options for  " + question);
					$("#message").show();
					setTimeout(function() {$("#message").hide();}, 5000);
					return;
				}
				if($(this).find("#answerOpt1").is(':checked')){
					answer = option1;
				} else if($(this).find("#answerOpt2").is(':checked')){
					answer = option2;
				} else if($(this).find("#answerOpt3").is(':checked')){
					answer = option3;
				} else if($(this).find("#answerOpt4").is(':checked')){
					answer = option4;
				} else {
					$("#message").text("Select an answer for " + question);
					$("#message").show();
					setTimeout(function() {$("#message").hide();}, 5000);
					return;
				}
				
				console.log("q " + question + " " + option1 + " ");
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
