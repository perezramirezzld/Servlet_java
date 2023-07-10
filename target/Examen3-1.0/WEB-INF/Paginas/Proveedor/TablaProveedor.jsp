<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>
<section  id="actions" >
    <div class="buto" >
        <div class="col-md-4">
            <a href="#proveeagregar" class="btn btn-dark "
               data-toggle="modal" data-target="#proveeagregar">
                Agregar Proveedor
            </a>
        </div>
    </div>
</section>
<h1 class="mt-4">Proveedores</h1>
 <div class="img">
        <img width="450" src="Assets/Vaq.png" class="img-responsive" alt="Logo"/>
    </div>
<div class="tabla1">
    <div class="card mb-4" >
        <div class="card-header">
            <i class="fas fa-table me-1"></i>
            Tabla de Proveedores
        </div>
        <div class="card-body">
            <table class="table table-white d-block d-lg-table overflow-scroll" id="datatablesSimple">
                <thead>
                    <tr>
                        <th scope="col" class="text-center">Proveedor_Id</th>
                        <th scope="col" class="text-center">Nombre</th>
                        <th scope="col" class="text-center">Apellido_Paterno</th>
                        <th scope="col" class="text-center">Apellido_Materno</th>
                        <th scope="col" class="text-center">Telefono</th>
                        <th scope="col" class="text-center">Direccion</th>
                        <th scope="col" class="text-center">Marca</th>
                        <th scope="col" class="text-center">Editar</th>
                        <th scope="col" class="text-center">Borrar</th>
                    </tr>
                </thead>
                <tbody>
                  <c:forEach var="proveedores" items="${proveedores}" varStatus="status" >
                    <tr>
                        <td class="text-center">${proveedores.idProveedor}</td>
                        <td class="text-center">${proveedores.nombre}</td>
                        <td class="text-center">${proveedores.apellidoP}</td>
                        <td class="text-center">${proveedores.apellidoM}</td>
                        <td class="text-center">${proveedores.telefono}</td>
                        <td class="text-center">${proveedores.direccion}</td>
                        <td class="text-center">${proveedores.marca}</td>
                        <td class="align-middle text-center"><a href="${pageContext.request.contextPath}/ServletProveedor?accion=editar&idProveedor=${proveedores.idProveedor}" >
                        <i class="fa-sharp fa-solid fa-pen-to-square"></i></a></td>
                        <td class="align-middle text-center"><a href="${pageContext.request.contextPath}/ServletProveedor?accion=eliminar&idProveedor=${proveedores.idProveedor}" >
                        <i class="fa-solid fa-trash-can text-danger"></i></a></td>
                    </tr>
                  </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>