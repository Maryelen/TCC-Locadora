<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Reserva</h1>
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
                                <th>Foto</th>
                                <th width="160px">Acao</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="filme" items="${filmes}">


                                <tr class="odd gradeX">
                                    <td>${filme.id}</td>
                                    <td>${filme.nome}</td>
                                    <td>${filme.descricao}</td>
                                    <td>${filme.foto}</td>
                                    <td>
                                        <a href="#" class="btn" id="${filme.id}">
                                            <i class="fa fa-plus-square-o fa-fw"></i>Add
                                        </a>
                                        &nbsp;
                                        <a href="#" class="btnExcluir" id="${filme.id}">
                                            <i class="fa fa-search fa-fw"></i>Detalhe
                                        </a>                        
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

    $(".btnAlterar").click(function() {
        $("#conteudoForm").load("servlet", {
            //variaveis de controle
            txtObjeto: 'filme'
            , txtMetodo: 'detalhe'
                    //variaveis para o objeto
            , txtId: this.id
        }, function(responseTxt, statusTxt, xhr) {
            if (statusTxt == "error")
                alert("Error: " + xhr.status + ": " + xhr.statusText);
        });
    });

    $(".btnExcluir").click(function() {
        if (confirm('Deseja realmente excluir o registro?')) {
            $("#conteudoForm").load("servlet", {
                //variaveis de controle
                txtObjeto: 'filme'
                , txtMetodo: 'deletar'
                        //variaveis para o objeto
                , txtId: this.id
            }, function(responseTxt, statusTxt, xhr) {
                if (statusTxt == "error")
                    alert("Error: " + xhr.status + ": " + xhr.statusText);
            });
        }
    });

</script>
