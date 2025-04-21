<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <!-- Agregar enlace a Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Iniciar sesi�n</h2>
        <form action="svLogin" method="post" class="border p-4 rounded shadow-sm">
            <div class="mb-3">
                <label for="dni" class="form-label">DNI:</label>
                <input type="text" id="dni" name="dni" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="contrase�a" class="form-label">Contrase�a:</label>
                <input type="password" id="contrase�a" name="contrase�a" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-primary w-100">Iniciar sesi�n</button>
        </form>

        <c:if test="${param.error != null}">
            <div class="alert alert-danger mt-3">
                Credenciales incorrectas. Intenta nuevamente.
            </div>
        </c:if>
    </div>

    <!-- Agregar los scripts de Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
