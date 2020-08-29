package A_Modelo;

import A_ClasesUtilizadas.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MueblesPrincipalQuery extends Conexion {

    ArrayList<String> lista = new ArrayList<>();
    ArrayList<String> listaID = new ArrayList<>();

    public ArrayList<String> buscarCustodios() {

        lista.clear();
        listaID.clear();

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM usuario WHERE USUESTADO = 1 ORDER BY USUAPELLIDOS ASC";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("USUAPELLIDOS") + " " + rs.getString("USUNOMBRES"));
                listaID.add(rs.getString("USUID"));
            }
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
            return lista;
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - buscarCustodios()");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public ArrayList<String> buscarCustodiosID() {
        return listaID;
    }

    public ArrayList<String> buscarCuentasContables() {
        lista.clear();
        listaID.clear();

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM cuentacontable WHERE CCESTADO = 1 ORDER BY CCNOMBRE ASC";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("CCNOMBRE"));
                listaID.add(rs.getString("CCID"));
            }
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
            return lista;
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - buscarCuentasContables()");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public ArrayList<String> buscarCuentasContablesID() {
        return listaID;
    }

    public ArrayList<MueblesPrincipalModel> listarBuscarMueble(String textoBuscar, String ccID, String usuID) {
        ArrayList<MueblesPrincipalModel> list = new ArrayList<MueblesPrincipalModel>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String opcion = "Todo";

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
                + "WHERE MUE.MUEESTADO = 1 ";
//        JOptionPane.showMessageDialog(null, "Arreglar la consulta ya que vota el registro 28"
//                + "\ncomo estado 0 siendo lo correcto que mando todos los estados con 1. ", "Información", JOptionPane.INFORMATION_MESSAGE);

        if (textoBuscar != null && ccID == "NoAplica" && usuID == "NoAplica") {
            sql = sql + "AND MUE.MUEDESCRIPCION LIKE '%" + textoBuscar + "%' "
                    + "OR MUE.MUECODIGOETIQUETA LIKE '%" + textoBuscar + "%' "
                    + "OR MUE.MUESERIE = '%" + textoBuscar + "%' "
                    + "OR MAR.MARNOMBRE LIKE '%" + textoBuscar + "%'  ";
            opcion = "Buscar texto.";
        }
        if (textoBuscar == null && ccID.equals("Todos") && usuID.equals("Todos")) {
            opcion = "Buscar por Combos - Todos.";
        }
        if (textoBuscar == null && !ccID.equals("Todos") && usuID.equals("Todos")) {
            sql = sql + "AND CC.CCID = " + ccID + " \n";
            opcion = "Buscar Cuenta Contable:  " + ccID + " - Custodios: " + usuID;

        }
        if (textoBuscar == null && !ccID.equals("Todos") && !usuID.equals("Todos")) {
            sql = sql + "AND CC.CCID = " + ccID + " \n";
            sql = sql + "AND USU.USUID = " + usuID + " \n";
            opcion = "Buscar Cuenta Contable>>>>:  " + ccID + " - Custodios: " + usuID;
        }
        if (textoBuscar == null && ccID.equals("Todos") && !usuID.equals("Todos")) {
            sql = sql + "AND USU.USUID = " + usuID + " \n";
            opcion = "Buscar Cuenta Contable:  " + ccID + " - Custodios: " + usuID;
        }

        sql = sql + "ORDER BY MUE.MUEDESCRIPCION ASC";

//        System.out.println("" + sql);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int index = 1;

            while (rs.next()) {
                MueblesPrincipalModel model = new MueblesPrincipalModel();
                model.setNro(index++);
                model.setUsuId(Integer.parseInt(rs.getString("USU.USUID")));
                model.setUsuNombre(rs.getString("USU.USUNOMBRES"));
                model.setUsuApellido(rs.getString("USU.USUAPELLIDOS"));
                model.setCcNombre(rs.getString("CC.CCNOMBRE"));
                model.setMueCodigoEtiqueta(rs.getString("MUE.MUECODIGOETIQUETA"));
                model.setMueDescripcion(rs.getString("MUE.MUEDESCRIPCION"));
                model.setMueID(Integer.parseInt(rs.getString("MUE.MUEID")));
                model.setMueSerie(rs.getString("MUE.MUESERIE"));
                list.add(model);
            }
//            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - listarBuscarMueble() - " + opcion);
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return list;
    }
}
