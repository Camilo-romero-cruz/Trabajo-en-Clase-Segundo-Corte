package com.mycompany.servlet;

import com.mycompany.servlet.logica.clasePaciente;
import com.mycompany.servlet.logica.controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "svEditarPaciente", urlPatterns = {"/svEditarPaciente"})
public class svEditarPaciente extends HttpServlet {

    controladora control = new controladora();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_editar = Integer.parseInt(request.getParameter("id_pacienteEditar"));
        clasePaciente pac = control.traerPaciente(id_editar);
        HttpSession misesion = request.getSession();
        misesion.setAttribute("pacEditar", pac);

        response.sendRedirect("editarPaciente.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String telefono = request.getParameter("telefono");

        clasePaciente pac = control.traerPaciente(id);

        if (pac != null) {
            pac.setDni(dni);
            pac.setNombre(nombre);
            pac.setApellidos(apellidos);
            pac.setTelefono(telefono);

            control.editarPaciente(pac);
        }

        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Servlet para editar pacientes";
    }
}
