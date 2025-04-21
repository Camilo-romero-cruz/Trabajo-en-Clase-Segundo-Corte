package com.mycompany.servlet;

import com.mycompany.servlet.logica.claseUsuario;
import com.mycompany.servlet.logica.controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "svEditarUsuario", urlPatterns = {"/svEditarUsuario"})
public class svEditarUsuario extends HttpServlet {

    controladora control = new controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_editar = Integer.parseInt(request.getParameter("id_usuarioEditar"));
        claseUsuario usu = control.traerUsuario(id_editar);
        HttpSession misesion = request.getSession();
        misesion.setAttribute("usuEditar", usu);
        
        response.sendRedirect("editarUsuario.jsp");
    }

    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    
    int id = Integer.parseInt(request.getParameter("id")); // <-- este es nuevo

    String dni = request.getParameter("dni");
    String nombre = request.getParameter("nombre");
    String apellidos = request.getParameter("apellidos");
    String telefono = request.getParameter("telefono");

    claseUsuario usu = control.traerUsuario(id); // <-- en vez de tomarlo de la sesión

    if (usu != null) {
        usu.setDni(dni);
        usu.setNombre(nombre);
        usu.setApellidos(apellidos);
        usu.setTelefono(telefono);

        control.editarUsuario(usu);
    }

    response.sendRedirect("index.jsp");
}


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
