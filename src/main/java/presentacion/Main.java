
package presentacion;

import date.AnimesDAO;
import dominio.Anime;
import java.util.*;


public class Main {
    
    /*
    public static void main(String[] args) {
         AnimesDAO animeDAO = new AnimesDAO();
         List<Anime> animes = animeDAO.mostrar();
         
         for(Anime  animeForEach:animes){
             System.out.println(animeForEach + "\n");
         }
    }*/
    //Mostrar base de datos.
    public static void main(String[] args) {
         AnimesDAO animeDAO = new AnimesDAO();
         List<Anime> animes = animeDAO.mostrar();
         
         for(Anime animeForEach:animes){
             System.out.println(animeForEach + "\n");
         }
    }
}
