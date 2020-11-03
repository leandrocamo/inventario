package Modelo;

import ClasesUtilizadas.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MarcaQuery extends Conexion {

    public ArrayList<MarcaModel> listarMarcas(String textoBuscar) {

        ArrayList<MarcaModel> list = new ArrayList<MarcaModel>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String opcion = "Todo";

        String sql = "";
        int totalRegistros = 0;
        if (textoBuscar == null) {
            sql = "SELECT * FROM marca WHERE MARESTADO = 1 ";
        } else {
            sql = "SELECT * FROM marca WHERE MARESTADO = 1 "
                    + "AND (MARNOMBRE LIKE '%" + textoBuscar + "%' OR MARDESCRIPCION LIKE '%" + textoBuscar + "%')";
        }

//        int totalRegistros = totalRegistrosMarca(sql);
//        System.out.println("" + sql);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int index = 1;

            while (rs.next()) {
                MarcaModel model = new MarcaModel();

                model.setNroRegistros(index++);
                model.setMARID(Integer.parseInt(rs.getString("MARID")));
                model.setMARNOMBRE(rs.getString("MARNOMBRE"));
                model.setMARDESCRIPCION(rs.getString("MARDESCRIPCION"));
                model.setTotalRegistros(totalRegistros);
                list.add(model);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - listarMarcas()");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return list;
    }

    public int totalRegistros() {
        int index = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM marca WHERE MARESTADO = 1 ";
//        System.out.println("totalRegistrosMarca " + sql);

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
                System.out.println("Conexión cerrada - totalRegistrosMarca");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return index;
    }

    public boolean guardarRegistro(MarcaModel modelo) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO marca (MARNOMBRE, MARDESCRIPCION, MARESTADO) "
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
                System.out.println("Conexión cerrada - guardarRegistro(MARCA).");
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

        String sql = "SELECT * FROM marca WHERE MARESTADO = 1 AND MARID=" + model.getMARID();

//        System.out.println("" + sql);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model.setMARDESCRIPCION(rs.getString("MARDESCRIPCION"));
                model.setMARNOMBRE(rs.getString("MARNOMBRE"));
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - buscarRegistroID(MARCA)");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean actualizarRegistro(MarcaModel model) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE marca SET MARNOMBRE=?, MARDESCRIPCION=? WHERE MARID=?";

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
                System.out.println("Conexión cerrada - actualizarRegistro(MARCA).");
            } catch (SQLException e) {
                System.err.println(e);
                return false;
            }
        }
    }

    public boolean eliminarRegistro(MarcaModel model) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "DELETE FROM marca WHERE MARID=?";

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
                System.out.println("Conexión cerrada - eliminarRegistro(MARCA).");
            } catch (SQLException e) {
                System.err.println(e);
                return false;
            }
        }
    }
}
