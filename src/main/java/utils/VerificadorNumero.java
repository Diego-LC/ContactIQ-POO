package utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificadorNumero {

    public static boolean validarFormato(String numeroTelefono) {
        // Asumimoas un formato de número básico par este ejemplo (puedes ajustarlo según tus necesidades)
        String formatoValido = "9\\d{8}";
        Pattern pattern = Pattern.compile(formatoValido);
        Matcher matcher = pattern.matcher(numeroTelefono);
        return matcher.matches();
    }

    public static String extraerCodigoPais(String numeroTelefono) {
        // Como no hay guiones en el formato, simplemente devolvemos el primer carácter
        if (!numeroTelefono.isEmpty()) {
            return String.valueOf(numeroTelefono.charAt(0));
        }
        return "";
    }
}
