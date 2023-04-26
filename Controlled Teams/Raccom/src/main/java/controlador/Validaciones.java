package controlador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {

    public static boolean validadorStrings(String cadena) {
        boolean resultado=false;
        Pattern p = Pattern.compile("[a-zA-ZñÑáéíóúÁÉÍÓÚ ]{3,20}");
        Matcher validar= p.matcher(cadena);
        if(validar.matches()){
            resultado=true;
        }
        return resultado;

    }

    public static boolean validadorCodUnico(String cadena) {
        boolean resultado=false;
        Pattern p = Pattern.compile("[2-3]{1}[0-9]{3}[1-2]{1}[0-9]{4}");
        Matcher validar= p.matcher(cadena);
        if(validar.matches()){
            resultado=true;
        }
        return resultado;

    }

    public static boolean validadorCorreo(String cadena) {
        boolean resultado=false;
        Pattern p = Pattern.compile("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
        Matcher validar= p.matcher(cadena);
        if(validar.matches()){
            resultado=true;
        }
        return resultado;

    }



}
