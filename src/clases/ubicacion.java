/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author camo
 */
public class ubicacion {

    int UBIID;
    String UBINOMBRE;

    @Override
    public String toString() {
        return UBINOMBRE;
    }

    public ubicacion(int UBIID, String UBINOMBRE) {
        this.UBIID = UBIID;
        this.UBINOMBRE = UBINOMBRE;
    }

    public int getUBIID() {
        return UBIID;
    }

    public void setUBIID(int UBIID) {
        this.UBIID = UBIID;
    }

    public String getUBINOMBRE() {
        return UBINOMBRE;
    }

    public void setUBINOMBRE(String UBINOMBRE) {
        this.UBINOMBRE = UBINOMBRE;
    }

}
