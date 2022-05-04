package com.inventario.Inventario.Controladores;

import com.inventario.Inventario.Modelos.*;
import com.inventario.Inventario.Servicios.*;
import com.inventario.Inventario.Utilitarios.TipoVacuna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/dosis")
public class dosisController {

    @Autowired
    private dosisServicios objetoDosisServicios;

    @GetMapping("/consultaDosis/{idEmpleado}")
    public ResponseEntity<ArrayList<dosis>> consultaDosis(@PathVariable("idEmpleado") long empleadoId) {

        return this.objetoDosisServicios.consultaDosis(empleadoId);
    }

    @GetMapping("/consultarPorTipoVacuna/{tipoVacuna}")
    public ResponseEntity<Object> consultaPorTipoVacuna(@PathVariable("tipoVacuna") TipoVacuna tipoVacuna) {

        return this.objetoDosisServicios.consultaPorTipoVacuna(tipoVacuna);
    }

    @PostMapping("/ingresaDosis/{idEmpleado}")
    public ResponseEntity<dosis> ingresaDosis(@Valid @PathVariable("idEmpleado") long empleadoId,
                                              @RequestBody dosis objetoDosis) {

        return this.objetoDosisServicios.ingresaDosis(empleadoId, objetoDosis);

    }

    @DeleteMapping("/eliminaDosis/{idEmpleado}/{id}")
    public String eliminaDosis(@PathVariable("idEmpleado") long empleadoId, @PathVariable("id") long id) {

        if (this.objetoDosisServicios.eliminaDosis(empleadoId, id)){
            return "Dato eliminado con exito";
        }else{
            return "Dato no pudo ser eliminado";
        }

    }
}
