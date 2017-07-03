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
        <link href="css/star-rating.css" media="all" rel="stylesheet" type="text/css" />
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="css/loged_in.css" rel="stylesheet">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
          <![endif]-->
    </head>
    <body>
        <div>
            <% User u = (User) request.getSession().getAttribute("user");%>
            <% if(u == null) { %>
                <div class="navbar navbar-default navbar-fixed-top" role="navigation" style="background-color:#353135">
                <div class="container">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">
                            <img class="img-fluid" alt="MovieDB" src="images/logo.jpg" width="50" height="100">
                        </a>
                        <a class="navbar-brand" href="/MovieDB3/homepage_logedout" style="padding-top:15px;margin-left:10px;color:whitesmoke">
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
                <nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="background-color:#353135">
                    <div class="container">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="navbar-header">
                            <a class="navbar-brand" href="#">
                                <img class="img-fluid" alt="MovieDB" src="images/logo.jpg" width="50" height="100">
                            </a>
                            <a class="navbar-brand" href="#" style="padding-top:15px;margin-left:10px;color:whitesmoke">
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
                            <% } %>
                            <div class="panel-body">
                                <% Movie movie = (Movie)request.getSession().getAttribute("movie");%>
                                <% if(u == null) { %>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <h1 style="display: inline-block"><%= movie.getTitle()%></h1>
                                        </div>
                                        <div class="col-md-3">
                                        </div>
                                        <div class="col-md-3" style="margin-top:28px">
                                            <span class="star-ratings-css"><span style="color: #000"><%=movie.getRating()%>  <span style="color: #ff6600">★</span></span></span>
                                        </div>
                                    </div>
                                <% } else { %>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <h1 style="display: inline-block"><%= movie.getTitle()%></h1>
                                        </div>
                                        <div class="col-md-1" style="margin-top:28px">
                                            <span class="star-ratings-css"><span style="color: #000"><%=movie.getRating()%>  <span style="color: #ff6600">★</span></span></span>
                                        </div>
                                        <div class="col-md-1">
                                        </div>
                                        <div class="col-md-6" style="margin-top:28px">
                                            <input id="starsRating" onclick="saveRating()" name="input-name" type="number" class="rating" data-min=0 data-max=10 data-step=1 data-stars=10 data-size="xs">
                                        </div>
                                    </div>
                                <% } %>
                                <div class="row" style="margin-top:5px">
                                    <div class="col-md-12">
                                        <%= "Duration: "+ movie.getDuration()+" min"%>
                                        <span style="margin-left: 20px"><%= movie.getGenre()%></span>
                                        <span style="margin-left: 20px"><%= movie.getRelease_day()+"/"+movie.getRelease_month()+"/"+movie.getRelease_year()%></span>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-4">
                                        <img src=<%=movie.getPoster()%> alt="Image" style=" margin-top:10px; height:40%; width:85%;">
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
                                    <div class="col-md-12">
                                        <span style="font-weight: bold">Cast:</span>
                                        <% List<Staff> actors = (List<Staff>)request.getAttribute("cast"); %>
                                        <% for(int i=0;i<actors.size();i++) {%>
                                            <% if(actors.size() == 1){ %>
                                                <span style="margin-left:10px"> <a href="#"><%= actors.get(i).getName() %></a></span>
                                            <% }else if(i==0){ %>
                                                <span style="margin-left:10px"> <a href="#"><%= actors.get(i).getName()+", " %></a></span>
                                            <% }else if(i<actors.size()-1){ %>
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
                      
                      
                <script>
                    // This code goes ABOVE the main HTML Comment Box code!
                    // replace the text in the single quotes below to customize labels.
                    hcb_user = {
                        // L10N
                        comments_header : 'Make a review',
                        name_label : 'Name',
                        content_label: 'Enter your review here',
                        submit : 'OK',
                        logout_link : '<img title="log out" src="//www.htmlcommentbox.com/static/images/door_out.png" alt="[logout]" class="hcb-icon"/>',
                        admin_link : '<img src="//www.htmlcommentbox.com/static/images/door_in.png" alt="[login]" class="hcb-icon"/>',
                        no_comments_msg: 'No one has made a review yet. Be the first!',
                        add:'Add your review',
                        again: 'Make another review',
                        rss:'<img src="//www.htmlcommentbox.com/static/images/feed.png" class="hcb-icon" alt="rss"/> ',
                        said:'wrote:',
                        prev_page:'<img src="//www.htmlcommentbox.com/static/images/arrow_left.png" class="hcb-icon" title="previous page" alt="[prev]"/>',
                        next_page:'<img src="//www.htmlcommentbox.com/static/images/arrow_right.png" class="hcb-icon" title="next page" alt="[next]"/>',
                        showing:'Showing',
                        to:'to',
                        website_label:'website (optional)',
                        email_label:'email',
                        anonymous:'Anonymous',
                        mod_label:'(mod)',
                        subscribe:'email me replies',
                        are_you_sure:'Do you want to flag this review as inappropriate?',

                        reply:'<img src="//www.htmlcommentbox.com/static/images/reply.png"/> reply',
                        flag:'<img src="//www.htmlcommentbox.com/static/images/flag.png"/> flag',
                        like:'<img src="//www.htmlcommentbox.com/static/images/like.png"/> like',

                        //dates
                        days_ago:'days ago',
                        hours_ago:'hours ago',
                        minutes_ago:'minutes ago',
                        within_the_last_minute:'seconds ago',

                        msg_thankyou:'Thank you for sharing your review!',
                        msg_approval:'(this review is not published until approved)',
                        msg_approval_required:'Thank you for reviewing! Your review will appear once approved by a moderator.',

                        err_bad_html:'Your comment contained bad html.',
                        err_bad_email:'Please enter a valid email address.',
                        err_too_frequent:'You must wait a few seconds between posting comments.',
                        err_comment_empty:'Your comment was not posted because it was empty!',
                        err_denied:'Your comment was not accepted.',

                        //SETTINGS
                        MAX_CHARS: 8192,
                        PAGE:'', // ID of the webpage to show comments for. defaults to the webpage the user is currently visiting.
                        RELATIVE_DATES:true // show dates in the form "X hours ago." etc.
                    };
                </script>
<!-- done customizing labels of htmlcommentbox.com -->  
                <% if(u != null) { %>
                    <div class="row">
                        <h1 style="margin-botton:10px">Reviews</h1>
                        <!-- begin wwww.htmlcommentbox.com -->
                        <div id="HCB_comment_box"><a href="http://www.htmlcommentbox.com">HTML Comment Box</a> is loading comments...</div>
                        <link rel="stylesheet" type="text/css" href="//www.htmlcommentbox.com/static/skins/bootstrap/twitter-bootstrap.css?v=0" />
                        <script type="text/javascript" id="hcb"> /*<!--*/ if(!window.hcb_user){hcb_user={};} (function(){var s=document.createElement("script"), l=hcb_user.PAGE || (""+window.location).replace(/'/g,"%27"), h="//www.htmlcommentbox.com";s.setAttribute("type","text/javascript");s.setAttribute("src", h+"/jread?page="+encodeURIComponent(l).replace("+","%2B")+"&opts=16862&num=10&ts=1499029483375");if (typeof s!="undefined") document.getElementsByTagName("head")[0].appendChild(s);})(); /*-->*/ </script>
                       <!-- end www.htmlcommentbox.com -->
                    </div>
                <% } %>
            </div>
        </div>
                                                            
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        
        
        <script>
            function saveRating() {
                var rating = document.getElementById('starsRating').value;
                console.log("STAR RATING: " + rating);
                var xmlHttp = new XMLHttpRequest();
                xmlHttp.onreadystatechange = function() { 
                    if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
                        callback(xmlHttp.responseText);
                }
                xmlHttp.open("GET", "/MovieDB3/ratings_servlet?rating="+rating, true); // true for asynchronous 
                xmlHttp.send(null);
            }
        </script>
        
        
        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.js"></script>
        <script src="js/star-rating.js" type="text/javascript"></script>
        <script src="js/loged_in.js"></script>
        <!-- <script>
            $(document).on('ready', function(){
                $('#starsRating').rating({min: 0, max: 10, step: 1, stars: 10, size:"xs"});
            });
        </script> -->
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="js/ie10-viewport-bug-workaround.js"></script>
        <script src="js/ie-emulation-modes-warning.js"></script>
    </body>
</html>
