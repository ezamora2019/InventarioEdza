package com.inventario.Inventario.Servicios;

import com.inventario.Inventario.Repositorios.*;
import com.inventario.Inventario.Modelos.*;
import com.inventario.Inventario.Utilitarios.EstadoVacunacion;
import com.inventario.Inventario.Utilitarios.PasswordUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class empleadoServicios {

    @Autowired
    private empleadoRepositorios objetoEmpleadoRepositorios;

    public ResponseEntity<ArrayList<empleado>> consultaGeneralEmpleados() {

        ArrayList<empleado> listaEmpleados = (ArrayList<empleado>) objetoEmpleadoRepositorios.findAll();

        if (listaEmpleados.size() == 0) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(listaEmpleados);
    }

    public ResponseEntity<empleado> consultaIndividualPorId(long id) {

        Optional<empleado> individualEmpleado = objetoEmpleadoRepositorios.findById(id);

        if (individualEmpleado.isPresent()) {
            return ResponseEntity.ok(individualEmpleado.get());
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<ArrayList<empleado>> consultaIndividualPorCedula(String cedula) {

        ArrayList<empleado> listaEmpleado = objetoEmpleadoRepositorios.findByCedula(cedula);

        if (listaEmpleado.size() == 0) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(listaEmpleado);
    }

    public ResponseEntity<ArrayList<empleado>> consultaPorEstadoVacunacion(EstadoVacunacion estadoVacunacion) {

        ArrayList<empleado> listaEmpleado = objetoEmpleadoRepositorios.findByEstadoVacunacion(estadoVacunacion);

        if (listaEmpleado.size() == 0) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(listaEmpleado);
    }

    public ResponseEntity<empleado> ingresaEmpleado(empleado objetoEmpleado) {
        PasswordUsuario objetoPassword = new PasswordUsuario();
        empleado objetoNuevoEmpleado = new empleado();
        objetoNuevoEmpleado.setCedula(objetoEmpleado.getCedula());
        objetoNuevoEmpleado.setNombre(objetoEmpleado.getNombre());
        objetoNuevoEmpleado.setApellido(objetoEmpleado.getApellido());
        objetoNuevoEmpleado.setCorreo(objetoEmpleado.getCorreo());
        objetoNuevoEmpleado.setNombre(objetoPassword.generateUsuario(objetoEmpleado));
        objetoNuevoEmpleado.setClave(objetoPassword.generateContrasenia(10));
        objetoNuevoEmpleado.setRol(objetoEmpleado.getRol());
        objetoNuevoEmpleado.setFechaNacimiento(objetoEmpleado.getFechaNacimiento());
        objetoNuevoEmpleado.setDireccion(objetoEmpleado.getDireccion());
        objetoNuevoEmpleado.setCelular(objetoEmpleado.getCelular());
        objetoNuevoEmpleado.setEstadoVacunacion(objetoEmpleado.getEstadoVacunacion());
        objetoNuevoEmpleado.setVacuna(objetoEmpleado.getVacuna());

        empleado nuevoEmpleado = objetoEmpleadoRepositorios.save(objetoNuevoEmpleado);

        return ResponseEntity.ok(nuevoEmpleado);
    }

    public ResponseEntity<Void> eliminaEmpleado(long id) {
        objetoEmpleadoRepositorios.deleteById(id);
        return ResponseEntity.ok(null);
    }

    public ResponseEntity<empleado>actualizaEmpleado(empleado objetoEmpleado) {

        Optional<empleado> optionalEmpleado = objetoEmpleadoRepositorios.findById(objetoEmpleado.getId());

        if (optionalEmpleado.isPresent()) {

            empleado objetoActualizaEmpleado = optionalEmpleado.get();

            objetoActualizaEmpleado.setNombre(objetoActualizaEmpleado.getNombre());
            objetoActualizaEmpleado.setApellido(objetoActualizaEmpleado.getApellido());
            objetoActualizaEmpleado.setCorreo(objetoActualizaEmpleado.getCorreo());
            objetoActualizaEmpleado.setCedula(objetoActualizaEmpleado.getCedula());
            objetoActualizaEmpleado.setDireccion(objetoActualizaEmpleado.getDireccion());
            objetoActualizaEmpleado.setFechaNacimiento(objetoActualizaEmpleado.getFechaNacimiento());
            objetoActualizaEmpleado.setEstadoVacunacion(objetoActualizaEmpleado.getEstadoVacunacion());
            objetoActualizaEmpleado.setCelular(objetoActualizaEmpleado.getCelular());
            objetoActualizaEmpleado.setRol(objetoActualizaEmpleado.getRol());

            empleado empleadoActualizado = objetoEmpleadoRepositorios.save(objetoActualizaEmpleado);

            return ResponseEntity.ok(empleadoActualizado);
        }

        return ResponseEntity.notFound().build();
    }

}
