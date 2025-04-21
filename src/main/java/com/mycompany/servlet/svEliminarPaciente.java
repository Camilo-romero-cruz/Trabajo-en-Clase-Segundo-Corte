package com.mycompany.servlet;

import com.mycompany.servlet.logica.controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "svEliminarPaciente", urlPatterns = {"/svEliminarPaciente"})
public class svEliminarPaciente extends HttpServlet {

    controladora control = new controladora();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_eliminar = Integer.parseInt(request.getParameter("id_paciente"));
        control.borrarPaciente(id_eliminar);

        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Servlet para eliminar pacientes";
    }
}
