package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultaPnlUsuarioDetalle extends Conexion {

    public ArrayList<PnlUsuarioDetalle> ListarBuscarUsuario(String textoBuscar) {
        ArrayList<PnlUsuarioDetalle> list = new ArrayList<PnlUsuarioDetalle>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = null;
        String opcion = null;
        if (textoBuscar == null) {
            sql = "SELECT * FROM usuario USU \n"
                    + "INNER JOIN areadependencia AXD ON AXD.ADID=USU.ADID \n"
                    + "WHERE USU.USUESTADO = 1 ORDER BY USU.USUUSUARIO ASC";
            opcion = "Todo";
        } else {
            sql = "SELECT * FROM usuario USU \n"
                    + "INNER JOIN areadependencia AXD ON AXD.ADID=USU.ADID \n"
                    + "WHERE USU.USUESTADO = 1 "
                    + "AND USU.USUUSUARIO LIKE '%" + textoBuscar + "%' "
                    + "OR USU.USUEMAIL LIKE '%" + textoBuscar + "%' "
                    + "OR AXD.ADNOMBRE LIKE '%" + textoBuscar + "%'  "
                    + "ORDER BY USU.USUUSUARIO ASC";
            opcion = "Buscar";
        }
//        System.out.println("" + sql);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int index = 1;
            while (rs.next()) {
                PnlUsuarioDetalle pud = new PnlUsuarioDetalle();
                pud.setNro(index++);
                pud.setUsuUsuario(rs.getString("USU.USUUSUARIO"));
                pud.setUsuCorreoElectronico(rs.getString("USU.USUEMAIL"));
                pud.setRole(Integer.parseInt(rs.getString("USU.ROLE")));
                pud.setAdNombre(rs.getString("AXD.ADNOMBRE"));
                list.add(pud);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - ListarBuscarUsuario() - " + opcion);
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return list;
    }

}
