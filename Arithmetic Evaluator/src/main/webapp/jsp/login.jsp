<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>login form</title>
    <link rel="stylesheet" href="css/login_css.css">
    <link rel="stylesheet" href="../css/login_css.css">
   
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
   
<style>
    h2   {color: black;}
p    {color: black;}
.button1 {border-radius: 50%;}

</style>
<script>
//Function to submit the login form
function loginFunction() {
  document.getElementById("register-form").submit();
}
</script>
</head>
<body> 
    
  <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand">Arithmetic Evaluator</a>
    </div>
    
  </div>
</nav>
       <div class="login-page">
           <div class="form">
               <form class="register-form" action="login.action">
                   <div class="imgcontainer">
    <img src="https://icon-library.net/images/head-icon/head-icon-11.jpg" alt="Avatar" class="avatar">
  </div>
    <p></p>
               <input name ="emailID" type="text" placeholder="user name"/>
               <input name="password" type="password" placeholder="password"/>
                <button name="login" onclick="loginFunction()">LOGIN</button>

                   
                                      
<!-- Trigger/Open The Modal -->
<a style="color: black" href="#" id="myBtn">Not Registered. Click here!</a>

<!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <div class="modal-header">
      <span class="close">&times;</span>
      <h2>Create an account!</h2>
    </div>
    <div class="modal-body">
      <p style="color: black">not registered? contact admin!</p>
      <p style="color: black"> Want to create institution? <a href="admin/signup_page.action">Create</a></p>
    </div>
   
  </div>

</div>
               </form>
   <h2>OR</h2>
   <p>TRY AS</p>
           </div>
  <div class="btn-grp">
              <button style="margin: 5px" class="button button1">  IST GRADE STUDENT </button>
                <button style="margin: 5px" class="button button1">  6TH GRADE STUDENT</button>
 
  <button style="margin: 5px" class="button button1">  9TH GRADE STUDENT</button>
  </div>
      </div>
<script>
// Get the modal
var modal = document.getElementById("myModal");

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
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