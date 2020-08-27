package A_Modelo;

import Zmodelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class MueblesNuevoQuery extends Conexion {

    ArrayList<String> lista = new ArrayList<>();
    ArrayList<String> listaID = new ArrayList<>();

    public ArrayList<String> buscarRegistrosCombos(String sql, String columna1, String columna2, String combo) {

        lista.clear();
        listaID.clear();

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
//        String sql = "SELECT * FROM usuario WHERE USUESTADO = 1 ORDER BY USUAPELLIDO ASC";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString(columna1));
                listaID.add(rs.getString(columna2));
            }
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
            return lista;
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - buscarRegistrosCombos()-" + combo);
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public ArrayList<String> buscarRegistrosCombosID() {
        return listaID;
    }

    public boolean guardarMueble(MueblesNuevoModel modelo) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO mueble (CCID, TMID, ESTID, UBIID, MARID, COLID, "
                + "MUECODIGOETIQUETA, MUEDESCRIPCION, MUESERIE, MUEFECHACOMPRA, "
                + "MUEFECHAFABRICACION, MUEFECHAEXPIRACION, MUEFD, MUEFO, MUEVALORNUEVO, "
                + "MUEVALORCOMERCIAL, MUEVALORREMANENTE, MUECANTIDAD, MUEVALORUNITARIO, "
                + "MUEVALORTOTAL, MUEESTADO) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 1, ?, ?, ?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, modelo.getCCID());
            ps.setInt(2, modelo.getTMID());
            ps.setInt(3, modelo.getESTID());
            ps.setInt(4, modelo.getUBIID());
            ps.setInt(5, modelo.getMARID());
            ps.setInt(6, modelo.getCOLID());
            ps.setString(7, modelo.getMUECODIGOETIQUETA());
            ps.setString(8, modelo.getMUEDESCRIPCION());
            ps.setString(9, modelo.getMUESERIE());
            ps.setDate(10, (java.sql.Date) (Date) modelo.getMUEFECHACOMPRA());
            ps.setDate(11, (java.sql.Date) (Date) modelo.getMUEFECHAFABRICACION());
            ps.setDate(12, (java.sql.Date) (Date) modelo.getMUEFECHAEXPIRACION());
            ps.setString(13, modelo.getMUEFD());
            ps.setString(14, modelo.getMUEFO());
            ps.setDouble(15, modelo.getMUEVALORNUEVO());
            ps.setDouble(16, modelo.getMUEVALORCOMERCIAL());
            ps.setDouble(17, modelo.getMUEVALORREMANENTE());
            ps.setInt(18, modelo.getMUECANTIDAD());
            ps.setDouble(19, modelo.getMUEVALORUNITARIO());
            ps.setDouble(20, modelo.getMUEVALORUNITARIO());
            ps.setBoolean(12, true);
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - insertarActividad ().");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

}
