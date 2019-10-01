<html>
   <head>
	<title>Arithmetic Evaluator</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
      <style type="text/css">
         #boxA,#boxA1, #boxA2, #boxA3, #boxB {
            float:left;padding:10px;margin:10px;-moz-user-select:none;
         }
         #boxA,#boxA1, #boxA2, #boxA3 { width:30px; height:10px;  }
         #boxB { background-color:#F0FFFF ;width:450px; height:400px; }

body {
  font-family: Arial, Helvetica, sans-serif;
  background: grey;
}
/* Container for flexboxes */
section {
  display: -webkit-flex;
  display: flex;
}

/* Style the navigation menu */
nav {
  min-width: 500px;
  min-height: 600px;
  -webkit-flex: 1;
  -ms-flex: 1;
  flex: 1;
  height:80px; 
  background: #F0FFFF;
  padding: 20px;
  border-style: groove;
}

/* Style the list inside the menu */
nav ul {
  list-style-type: none;
  padding: 0;
}

/* Style the content */
article {
  min-width: 100px;
  min-height: 600px;
  -webkit-flex: 3;
  -ms-flex: 3;
  flex: 3;
  background-color: #F0FFFF;
  padding: 10px;
  border-style: groove;
}

/* Style the footer */
footer {
  background-color: #666;
  padding: 10px;
  text-align: center;
  color: white;
}
/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  margin: 15% auto; /* 15% from the top and centered */
  padding: 20px;
  border: 1px solid #888;
  width: 30%; /* Could be more or less, depending on screen size */
}

/* The Close Button */
.close {
  color: #aaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: black;
  text-decoration: none;
  cursor: pointer;
}

/*the form style*/
.form{
    position: relative;
    z-index: 1;
    background: rgba(7, 40, 195, 0.05);
    max-width: 360px;
    margin: 0 auto 30px;
    padding:0px;
    text-align: center;
}
.form input{
    font-family: "Roboto", sans-serif;
    outline: 1;
    background: #f2f2f2;
    width: 100%;
    border: 0;
    margin: 0 0 15px;
    padding: 15px;
    box-sizing: border-box;
    font-size: 14px;
}

.form button{
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
img.avatar {
  width: 40%;
  border-radius: 50%;
}


.btn-grp button:hover{
  background-color:#337B7C;
}

.form button:hover,.form button:active{
    background: #4C669F;
}
.dropzone {
  width: 500px;
  height: 10px;
  padding: 10px;
  border: 1px solid #888;
}
</style>
<script type="text/javascript">
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
            ev.target.appendChild(document.getElementById(src));
            ev.stopPropagation();
            return false;
         }
	
      </script>
   </head>
   <body>
      <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="1.html">Arithmetic Evaluator</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="1.html">Home</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="test.html"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href= "#" id="myBtn"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
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
    <p></p>
               <input type="text" placeholder="user name"/>
               <input type="password" placeholder="password"/>
                <button>LOGIN</button>                   

    <span class="acc"> Not Registered? <a href="#">Create an institute</a></span>
    
               </form>
  </div>

</nav>
	<section>
  <nav>
	<h1> Operations </h1>

