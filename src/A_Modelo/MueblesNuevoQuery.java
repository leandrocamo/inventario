package A_Modelo;

import A_ClasesUtilizadas.ClasesUtilizadas;
import A_ClasesUtilizadas.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Vector;
import javax.swing.JOptionPane;

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
        lista.add("Seleccione una opción...");
        listaID.add("Seleccione una opción...");
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
        String sql = "INSERT INTO mueble (CCID, TMID, ESTID, MARID, COLID, USUXUBIID, "
                + "MUECODIGOETIQUETA, MUEDESCRIPCION, MUESERIE, MUEFECHACOMPRA, "
                + "MUEFECHAFABRICACION, MUEFECHAEXPIRACION, MUEFD, MUEFO, MUEVALORNUEVO, "
                + "MUEVALORCOMERCIAL, MUEVALORREMANENTE, MUECANTIDAD, MUEVALORUNITARIO, "
                + "MUEVALORTOTAL, MUEESTADO) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, modelo.getCCID());
            ps.setInt(2, modelo.getTMID());
            ps.setInt(3, modelo.getESTID());
            ps.setInt(4, modelo.getMARID());
            ps.setInt(5, modelo.getCOLID());
            ps.setInt(6, modelo.getUSUXUBIID());
            ps.setString(7, modelo.getMUECODIGOETIQUETA());
            ps.setString(8, modelo.getMUEDESCRIPCION());
            ps.setString(9, modelo.getMUESERIE());
            ps.setDate(10, (Date) modelo.getMUEFECHACOMPRA());
            ps.setDate(11, (Date) modelo.getMUEFECHAFABRICACION());
            ps.setDate(12, (Date) modelo.getMUEFECHAEXPIRACION());
            ps.setString(13, modelo.getMUEFD());
            ps.setString(14, modelo.getMUEFO());
            ps.setDouble(15, modelo.getMUEVALORNUEVO());
            ps.setDouble(16, modelo.getMUEVALORCOMERCIAL());
            ps.setDouble(17, modelo.getMUEVALORREMANENTE());
            ps.setInt(18, modelo.getMUECANTIDAD());
            ps.setDouble(19, modelo.getMUEVALORUNITARIO());
            ps.setDouble(20, modelo.getMUEVALORCOMERCIAL());
            ps.setBoolean(21, true);
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
                return false;
            }
        }
    }

    public Vector<MueblesNuevoModel> cargarRegistrosCombos(String sql, String columna1, String columna2, String combo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        Vector<MueblesNuevoModel> datos = new Vector<MueblesNuevoModel>();
//        MueblesNuevoQuery modelo = null;
        MueblesNuevoModel modelo;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            modelo = new MueblesNuevoModel();
            modelo.setComboID(0);
            modelo.setComboTexto("Seleccione una opción...");
            datos.add(modelo);

            while (rs.next()) {
                modelo = new MueblesNuevoModel();
                modelo.setComboID(rs.getInt(columna1));
                modelo.setComboTexto(rs.getString(columna2));
                datos.add(modelo);
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - mostrarOpciones()-" + combo);
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return datos;
    }

    public Vector<MueblesNuevoModel> cargarRegistrosCombosCustodio(String sql, String columna1, String columna2, String combo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        Vector<MueblesNuevoModel> datos = new Vector<MueblesNuevoModel>();
        MueblesNuevoModel modelo = null;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            modelo = new MueblesNuevoModel();
            modelo.setComboID(0);
            modelo.setComboTexto("Seleccione una opción...");
            datos.add(modelo);

            while (rs.next()) {
                modelo = new MueblesNuevoModel();
                modelo.setComboID(rs.getInt(columna1));
                modelo.setComboTexto(rs.getString(columna2) + " " + rs.getString("USU.USUNOMBRES"));
                datos.add(modelo);
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - cargarRegistrosCombosCustodio()-" + combo);
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return datos;
    }

}
