package Modelo;

public class MarcaModel {

    private int NroRegistros;
    private int MARID;
    private String MARNOMBRE;
    private String MARDESCRIPCION;
    private boolean MARESTADO;
    private String textoBuscar;
    private int totalRegistros;

    public int getTotalRegistros() {
        return totalRegistros;
    }

    public void setTotalRegistros(int totalRegistros) {
        this.totalRegistros = totalRegistros;
    }

    public int getNroRegistros() {
        return NroRegistros;
    }

    public void setNroRegistros(int NroRegistros) {
        this.NroRegistros = NroRegistros;
    }

    public int getMARID() {
        return MARID;
    }

    public void setMARID(int MARID) {
        this.MARID = MARID;
    }

    public String getMARNOMBRE() {
        return MARNOMBRE;
    }

    public void setMARNOMBRE(String MARNOMBRE) {
        this.MARNOMBRE = MARNOMBRE;
    }

    public String getMARDESCRIPCION() {
        return MARDESCRIPCION;
    }

    public void setMARDESCRIPCION(String MARDESCRIPCION) {
        this.MARDESCRIPCION = MARDESCRIPCION;
    }

    public boolean isMARESTADO() {
        return MARESTADO;
    }

    public void setMARESTADO(boolean MARESTADO) {
        this.MARESTADO = MARESTADO;
    }

    public String getTextoBuscar() {
        return textoBuscar;
    }

    public void setTextoBuscar(String textoBuscar) {
        this.textoBuscar = textoBuscar;
    }

}
