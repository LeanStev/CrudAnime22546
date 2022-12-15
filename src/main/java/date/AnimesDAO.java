
package date;

import static date.ConexionBD.close;
import static date.ConexionBD.getConexion;
import dominio.Anime;
import java.sql.*;
import java.util.*;

//en el DAO haremos la los respectivo metodos del CRUD (CREATE,READ,UPDATE,DELETE)
public class AnimesDAO {
    private static final String SQL_SELECT = "SELECT * FROM animelist";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM animelist WHERE IdAnime = ?";
    
    private static final String SQL_INSERT = "INSERT INTO animelist(Nombre,Autor,Capitulos,Finalizado) VALUES (?,?,?,?)";
    
    private static final String SQL_UPDATE = "UPDATE animelist SET Nombre=? ,Autor=? ,Capitulos=? ,Finalizado=? WHERE IdAnime=?";
    
    private static final String SQL_DELETE = "DELETE FROM animelist WHERE IdAnime=?";
    
    
    public List<Anime> mostrar(){
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado= null;
        Anime anime = null;
        List<Anime> animes = new ArrayList();
        
        try {
            conexion = getConexion();
            sentencia = conexion.prepareStatement(SQL_SELECT);
            resultado = sentencia.executeQuery();
            
            while(resultado.next()){
                int idanime = resultado.getInt("IdAnime");
                String nombre = resultado.getString("Nombre");
                String autor = resultado.getString("Autor");
                int capitulos = resultado.getInt("Capitulos");
                int finalizado = resultado.getInt("Finalizado");
                
                anime = new Anime (idanime,nombre,autor,capitulos,finalizado);
                
                animes.add(anime);
            }
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally{
            try {
                close(resultado);
                close(sentencia);
                close(conexion);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return animes;
    }
    
    public int insertar(Anime anime){
        Connection conexion = null;
        PreparedStatement sentencia = null;
        int registros = 0;
        try {
            conexion = getConexion();
            sentencia = conexion.prepareStatement(SQL_INSERT);
            sentencia.setString(1, anime.getNombre());
            sentencia.setString(2, anime.getAutor());
            sentencia.setInt(3, anime.getCapitulos());
            sentencia.setInt(4, anime.getFinalizado());
            registros = sentencia.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(sentencia);
                close(conexion);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
     
   public Anime seleccionarPorId(int id){
       Connection conexion = null;
       PreparedStatement sentencia = null;
       ResultSet resultado = null;
       Anime anime = null;
        
        try {
            conexion= getConexion();
            sentencia = conexion.prepareStatement(SQL_SELECT_BY_ID);
            sentencia.setInt(1, id);
            resultado = sentencia.executeQuery();
            
            while (resultado.next()){
            int idanime = resultado.getInt("IdAnime");
            String nombre = resultado.getString("Nombre");
            String autor = resultado.getString("Autor");
            int capitulos = resultado.getInt("Capitulos");
            int finalizado = resultado.getInt("Finalizado");
            
            anime = new Anime(idanime,nombre,autor,capitulos,finalizado);
            
            
        }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } 
        finally{
            try {
                 close(resultado);
                 close(sentencia);
                 close(conexion);
                
            } catch (SQLException e) {
                e.printStackTrace(System.out); 
            }  
        }
        return anime;
       
   }
   
   public int actualizar(Anime anime){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, anime.getNombre());
            stmt.setString(2, anime.getAutor());
            stmt.setInt(3, anime.getCapitulos());
            stmt.setInt(4, anime.getFinalizado());
            stmt.setInt(5, anime.getidanime());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
   
   
    public void eliminar(Anime anime) {
    Connection conn = null;
    PreparedStatement stmt = null;
    try {
        conn = getConexion();
        stmt = conn.prepareStatement(SQL_DELETE);
        stmt.setInt(1, anime.getidanime());
        stmt.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        try {
            close(stmt);
            close(conn);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}

}
