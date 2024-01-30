<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="Models.Course"%>
<%@page import="ModeloDAO.CourseDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<head>

    <!-- Basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    
    <!-- Site Meta -->
    <title>Student Management System</title>

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,400i,500,700,900" rel="stylesheet"> 
    <link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,400i,700,700i" rel="stylesheet"> 
	
    <!-- Custom & Default Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/carousel.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="style.css">

</head>
<body>  

    <div id="wrapper">

        <header class="header">
    
            <div class="container">
                <nav class="navbar navbar-default yamm">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>

                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="index.jsp">Home</a></li>
                            <li><a href="login.jsp">Login</a></li>
                        </ul>
                    </div>
                </nav><!-- end navbar -->
            </div><!-- end container -->
        </header>

        <section id="home" class="video-section js-height-full">
            <div class="overlay"></div>
            <div class="home-text-wrapper relative container">
                <div class="home-message">
                    <p>School Management System</p>
                </div>
            </div>
        </section>

        <section class="section gb">
            <div class="container">
                <div class="section-title text-center">
                    <h3>Recent Courses</h3>
                </div><!-- end title -->

                <div id="owl-01" class="owl-carousel owl-theme owl-theme-01">
                    
                      <%
                        CourseDAO dao=new CourseDAO();
                        List<Course>list=dao.list_array();
                        Iterator<Course>iter=list.iterator();
                        Course ex=null;
                        while(iter.hasNext()){
                            ex=iter.next();

                      %>
                    <div class="caro-item">
                        <div class="course-box">
                            <div class="image-wrap entry">
                                <img src="images/courses-03.jpg" alt="" class="img-responsive">
                                <div class="magnifier">
                                     <a href="#" title=""><i class="flaticon-add"></i></a>
                                </div>
                            </div><!-- end image-wrap -->
                            <div class="course-details">
                                <h4>
                                    <a href="#" title=""><%= ex.getCourseName()%></a>
                                </h4>
                                <p><%= ex.getDescription()%></p>
                            </div><!-- end details -->
                            
                        </div><!-- end box -->
                    </div><!-- end col -->
                    <%}%>
                </div><!-- end row -->

                <hr class="invis">

                <div class="section-button text-center">
                    <a href="#" class="btn btn-primary">View All Courses</a>
                </div>
            </div><!-- end container -->
        </section>

        <div class="copyrights">
            <div class="container">
                <div class="clearfix">
                    <div class="pull-right">
                        <div class="footer-links">
                            <ul class="list-inline">
                                <li>School Management System</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div><!-- end container -->
        </div><!-- end copy -->
    </div><!-- end wrapper -->

    <!-- jQuery Files -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/carousel.js"></script>
    <script src="js/animate.js"></script>
    <script src="js/custom.js"></script>

</body>
</html>



