<%@page import="com.mycompany.servlet.logica.claseUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Editar Usuario</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body class="container mt-5">
        <% claseUsuario usu = (claseUsuario) request.getSession().getAttribute("usuEditar");%>

        <div class="card shadow-lg">
            <div class="card-header bg-primary text-white">
                <h3 class="mb-0">Editar Usuario</h3>
            </div>
            <div class="card-body">
                <form action="svEditarUsuario" method="POST">
                    <input type="hidden" name="id" value="<%= usu.getId()%>">

                    <div class="row">
                        <div class="col-md-6 form-group">
                            <label for="dni">DNI</label>
                            <input type="text" class="form-control" id="dni" name="dni" 
                                   value="<%= usu.getDni()%>" required>
                        </div>
                        <div class="col-md-6 form-group">
                            <label for="nombre">Nombre</label>
                            <input type="text" class="form-control" id="nombre" name="nombre" 
                                   value="<%= usu.getNombre()%>" required>
                        </div>
                        
                        
                    </div>

                    <div class="row">
                        
                        <div class="col-md-6 form-group">
                            <label for="apellidos">Apellidos</label>
                            <input type="text" class="form-control" id="apellidos" name="apellidos" 
                                   value="<%= usu.getApellidos()%>" required>
                        </div>
                        
                        <div class="col-md-6 form-group">
                            <label for="telefono">Teléfono</label>
                            <input type="text" class="form-control" id="telefono" name="telefono" 
                                   value="<%= usu.getTelefono()%>" required>
                        </div>
                    </div>

                    <div class="mt-4 text-right">
                        <button type="submit" class="btn btn-primary btn-lg shadow-sm">
                            Guardar Cambios
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>