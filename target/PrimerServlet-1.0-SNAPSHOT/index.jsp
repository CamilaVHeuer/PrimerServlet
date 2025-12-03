<%-- 
    Document   : index
    Created on : 3 dic. 2025, 10:39:16
    Author     : Camila Villalba Heuer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de prueba</title>
    </head>
    <body>
        <h1>Datos del usuario</h1>
        <form action="SvUsuarios" method="POST">
            <p><label>Dni: </label><input type="text" name="dni"></p>
            <p><label>Nombre: </label><input type="text" name="nombre"></p>
            <p><label>Apellido: </label><input type="text" name="apellido"></p>
            <p><label>Telefono: </label><input type="text" name="telefono"></p>
            <button type="submit"> Enviar</button>
        </form>
        
        <h1>Ver lista de usuarios</h1>
        <p>Para ver los datos de los usuarios cargados haga click en el sigueinte boton</p>
        <form action="SvUsuarios" method="GET">
            <button type="submit">Mostrar Usuarios</button>
        </form>
        
        
        <h1>Eliminar usuario</h1>
        <p>Ingrese el id del usuario que quiere eliminar</p>
        <form action="SvEliminar" method="POST">
            <p><label>Id: </label><input type="text" name="id_usuario"></p>   
            <button type="submit">Eliminar Usuario</button>
        </form>
    </body>
</html>
