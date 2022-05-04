package com.inventario.Inventario.Modelos;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.inventario.Inventario.Utilitarios.*;

@Entity
@Table(name = "empleado")
public class empleado {
    
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "cedula", nullable = false, length = 10, unique = true)
    @Pattern(regexp = "[0-9]{10,10}")
    private String cedula;

    @Column(name = "nombre", nullable = false, length = 50)
    @Pattern(regexp = "^[a-zA-ZñÑ\\s]*$")
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 50)
    @Pattern(regexp = "^[a-zA-ZñÑ\\s]*$")
    private String apellido;

    @Column(name = "correo", nullable = false, length = 50)
    @Email(message = "El campo email no tiene un formato valido")
    private String correo;

    @Column(name = "fechaNacimiento")
    private Date fechaNacimiento;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "celular")
    private String celular;

    @Column(name = "nombreUsuario")
    private String nombreUsuario;

    @Column(name = "clave")
    private String clave;

    @Column(name = "rol")
    private String rol;

    @Column(name = "estadoVacunacion")
    @Enumerated(value = EnumType.STRING)
    private EstadoVacunacion estadoVacunacion;

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public EstadoVacunacion getEstadoVacunacion() {
        return estadoVacunacion;
    }

    public void setEstadoVacunacion(EstadoVacunacion estadoVacunacion) {
        this.estadoVacunacion = estadoVacunacion;
    }

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "empleado")
    private Set<dosis> vacuna = new HashSet<>();
    
    public empleado() {
        
    }
    
    public empleado(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Set<dosis> getVacuna() {
        return vacuna;
    }

    public void setVacuna(Set<dosis> vacuna) {
        this.vacuna = vacuna;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
}
