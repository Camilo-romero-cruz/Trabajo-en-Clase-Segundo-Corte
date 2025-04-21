package com.mycompany.servlet.logica;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "responsables")
public class claseResponsable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_responsable")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private clasePaciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_odontologo", nullable = false)
    private claseOdontologo odontologo;

    public claseResponsable() {}

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public clasePaciente getPaciente() { return paciente; }
    public void setPaciente(clasePaciente paciente) { this.paciente = paciente; }

    public claseOdontologo getOdontologo() { return odontologo; }
    public void setOdontologo(claseOdontologo odontologo) { this.odontologo = odontologo; }
}
