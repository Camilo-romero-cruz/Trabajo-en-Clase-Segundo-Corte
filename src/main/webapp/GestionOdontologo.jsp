<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestión de Odontólogos</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="sb-nav-fixed">
<%@include file="LAYOUT/layout-static.jsp" %>

<div id="layoutSidenav_content">
    <main class="container bg-light py-5">
        <h1 class="display-4 text-center mb-5">Gestión de Odontólogos</h1>

        <div class="card shadow mb-5">
            <div class="card-header bg-primary text-white">
                <h2 class="h5 mb-0">Registrar nuevo odontólogo</h2>
            </div>
            <div class="card-body">
                <form action="svOdontologo" method="POST">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="dni">DNI</label>
                            <input type="text" id="dni" name="dni" class="form-control" required>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="nombre">Nombre</label>
                            <input type="text" id="nombre" name="nombre" class="form-control" required>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="apellidos">Apellidos</label>
                            <input type="text" id="apellidos" name="apellidos" class="form-control" required>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="telefono">Teléfono</label>
                            <input type="text" id="telefono" name="telefono" class="form-control" required>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="especialidad">Especialidad</label>
                            <input type="text" id="especialidad" name="especialidad" class="form-control" required>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary btn-block">Guardar Odontólogo</button>
                    
                 

                </form>.
                   <form action="svOdontologo" method="GET" class="mt-3">
    <button type="submit" class="btn btn-info">Mostrar Pacientes</button>
</form>
            </div>
        </div>
    </main>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
