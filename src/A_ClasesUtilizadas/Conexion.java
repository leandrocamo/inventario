package A_ClasesUtilizadas;

import Zmodelo.*;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private final String base = "inventario1";
    private final String user = "root";
    private final String password = "";
    private final String server = "localhost:3306";
    private final String url = "jdbc:mysql://" + server + "/" + base;
    private Connection con = null;

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("Conexión exitosa");
        } catch (SQLException e) {
            System.err.println("Error 1 al conectar a la bdd. " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error 2 al conectar a la bdd. " + ex);
        }
        return con;
    }

//    public void LeerServidor(){
//         File archivo = null;
//         FileReader fr = null;
//         BufferedReader br = null;
//         
//         try {
//             // Apertura del fichero y creacion de BufferedReader para poder
//             // hacer una lectura comoda (disponer del metodo readLine()).
//             archivo = new File (url_server);
//             fr = new FileReader (archivo);
//             br = new BufferedReader(fr);
//
//         // Lectura del fichero
//             String linea;
//             while((linea=br.readLine())!=null){
//                 //System.out.println("Conectando a: "+linea+" ...");
//                 //linea=server;
//                 server=linea;
//             }
//         }
//         catch(Exception e){
//             e.printStackTrace();
//         }finally{
//         // En el finally cerramos el fichero, para asegurarnos
//         // que se cierra tanto si todo va bien como si salta 
//         // una excepcion.
//             try{                    
//                 if( null != fr ){   
//                     fr.close();     
//                 }                  
//             }catch (Exception e2){ 
//                 e2.printStackTrace();
//             }
//         }
//    }
}
