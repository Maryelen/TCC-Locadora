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
                <legend>Editar Filme</legend>
                
                <input type="hidden" name="acao" value="salvar"/>
                
                <input type="hidden" name="idFilme" 
                       value="${editFilme.idFilme}" /> 

                <label for="nome">Nome:</label>
                <input type="text" 
                       name="nomeFilme" value="${editFilme.nomeFilme}"/>

                <label for="nome">Ano:</label>
                <input type="text" 
                       name="anoFilme" value="${editFilme.anoFilme}"/>

                <label for="nome">Genero:</label>
                <input type="text" 
                       name="generoFilme" value="${editFilme.generoFilme}"/>

                <label for="nome">Diretor:</label>
                <input type="text" 
                       name="diretorFilme" value="${editFilme.diretorFilme}"/>
                <br/>

                <label for="nome">Código:</label>
                <input type="text" 
                       name="codigoFilme"  value="${editFilme.codigoFilme}" /> 

                <label for="nome">Midia:</label>
                <input type="text" 
                       name="midiaFilme"  value="${editFilme.midiaFilme}" />

                <label for="nome">Sinopse:</label>
                <input type="text" 
                       name="sinopseFilme"  value="${editFilme.sinopseFilme}" />

                <label for="nome">Produtora:</label>
                <input type="text" 
                       name="produtoraFilme"  value="${editFilme.produtoraFilme}" /> 
                <br/>

                <label for="nome">Classificação indicativa:</label>
                <input type="text" 
                       name="classificacaoFilme"  value="${editFilme.classificacaoIndicativaFilme}" /> 

                <label for="nome">Valor pago:</label>
                <input type="text" 
                       name="valorFilmePagoLocadora"  value="${editFilme.valorPagoLocadora}" /> 

                <label for="nome">Classificação:</label>
                <input type="text" 
                       name="classificacaoValorFilme"  value="${editFilme.classificacaoValorFilme}" /> 
            </fieldset>
            <input type='submit' value="salvar"/>
        </form>
    </body>
</html>