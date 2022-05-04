package com.inventario.Inventario.Controladores;

import com.inventario.Inventario.Modelos.empleado;
import com.inventario.Inventario.Servicios.empleadoServicios;
import com.inventario.Inventario.Utilitarios.EstadoVacunacion;
import com.inventario.Inventario.Utilitarios.PasswordUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/empleado")
public class empleadoController {

    @Autowired
    empleadoServicios objetoEmpleadoServicios;

    @GetMapping()
    public ResponseEntity<ArrayList<empleado>> consultaGeneralEmpleados(){
        return this.objetoEmpleadoServicios.consultaGeneralEmpleados();
    }

    @RequestMapping(value = "/consultaIndividualPorId/{cedula}")
    public ResponseEntity<empleado> consultaIndividualPorId(@PathVariable("id") long id) {

        return objetoEmpleadoServicios.consultaIndividualPorId(id);
    }

    @RequestMapping(value = "/consultaIndividualPorCedula/{cedula}")
    public ResponseEntity<ArrayList<empleado>> consultaIndividualPorCedula(@PathVariable("cedula") String cedula) {

        return objetoEmpleadoServicios.consultaIndividualPorCedula(cedula);
    }

    @RequestMapping(value = "/consultaPorEstadoVacunacion/{id}")
    public ResponseEntity<ArrayList<empleado>> consultaPorEstadoVacunacion(@PathVariable("id") EstadoVacunacion estadoVacunacion) {

        return objetoEmpleadoServicios.consultaPorEstadoVacunacion(estadoVacunacion);
    }

    @PostMapping("/ingresaEmpleado")
    public ResponseEntity<empleado> ingresaEmpleado(@Valid @RequestBody empleado objetoEmpleado) {
        return objetoEmpleadoServicios.ingresaEmpleado(objetoEmpleado);
    }

    @DeleteMapping(value = "/eliminaEmpleado/{id}")
    public ResponseEntity<Void> eliminaEmpleado(@PathVariable("id") long id) {

        return objetoEmpleadoServicios.eliminaEmpleado(id);
    }

    @PutMapping("/actualizaEmpleado")
    public ResponseEntity<empleado>actualizaEmpleado(@RequestBody empleado objetoEmpleado) {

        return objetoEmpleadoServicios.actualizaEmpleado(objetoEmpleado);
    }
}
