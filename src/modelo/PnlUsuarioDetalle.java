package modelo;

public class PnlUsuarioDetalle {

    public int getNro() {
        return Nro;
    }

    public void setNro(int Nro) {
        this.Nro = Nro;
    }

    public int getUsuId() {
        return usuId;
    }

    public void setUsuId(int usuId) {
        this.usuId = usuId;
    }

    public String getAdNombre() {
        return adNombre;
    }

    public void setAdNombre(String adNombre) {
        this.adNombre = adNombre;
    }

    public String getUsuUsuario() {
        return usuUsuario;
    }

    public void setUsuUsuario(String usuUsuario) {
        this.usuUsuario = usuUsuario;
    }

    public String getUsuCorreoElectronico() {
        return usuCorreoElectronico;
    }

    public void setUsuCorreoElectronico(String usuCorreoElectronico) {
        this.usuCorreoElectronico = usuCorreoElectronico;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    private int Nro;
    private int usuId;
    private String adNombre;
    private String usuUsuario;
    private String usuCorreoElectronico;
    private int role;

    public PnlUsuarioDetalle() {
    }

        
}
