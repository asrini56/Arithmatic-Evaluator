<html>
<head>
    <title>teacher's dashboard</title>
    <link rel="stylesheet" href="dashboard.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

 <style>
  .grid-container {
    display: grid;
    grid-template-columns: 1fr; /* Side nav is hidden on mobile */
    grid-template-rows: 50px 1fr 50px;
    grid-template-areas:
      'header'
      'main'
      'footer';
    height: 100vh;
  }
  
  .sidenav {
    display: none;
    grid-area: sidenav;
    background-color: #394263;
  }
  
  .main-cards {
    column-count: 1;
    column-gap: 20px;
    margin: 20px;
  }
  
  /* Non-mobile styles, 750px breakpoint */
  @media only screen and (min-width: 46.875em) {
    /* Show the sidenav */
    .grid-container {
      grid-template-columns: 240px 1fr; /* Show the side nav for non-mobile screens */
      grid-template-areas:
        "sidenav header"
        "sidenav main"
        "sidenav footer";
    }
    .sidenav {
      display: flex;
      flex-direction: column;
    }
  }
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
 

    <div class="menu-icon">
    <i class="fas fa-bars"></i>
  </div>
  <header class="header">    <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand">Arithmetic Evaluator</a>
    </div>
    
  </div>
</nav></header>
    
<aside class="sidenav">
    
  <ul class="sidenav__list">
    <li class="sidenav__list-item">HOME</li>
    <li class="sidenav__list-item">View Canvas</li>

    <li class="sidenav__list-item">Settings</li>
  </ul>
</aside>
    
    </aside>
  <main class="main">
     <div class="main-header">
         
  <div class="main-header__heading">Hello User</div>
  <div class="main-header__updates">Recent Items</div>
</div>
    
      <div class="main-cards">
  
 <div class="w3-card-4" onclick="buttonclick()" style="height: 475px; background-color: white"> 
      <br>
      <p style="text-align: center">CREATE TESTS</p>
         <img src="https://previews.123rf.com/images/iqoncept/iqoncept1405/iqoncept140500026/28029804-quiz-clipboard-of-questions-and-answers-marked-in-checklist-boxes.jpg" alt="Alps" style="width:90%">

      
    </div>


      <div class="w3-card-4" style= "height:475px; background-color: white">
          <br>
          <p style="text-align: center">VIEW TEST SCORES</p>
    <img src="https://i.dlpng.com/static/png/413588_preview.png" alt="Alps" style="width:100%">
      
</div>

  


   
</div>
    </main>
    <footer class="footer"></footer>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script>
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

  </script>
</body>
</html>