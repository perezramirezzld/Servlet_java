<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>
<div class="modal fade" id="pediagregar">
    <div class="modal-dialog ">
        <div class="modal-content">
            <div class="modal-header bg-dark text-white">
                <h5 class="modal-title">Agregar Proveedor</h5> 
            </div>
            <div class="row"  >
                <div class="formulario container-md container-fluid mt-3">
                    <div class="col-md-12" >
                        <form action="${pageContext.request.contextPath}/ServletPedido?accion=insertar" method="POST">
                            <h1>Pedidos </h1>
                            <fieldset>
                                <legend><span class="number">1</span> Agregar Pedido </legend>

                                <label for="date"> Fecha de Pedido</label>
                                <input type="date" name="fechaPedido" required>
                                <label for="cantidad">Cantidad:</label>
                                <input type="number"  name="cantidad" required>
                                <label for="idProducto">Producto</label>
                                <select name="idProducto">
                                    <optgroup label="Productos">
                                        <c:forEach var="productos" items="${productos}" varStatus="status" >
                                            <option>${productos.idProducto}-${productos.descripcion}</option>
                                        </c:forEach> 
                                    </optgroup>
                                </select>
                                <label for="idProveedor">Proveedor</label>
                                <select  name="idProveedor">
                                    <optgroup label="Proveedores">
                                        <c:forEach var="proveedores" items="${proveedores}" varStatus="status" >
                                            <option>${proveedores.idProveedor}-${proveedores.nombre}</option>
                                        </c:forEach> 
                                    </optgroup>
                                </select>
                            </fieldset>
                            <div class="text-center"> 
                                <button type="submit">Guardar</button>
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>