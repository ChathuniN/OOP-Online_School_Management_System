<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Management System</title>
    
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-grad-school.css">
    <link rel="stylesheet" href="assets/css/owl.css">
    <link rel="stylesheet" href="assets/css/lightbox.css">

  </head>
<body>
    
      <!--header-->
  <header class="main-header clearfix" role="header">
    <div class="logo">
      <a href="#"><em>Student</em> Management System</a>
    </div>
    <nav id="menu" class="main-nav" role="navigation">
      <ul class="main-menu">
        <li><a href="index.jsp">Home</a></li>
        <li><a href="login.jsp">Login</a></li>
      </ul>
    </nav>
  </header>
      
    <section class="section coming-soon" data-section="section3">
    <div class="container">
      <div class="row">
          <div class="col-md-3"></div>
        <div class="col-md-6">
          <div class="right-content">
            <div class="top-content">
              <h6>Register</h6>
            </div>
              
            <form id="contact" action="RegsterServlet">
              <div class="row">
                <div class="col-md-12">
                  <fieldset>
                    <input type="text" name="txtStudentName" class="form-control" id="txtStudentName" placeholder="Your Name" required="">
                  </fieldset>
                </div>
                <div class="col-md-12">
                  <fieldset>
                    <input name="txtCourseName" type="text" class="form-control" id="passtxtCourseNameword" placeholder="Enter the Course Name" required="">
                  </fieldset>
                </div>
                <div class="col-md-12">
                  <fieldset>
                    <button type="submit" name="action" value="addrow" class="button">Register</button>
                  </fieldset>
                </div>
              </div>
            </form>
          </div>
        </div>
               <div class="col-md-3"></div>
      </div>
    </div>
  </section>
      
                <footer>
    <div class="container">
      <div class="row">
        <div class="col-md-12">
            <p><i class="fa fa-copyright"></i> Copyright 2022 @ School Management System  </p>
        </div>
      </div>
    </div>
  </footer>
</body>
</html>
