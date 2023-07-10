<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>
<div class="modal fade" id="ventaagregar">
    <div class="modal-dialog ">
        <div class="modal-content">
            <div class="modal-header bg-dark text-white">
                <h5 class="modal-title">Agregar Ventas</h5> 
            </div>
            <div class="row" >
                <div class="container-md container-fluid mt-3">
                    <div class="espacioLoco2 col-md-12" >

                        <form action="${pageContext.request.contextPath}/ServletVenta?accion=insertar" method="POST">
                            <h1>Ventas </h1>
                            <fieldset>
                                <legend><span class="number">1</span> Agregar Venta </legend>

                                <label for="date"> Fecha de Venta</label>
                                <input type="date" name="fecha_venta" required>

                                <label for="cliente">Cliente</label>
                                <select name="cliente_id">
                                    <optgroup label="Clientes">
                                        <c:forEach var="clientes" items="${clientes}" varStatus="status" >
                                            <option>${clientes.idCliente}-${clientes.nombre}</option>
                                        </c:forEach> 
                                    </optgroup>
                                </select>
                                <label for="producto">Producto</label>
                                <select  name="producto_id">
                                    <optgroup label="Productos">
                                        <c:forEach var="productos" items="${productos}" varStatus="status" >
                                            <option value="${productos.idProducto}">${productos.idProducto}-${productos.descripcion}</option>
                                        </c:forEach> 
                                    </optgroup>
                                </select>

                                <label for="cantidad">Cantidad:</label>
                                <input type="number"  name="cantidad" required >
                                <h4>${Error}</h4>

                            </fieldset>
                            <div class="text-center"> 
                            <button type="submit">Guardar</button>
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>