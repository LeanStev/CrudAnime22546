<%@page import="dominio.Anime"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" >
        <script src="https://kit.fontawesome.com/f369b813cd.js" crossorigin="anonymous"></script>
        <title>Editar anime</title>

    </head> 
    <body>
        <!--        <img class="imgGif" src="https://image.myanimelist.net/ui/5LYzTBVoS196gvYvw3zjwHQ23nYQP3Xdqds56ChX-RQ">
                <div class="icon-anime">
                    <img class="anime1" src="https://static.tumblr.com/f57163fe954296a2a4d17e506e971ce5/fzar6mu/ypFpbt805/tumblr_static_6s4li12sjig408k88sww0cww0.gif" alt="gif-anime"/>
                </div>-->

        <jsp:include page="../comunes/cabecera.jsp"/>
        <form action="${pageContext.request.contextPath}/servletControlador?accion=modificar&idAnime=${anime.idanime}" method="POST" class="was-validated" >
            <jsp:include page="../comunes/botonesNavegacionEditar.jsp"/>
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar anime</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="nombre">Nombre</label>
                                        <input type="text" class="form-control" name="nombre" required value="${anime.nombre}"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="autor">Autor</label>
                                        <input type="text" class="form-control" name="autor" required value="${anime.autor}"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="capitulos">Capitulos</label>
                                        <input type="number" class="form-control" name="capitulos" required value="${anime.capitulos}"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="finalizado">Finalizado</label>
                                        <input type="number" class="form-control" name="finalizado" required value="${anime.finalizado}"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>

        <jsp:include page="../comunes/pieDePagina.jsp"/>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

        
        
    </body>

    
    <style>
        body{
            font-weight:bold ;
            width: 100vw;
            height: 100vw;
            background: rgb(238,174,202);
            background: radial-gradient(circle, rgba(238,174,202,1) 0%, rgba(148,187,233,1) 100%);
            overflow-x:hidden; 
            overflow-y:hidden;
        }
        .card{
            background-color: #ffffff00!important;
            color: white;
        }
        input{
            background-color: transparent!important;
            color: white!important;
        }
    </style>
</html>