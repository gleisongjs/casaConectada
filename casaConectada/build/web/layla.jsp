<%-- 
    Document   : layla
    Created on : 08/03/2017, 11:23:43
    Author     : Gleisongjs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sistema Layla</title>
        <meta charset="utf-8">
        <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="Casa Conectada" content="Sistema Água para Layla">

        <!-- inserindo o bootstrap-->
        <link href="public/css/bootstrap.min.css" rel="stylesheet">
        <link href="public/css/bootstrap-select.min.css" rel="stylesheet">
        <link href="public/css/style.css" rel="stylesheet">
        <link href="public/css/costumizado.css" rel="stylesheet">

        <link href="public/stylesheets/locastyle.css" rel="stylesheet" type="text/css">
        <link rel="icon" sizes="192x192" href="images/portal.png">
        <link rel="apple-touch-icon" href="public/img//portal.png">
        <!-- Ele funciona da mesma com toda a versão do jQuery 1.x para 2.x -->
        <script src="public/js/jquery-1.9.1.min.js" type="text/javascript"></script>
        <script src="public/js/jquery.min.js" type="text/javascript"></script>
    </head>
    <body>

        <div class="ls-topbar ">


            <span class="ls-show-sidebar ls-ico-menu"></span>

            <a href="/locawebstyle/documentacao/exemplos//pre-painel"  class="ls-go-next"><span class="ls-text">Voltar à lista de serviços</span></a>

            <!-- Nome do produto/marca com sidebar -->
            <h1 class="ls-brand-name">
                <a href="index.jsp" class="ls-ico-hours">
                    Casa Conectada
                </a>
            </h1>
        </div>
        <aside class="ls-sidebar">

            <div class="ls-sidebar-inner">
                <a href="#"  class="ls-go-prev"><span class="ls-text">Voltar à lista de serviços</span></a>

                <nav class="ls-menu">
                    <ul>
                        <li><a href="SensorSV?action=layla"class="ls-ico-checkmark-circle" title="layla">SISTEMA LAYLA</a></li>
                        <li><a href="sistemaLaylaDB?action=layladb"class="ls-ico-checkmark-circle" title="layla">DB SISTEMA LAYLA </a></li>
                        <li><a href="DroneSV?action=drone"class="ls-ico-checkmark-circle" title="drone">SISTEMA DRONE</a></li>
                        <li><a href="twittaConexaoDB?action=twittaconexaodb" class="ls-ico-checkmark-circle" title="twitta">TWITTA CONEXÃO</a></li>
                        <li><a href="#" class="ls-ico-checkmark-circle" title="listar">SISTEMA RASBERRY</a></li>
                    </ul>
                </nav>
            </div>
        </aside>

        <script type="text/javascript" src="public/lib/jquery.min.js"></script>
        <script src="public/js/locastyle.js" type="text/javascript"></script>
        <script type="text/javascript" src="public/js/jquery-1.9.1.min.js"></script>

        <main class="ls-main ">
            <div class="container col-md-12">
                <h1 class="ls-title-intro ls-ico-home"> SISTEMA LAYLA </h1>
                
                <div class="panel panel-default col-md-12">
                    <div class="panel-heading"><span class="glyphicon glyphicon-tint"></span> Monitor</div>
                    <div class="panel-body">  
                        ${resultado}
                    </div>
                </div>

                <div class="panel panel-default col-md-12">
                    <div class="panel-heading"><span class="glyphicon glyphicon-cog"></span> Painel de Controle</div>
                    <div class="panel-body col-md-3"> </div>
                    <div class="panel-body col-md-3"> 
                        <a href="SensorSV?action=led"


                           <button  type="button" id="led" >

                                <%
                                    HttpSession ses = request.getSession(true);

                                    String s = (String) ses.getAttribute("led");

                                    if (s == "f") {
                                %>    
                                <script class="btn btn-success" >  Ligar LED</script>

                                <%} else {%>
                                <script class="btn btn-danger" >  Desligar LED</script>
                                <%}%>
                            </button> </a>
                    </div>

                    <div class="panel-body col-md-3"> 
                        <a href="SensorSV?action=agua"
                           <button type="button" id="agua" >

                                <%

                                    String agua = (String) ses.getAttribute("agua");

                                    if (agua == "f") {

                                %>    

                                <script class="btn btn-success" >  Liberar ÁGUA</script>
                                <%} else {%>

                                <script class="btn btn-danger" >  Fechar
                                    ÁGUA</script>
                                <%}%>
                            </button> </a>
                    </div>
                    <div class="panel-body col-md-3"> </div>
                </div>

        <!-- Nome do produto/marca sem sidebar quando for o pre-painel  -->
    </div>        
</body>
</html>
