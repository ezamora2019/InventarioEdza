package com.inventario.Inventario.Modelos;

import java.sql.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.inventario.Inventario.Utilitarios.*;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "dosis")
public class dosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "fecha", nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fecha;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "tipoVacuna", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TipoVacuna tipoVacuna;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "empleado_id", nullable = false)
    private com.inventario.Inventario.Modelos.empleado empleado;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int numerodosis) {
        this.cantidad = cantidad;
    }

    public TipoVacuna getTipoVacuna() {
        return this.tipoVacuna;
    }

    public void setTipoVacuna(TipoVacuna tipoVacuna) {
        this.tipoVacuna = tipoVacuna;
    }

    public com.inventario.Inventario.Modelos.empleado getEmpleado() {
        return this.empleado;
    }

    public void setEmpleado(com.inventario.Inventario.Modelos.empleado empleado) {
        this.empleado = empleado;
    }
}