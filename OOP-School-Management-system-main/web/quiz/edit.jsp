<%@page import="Modelo.Event"%>
<%@page import="ModeloDAO.EventDAO"%>
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
          <a class="navbar-brand" href="#">Event Management System</a>
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
              EventDAO dao=new EventDAO();
              int id=Integer.parseInt((String)request.getAttribute("eventId"));
              Event ev=(Event)dao.list(id);
              %>
            <form>
              <div class="form-group">
                <label for="eventName">Event Name</label>
                <input name="txtEventName" type="text" class="form-control" id="eventName" placeholder="Enter a Name" value="<%= ev.getEventName()%>">
              </div>
              <div class="form-group">
                <label for="eventDate">Date</label>
                <input name="txtEventDate" type="text" class="form-control" id="eventDate" placeholder="Enter easy referance code" value="<%= ev.getEventDate()%>">
              </div>
              <div class="form-group">
                <label for="eventVenue">Venue</label>
                <input name="txtEventVenue" type="text" class="form-control" id="eventVenue" placeholder="Enter a brief Description" value="<%= ev.getVenue()%>">
              </div>
              <div class="form-check">
                <input type="checkbox" class="form-check-input" id="isActive">
                <label class="form-check-label" for="isActive">Is Active</label>
              </div>
              <input type="hidden" name="txtEventId" value="<%= ev.getEventId()%>">
              <button type="submit" class="btn btn-primary" name="action" value="editrow">Submit</button>
            </form>
          </div>
        </div>
      </div>
    </div>

    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  </body>
</html>