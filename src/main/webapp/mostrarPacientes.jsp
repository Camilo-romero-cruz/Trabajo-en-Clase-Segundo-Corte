<%@page import="com.mycompany.servlet.logica.clasePaciente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Pacientes</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="sb-nav-fixed">
    <%@include file="LAYOUT/layout-static.jsp" %>

  <div id="layoutSidenav_content">
        <main class="container py-5">
            <div class="text-center mb-5">
                <h1 class="display-4 text-success font-weight-bold">🧑‍⚕️ Lista de Pacientes</h1>
                <p class="lead text-muted">Gestión de pacientes registrados en el sistema</p>
            </div>

            <div class="card shadow border-0">
                <div class="card-header bg-success text-white">
                    <h2 class="h5 mb-0">Pacientes Registrados</h2>
                </div>
                <div class="card-body">
                    <%
                        List<clasePaciente> listaPacientes = (List) request.getSession().getAttribute("listaPacientes");
                        if (listaPacientes != null && !listaPacientes.isEmpty()) {
                    %>
                    <div class="table-responsive">
                        <table class="table table-hover table-bordered">
                            <thead class="thead-dark text-center">
                                <tr>
                                    <th>#</th>
                                    <th>DNI</th>
                                    <th>Nombre</th>
                                    <th>Apellidos</th>
                                    <th>Teléfono</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                            <%
                                int i = 1;
                                for (clasePaciente pac : listaPacientes) {
                            %>
                                <tr>
                                    <td class="text-center"><%= i++ %></td>
                                    <td><%= pac.getDni() %></td>
                                    <td><%= pac.getNombre() %></td>
                                    <td><%= pac.getApellidos() %></td>
                                    <td><%= pac.getTelefono() %></td>
                                    <td class="text-center">
                                        <button class="btn btn-warning btn-sm mr-1"
                                                data-toggle="modal"
                                                data-target="#modalEditar"
                                                data-id="<%= pac.getId() %>"
                                                data-dni="<%= pac.getDni() %>"
                                                data-nombre="<%= pac.getNombre() %>"
                                                data-apellidos="<%= pac.getApellidos() %>"
                                                data-telefono="<%= pac.getTelefono() %>">
                                            <i class="fas fa-edit"></i> Editar
                                        </button>

                                        <form action="svEliminarPaciente" method="POST" style="display:inline;">
                                            <input type="hidden" name="id_paciente" value="<%= pac.getId() %>">
                                            <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('¿Eliminar este paciente?')">
                                                <i class="fas fa-trash-alt"></i> Eliminar
                                            </button>
                                        </form>
                                    </td>
                                </tr>
                            <% } %>
                            </tbody>
                        </table>
                    </div>
                    <% } else { %>
                    <div class="alert alert-warning text-center">No hay pacientes registrados.</div>
                    <% } %>
                </div>
            </div>
        </main>
    </div>

    <!-- Modal Editar Paciente -->
    <div class="modal fade" id="modalEditar" tabindex="-1" role="dialog" aria-labelledby="editarModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <form action="svEditarPaciente" method="POST" class="modal-content">
            <div class="modal-header bg-success text-white">
                <h5 class="modal-title"><i class="fas fa-user-edit"></i> Editar Paciente</h5>
                <button type="button" class="close text-white" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <input type="hidden" name="id" id="editId">
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
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-success"><i class="fas fa-save"></i> Guardar Cambios</button>
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
        });
    </script>
</body>
</html>
