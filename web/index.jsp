<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="col-lg-12">

    </div>
    <!-- /.col-lg-12 -->
</div><!doctype html>
<div class="row">
    <div class="">
    </div>
    <!-- /.col-lg-12 -->
</div>
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
            <div id="login-panel">
                <form class="form-group">
                    <div class="row">
                        <div class="col-md-2 col-md-offset-5">
                            Login<input type="text" class="form-control" placeholder="Digite seu login"  required autofocus>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2 col-md-offset-5">
                            Senha<input type="password" class="form-control" placeholder="Digite sua senha" required>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-md-2 col-md-offset-5">
                            <button class="btn btn-lg btn-primary btn-block" type="submit">
                                Acessar</button>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2 col-md-offset-5">
                            <a rel="stylesheet" href="naoSouCadastrado">Não Sou Cadastrado</a>
                        </div>
                    </div>

                </form>
            </div>
        </div>


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
