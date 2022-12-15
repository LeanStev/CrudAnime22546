/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package date;
import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;


public class ConexionBD {
   
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/animes?useSSL=false&useTimeZone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USR = "root";
    private static final String JDBC_PASS = "Admin";
    
    public static DataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USR);
        ds.setPassword(JDBC_PASS);
        
        ds.setInitialSize(20);
        return ds;
    }
    
    
    public static Connection getConexion() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Hubo un error"+ e);
        }
        return getDataSource().getConnection(); 
    }
    
    public static void close (ResultSet resultado) throws SQLException{
        resultado.close();
    }
    public static void close (Statement sentencia) throws SQLException{
        sentencia.close();
    }
    public static void close (Connection conexion) throws SQLException{
        conexion.close();
    } 

}
    