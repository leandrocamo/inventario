package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaInicio extends Conexion {

    public boolean buscarUsuario(Inicio modeloInicio) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM usuario "
                + "WHERE USUEMAIL = '" + modeloInicio.getUsuario() + "' "
                + "AND USUCONTRASENIA = '" + modeloInicio.getContrasenia() + "'";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - buscarUsuario()");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

}
