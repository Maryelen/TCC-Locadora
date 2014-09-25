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
        <%
            Filme filme = (Filme) request.getAttribute("editFilme");
        %>
        <form action="servlet" method="get">
            Nome: <input type="text" name="nomeFilme" value="<%=filme.getNomeFilme()%>" /><br />
            <a href="servlet?acao=editar"</a>
            <br />
            <br />
            <input type="submit" value="Editar" />
        </form>
    <c:import url="rodape.jsp" />
</body>
</html>