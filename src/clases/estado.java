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
public class estado {

    int ESTID;
    String ESTNOMBRE;

    @Override
    public String toString() {
        return ESTNOMBRE;
    }

    public estado(int ESTID, String ESTNOMBRE) {
        this.ESTID = ESTID;
        this.ESTNOMBRE = ESTNOMBRE;
    }

    public int getESTID() {
        return ESTID;
    }

    public void setESTID(int ESTID) {
        this.ESTID = ESTID;
    }

    public String getESTNOMBRE() {
        return ESTNOMBRE;
    }

    public void setESTNOMBRE(String ESTNOMBRE) {
        this.ESTNOMBRE = ESTNOMBRE;
    }
    

}
