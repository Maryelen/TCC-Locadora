<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Locadora</h1>
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
                <i class="fa fa-edit fa-fw"></i> Cadastro de Locadora
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <form role="form" id="formAtual" name="formAtual">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label>Nome</label>
                                <input class="form-control" placeholder="Informe o nome" type="text" id="txtNome" name="txtNome">
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label>Cnpj</label>
                                <input class="form-control" placeholder="Informe o Cnpj" type="text" id="txtCnpj" name="txtCnpj">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label>Rua</label>
                                <input class="form-control" placeholder="Informe a Rua" type="text" id="txtRua" name="txtRua">
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label>Número</label>
                                <input class="form-control" placeholder="Informe o Número" type="text" id="txtNumero" name="txtNumero">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label>Complemento</label>
                                <input class="form-control" placeholder="Informe o Complemento" type="text" id="txtComplemento" name="txtComplemento">
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label>Cep</label>
                                <input class="form-control" placeholder="Informe o Cep" type="text" id="txtCep" name="txtCep">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label>Bairro</label>
                                <input class="form-control" placeholder="Informe o Bairro" type="text" id="txtBairro" name="txtBairro">
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label>Cidade</label>
                                <input class="form-control" placeholder="Informe a Cidade" type="text" id="txtCidade" name="txtCidade">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label>Estado</label>
                                <input class="form-control" placeholder="Informe o Estado" type="text" id="txtEstado" name="txtEstado">
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label>Telefone Comercial</label>
                                <input class="form-control" placeholder="Informe o Telefone Comercial" type="text" id="txtTelefoneComercial" name="txtTelefoneComercial">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label>Telefone de Contato</label>
                                <input class="form-control" placeholder="Informe o Telefone de Contato" type="text" id="txtTelefoneContato" name="txtTelefoneContato">
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label>Email</label>
                                <input class="form-control" placeholder="Informe o Email" type="text" id="txtEmail" name="txtEmail">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label>Site</label>
                                <input class="form-control" placeholder="Informe o Site" type="text" id="txtSite" name="txtSite">
                            </div>
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
