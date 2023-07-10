<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>
<section  id="actions" >
    <div class="buto" >
        <div class="col-md-4">
            <a href="#pediagregar" class="btn btn-dark "
               data-toggle="modal" data-target="#pediagregar">
                Agregar Pedido
            </a>
        </div>
    </div>
</section>
<h1 class="mt-4">Pedidos</h1>
 <div class="img">
        <img width="450" src="Assets/Vaq.png" class="img-responsive" alt="Logo"/>
    </div>
<div class="tabla1">
    <div class="card mb-4" >
        <div class="card-header">
            <i class="fas fa-table me-1"></i>
            Tabla de Pedidos
        </div>
        <div class="card-body">
            <table class="table table-white d-block d-lg-table overflow-scroll" id="datatablesSimple">
                <thead>
                    <tr>
                       <th scope="col" class="text-nowrap">Pedido_Id</th>
                      <th scope="col" class="text-nowrap">Fecha_pedido</th>
                      <th scope="col" class="text-nowrap">Cantidad</th>
                      <th scope="col" class="text-nowrap">Producto_Id</th>
                      <th scope="col" class="text-nowrap">Proveedor_Id</th>
                      <th scope="col" class="text-center">Editar</th>
                      <th scope="col" class="text-center">Borrar</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <!-- Iteramos cada elemento de la lista de ventas -->
                <c:forEach var="pedidos" items="${pedidos}" varStatus="status" >
                    <tr>
                        <td class="text-center">${pedidos.idPedido}</td>
                        <td >${pedidos.fechaPedido}</td>
                        <td class="text-center">${pedidos.cantidad}</td>
                        <td >${pedidos.idProducto}</td>
                        <td>${pedidos.idProveedor}</td>
                        <td class="align-middle text-center"><a href="${pageContext.request.contextPath}/ServletPedido?accion=editar&idPedido=${pedidos.idPedido}">
                        <i class="fa-sharp fa-solid fa-pen-to-square"></i></a>
                        <td class="align-middle text-center"><a href="${pageContext.request.contextPath}/ServletPedido?accion=eliminar&idPedido=${pedidos.idPedido}">
                        <i class="fa-solid fa-trash-can text-danger"></i></a></td>
                    </tr>
                </c:forEach>
            </tbody>
            </table>
        </div>
    </div>
</div>