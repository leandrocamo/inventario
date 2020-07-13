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
public class tipomueble {
    int TMID;
    String TMNOMBRE;

    public tipomueble(int TMID, String TMNOMBRE) {
        this.TMID = TMID;
        this.TMNOMBRE = TMNOMBRE;
    }

    public int getTMID() {
        return TMID;
    }

    public void setTMID(int TMID) {
        this.TMID = TMID;
    }

    public String getTMNOMBRE() {
        return TMNOMBRE;
    }

    public void setTMNOMBRE(String TMNOMBRE) {
        this.TMNOMBRE = TMNOMBRE;
    }

    
    @Override
    public String toString() {
        return TMNOMBRE;
    }
    
}
