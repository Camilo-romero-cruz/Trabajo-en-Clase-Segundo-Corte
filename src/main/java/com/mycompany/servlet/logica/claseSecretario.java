package com.mycompany.servlet.logica;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class claseSecretario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_secretario;

    @Column(nullable = false, unique = true)
    private String dni;

    @Column(nullable = false)
    private String sector;

    private String nombre;
    private String apellidos;
    private String telefono;

    public claseSecretario() {}

    // Getters y Setters
    public int getId_secretario() { return id_secretario; }
    public void setId_secretario(int id_secretario) { this.id_secretario = id_secretario; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getSector() { return sector; }
    public void setSector(String sector) { this.sector = sector; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
