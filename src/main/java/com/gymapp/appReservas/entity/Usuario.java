package com.gymapp.appReservas.entity;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.EntityModel;
import javax.persistence.*;


@Entity
@Table(name="usuarios")
public class Usuario extends EntityModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @Column(name="nombre",length = 256)
    private String nombre;
    @Column(name="apellidos",length = 256)
    private String apellidos;
    @Column(name="email",length = 256)
    private String email;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String fechaNacimiento;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String toString(){
        return "[id] "+idUsuario+" [nombre] " + nombre + " [apellidos] " + apellidos;
    }

}
