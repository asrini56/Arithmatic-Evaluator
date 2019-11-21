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
	<h1 class="splitHeading">Canvas</h1>
		<div style="height:592px; min-height:592px;">
			<div id="assignmentQuestionsTemplate" class="display-none">
				<div id="assignmentQuestions">
						<h3 id="question"></h3>
						<input type="radio" name="options" id="answerOpt1" />
						<input type="text" name="option1" id="option1" /><br> 
						<input type="radio" name="options" id="answerOpt2" />
						<input type="text" name="option2" id="option2" /><br> 
						<input type="radio" name="options" id="answerOpt3" />
						<input type="text" name="option3" id="option3" /><br> 
						<input type="radio" name="options" id="answerOpt4" />
						<input type="text" name="option4" id="option4" /><br>
				</div>
			</div>
			<div id="questionsCanvasDiv">
			<div id="message" class="alert alert-info display-none"></div>
		</div>
		</div>
		
		<button type="button" id="preview" onClick="preview()" class="btn btn-success canvasButton">Preview</button>
		
  </nav>	

  <nav style="min-height:800px !important">
    <h1 class="splitHeading">Preview</h1>
    <div class= "questionPreviewTemplateDiv" style="display:none">
   		<div class="questionPreviewTemplate" id="questionPreviewTemplate">
   			<h2>Question : <span id="previewQuestion"></span></h2>
   			<h3> Answer is: <span id="previewAnswer"></span><br/></h3>
   			<hr>
   		</div>
    </div>
    <div class="previewDiv" id="previewDiv" style ="min-height:600px !important"></div>
    <button type="button" id="publish" onClick="submitTest()" class="btn btn-success canvasButton">Submit</button>
  </nav>
	</section>

	<script src="/arithmetic-evaluator/js/common.js"></script>
	<script>
	var testID;
	$( document ).ready(function() {
		testID = "${testID}";
		fetchTestDetails(testID);
	});

	function fetchTestDetails(testID) {
		var url = "/arithmetic-evaluator/student/fetchTest.action?testID="+testID
		sendAjaxRequest(url, function(resp) {
			var result = resp.response;
			console.log(resp);
			
			var qNo = 1;
			
			$.each(resp.testDetail.questions, function() {
				$qts = $('#assignmentQuestions').clone();
				var question = this.question;
				var option1 = this.option1;
				var option2 = this.option2;
				var option3 = this.option3;
				var option4 = this.option4;
				$qts.addClass("questionTag");
				$qts.find("#question").text("Question " + qNo + " : " +question);
				$qts.find("#question").attr('name', this.id);
				$qts.find("#option1").val(option1);
				$qts.find("#option2").val(option2);
				$qts.find("#option3").val(option3);
				$qts.find("#option4").val(option4);
				$qts.find("#answerOpt1").attr('name', 'question' + qNo)
				$qts.find("#answerOpt2").attr('name', 'question' + qNo)
				$qts.find("#answerOpt3").attr('name', 'question' + qNo)
				$qts.find("#answerOpt4").attr('name', 'question' + qNo)
				$("#questionsCanvasDiv").append($qts);
				qNo++;
			});
			
			
		});
	}
	
	function preview() {
		$("#previewDiv").text("");
		$(".questionTag").each(function(index) {
			var question = $(this).find("#question").val();
			var option1 = $(this).find("#option1").val().trim();
			var option2 = $(this).find("#option2").val().trim();
			var option3 = $(this).find("#option3").val().trim();
			var option4 = $(this).find("#option4").val().trim();

			console.log
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
			
			console.log(answer);
			$previewElement = $('#questionPreviewTemplate').clone();
			$previewElement.find("#previewQuestion").text(question);
			$previewElement.find("#previewAnswer").text(answer);
			$("#previewDiv").append($previewElement);
		});
	}
	
	function submitTest() {
		if(confirm("Press a button!")){
			alert("Yes");
		} else {
			alert("No");
		}
		var allQuestions = [];
		$(".questionTag").each(function(index) {
			var question = $(this).find("#question").val();
			var questionID = $(this).find("question").attr('name');
			var option1 = $(this).find("#option1").val().trim();
			var option2 = $(this).find("#option2").val().trim();
			var option3 = $(this).find("#option3").val().trim();
			var option4 = $(this).find("#option4").val().trim();

			var radio1Value = $(this).find("#answerOpt1").is(':checked');
			var radio2Value = $(this).find("#answerOpt2").is(':checked');
			var radio3Value = $(this).find("#answerOpt3").is(':checked');
			var radio4Value = $(this).find("#answerOpt4").is(':checked');
			var answer = 1;
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
			questionObj.questionID=questionID;
			questionObj.answer=answer;
			allQuestions.push(questionObj);
		});
		var json = new Object();
		json.questions = allQuestions;
		var testID = testID;
		var params = "testID="+testName + "&questionsJSONAsString=" +  encodeURIComponent(JSON.stringify(json));
		var url = "/arithmetic-evaluator/student/test/submit.action?" + params;
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
		
	}
	</script>
</body>
</html>
