<%-- 
    Document   : perfil_propietarios
    Created on : 03/05/2023, 10:25:35 PM
    Author     : mrang
--%>

<%@page import="modelo.Propiedad"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Renta Facil</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>
    <link rel="stylesheet" type="text/css" href="Styles/bootstrap.css" media="all"/>
    <script type="text/javascript" src="Js/jsrentafacil.js"></script> 
    <style>
    /* Estilos para el menú horizontal */
    html{
        height: 90%;
        margin: 0;
        padding: 0;
    }
    body {
        background-image: url('imagenes/Fondo_principal.jpg');
        background-size: cover;
        background-repeat: no-repeat;
        height: 100%;
        margin: 0;
        padding: 0;
        opacity: 0.8;
    }
    .contenido{
        height: 75%;
        justify-content: center;
        align-items: center;
    }
    .footer{
        height: 5%;
        margin: 30px;
        text-align: center;
        font-variant: historical-ligatures;
    }
    nav {
        height: 50px;
        display: flex;
        justify-content: center;
        align-items: center;
        padding: 0 20px;
    }
    
    tbody{
        background-color: whitesmoke;
        font-size: 14px;
        font-style: normal;
        color:#004085;
    }
    .menu{
        height: 8%;
        background-color: #666666;
    }
    nav ul {
      list-style: none;
      justify-content: center;
      display: flex;
      margin: 0;
      padding: 0;
    }
    nav li {
      margin: 0 5px;
    }
    nav a {
      color: darkslategray;
      text-align: center;
      text-decoration: none;
      font-weight: bold;
      font-size: 32px;
      transition: color 0.3s ease-in-out;
    }
    nav a:hover {
      color: #f00;
    }
    /* Estilos para el contenido */
    .contenido-1 .contenido-2{
        display:block;
        justify-content: flex-start;
        padding-top: 10px;
    }
        .datos-propietario {
      background-color: silver;
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
      margin-bottom: 20px;
      opacity: 0.95;
    }

    .datos-propietario p {
      font-size: 24px;
      font-weight: bold;
      margin-bottom: 10px;
    }

    .datos-propietario .datos {
      font-size: 18px;
      font-weight: bold;
      margin-bottom: 10px;
    }

    .datos-propietario table {
      width: 100%;
    }

    .datos-propietario td {
      padding: 10px;
    }

    .datos-propietario label {
      display: block;
      font-weight: bold;
      margin-bottom: 5px;
    }

    .datos-propietario input[type="text"] {
      width: 100%;
      padding: 10px;
      border-radius: 5px;
      border: none;
      box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.2);
      margin-bottom: 10px;
    }

    .datos-propietario a.btn-warning {
      background-color: #ffc107;
      color: #fff;
      padding: 10px 20px;
      border-radius: 5px;
      text-decoration: none;
      transition: all 0.3s ease;
    }

    .datos-propietario a.btn-warning:hover {
      background-color: #ff9800;
      color: #fff;
    }
    .lista-propiedades{
        align-items: flex-start;
    }
    .datos{
        font-size: 32px;
        padding: 15px;
    }
    .lista{
        font-size: 32px;
        padding: 15px;
    }
    /* Estilos para el campo de búsqueda */
    #frm-search {
      display: flex;
      justify-content: center;
      align-items: center;
      margin-top: 90px;
    }
    #search {
      width: 700px;
      padding: 5px;
      justify-content: center;
      border-radius: 5px 0 0 5px;
      border: none;
      outline: none;
      font-size: 22px;
      background-color: lightgray;
      margin: 180px 0;
    }
    #search-button {
      background-color: #f00;
      color: #fff;
      border: none;
      border-radius: 0 5px 5px 0;
      padding: 10px 20px;
      cursor: pointer;
      transition: background-color 0.3s ease-in-out;
    }
    #search-button:hover {
      background-color: #222;
    }
  </style>
