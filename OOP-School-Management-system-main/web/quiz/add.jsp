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
            <li class="active"><a href="dashboard.html">Admin <span class="sr-only">(current)</span></a></li>
            <li><a href="exams.html">Exam</a></li>
            <li><a href="reportpool.html">Reports</a></li>
            <li><a href="attendance.html">Attendance</a></li>
            <li><a href="org.html">Organization</a></li>
            <li><a href="#">Logout</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">New Quiz</h1>
          <div class="quiz-q">
            <input type="text" placeholder="Question goes here." name="quiz-q1-q">
            <div class="flex">
              <input type="radio" name="quiz-q1" id="">
              <input type="text" name="quiz-q1-answer-1" id=""  placeholder="an Answer goes here.">
            </div>
            <div class="flex">
              <input type="radio" name="quiz-q1" id="">
              <input type="text" name="quiz-q1-answer-2" id=""  placeholder="an Answer goes here.">
            </div>
            <div class="flex">
              <input type="radio" name="quiz-q1" id="">
              <input type="text" name="quiz-q1-answer-3" id=""  placeholder="an Answer goes here.">
            </div>
            <div class="flex">
              <input type="radio" name="quiz-q1" id="">
              <input type="text" name="quiz-q1-answer-4" id=""  placeholder="an Answer goes here.">
            </div>
          </div>
          <div class="quiz-q">
                <input type="text" placeholder="Question goes here." name="quiz-q1-q">
                <div class="flex">
                <input type="radio" name="quiz-q2" id="">
                <input type="text" name="quiz-q2-answer-1" id=""  placeholder="an Answer goes here.">
                </div>
                <div class="flex">
                <input type="radio" name="quiz-q2" id="">
                <input type="text" name="quiz-q2-answer-2" id=""  placeholder="an Answer goes here.">
                </div>
                <div class="flex">
                <input type="radio" name="quiz-q2" id="">
                <input type="text" name="quiz-q2-answer-3" id=""  placeholder="an Answer goes here.">
                </div>
                <div class="flex">
                <input type="radio" name="quiz-q2" id="">
                <input type="text" name="quiz-q2-answer-4" id=""  placeholder="an Answer goes here.">
                </div>
          </div>
          <button type="button" class="btn btn-success">Submit Answers</button>
        </div>
      </div>
    </div>

    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  </body>
</html>
