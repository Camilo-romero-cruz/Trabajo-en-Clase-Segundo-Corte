package com.mycompany.servlet.persistencia;


import com.mycompany.servlet.logica.claseResponsable;
import com.mycompany.servlet.logica.claseSecretario;
import com.mycompany.servlet.logica.clasePaciente;
import com.mycompany.servlet.logica.claseUsuario;
import com.mycompany.servlet.logica.claseOdontologo;
import com.mycompany.servlet.logica.claseHorario;
import com.mycompany.servlet.logica.claseTurno;

import com.mycompany.servlet.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class controladoraPersistencia {

    // Controladores de JPA para Usuario y Paciente
    claseUsuarioJpaController usuJpa = new claseUsuarioJpaController();
    clasePacienteJpaController pacienteJpa = new clasePacienteJpaController();
    
    // Controladores de JPA para Odontologo y Horario
    claseOdontologoJpaController odontologoJpa = new claseOdontologoJpaController();
    
    // Métodos para Usuario
    public void crearUsuario(claseUsuario usu){
        usuJpa.create(usu);
    }

    public List<claseUsuario> traerUsuarios(){
        return usuJpa.findclaseUsuarioEntities();
    }

    public claseUsuario traerUsuarioPorDni(String dni) {
        return usuJpa.findUsuarioByDni(dni);  // Asegúrate de que este método esté correctamente implementado
    }

    public void borrarUsuario(int id_eliminar){
        try {
            usuJpa.destroy(id_eliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public claseUsuario traerUsuario(int id_editar){
        return usuJpa.findclaseUsuario(id_editar);
    }

    public void editarUsuario(claseUsuario usu) {
        try {
            usuJpa.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Métodos para Paciente
    public void crearPaciente(clasePaciente pac) {
        pacienteJpa.create(pac);
    }

    public List<clasePaciente> traerPacientes() {
        return pacienteJpa.findclasePacienteEntities();
    }

    public clasePaciente traerPaciente(int id) {
        return pacienteJpa.findclasePaciente(id);
    }

    public void editarPaciente(clasePaciente pac) {
        try {
            pacienteJpa.edit(pac);
        } catch (Exception ex) {
            Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarPaciente(int id_eliminar) {
        try {
            pacienteJpa.destroy(id_eliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Métodos para Odontologo
    public void crearOdontologo(claseOdontologo odontologo) {
        odontologoJpa.create(odontologo);
    }

    public List<claseOdontologo> traerOdontologos() {
        return odontologoJpa.findclaseOdontologoEntities();
    }

    public claseOdontologo traerOdontologo(int id) {
        return odontologoJpa.findclaseOdontologo(id);
    }

    public void editarOdontologo(claseOdontologo odontologo) {
        try {
            odontologoJpa.edit(odontologo);
        } catch (Exception ex) {
            Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarOdontologo(int id_eliminar) {
        try {
            odontologoJpa.destroy(id_eliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    // Referencia a claseSecretarioJpaController
claseSecretarioJpaController secretarioJpa = new claseSecretarioJpaController();

// Métodos para Secretario
public void crearSecretario(claseSecretario secretario) {
    secretarioJpa.create(secretario);
}

public List<claseSecretario> traerSecretarios() {
    return secretarioJpa.findclaseSecretarioEntities();
}

public claseSecretario traerSecretario(int id_secretario) {
    return secretarioJpa.findclaseSecretario(id_secretario);
}

public void editarSecretario(claseSecretario secretario) {
    try {
        secretarioJpa.edit(secretario);
    } catch (Exception ex) {
        Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public void borrarSecretario(int id_eliminar) {
    try {
        secretarioJpa.destroy(id_eliminar);
    } catch (NonexistentEntityException ex) {
        Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
    }
}

// al inicio de la clase, declara:
claseResponsableJpaController responsableJpa = new claseResponsableJpaController();

// luego añade abajo, junto a los demás:

// Métodos para Responsables
public void crearResponsable(claseResponsable r) {
    responsableJpa.create(r);
}

public List<claseResponsable> traerResponsables() {
    return responsableJpa.findResponsableEntities();
}

public void borrarResponsable(int id) {
    try {
        responsableJpa.destroy(id);
    } catch (NonexistentEntityException ex) {
        Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
    }
}

claseHorarioJpaController horarioJpa = new claseHorarioJpaController();

    // Métodos para Horario:
    public void crearHorario(claseHorario horario) {
        horarioJpa.create(horario);
    }

    public List<claseHorario> traerHorarios() {
        return horarioJpa.findHorarioEntities();
    }

    public void borrarHorario(int id) {
        try {
            horarioJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    // Declaraciones al inicio de la clase:
claseTurnoJpaController turnoJpa = new claseTurnoJpaController();

// Métodos para Turno:
public void crearTurno(claseTurno t) {
    turnoJpa.create(t);
}
public List<claseTurno> traerTurnos() {
    return turnoJpa.findTurnoEntities();
}
public List<claseTurno> traerTurnosPorOdontologoYFecha(int idOd, String fecha) {
    return turnoJpa.findTurnosByOdontologoAndFecha(idOd, fecha);
}
public void borrarTurno(int id) {
    try { turnoJpa.destroy(id); }
    catch (NonexistentEntityException ex) {
        Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
    }
}

// Método para traer horarios por odontólogo:
public List<claseHorario> traerHorariosPorOdontologo(int idOd) {
    return horarioJpa.findHorarioByOdontologo(idOd);
}

}
