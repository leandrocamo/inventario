package clases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class ClasesUtilizadas {

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

        if (opcion == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una opción de " + cbxNombre + "."  + opcion, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

}
