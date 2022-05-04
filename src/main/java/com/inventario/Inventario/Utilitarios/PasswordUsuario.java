package com.inventario.Inventario.Utilitarios;

import java.util.Random;

import com.inventario.Inventario.Modelos.empleado;
import org.apache.commons.lang3.RandomStringUtils;

public class PasswordUsuario {

    public String generateUsuario(empleado empleado) {

        Random generator = new Random();
        String usuarioRetorno = empleado.getNombre().replaceAll("\\s+", "").toLowerCase().substring(0, 2)
                + empleado.getApellido().replaceAll("\\s+", "").toLowerCase().substring(0, 6)
                + String.valueOf(generator.nextInt(89) + 10);

        return usuarioRetorno;
    }

    public String generateContrasenia(int len) {
		final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        return RandomStringUtils.random(len, chars);
	}


}
