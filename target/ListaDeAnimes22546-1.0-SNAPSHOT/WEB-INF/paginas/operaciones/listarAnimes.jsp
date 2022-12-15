<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <fmt:setLocale value="es_ES"/><fmt:formatNumber value="${anime.autor}" type="currency"/> --%>
<section id="animesSection">   
    <div class="container">
        <div class="row row-table">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Lista de animes</h4>
                        
                    </div>
                    
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Autor</th>
                                <th>Capitulos</th>
                                <th>Finalizado</th>
                            </tr>
                        </thead>
                        
                        <tbody>
                           <c:forEach var="anime" items="${animes}" varStatus="status">
                               <tr>
                                   <td> ${status.count} </td>
                                   <td> ${anime.nombre} </td>
                                   <td> ${anime.autor} </td>
                                   <td> ${anime.capitulos} </td>
                                   <td> ${anime.finalizado} </td>
                                   
                                   <td>
                                       <a href="${pageContext.request.contextPath}/servletControlador?accion=editar&idAnime=${anime.idanime}" class="btn-secundary">
                                           <i class="fa-solid fa-pen-to-square"></i>
                                           Editar
                                       </a>
                                   </td>
                               </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-center text-white mb-3">
                    <div class="card-body">
                        <h3>Cantidad de Animes</h3>
                        <h4 class="display-4 "><i class="fa-solid fa-heart mx-2"></i>${totalAnimes}</h4>
                    </div>
                </div>
                
                <div class="card text-center text-white mb-3">
                    <div class="card-body">
                        <h3>Capitulos Totales</h3>
                        <h4 class="display-4 "><i class="fa-solid fa-plus mx-2"></i>${totalCap}</h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
   <jsp:include page="/WEB-INF/paginas/operaciones/agregarAnime.jsp"/>             
