<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.servlet.logica.claseTurno" %>
<%@ page import="com.mycompany.servlet.logica.claseOdontologo" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Turnos</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="sb-nav-fixed">
    <%@ include file="LAYOUT/layout-static.jsp" %>
    <div id="layoutSidenav_content">
        <main class="container bg-light py-5">
            <h1 class="display-4 text-center mb-5">Turnos Registrados</h1>
            <div class="card shadow mb-5">
                <div class="card-header bg-primary text-white">
                    <h2 class="h5 mb-0">Turnos</h2>
                </div>
                <div class="card-body">
                    <%
                      List<claseTurno> lista = (List<claseTurno>) session.getAttribute("listaTurnos");
                      if (lista != null && !lista.isEmpty()) {
                    %>
                    <table class="table table-striped table-bordered">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Odontólogo</th>
                                <th>Fecha</th>
                                <th>Hora Inicio</th>
                                <th>Hora Salida</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                        <%
                          int i = 1;
                          for (claseTurno t : lista) {
                              claseOdontologo o = t.getOdontologo();
                        %>
                            <tr>
                                <td><%= i++ %></td>
                                <td><%= o.getNombre() %> <%= o.getApellidos() %></td>
                                <td><%= t.getFecha() %></td>
                                <td><%= t.getHoraInicio() %></td>
                                <td><%= t.getHoraSalida() %></td>
                                <td>
                                  <form action="svEliminarTurno" method="POST" style="display:inline;">
                                      <input type="hidden" name="idTurno" value="<%= t.getId() %>" />
                                      <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('¿Eliminar este turno?')">Eliminar</button>
                                  </form>
                                </td>
                            </tr>
                        <%
                          }
                        %>
                        </tbody>
                    </table>
                    <% } else { %>
                    <div class="alert alert-warning">No hay turnos registrados.</div>
                    <% } %>
                </div>
            </div>
        </main>
    </div>
</body>
</html>