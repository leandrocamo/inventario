package Modelo;

import ClasesUtilizadas.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioQuery extends Conexion {

    public ArrayList<UsuarioModel> listarUsuario(String sql) {

        ArrayList<UsuarioModel> list = new ArrayList<UsuarioModel>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
//        System.out.println("listarUsuario: " + sql);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int index = 1;

            while (rs.next()) {
                UsuarioModel model = new UsuarioModel();

                model.setNroRegistros(index++);
                model.setId(Integer.parseInt("" + rs.getObject(1)));
                model.setNombres("" + rs.getObject(2));
                model.setApellidos("" + rs.getObject(3));
                model.setCorreoElectronico("" + rs.getObject(4));
                model.setRol(Integer.parseInt("" + rs.getObject(5)));
                list.add(model);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - listarUsuario()");
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
//        System.out.println("totalRegistrosUsuario " + sql);

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
                System.out.println("Conexión cerrada - totalRegistrosUsuario(" + index + ")");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return index;
    }

    public boolean guardarRegistro(UsuarioModel modelo, String sql) {
        PreparedStatement ps = null;
        Connection con = getConexion();
//        String sql = "INSERT INTO USUARIO(USUNOMBRES, USUAPELLIDOS, USUEMAIL, USUCONTRASENIA, ROLE, USUESTADO) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, modelo.getNombres());
            ps.setString(2, modelo.getApellidos());
            ps.setString(3, modelo.getCorreoElectronico());
            ps.setString(4, "bosco2020");
            ps.setInt(5, 1);
            ps.setBoolean(6, true);
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - guardarRegistro(" + modelo.getCorreoElectronico() + ").");
            } catch (SQLException e) {
                System.err.println(e);
                return false;
            }
        }
    }

    public void buscarRegistroID(UsuarioModel model, String sql) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model.setNombres("" + rs.getObject(1));
                model.setApellidos("" + rs.getObject(2));
                model.setCorreoElectronico("" + rs.getObject(3));
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - buscarRegistroID(Usuario)");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean actualizarRegistro(UsuarioModel modelo, String sql) {
        PreparedStatement ps = null;
        Connection con = getConexion();
//        String sql = "UPDATE USUARIO SET USUNOMBRES=?, USUAPELLIDOS=?, USUEMAIL=? WHERE USUID=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, modelo.getNombres());
            ps.setString(2, modelo.getApellidos());
            ps.setString(3, modelo.getCorreoElectronico());
            ps.setInt(4, modelo.getId());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - actualizarRegistro(Usuario).");
            } catch (SQLException e) {
                System.err.println(e);
                return false;
            }
        }
    }

    public boolean eliminarRegistro(UsuarioModel model, String sql) {
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
