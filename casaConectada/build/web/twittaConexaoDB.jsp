<%-- 
    Document   : twittaConexaoDB
    Created on : 07/12/2017, 15:18:44
    Author     : trnsformers
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Casa Conectada</title>
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
        <link rel="icon" sizes="192x192" href="images/labrador.png">
        <link rel="apple-touch-icon" href="public/img//labrador.png">
        <!-- Ele funciona da mesma com toda a versão do jQuery 1.x para 2.x -->
        <script src="public/js/jquery-1.9.1.min.js" type="text/javascript"></script>
        <script src="public/js/jquery.min.js" type="text/javascript"></script>
        <script src="public/js/bootstrap/bootstrap.min.js"></script>


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
     <!--   <div id="top" class="row">
    <div class="col-md-3">
        <h2>Itens</h2>
    </div>
 
    <div class="col-md-6">
        <div class="input-group h2">
            <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Itens">
            <span class="input-group-btn">
                <button class="btn btn-primary" type="submit">
                    <span class="glyphicon glyphicon-search"></span>
                </button>
            </span>
        </div>
    </div>
 
    <div class="col-md-3">
        <a href="add.html" class="btn btn-primary pull-right h2">Novo Item</a>
    </div>
</div>  /#top -->
        

        <!-- Modal Adicionar-->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h2 class="modal-title ls-ico-user-add" id="myModalLabel"> Adicionar Dispositivo</h2>
                    </div>
                    <div class="modal-body">  
                        <div class="container-fluid col-md-12">                                       
                            <!-- Begin # DIV Form -->
                            <div id="div-forms">

                                <!-- Begin # Login Form -->
                                <div class="container col-md-3">
                                </div>

                                <div class="container col-md-6">


                                    <form action="twittaConexaoDB?action=incluidispositivo" method="post"> 

                                        <input id="nome" class="form-control" type="text" name="nome" placeholder="Nome do dispositivo" required>
                                        <br/> 
                                        <input id="mac" class="form-control" type="text" name="mac" placeholder="MAC do dispositivo" required>
                                        <br/>

                                        <div class="container col-md-3">
                                        </div>
                                </div>
                            </div>

                        </div>
                        <!-- BOTÕES DE AÇÕES -->
                        <div class="form-group">
                            <div style="alignment-adjust: central" ><center>
                                    <span id="load"></span>
                                    <input type="submit" name="btnsubmit" class="btn btn-success" aria-label="Left Align">
                                    <input type="reset" name="btnreset" class="btn btn-danger" aria-label="Right Align">
                                </center>
                            </div>                                   
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- fim do modal-->

        <!-- Modal Editar-->
        <div class="modal fade" id="myModalEditar" tabindex="-1" role="dialog" aria-labelledby="myModalEditarLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h2 class="modal-title ls-ico-pencil2" id="myModalEditarLabel"> Editar Dispositivo</h2>
                    </div>
                    <div class="modal-body">  
                        <div class="panel-body">                            
                            <!-- Begin # DIV Form -->
                            <div id="div-forms">

                                <!-- Begin # Login Form -->
                                <form action="twittaConexaoDB?action=editadispositivo" method="post"> 
                                    <div class="form-group container-fluid col-md-12">
                                        <div class="container col-md-3"></div>
                                        <div class="container col-md-2">
                                            <input id="id" class="form-control" type="text" name="id" placeholder="ID" required> 
                                        </div>
                                        <div class="container col-md-2">
                                            <button type="button" class="btn btn-info btn-info ls-ico-search" >
                                                
                                                Buscar                                                
                                            </button>  
                                        </div>  
                                        <div class="container col-md-5"></div> 
                                    </div>
                                    <div class="form-group container-fluid col-md-12 ">                                                                
                                        <div class="container col-md-3"></div> 
                                        <div class="container col-md-9">
                                            <input id="nome" class="form-control" type="text" name="nome" placeholder="Nome do dispositivo" required>
                                            <br/> </div>
                                        <div class="container col-md-3"></div>
                                        <div class="container col-md-9">
                                            <input id="mac" class="form-control" type="text" name="mac" placeholder="MAC do dispositivo" required>
                                            <br/></div> 
                                    </div>
                            </div>
                        </div>


                        <!-- BOTÕES DE AÇÕES -->
                        <div class="form-group">
                            <div style="alignment-adjust: central" ><center>
                                    <span id="load"></span>
                                    <input type="submit" name="btnsubmit" class="btn btn-success" aria-label="Left Align">
                                    <input type="reset" name="btnreset" class="btn btn-danger" aria-label="Right Align">
                                </center>
                            </div>                                   
                        </div>
                        </form>
                    </div>
                </div> 
            </div>
        </div>
    </div>
    <!-- fim do modal-->

    <main class="ls-main ">
        <div class="container">
            <h1 class="ls-title-intro ls-ico-cloud">Banco de dados</h1>
            <div class="col-md-12">
                <div class="col-md-3">
                    <!--modal-->  
                    <button type="button" class="btn btn-primary btn-lg ls-ico-plus" data-toggle="modal" data-target="#myModal">
                        Novo Dispositivo
                    </button>                        
                </div>
                <div class="col-md-3">
                    <!--modal-->  
                    <button type="button" class="btn btn-primary btn-lg ls-ico-pencil" data-toggle="modal" data-target="#myModalEditar">
                        Editar Dispositivo
                    </button>
                </div>
                <div class="col-md-3"></div>
                <div class="col-md-3"></div>
            </div>
            <div class="col-md-12">                    
                <div class="panel panel-default">
                    <div class="panel-heading"><span class="glyphicon glyphicon-sort-by-attributes"></span> Lista</div>
                    <div class="panel-body">
                        <div class="form-group">

                            ${resultado}                
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <!-- Nome do produto/marca sem sidebar quando for o pre-painel  -->
</div>        
</body>
</html>
