package Modelo;

import ClasesUtilizadas.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioUbicacionQuery extends Conexion {

    public ArrayList<UsuarioUbicacionModel> listarRegistros(String sql) {

        ArrayList<UsuarioUbicacionModel> list = new ArrayList<UsuarioUbicacionModel>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
//        System.out.println("listarUsuario: " + sql);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int index = 1;

            while (rs.next()) {
                UsuarioUbicacionModel model = new UsuarioUbicacionModel();

                model.setNroRegistros(index++);
                model.setId(Integer.parseInt("" + rs.getObject(1)));
                model.setUbicacion("" + rs.getObject(2));
//                model.setApellidos("" + rs.getObject(3));
//                model.setCorreoElectronico("" + rs.getObject(4));
//                model.setRol(Integer.parseInt("" + rs.getObject(5)));
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

    public boolean insertarRegistro(String sql) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        try {
            ps = con.prepareStatement(sql);
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
                System.out.println("Conexión cerrada - insertarRegistro().");
            } catch (SQLException e) {
                System.err.println(e);
                return false;
            }
        }
    }

    public void buscarRegistroID(UsuarioUbicacionModel model, String sql) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
//                model.setNombres("" + rs.getObject(1));
//                model.setApellidos("" + rs.getObject(2));
//                model.setCorreoElectronico("" + rs.getObject(3));
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

    public boolean actualizarRegistro(UsuarioUbicacionModel modelo, String sql) {
        PreparedStatement ps = null;
        Connection con = getConexion();
//        String sql = "UPDATE USUARIO SET USUNOMBRES=?, USUAPELLIDOS=?, USUEMAIL=? WHERE USUID=?";
        try {
            ps = con.prepareStatement(sql);
//            ps.setString(1, modelo.getNombres());
//            ps.setString(2, modelo.getApellidos());
//            ps.setString(3, modelo.getCorreoElectronico());
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

    public boolean eliminarRegistro(String sql) {
        PreparedStatement ps = null;
        Connection con = getConexion();
//        String sql = "DELETE FROM marca WHERE MARID=?";

        try {
            ps = con.prepareStatement(sql);
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error:\nNo se puede eliminar debido a que puede estar relacionado con un usuario o ubicación.", "Error", JOptionPane.ERROR_MESSAGE);
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
