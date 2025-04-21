<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <title>Clinica DON CESAR</title>
  <link href="css/styles.css" rel="stylesheet" />
  <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body>
  <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <a class="navbar-brand ps-3" href="index.jsp">Clinica DON CESAR</a>
    <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle">
      <i class="fas fa-bars"></i>
    </button>
    <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
      <div class="input-group">
        <input class="form-control" type="text" placeholder="Search for..."
               aria-label="Search for..." aria-describedby="btnNavbarSearch" />
        <button class="btn btn-primary" id="btnNavbarSearch" type="button">
          <i class="fas fa-search"></i>
        </button>
      </div>
    </form>
    <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button"
           data-bs-toggle="dropdown" aria-expanded="false">
          <i class="fas fa-user fa-fw"></i>
        </a>
        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
          <li><a class="dropdown-item" href="logout.jsp">Logout</a></li>
        </ul>
      </li>
    </ul>
  </nav>

  <div id="layoutSidenav">
    <div id="layoutSidenav_nav">
      <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
        <div class="sb-sidenav-menu">
          <div class="nav">
            <div class="sb-sidenav-menu-heading">Opciones</div>

            <!-- PACIENTES -->
            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
               data-bs-target="#collapsePacientes" aria-expanded="false">
              <div class="sb-nav-link-icon"><i class="fas fa-user-injured"></i></div>
              Pacientes
              <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapsePacientes" data-bs-parent="#sidenavAccordion">
              <nav class="sb-sidenav-menu-nested nav">
                <a class="nav-link ver-pacientes" href="svPacientes">Ver Pacientes</a>
                <a class="nav-link alta-pacientes" href="GestionPaciente.jsp">Alta Pacientes</a>
              </nav>
            </div>

            <!-- RESPONSABLES -->
            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
               data-bs-target="#collapseResponsables" aria-expanded="false">
              <div class="sb-nav-link-icon"><i class="fas fa-user-friends"></i></div>
              Responsables
              <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseResponsables" data-bs-parent="#sidenavAccordion">
              <nav class="sb-sidenav-menu-nested nav">
                <a class="nav-link ver-responsables" href="svResponsables">Ver Responsables</a>
                <a class="nav-link alta-responsables" href="GestionResponsables.jsp">Alta Responsables</a>
              </nav>
            </div>

            <!-- TURNOS -->
            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
               data-bs-target="#collapseTurnos" aria-expanded="false">
              <div class="sb-nav-link-icon"><i class="fas fa-calendar-alt"></i></div>
              Turnos
              <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseTurnos" data-bs-parent="#sidenavAccordion">
              <nav class="sb-sidenav-menu-nested nav">
                <a class="nav-link ver-turnos" href="#">Ver Turnos</a>
                <a class="nav-link alta-turnos" href="#">Alta Turnos</a>
              </nav>
            </div>

            <!-- HORARIOS -->
            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
               data-bs-target="#collapseHorarios" aria-expanded="false">
              <div class="sb-nav-link-icon"><i class="fas fa-clock"></i></div>
              Horarios
              <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseHorarios" data-bs-parent="#sidenavAccordion">
              <nav class="sb-sidenav-menu-nested nav">
                <a class="nav-link ver-horarios" href="svHorarios">Ver Horarios</a>
                <a class="nav-link alta-horarios" href="gestionHorarios.jsp">Asignar Horarios</a>
              </nav>
            </div>

            <!-- ODONTÓLOGOS -->
            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
               data-bs-target="#collapseOdontologos" aria-expanded="false">
              <div class="sb-nav-link-icon"><i class="fas fa-user-md"></i></div>
              Odontólogos
              <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseOdontologos" data-bs-parent="#sidenavAccordion">
              <nav class="sb-sidenav-menu-nested nav">
                <a class="nav-link ver-odontologos" href="svOdontologo">Ver Odontólogos</a>
                <a class="nav-link alta-odontologos" href="GestionOdontologo.jsp">Alta Odontólogos</a>
              </nav>
            </div>

            <!-- SECRETARIOS -->
            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
               data-bs-target="#collapseSecretarios" aria-expanded="false">
              <div class="sb-nav-link-icon"><i class="fas fa-user-tie"></i></div>
              Secretarios
              <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseSecretarios" data-bs-parent="#sidenavAccordion">
              <nav class="sb-sidenav-menu-nested nav">
                <a class="nav-link ver-secretarios" href="svSecretarios">Ver Secretarios</a>
                <a class="nav-link alta-secretarios" href="GestionSecretarios.jsp">Alta Secretarios</a>
              </nav>
            </div>

            <!-- USUARIOS -->
            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
               data-bs-target="#collapseUsuarios" aria-expanded="false">
              <div class="sb-nav-link-icon"><i class="fas fa-users"></i></div>
              Administrar Usuarios
              <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseUsuarios" data-bs-parent="#sidenavAccordion">
              <nav class="sb-sidenav-menu-nested nav">
                <a class="nav-link ver-usuarios" href="svUsuarios">Ver Usuarios</a>
                <a class="nav-link alta-usuarios" href="GestionUsuarios.jsp">Alta Usuarios</a>
              </nav>
            </div>

            
        </div>
      </nav>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
          crossorigin="anonymous"></script>
  <script src="js/scripts.js"></script>
  <script>
/*  document.addEventListener('DOMContentLoaded', function() {
      var rol = '<%= session.getAttribute("rol") != null ? session.getAttribute("rol") : "" %>';

      var permisos = {
        'ODONTOLOGO': [
          'ver-pacientes','ver-responsables','ver-turnos','ver-horarios'
        ],
        'SECRETARIO': [
          'ver-pacientes','ver-responsables','ver-turnos','ver-horarios',
          'alta-pacientes','alta-responsables','alta-turnos'
        ],
        'ADMIN': [
          'ver-pacientes','alta-pacientes',
          'ver-responsables','alta-responsables',
          'ver-turnos','alta-turnos',
          'ver-horarios','alta-horarios',
          'ver-odontologos','alta-odontologos',
          'ver-secretarios','alta-secretarios',
          'ver-usuarios','alta-usuarios'
        ]
      };

      // Oculto todos los ítems de menú anidados
      document.querySelectorAll('.sb-sidenav-menu-nested .nav-link').forEach(function(el) {
        el.style.display = 'none';
      });

      if (permisos[rol]) {
        permisos[rol].forEach(function(clase) {
          document.querySelectorAll('.' + clase).forEach(function(el) {
            el.style.display = '';
          });
        });
      } else {
        // Rol no reconocido -> muestro todo
        document.querySelectorAll('.sb-sidenav-menu-nested .nav-link').forEach(function(el) {
          el.style.display = '';
        });
      }
    });
    */
    
    
  </script>
</body>
</html>
