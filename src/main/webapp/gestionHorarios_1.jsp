<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Gestión de Horarios</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="sb-nav-fixed">
  <%@ include file="LAYOUT/layout-static.jsp" %>

  <div id="layoutSidenav_content">
    <main class="container py-5">
      <h1 class="text-center mb-4">Asignación de Horarios</h1>

      <div class="card mb-5">
        <div class="card-header bg-primary text-white">
          <h4 class="mb-0">Nuevo Horario</h4>
        </div>
        <div class="card-body">
          <form action="svHorarios" method="POST">
            <div class="form-row">
              <!-- Odontólogos -->
              <div class="col-md-4 mb-3">
                <label for="idOdontologo">Odontólogo:</label>
                <select id="idOdontologo" name="idOdontologo" class="form-control" required>
                  <option value="">Cargando odontólogos...</option>
                </select>
              </div>
              <!-- Hora Entrada -->
              <div class="col-md-4 mb-3">
                <label for="horaEntrada">Hora Entrada:</label>
                <input type="time" id="horaEntrada" name="horaEntrada" class="form-control" required />
              </div>
              <!-- Hora Salida -->
              <div class="col-md-4 mb-3">
                <label for="horaSalida">Hora Salida:</label>
                <input type="time" id="horaSalida" name="horaSalida" class="form-control" required />
              </div>
            </div>

            <button type="submit" class="btn btn-success">Guardar Horario</button>
          </form>
        </div>
      </div>
    </main>
  </div>

  <script>
    document.addEventListener("DOMContentLoaded", function () {
      fetch('svHorarios?tipo=ajax')
        .then(response => response.json())
        .then(data => {
          const select = document.getElementById('idOdontologo');
          select.innerHTML = '<option value="">--Seleccione--</option>';
          if (!data.length) {
            const opt = document.createElement('option');
            opt.disabled = true;
            opt.text = 'No hay odontólogos disponibles';
            select.appendChild(opt);
            return;
          }
          data.forEach(o => {
            const option = document.createElement('option');
            option.value = o.id_odontologo;
            option.text = o.nombre + ' ' + o.apellidos;
            select.appendChild(option);
          });
        })
        .catch(() => {
          const select = document.getElementById('idOdontologo');
          select.innerHTML = '<option disabled>Error cargando odontólogos</option>';
        });
    });
  </script>
</body>
</html>