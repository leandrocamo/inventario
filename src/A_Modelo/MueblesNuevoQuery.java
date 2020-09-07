package A_Modelo;

import A_ClasesUtilizadas.ClasesUtilizadas;
import A_ClasesUtilizadas.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
                System.out.println("Conexión cerrada - guardarMueble().");
            } catch (SQLException e) {
                System.err.println(e);
                return false;
            }
        }
    }

    public boolean actualizarMueble(MueblesNuevoModel modelo) {
        PreparedStatement ps = null;
        Connection con = getConexion();
//        String sql = "UPDATE tramite SET TRANOMBRE=?, TRAESTADO=? WHERE TRAID=?";
        String sql = "UPDATE mueble SET CCID=?, TMID=?, ESTID=?, MARID=?, COLID=?, USUXUBIID=?, "
                + "MUECODIGOETIQUETA=?, MUEDESCRIPCION=?, MUESERIE=?, MUEFECHACOMPRA=?, "
                + "MUEFECHAFABRICACION=?, MUEFECHAEXPIRACION=?, MUEFD=?, MUEFO=?, MUEVALORNUEVO=?, "
                + "MUEVALORCOMERCIAL=?, MUEVALORREMANENTE=?, MUECANTIDAD=?, MUEVALORUNITARIO=?, "
                + "MUEVALORTOTAL=?, MUEESTADO=? "
                + "WHERE MUEID=?";

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
            ps.setInt(22, modelo.getMUEID());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - actualizarMueble().");
            } catch (SQLException e) {
                System.err.println(e);
                return false;
            }
        }
    }

    public boolean eliminarMueble(MueblesNuevoModel modelo) {
        PreparedStatement ps = null;
        Connection con = getConexion();
//      String sql = "DELETE FROM tramite WHERE TRAID=?";
        String sql = "DELETE FROM mueble WHERE MUEID=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, modelo.getMUEID());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - eliminarMueble().");
            } catch (SQLException e) {
                System.err.println(e);
                return false;
            }
        }
    }

//    public Vector<MueblesNuevoModel> cargarRegistrosCombos(String sql, String columna1, String columna2, String combo) {
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        Connection con = getConexion();
//
//        Vector<MueblesNuevoModel> datos = new Vector<MueblesNuevoModel>();
////        MueblesNuevoQuery modelo = null;
//        MueblesNuevoModel modelo;
//
//        try {
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//
//            modelo = new MueblesNuevoModel();
//            modelo.setComboID(0);
//            modelo.setComboTexto("Seleccione una opción...");
//            datos.add(modelo);
//
//            while (rs.next()) {
//                modelo = new MueblesNuevoModel();
//                modelo.setComboID(rs.getInt(columna1));
//                modelo.setComboTexto(rs.getString(columna2));
//                datos.add(modelo);
//            }
//
//        } catch (SQLException e) {
//            System.err.println(e);
//        } finally {
//            try {
//                con.close();
//                System.out.println("Conexión cerrada - mostrarOpciones()-" + combo);
//            } catch (SQLException e) {
//                System.err.println(e);
//            }
//        }
//        return datos;
//    }
//    public Vector<MueblesNuevoModel> cargarRegistrosCombosCustodio(String sql, String columna1, String columna2, String combo) {
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        Connection con = getConexion();
//
//        Vector<MueblesNuevoModel> datos = new Vector<MueblesNuevoModel>();
//        MueblesNuevoModel modelo = null;
//
//        try {
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//
//            modelo = new MueblesNuevoModel();
//            modelo.setComboID(0);
//            modelo.setComboTexto("Seleccione una opción...");
//            datos.add(modelo);
//
//            while (rs.next()) {
//                modelo = new MueblesNuevoModel();
//                modelo.setComboID(rs.getInt(columna1));
//                modelo.setComboTexto(rs.getString(columna2) + " " + rs.getString("USU.USUNOMBRES"));
//                datos.add(modelo);
//            }
//
//        } catch (SQLException e) {
//            System.err.println(e);
//        } finally {
//            try {
//                con.close();
//                System.out.println("Conexión cerrada - cargarRegistrosCombosCustodio()-" + combo);
//            } catch (SQLException e) {
//                System.err.println(e);
//            }
//        }
//        return datos;
//    }
    public void listarMuebleID(MueblesNuevoModel modelo) throws ParseException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM mueble MUE "
                + "INNER JOIN usuxubi UXU ON UXU.USUXUBIID=MUE.USUXUBIID \n"
                + "INNER JOIN usuario USU ON UXU.USUID=USU.USUID \n"
                + "INNER JOIN ubicacion UBI ON UXU.UBIID=UBI.UBIID \n"
                + "INNER JOIN areadependencia AXD ON AXD.ADID=UBI.ADID \n"
                + "INNER JOIN color as COL ON COL.COLID = MUE.COLID \n"
                + "INNER JOIN cuentacontable as CC ON CC.CCID = MUE.CCID \n"
                + "INNER JOIN tipomueble as TM ON TM.TMID = MUE.TMID \n"
                + "INNER JOIN estado as EST ON EST.ESTID = MUE.ESTID \n"
                + "INNER JOIN marca as MAR ON MAR.MARID = MUE.MARID \n"
                + "WHERE MUE.MUEESTADO = 1 AND MUE.MUEID = " + modelo.getMUEID();

