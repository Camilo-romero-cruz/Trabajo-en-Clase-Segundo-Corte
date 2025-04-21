package com.mycompany.servlet;

import com.mycompany.servlet.logica.claseSecretario;
import com.mycompany.servlet.logica.controladora;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "svSecretarios", urlPatterns = {"/svSecretarios"})
public class svSecretarios extends HttpServlet {

    controladora control = new controladora();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String telefono = request.getParameter("telefono");
        String sector = request.getParameter("sector");

        // Crear objeto secretario
        claseSecretario secretario = new claseSecretario();
        secretario.setDni(dni);
        secretario.setNombre(nombre);
        secretario.setApellidos(apellidos);
        secretario.setTelefono(telefono);
        secretario.setSector(sector);

        // Guardar en BD
        control.crearSecretario(secretario);

        // Redirigir a página de confirmación o listado
        response.sendRedirect("index.jsp");
    }

    @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String tipo = request.getParameter("tipo");

    // Lógica AJAX para llenar el combo de secretarios sin redirigir
    if ("ajax".equals(tipo)) {
        List<claseSecretario> listaSecretarios = control.traerSecretarios();

        // Especificar tipo de contenido
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Crear el JSON manualmente
        StringBuilder json = new StringBuilder();
        json.append("[");

        for (int i = 0; i < listaSecretarios.size(); i++) {
            claseSecretario secretario = listaSecretarios.get(i);
            // Dentro del for …
json.append("{")
    .append("\"id_secretario\":").append(secretario.getId_secretario()).append(",")
    .append("\"dni\":\"").append(secretario.getDni()).append("\",")
    .append("\"nombre\":\"").append(secretario.getNombre()).append("\",")
    .append("\"apellidos\":\"").append(secretario.getApellidos()).append("\"")
    .append("}");

            // Añadir coma si no es el último elemento
            if (i < listaSecretarios.size() - 1) {
                json.append(",");
            }
        }

        json.append("]");

        // Escribir el JSON en la respuesta
        response.getWriter().write(json.toString());
        return;
    }

    // Si no es una petición AJAX, redirige normalmente
    List<claseSecretario> listaSecretarios = control.traerSecretarios();
    HttpSession misesion = request.getSession();
    misesion.setAttribute("listaSecretarios", listaSecretarios);
    response.sendRedirect("mostrarSecretarios.jsp");
}


    @Override
    public String getServletInfo() {
        return "Servlet para crear y listar secretarios";
    }
}
