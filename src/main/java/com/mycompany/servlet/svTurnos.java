package com.mycompany.servlet;

import com.mycompany.servlet.logica.claseUsuario;
import com.mycompany.servlet.logica.claseSecretario;
import com.mycompany.servlet.logica.claseHorario;
import com.mycompany.servlet.logica.claseOdontologo;
import com.mycompany.servlet.logica.claseTurno;

import com.mycompany.servlet.logica.controladora;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "SvTurnos", urlPatterns = {"/svTurnos"})
public class svTurnos extends HttpServlet {

    private final controladora control = new controladora();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tipo = request.getParameter("tipo");

        if ("ajax".equalsIgnoreCase(tipo)) {
            List<claseOdontologo> odontos = control.traerOdontologos();
            response.setContentType("application/json;charset=UTF-8");

            try (PrintWriter out = response.getWriter()) {
                out.print("[");
                for (int i = 0; i < odontos.size(); i++) {
                    claseOdontologo o = odontos.get(i);
                    String nom = o.getNombre().replace("\"", "\\\"");
                    String ape = o.getApellidos().replace("\"", "\\\"");
                    out.print("{\"id_odontologo\":" + o.getId()
                            + ",\"nombre\":\"" + nom + "\""
                            + ",\"apellidos\":\"" + ape + "\"}");
                    if (i < odontos.size() - 1) {
                        out.print(",");
                    }
                }
                out.print("]");
            }

            return;
        }

        List<claseTurno> turnos = control.traerTurnos();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaTurnos", turnos);
        response.sendRedirect("mostrarTurnos.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int idOd = Integer.parseInt(request.getParameter("idOdontologo"));
            String fecha = request.getParameter("fecha");
            String inicio = request.getParameter("horaInicio");
            String salida = request.getParameter("horaSalida");

            // Verificar horario del odontólogo
            List<claseHorario> horarios = control.traerHorariosPorOdontologo(idOd);
            boolean validoHorario = horarios.stream().anyMatch(h ->
                h.getHoraEntrada().compareTo(inicio) <= 0 &&
                h.getHoraSalida().compareTo(salida) >= 0
            );

            if (!validoHorario) {
                response.sendRedirect("gestionTurnos.jsp?error=Turno fuera del horario disponible");
                return;
            }

            // Verificar solapamiento con otros turnos
            List<claseTurno> turnosExist = control.traerTurnosPorOdontologoYFecha(idOd, fecha);
            boolean conflicto = turnosExist.stream().anyMatch(t ->
                !(salida.compareTo(t.getHoraInicio()) <= 0 ||
                  inicio.compareTo(t.getHoraSalida()) >= 0)
            );

            if (conflicto) {
                response.sendRedirect("gestionTurnos.jsp?error=Ya existe un turno en ese intervalo");
                return;
            }

            // Crear nuevo turno
            claseTurno nuevoTurno = new claseTurno();
            nuevoTurno.setOdontologo(control.traerOdontologo(idOd));
            nuevoTurno.setFecha(fecha);
            nuevoTurno.setHoraInicio(inicio);
            nuevoTurno.setHoraSalida(salida);
            control.crearTurno(nuevoTurno);

            response.sendRedirect("gestionTurnos.jsp");

        } catch (NumberFormatException e) {
            response.sendRedirect("gestionTurnos.jsp?error=Datos inválidos");
        }
    }
}
