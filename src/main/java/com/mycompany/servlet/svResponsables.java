package com.mycompany.servlet;

import com.mycompany.servlet.logica.claseResponsable;
import com.mycompany.servlet.logica.clasePaciente;
import com.mycompany.servlet.logica.claseOdontologo;
import com.mycompany.servlet.logica.controladora;
import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "svResponsables", urlPatterns = {"/svResponsables"})
public class svResponsables extends HttpServlet {
    private controladora control = new controladora();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<clasePaciente> pacientes = control.traerPacientes();
        List<claseOdontologo> odontologos = control.traerOdontologos();
        List<claseResponsable> responsables = control.traerResponsables();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaPacientes", pacientes);
        sesion.setAttribute("listaOdontologos", odontologos);
        sesion.setAttribute("listaResponsables", responsables);

        response.sendRedirect("mostrarResponsables.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idPac = Integer.parseInt(request.getParameter("idPaciente"));
        int idOd = Integer.parseInt(request.getParameter("idOdontologo"));

        claseResponsable r = new claseResponsable();
        r.setPaciente(control.traerPaciente(idPac));
        r.setOdontologo(control.traerOdontologo(idOd));

        control.crearResponsable(r);
        response.sendRedirect("index.jsp");
    }
}
