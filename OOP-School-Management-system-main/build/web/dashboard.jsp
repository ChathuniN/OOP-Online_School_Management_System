<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Event Management System</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">

    <!-- Custom styles -->
    <link href="../css/dashboard.css" rel="stylesheet">

  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Event Management System</a>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="dashboard.html"><i class="fa fa-lock" aria-hidden="true"></i> Admin <span class="sr-only">(current)</span></a></li>
            <li><a href="exams.html"> <i class="fa fa-paperclip" aria-hidden="true"></i>  Exam</a></li>
            <li><a href="reportpool.html"><i class="fa fa-book" aria-hidden="true"></i>  Reports</a></li>
            <li><a href="attendance.html"><i class="fa fa-check-circle-o" aria-hidden="true"></i>  Attendance</a></li>
            <li><a href="org.html"><i class="fa fa-sitemap" aria-hidden="true"></i>  Organization</a></li>
            <li><a href="#"><i class="fa fa-sign-out" aria-hidden="true"></i>  Logout</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Dashboard</h1>

          <div class="container">
            <div class="tile job">
              <div class="header">
                <div class="count">1</div>
                <div class="title">Exam</div>
              </div>
              <div class="body">
                <div class="title">Finished Exams</div>
              </div>
            </div>
            <div class="tile wide resource">
              <div class="header">
                <div class="left">
                  <div class="count">12</div>
                  <div class="title">Staff</div>
                </div>
                <div class="right">
                  <div class="count">150</div>
                  <div class="title">Students</div>
                </div>
              </div>
              <div class="body">
                <div class="title">Today's Attendance</div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  </body>
</html>
