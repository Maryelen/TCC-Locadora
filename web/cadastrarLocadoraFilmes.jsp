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
                <i class="fa fa-edit fa-fw"></i> Filmes de Lacadora
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <form role="form" id="formFilmes" name="formFilmes">
                    <div class="row">
                        <div class="col-lg-12">
                            <c:forEach var="filme" items="${filmes}">
                            <div class="form-group">
                                <label>Nome</label>
                                <input class="form-control chkFilms" placeholder="Informe o nome" type="checkbox" id="txtNome" name="txtNome">
                            </div>
                            </foreach>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-12" align="right">
                            <input type="hidden" name="txtObjeto" id="txtObjeto" value="locadora" >
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
        <div id="listalocadora"></div>
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
            , txtCnpj: document.forms["formAtual"].elements["txtCnpj"].value
            , txtRua: document.forms["formAtual"].elements["txtRua"].value
            , txtNumero: document.forms["formAtual"].elements["txtNumero"].value
            , txtComplemento: document.forms["formAtual"].elements["txtComplemento"].value
            , txtBairro: document.forms["formAtual"].elements["txtBairro"].value
            , txtCidade: document.forms["formAtual"].elements["txtCidade"].value
            , txtEstado: document.forms["formAtual"].elements["txtEstado"].value
            , txtCep: document.forms["formAtual"].elements["txtCep"].value
            , txtTelefoneComercial: document.forms["formAtual"].elements["txtTelefoneComercial"].value
            , txtTelefoneContato: document.forms["formAtual"].elements["txtTelefoneContato"].value
            , txtEmail: document.forms["formAtual"].elements["txtEmail"].value
            , txtSite: document.forms["formAtual"].elements["txtSite"].value

        }, function(responseTxt, statusTxt, xhr) {
            if (statusTxt == "error")
                alert("Error: " + xhr.status + ": " + xhr.statusText);
        });
    });

</script>
