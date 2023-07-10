<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css'>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css'>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css'>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.4/css/tether.min.css'>
        <link rel="stylesheet" href="Styles/StylesNav.css">
        <title>LAVAQUITA</title>
    </head>
    <body>
        <div id="wrapper">
            <div class="row">
                <div class="container-md container-fluid mt-3" id="clieModEli">
                    <div class="espacioLoco col-md-12">
                        <form action="${pageContext.request.contextPath}/ServletCliente?accion=modificar&idCliente=${clientes.idCliente}" method="POST">
                            <h1>Cliente </h1>
                            <fieldset>
                                <legend><span class="number">1</span> Modificar Cliente </legend>
                                <label for="nombre">Nombre</label>
                                <input type="text" name="nombre" required value="${clientes.nombre}">
                                <label for="apellido_paterno">Apellido Paterno</label>
                                <input type="text" name="apellido_paterno" required value="${clientes.apellidoP}">
                                <label for="apellido_materno">Apellido Materno</label>
                                <input type="text" name="apellido_materno" required value="${clientes.apellidoM}">
                                <label for="tel">Telefono </label>
                                <input type="tel" name="telefono" required value="${clientes.telefono}">
                                <label for="correo">Correo</label>
                                <input type="email" name="correo" required value="${clientes.correo}">
                            </fieldset>
                            <button type="submit">Guardar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src='https://code.jquery.com/jquery-3.3.1.slim.min.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js'></script>
        <script src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.4/js/tether.min.js'></script>
        <script src="Js/Nav.js"></script>
    </body>
</html>
