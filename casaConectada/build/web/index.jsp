<%-- 
    Document   : index
    Created on : 24/02/2017, 21:15:44
    Author     : Gleisongjs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="ls-theme-blue" lang="pt-br">
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
        <link href="public/css/carousel.css" rel="stylesheet">

        <link href="public/stylesheets/locastyle.css" rel="stylesheet" type="text/css">
        <link rel="icon" sizes="192x192" href="images/labrador.png">
        <link rel="apple-touch-icon" href="public/img//labrador.png">
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
        <script type="text/javascript" src="public/js/bootstrap/bootstrap.min.js"></script>
        <script type="text/javascript">
            $('.carousel').carousel({
                interval: 100
            });
        </script>

        <main class="ls-main ">           
            <div class="container">
                <h1 class="ls-title-intro ls-ico-home">Página inicial</h1>






                <div class="col-md-12">
                    <ul class="list-group">
                        <li class="list-group-item">


                            <img data-u="image" src="public/img/sensor.JPG"  alt="sensor" class="img-responsive center-block"/>
                            <div class="caption">
                                <h2 class="ls-title-2">Funcionamento do Sistema </h2>
                                <p class="text-justify lead"> O sensor que está na parede, apontado para o solo, está constantemente medindo a distância. 
                                    Quando a distância é menor que 75 cm (normalmente quando a layla coloca as duas patas superiores na parede
                                    na direção do sensor), o sistema libera água durante 5 segundos, envia um twitter informando detalhes e permanece 
                                    indisponível para liberar água por proximidade nas próximas 04 horas.</p>
                            </div>

                        </li>

                        <li class="list-group-item">   

                            <img data-u="image" src="public/img/layla.JPG" alt="layla" class="img-responsive center-block"/> 
                            <div class="caption">
                                <h2 class="ls-title-2">Labrador retriever</h2>

                                <p class="text-justify lead" > A layla é uma cachorra da raça labrador retriever. Essa é uma raça canina 
                                    originária de Labrador no Canadá. Utilizado originalmente para a caça de aves aquáticas, 
                                    o labrador é conhecido como uma raça versátil, inteligente e dócil. </p>
                            </div>

                        </li>
                </div>
            </div>



            <section class="main-slider">
                <div id="myCarousel" class="carousel slide carousel-fade" data-ride="carousel">



                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#myCarousel" data-slide-to="1"></li>
                        <li data-target="#myCarousel" data-slide-to="2"></li>
                        <li data-target="#myCarousel" data-slide-to="3"></li>
                    </ol>


                    <!-- Carousel items -->
                    <div class="carousel-inner">

                        <!-- Slide 1 : Active -->
                        <div class="item active">
                            <center> <img src="public/img/layla.JPG" alt=""></center>
                            <div class="carousel-caption">

                                <h2 class="ls-title-2">Labrador retriever</h2>

                                <p class="text-justify lead" > A layla é uma cachorra da raça labrador retriever. Essa é uma raça canina 
                                    originária de Labrador no Canadá. Utilizado originalmente para a caça de aves aquáticas, 
                                    o labrador é conhecido como uma raça versátil, inteligente e dócil. </p>

                            </div><!-- /.carousel-caption -->
                        </div><!-- /Slide1 -->

                        <!-- Slide 2 -->
                        <div class="item ">
                            <img src="public/img/layla.JPG" alt="">
                            <div class="carousel-caption">
                                <h3>Slide 2</h3>
                                <p>Etiam porta sem malesuada magna mollis euismod.</p>
                            </div><!-- /.carousel-caption -->
                        </div><!-- /Slide2 -->

                        <!-- Slide 3 -->
                        <div class="item ">
                            <img src="public/img/sensor.JPG" alt="">
                            <div class="carousel-caption">
                                <h3>Slide 3</h3>
                                <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam.</p>
                            </div><!-- /.carousel-caption -->
                        </div><!-- /Slide3 -->

                        <!-- Slide 4 -->
                        <div class="item ">
                            <img src="https://cl.ly/image/1n0A2k0Z111n/banner_04.jpg" alt="">
                            <div class="carousel-caption">
                                <h3>Slide 4</h3>
                                <p>Pellentesque ornare sem lacinia quam venenatis vestibulum.</p>
                            </div><!-- /.carousel-caption -->
                        </div><!-- /Slide4 -->

                    </div><!-- /.carousel-inner -->


                    <!-- Controls -->
                    <div class="control-box">
                        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                            <span class="control-icon prev fa fa-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>

                        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                            <span class="control-icon next fa fa-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div><!-- /.control-box -->


                </div><!-- /#myCarousel -->
            </section><!-- /.main-slider -->







        </main>
        <!-- Nome do produto/marca sem sidebar quando for o pre-painel  -->

    </body>
</html>

