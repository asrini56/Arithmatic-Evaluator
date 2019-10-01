<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: white;
}

.container {

    position: relative;
    z-index: 1;
    background-color: white;
    max-width: 480px;
    margin: 0 auto 30px;
    padding:100px;
    text-align: center;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}


.registerbtn {
  background-color: #6E7C9A;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 200px;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}


a {
  color: dodgerblue;
}


</style>
</head>
<body>

<form action="/action_page.php">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create a teacher account.</p>
    <hr>
    <input type="text" placeholder="Enter First Name" name="firstname" required>
    <input type="text" placeholder="Enter Middle Name" name="middlename">
    <input type="text" placeholder="Enter Last Name" name="lastname" required>
 <input type="text" placeholder="Enter Email" name="email" required>

    
    <input type="password" placeholder="Enter Password" name="psw" required>


    <input type="password" placeholder="Confirm Password" name="psw-confirm" required>
    <hr>

    <button type="submit" class="registerbtn">Register Teacher</button>
  </div>
  
</form>

</body>
</html>
