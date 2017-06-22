<%-- 
    Document   : homepage_logedout
    Created on : 22/jun/2017, 10:54:24
    Author     : Utilizador
--%>

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
	<link href="starter-template.css" rel="stylesheet">
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
        <div class="navbar navbar-default navbar-fixed-top" role="navigation">
     <div class="container">
       <div class="navbar-header">
         <a class="navbar-brand" href="#">
         <img class="img-fluid" alt="MovieDB" src="/images/logo.jpg" width="50" height="100">
         </a>
         <a class="navbar-brand" href="#" style="padding-top:15px">
            MovieDB
         </a>
       </div>
       <div class="navbar-collapse collapse">
          <form method="POST" action="Login_Register_Page_Servlet" class="navbar-form navbar-right" >
               <input type="submit" name="login" class="btn btn-default" value="Login">
               <input type="submit" name=register" class="btn btn-default" value="Register">
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
        <h1>Hello World!/h1>
    </body>
</html>
