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
        <table border="1">
            <tr>
                <td><%=umFilme.getNomeFilme()%></td>
                <td><%=umFilme.getAnoFilme()%></td>
                <td><%=umFilme.getGeneroFilme()%></td>
                <td><%=umFilme.getDiretorFilme()%></td>
                <td><%=umFilme.getCodigoFilme()%></td>
                <td><%=umFilme.getMidiaFilme()%></td>
                <td><%=umFilme.getSinopseFilme()%></td>
                <td><%=umFilme.getProdutoraFilme()%></td>
                <td><%=umFilme.getClassificacaoIndicativaFilme()%></td>
                <td><%=umFilme.getValorPagoLocadora()%></td>
                <td><%=umFilme.getClassificacaoValorFilme()%></td>
                <td><a href="servlet?acao=editarFilme&idFilme=<%=umFilme.getIdFilme()%>">EDITAR</a></td>
            </tr>
            <%
                }
            %>
        </table>

        <a href="servlet?acao=novo">Novo filme</a>
    </body>
</html>
