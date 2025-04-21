package com.mycompany.servlet;

import com.mycompany.servlet.logica.claseHorario;
import com.mycompany.servlet.logica.claseOdontologo;
import com.mycompany.servlet.logica.controladora;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "svHorarios", urlPatterns = {"/svHorarios"})
public class svHorarios extends HttpServlet {
    private controladora control = new controladora();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tipo = request.getParameter("tipo");
        
        if ("ajax".equals(tipo)) {
            List<claseOdontologo> odontos = control.traerOdontologos();
            response.setContentType("application/json;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.print("[");
                for (int i = 0; i < odontos.size(); i++) {
                    claseOdontologo o = odontos.get(i);
                    String nombre = o.getNombre() != null ? o.getNombre().replace("\"", "\\\"") : "";
                    String apellidos = o.getApellidos() != null ? o.getApellidos().replace("\"", "\\\"") : "";
                    out.print("{\"id_odontologo\":" + o.getId()
                            + ",\"nombre\":\"" + nombre + "\""
                            + ",\"apellidos\":\"" + apellidos + "\"}");
                    if (i < odontos.size() - 1) {
                        out.print(",");
                    }
                }
                out.print("]");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        // Verificar que el control traiga horarios correctamente
        List<claseHorario> horarios = control.traerHorarios();
        
        if (horarios != null) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("listaHorarios", horarios);
        } else {
            // Manejo de errores si no se encuentran horarios
            request.setAttribute("error", "No se pudieron obtener los horarios.");
        }
        
        response.sendRedirect("mostrarHorarios.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int idOd = Integer.parseInt(request.getParameter("idOdontologo"));
            String entrada = request.getParameter("horaEntrada");
            String salida = request.getParameter("horaSalida");

            if (idOd <= 0 || entrada == null || salida == null) {
                // Validar los parámetros recibidos
                request.setAttribute("error", "Faltan parámetros o son incorrectos.");
                response.sendRedirect("gestionHorarios.jsp");
                return;
            }

            claseHorario h = new claseHorario();
            h.setOdontologo(control.traerOdontologo(idOd));
            h.setHoraEntrada(entrada);
            h.setHoraSalida(salida);

            control.crearHorario(h);
            response.sendRedirect("gestionHorarios.jsp");
        } catch (NumberFormatException e) {
            // Manejo de error si el idOdontologo no es un número válido
            request.setAttribute("error", "El ID del odontólogo es inválido.");
            response.sendRedirect("gestionHorarios.jsp");
        }
    }
}
