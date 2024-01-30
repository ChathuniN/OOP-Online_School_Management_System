<%@page import="java.util.Iterator"%>
<%@page import="Models.Exam"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.ExamDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>School Management System</title>

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
          <a class="navbar-brand" href="#">School Management System</a>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li><a href="StattendanceServlet?action=list"> <i class="fa fa-paperclip" aria-hidden="true"></i>Attendance</a></li>
            <li class="active"><a href="ExamServlet?action=list"><i class="fa fa-sitemap" aria-hidden="true"></i>Exams<span class="sr-only">(current)</span></a></li>
            <li><a href="LogoutServlet"><i class="fa fa-sign-out" aria-hidden="true"></i>Logout</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <div class="flex" style="display: flex; gap: 24px; align-items: center;">
            <h2 class="sub-header">Exams</h2>
            <button type="button" class="btn btn-success" style="max-height: 35px;"><a href="ExamServlet?action=add"><i class="fa fa-plus" aria-hidden="true"></i></a></button>
          </div>

          <table class="table table-striped">
            <thead>
              <tr>
                <th>Exam Code</th>
                <th>Exam Name</th>
                <th>Course</th>
                <th>Date</th>
                <th>Hall No.</th>
                <th>Modify</th>
              </tr>
            </thead>
            <%
                ExamDAO dao=new ExamDAO();
                List<Exam>list=dao.list_array();
                Iterator<Exam>iter=list.iterator();
                Exam ex=null;
                while(iter.hasNext()){
                    ex=iter.next();
                    
              %>
            <tbody>
              <tr>
                <td><%= ex.getExamCode()%></td>
                <td><%= ex.getExamName()%></td>
                <td><%= ex.getCourseId()%></td>
                <td><%= ex.getExamDate()%></td>
                <td><%= ex.getHallNo()%></td>
                <td>
                    <a class="btn btn-warning" href="ExamServlet?action=edit&id=<%= ex.getExamId()%>">Edit</a>
                    <a class="btn btn-danger" href="ExamServlet?action=delete&id=<%= ex.getExamId()%>">Delete</a>
                </td>
              </tr>
              <%}%>
            </tbody>
          </table>
        </div>
      </div>
    </div>

    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  </body>
</html>

