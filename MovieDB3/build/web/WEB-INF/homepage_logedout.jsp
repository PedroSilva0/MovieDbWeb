<%-- 
    Document   : homepage_logedout
    Created on : 22/jun/2017, 10:54:24
    Author     : Utilizador
--%>

<%@page import="moviedb_classes.Movie"%>
<%@page import="java.util.List"%>
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
        <link href="css/list.css" rel="stylesheet">
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
            <div class="navbar navbar-default navbar-fixed-top" role="navigation">
                <div class="container">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="homepage_logedout">
                            <img class="img-fluid" alt="MovieDB" src="images/logo.jpg" width="50" height="100">
                        </a>
                        <a class="navbar-brand" href="homepage_logedout" style="padding-top:15px">
                            MovieDB
                        </a>
                    </div>
                    <div class="navbar-collapse collapse">
                        <form method="POST" action="Login_Register_Page_Servlet" class="navbar-form navbar-right" >
                            <input type="submit" name="login" class="btn btn-default" value="Login">
                            <input type="submit" name="register" class="btn btn-default" value="Register">
                        </form>
                        <form method="POST" action="Search_Servlet" class="navbar-form" id="search">
                            <div class="form-group" style="display:inline;">
                                <div class="input-group">
                                    <input class="form-control" type="text" name="movie_title" placeholder="Search movie title">
                                    <span class="input-group-addon">
                                    <button type="submit" class="submit-with-icon icon-button">
                                            <span class="glyphicon glyphicon-search"></span>
                                    </button>
                                    </span>
                                </div>
                            </div>
                        </form>

                    </div><!--/.nav-collapse -->
                </div>
            </div>
            <div class="container">

                <h4 style="padding-top: 50px"> <a href="Website_List?list_name=Top_Rated&bot_limit=0">Top Rated </a> </h4>
                <div class="row">
                    <div class="col-md-12">
                        <div id="Carousel" class="carousel slide">

                            <ol class="carousel-indicators hidden">
                                <li data-target="#Carousel" data-slide-to="0" class="active"></li>
                                    <% List<Movie> top_movies = (List) request.getAttribute("top_movies");
                                        int pages = (int) Math.ceil(top_movies.size() / 6.0);
                                        System.out.println(pages);
                                        int i;
                                        for (i = 1; i < pages; i++) {%>
                                <li data-target="#Carousel" data-slide-to="<%=i%>"></li>
                                    <%}%>
                            </ol>

                            <!-- Carousel items -->
                            <div class="carousel-inner">

                                <div class="item active">
                                    <div class="row">
                                        <%
                                            i = 0;
                                            int max_page = i + 6;
                                            for (i = 0; i < top_movies.size() && i < max_page; i++) {
                                        Movie m = top_movies.get(i);%>
                                        <div class="col-md-2"><a href=<%="/MovieDB3/movie_details?id="+m.getId()%> class="thumbnail"><img src=<%=m.getPoster()%> alt="Image" style=" height:250px; max-width:100%;"></a>
                                        <div class="caption">
                                            <a href=<%="/MovieDB3/movie_details?id="+m.getId()%>><%=m.getTitle()%></a>
                                        </div>
                                        </div>
                                        
                                        <%}%>

                                    </div><!--.row-->
                                </div><!--.item-->

                                <%
                                    int page_aux;
                                    for (page_aux = 1; page_aux < pages; page_aux++) {
                                %>

                                <div class="item">
                                    <div class="row">
                                        <%
                                            max_page = max_page + 6;
                                            for (i = i; i < top_movies.size() && i < max_page; i++) {
                                            Movie m = top_movies.get(i);%>

                                        <div class="col-md-2"><a href=<%="/MovieDB3/movie_details?id="+m.getId()%> class="thumbnail"><img src=<%=m.getPoster()%> alt="Image" style="height:250px; max-width:100%;"></a>
                                        <div class="caption">
                                            <a href=<%="/MovieDB3/movie_details?id="+m.getId()%>><%=m.getTitle()%></a>
                                        </div>
                                        </div>
                                        
                                                <%}%>
                                    </div><!--.row-->
                                </div><!--.item-->
                                <%}%>
                            </div><!--.carousel-inner-->
                            <%if(top_movies.size()>6){%>
                            <a data-slide="prev" href="#Carousel" class="left carousel-control"><</a>
                            <a data-slide="next" href="#Carousel" class="right carousel-control">></a>
                            <%}%>
                        </div><!--.Carousel-->

                    </div>
                </div>
            </div><!--.container-->
        </div>

        <!-- Bootstrap core JavaScript
    ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
        <script src="js/list.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="js/ie10-viewport-bug-workaround.js"></script>

    </body>
</html>
