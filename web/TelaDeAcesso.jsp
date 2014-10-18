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
                    <input type="hidden" name="acao" value="Acesso"/>
                    <h2 class="form-signin-heading">Acesso Cliente</h2>
                    LOGIN:<input type="text" name="login" class="form-control" placeholder="Login" required autofocus>
                    SENHA:<input type="password" name="senha" class="form-control" placeholder="Senha" required>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
                </form>
            </div> <!-- /container -->
            <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
            <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
        </form>
    </body>
</html>
