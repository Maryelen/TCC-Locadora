<%-- 
    Document   : cadastrarCliente
    Created on : 17/10/2014, 20:41:25
    Author     : maryelen_cassia
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
            <input type="hidden" name="acao" value="salvarUsuario">
            <input type="hidden" name="id" value="0"/>
            Login: <input type="text" name="login" value="${usuario.login}" /><br />
            Senha: <input type="text" name="senha" value="${usuario.senha}" /><br />
            Pergunta de seguranção: <input type="text" name="perguntaDeSeguranca" value="${usuario.perguntaDeSeguranca}" /><br />
            <a href="Servlet?acao=salvarUsuario"</a>
            <br />
            <br />
            <input type="submit" value="salvar" />
        </form>
    <c:import url="rodape.jsp" />
</body>
</html>
