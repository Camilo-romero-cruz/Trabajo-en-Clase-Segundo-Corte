<%@page import="com.mycompany.servlet.logica.claseHorario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Horarios</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="sb-nav-fixed">
    <%@include file="LAYOUT/layout-static.jsp" %>

    <div id="layoutSidenav_content">
        <main class="container py-5">
            <div class="text-center mb-5">
                <h1 class="display-4 text-primary font-weight-bold">🕒 Lista de Horarios</h1>
                <p class="lead text-muted">Gestión de horarios de odontólogos</p>
            </div>

            <div class="card shadow border-0">
                <div class="card-header bg-primary text-white">
                    <h2 class="h5 mb-0">Horarios Registrados</h2>
                </div>
                <div class="card-body">
                    <%
                        List<claseHorario> listaHorarios = (List) request.getSession().getAttribute("listaHorarios");
                        if (listaHorarios != null && !listaHorarios.isEmpty()) {
                    %>
                    <div class="table-responsive">
                        <table class="table table-hover table-bordered">
                            <thead class="thead-dark text-center">
                                <tr>
                                    <th>#</th>
                                    <th>Odontólogo</th>
                                    <th>Hora Entrada</th>
                                    <th>Hora Salida</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                            <%
                                int i = 1;
                                for (claseHorario h : listaHorarios) {
                            %>
                                <tr>
                                    <td class="text-center"><%= i++ %></td>
                                    <td><%= h.getOdontologo().getNombre() + " " + h.getOdontologo().getApellidos() %></td>
                                    <td><%= h.getHoraEntrada() %></td>
                                    <td><%= h.getHoraSalida() %></td>
                                    <td class="text-center">
                                        <button class="btn btn-warning btn-sm mr-1"
                                                data-toggle="modal"
                                                data-target="#modalEditar"
                                                data-id="<%= h.getId() %>"
                                                data-entrada="<%= h.getHoraEntrada() %>"
                                                data-salida="<%= h.getHoraSalida() %>"
                                                data-odontologo="<%= h.getOdontologo().getNombre() + " " + h.getOdontologo().getApellidos() %>">
                                            <i class="fas fa-edit"></i> Editar
                                        </button>

                                        <form action="svEliminarHorario" method="POST" style="display:inline;">
                                            <input type="hidden" name="id_horario" value="<%= h.getId() %>">
                                            <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('¿Eliminar este horario?')">
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
                    <div class="alert alert-warning text-center">No hay horarios registrados.</div>
                    <% } %>
                </div>
            </div>
        </main>
    </div>

    <!-- Modal Editar Horario -->
    <div class="modal fade" id="modalEditar" tabindex="-1" role="dialog" aria-labelledby="editarModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <form action="svEditarHorario" method="POST" class="modal-content">
            <div class="modal-header bg-primary text-white">
                <h5 class="modal-title"><i class="fas fa-clock"></i> Editar Horario</h5>
                <button type="button" class="close text-white" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <input type="hidden" name="id" id="editId">
                <div class="form-group">
                    <label for="editOdontologo">Odontólogo</label>
                    <input type="text" class="form-control" id="editOdontologo" name="odontologo" disabled>
                </div>
                <div class="form-group">
                    <label for="editEntrada">Hora Entrada</label>
                    <input type="time" class="form-control" id="editEntrada" name="horaEntrada" required>
                </div>
                <div class="form-group">
                    <label for="editSalida">Hora Salida</label>
                    <input type="time" class="form-control" id="editSalida" name="horaSalida" required>
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
            $('#editOdontologo').val(button.data('odontologo'));
            $('#editEntrada').val(button.data('entrada'));
            $('#editSalida').val(button.data('salida'));
        });
    </script>
</body>
</html>