<div id="boxB" ondragenter="return dragEnter(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">

	<div  id="dropzone1" class="static dropzone" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
     	<div id="boxA" draggable="true" ondragenter="return dragEnter(event)" ondragstart="return dragStart(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)" "><button type="button" class="btn btn-default btn-sm" style=background-color:#438687>
    		<input type="text" placeholder="Input1" id="add1" name="add1" size="5" required> <b> <font size=5>+ </font> <b> <input type="text" placeholder="Input2" id="add2" name="add2" size="5" required>          
	</button>
	  </div>
	</div>
	<br><br>
	<div id="dropzone2" class="static dropzone" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
    	<div id="boxA1" draggable="true" ondragenter="return dragEnter(event)" ondragstart="return dragStart(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)"><button type="button" class="btn btn-default btn-sm" style=background-color:#438687> 
          <input type="text" placeholder="Input1" id="sub1" name="sub1" size="5" required> <b> <font size=5>- </font><b> <input type="text" placeholder="Input2" id="sub2" name="sub2" size="5" required></form>
          </button>
	  </div>
	</div>
	<br><br>
	<div id="dropzone3" class="static dropzone" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
		<div id="boxA2" draggable="true" ondragenter="return dragEnter(event)" ondragstart="return dragStart(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)" "><button type="button" class="btn btn-default btn-sm" style=background-color:#438687>
          <input type="text" placeholder="Input1" id="multiply1" name="multiply1" size="5" required> <b> <font size=5>* </font> <b><input type="text" placeholder="Input2" id="multiply2" name="multiply2" size="5" required></form>
          </button>
	  </div>
	</div>
	<br><br>
	<div id="dropzone4" class="static dropzone" ondrop="return dragDrop(event)" ondragover="return dragOver(event)">
		<div id="boxA3" draggable="true" ondragenter="return dragEnter(event)" ondragstart="return dragStart(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)" "><button type="button" class="btn btn-default btn-sm" style=background-color:#438687>
          <input type="text" placeholder="Input1" id="divide1" name="divide1" size="5" required> <b> <font size=5> / </font> <b><input type="text" placeholder="Input2" id="divide2" name="divide2" size="5" required></form>
          </button>
	  </div>
	</div>
</div>
  </nav>
  <nav>
	<h1>Canvas</h1>
	<div id="boxB" ondragenter="return dragEnter(event)" ondrop="return dragDrop(event)" ondragover="return dragOver(event)" ondragstart="return dragStart(event)">
	</div>
	<button type="button" id="submit" class="btn btn-success" style=float:right onclick="add();sub();multiply();divide()">Submit</button>
  </nav>	


  <article>
    <h1>Result</h1>
</div>
<p> answer will be displayed here </p>
<div id="result"></div>
<div id="result1"></div>
<div id="result2"></div>
<div id="result3"></div>


	<button type="button" class="btn btn-default btn-sm" style=float:right>
          <span class="glyphicon glyphicon-save-file" ></span> Save
        </button>
  </article>
</section>

<footer>
  <p style=text-align:right><span class="glyphicon glyphicon-copyright-mark"></span>  Copyright</p>
</footer>
<script>
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

	var add1 = Number(document.getElementById('add1').value);
	var add2 = Number(document.getElementById('add2').value);
	var sub1 = Number(document.getElementById('sub1').value);
	var sub2 = Number(document.getElementById('sub2').value);
	var multiply1 = Number(document.getElementById('multiply1').value);
	var multiply2 = Number(document.getElementById('multiply2').value);
	var divide1 = Number(document.getElementById('divide1').value);
	var divide2 = Number(document.getElementById('divide2').value);

function add() {
	var add1 = Number(document.getElementById('add1').value);
	var add2 = Number(document.getElementById('add2').value);

	if(add1!=0 && add2!=0)
	{   	
	document.getElementById('result').innerHTML = add1+add2;
    	return false;
	}
}

function sub() {
	var sub1 = Number(document.getElementById('sub1').value);
	var sub2 = Number(document.getElementById('sub2').value);
	if(sub1!=0 && sub2!=0)
	{
    document.getElementById('result1').innerHTML = sub1-sub2;
    return false;
	}
}

function multiply() {
	var multiply1 = Number(document.getElementById('multiply1').value);
	var multiply2 = Number(document.getElementById('multiply2').value);
	
    	if(multiply1!=0 && multiply2!=0)
	{
	document.getElementById('result2').innerHTML = multiply1*multiply2;
    	return false;
	}
}
function divide() {
	var divide1 = Number(document.getElementById('divide1').value);
	var divide2 = Number(document.getElementById('divide2').value);
	if(divide1!=0 && divide2!=0)
	{
    document.getElementById('result3').innerHTML = divide1/divide2;
    return false;
	}
}



document.getElementById('submit').addEventListener('click', add);
document.getElementById('submit').addEventListener('click', sub);
document.getElementById('submit').addEventListener('click', multiply);
document.getElementById('submit').addEventListener('click', divide);

</script>
   </body>
</html>
