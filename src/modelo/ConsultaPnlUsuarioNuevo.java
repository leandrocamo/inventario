package modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConsultaPnlUsuarioNuevo extends Conexion {

    public boolean guardarUsuario(PnlUsuarioNuevo pun, boolean tipoGuardado) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = null;
        if (tipoGuardado) {
            //INSERT INTO `usuario` (`USUID`, `ADID`, `USUUSUARIO`, `USUEMAIL`, `USUCONTRASENIA`, `USUAUTHKEY`, `USUACCESOTOKEN`, `USUESTADO`, `ROLE`) 
//            VALUES (NULL, '3', 'Sanchez Moran Juan Carlos', 'juan.sanchez@gmail.com', 'Ecuador2020', '', '', '1', '1');
            sql = "INSERT INTO usuario (ADID, USUUSUARIO, USUEMAIL, USUCONTRASENIA, USUAUTHKEY, USUACCESOTOKEN, USUESTADO, ROLE) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        } else {
            sql = "Update";
        }
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pun.getAdId());
            ps.setString(2, pun.getUsuUsuario());
            ps.setString(3, pun.getUsuEmail());
            ps.setString(4, pun.getUsuUsuario());
            ps.setString(5, "");
            ps.setString(6, "");
            ps.setBoolean(7, true);
            ps.setInt(8, 1);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se guardó el registro.\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - guardarUsuario().");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
