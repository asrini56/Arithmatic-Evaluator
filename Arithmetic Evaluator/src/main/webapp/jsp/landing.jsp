<html>
<head>
<title>Arithmetic Evaluator</title>
<link rel="stylesheet" href="/arithmetic-evaluator/css/landing.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
    
<section class="landing py-5">
    <div class="grid-container">
    <header class="header">
			<nav class="navbar navbar-inverse" style="margin-bottom:0px !important; ">
  				<div class="container-fluid">
    				<div class="navbar-header">
      					<a class="navbar-brand titleText" href="#">Arithmetic Evaluator</a>
    				</div>
				</div>
			</nav> 
    </header>
    <br><br>
    <div class="cards_row">
      <!-- card Grade 1 -->
      <div class="cardlog">
        <div class="card mb-5 mb-lg-0">
          <div class="card-body" onclick="goToPractiseMathsPageGrade1()">
            <img src="/arithmetic-evaluator/image/1stgrade.jpg"alt="Alps" style="width: 100%">
          </div>
        </div>
      </div>
      <!-- card Grade 6 -->
      <div class="cardlog">
        <div class="card mb-5 mb-lg-0">
          <div class="card-body" onclick="goToPractiseMathsPageGrade6()">
            <img src="/arithmetic-evaluator/image/6thgrade.png"alt="Alps" style="width: 100%">
          </div>
        </div>
      </div>
      <!-- card Grade9 -->
      <div class="cardlog">
        <div class="card">
          <div class="card-body" onclick="goToPractiseMathsPageGrade9()">
            <img src="/arithmetic-evaluator/image/grade9th.jpg" alt="Alps" style="width: 100%">
          </div>
        </div>
        <br><br>
      </div>
    </div>
  </div>
    <br/>
    <br/>
    <br/>
  <div class="loginDiv">
      <span>Click here to Login or Register!</span>
      <br>
      <button type="button" class="loginBtn" style="font-family: fantasy" onclick="loginFunction()">LOGIN or REGISTER </button>
  </div>
</section>
<script>
function loginFunction(){
    window.location="login_page.action";
}
function goToPractiseMathsPageGrade1(){
    window.location="/arithmetic-evaluator/grade1/operations_page.action";
}
function goToPractiseMathsPageGrade6(){
    window.location="/arithmetic-evaluator/grade6/operations_page.action";
}
function goToPractiseMathsPageGrade9(){
    alert("Page under construction, kindly bear with us!")
}
</script>

</body>
</html>