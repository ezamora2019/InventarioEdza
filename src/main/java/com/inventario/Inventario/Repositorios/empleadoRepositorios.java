package com.inventario.Inventario.Repositorios;

import com.inventario.Inventario.Modelos.empleado;
import com.inventario.Inventario.Utilitarios.EstadoVacunacion;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface empleadoRepositorios extends CrudRepository<empleado, Long> {
    public abstract ArrayList<empleado> findByCedula(String cedula);
    public abstract ArrayList<empleado> findByEstadoVacunacion(EstadoVacunacion estadoVacunacion);
}


