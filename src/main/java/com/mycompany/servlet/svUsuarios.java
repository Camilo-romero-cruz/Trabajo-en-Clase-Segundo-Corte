package com.mycompany.servlet;

import com.mycompany.servlet.logica.claseUsuario;
import com.mycompany.servlet.logica.claseSecretario;
import com.mycompany.servlet.logica.claseOdontologo;
import com.mycompany.servlet.logica.controladora;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "svUsuarios", urlPatterns = {"/svUsuarios"})
public class svUsuarios extends HttpServlet {

    private controladora control = new controladora();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Traer listas de secretarios y odontólogos
        List<claseSecretario> listaSecretarios = control.traerSecretarios();
        List<claseOdontologo> listaOdontologos = control.traerOdontologos();

        // Guardar en sesión
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaSecretarios", listaSecretarios);
        sesion.setAttribute("listaOdontologos", listaOdontologos);

        // Redirigir al JSP del formulario
        response.sendRedirect("GestionUsuarios.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Parámetros del formulario
        String dni          = request.getParameter("dni");
        String nombre       = request.getParameter("nombre");
        String apellidos    = request.getParameter("apellidos");
        String telefono     = request.getParameter("telefono");
        String contrasena   = request.getParameter("contrasena");
        String rol          = request.getParameter("rol");
        String idPersona    = request.getParameter("idPersona");  // id_secretario o id_odontologo

        // Crear objeto Usuario
        claseUsuario usuario = new claseUsuario();
        usuario.setDni(dni);
        usuario.setNombre(nombre);  
        usuario.setApellidos(apellidos);
        usuario.setTelefono(telefono);
        usuario.setContraseña(contrasena);
        usuario.setRol(rol);

        // Asignar clave foránea según rol
     if ("SECRETARIO".equals(rol)) {
    claseSecretario secretario = control.traerSecretarioPorId(Integer.parseInt(idPersona));
    usuario.setSecretario(secretario);
} else if ("ODONTOLOGO".equals(rol)) {
    claseOdontologo odontologo = control.traerOdontologoPorId(Integer.parseInt(idPersona));
    usuario.setOdontologo(odontologo);
}
     

        // Guardar en BD
        control.crearUsuario(usuario);

        // Volver al listado o al formulario
        response.sendRedirect("svUsuarios");
    }

    @Override
    public String getServletInfo() {
        return "Servlet para crear y listar usuarios con relación a secretarios u odontólogos";
    }
}
