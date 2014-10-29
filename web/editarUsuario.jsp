<%@page import="Entity.Filme"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <form action="servlet" method="get">
            <fieldset>
                <legend>Editar Usuário</legend>
                
                <input type="hidden" name="acao" value="salvarUsuario"/>
                
                <input type="hidden" name="id" 
                       value="${editarUsuario.id}" /> 

                <label for="nome">Nome:</label>
                <input type="text" 
                       name="login" value="${editarUsuario.login}"/>

                <label for="nome">Ano:</label>
                <input type="text" 
                       name="senha" value="${editarUsuario.senha}"/>

                <label for="nome">Genero:</label>
                <input type="text" 
                       name="perguntaDeSeguranca" value="${editarUsuario.perguntaDeSeguranca}"/>
            </fieldset>
            <input type='submit' value="editarUsuario"/>
        </form>
    </body>
</html>