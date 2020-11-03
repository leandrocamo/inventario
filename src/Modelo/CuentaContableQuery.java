package Modelo;

import ClasesUtilizadas.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CuentaContableQuery extends Conexion {

    private String marca = "CuentaContable";

    public ArrayList<CuentaContableModel> listarRegistros() {

        ArrayList<CuentaContableModel> list = new ArrayList<CuentaContableModel>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM cuentacontable WHERE CCESTADO = 1 ";
        int totalRegistros = totalRegistros(sql);
//        System.out.println("" + sql);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int index = 1;

            while (rs.next()) {
                CuentaContableModel model = new CuentaContableModel();
                model.setNroRegistros(index++);
                model.setId(Integer.parseInt(rs.getString("CCID")));
                model.setNombre(rs.getString("CCNOMBRE"));
                model.setDescripcion(rs.getString("CCDESCRIPCION"));
                model.setIdcuentacontable(rs.getString("CCCODIGOCUENTACONTABLE"));
                model.setTotalRegistros(totalRegistros);
                list.add(model);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - listarRegistros(" + marca + ")");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return list;
    }

    public int totalRegistros(String sql) {
        int index = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
//        System.out.println("totalRegistrosColores "+sql);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                index++;
            }

        } catch (SQLException e) {
            System.err.println(e);

        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - totalRegistros(" + marca + ")");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return index;
    }

    public boolean guardarRegistro(CuentaContableModel modelo) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO cuentacontable (CCNOMBRE, CCDESCRIPCION, CCCODIGOCUENTACONTABLE, CCESTADO) "
                + "VALUES (?, ?, ?, ?);";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, modelo.getNombre());
            ps.setString(2, modelo.getDescripcion());
            ps.setString(3, modelo.getIdcuentacontable());
            ps.setBoolean(4, true);
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - guardarRegistro(" + marca + ")");
            } catch (SQLException e) {
                System.err.println(e);
                return false;
            }
        }
    }

    public void buscarRegistroID(CuentaContableModel model) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM cuentacontable WHERE CCESTADO = 1 AND CCID=" + model.getId();
//        System.out.println("" + sql);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model.setDescripcion(rs.getString("CCDESCRIPCION"));
                model.setNombre(rs.getString("CCNOMBRE"));
                model.setIdcuentacontable(rs.getString("CCCODIGOCUENTACONTABLE"));
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - buscarRegistroID(" + marca + ")");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean actualizarRegistro(CuentaContableModel model) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE cuentacontable SET CCNOMBRE=?, CCDESCRIPCION=?, CCCODIGOCUENTACONTABLE=? WHERE CCID=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, model.getNombre());
            ps.setString(2, model.getDescripcion());
            ps.setString(3, model.getIdcuentacontable());
            ps.setInt(4, model.getId());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - actualizarRegistro(" + marca + ")");
            } catch (SQLException e) {
                System.err.println(e);
                return false;
            }
        }
    }

    public boolean eliminarRegistro(CuentaContableModel model) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "DELETE FROM cuentacontable WHERE CCID=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, model.getId());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error:\nNo se puede eliminar debido a que puede estar relacionado con un mueble.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - eliminarRegistro(" + marca + ")");
            } catch (SQLException e) {
                System.err.println(e);
                return false;
            }
        }
    }
}
