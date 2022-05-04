package com.inventario.Inventario.Repositorios;

import com.inventario.Inventario.Modelos.dosis;
import com.inventario.Inventario.Utilitarios.TipoVacuna;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface dosisRepositorios extends CrudRepository<dosis, Long> {
    public abstract ArrayList<dosis> findByEmpleadoId(long empleado);
    public abstract ArrayList<dosis> findByTipoVacuna(TipoVacuna tipoVacuna);
}
