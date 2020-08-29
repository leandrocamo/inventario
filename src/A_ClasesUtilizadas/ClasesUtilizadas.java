package A_ClasesUtilizadas;

import Zclases.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class ClasesUtilizadas {

    public Date capturarFecha() {
        Date fechaActual = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String fecha = formatofecha.format(fechaActual);
        Date fechaHoy = null;
        try {
            fechaHoy = formatofecha.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(ClasesUtilizadas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fechaHoy;
    }

    public Date sumarRestarMeses(Date fecha, int meses) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.MONTH, meses);
        return calendar.getTime();
    }

    public Date convertirFecha(Date fechaEnviada) {
        long d = fechaEnviada.getTime();
        java.sql.Date fecha = new java.sql.Date(d);
        return fecha;
    }
    
    public Date convertirFechayHora(Date fechaEnviada) {
        if (fechaEnviada == null) {
            return null;
        } else {
            long d = fechaEnviada.getTime();
            java.sql.Timestamp fecha = new java.sql.Timestamp(d);
            return fecha;
        }

    }

    public boolean validarFechaVacia(Date fecha, String nombreFecha) {
        if (fecha == null) {
            JOptionPane.showMessageDialog(null, "Escoja una fecha de " + nombreFecha + ".", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    public boolean validarCorreo(String correo) {
        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        // El email a validar
//        String email = "info@programacionextrema.com";
        Matcher mather = pattern.matcher(correo);

        if (mather.find() == true) {
//            System.out.println("El email ingresado es válido.");
            return true;
        } else {
//            System.out.println("El email ingresado es inválido.");
            JOptionPane.showMessageDialog(null, "Ingrese un correo electrónico válido", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean validarCombo(int opcion, String cbxNombre) {
        //int opcion es getSelectIndex
        if (opcion == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una opción de " + cbxNombre + ".", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    public boolean validarCampoVacio(String textoEvaluar, String texto) {
        if (textoEvaluar.isEmpty()) {
            //El campo esta vacio,
            JOptionPane.showMessageDialog(null, "No deje campos vacios en "+texto+".", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            //El campo tiene texto
            return true;
        }
    }

}
