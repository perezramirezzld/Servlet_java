<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>
<div class="modal fade" id="producagregar">
    <div class="modal-dialog ">
        <div class="modal-content">
            <div class="modal-header bg-dark text-white">
                <h5 class="modal-title">Agregar Proveedor</h5> 
            </div>
            <div class="row">
                <div class="container-md container-fluid mt-3">
                    <div class="col-md-12">
                        <form action="${pageContext.request.contextPath}/ServletProducto?accion=insertar" method="POST">
                            <h1>Producto</h1>
                            <fieldset>
                                <legend><span class="number">1</span> Agregar Producto </legend>
                                <label for="descripcion">Descripcion</label>
                                <input type="text" name="descripcion" required>
                                <label for="precio">Precio </label>
                                <input type="number" name="precio" required>
                                <label for="cantidad">Cantidad: </label>
                                <input type="number" name="cantidad" required>
                                <label for="idProveedor">Id Proveedor</label>
                                <select name="idProveedor">
                                    <optgroup label="Proveedor">
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