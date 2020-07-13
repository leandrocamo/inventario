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
public class marca {

    int MARID;
    String MARNOMBRE;
//    int MARESTADO;

    public marca(int MARID, String MARNOMBRE) {
        this.MARID = MARID;
        this.MARNOMBRE = MARNOMBRE;
//        this.MARESTADO = MARESTADO;
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

    @Override
    public String toString() {
        return MARNOMBRE;
    }
}
