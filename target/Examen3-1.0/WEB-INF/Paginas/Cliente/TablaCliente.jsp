<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>
<section  id="actions" >
    <div class="buto" >
        <div class="col-md-4">
            <a href="#clieagregar" class="btn btn-dark "
               data-toggle="modal" data-target="#clieagregar">
                Agregar Cliente
            </a>
        </div>
    </div>
</section>
<h1 class="mt-4">Cliente</h1>
 <div class="img">
        <img width="450" src="Assets/Vaq.png" class="img-responsive" alt="Logo"/>
    </div>
<div class="tabla1">
    <div class="card mb-4" >
        <div class="card-header">
            <i class="fas fa-table me-1"></i>
            Tabla de Clientes
        </div>
        <div class="card-body">
            <table class="table table-white d-block d-lg-table overflow-scroll" id="datatablesSimple">
                <thead>
                    <tr>
                        <th scope="col" class="text-center">Cliente_Id</th>
                        <th scope="col" class="text-center">Nombre</th>
                        <th scope="col" class="text-center">Apellido_Paterno</th>
                        <th scope="col" class="text-center">Apellido_Materno</th>
                        <th scope="col" class="text-center">Telefono</th>
                        <th scope="col" class="text-center">Correo</th>
                        <th scope="col" class="text-center">Editar</th>
                        <th scope="col" class="text-center">Borrar</th>
                    </tr>
                </thead>
                <tbody>
                  <c:forEach var="clientes" items="${clientes}" varStatus="status" >
                    <tr>
                        <td class="text-center">${clientes.idCliente}</td>
                        <td class="text-center">${clientes.nombre}</td>
                        <td class="text-center">${clientes.apellidoP}</td>
                        <td class="text-center">${clientes.apellidoM}</td>
                        <td class="text-center">${clientes.telefono}</td>
                        <td class="text-center">${clientes.correo}</td>
                        <td class="align-middle text-center"><a href="${pageContext.request.contextPath}/ServletCliente?accion=editar&idCliente=${clientes.idCliente}" >
                        <i class="fa-sharp fa-solid fa-pen-to-square"></i></a>
                        <td class="align-middle text-center"><a href="${pageContext.request.contextPath}/ServletCliente?accion=eliminar&idCliente=${clientes.idCliente}" >
                        <i class="fa-solid fa-trash-can text-danger"></i></a></td>
                    </tr>
                  </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>