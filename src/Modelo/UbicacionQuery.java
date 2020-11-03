package Modelo;

import ClasesUtilizadas.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UbicacionQuery extends Conexion {

    public ArrayList<UbicacionModel> listarUbicacion(String sql) {

        ArrayList<UbicacionModel> list = new ArrayList<UbicacionModel>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

//        String sql = textoBuscar;
//        int totalRegistros = 0;
//        if (textoBuscar == null) {
//            sql = "SELECT * FROM marca WHERE MARESTADO = 1 ";
//        } else {
//            sql = "SELECT * FROM marca WHERE MARESTADO = 1 "
//                    + "AND (MARNOMBRE LIKE '%" + textoBuscar + "%' OR MARDESCRIPCION LIKE '%" + textoBuscar + "%')";
//        }
//        int totalRegistros = totalRegistrosMarca(sql);
//        System.out.println("listarUbicacion: " + sql);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int index = 1;

            while (rs.next()) {
                UbicacionModel model = new UbicacionModel();

                model.setNroRegistros(index++);
                model.setId(Integer.parseInt("" + rs.getObject(1)));
                model.setUbicacion("" + rs.getObject(2));
                model.setAreadependencia("" + rs.getObject(3));
//                model.setTotalRegistros(totalRegistros);
                list.add(model);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - listarUbicacion()");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return list;
    }

    public int totalRegistros(String sql) {
        int index = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
//        String sql = "SELECT * FROM marca WHERE MARESTADO = 1 ";
//        System.out.println("totalRegistrosUbicacion " + sql);

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
                System.out.println("Conexión cerrada - totalRegistrosUbicacion(" + index + ")");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return index;
    }

    public boolean guardarRegistro(UbicacionModel modelo, String sql) {
        PreparedStatement ps = null;
        Connection con = getConexion();
//        String sql = "INSERT INTO marca (MARNOMBRE, MARDESCRIPCION, MARESTADO) "
//                + "VALUES (?, ?, ?);";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, modelo.getUbicacion());
            ps.setInt(2, modelo.getAreadependenciaID());
            ps.setBoolean(3, true);
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - guardarRegistro(" + modelo.getUbicacion() + ").");
            } catch (SQLException e) {
                System.err.println(e);
                return false;
            }
        }
    }

    public void buscarRegistroID(UbicacionModel model, String sql) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
//        System.out.println("MENSAJE001 " + sql);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model.setAreadependenciaID(Integer.parseInt("" + rs.getObject(2)));
                model.setUbicacion("" + rs.getObject(3));

            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - buscarRegistroID()");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean actualizarRegistro(UbicacionModel modelo, String sql) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        System.out.println("actualizarRegistro Ubicación: " + sql);
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, modelo.getUbicacion());
            ps.setInt(2, modelo.getAreadependenciaID());
            ps.setInt(3, modelo.getId());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - actualizarRegistro().");
            } catch (SQLException e) {
                System.err.println(e);
                return false;
            }
        }
    }

    public boolean eliminarRegistro(UbicacionModel model, String sql) {
        PreparedStatement ps = null;
        Connection con = getConexion();
//        String sql = "DELETE FROM marca WHERE MARID=?";

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
                System.out.println("Conexión cerrada - eliminarRegistro().");
            } catch (SQLException e) {
                System.err.println(e);
//                return false;
            }
        }
    }
}
