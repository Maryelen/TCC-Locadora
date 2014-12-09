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
                <i class="fa fa-edit fa-fw"></i> Lista de Reservas
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">

                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover" id="dataTables-funcionarios">
                        <thead>
                            <tr>
                                <th>Nome</th>
                                <th>Genero</th>
                                <th>Locadora</th>
                                <th>Situação</th>
                                <th>Cancelar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="reserva" items="${reservas}">


                                <tr class="odd gradeX">
                                    <td>${reserva.nomeFilme}</td>
                                    <td>${reserva.genero}</td>
                                    <td>${reserva.nomeLocadora}</td>
                                    <td>${reserva.situacao}</td>
                                    <td>
                                        <a href="#" class="btnExcluir" id="${reserva.id}">
                                            <i class="fa fa-trash-o fa-fw"></i>Excluir
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
