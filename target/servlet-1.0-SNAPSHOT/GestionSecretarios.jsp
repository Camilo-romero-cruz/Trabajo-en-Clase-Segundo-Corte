<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro de Secretarios</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body class="sb-nav-fixed">

    <%@include file="LAYOUT/layout-static.jsp" %>

    <div id="layoutSidenav_content">
        <main class="container bg-light py-5">
            <h1 class="display-4 text-center mb-5">Registrar Secretario</h1>

            <div class="card shadow-lg">
                <div class="card-header bg-primary text-white">
                    <h2 class="h4 mb-0"><i class="bi bi-person-plus-fill"></i> Datos del Secretario</h2>
                </div>
                <div class="card-body">
                    <form action="svSecretarios" method="POST">
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label for="dni">DNI:</label>
                                <input type="text" id="dni" name="dni" required class="form-control mb-3">

                                <label for="nombre">Nombre:</label>
                                <input type="text" id="nombre" name="nombre" required class="form-control mb-3">

                                <label for="apellidos">Apellidos:</label>
                                <input type="text" id="apellidos" name="apellidos" required class="form-control mb-3">
                            </div>

                            <div class="col-md-6 form-group">
                                <label for="telefono">Teléfono:</label>
                                <input type="text" id="telefono" name="telefono" required class="form-control mb-3">

                                <label for="sector">Sector:</label>
                                <input type="text" id="sector" name="sector" required class="form-control mb-3">
                            </div>
                        </div>

                        <button type="submit" class="btn btn-primary btn-block mt-4">
                            Guardar Secretario
                        </button>
                    </form>
                </div>
            </div>
        </main>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
