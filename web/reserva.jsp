<%-- 
    Document   : reserva
    Created on : 29/10/2014, 22:34:17
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
        <input type="hidden" name="acao" value="Pesquisar">
        Título: <input type="text" name="filme" value="${filme.titulo}" /> 
        Ano: <input type="text" name="ano" value="${filme.ano}" /><br />
        Genero: <input type="text" generoFilme" value="${filme.generoFilme}" />
        Classificação Indicativa: <input type="text" name="classificaçãoIndicativa" value="${filme.classificaçãoIndicativa}" /><br /> 
        <input type="button" value="Pesquisar" />
    </body>
</html>
