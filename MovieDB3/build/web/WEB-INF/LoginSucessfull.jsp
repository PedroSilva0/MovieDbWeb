<%-- 
    Document   : LoginSucessfull
    Created on : 15/jun/2017, 15:54:17
    Author     : Utilizador
--%>

<%@page import="moviedb_classes.Ratings"%>
<%@page import="moviedb_classes.Movie"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="moviedb_classes.User"%>
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

        <% User u = (User) request.getAttribute("user");%>
        <nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="background-color:#353135">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <% String ref="LoginServlet?log_state=1&username="+u.getUsername();%>
                    <a class="navbar-brand" href=<%=ref%>>
                        <img class="img-fluid" alt="MovieDB" src="images/logo.jpg" width="50" height="100">
                    </a>
<<<<<<< HEAD
                    <a class="navbar-brand" href="#" style="padding-top:15px;margin-left:10px;color:whitesmoke">
=======
                    <a class="navbar-brand" href=<%=ref%> style="padding-top:15px">
>>>>>>> refs/remotes/origin/master
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
                    <form method="POST" action="Search_Servlet" class="navbar-form" id="search">
                            <div class="form-group" style="display:inline;">
                                <div class="input-group">
                                    <input class="form-control" type="text" name="movie_title" placeholder="Search movie title">
                                    <input type="hidden" name="user" value="<%=u.getId()%>" />
                                    <span class="input-group-addon">
                                    <button type="submit" class="submit-with-icon icon-button">
                                            <span class="glyphicon glyphicon-search"></span>
                                    </button>
                                    </span>
                                </div>
                            </div>
                        </form>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>

        <div style="padding-top:30px;" class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="panel">
                        <div id="0" class="panel-heading" style="background-color: #353135;">
                            <div class="row">
                                <div class="col-xs-6">
                                    <a href="#" class="active" id="home-link" style="color:whitesmoke">Home</a>
                                </div>
                                <div class="col-xs-5">
                                    <a href="#" id="lists-link" style="color:whitesmoke">Lists</a>
                                </div>
                                <div class="col-xs-1">
                                    <a href="#" id="ratings-link" style="color:whitesmoke">Ratings</a>
                                </div>
                            </div>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div id="home-stuff" class="col-lg-12">
                                    <div class="container">
                                        <% ref="Website_List?list_name=Top_Rated&bot_limit=0&user="+u.getUsername();%>
                                        <h4 style="padding-top: 50px"> <a href=<%=ref%>>Top Rated </a> </h4>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div id="Carousel" class="carousel slide">

                                                    <ol class="carousel-indicators hidden">
                                                        <li data-target="#Carousel" data-slide-to="0" class="active"></li>
                                                            <% List<Movie> top_movies = (List) request.getAttribute("top_movies");
                                                                int pages = (int) Math.ceil(top_movies.size() / 6.0);
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
<<<<<<< HEAD
                                                Movie m = top_movies.get(i);%>
=======
                                                Movie m = top_movies.get(i);
                                                                %>
>>>>>>> refs/remotes/origin/master
                                                                <div class="col-md-2"><a href="<%="/MovieDB3/movie_details?id="+m.getId()+"&user="+u.getId()%>" class="thumbnail"><img src=<%=m.getPoster()%> alt="Image" style=" height:250px; max-width:100%;"></a>
                                                                    <div class="caption">
                                                                        <h4 style="text-align: center"><%=m.getTitle()%></h4>
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
                                                Movie m = top_movies.get(i);
                                                                %>

                                                                <div class="col-md-2"><a href="<%="/MovieDB3/movie_details?id="+m.getId()+"&user="+u.getId()%>" class="thumbnail"><img src=<%=m.getPoster()%> alt="Image" style="height:250px; max-width:100%;"></a>
                                                                    <div class="caption">
<<<<<<< HEAD
                                                                        <h4 style="text-align: center"><%=m.getTitle()%></h4>
=======
                                                                        <a href="<%="/MovieDB3/movie_details?id="+m.getId()+"&user="+u.getId()%>"><%=m.getTitle()%></a>
