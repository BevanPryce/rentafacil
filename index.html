<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Renta Facil</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>
    <link rel="stylesheet" type="text/css" href="Styles/bootstrap.css" media="all"/>
    <link rel="stylesheet" type="text/css" href="Styles/customStyle.css" media="all"/>
    <script src="Js/jsrentafacil.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url('imagenes/Fondo_principal.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            height: 100%;
            margin: 0;
            padding: 0;
            opacity: 0.8;
        }
        .modal-content h1, h5 {
            color: #20c997;
            text-align: center;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="menu">
        <nav class="navbar navbar-expand position-sticky">
            <div class="container-fluid d-flex justify-content-between align-items-center w-100">
                <div class="agile-main-top col-lg-12 align-items-center">
                    <ul class="row main-top-w3l py-2 bg-transparent">
                        <li class="col-md-2 header-most-top border-0"><a class="nav-link text-red" href="#">Home</a></li>
                        <li class="col-md-2 header-most-top border-left"><a class="nav-link text-black" href="#">Nosotros</a></li>
                        <li class="col-md-2 header-most-top border-left"><a class="nav-link text-black" href="#">Contacto</a></li>

                        <% 
                          HttpSession sesion = request.getSession();
                            if (sesion.getAttribute("id") == null) {
                        %>
                            <li class="col-md-2 header-most-top border-left"><a class="nav-link text-black" data-toggle="modal" data-target="#ventana2" href="#"><i class="fas fa-user"></i>Registrarse</a></li>
                            <li class="col-md-2 header-most-top border-left"><a class="nav-link text-black" data-toggle="modal" data-target="#ventana1" href="#"><i class="fas fa-lock"></i>Iniciar Sesión</a></li>
                        <% } else { %>
                            <li class="col-md-2 header-most-top border-left dropdown" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><b class="nav-link text-black">Bienvenido: <%= sesion.getAttribute("nombre") %></b></li>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <%
                                        if(sesion.getAttribute("rol").equals(1)){
                                            Object obj;
                                            obj = sesion.getAttribute("id").toString();
                                            System.out.println("sesion: "+obj);
                                    %>
                                    <a href="ownerController?accion=ownerPerfil&user=<%= obj %>" class="nav-link text-black"><i class="fas fa-user"></i>Perfil</a>
                                    <% 
                                        }
                                    %>
                                    <a href="#" class="nav-link text-black"><i class="fas fa-edit"></i>Actualización de Datos</a>
                                    <a href="#" class="nav-link text-black"><i class="fas fa-lock"></i>Cambio de Contraseña</a>
                                </div>
                            <li class="col-md-2 header-most-top border-left"><a class="nav-link text-black" href="loginController?accion=logout"><i class="fas fa-lock"></i>Cerrar Sesión</a></li>
                        <% } %>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <!--Modal Login -->
    <div class="modal fade" id="ventana1">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <h1>Login</h1> 
                <form action="loginController?accion=login" method="POST">
                    <div class="modal-body">
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                </div>
                                <input type="text" class="form-control" placeholder="Usuario" name="txtusuario" id="txtusuario" minlength="5" maxlength="30" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-lock"></i></span>
                                </div>
                                <input type="password" class="form-control" placeholder="Contraseña" name="txtpassword" id="txtpassword" minlength="8" maxlength="16" required>
                            </div>
                        </div>
                        <a data-dismiss="modal" data-toggle="modal" data-target="#ventana3" href="#">¿Olvidó su contraseña?</a>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary btn-block">Login</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!--Modal Registro usuario -->
    <div class="modal fade" id="ventana2">
        <div class="modal-dialog modal-dialog-centered modal-lg">
            <div class="modal-content">
                <form action="userController?accion=newUser" method="POST">
                    <div class="modal-header bg-primary text-white">
                        <h5 class="modal-title">Nuevo Usuario</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Cerrar">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="user_first_name">Nombre</label>
                                <input type="text" placeholder="Ingrese su nombre" name="user_first_name" id="user_first_name" class="form-control">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="user_last_name_1">Apellido Paterno</label>
                                <input type="text" placeholder="Ingrese su apellido paterno" name="user_last_name_1" id="user_last_name_1" class="form-control">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="user_last_name_2">Apellido Materno</label>
                                <input type="text" placeholder="Ingrese su apellido materno" name="user_last_name_2" id="user_last_name_2" class="form-control">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="user_doi">Documento Identidad</label>
                                <input type="text" placeholder="Ingrese su documento de identidad" name="user_doi" id="user_doi" class="form-control">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="user_email">E-mail</label>
                                <input type="text" placeholder="Ingrese su dirección" name="user_email" id="user_email" class="form-control">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="user_pwd">Contraseña</label>
                                <input type="password" placeholder="Contraseña" name="user_pwd" id="user_pwd" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="role">Rol</label>
                            <select id="role" class="form-control-sm" name="role_id">
                                <option value="1">Propietario</option>
                                <option value="2">Visitante</option>
                            </select>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary">Agregar</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!--Modal Recuperar contraseña-->
    <div class="modal fade" id="ventana3">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <form action="Control?accion=x" method="POST">
                    <div class="modal-header">
                        <h5 class="modal-title">Recuperar contraseña</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Cerrar">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="dni">DNI</label>
                            <input type="text" class="form-control" id="dni" placeholder="Ingrese su DNI" name="dni" required>
                        </div>
                        <div class="form-group">
                            <label for="email">Correo electrónico</label>
                            <input type="email" class="form-control" id="email" placeholder="Ingrese su correo electrónico" name="email" required>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary">Enviar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="contenido">
        <form id="frm-search" action="propertyController?accion=buscar_propiedad" method="post">
            <label for="search"></label><input id="search" type="text" placeholder="Buscar...">
          <br>
          <button id="search-button"><i class="fas fa-search"></i></button>
        </form>        
    </div>
    <div class="footer">
        <p style="font-size: 36px">Derechos reservados &copy; 2023</p>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
