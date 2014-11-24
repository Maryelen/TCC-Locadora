<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Filme</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                <i class="fa fa-edit fa-fw"></i> Cadastro de Filme
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <form role="form" id="formAtual" name="formAtual">
                    <div class="btn-toolbar">
                        <!-- Div para agrupar os botões com texto e com ícone -->
                        <div class="btn-group">
                            <button id="btn-selecione" class="btn btn-large dropdown-toggle span4" style="text-align: left;">
                                Selecione
                            </button>
                            <button id="btn-caret" class="btn btn-large dropdown-toggle" data-toggle="dropdown">
                                <i class="caret"></i>
                            </button>
                            <!-- Lista de opções -->
                            <ul id="ul-dropdown-menu" class="dropdown-menu" style="width: 400px;">
                                <c:forEach var="locadora" items="${locadoras}">
                                    <li id="txtNomeLocadora" name="txtNomeLocadora"><a href="#">${locadora.nome}</a></li>
                                    </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label>Nome</label>
                                <input class="form-control" placeholder="Informe o nome" type="text" id="txtNome" name="txtNome">
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label>Descrição</label>
                                <input class="form-control" placeholder="Informe a Descrição" type="text" id="txtDescricao" name="txtDescricao">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label>Ano</label>
                                <input class="form-control" placeholder="insira o ano" type="text" id="txtAno" name="txtAno">
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label>Genero</label>
                                <input class="form-control" placeholder="insira o genero" type="text" id="txtGenero" name="txtGenero">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12" align="right">
                            <input type="hidden" name="txtObjeto" id="txtObjeto" value="filme" >
                            <input type="hidden" name="txtMetodo" id="txtMetodo" value="salvar">
                            <button tabindex="5" type="button" class="btn btn-default" id="btnEnviar">Salvar</button>
                        </div>
                    </div>
                </form>
                <!-- /.row (nested) -->
            </div>
            <!-- /.panel-body -->
        </div>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div id="listafilme"></div>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->


<script type="text/javascript">
    $(document).ready(function() {

    });

    $("#btnEnviar").click(function() {
        $("#conteudoForm").load("servlet", {
            //variaveis de controle
            txtObjeto: document.forms["formAtual"].elements["txtObjeto"].value
            , txtMetodo: document.forms["formAtual"].elements["txtMetodo"].value
                    //variaveis para o objeto
            , txtNome: document.forms["formAtual"].elements["txtNome"].value
            , txtDescricao: document.forms["formAtual"].elements["txtDescricao"].value
            , txtAno: document.forms["formAtual"].elements["txtAno"].value
            , txtGenero: document.forms["formAtual"].elements["txtGenero"].value
            , txtIdLocadora: document.forms["formAtual"].elements["txtIdLocadora"].value
        }, function(responseTxt, statusTxt, xhr) {
            if (statusTxt == "error")
                alert("Error: " + xhr.status + ": " + xhr.statusText);
        });
    });

</script>
<script type="text/javascript">
    $(document).ready(function() {
        // Adiciona a aparência de dropdown para os elementos que possuem a classe dropdown-toggle.
        $('.dropdown-toggle').dropdown();
    });

    // Adiciona o efeito slideToogle ao clicar nos botões.
    $('#btn-selecione, #btn-caret').click(function() {
        $('#ul-dropdown-menu').slideToggle();
    });

    // Altera os textos de acordo com o item selecionado.
    $('#ul-dropdown-menu li').click(function() {
        $("#span-item-selecionado").text($(this).text());
        $("#btn-selecione").text($(this).text());
        $('#ul-dropdown-menu').slideToggle();
    });
</script>
