<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" >
        <script src="https://kit.fontawesome.com/f369b813cd.js" crossorigin="anonymous"></script>
        <title>Control de anime</title>

    </head>
    <body>
        <img class="imgGif" src="https://image.myanimelist.net/ui/5LYzTBVoS196gvYvw3zjwHQ23nYQP3Xdqds56ChX-RQ"/>
        <div class="icon-anime">
            <img class="anime1" src="https://static.tumblr.com/f57163fe954296a2a4d17e506e971ce5/fzar6mu/ypFpbt805/tumblr_static_6s4li12sjig408k88sww0cww0.gif" alt="gif-anime"/>
        </div>
        
        <jsp:include page="WEB-INF/paginas/comunes/cabecera.jsp"/>
        <jsp:include page="WEB-INF/paginas/comunes/botonesNavegacion.jsp"/>

        <jsp:include page="WEB-INF/paginas/operaciones/listarAnimes.jsp"/>

        <jsp:include page="WEB-INF/paginas/comunes/pieDePagina.jsp"/>
        
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

    </body>

    <style>

       body{
    font-weight:bold ;
    width: 100vw;
    height: auto;
    background: rgb(238,174,202);
    background: radial-gradient(circle, rgba(238,174,202,1) 0%, rgba(148,187,233,1) 100%);
    overflow-x:hidden;
    
}

.row-table,.row-header{
    display: flex;
    justify-content: center;
}
.header-icon{
    padding-top: 10px;
    height: 100px;
}
.fa-cat{
    margin-right: 20px;
}
.icon-anime{
    position: fixed;
    height: 100%;
    width: auto;
}
.anime1{
    left: 1400px;
    position: absolute;
}
.imgGif {
    position: fixed;
    width: 300px;
    height: 300px;
    bottom: 0;
}

.card,.card-head{
    background-color: transparent;
    color: white;
}
tr,th,td{
    color: white!important;
}
.btn-secundary{
    color: rgb(255, 0, 0);
    text-decoration: none;
    font-weight: normal;

}
.btn-secundary:hover{
    color:rgb(200, 0, 0);;
}
    </style>
</html>
