package A_Modelo;

import A_ClasesUtilizadas.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class UsuarioModel extends Conexion {

    private int USUID;
    private String USUNOMBREAPELLIDO;

    public int getUSUID() {
        return USUID;
    }

    public void setUSUID(int USUID) {
        this.USUID = USUID;
    }

    public String getUSUNOMBREAPELLIDO() {
        return USUNOMBREAPELLIDO;
    }

    public void setUSUNOMBREAPELLIDO(String USUNOMBREAPELLIDO) {
        this.USUNOMBREAPELLIDO = USUNOMBREAPELLIDO;
    }

    public String toString() {
        return this.USUNOMBREAPELLIDO;
    }

    public Vector<UsuarioModel> cargarUsuario(Integer UBIID) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        Vector<UsuarioModel> datos = new Vector<UsuarioModel>();
//        MueblesNuevoQuery modelo = null;
        UsuarioModel modelo;

        String sql = "SELECT * FROM usuxubi UXU \n"
                + "INNER JOIN usuario USU ON USU.USUID=UXU.USUID \n"
                + "WHERE UXU.UBIID = " + UBIID + " AND UXU.USUXUBIESTADO=1 \n"
                + "ORDER BY USU.USUAPELLIDOS ASC";
//        System.out.println(">"+sql);

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            modelo = new UsuarioModel();
            modelo.setUSUID(0);
            modelo.setUSUNOMBREAPELLIDO("Seleccione una opción...");
            datos.add(modelo);

            while (rs.next()) {
                modelo = new UsuarioModel();
                modelo.setUSUID(rs.getInt("UXU.USUXUBIID"));
                modelo.setUSUNOMBREAPELLIDO(rs.getString("USU.USUAPELLIDOS") + " " + rs.getString("USU.USUNOMBRES"));
                datos.add(modelo);
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - cargarRegistrosCombos()");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return datos;
    }

}
