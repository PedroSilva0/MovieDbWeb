<!DOCTYPE html>
<html lang="en">
    <head> 
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/login.css">

    <!-- Website CSS style -->
    <link rel="stylesheet" type="text/css" href="css/main.css">

    <!-- Website Font style -->
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
    
    <!-- Google Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>

    <title>Admin</title>
  </head>
  <body>
    <div class="container">
      <div class="row main">
        <div class="panel-heading">
                 <div class="panel-title text-center">
                    <h1 class="title">MovieDB</h1>
                    <hr />
                  </div>
              </div> 
        <div class="main-login main-center">
          <h6>Register once for full acess to all features.</h6>
          <%
                int register_state= (int) request.getAttribute("register_state");
            %>
          <form class="form-horizontal" method="POST" action="RegisterServlet">
            <%
                if(register_state==-3){
              %>
            <div class="alert alert-danger alert-dismissable">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Error!</strong> Username already taken.
            </div>
            <%}%>
            <div class="form-group">
              <label for="name" class="cols-sm-2 control-label">Your Name</label>
              <div class="cols-sm-10">
                <div class="input-group">
                  <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                  <input type="text" class="form-control" name="name" id="name"  placeholder="Enter your Username"/>
                </div>
              </div>
            </div>
              <%
                if(register_state==-2){
              %>
            <div class="alert alert-danger alert-dismissable">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Error!</strong> Invalid email format.
            </div>
            <%}%>
            <div class="form-group">
              <label for="email" class="cols-sm-2 control-label">Your Email</label>
              <div class="cols-sm-10">
                <div class="input-group">
                  <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                  <input type="text" class="form-control" name="email" id="email"  placeholder="Enter your Email"/>
                </div>
              </div>
            </div>
               <%
                
                if(register_state==-1){
            %>
            <div class="alert alert-danger alert-dismissable">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Error!</strong> Passwords don't match.
            </div>
            <%}%>
            <div class="form-group">
              <label for="password" class="cols-sm-2 control-label">Password</label>
              <div class="cols-sm-10">
                <div class="input-group">
                  <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                  <input type="password" class="form-control" name="password" id="password"  placeholder="Enter your Password"/>
                </div>
              </div>
            </div>

            <div class="form-group">
              <label for="confirm" class="cols-sm-2 control-label">Confirm Password</label>
              <div class="cols-sm-10">
                <div class="input-group">
                  <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                  <input type="password" class="form-control" name="password2" id="confirm"  placeholder="Confirm your Password"/>
                </div>
              </div>
            </div>

            <div class="form-group ">
              <input type="submit" class="btn btn-primary btn-lg btn-block login-button" value="Register">
            </div>
            <div class="login-register">
                    <a name="login" href="Login_Register_Page_Servlet?login=login">Login</a>
                 </div>
          </form>
        </div>
      </div>
    </div>

    <script type="text/javascript" src="assets/js/bootstrap.js"></script>
  </body>
</html>