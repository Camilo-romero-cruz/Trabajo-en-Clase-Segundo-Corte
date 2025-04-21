package com.mycompany.servlet;

import com.mycompany.servlet.logica.clasePaciente;
import com.mycompany.servlet.logica.controladora;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "svPacientes", urlPatterns = {"/svPacientes"})
public class svPacientes extends HttpServlet {

    controladora control = new controladora();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String telefono = request.getParameter("telefono");

        clasePaciente pac = new clasePaciente();
        pac.setDni(dni);
        pac.setNombre(nombre);
        pac.setApellidos(apellidos);
        pac.setTelefono(telefono);

        control.crearPaciente(pac);

        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tipo = request.getParameter("tipo");

        // Si viene por AJAX
        if ("ajax".equals(tipo)) {
            List<clasePaciente> listaPacientes = control.traerPacientes();

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            StringBuilder json = new StringBuilder();
            json.append("[");

            for (int i = 0; i < listaPacientes.size(); i++) {
                clasePaciente pac = listaPacientes.get(i);

                json.append("{")
                    .append("\"id_paciente\":").append(pac.getId()).append(",")
                    .append("\"dni\":\"").append(pac.getDni()).append("\",")
                    .append("\"nombre\":\"").append(pac.getNombre()).append("\",")
                    .append("\"apellidos\":\"").append(pac.getApellidos()).append("\"")
                    .append("}");

                if (i < listaPacientes.size() - 1) {
                    json.append(",");
                }
            }

            json.append("]");

            response.getWriter().write(json.toString());
            return;
        }

        // Si no es AJAX, comportamiento tradicional
        List<clasePaciente> listaPacientes = control.traerPacientes();
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaPacientes", listaPacientes);

        response.sendRedirect("mostrarPacientes.jsp");
    }
}

