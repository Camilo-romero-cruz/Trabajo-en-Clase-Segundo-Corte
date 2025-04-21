package com.mycompany.servlet;

import com.mycompany.servlet.logica.claseSecretario;
import com.mycompany.servlet.logica.controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "svEditarSecretario", urlPatterns = {"/svEditarSecretario"})
public class svEditarSecretario extends HttpServlet {

    controladora control = new controladora();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_editar = Integer.parseInt(request.getParameter("id_secretarioEditar"));
        claseSecretario secretario = control.traerSecretario(id_editar);
        HttpSession misesion = request.getSession();
        misesion.setAttribute("secretarioEditar", secretario);

        response.sendRedirect("editarSecretario.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id_secretario"));
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String telefono = request.getParameter("telefono");
        String sector = request.getParameter("sector");

        claseSecretario secretario = control.traerSecretario(id);

        if (secretario != null) {
            secretario.setDni(dni);
            secretario.setNombre(nombre);
            secretario.setApellidos(apellidos);
            secretario.setTelefono(telefono);
            secretario.setSector(sector);

            control.editarSecretario(secretario);
        }

        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Servlet para editar secretarios";
    }
}
