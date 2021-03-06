<%@page import="Entity.Reserva"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="pt-br">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Sistema de Reserva de Filmes</title>

        <!-- Core CSS - Include with every page -->
        <link href="include/css/bootstrap.min.css" rel="stylesheet">
        <link href="include/font-awesome/css/font-awesome.css" rel="stylesheet">
        <link href="include/css/datepicker.css" rel="stylesheet">
        <!-- Page-Level Plugin CSS - Tables -->
        <link href="include/css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">
        <!-- Page-Level Plugin CSS - Dashboard -->
        <link href="include/css/plugins/timeline/timeline.css" rel="stylesheet">
        <!-- SB Admin CSS - Include with every page -->
        <link href="include/css/sb-admin.css" rel="stylesheet">

        <!-- Fav and touch icons -->
        <link rel="shortcut icon" href="include/img/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="include/img/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="include/img/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="include/img/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="include/img/apple-touch-icon-57-precomposed.png">        
    </head>

    <body>

        <div id="wrapper">
            <nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                        <span class="sr-only">SRF</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="admin">Sistema de Reserva de Filmes</a>
                </div>
                <!-- /.navbar-header -->

                <div class="navbar-default navbar-static-side" role="navigation">
                    <div class="sidebar-collapse">
                        <ul class="nav" id="side-menu">
                            <li>
                                <a href="menu_Usuario.jsp"><i class="fa fa-home fa-fw"></i> Principal </a>
                            </li>
                            <li><a href="#" class="linkLista" id="reserva"><i class="fa fa-files-o fa-fw"></i>Reserva</a></li>
                            <li><a href="#" class="linkLista" id="minhas_reservas"><i class="fa fa-edit fa-fw"></i> Minhas Reservas</a></li>
                            <li><a href="index.jsp"><i class="fa fa-edit fa-fw"></i>Sair</a></li>
                        </ul>
                        <!-- /#side-menu -->
                    </div>
                    <!-- /.sidebar-collapse -->
                </div>
                <!-- /.navbar-static-side -->
            </nav>

            <div id="page-wrapper">
                <div class="row">
                    <div id="conteudoForm">
                        <image src="imagens/fundo.jpg"/>
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- Core Scripts - Include with every page -->
    <script src="include/js/jquery-1.10.2.js"></script>
    <script src="include/js/bootstrap.min.js"></script>
    <script src="include/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="include/js/bootstrap-datepicker.js"></script>

    <!-- Page-Level Plugin Scripts - Dashboard -->
    <script src="include/js/plugins/morris/raphael-2.1.0.min.js"></script>

    <!-- Page-Level Plugin Scripts - Tables -->
    <script src="include/js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="include/js/plugins/dataTables/dataTables.bootstrap.js"></script>

    <!-- SB Admin Scripts - Include with every page -->
    <script src="include/js/sb-admin.js"></script>

    <!-- Scripts de funcionario da pagina -->
    <script type="text/javascript">
        $(".linkForm").click(function() {
            $("#conteudoForm").load("servlet", {
                //variaveis de controle
                txtObjeto: this.id
                , txtMetodo: 'principal'
            }, function(responseTxt, statusTxt, xhr) {
                if (statusTxt == "error")
                    alert("Error: " + xhr.status + ": " + xhr.statusText);
            });
        });

        $(".linkLista").click(function() {
            $("#conteudoForm").load("servlet", {
                //variaveis de controle
                txtObjeto: this.id
                , txtMetodo: 'listar'
            }, function(responseTxt, statusTxt, xhr) {
                if (statusTxt == "error")
                    alert("Error: " + xhr.status + ": " + xhr.statusText);
            });
        });

    </script>


</body>

</html>