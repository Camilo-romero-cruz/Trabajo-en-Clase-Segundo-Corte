<%@page import="com.mycompany.servlet.logica.claseSecretario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Secretarios</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="sb-nav-fixed">
    <%@include file="LAYOUT/layout-static.jsp" %>

    <div id="layoutSidenav_content">
        <main class="container bg-light py-5">
            <h1 class="display-4 text-center mb-5">Lista de Secretarios Registrados</h1>

            <div class="card shadow mb-5">
                <div class="card-header bg-primary text-white">
                    <h2 class="h5 mb-0">Secretarios</h2>
                </div>
                <div class="card-body">
                    <%
                        List<claseSecretario> listaSecretarios = (List) request.getSession().getAttribute("listaSecretarios");
                        if (listaSecretarios != null && !listaSecretarios.isEmpty()) {
                    %>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>DNI</th>
                                <th>Nombre</th>
                                <th>Apellidos</th>
                                <th>Teléfono</th>
                                <th>Sector</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                        <%
                            int i = 1;
                            for (claseSecretario s : listaSecretarios) {
                        %>
                            <tr>
                                <td><%= i++ %></td>
                                <td><%= s.getDni() %></td>
                                <td><%= s.getNombre() %></td>
                                <td><%= s.getApellidos() %></td>
                                <td><%= s.getTelefono() %></td>
                                <td><%= s.getSector() %></td>
                                <td>
                                    <button class="btn btn-warning btn-sm"
                                            data-toggle="modal"
                                            data-target="#modalEditar"
                                            data-id="<%= s.getId_secretario() %>"
                                            data-dni="<%= s.getDni() %>"
                                            data-nombre="<%= s.getNombre() %>"
                                            data-apellidos="<%= s.getApellidos() %>"
                                            data-telefono="<%= s.getTelefono() %>"
                                            data-sector="<%= s.getSector() %>">
                                        Editar
                                    </button>

                                    <form action="svEliminarSecretario" method="POST" style="display:inline;">
                                        <input type="hidden" name="id_secretario" value="<%= s.getId_secretario() %>">
                                        <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('¿Eliminar este secretario?')">
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
                    <div class="alert alert-danger mt-3">No hay secretarios registrados.</div>
                    <% } %>
                </div>
            </div>
        </main>
    </div>

    <!-- Modal Editar Secretario -->
    <div class="modal fade" id="modalEditar" tabindex="-1" role="dialog" aria-labelledby="editarModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <form action="svEditarSecretario" method="POST" class="modal-content">
            <div class="modal-header bg-primary text-white">
                <h5 class="modal-title">Editar Secretario</h5>
                <button type="button" class="close text-white" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <input type="hidden" name="id_secretario" id="editId">
                <div class="form-group">
                    <label for="editDni">DNI</label>
                    <input type="text" class="form-control" id="editDni" name="dni" required>
                </div>
                <div class="form-group">
                    <label for="editNombre">Nombre</label>
                    <input type="text" class="form-control" id="editNombre" name="nombre" required>
                </div>
                <div class="form-group">
                    <label for="editApellidos">Apellidos</label>
                    <input type="text" class="form-control" id="editApellidos" name="apellidos" required>
                </div>
                <div class="form-group">
                    <label for="editTelefono">Teléfono</label>
                    <input type="text" class="form-control" id="editTelefono" name="telefono" required>
                </div>
                <div class="form-group">
                    <label for="editSector">Sector</label>
                    <input type="text" class="form-control" id="editSector" name="sector" required>
                </div>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-success">Guardar Cambios</button>
            </div>
        </form>
      </div>
    </div>

    <script>
        $('#modalEditar').on('show.bs.modal', function (event) {
            var button = $(event.relatedTarget);
            $('#editId').val(button.data('id'));
            $('#editDni').val(button.data('dni'));
            $('#editNombre').val(button.data('nombre'));
            $('#editApellidos').val(button.data('apellidos'));
            $('#editTelefono').val(button.data('telefono'));
            $('#editSector').val(button.data('sector'));
        });
    </script>
</body>
</html>
