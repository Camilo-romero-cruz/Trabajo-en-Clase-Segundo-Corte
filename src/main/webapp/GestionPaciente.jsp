<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario de pruebas</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link href="css/styles.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
    <!-- Aquí se incluye el layout del sidenav -->
    <%@include file="LAYOUT/layout-static.jsp" %>

    <div id="layoutSidenav_content">
        <main class="container bg-light py-5">
            <h1 class="display-4 text-center mb-5">Gestión de Usuarios</h1>

            <!-- Sección Principal - Formulario de Registro -->
            <div class="card shadow-lg mb-5">
                <div class="card-header bg-primary text-white">
                    <h2 class="h4 mb-0"><i class="bi bi-person-plus"></i> Datos del Usuario</h2>
                </div>
                <div class="card-body">
                    <form action="svPacientes" method="POST">
    <label for="dni">DNI:</label>
    <input type="text" name="dni" required class="form-control mb-2">

    <label for="nombre">Nombre:</label>
    <input type="text" name="nombre" required class="form-control mb-2">

    <label for="apellidos">Apellidos:</label>
    <input type="text" name="apellidos" required class="form-control mb-2">

    <label for="telefono">Teléfono:</label>
    <input type="text" name="telefono" required class="form-control mb-2">

    <button type="submit" class="btn btn-success mt-3">Guardar Paciente</button>
</form>

<!-- Botón para ver pacientes -->
<form action="svPacientes" method="GET" class="mt-3">
    <button type="submit" class="btn btn-info">Mostrar Pacientes</button>
</form>

                </div>
            </div>

    
                
        </main>
    </div>

    <!-- Scripts -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</body>
</html>
