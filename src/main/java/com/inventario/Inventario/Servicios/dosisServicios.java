package com.inventario.Inventario.Servicios;

import com.inventario.Inventario.Repositorios.*;
import com.inventario.Inventario.Modelos.*;
import com.inventario.Inventario.Utilitarios.TipoVacuna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class dosisServicios {

    @Autowired
    private dosisRepositorios objetoDosisRepositorios;

    @Autowired
    private empleadoRepositorios objetoEmpleadoRepositorios;

    public ResponseEntity<ArrayList<dosis>> consultaDosis(long empleadoId) {

        ArrayList<dosis> listaDosis = this.objetoDosisRepositorios.findByEmpleadoId(empleadoId);

        if (listaDosis.size() == 0) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(listaDosis);
    }

    public ResponseEntity<Object> consultaPorTipoVacuna(TipoVacuna tipoVacuna) {

        ArrayList<dosis> listaVacuna = objetoDosisRepositorios.findByTipoVacuna(tipoVacuna);

        if (listaVacuna.size() == 0) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(listaVacuna);
    }
    public ResponseEntity<dosis> ingresaDosis(long empleadoId, dosis objetoDosis) {

        Optional<empleado> optionalEmpleado = this.objetoEmpleadoRepositorios.findById(empleadoId);

        if (!optionalEmpleado.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        objetoDosis.setEmpleado(optionalEmpleado.get());
        dosis nuevaDosis = this.objetoDosisRepositorios.save(objetoDosis);
        return ResponseEntity.ok(nuevaDosis);

    }

    public boolean eliminaDosis(long empleadoId, long id) {

        Optional<empleado> optionalEmpleado = this.objetoEmpleadoRepositorios.findById(empleadoId);

        if (!optionalEmpleado.isPresent()) {
            return false;
        }

        try{
            this.objetoDosisRepositorios.deleteById(id);
            return true;
        }catch(Exception ex){
            return false;
        }



    }


}
