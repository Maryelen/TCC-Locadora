<%-- 
    Document   : acesso
    Created on : 29/10/2014, 22:06:56
    Author     : Jorgeluiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="servlet" method="post">
            Login: <input type="text" name="login" value="${usuario.login}" /><br />
            Senha: <input type="text" name="login" value="${usuario.login}" /><br />
            <a href="Servlet?acao=novoUsuario"</a><input type="image" value="Não sou Cadastrado"/>
        </form>  
    </body>
</html>
