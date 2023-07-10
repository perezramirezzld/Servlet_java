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
                <div class="formulario container-md container-fluid mt-3" >
                    <div class="espacioLoco col-md-12"  id="ventaModEli">
                        <form action="${pageContext.request.contextPath}/ServletVenta?accion=modificar&idVenta=${ventas.idVenta}" method="POST">
                            <h1>Ventas </h1>
                            <fieldset>
                                <legend><span class="number">2</span> Modificar Venta </legend>

                                <label for="date"> Fecha de Venta</label>
                                <input type="date" name="fecha_venta" required value="${ventas.fechaVenta}">

                                <label for="cliente">Cliente</label>
                                <select name="cliente_id" required value="${ventas.idCliente}">
                                    <optgroup label="Clientes">
                                        <c:forEach var="clientes" items="${clientes}" varStatus="status" >
                                            <option>${clientes.idCliente}-${clientes.nombre}</option>
                                        </c:forEach> 
                                    </optgroup>
                                </select>
                                <label for="producto">Producto</label>
                                <select  name="producto_id" required value="${ventas.idProducto}">
                                    <optgroup label="Productos">
                                        <c:forEach var="productos" items="${productos}" varStatus="status" >
                                            <option value="${productos.idProducto}">${productos.idProducto}-${productos.descripcion}</option>
                                        </c:forEach> 
                                    </optgroup>
                                </select>

                                <label for="cantidad">Cantidad:</label>
                                <input type="number" name="cantidad" required value="${ventas.cantidad}">

                                
                            </fieldset>


                            <button type="submit" >Guardar</button >
                            <button type="button" class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletVenta">Cancelar</button>

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
