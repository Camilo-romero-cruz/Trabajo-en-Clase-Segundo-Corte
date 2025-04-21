<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clínica Odontológica Sonrisa Feliz</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link href="css/styles.css" rel="stylesheet" />
</head>
<body class="sb-nav-fixed">
    <%@include file="LAYOUT/layout-static.jsp" %>

    <div id="layoutSidenav_content">
        <main class="container py-5">
            <div class="jumbotron text-center bg-light shadow-sm">
                <h1 class="display-4 text-primary">Bienvenidos a Clinica Don Cesar</h1>
                <p class="lead">Tu salud bucal es nuestra prioridad.</p>
                <hr class="my-4">
                <p>Agenda tu cita, conoce a nuestros especialistas y descubre todos los servicios que ofrecemos.</p>
           
            </div>

            <!-- Servicios -->
            <section class="row text-center mt-5">
                <div class="col-md-4 mb-4">
                    <div class="card h-100 shadow-sm">
                        <div class="card-body">
<i class="bi bi-emoji-smile text-primary display-4 mb-3"></i>
                            <h5 class="card-title">Odontología General</h5>
                            <p class="card-text">Diagnóstico, limpieza y tratamientos generales para mantener tu sonrisa sana.</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 mb-4">
                    <div class="card h-100 shadow-sm">
                        <div class="card-body">
                            <i class="bi bi-braces text-success display-4 mb-3"></i>
                            <h5 class="card-title">Ortodoncia</h5>
                            <p class="card-text">Tratamientos con brackets tradicionales y estéticos para alinear tus dientes.</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 mb-4">
                    <div class="card h-100 shadow-sm">
                        <div class="card-body">
                            <i class="bi bi-shield-plus text-danger display-4 mb-3"></i>
                            <h5 class="card-title">Prevención</h5>
                            <p class="card-text">Controles periódicos y consejos personalizados para evitar futuras complicaciones.</p>
                        </div>
                    </div>
                </div>
            </section>

            <!-- Contacto Rápido -->
            <section class="mt-5 text-center">
                <h2 class="mb-4">¿Tienes dudas o deseas agendar por teléfono?</h2>
                <p><i class="bi bi-telephone"></i> Llámanos al: <strong>(+57)317-566-1135</strong></p>
                <p><i class="bi bi-envelope"></i> Correo: <strong>DonCesar@ClinicaDonCesar.com</strong></p>
            </section>
        </main>
    </div>

    <!-- Scripts -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</body>
</html>
