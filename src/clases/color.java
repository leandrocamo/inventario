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
public class color {

    int COLID;
    String COLNOMBRE;
//    int COLESTADO;

    public color(int COLID, String COLNOMBRE) {
        this.COLID = COLID;
        this.COLNOMBRE = COLNOMBRE;
//        this.COLESTADO = COLESTADO;
    }

    public int getCOLID() {
        return COLID;
    }

    public void setCOLID(int COLID) {
        this.COLID = COLID;
    }

    public String getCOLNOMBRE() {
        return COLNOMBRE;
    }

    public void setCOLNOMBRE(String COLNOMBRE) {
        this.COLNOMBRE = COLNOMBRE;
    }

//    public int getCOLESTADO() {
//        return COLESTADO;
//    }
//
//    public void setCOLESTADO(int COLESTADO) {
//        this.COLESTADO = COLESTADO;
//    }

    @Override
    public String toString() {
        return COLNOMBRE;
    }
}
