    <%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.servlet.logica.claseOdontologo"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Odontólogos</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="sb-nav-fixed">
<%@include file="LAYOUT/layout-static.jsp" %>


<div id="layoutSidenav_content">
    <main class="container py-5">
        <div class="text-center mb-5">
            <h1 class="display-4 font-weight-bold text-primary">👨‍⚕️ Lista de Odontólogos</h1>
            <p class="lead text-muted">Gestión y mantenimiento de odontólogos registrados en el sistema.</p>
        </div>

        <div class="card shadow border-0">
            <div class="card-header bg-info text-white d-flex justify-content-between align-items-center">
                <h2 class="h5 mb-0">Odontólogos Registrados</h2>
            </div>
            <div class="card-body">
                <%
                    List<claseOdontologo> listaOdontologos = (List<claseOdontologo>) request.getSession().getAttribute("listaOdontologos");
                    if (listaOdontologos != null && !listaOdontologos.isEmpty()) {
                %>
                <div class="table-responsive">
                    <table class="table table-hover table-bordered">
                        <thead class="thead-dark text-center">
                            <tr>
                                <th>#</th>
                                <th>DNI</th>
                                <th>Especialidad</th>
                                <th>Nombre</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int i = 1;
                                for (claseOdontologo o : listaOdontologos) {
                            %>
                            <tr>
                                <td class="text-center"><%= i++ %></td>
                                <td><%= o.getDni() %></td>
                                <td><%= o.getEspecialidad() %></td>
                                <td><%= o.getNombre() %> <%= o.getApellidos() %></td>
                                <td class="text-center">
                                    <button class="btn btn-sm btn-warning mr-1"
                                            data-toggle="modal"
                                            data-target="#modalEditar"
                                            data-id="<%= o.getId() %>"
                                            data-dni="<%= o.getDni() %>"
                                            data-nombre="<%= o.getNombre() %>"
                                            data-apellidos="<%= o.getApellidos() %>"
                                            data-especialidad="<%= o.getEspecialidad() %>">
                                        <i class="fas fa-edit"></i> Editar
                                    </button>

                                    <form action="svEliminarOdontologo" method="POST" style="display:inline;">
                                        <input type="hidden" name="id_odontologo" value="<%= o.getId() %>">
                                        <button type="submit" class="btn btn-sm btn-danger" onclick="return confirm('¿Eliminar este odontólogo?')">
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
                <div class="alert alert-warning text-center">No hay odontólogos registrados.</div>
                <% } %>
            </div>
        </div>
    </main>
</div>

<!-- Modal Editar Odontólogo -->
<div class="modal fade" id="modalEditar" tabindex="-1" role="dialog" aria-labelledby="editarModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <form action="svEditarOdontologo" method="POST" class="modal-content">
        <div class="modal-header bg-info text-white">
            <h5 class="modal-title"><i class="fas fa-user-edit"></i> Editar Odontólogo</h5>
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
                <label for="editEspecialidad">Especialidad</label>
                <input type="text" class="form-control" id="editEspecialidad" name="especialidad" required>
            </div>
        </div>
        <div class="modal-footer">
            <button type="submit" class="btn btn-info"><i class="fas fa-save"></i> Guardar Cambios</button>
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
        $('#editEspecialidad').val(button.data('especialidad'));
    });
</script>

</body>
</html>
