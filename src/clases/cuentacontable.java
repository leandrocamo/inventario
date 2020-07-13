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
public class cuentacontable {

    int CCID;
    String CCNOMBRE;

    @Override
    public String toString() {
        return CCNOMBRE;
    }

    public int getCCID() {
        return CCID;
    }

    public void setCCID(int CCID) {
        this.CCID = CCID;
    }

    public String getCCNOMBRE() {
        return CCNOMBRE;
    }

    public void setCCNOMBRE(String CCNOMBRE) {
        this.CCNOMBRE = CCNOMBRE;
    }

    public cuentacontable(int CCID, String CCNOMBRE) {
        this.CCID = CCID;
        this.CCNOMBRE = CCNOMBRE;
    }

}
