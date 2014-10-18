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
        <form action="servlet" method="get">
            <input type="hidden" name="acao" value="salvar">
            <input type="hidden" name="idCliente" value="0"/>
            Nome: <input type="text" name="nomeCliente" value="${cliente.nomeCliente}" /><br />
            Email: <input type="text" name="email" value="${cliente.email}" /><br />
            CPF: <input type="text" name="cpf" value="${cliente.cpf}" /><br />
            Endereço: <input type="text" name="endereco" value="${cliente.endereco}" /><br />
            Bairro: <input type="text" name="bairro" value="${cliente.bairro}" /><br />
            Complemento: <input type="text" name="complemento" value="${cliente.complemento}" /><br />
            Cidade: <input type="text" name="cidade" value="${cliente.cidade}" /><br />
            Estado: <input type="text" name="estado" value="${cliente.estado}" /><br />
            Telefone Residencial: <input type="text" name="telefoneResidencial" value="${cliente.telefoneResidencial}" /><br />
            Telefone Celular: <input type="text" name="telefoneCelular" value="${cliente.telefoneCelular}" /><br />
            Telefone Recado: <input type="text" name="telefoneRecado:" value="${cliente.telefoneRecado}" />
            <a href="servlet?acao=validaAcesso"</a>
            <br />
            <br />
            <input type="submit" value="Enviar" />
        </form>
    <c:import url="rodape.jsp" />
</body>
</html>
