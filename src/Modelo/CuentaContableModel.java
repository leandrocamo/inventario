package Modelo;

public class CuentaContableModel {
    private int NroRegistros;
    private int id;
    private String nombre;
    private String descripcion;
    private String idcuentacontable;
    private boolean estado;
    private int totalRegistros;

    public int getNroRegistros() {
        return NroRegistros;
    }

    public void setNroRegistros(int NroRegistros) {
        this.NroRegistros = NroRegistros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdcuentacontable() {
        return idcuentacontable;
    }

    public void setIdcuentacontable(String idcuentacontable) {
        this.idcuentacontable = idcuentacontable;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getTotalRegistros() {
        return totalRegistros;
    }

    public void setTotalRegistros(int totalRegistros) {
        this.totalRegistros = totalRegistros;
    }
}
