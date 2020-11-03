package Modelo;

import ClasesUtilizadas.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class UsuarioUbicacionModel extends Conexion {

    public int id;
    public int ubicacionID;
    public String ubicacion;
//    public int usuarioID;
    public int nroRegistros;

    public int getNroRegistros() {
        return nroRegistros;
    }

    public void setNroRegistros(int nroRegistros) {
        this.nroRegistros = nroRegistros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUbicacionID() {
        return ubicacionID;
    }

    public void setUbicacionID(int ubicacionID) {
        this.ubicacionID = ubicacionID;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
