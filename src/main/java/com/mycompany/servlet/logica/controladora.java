    package com.mycompany.servlet.logica;
    
  import com.mycompany.servlet.logica.claseHorario;

    import com.mycompany.servlet.persistencia.controladoraPersistencia;
    import java.util.List;

    public class controladora {

        controladoraPersistencia controlPersis = new controladoraPersistencia();    

        // Métodos para Usuario
        public void crearUsuario(claseUsuario usu){
            controlPersis.crearUsuario(usu);
        }

        public List<claseUsuario> traerUsuarios(){
            return controlPersis.traerUsuarios();
        }

        public claseUsuario traerUsuarioPorDni(String dni) {
            return controlPersis.traerUsuarioPorDni(dni);
        }

        public void borrarUsuario(int id_eliminar){
            controlPersis.borrarUsuario(id_eliminar);
        }

        public claseUsuario traerUsuario(int id_editar) {
            return controlPersis.traerUsuario(id_editar);
        }

        public void editarUsuario(claseUsuario usu){
            controlPersis.editarUsuario(usu);
        }

    // Métodos para Paciente
public void crearPaciente(clasePaciente pac){
    controlPersis.crearPaciente(pac);
}

public List<clasePaciente> traerPacientes(){
    return controlPersis.traerPacientes();
}

public clasePaciente traerPaciente(int id_paciente) {
    return controlPersis.traerPaciente(id_paciente);
}

public void editarPaciente(clasePaciente pac){
    controlPersis.editarPaciente(pac);
}

public void borrarPaciente(int id_eliminar) {
    controlPersis.borrarPaciente(id_eliminar);
}


        
        
        // Métodos para Odontologo
        public void crearOdontologo(claseOdontologo odontologo) {
            controlPersis.crearOdontologo(odontologo);
        }

        public List<claseOdontologo> traerOdontologos() {
            return controlPersis.traerOdontologos();
        }

        public claseOdontologo traerOdontologo(int id) {
            return controlPersis.traerOdontologo(id);
        }

        public void editarOdontologo(claseOdontologo odontologo) {
            controlPersis.editarOdontologo(odontologo);
        }

        public void borrarOdontologo(int id) {
            controlPersis.borrarOdontologo(id);
        }

        // Métodos para Horario
     public void crearHorario(claseHorario h) {
          controlPersis.crearHorario(h);
      }
  
      public List<claseHorario> traerHorarios() {
          return controlPersis.traerHorarios();
      }
  
      public void borrarHorario(int id) {
          controlPersis.borrarHorario(id);
      }

     /*   public void editarHorario(claseHorario horario) {
            controlPersis.editarHorario(horario);
        }

        public void borrarHorario(int id) {
            controlPersis.borrarHorario(id);
        }
        */
  // Métodos para Secretario
public void crearSecretario(claseSecretario secretario) {
    controlPersis.crearSecretario(secretario);
}

public List<claseSecretario> traerSecretarios() {
    return controlPersis.traerSecretarios();
}

public claseSecretario traerSecretario(int id_secretario) {
    return controlPersis.traerSecretario(id_secretario);
}

public void editarSecretario(claseSecretario secretario) {
    controlPersis.editarSecretario(secretario);
}

public void borrarSecretario(int id_eliminar) {
    controlPersis.borrarSecretario(id_eliminar);
}
public claseSecretario traerSecretarioPorId(int id) {
    return controlPersis.traerSecretario(id);
}

public claseOdontologo traerOdontologoPorId(int id) {
    return controlPersis.traerOdontologo( id);
}


// declara en la parte superior:

// y añade:

public void crearResponsable(claseResponsable r) {
    controlPersis.crearResponsable(r);
}

public List<claseResponsable> traerResponsables() {
    return controlPersis.traerResponsables();
}

public void borrarResponsable(int id) {
    controlPersis.borrarResponsable(id);
}


public void crearTurno(claseTurno t) {
    controlPersis.crearTurno(t);
}
public List<claseTurno> traerTurnos() {
    return controlPersis.traerTurnos();
}
public List<claseTurno> traerTurnosPorOdontologoYFecha(int idOd, String fecha) {
    return controlPersis.traerTurnosPorOdontologoYFecha(idOd, fecha);
}
public void borrarTurno(int id) {
    controlPersis.borrarTurno(id);
}

// Método auxiliar para Horario:
public List<claseHorario> traerHorariosPorOdontologo(int idOd) {
    return controlPersis.traerHorariosPorOdontologo(idOd);
}

        
    }
