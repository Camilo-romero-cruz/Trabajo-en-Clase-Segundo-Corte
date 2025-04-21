package com.mycompany.servlet.logica;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "turnos")
public class claseTurno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turno")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_odontologo", nullable = false)
    private claseOdontologo odontologo;

    @Column(name = "fecha", nullable = false)
    private String fecha;

    @Column(name = "hora_inicio", nullable = false)
    private String horaInicio;

    @Column(name = "hora_salida", nullable = false)
    private String horaSalida;

    public claseTurno() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public claseOdontologo getOdontologo() { return odontologo; }
    public void setOdontologo(claseOdontologo odontologo) { this.odontologo = odontologo; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getHoraInicio() { return horaInicio; }
    public void setHoraInicio(String horaInicio) { this.horaInicio = horaInicio; }

    public String getHoraSalida() { return horaSalida; }
    public void setHoraSalida(String horaSalida) { this.horaSalida = horaSalida; }
}