</head>
<body>
    <div class="menu">
        <nav class="navbar navbar-expand position-sticky">
            <div class="container-fluid d-flex justify-content-between align-items-center w-100"> 
                <div class="agile-main-top col-lg-12 align-items-center">
                    <ul class="row main-top-w3l py-2 bg-transparent">
                        <li class="col-md-2 header-most-top border-0"><a class="nav-link text-black" href="#">Home</a></li>
                        <li class="col-md-2 header-most-top border-left"><a class="nav-link text-black" href="#">Nosotros</a></li>
                        <li class="col-md-2 header-most-top border-left"><a class="nav-link text-black" href="#">Contacto</a></li>
                        <%
                           HttpSession sesion = request.getSession();
                        %>
                        <li class="col-md-2 header-most-top border-left"><a class="nav-link text-black" data-toggle="modal" data-target="#ventana2" href="#"><i class="fas fa-user"></i> Usuario: <%= sesion.getAttribute("id")%></a></li>
                        <li class="col-md-2 header-most-top border-left"><a class="nav-link text-black" href="loginController?accion=logout"><i class="fas fa-lock"></i>Cerrar Sesión</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <%
        String mensaje = (String) request.getAttribute("mensaje");
        %>
    <script>
        alert("<%= mensaje %>");
    </script>        
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-4">
                <div class="contenido-1">
                    <div class="datos-propietario">
                        <h2>Bienvenido<br> <%= request.getAttribute("full_name") %></h2>
                        <h3 class="datos">Información para contacto</h3>
                        <div class="form-datos-propietario">
                            <form action="ownerController?accion=ownerUPD" method="POST">
                                <div class="form-group">
                                    <label for="codigo">Codigo de Propietario</label>
                                    <input type="text" class="form-control" id="owner_id" name="owner_id" value="<%= request.getAttribute("ownerid") %>" readonly="yes" >
                                    <input type="hidden" id="user_id" name="user_id" value="<%= sesion.getAttribute("id") %>">
                                </div>
                                <div class="form-group">
                                    <label for="nombre">Nombre completo</label>
                                    <input type="text" class="form-control" id="fullname" name="full_name" placeholder="Nombre completo" value="<%= sesion.getAttribute("fullname").toString() %>" readonly="yes" >
                                </div>
                                <div class="form-group">
                                    <label for="direccion">Dirección</label>
                                    <input type="text" class="form-control" id="owner_address" name="owner_address" placeholder="Dirección" value="<%= request.getAttribute("address") %>" >
                                </div>
                                <div class="form-group">
                                    <label for="telefono">Teléfono</label>
                                    <input type="text" class="form-control" id="owner_phone" name="owner_phone" placeholder="Teléfono" value="<%= request.getAttribute("phone") %>" >
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-warning">Actualizar datos</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-8">
                <div class="contenido-2">
                    <div class="lista-propiedades">
                        <h2 class="lista">Propiedades registradas</h2>
                        <button class="btn btn-primary" data-toggle="modal" data-target="#nuevoRegistroModal">Agregar Propiedad</button>
                        <!--button class="btn btn-dark" data-toggle="modal" data-target="#repositorioImagenesModal">Agregar Imagenes</button-->
                    </div>
                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">ID PROPIETARIO</th>
                                    <th scope="col">DIRECCION</th>
                                    <th scope="col">DISTRITO</th>
                                    <th scope="col">DEPARTAMENTO</th>
                                    <th scope="col">TIPO</th>
                                    <th scope="col">CANTIDAD DE HABITACIONES</th>
                                    <th scope="col">BAÑO COMPARTIDO</th>
                                    <th scope="col">COCINA</th>
                                    <th scope="col">SALA</th>
                                    <th scope="col">AFORO</th>
                                    <th scope="col">ACEPTA MASCOTA</th>
                                    <th scope="col">AREA CONSTRUIDA</th>
                                    <th scope="col">PRECIO DE RENTA</th>
                                    <th scope="col">DESCRIPCION</th>
                                    <th scope="col">ESTADO</th>
                                    <th scope="col">ACCION</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% 
                                    ArrayList<Propiedad>lista = (ArrayList<Propiedad>)request.getAttribute("listapropiedades");
                                    for(int z=0; z<lista.size();z++){
                                %>
                                <tr>
                                    <td><%= lista.get(z).getProperty_id() %></td>
                                    <td><%= lista.get(z).getOwner_id() %></td>
                                    <td><%= lista.get(z).getProperty_address() %></td>
                                    <td><%= lista.get(z).getProperty_district() %></td>
                                    <td><%= lista.get(z).getProperty_department() %></td>
                                    <td><%= lista.get(z).getType_id() %></td>
                                    <td><%= lista.get(z).getProperty_room_qty() %></td>
                                    <td><%= lista.get(z).getProperty_shared_bathroom() %></td>
                                    <td><%= lista.get(z).getProperty_kitchen_room() %></td>
                                    <td><%= lista.get(z).getProperty_living_room() %></td>
                                    <td><%= lista.get(z).getProperty_capacity() %></td>
                                    <td><%= lista.get(z).getProperty_pet_friendly() %></td>
                                    <td><%= lista.get(z).getProperty_buil_area() %></td>
                                    <td><%= lista.get(z).getProperty_rent_price() %></td>
                                    <td><%= lista.get(z).getProperty_description() %></td>
                                    <td><%= lista.get(z).getProperty_state() %></td>
                                    <!--td><a href="#" class="btn btn-dark" data-toggle="modal" data-target="#repositorioImagenesModal" data-codigo-propiedad="<!--%= lista.get(z).getProperty_id() %>">Agregar Imágenes</a></td-->
                                    <td><a href="#" class="btn btn-dark" data-toggle="modal" data-target="#repositorioImagenesModal" onclick="propertymodal('<%= lista.get(z).getProperty_id() %>')">Agregar Imágenes</a></td>
                                </tr>
                                <%
                                    }
                                %>
                            </tbody>
                        </table>
                    </div>
                </div>
            <!-- Modal: Registro de propiedades-->
                <div class="modal fade" id="nuevoRegistroModal" tabindex="-1" role="dialog" aria-labelledby="nuevoRegistroModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="nuevoRegistroModalLabel">Nueva Propiedad</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form action="propertyController?accion=addProperty" method="POST">
                                    <div class="form-row">
                                        <!--div class="form-group col-md-6">
                                            <label for="id">ID</label>
                                            <input type="text" class="form-control" id="property_id" name="property_id" required>
                                        </div-->
                                        <div class="form-group">
                                            <label for="idPropietario">ID PROPIETARIO</label>
                                            <input type="text" class="form-control" id="owner_id" name="owner_id" value="<%= request.getAttribute("ownerid") %>" required readonly="yes">
                                            <input type="hidden" id="fullname" name="full_name" value="<%= request.getAttribute("full_name") %>">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group">
                                            <label for="direccion">DIRECCIÓN</label>
                                            <input type="text" class="form-control" id="propery_address" name="propery_address" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="distrito">DISTRITO</label>
                                            <select id="property_district" class="form-control-sm" name="property_district">
                                                <option>Seleccione</option>
                                                <option value="1">La Perla</option>
                                            </select>
                                            <!input type="text" class="form-control" id="property_district" name="property_district" required>
                                        
                                            <label for="departamento">DEPARTAMENTO</label>
                                            <select id="property_department" class="form-control-sm" name="property_department">
                                                <option>Seleccione</option>
                                                <option value="1">Callao</option>
                                            </select>
                                            <!input type="text" class="form-control" id="propery_department" name="propery_department" required>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group">
                                            <label for="tipo">TIPO</label>
                                            <select id="type_id" class="form-control-sm" name="type_id">
                                                <option>Seleccione</option>
                                                <option value="1">Casa</option>
                                                <option value="2">Departamento</option>
                                                <option value="3">Minidepartamento</option>
                                                <option value="4">Local Comercial</option>
                                            </select>
                                            <!input type="text" class="form-control" id="type_id" name="type_id" required>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group">
                                            <label for="cantidadHabitaciones">CANTIDAD DE HABITACIONES</label>
                                            <input type="number" min="1" class="form-control" id="propery_room_qty" name="propery_room_qty" required>
                                        </div>
                                    </div>
                                    <div class="form-check">
                                        <div class="form-group">
                                            <label for="banoCompartido">BAÑO COMPARTIDO</label>
                                            <input type="radio" class="form-control-sm" id="option1" name="property_shared_room" value="Si" checked="true"><label for="option1"> Sí  </label>
                                            <input type="radio" class="form-control-sm" id="option2" name="property_shared_room" value="No"><label for="option2"> No </label>
                                        </div>
                                    </div>
                                    <div class="form-check">
                                        <div class="form-group">
                                            <label for="cocina">COCINA</label>
                                            <input type="radio" class="form-control-sm" id="option1" name="property_kitchen_room" checked="true" value="Si"><label for="option1"> Sí  </label>
                                            <input type="radio" class="form-control-sm" id="option2" name="property_kitchen_room" value="No"><label for="option2"> No  </label>
                                        </div> 
                                    </div>
                                    <div class="form-check">
                                        <div class="form-group">
                                            <label for="sala">SALA</label>
                                            <input type="radio" class="form-control-sm" id="option1" name="property_living_room" checked="true" value="Si"><label for="option1"> Sí  </label>
                                            <input type="radio" class="form-control-sm" id="option2" name="property_living_room" value="No"><label for="option2"> No  </label>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group">
                                            <label for="aforo">AFORO</label>
                                            <input type="number" min="1" max="5" class="form-control" id="property_capacity" name="property_capacity" required>
                                        </div>
                                    </div>
                                    <div class="form-check">
                                        <div class="form-group">
                                            <label for="aceptaMascota">ACEPTA MASCOTA</label>
                                            <input type="radio" class="form-control-sm" id="option1" name="property_pet_friendly" checked="true" value="Si"><label for="option1"> Sí  </label>
                                            <input type="radio" class="form-control-sm" id="option2" name="property_pet_friendly" value="No"><label for="option2"> No  </label>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group">
                                            <label for="areaConstruida">ÁREA CONSTRUIDA</label>
                                            <input type="text" class="form-control" id="property_build_area" name="property_build_area" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="precioRenta">PRECIO DE RENTA</label>
                                            <input type="text" class="form-control" id="property_rent_price" name="property_rent_price" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="descripcion">DESCRIPCIÓN</label>
                                            <input type="text" class="form-control" id="property_description" name="property_description" required>
                                        </div>
                                    </div>
                                    <div class="form-check">
                                        <div class="form-group">
                                            <label for="estado">ESTADO</label>
                                            <input type="radio" class="form-control-sm" id="option1" name="property_state" checked="true" value="Disponible"><label for="option1"> Disponible  </label>
                                            <input type="radio" class="form-control-sm" id="option2" name="property_state" value="No Disponible"><label for="option2"> No Disponible  </label>                                            
                                        </div>
                                    </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                    <button type="submit" class="btn btn-primary">Guardar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!--Modal: Repositorio de imagenes -->
            <div class="modal fade" id="repositorioImagenesModal" tabindex="-1" role="dialog" aria-labelledby="repositorioImagenesModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="nuevoRegistroModalLabel">Registrar imagenes</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="propertyImgController?accion=addImgProperty" method="POST" enctype="multipart/form-data">
                                <div class="form-group">
                                <label for="imagen1">Imagen 1</label>
                                <input type="hidden" id="contador" value="1">
                                <input type="file" class="form-control-file" name="imagen[]" id="imagen1" accept="image/*" size="10240" required>
                                </div>
                                <div id="contenedorImagenes"></div>
                                <button type="button" class="btn btn-primary mt-3" onclick="agregarInput()">Agregar más imágenes</button>
                                <input type="hidden" name="property_code" id="campoCodigoPropiedad">
                                <button type="submit" class="btn btn-success mt-3">Guardar</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
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