//        System.out.println("" + sql);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            SimpleDateFormat fechaSQL = new SimpleDateFormat("yyyy-MM-dd");

            while (rs.next()) {
                modelo.setCCID(Integer.parseInt(rs.getString("CC.CCID")));
                modelo.setTMID(Integer.parseInt(rs.getString("TM.TMID")));
                modelo.setESTID(Integer.parseInt(rs.getString("EST.ESTID")));
                modelo.setMARID(Integer.parseInt(rs.getString("MAR.MARID")));
                modelo.setCOLID(Integer.parseInt(rs.getString("COL.COLID")));
                modelo.setADID(Integer.parseInt(rs.getString("AXD.ADID")));
                modelo.setUBIID(Integer.parseInt(rs.getString("UXU.UBIID")));
                modelo.setUSUXUBIID(Integer.parseInt(rs.getString("UXU.USUID")));
                modelo.setMUECODIGOETIQUETA(rs.getString("MUE.MUECODIGOETIQUETA"));
                modelo.setMUEDESCRIPCION(rs.getString("MUE.MUEDESCRIPCION"));
                modelo.setMUESERIE(rs.getString("MUE.MUESERIE"));
                modelo.setMUEFECHACOMPRA(fechaSQL.parse(rs.getString("MUE.MUEFECHACOMPRA")));
                modelo.setMUEFECHAEXPIRACION(fechaSQL.parse(rs.getString("MUE.MUEFECHAEXPIRACION")));
                modelo.setMUEFECHAFABRICACION(fechaSQL.parse(rs.getString("MUE.MUEFECHAFABRICACION")));
                modelo.setMUEFD(rs.getString("MUE.MUEFD"));
                modelo.setMUEFO(rs.getString("MUE.MUEFO"));
                modelo.setMUEVALORCOMERCIAL(Double.parseDouble(rs.getString("MUE.MUEVALORCOMERCIAL")));
                modelo.setMUEVALORNUEVO(Double.parseDouble(rs.getString("MUE.MUEVALORNUEVO")));
                modelo.setMUEVALORREMANENTE(Double.parseDouble(rs.getString("MUE.MUEVALORREMANENTE")));
                modelo.setMUEVALORTOTAL(Double.parseDouble(rs.getString("MUE.MUEVALORTOTAL")));
                modelo.setMUEVALORUNITARIO(Double.parseDouble(rs.getString("MUE.MUEVALORUNITARIO")));
                modelo.setMUECANTIDAD(Integer.parseInt(rs.getString("MUE.MUECANTIDAD")));
            }
//            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - listarMuebleID()");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
