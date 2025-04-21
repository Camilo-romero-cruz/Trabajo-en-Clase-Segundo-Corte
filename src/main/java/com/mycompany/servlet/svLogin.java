package com.mycompany.servlet;

import com.mycompany.servlet.logica.claseUsuario;
import com.mycompany.servlet.logica.controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "svLogin", urlPatterns = {"/svLogin"})
public class svLogin extends HttpServlet {

    controladora control = new controladora();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String dni = request.getParameter("dni");
        String contraseña = request.getParameter("contraseña");

        // Verificar las credenciales del usuario
        claseUsuario usuario = control.traerUsuarioPorDni(dni);  // Método para obtener el usuario por DNI

    
        if (usuario != null && usuario.getContraseña().equals(contraseña)) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            
                session.setAttribute("rol", usuario.getRol());
    session.setAttribute("idUsuario", usuario.getId());
    
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("login.jsp?error=1");
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet para gestionar el login de los usuarios";
    }
}