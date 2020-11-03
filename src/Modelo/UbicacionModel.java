package Modelo;

public class UbicacionModel {

    private int NroRegistros;
    private int id;
    private String ubicacion;
    private String areadependencia;
    private int areadependenciaID;
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getAreadependencia() {
        return areadependencia;
    }

    public void setAreadependencia(String areadependencia) {
        this.areadependencia = areadependencia;
    }

    public int getAreadependenciaID() {
        return areadependenciaID;
    }

    public void setAreadependenciaID(int areadependenciaID) {
        this.areadependenciaID = areadependenciaID;
    }

    public int getTotalRegistros() {
        return totalRegistros;
    }

    public void setTotalRegistros(int totalRegistros) {
        this.totalRegistros = totalRegistros;
    }

}
