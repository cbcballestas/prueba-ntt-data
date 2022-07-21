package com.nttdata.apirest.util;

public class Util {

    /**
     * Método que permite verificar si una cadena es nula ó vacía
     * @param valor Cadena
     * @return Si la cadena es nula ó vacía retorna TRUE, de lo
     * contrario FALSE
     */
    public static boolean isNullOrEmpty(String valor) {
        if (valor == null) {
            return true;
        }
        return valor.isEmpty();
    }
}
