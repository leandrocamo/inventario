package Modelo;

import ClasesUtilizadas.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InicioSesionQuery extends Conexion {

    public boolean validasUsuario(InicioSesionModel modelo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM usuario "
                + "WHERE USUEMAIL = '" + modelo.getUsuEmail() + "' "
                + "AND USUCONTRASENIA = '" + modelo.getUsuContrsasenia() + "'";
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
