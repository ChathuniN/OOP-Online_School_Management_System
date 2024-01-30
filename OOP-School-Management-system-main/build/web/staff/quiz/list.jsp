
<%@page import="java.util.Iterator"%>
<%@page import="Models.Quiz"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.QuizDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Student Management System</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">

    <!-- Custom styles -->
    <link href="css/dashboard.css" rel="stylesheet">

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
          <a class="navbar-brand" href="#">Student Management System</a>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li><a href="StattendanceServlet?action=list"> <i class="fa fa-paperclip" aria-hidden="true"></i>Attendance</a></li>
            <li><a href="ExamServlet?action=list"><i class="fa fa-sitemap" aria-hidden="true"></i>Exams</a></li>
            <li class="active"><a href="QuizServlet?action=list"><i class="fa fa-sitemap" aria-hidden="true"></i>Quiz<span class="sr-only">(current)</span></a></li>
            <li><a href="LogoutServlet"><i class="fa fa-sign-out" aria-hidden="true"></i>Logout</a></li>
          </ul>
        </div>
          
          <%
                QuizDAO dao=new QuizDAO();
                List<Quiz>list=dao.list_array();
                Iterator<Quiz>iter=list.iterator();
                Quiz ex=null;
                while(iter.hasNext()){
                    ex=iter.next();
                    
              %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="flex" style="display: flex; gap: 24px; align-items: center;">
            <h2 class="sub-header">Quiz</h2>
            <button type="button" class="btn btn-success" style="max-height: 35px;"><a href="QuizServlet?action=add"><i class="fa fa-plus" aria-hidden="true"></i></a></button>
          </div>
            
          <div class="quiz-q">
            <p><%= ex.getQuestion()%></p>
            <div class="flex">
              <input type="radio" name="" id="">
              <p><%= ex.getAns1()%></p>
            </div>
            <div class="flex">
              <input type="radio" name="" id="">
              <p><%= ex.getAns2()%></p>
            </div>
            <div class="flex">
              <input type="radio" name="" id="">
              <p><%= ex.getAns3()%></p>
            </div>
            <div class="flex">
              <input type="radio" name="" id="">
              <p><%= ex.getAns4()%></p>
            </div>
            
          </div>
        <%}%>
          <button type="button" class="btn btn-success">Submit Answers</button>
        </div>
      </div>
    </div>

    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  </body>
</html>
