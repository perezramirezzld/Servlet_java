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
                    <div class="espacioLoco col-md-12"  id="pediModEli">
                        <form action="${pageContext.request.contextPath}/ServletPedido?accion=modificar&idPedido=${pedidos.idPedido}" method="POST">
                            <h1>Pedidos </h1>
                            <fieldset>
                                <legend><span class="number">2</span> Modificar Pedido </legend>

                                <label for="date"> Fecha de Venta</label>
                                <input type="date" name="fechaPedido" required value="${pedidos.fechaPedido}">
                                <label for="cantidad">Cantidad:</label>
                                <input type="number" name="cantidad" required value="${pedidos.cantidad}">
                                <label for="idProducto">Producto</label>
                                <select name="idProducto" required value="${pedidos.idProducto}">
                                    <optgroup label="Productos">
                                          <c:forEach var="productos" items="${productos}" varStatus="status" >
                                             <option>${productos.idProducto}-${productos.descripcion}</option>
                                          </c:forEach> 
                                    </optgroup>
                                </select>
                                <label for="idProveedor">Proveedor</label>
                                <select  name="idProveedor" required value="${pedidos.idProveedor}">
                                    <optgroup label="Proveedores">
                                       <c:forEach var="proveedores" items="${proveedores}" varStatus="status" >
                                          <option>${proveedores.idProveedor}-${proveedores.nombre}</option>
                                         </c:forEach>
                                    </optgroup>
                                </select>
                            </fieldset>
                            <button type="submit" >Guardar</button >
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
