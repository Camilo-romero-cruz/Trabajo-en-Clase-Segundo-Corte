    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.util.List" %>
    <%@ page import="com.mycompany.servlet.logica.claseSecretario" %>
    <%@ page import="com.mycompany.servlet.logica.claseOdontologo" %>
    <!DOCTYPE html>
    <html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Gestión de Usuarios</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    </head>
    <body class="sb-nav-fixed">
        <%@ include file="LAYOUT/layout-static.jsp" %>
        <div id="layoutSidenav_content">
            <main class="container bg-light py-5">
                <h1 class="display-4 text-center mb-5">Gestión de Usuarios</h1>

                <div class="card shadow-lg mb-5">
                    <div class="card-header bg-primary text-white">
                        <h2 class="h4 mb-0"><i class="bi bi-person-plus"></i> Datos del Usuario</h2>
                    </div>
                    <div class="card-body">
                        <form action="svUsuarios" method="POST">
                            <div class="row">
                                <!-- Datos básicos -->
                                <div class="col-md-6">
                                    <label for="dni">DNI:</label>
                                    <input type="text" id="dni" name="dni" required class="form-control mb-2">

                                    <label for="nombre">Nombre:</label>
                                    <input type="text" id="nombre" name="nombre" required class="form-control mb-2">

                                    <label for="apellidos">Apellidos:</label>
                                    <input type="text" id="apellidos" name="apellidos" required class="form-control mb-2">

                                    <label for="telefono">Teléfono:</label>
                                    <input type="text" id="telefono" name="telefono" required class="form-control mb-2">

                                    <label for="contrasena">Contraseña:</label>
                                    <input type="password" id="contrasena" name="contrasena" required class="form-control mb-2">
                                </div>

                                <!-- Selección de rol y persona -->
                                <div class="col-md-6">
                                    <label for="rol">Rol:</label>
                                    <select id="rol" name="rol" required class="form-control mb-2" onchange="mostrarBotonCargar()">
                                        <option value="">Seleccione un rol</option>
                                        <option value="ODONTOLOGO">Odontólogo</option>
                                        <option value="SECRETARIO">Secretario</option>
                                    </select>

                                    <!-- Botones dinámicos -->
                                    <div id="botonCargarOdonto" style="display:none;" class="mb-2">
                                        <a id="btnCargarOdonto" class="btn btn-info btn-block" onclick="cargarOdontologos()">Cargar Datos</a>
                                    </div>

                                    <div id="botonCargarSecretario" style="display:none;" class="mb-2">
                                        <a id="btnCargarSecretario" class="btn btn-info btn-block" onclick="cargarSecretarios()">Cargar Datos</a>
                                    </div>

                                    <!-- Segundo select -->
                                    <div id="grupoPersona" style="display:none;">
                                        <label for="persona">Seleccione la persona:</label>
                                        <select id="persona" name="idPersona" class="form-control mb-2">
                                            <!-- Se llena con JS -->
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <button type="submit" class="btn btn-primary btn-block mt-3">
                                Guardar Usuario
                            </button>
                        </form>
                    </div>
                </div>
            </main>
        </div>

        <!-- Scripts -->
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script>
        // Función para mostrar el botón de cargar datos si se selecciona "Odontólogo" o "Secretario"
        function mostrarBotonCargar() {
            var rol = document.getElementById("rol").value;
            var botonCargarOdonto = document.getElementById("botonCargarOdonto");
            var botonCargarSecretario = document.getElementById("botonCargarSecretario");
            var grupoPersona = document.getElementById("grupoPersona");

            if (rol === "ODONTOLOGO") {
                botonCargarOdonto.style.display = "block";
                botonCargarSecretario.style.display = "none";
                grupoPersona.style.display = "block";
            } else if (rol === "SECRETARIO") {
                botonCargarOdonto.style.display = "none";
                botonCargarSecretario.style.display = "block";
                grupoPersona.style.display = "block";
            } else {
                botonCargarOdonto.style.display = "none";
                botonCargarSecretario.style.display = "none";
                grupoPersona.style.display = "none";
            }
        }

        // Función para cargar odontólogos con AJAX
        function cargarOdontologos() {
            fetch('svOdontologo?tipo=ajax')
                .then(response => response.json())
                .then(data => {
                    const select = document.getElementById("persona");
                    select.innerHTML = ""; // Limpiar opciones anteriores

                    data.forEach(odonto => {
                        const option = document.createElement("option");
                        option.value = odonto.id_odontologo; // O el ID que uses
                        option.text = odonto.nombre + " " + odonto.apellidos;
                        select.appendChild(option);
                    });
                });
        }

        // Función para cargar secretarios con AJAX
        function cargarSecretarios() {
            fetch('svSecretarios?tipo=ajax')
                .then(response => response.json())
                .then(data => {
                    const select = document.getElementById("persona");
                    select.innerHTML = ""; // Limpiar opciones anteriores

                    data.forEach(secretario => {
                        const option = document.createElement("option");
                        option.value = secretario.id_secretario; // O el ID que uses
                        option.text = secretario.nombre + " " + secretario.apellidos;
                        select.appendChild(option);
                    });
                });
        }
        </script>
    </body>
    </html>
