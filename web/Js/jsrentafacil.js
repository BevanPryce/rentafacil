/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*function generarCodigoCliente() {
  var usersDAO = new usersDAO();
  var listaUsuarios = usersDAO.listarUsuarios();
  var totalUsuarios = listaUsuarios.length + 1;
  //var formato = "0000";
  var objf = new Intl.NumberFormat('en-US', {minimumIntegerDigits: 4, useGrouping:false});
  var userId = "U" + objf.format(totalUsuarios);
  console.log("Nuevo Usuario: " + userId);
}*/

function cargarRoles(){
    // Obtener la matriz de roles
    let roles = getRoleFromDatabase();

    // Obtener el elemento select
    let select = document.getElementById("role");

    // Generar dinámicamente las opciones del select
    for (let i = 0; i < roles.length; i++) {
        let option = document.createElement("option");
        option.value = roles[i].id;
        option.text = roles[i].name;
        select.add(option);
    }
}

function propertymodal(propertyid){
    document.getElementById("campoCodigoPropiedad").value=propertyid;
    console.log("codigo propiedad js: "+propertyid);
}

function agregarInput(){
var contador = parseInt(document.getElementById("contador").value);
    if (contador < 3) {
        var input = document.createElement("div");
        input.className = "form-group";
        input.innerHTML = `
          <label for="imagen${contador + 1}">Imagen ${contador + 1}</label>
          <input type="file" class="form-control-file" name="imagen[]" id="imagen${contador + 1}" accept="image/*">
          `;
        document.getElementById("contenedorImagenes").appendChild(input);
        contador++;
        document.getElementById("contador").value = contador;
    }
      //input.innerHTML = `<input type="hidden" id="property_code" name="property_code"`;
        // Asignar el código de la propiedad al campo oculto en el formulario
        //document.getElementById("campoCodigoPropiedad").value = codigoPropiedad;
}

