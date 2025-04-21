package com.mycompany.servlet.logica;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "horarios")
public class claseHorario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_odontologo", nullable = false)
    private claseOdontologo odontologo;

    @Column(name = "hora_entrada", nullable = false)
    private String horaEntrada;

    @Column(name = "hora_salida", nullable = false)
    private String horaSalida;

    public claseHorario() {}

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public claseOdontologo getOdontologo() { return odontologo; }
    public void setOdontologo(claseOdontologo odontologo) { this.odontologo = odontologo; }

    public String getHoraEntrada() { return horaEntrada; }
    public void setHoraEntrada(String horaEntrada) { this.horaEntrada = horaEntrada; }

    public String getHoraSalida() { return horaSalida; }
    public void setHoraSalida(String horaSalida) { this.horaSalida = horaSalida; }
}