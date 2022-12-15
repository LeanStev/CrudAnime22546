<div class="modal fade" id="agregarAnimeModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content bg-info">
            <div class="modal-header text-white">
                <h5 class="modal-title">Añadir anime</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <!-- cuando envio un formulario desde el frontend al servidor tengo que decirle que tipo de metodo voy a usar, en este caso tipo POST -->
            <!-- el action hace referencia a la misma aplicacion -->
            <form action="${pageContext.request.contextPath}/servletControlador?accion=insertar&idAnime=${anime.idanime}" method="POST" class="was-validated" >
                
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required/>
                    </div>
                    <div class="form-group">
                        <label for="autor">Autor</label>
                        <input type="text" class="form-control" name="autor" required/>
                    </div>
                    <div class="form-group">
                        <label for="capitulos">Capitulos</label>
                        <input type="number" class="form-control" name="capitulos" required/>
                    </div>
                    <div class="form-group">
                        <label for="finalizado">Finalizado</label>
                        <input type="number" class="form-control" name="finalizado" required/>
                    </div>
                </div>
             
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">
                        Guardar
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>

<style>
    .modal-content{
        background:radial-gradient(circle, rgba(238,174,202,1) 0%, rgba(148,187,233,1) 100%);
    }
    .modal-header{
        color: #000!important;
    }
    .form-control{
        background-color: #ffffff00;

    }

</style>