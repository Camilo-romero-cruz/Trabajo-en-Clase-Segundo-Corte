<%@page import="com.mycompany.servlet.logica.claseResponsable"%>
<%@page import="com.mycompany.servlet.logica.clasePaciente"%>
<%@page import="com.mycompany.servlet.logica.claseOdontologo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Responsables</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="sb-nav-fixed">
    <%@include file="LAYOUT/layout-static.jsp" %>

    <div id="layoutSidenav_content">
        <main class="container bg-light py-5">
            <h1 class="display-4 text-center mb-5">Lista de Responsables Registrados</h1>

            <div class="card shadow mb-5">
                <div class="card-header bg-primary text-white">
                    <h2 class="h5 mb-0">Responsables</h2>
                </div>
                <div class="card-body">
                    <%
                        List<claseResponsable> listaResponsables = (List<claseResponsable>) session.getAttribute("listaResponsables");
                        if (listaResponsables != null && !listaResponsables.isEmpty()) {
                    %>
                    <table class="table table-striped table-bordered">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Paciente</th>
                                <th>Odontólogo</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                        <%
                            int i = 1;
                            for (claseResponsable r : listaResponsables) {
                                clasePaciente paciente = r.getPaciente();
                                claseOdontologo odontologo = r.getOdontologo();
                        %>
                            <tr>
                                <td><%= i++ %></td>
                                <td><%= paciente.getNombre() %> <%= paciente.getApellidos() %></td>
                                <td><%= odontologo.getNombre() %> <%= odontologo.getApellidos() %></td>
                                <td>
                                    <!-- Podrías agregar botones de editar o eliminar si es necesario -->
                       <form action="svEliminarResponsable" method="POST" style="display:inline;">
    <input type="hidden" name="idResponsable" value="<%= r.getId() %>">
    <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('¿Eliminar esta relación responsable?')">
        Eliminar
    </button>
</form>

                                </td>
                            </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                    <% } else { %>
                    <div class="alert alert-warning">No hay responsables registrados.</div>
                    <% } %>
                </div>
            </div>
        </main>
    </div>
</body>
</html>
