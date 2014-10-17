<%-- 
    Document   : teste
    Created on : 17/10/2014, 18:59:36
    Author     : jorge_filho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    </head>
    <body>
        <!-- Incluindo o jQuery que é requisito do JavaScript do Bootstrap -->
        <script src="http://code.jquery.com/jquery-latest.js"></script>

        <!-- Incluindo o JavaScript do Bootstrap -->
        <script src="js/bootstrap.min.js"></script>
        <form class="form-horizontal">
         <div class="container">

      <form class="form-signin" role="form">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="email" class="form-control" placeholder="Email address" required autofocus>
        <input type="password" class="form-control" placeholder="Password" required>
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
        </form>
    </body>
</html>
