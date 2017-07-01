<%-- 
    Document   : movie_details
    Created on : Jun 29, 2017, 12:48:09 PM
    Author     : adt
--%>

<%@page import="moviedb_classes.Staff"%>
<%@page import="java.util.List"%>
<%@page import="moviedb_classes.User"%>
<%@page import="moviedb_classes.Movie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="favicon.ico">

        <title>MovieDB</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.css" rel="stylesheet">
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="css/loged_in.css" rel="stylesheet">
        <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
        <script src="js/ie-emulation-modes-warning.js"></script>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
          <![endif]-->
    </head>
    <body>
        <div>
            <% User u = (User) request.getAttribute("user");%>
            <% if(u == null) { %>
                <div class="navbar navbar-default navbar-fixed-top" role="navigation">
                <div class="container">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">
                            <img class="img-fluid" alt="MovieDB" src="images/logo.jpg" width="50" height="100">
                        </a>
                        <a class="navbar-brand" href="#" style="padding-top:15px">
                            MovieDB
                        </a>
                    </div>
                    <div class="navbar-collapse collapse">
                        <form method="POST" action="Login_Register_Page_Servlet" class="navbar-form navbar-right" >
                            <input type="submit" name="login" class="btn btn-default" value="Login">
                            <input type="submit" name="register" class="btn btn-default" value="Register">
                        </form>
                        <form class="navbar-form" id="search">
                            <div class="form-group" style="display:inline;">
                                <div class="input-group">
                                    <input class="form-control" type="text" placeholder="Search movie title">
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-search"></span></span>
                                </div>
                            </div>
                        </form>

                    </div><!--/.nav-collapse -->
                </div>
            </div>
            <% } else { %>      
                <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
                    <div class="container">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="navbar-header">
                            <a class="navbar-brand" href="#">
                                <img class="img-fluid" alt="MovieDB" src="images/logo.jpg" width="50" height="100">
                            </a>
                            <a class="navbar-brand" href="#" style="padding-top:15px">
                                MovieDB
                            </a>
                        </div>

                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <div class="collapse navbar-collapse">
                            <ul class="nav navbar-nav navbar-right">
                                <li>
                                    <img class="img-circle" src=<%=u.getAvatar()%> >
                                </li>
                                <li><p class="navbar-text">Hello,</p></li>
                                <li class="dropdown ">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b><%=u.getUsername()%></b> <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li>
                                        <li><a href="homepage_logedout">Log out</a></li>
                                </li>
                            </ul>
                            </li>
                            </ul>
                            <form class="navbar-form" id="search">
                                <div class="form-group" style="display:inline;">
                                    <div class="input-group">
                                        <input class="form-control" type="text" placeholder="Search movie title">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-search"></span></span>
                                    </div>
                                </div>
                            </form>
                        </div><!-- /.navbar-collapse -->
                    </div><!-- /.container-fluid -->
                </nav>
            <% } %>

            <div style="padding-top:30px;" class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel">
                            <% if(u != null) { %>
                                <div id="0" class="panel-heading">
                                    <div class="row">
                                        <div class="col-xs-4">
                                            <a href="#" class="active" id="home-link">Home</a>
                                        </div>
                                        <div class="col-xs-4">
                                            <a href="#" id="lists-link">Lists</a>
                                        </div>
                                        <div class="col-xs-4">
                                            <a href="#" id="ratings-link">Ratings</a>
                                        </div>
                                    </div>
                                </div>
                            <% } %>
                            <div class="panel-body">
                                <% Movie movie = (Movie)request.getAttribute("movie");%>
                                <div class="row">
                                    <div class="col-md-12">
                                        <h1 style="display: inline-block"><%= movie.getTitle()%></h1>
                                        <span style="margin-left: 15px" class="star-ratings-css"><span style="color: #000"><%=movie.getRating()%>  <span style="color: #FF6701">★</span></span></span>
                                    </div>
                                </div>
                                <div class="row" style="margin-top:10px">
                                    <div class="col-md-12">
                                        <%= "Duration: "+ movie.getDuration()+" min"%>
                                        <span style="margin-left: 40px"><%= movie.getGenre()%></span>
                                        <span style="margin-left: 40px"><%= movie.getRelease_day()+"/"+movie.getRelease_month()+"/"+movie.getRelease_year()%></span>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-4">
                                        <img src=<%=movie.getPoster()%> alt="Image" style=" margin-top:10px; height:65%; width:100%;">
                                    </div>
                                    <div class="col-md-4">
                                        <h2>Synopsis</h2>
                                        <p><%= movie.getSynopsys()%></p>
                                    </div>
                                    <div class="col-md-2">
                                    </div>
                                    <div class="col-md-2">
                                    </div>
                                </div>
                                <div class="row" style="margin-top:10px">
                                    <div class="col-md-3"><span style="font-weight: bold">Cast:></span></div>
                                    <div class="col-md-9">
                                        <% List<Staff> actors = (List<Staff>)request.getAttribute("cast"); %>
                                        <% for(int i=0;i<actors.size();i++) {%>
                                            <% if(i<actors.size()-1){ %>
                                                <a href="#"><%= actors.get(i).getName()+", " %></a>
                                            <% }else{ %>
                                                <a href="#"><%= actors.get(i).getName() %></a>
                                            <% } %>
                                        <% } %>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>    
                </div>              
                      <!--<a id="myBTN"  href="#" class="btn btn-primary btn-lg back-to-top" role="button" title="Click to return on the top page" data-toggle="tooltip" data-placement="left"><span class="glyphicon glyphicon-chevron-up"></span></a> -->

            </div>
        </div>




        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
        <script src="js/loged_in.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
