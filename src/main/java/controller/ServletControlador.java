
package controller;

import date.AnimesDAO;
import dominio.Anime;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet ("/servletControlador") 
public class ServletControlador extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
         String accionJava = req.getParameter("accion");
        
        if(accionJava != null){
            switch (accionJava){
                case "editar":
                    editarAnime(req,res);
                    break;
                case "eliminar":
                    modificarAnime(req,res);
                    break;
                default:
                    accionDefault(req,res);
                    break;
            }
        }else{
            accionDefault(req,res);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse res) 
            throws ServletException, IOException{
        String accionJava = req.getParameter("accion");
        
        if(accionJava != null){
            switch (accionJava){
                case "insertar":
                    insertarAnime(req,res);
                    break;
                 case "modificar":
                    modificarAnime(req,res);
                    break;
                 
                default:
                    //eliminarAnime(req,res);
                    break;
            }
        }else{
            accionDefault(req,res);
        }
    }
    
    
    private Integer totalCap(List<Anime> animeList){
        Integer cantidad = 0;
        
        for (int i = 0; i < animeList.size(); i++) {
            cantidad += animeList.get(i).getCapitulos();
        }
        return cantidad;
    }
    
    private void accionDefault(HttpServletRequest req,HttpServletResponse res) 
            throws ServletException, IOException{
        List<Anime> animes = new AnimesDAO().mostrar();
        animes.forEach(System.out::println);
        
        HttpSession sesion = req.getSession();
        
        sesion.setAttribute("animes", animes);
        sesion.setAttribute("totalAnimes", animes.size());
        sesion.setAttribute("totalCap", totalCap(animes));
        res.sendRedirect("animes.jsp");
        
    }
    
    private void insertarAnime (HttpServletRequest req,HttpServletResponse res) 
            throws ServletException, IOException{
        String nombre = req.getParameter("nombre");
        String autor = req.getParameter("autor");
        int capitulos=0;
        int finalizado=0;
        String capitulosString = req.getParameter("capitulos");
        if(capitulosString != null && !capitulosString.equals("")){
             capitulos = Integer.parseInt(capitulosString);
        }
        //VALIDACIONES PARA EVITAR UNA EXCEPCION
        String finalizadoString = req.getParameter("finalizado");
        if(finalizadoString != null && !finalizadoString.equals("")){
             finalizado = Integer.parseInt(finalizadoString);
        }
        
        Anime anime = new Anime(nombre,autor,capitulos,finalizado);
        
        int regMod = new AnimesDAO().insertar(anime);
        
        System.out.println("Registros guardados: "+ regMod);
        
        accionDefault(req,res);
    }
    
    private void editarAnime (HttpServletRequest req,HttpServletResponse res) 
            throws ServletException, IOException {
        int idanime = Integer.parseInt(req.getParameter("idAnime"));
         System.out.println("-----------Recibido ID de anime: ------------" + idanime);
        Anime anime = new AnimesDAO().seleccionarPorId(idanime);
        System.out.println("Anime asignado a la solicitud: " + anime);

   

        req.setAttribute("anime", anime);
        String jspEditar = "/WEB-INF/paginas/operaciones/editarAnime.jsp";
        
        req.getRequestDispatcher(jspEditar).forward(req,res);
    }
    
    private void modificarAnime (HttpServletRequest req,HttpServletResponse res) 
        throws ServletException, IOException {
        int idanime = Integer.parseInt(req.getParameter("idAnime"));
        System.out.println("-----------Recibido ID de anime: ------------" + idanime);
        String nombre = req.getParameter("nombre");
        String autor = req.getParameter("autor");
        int capitulos=0;
        int finalizado=0;
//        int idanime = 0;
         //VALIDACIONES PAR  A EVITAR UNA EXCEPCION
//        String idanimeString = req.getParameter("idanime");
//        if (idanimeString != null && !idanimeString.equals("")) {
//          idanime = Integer.parseInt(idanimeString);
//        }
         //VALIDACIONES PAR  A EVITAR UNA EXCEPCION
        String capitulosString = req.getParameter("capitulos");
        if(capitulosString != null && !capitulosString.equals("")){
             capitulos = Integer.parseInt(capitulosString);
        }
        //VALIDACIONES PAR  A EVITAR UNA EXCEPCION
        String finalizadoString = req.getParameter("finalizado");
        if(finalizadoString != null && !finalizadoString.equals("")){
             finalizado = Integer.parseInt(finalizadoString);
        }
        
        Anime anime = new Anime(idanime,nombre,autor,capitulos,finalizado);
        
        int regMod = new AnimesDAO().actualizar(anime);
        
        System.out.println("Registros actualizados: "+ regMod);
        
        accionDefault(req,res);
    }
    


}





