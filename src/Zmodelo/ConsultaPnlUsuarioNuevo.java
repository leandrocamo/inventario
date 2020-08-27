package Zmodelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConsultaPnlUsuarioNuevo extends Conexion {

    public boolean guardarUsuario(PnlUsuarioNuevoModel pun, boolean tipoGuardado) {
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
            ps.setString(4, pun.getUsuContrasenia());
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

    public boolean buscarUsuario(PnlUsuarioNuevoModel pun) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
//        String sql = "SELECT * FROM tramite WHERE TRANOMBRE LIKE '%"+pun.getTranombre()+"%'";
        String sql = "SELECT *  FROM usuario WHERE USUID = " + pun.getUsuId();
//        System.out.println(""+sql);

        try {
            ps = con.prepareStatement(sql);
//            ps.setString(1, tra.getTranombre());
            rs = ps.executeQuery();
            if (rs.next()) {
                pun.setUsuId(Integer.parseInt(rs.getString("USUID")));
                pun.setUsuUsuario(rs.getString("USUUSUARIO"));
                pun.setUsuEmail(rs.getString("USUEMAIL"));
                pun.setUsuContrasenia(rs.getString("USUCONTRASENIA"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - buscarUsuario().");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
