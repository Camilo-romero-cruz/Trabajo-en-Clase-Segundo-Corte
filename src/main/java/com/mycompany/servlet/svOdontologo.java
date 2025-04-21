package com.mycompany.servlet;

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

@WebServlet(name = "svOdontologo", urlPatterns = {"/svOdontologo"})
public class svOdontologo extends HttpServlet {

    controladora control = new controladora();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtener los parámetros de la solicitud
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String telefono = request.getParameter("telefono");
        String especialidad = request.getParameter("especialidad");

        // Crear un objeto de tipo claseOdontologo
        claseOdontologo odontologo = new claseOdontologo();
        odontologo.setDni(dni);
        odontologo.setNombre(nombre);
        odontologo.setApellidos(apellidos);
        odontologo.setTelefono(telefono);
        odontologo.setEspecialidad(especialidad);

        // Llamar al método para guardar el odontologo
        try {
            control.crearOdontologo(odontologo); // Método corregido
        } catch (Exception e) {
            // Manejar excepciones aquí si es necesario (ej. base de datos)
            e.printStackTrace();
        }

        // Redirigir a la página principal o a una página de éxito
        response.sendRedirect("index.jsp");
    }

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String tipo = request.getParameter("tipo");

    // Lógica AJAX para llenar el combo sin redirigir
    if ("ajax".equals(tipo)) {
        List<claseOdontologo> listaOdontologos = control.traerOdontologos();

        // Especificar tipo de contenido
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Crear el JSON manualmente
        StringBuilder json = new StringBuilder();
        json.append("[");

        for (int i = 0; i < listaOdontologos.size(); i++) {
            claseOdontologo odontologo = listaOdontologos.get(i);
        json.append("{")
    .append("\"id_odontologo\":").append(odontologo.getId()).append(",")
    .append("\"dni\":\"").append(odontologo.getDni()).append("\",")
    .append("\"nombre\":\"").append(odontologo.getNombre()).append("\",")
    .append("\"apellidos\":\"").append(odontologo.getApellidos()).append("\"")
    .append("}");


            // Añadir coma si no es el último elemento
            if (i < listaOdontologos.size() - 1) {
                json.append(",");
            }
        }

        json.append("]");

        // Escribir el JSON en la respuesta
        response.getWriter().write(json.toString());
        return;
    }

    // Comportamiento clásico: redirección a mostrarOdontologo.jsp
    List<claseOdontologo> listaOdontologos = control.traerOdontologos();
    HttpSession session = request.getSession();
    session.setAttribute("listaOdontologos", listaOdontologos);
    response.sendRedirect("mostrarOdontologo.jsp");
}


}
