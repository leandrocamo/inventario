package Modelo;

import ClasesUtilizadas.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class AreaDependenciaModel extends Conexion {

    private int ADID;
    private String ADNOMBRE;

    public int getADID() {
        return ADID;
    }

    public void setADID(int ADID) {
        this.ADID = ADID;
    }

    public String getADNOMBRE() {
        return ADNOMBRE;
    }

    public void setADNOMBRE(String ADNOMBRE) {
        this.ADNOMBRE = ADNOMBRE;
    }

    public String toString() {
        return this.ADNOMBRE;
    }

    public Vector<AreaDependenciaModel> cargarAreaDependencia() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        Vector<AreaDependenciaModel> datos = new Vector<AreaDependenciaModel>();
//        MueblesNuevoQuery modelo = null;
        AreaDependenciaModel modelo;

        String sql = "SELECT * FROM areadependencia WHERE ADESTADO = 1 ORDER BY ADNOMBRE ASC";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            modelo = new AreaDependenciaModel();
            modelo.setADID(0);
            modelo.setADNOMBRE("Seleccione una opción...");
            datos.add(modelo);

            while (rs.next()) {
                modelo = new AreaDependenciaModel();
                modelo.setADID(rs.getInt("ADID"));
                modelo.setADNOMBRE(rs.getString("ADNOMBRE"));
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
