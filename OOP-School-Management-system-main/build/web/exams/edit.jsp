<%@page import="Models.Exam"%>
<%@page import="ModeloDAO.ExamDAO"%>
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
          <a class="navbar-brand" href="#">Student Management System</a>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li><a href="dashboard.html">Home</a></li>
            <li class="active"><a href="EventServlet?action=list">Events<span class="sr-only">(current)</span></a></li>
            <li><a href="EventCategoryServlet?action=list">Event Category</a></li>
            <li><a href="PackageServlet?action=list">Packages</a></li>
            <li><a href="users.html">Users</a></li>
            <li><a href="#">Logout</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Dashboard</h1>

          <h2 class="sub-header">Add an Event</h2>
          <div class="user-form" style="width: 50%;">
              <%
              ExamDAO dao=new ExamDAO();
              int id=Integer.parseInt((String)request.getAttribute("examId"));
              Exam ex=(Exam)dao.list(id);
              %>
            <form>
                <div class="form-group">
                <label for="txtExamCode">Exam Code</label>
                <input name="txtExamCode" type="text" class="form-control" id="txtExamCode" placeholder="Enter Exam Code" value="<%= ex.getExamCode()%>">
              </div>
              <div class="form-group">
                <label for="txtExamName">Exam Name</label>
                <input name="txtExamName" type="text" class="form-control" id="txtExamName" placeholder="Enter the Exam" value="<%= ex.getExamName()%>">
              </div>
              <div class="form-group">
                  <label for="cmbCourse">Course</label>
                  <select name="cmbCourse">
                      <option value="1">ICT</option>
                      <option value="2">Leth</option>
                      <option value="3">Hotel</option>
                  </select>   
              </div>
              <div class="form-group">
                <label for="dateExamDate">Exam Date</label>
                <input name="dateExamDate" type="date" class="form-control" id="dateExamDate" value="<%= ex.getExamDate()%>">
              </div>
              <div class="form-check">
                <label for="txtHallNo">Hall Number</label>
                <input name="txtHallNo" type="number" class="form-control" id="txtHallNo" placeholder="Enter Hall No" value="<%= ex.getHallNo()%>">
              </div>
                <input type="hidden" name="txtExamId" value="<%= ex.getExamId()%>">
                <button type="submit" name="action" value="editrow" class="btn btn-primary">Submit</button>
            </form>
          </div>
        </div>
      </div>
    </div>

    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  </body>
</html>