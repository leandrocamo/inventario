package A_Modelo;

import A_ClasesUtilizadas.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class UbicacionModel extends Conexion {

    private int UBIID;
    private String UBINOMBRE;

    public int getUBIID() {
        return UBIID;
    }

    public void setUBIID(int UBIID) {
        this.UBIID = UBIID;
    }

    public String getUBINOMBRE() {
        return UBINOMBRE;
    }

    public void setUBINOMBRE(String UBINOMBRE) {
        this.UBINOMBRE = UBINOMBRE;
    }

    public String toString() {
        return this.UBINOMBRE;
    }

    public Vector<UbicacionModel> cargarUbicacion(Integer ADID) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        Vector<UbicacionModel> datos = new Vector<UbicacionModel>();
//        MueblesNuevoQuery modelo = null;
        UbicacionModel modelo;

        String sql = "SELECT *  FROM ubicacion WHERE ADID = " + ADID + " AND UBIESTADO = 1 ORDER BY UBINOMBRE ASC";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            modelo = new UbicacionModel();
            modelo.setUBIID(0);
            modelo.setUBINOMBRE("Seleccione una opción...");
            datos.add(modelo);

            while (rs.next()) {
                modelo = new UbicacionModel();
                modelo.setUBIID(rs.getInt("UBIID"));
                modelo.setUBINOMBRE(rs.getString("UBINOMBRE"));
                datos.add(modelo);
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - cargarUbicacion()");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return datos;
    }

}
