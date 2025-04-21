package com.mycompany.servlet.logica;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class claseUsuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id;

    @Column(nullable = false, unique = true)
    private String dni;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String contraseña;

    @Column(nullable = false)
    private String rol;

    // Relaciones con secretario y odontólogo
    @ManyToOne
    @JoinColumn(name = "id_odontologo", referencedColumnName = "id_odontologo", nullable = true)
    private claseOdontologo odontologo;

    @ManyToOne
    @JoinColumn(name = "id_secretario", referencedColumnName = "id_secretario", nullable = true)
    private claseSecretario secretario;

    public claseUsuario() {}

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public claseOdontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(claseOdontologo odontologo) {
        this.odontologo = odontologo;
    }

    public claseSecretario getSecretario() {
        return secretario;
    }

    public void setSecretario(claseSecretario secretario) {
        this.secretario = secretario;
    }
}
