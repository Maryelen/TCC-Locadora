<%-- 
    Document   : index
    Created on : 04/09/2014, 18:59:56
    Author     : jorge_filho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
    </head>
    <body>
        <div>Cadastro de Filmes</div>
        <br />
        <br />
        <br />
        <br />
        <form action="TESTE6" method="get">
            Titulo: <input type="text" name ="nomeFilme" id="nomeFilme"/>
            <br />
            <br />
            Ano de lançamento: <input type="text" name="anoFilme" id="anoFilme" />
            <br />
            <br />
            Genero:
            <select name="generoFilme">
                <option value="AÇÃO">AÇÃO</option>
                <option value="TERROR">TERROR</option>
                <option value="COMÉDIA ROMÂNTICA">COMÉDIA ROMÂNTICA</option>
                <option value="COMÉDIA">COMÉDIA</option>
                <option value="FAROESTE">FAROESTE</option>
                <option value="DRAMA">DRAMA</option>
                <option value="BIOGRAFIA">BIOGRAFIA</option>
                <option value="CLASSICOS">CLASSICOS</option>
                <option value="CRIME">CRIME</option>
                <option value="CURTA-METRAGEM">CURTA-METRAGEM</option>
                <option value="DOCUMENTARIO">DOCUMENTARIO</option>
                <option value="ESPORTE">ESPORTE</option>
                <option value="FAMÍLIA">FAMÍLIA</option>
                <option value="FANTASIA">FANTASIA</option>
                <option value="FICÇÃO CIENTÍFICA">FICÇÃO CIENTÍFICA</option>
                <option value="GUERRA">GUERRA</option>
                <option value="HISTÓRIA">HISTÓRIA</option>
                <option value="INDEPENDENTE">INDEPENDENTE</option>
                <option value="INFANTIS">INFANTIS</option>
                <option value="MISTÉRIO">MISTÉRIO</option>
                <option value="MUSICAL">MUSICAL</option>
                <option value="ROMANCE">ROMANCE</option>
                <option value="SUSPENSE">SUSPENSE</option>
            </select> 
            <br />
            <br />
            Diretor: <input type="text" name="diretorFilme" id="diretorFilme" />
            <br />
            <br />
            Codigo: <input type="text" name="codigoFilme" id="codigoFilme" />
            <br />
            <br />
            Midia:
            <select name="midiaFilme">
                <option value="DVD">DVD</option>
                <option value="BLU-RAY">BLU-RAY</option>
                <option value="VHS">VHS</option>
            </select> 
            <br />
            <br />
            Sinopse:     
            <textarea name="sinopseFilme" rows="4" cols="50" id="sinopseFilme"></textarea> 
            <br />
            <br />
            Produtora: <input type="text" name="produtoraFilme" id="produtoraFilme" />
            <br />
            <br />
            Classificação indicativa: 
            <select name="classificacaoFilme">
                <option value="L">LIVRE</option>
                <option value="10">10 ANOS</option>
                <option value="12">12 ANOS</option>
                <option value="14">14 ANOS</option>
                <option value="16">16 ANOS</option>
                <option value="18">18 ANOS</option>
            </select> 
            <br />
            <br />
            Valor pago:<input type="text" name="valorFilmePagoLocadora" id="valorFilmePagoLocadora" />
            <br />
            <br />
            Classificação:
            <select name="classificacaoValorFilme">
                <option value="24H LANCAMENTO">24H LANCAMENTO</option>
                <option value="48H">48H</option>
                <option value="ACERVO">ACERVO</option>
            </select>
            <input type="submit" value="Salvar" />
            <br />
            <br />
        </form>
    </body>
</html>
