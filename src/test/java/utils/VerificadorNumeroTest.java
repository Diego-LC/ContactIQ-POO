package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VerificadorNumeroTest {

    @Test
    public void testValidarFormatoNumeroValido() {
        String numeroTelefono = "912345678";
        assertTrue(VerificadorNumero.validarFormato(numeroTelefono));
    }

    @Test
    public void testValidarFormatoNumeroInvalido() {
        // Número con menos de 9 dígitos
        String numeroTelefono = "123456789";
        assertFalse(VerificadorNumero.validarFormato(numeroTelefono));

        // Número con más de 9 dígitos
        numeroTelefono = "9123456789";
        assertFalse(VerificadorNumero.validarFormato(numeroTelefono));

        // Número con letras
        numeroTelefono = "9a2345678";
        assertFalse(VerificadorNumero.validarFormato(numeroTelefono));

        // Número con caracteres especiales
        numeroTelefono = "9!2345678";
        assertFalse(VerificadorNumero.validarFormato(numeroTelefono));

        // Número negativo
        numeroTelefono = "-912345678";
        assertFalse(VerificadorNumero.validarFormato(numeroTelefono));

        // Número con espacios vacíos
        numeroTelefono = "912 345 678";
        assertFalse(VerificadorNumero.validarFormato(numeroTelefono));

        numeroTelefono = "errorRR";
        assertFalse(VerificadorNumero.validarFormato(numeroTelefono));
    }

    @Test
    public void testExtraerCodigoPais() {
        String numeroTelefono = "912345678";
        assertEquals("9", VerificadorNumero.extraerCodigoPais(numeroTelefono));
    }

    @Test
    public void testExtraerCodigoPaisNumeroVacio() {
        String numeroTelefono = "";
        assertEquals("", VerificadorNumero.extraerCodigoPais(numeroTelefono));
    }
}