>>>>>>> refs/remotes/origin/master
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
                                    <div class="container">
                                        <% ref="Website_List?list_name=Latest_Releases&bot_limit=0&user="+u.getUsername();%>
                <h4 style="padding-top: 50px"> <a href="<%=ref%>">Coming Soon </a> </h4>
                <div class="row">
                    <div class="col-md-12">
                        <div id="Carousel2" class="carousel slide">

                            <ol class="carousel-indicators hidden">
                                <li data-target="#Carouse2" data-slide-to="0" class="active"></li>
                                    <% List<Movie> latest_movies = (List) request.getAttribute("latest");
                                        pages = (int) Math.ceil(latest_movies.size() / 6.0);
                                        for (i = 1; i < pages; i++) {%>
                                <li data-target="#Carouse2" data-slide-to="<%=i%>"></li>
                                    <%}%>
                            </ol>

                            <!-- Carousel items -->
                            <div class="carousel-inner">

                                <div class="item active">
                                    <div class="row">
                                        <%
                                            i = 0;
                                            max_page = i + 6;
                                            for (i = 0; i < latest_movies.size() && i < max_page; i++) {
                                        Movie m = latest_movies.get(i);%>
                                        <div class="col-md-2"><a href=<%="/MovieDB3/movie_details?id="+m.getId()%> class="thumbnail"><img src=<%=m.getPoster()%> alt="Image" style=" height:250px; max-width:100%;"></a>
                                        <div class="caption">
                                            <a href=<%="/MovieDB3/movie_details?id="+m.getId()%>><%=m.getTitle()%></a>
                                        </div>
                                        </div>
                                        
                                        <%}%>

                                    </div><!--.row-->
                                </div><!--.item-->

                                <%
                                    
                                    for (page_aux = 1; page_aux < pages; page_aux++) {
                                %>

                                <div class="item">
                                    <div class="row">
                                        <%
                                            max_page = max_page + 6;
                                            for (i = i; i < latest_movies.size() && i < max_page; i++) {
                                            Movie m = latest_movies.get(i);%>

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
                            <%if(latest_movies.size()>6){%>
                            <a data-slide="prev" href="#Carousel2" class="left carousel-control"><</a>
                            <a data-slide="next" href="#Carousel2" class="right carousel-control">></a>
                            <%}%>
                        </div><!--.Carousel-->

                    </div>
                </div>
            </div><!--.container-->
                                    <div class="container">
                                        <% ref="Website_List?list_name=Coming_Soon&bot_limit=0&user="+u.getUsername();%>
                <h4 style="padding-top: 50px"> <a href="<%=ref%>">Coming Soon </a> </h4>
                <div class="row">
                    <div class="col-md-12">
                        <div id="Carousel3" class="carousel slide">

                            <ol class="carousel-indicators hidden">
                                <li data-target="#Carousel3" data-slide-to="0" class="active"></li>
                                    <% List<Movie> coming_soon_movies = (List) request.getAttribute("coming_soon");
                                        pages = (int) Math.ceil(coming_soon_movies.size() / 6.0);
                                        for (i = 1; i < pages; i++) {%>
                                <li data-target="#Carousel3" data-slide-to="<%=i%>"></li>
                                    <%}%>
                            </ol>

                            <!-- Carousel items -->
                            <div class="carousel-inner">

                                <div class="item active">
                                    <div class="row">
                                        <%
                                            i = 0;
                                            max_page = i + 6;
                                            for (i = 0; i < coming_soon_movies.size() && i < max_page; i++) {
                                        Movie m = coming_soon_movies.get(i);%>
                                        <div class="col-md-2"><a href=<%="/MovieDB3/movie_details?id="+m.getId()%> class="thumbnail"><img src=<%=m.getPoster()%> alt="Image" style=" height:250px; max-width:100%;"></a>
                                        <div class="caption">
                                            <a href=<%="/MovieDB3/movie_details?id="+m.getId()%>><%=m.getTitle()%></a>
                                        </div>
                                        </div>
                                        
                                        <%}%>

                                    </div><!--.row-->
                                </div><!--.item-->

                                <%
                                    
                                    for (page_aux = 1; page_aux < pages; page_aux++) {
                                %>

                                <div class="item">
                                    <div class="row">
                                        <%
                                            max_page = max_page + 6;
                                            for (i = i; i < coming_soon_movies.size() && i < max_page; i++) {
                                            Movie m = coming_soon_movies.get(i);%>

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
                            <%if(coming_soon_movies.size()>6){%>
                            <a data-slide="prev" href="#Carousel3" class="left carousel-control"><</a>
                            <a data-slide="next" href="#Carousel3" class="right carousel-control">></a>
                            <%}%>
                        </div><!--.Carousel-->

                    </div>
                </div>
            </div><!--.container-->
                                </div>
                                <div id="list-stuff" class="col-lg-12" style="display: none;">
                                    <% Map<String, List<Movie>> user_lists = (Map) request.getAttribute("lists");
                                        if (user_lists.values().size() == 0) {%>

                                    <h2 style="padding-top: 50px">You havent created any list.</h2>    
                                    <%} else {
                                        int carousel_number=4;
                                        for (String list_name : user_lists.keySet()) {
                                    String carousel_id="Carousel"+carousel_number;
                                    String carousel_target="#Carousel"+carousel_number;%>
                                    <div class="container">
                                        <% ref="User_Lists_Servlet?list_name="+list_name.replaceAll(" ","_")+"&bot_limit=0&user="+u.getUsername();%>
                                        <h4 style="padding-top: 100px"> <a href=<%=ref%>><%=list_name%> </a> </h4>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div id="<%=carousel_id%>" class="carousel slide">

                                                    <ol class="carousel-indicators hidden">
                                                        <li data-target="<%=carousel_target%>" data-slide-to="0" class="active"></li>
                                                            <% List<Movie> movies = user_lists.get(list_name);
                                                            pages = (int) Math.ceil(movies.size() / 6.0);
                                                            for (i = 1; i < pages; i++) {%>
                                                        <li data-target="<%=carousel_target%>" data-slide-to="<%=i%>"></li>
                                                            <%}%>
                                                    </ol>

                                                    <!-- Carousel items -->
                                                    <div class="carousel-inner">

                                                        <div class="item active">
                                                            <div class="row">
                                                                <%
                                                                    i = 0;
                                                                    max_page = i + 6;
                                                                    for (i = 0; i < movies.size() && i < max_page; i++) {
                                                                        Movie m = movies.get(i);%>
                                                                <div class="col-md-2"><a href="<%="/MovieDB3/movie_details?id="+m.getId()+"&user="+u.getId()%>" class="thumbnail"><img src=<%=m.getPoster()%> alt="Image" style=" height:250px; max-width:100%;"></a>
                                                                    <div class="caption">
                                                                        <a href="<%="/MovieDB3/movie_details?id="+m.getId()+"&user="+u.getId()%>"><%=m.getTitle()%></a>
                                                                    </div>
                                                                </div>

                                                                <%}%>

                                                            </div><!--.row-->
                                                        </div><!--.item-->

                                                        <%
                                                            for (page_aux = 1; page_aux < pages; page_aux++) {
                                                        %>

                                                        <div class="item">
                                                            <div class="row">
                                                                <%
                                                                    max_page = max_page + 6;
                                                                    for (i = i; i < movies.size() && i < max_page; i++) {
                                                                        Movie m = movies.get(i);%>

                                                                <div class="col-md-2"><a href="<%="/MovieDB3/movie_details?id="+m.getId()+"&user="+u.getId()%>" class="thumbnail"><img src=<%=m.getPoster()%> alt="Image" style="height:250px; max-width:100%;"></a>
                                                                    <div class="caption">
                                                                        <a href="<%="/MovieDB3/movie_details?id="+m.getId()+"&user="+u.getId()%>"><%=m.getTitle()%></a>
                                                                    </div>
                                                                </div>

                                                                <%}%>
                                                            </div><!--.row-->
                                                        </div><!--.item-->
                                                        <%}%>
                                                    </div><!--.carousel-inner-->
                                                    <%if(movies.size()>6){%>
                                                    <a data-slide="prev" href="<%=carousel_target%>" class="left carousel-control"><</a>
                                                    <a data-slide="next" href="<%=carousel_target%>" class="right carousel-control">></a>
                                                    <%}%>
                                                </div><!--.Carousel-->

                                            </div>
                                        </div>
                                    </div><!--.container-->
                                    <%}
                                        }%>
                                </div>
                                <div id="rating-stuff" class="col-lg-12" style="display: none;">
                                     <% List<Ratings> ratings= (List) request.getAttribute("ratings");
                                        if(ratings.size()>0){%>
                                    <div class="container">
                                        <div class="row">
                                            <div class='list-group gallery'>
                                                <%for(Ratings r:ratings){
                                                    Movie m=r.getMovie();
                                                %>
                                                <div class='col-sm-4 col-xs-6 col-md-3 col-lg-3'>
                                                    <a class="fancybox thumbnail" rel="ligthbox" href="<%="/MovieDB3/movie_details?id="+m.getId()+"&user="+u.getId()%>">
                                                        <img class="img-responsive rated-poster" alt="" src=<%=m.getPoster()%> />
                                                    </a>
                                                    <a href="<%="/MovieDB3/movie_details?id="+m.getId()+"&user="+u.getId()%>"><%=m.getTitle()%></a>
                                                    <div class="star-ratings-css">
                                                        <div class="star-ratings-css"><p class="thick" style="color: #000"><%=r.getRating()%>  <span style="color: #FF6701">★</span></p></div>
                                                    </div>
                                                </div> <!-- col-6 / end -->
                                                <%}%>
                                            </div> <!-- list-group / end -->
                                        </div> <!-- row / end -->
                                    </div> <!-- container / end -->
                                    <%}else{%>
                                    <h1> You haven't rated any movie yet! </h1>
                                    <%}%>
                                </div>
                                <a id="back-to-top"  href="#" class="btn btn-primary btn-lg back-to-top" role="button" title="Click to return on the top page" data-toggle="tooltip" data-placement="left"><span class="glyphicon glyphicon-chevron-up"></span></a>
                            </div>
                        </div>
                    </div>
                </div>    
            </div>              
                  <!--<a id="myBTN"  href="#" class="btn btn-primary btn-lg back-to-top" role="button" title="Click to return on the top page" data-toggle="tooltip" data-placement="left"><span class="glyphicon glyphicon-chevron-up"></span></a> -->
                  
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
