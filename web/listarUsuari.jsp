<%-- 
    Document   : listContato
    Created on : 16/09/2014, 20:58:44
    Author     : marcelo.horvath1
--%>


<%@page import="Entity.Usuario"%>
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
            List<Usuario> lista = (List<Usuario>) request.getAttribute("listarUsuario");
            for (Usuario umUsuario : lista) {
        %>
        <table border="1">
            <tr>
                <td><%=umUsuario.getId()%></td>
                <td><%=umUsuario.getLogin()%></td>
                <td><%=umUsuario.getSenha()%></td>
                <td><%=umUsuario.getPerguntaDeSeguranca()%></td>
                <td><a href="servlet?acao=editarFilme&idFilme=<%=umUsuario.getId()%>">EDITAR</a></td>
                <td><a href="servlet?acao=excluirFilme&idFilme=<%=umUsuario.getId()%>">EXCLUIR</a></td>
            </tr> 
            <%
                }
            %>
        </table>
        <br/>
        <a href="servlet?acao=novoUsuario">Novo filme</a>
    </body>
</html>
