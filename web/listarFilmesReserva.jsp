<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                <i class="fa fa-edit fa-fw"></i> Lista de Filmes
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">

                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover" id="dataTables-funcionarios">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Nome</th>
                                <th>Descrição</th>
                                <th>Ano</th>
                                <th>Genero</th>
                                <th>Locadora</th>
                                <th>Reservar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="filme" items="${filmes}">


                                <tr class="odd gradeX">
                                    <td>${filme.id}</td>
                                    <td>${filme.nome}</td>
                                    <td>${filme.descricao}</td>
                                    <td>${filme.ano}</td>
                                    <td>${filme.genero}</td>
                                    <td>${filme.nomeLocadora}</td>
                                    <td>
                                        <form name="combo">
                                            <a href="#" class="btnExcluir" id="${filme.id}">
                                                <input type="hidden" name="txtId" id="txtId" value="${filme.id}" >
                                                <input type="hidden" name="txtObjeto" id="txtObjeto" value="reserva" >
                                                <input type="hidden" name="txtMetodo" id="txtMetodo" value="salvar">
                                                <label><input id="combo" name="combo" type="checkbox"></label>
                                            </a>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel-body -->
    </div>
</div>
<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<!-- Page-Level Demo Scripts - Tables - Use for reference -->

<script>

    $(document).ready(function() {
        $('#dataTables-funcionarios').dataTable();
    });

    $(".btnExcluir").click(function() {
        if (confirm('Deseja reservar este filme?')) {
            $("#conteudoForm").load("servlet", {
                //variaveis de controle
                txtObjeto: 'reserva'
                , txtMetodo: 'salvar'
                        //variaveis para o objeto
                , txtId: this.id
            }, function(responseTxt, statusTxt, xhr) {
                if (statusTxt == "error")
                    alert("Error: " + xhr.status + ": " + xhr.statusText);
            });
        } else {
            document.combo.elements["combo"].checked = 0
        }
    });

</script>
