<html>
<head>
    <title>admin's dashboard</title>
    <link rel="stylesheet" href="dashboard.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
 <style>
     body {font-family: Arial, Helvetica, sans-serif;}
.card {
  /* Add shadows to create the "card" effect */
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
}

/* On mouse-over, add a deeper shadow */
.card:hover {
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}
    
/* Add some padding inside the card container */
.container {
  padding: 2px 16px;
}
#myImg {
  border-radius: 5px;
  cursor: pointer;
  transition: 0.3s;
}

#myImg:hover {opacity: 0.7;}

  .grid-container {
    display: grid;
    grid-template-columns: auto; /* Side nav is hidden on mobile */
    grid-template-rows: 50px 1fr 50px;
    grid-template-areas:
      'header'
      'main'
      'footer';
    height: 100vh;
  }
 /* 
  .sidenav {
    display: none;
    grid-area: sidenav;
    background-color: #394263;
  } */
  
  .main-cards {
    column-count: 1;
    column-gap: 20px;
    margin: 20px;
  }
  
  /* Non-mobile styles, 750px breakpoint */
  @media only screen and (min-width: 46.875em) {
    /* Show the sidenav */
    .grid-container {
      grid-template-columns: 0px 1fr; /* Show the side nav for non-mobile screens */
      grid-template-areas:
        "sidenav header"
        "sidenav main"
        "sidenav footer";
    }
  /*  .sidenav {
      display: flex;
      flex-direction: column;
    }
  }*/
  /* Medium-sized screen breakpoint (tablet, 1050px) */
  @media only screen and (min-width: 65.625em) {
    /* Break out main cards into two columns */
    .main-cards {
      column-count: 2;
    }
  }
  
</style>   
</head>
<body>
<div class="grid-container">
    <!--<div class="menu-icon">
    <i class="fas fa-bars"></i>
  </div>--->
  
<!---  <aside class="sidenav">
    
<aside class="sidenav">
    <div class="sidenav__close-icon">
    <i class="fas fa-times"></i>
  </div>
  <ul class="sidenav__list">
    <li class="sidenav__list-item">HOME</li>
    <li class="sidenav__list-item">View Canvas</li>
    <li class="sidenav__list-item">Create Test</li>
    <li class="sidenav__list-item">View Scores</li>
    <li class="sidenav__list-item">Settings</li>
  </ul>
</aside>   
     
    </aside>  --->
    <header class="header"></header>
  <main class="main">
     <div class="main-header">
  <div class="main-header__heading">Hello User</div>
  <div class="main-header__updates">Recent Items</div>
</div>
    
      <div class="main-cards">
  <div class="w3-card-4" onclick="buttonclick()" style="height: 500px"> 
         <img src="teachers.jpg" alt="Alps" style="width:100%">
    <div class="w3-container w3-center" style="background-color: whitesmoke">
      <p>TEACHERS</p>
    </div>
</div>

      <div class="w3-card-4" style= "height:500px">
    <img src="students.jpg" alt="Alps" style="width:100%">
    <div class="w3-container w3-center" style="background-color: whitesmoke">
      <p>STUDENTS</p>
    </div>
  </div>


<!-- <div class="card">
  <img src="students.jpg" alt="Avatar" style="width:100%">
  <div class="container">
    <h4><b>STUDENTS</b></h4>
    <p>View Students detail</p>
  </div>
</div>--> 
</div>
      
    </main>
  <footer class="footer"></footer>


   
</div>
   

<script>

/*function buttonclick(){
window.location="teacher_register.jsp.html";
}*/
</script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <!--<script>
    const menuIconEl = $('.menu-icon');
    const sidenavEl = $('.sidenav');
    const sidenavCloseEl = $('.sidenav__close-icon');

    // Add and remove provided class names
    function toggleClassName(el, className) {
      if (el.hasClass(className)) {
        el.removeClass(className);
      } else {
        el.addClass(className);
      }
    }

    // Open the side nav on click
    menuIconEl.on('click', function() {
      toggleClassName(sidenavEl, 'active');
    });

    // Close the side nav on click
    sidenavCloseEl.on('click', function() {
      toggleClassName(sidenavEl, 'active');
    });
  </script>-->
</body>
</html>