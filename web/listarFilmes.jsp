<%-- 
    Document   : listContato
    Created on : 16/09/2014, 20:58:44
    Author     : marcelo.horvath1
--%>


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
            List<Filme> lista = (List<Filme>) request.getAttribute("listaFilme");
            for (Filme umFilme : lista) {
        %>
        <%=umFilme.getNomeFilme()%><br />
        <%
            }
        %>
    </body>
</html>
