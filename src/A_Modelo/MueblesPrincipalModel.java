package A_Modelo;

public class MueblesPrincipalModel {

    private int ccId;
    private String ccNombre;
    private int usuId;
    private String usuNombre, usuApellido;
    private int Nro;
    private int mueID;
    private String mueCodigoEtiqueta;
    private String mueDescripcion;
    private String mueSerie;

    public int getNro() {
        return Nro;
    }

    public void setNro(int Nro) {
        this.Nro = Nro;
    }

    public int getMueID() {
        return mueID;
    }

    public void setMueID(int mueID) {
        this.mueID = mueID;
    }

    public String getMueCodigoEtiqueta() {
        return mueCodigoEtiqueta;
    }

    public void setMueCodigoEtiqueta(String mueCodigoEtiqueta) {
        this.mueCodigoEtiqueta = mueCodigoEtiqueta;
    }

    public String getMueDescripcion() {
        return mueDescripcion;
    }

    public void setMueDescripcion(String mueDescripcion) {
        this.mueDescripcion = mueDescripcion;
    }

    public String getMueSerie() {
        return mueSerie;
    }

    public void setMueSerie(String mueSerie) {
        this.mueSerie = mueSerie;
    }

    public int getCcId() {
        return ccId;
    }

    public void setCcId(int ccId) {
        this.ccId = ccId;
    }

    public String getCcNombre() {
        return ccNombre;
    }

    public void setCcNombre(String ccNombre) {
        this.ccNombre = ccNombre;
    }

    public int getUsuId() {
        return usuId;
    }

    public void setUsuId(int usuId) {
        this.usuId = usuId;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuApellido() {
        return usuApellido;
    }

    public void setUsuApellido(String usuApellido) {
        this.usuApellido = usuApellido;
    }
}
