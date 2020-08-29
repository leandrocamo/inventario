package Zmodelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Borrar_ConsultaPnlPrincipalMuebles extends Conexion {

    public void eliminarMueble(Borrar_PnlPrincipal pp) {
        Connection con = getConexion();
        String sql = "DELETE FROM mueble WHERE MUEID = ?;";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pp.getMueId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - eliminarMueble()");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public ArrayList<Borrar_PnlPrincipal> ListarMuebles() {
        ArrayList<Borrar_PnlPrincipal> list = new ArrayList<Borrar_PnlPrincipal>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM mueble MUE \n"
                + "INNER JOIN ubicacion UBI ON UBI.UBIID=MUE.UBIID \n"
                + "INNER JOIN areadependencia AXD ON AXD.ADID=UBI.ADID \n"
                + "INNER JOIN usuario USU ON USU.ADID=AXD.ADID\n"
                + "INNER JOIN color as COL ON COL.COLID = MUE.COLID \n"
                + "INNER JOIN cuentacontable as CC ON CC.CCID = MUE.CCID \n"
                + "INNER JOIN tipomueble as TM ON TM.TMID = MUE.TMID \n"
                + "INNER JOIN estado as EST ON EST.ESTID = MUE.ESTID \n"
                + "INNER JOIN marca as MAR ON MAR.MARID = MUE.MARID \n"
                + "WHERE MUE.MUEESTADO = 1 ORDER BY MUE.MUEDESCRIPCION ASC";
//        System.out.println("" + sql);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int index = 1;
            while (rs.next()) {
                Borrar_PnlPrincipal pp = new Borrar_PnlPrincipal();
                pp.setNro(index++);
                pp.setMueId(rs.getString("MUE.MUEID"));
                pp.setMueDescripcion(rs.getString("MUE.MUEDESCRIPCION"));
                pp.setMueCodigoEtiqueta(rs.getString("MUE.MUECODIGOETIQUETA"));
                pp.setMarNombre(rs.getString("MAR.MARNOMBRE"));
                pp.setMueSerie(rs.getString("MUE.MUESERIE"));
                list.add(pp);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - ListarMuebles()");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return list;
    }

    public ArrayList<Borrar_PnlPrincipal> BuscarMueble(String textoBuscar) {
        ArrayList<Borrar_PnlPrincipal> list = new ArrayList<Borrar_PnlPrincipal>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * "
                + "FROM mueble as MUE "
                + "INNER JOIN ubicacion UBI ON UBI.UBIID=MUE.UBIID \n"
                + "INNER JOIN areadependencia AXD ON AXD.ADID=UBI.ADID \n"
                + "INNER JOIN usuario USU ON USU.ADID=AXD.ADID\n"
                + "INNER JOIN color as COL ON COL.COLID = MUE.COLID \n"
                + "INNER JOIN cuentacontable as CC ON CC.CCID = MUE.CCID \n"
                + "INNER JOIN tipomueble as TM ON TM.TMID = MUE.TMID \n"
                + "INNER JOIN estado as EST ON EST.ESTID = MUE.ESTID \n"
                + "INNER JOIN marca as MAR ON MAR.MARID = MUE.MARID \n"
                + "WHERE MUE.MUEESTADO = 1 "
                + "AND MUE.MUEDESCRIPCION LIKE '%" + textoBuscar + "%' "
                + "OR MUE.MUECODIGOETIQUETA LIKE '%" + textoBuscar + "%' "
                + "OR MUE.MUESERIE = '%" + textoBuscar + "%' "
                + "OR MAR.MARNOMBRE LIKE '%" + textoBuscar + "%'  "
                + "ORDER BY MUE.MUEDESCRIPCION ASC";
//        System.out.println("" + sql);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int index = 1;
            while (rs.next()) {
                Borrar_PnlPrincipal pp = new Borrar_PnlPrincipal();
                pp.setNro(index++);
                pp.setMueId(rs.getString("MUE.MUEID"));
                pp.setMueDescripcion(rs.getString("MUE.MUEDESCRIPCION"));
                pp.setMueCodigoEtiqueta(rs.getString("MUE.MUECODIGOETIQUETA"));
                pp.setMarNombre(rs.getString("MAR.MARNOMBRE"));
                pp.setMueSerie(rs.getString("MUE.MUESERIE"));
                list.add(pp);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - ListarMuebles()");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return list;
    }
}