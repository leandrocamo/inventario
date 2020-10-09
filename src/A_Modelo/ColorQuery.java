package A_Modelo;

import A_ClasesUtilizadas.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ColorQuery extends Conexion {

    public ArrayList<MarcaModel> listarColores() {

        ArrayList<MarcaModel> list = new ArrayList<MarcaModel>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM color WHERE COLESTADO = 1 ";
        int totalRegistros = totalRegistrosColores(sql);
//        System.out.println("" + sql);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int index = 1;

            while (rs.next()) {
                MarcaModel model = new MarcaModel();
                model.setNroRegistros(index++);
                model.setMARID(Integer.parseInt(rs.getString("COLID")));
                model.setMARNOMBRE(rs.getString("COLNOMBRE"));
                model.setMARDESCRIPCION(rs.getString("COLDESCRIPCION"));
                model.setTotalRegistros(totalRegistros);
                list.add(model);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - listarColores()");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return list;
    }

    public int totalRegistrosColores(String sql) {
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
                System.out.println("Conexión cerrada - totalRegistrosColores()");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return index;
    }

    public boolean guardarRegistro(MarcaModel modelo) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO color (COLNOMBRE, COLDESCRIPCION, COLESTADO) "
                + "VALUES (?, ?, ?);";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, modelo.getMARNOMBRE());
            ps.setString(2, modelo.getMARDESCRIPCION());
            ps.setBoolean(3, true);
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - guardarRegistro(COLOR).");
            } catch (SQLException e) {
                System.err.println(e);
                return false;
            }
        }
    }

    public void buscarRegistroID(MarcaModel model) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM color WHERE COLESTADO = 1 AND COLID=" + model.getMARID();
//        System.out.println("" + sql);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model.setMARDESCRIPCION(rs.getString("COLDESCRIPCION"));
                model.setMARNOMBRE(rs.getString("COLNOMBRE"));
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - buscarRegistroID(COLOR)");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean actualizarRegistro(MarcaModel model) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE color SET COLNOMBRE=?, COLDESCRIPCION=? WHERE COLID=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, model.getMARNOMBRE());
            ps.setString(2, model.getMARDESCRIPCION());
            ps.setInt(3, model.getMARID());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - actualizarRegistro(COLOR).");
            } catch (SQLException e) {
                System.err.println(e);
                return false;
            }
        }
    }

    public boolean eliminarRegistro(MarcaModel model) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "DELETE FROM color WHERE COLID=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, model.getMARID());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error:\nNo se puede eliminar debido a que puede estar relacionado con un mueble.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - eliminarRegistro(COLOR).");
            } catch (SQLException e) {
                System.err.println(e);
                return false;
            }
        }
    }
}
