<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Gestión de Responsables</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="sb-nav-fixed">
  <%@ include file="LAYOUT/layout-static.jsp" %>

  <div id="layoutSidenav_content">
    <main class="container py-5">
      <h1 class="text-center mb-4">Asignación de Responsables</h1>

      <div class="card mb-5">
        <div class="card-header bg-primary text-white">
          <h4 class="mb-0">Nuevo Responsable</h4>
        </div>
        <div class="card-body">
          <form action="svResponsables" method="POST">
            <div class="form-row">
              <!-- Pacientes -->
              <div class="col-md-6 mb-3">
                <label for="idPaciente">Paciente:</label>
                <select id="idPaciente" name="idPaciente" class="form-control" required>
                  <option value="">Cargando pacientes...</option>
                </select>
              </div>

              <!-- Odontólogos -->
              <div class="col-md-6 mb-3">
                <label for="idOdontologo">Odontólogo:</label>
                <select id="idOdontologo" name="idOdontologo" class="form-control" required>
                  <option value="">Cargando odontólogos...</option>
                </select>
              </div>
            </div>

            <button type="submit" class="btn btn-success">Vincular</button>
          </form>
        </div>
      </div>
    </main>
  </div>

  <script>
    // Ejecutar al cargar la página
    document.addEventListener("DOMContentLoaded", function () {
      cargarPacientes();
      cargarOdontologos();
    });

    function cargarPacientes() {
      fetch('svPacientes?tipo=ajax')
        .then(response => response.json())
        .then(data => {
          const select = document.getElementById("idPaciente");
          select.innerHTML = '<option value="">--Seleccione--</option>';

          if (data.length === 0) {
            const opt = document.createElement("option");
            opt.disabled = true;
            opt.text = "No hay pacientes disponibles";
            select.appendChild(opt);
            return;
          }

          data.forEach(paciente => {
            const option = document.createElement("option");
            option.value = paciente.id_paciente;
            option.text = paciente.nombre + " " + paciente.apellidos;
            select.appendChild(option);
          });
        })
        .catch(() => {
          const select = document.getElementById("idPaciente");
          select.innerHTML = '<option disabled>Error cargando pacientes</option>';
        });
    }

    function cargarOdontologos() {
      fetch('svOdontologo?tipo=ajax')
        .then(response => response.json())
        .then(data => {
          const select = document.getElementById("idOdontologo");
          select.innerHTML = '<option value="">--Seleccione--</option>';

          if (data.length === 0) {
            const opt = document.createElement("option");
            opt.disabled = true;
            opt.text = "No hay odontólogos disponibles";
            select.appendChild(opt);
            return;
          }

          data.forEach(odonto => {
            const option = document.createElement("option");
            option.value = odonto.id_odontologo;
            option.text = odonto.nombre + " " + odonto.apellidos;
            select.appendChild(option);
          });
        })
        .catch(() => {
          const select = document.getElementById("idOdontologo");
          select.innerHTML = '<option disabled>Error cargando odontólogos</option>';
        });
    }
  </script>
</body>
</html>
