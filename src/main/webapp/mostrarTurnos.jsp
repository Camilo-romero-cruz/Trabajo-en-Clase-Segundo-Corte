<%@ page import="com.mycompany.servlet.logica.claseResponsable" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Responsables</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="sb-nav-fixed">
    <%@ include file="LAYOUT/layout-static.jsp" %>

    <div id="layoutSidenav_content">
        <main class="container bg-light py-5">
            <h1 class="display-4 text-center mb-5">Asignaciones de Responsables</h1>

            <div class="row">
                <%
                    @SuppressWarnings("unchecked")
                    List<claseResponsable> listaResps =
                        (List<claseResponsable>) session.getAttribute("listaResponsables");

                    if (listaResps != null && !listaResps.isEmpty()) {
                        for (claseResponsable r : listaResps) {
                %>
                <div class="col-md-4 mb-4">
                    <div class="card h-100 shadow-sm">
                        <div class="card-header bg-primary text-white">
                            <h5 class="mb-0">Responsable #<%= r.getId() %></h5>
                        </div>
                        <div class="card-body">
                            <p><strong>Paciente:</strong><br>
                               <%= r.getPaciente().getNombre() + " " + r.getPaciente().getApellidos() %>
                            </p>
                            <p><strong>Odontólogo:</strong><br>
                               <%= r.getOdontologo().getNombre() + " " + r.getOdontologo().getApellidos() %>
                            </p>
                        </div>
                        <div class="card-footer text-right">
                            <form action="svResponsables" method="GET" style="display:inline;">
                                <input type="hidden" name="accion" value="borrar">
                                <input type="hidden" name="id" value="<%= r.getId() %>">
                                <button type="submit"
                                        class="btn btn-danger btn-sm"
                                        onclick="return confirm('¿Eliminar esta asignación?')">
                                    <i class="bi bi-trash"></i> Eliminar
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
                <%  
                        } // for
                    } else {
                %>
                <div class="col-12">
                    <div class="alert alert-warning text-center">
                        No hay asignaciones de responsables.
                    </div>
                </div>
                <% } %>
            </div>

        </main>
    </div>

    <!-- Opcional: Bootstrap JS y dependencias (si no los tienes ya incluidos) -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
