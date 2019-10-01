<html>
<head>
<title>Set Password</title>
    <link rel="stylesheet" href="css/login_css.css">
   
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<style>
body{
    height:100vh;
    background-size: cover;
    background-size: center;
}
.login-page{
    width: 610px;
    padding: 2% 0 0;
    margin: auto;
}
.form{
    position: relative;
    z-index: 1;
    background-color: white;
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

.btn-grp button{
  background-color:#3A4356;
  border: 1px solid blue; 
  color: white;
  padding: 15px 21px; 
  cursor: pointer; 
  float: left;
}


img.avatar {
  width: 40%;
  border-radius: 50%;
}


.btn-grp button:hover{
  background-color:#6E7C9A;
}

.form button:hover,.form button:active{
    background: #4C669F;
}



/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
  position: relative;
  background-color: #fefefe;
  margin: auto;
  padding: 0;
  border: 1px solid #888;
  width: 80%;
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);
  -webkit-animation-name: animatetop;
  -webkit-animation-duration: 0.4s;
  animation-name: animatetop;
  animation-duration: 0.4s
}

/* Add Animation */
@-webkit-keyframes animatetop {
  from {top:-300px; opacity:0} 
  to {top:0; opacity:1}
}

@keyframes animatetop {
  from {top:-300px; opacity:0}
  to {top:0; opacity:1}
}

/* The Close Button */
.close {
  color: white;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}

.modal-header {
  padding: 2px 16px;
  background-color: #4C669F;
  color: white;
}


    h2   {color: white;}
p    {color: antiquewhite;}
.button1 {border-radius: 50%;}

</style>
</head>
<body> 
  <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand">Arithmetic Evaluator</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
      
    </ul>
  </div>
</nav>
       <div class="set-password-page">
           <div class="form">
               <form class="set-password-form">
                   <div class="imgcontainer">
    <img src="https://icon-library.net/images/head-icon/head-icon-11.jpg" alt="Avatar" class="avatar">
  </div>
   
               <input type="password" placeholder="new password"/>
               <input type="password" placeholder="confirm password"/>
                <button>Set Password</button>                   

    
               </form>
           </div>
      </div>

</body> 
</html>
