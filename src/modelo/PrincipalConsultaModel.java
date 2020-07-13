package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vista.Principal;

public class PrincipalConsultaModel extends Conexion {
//    public ArrayList<PrincipalModel> listarMueble() {
//        ArrayList listaMueble = new ArrayList();
//        PrincipalModel pm;
//
//        PreparedStatement ps = null;
//        ResultSet rs;
//        Connection con = getConexion();
//
//        String sql = "SELECT * "
//                + "FROM mueble as MUE "
//                + "INNER JOIN color as COL ON COL.COLID = MUE.COLID "
//                + "INNER JOIN cuentacontable as CC ON CC.CCID = MUE.CCID "
//                + "INNER JOIN tipomueble as TM ON TM.TMID = MUE.TMID "
//                + "INNER JOIN estado as EST ON EST.ESTID = MUE.ESTID "
//                + "INNER JOIN ubicacion as UBI ON UBI.UBIID = MUE.UBIID "
//                + "INNER JOIN marca as MAR ON MAR.MARID = MUE.MARID "
//                + "WHERE MUE.MUEESTADO = 1 "
//                + "ORDER BY MUE.MUEDESCRIPCION ASC";
//        try {
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                pm = new PrincipalModel();
//                pm.setCodigo(rs.getString("MUE.MUEID"));
//                pm.setDescripcion(rs.getString("MUE.MUEDESCRIPCION"));
//                pm.setCodigoEtiqueta(rs.getString("MUE.MUECODIGOETIQUETA"));
//                pm.setMarca(rs.getString("MAR.MARNOMBRE"));
//                pm.setSerie(rs.getString("MUE.MUESERIE"));
//                listaMueble.add(pm);
//            }
//
//        } catch (SQLException e) {
//            System.err.println(e);
//        } finally {
//            try {
//                con.close();
//                System.out.println("Conexión cerrada." + contador++);
//            } catch (SQLException e) {
//                System.err.println(e);
//            }
//        }
//        return listaMueble;
//    }
//    public boolean buscarMueble(PrincipalModel modelo) {
//
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        Connection con = getConexion();
//
//        String TextoBuscar = modelo.getBuscar();
//
//        String sql = "SELECT * "
//                + "FROM mueble as MUE "
//                + "INNER JOIN color as COL ON COL.COLID = MUE.COLID "
//                + "INNER JOIN cuentacontable as CC ON CC.CCID = MUE.CCID "
//                + "INNER JOIN tipomueble as TM ON TM.TMID = MUE.TMID "
//                + "INNER JOIN estado as EST ON EST.ESTID = MUE.ESTID "
//                + "INNER JOIN ubicacion as UBI ON UBI.UBIID = MUE.UBIID "
//                + "INNER JOIN marca as MAR ON MAR.MARID = MUE.MARID "
//                + "WHERE MUE.MUEESTADO = 1 "
//                + "AND MUE.MUEDESCRIPCION LIKE '%" + TextoBuscar + "%' "
//                + "OR MUE.MUECODIGOETIQUETA LIKE '%" + TextoBuscar + "%' "
//                + "OR MUE.MUESERIE = '%" + TextoBuscar + "%' "
//                + "OR MAR.MARNOMBRE LIKE '%" + TextoBuscar + "%'  "
//                + "ORDER BY MUE.MUEDESCRIPCION ASC";
//        try {
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                return true;
//            }
//            return false;
//        } catch (SQLException e) {
//            System.err.println(e);
//            return false;
//        } finally {
//            try {
//                con.close();
//                System.out.println("Conexión cerrada.");
//            } catch (SQLException e) {
//                System.err.println(e);
//            }
//        }
//    }
}
