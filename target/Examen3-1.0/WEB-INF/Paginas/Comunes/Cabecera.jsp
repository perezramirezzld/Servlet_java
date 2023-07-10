<div class="overlay"></div>
<!-- Sidebar -->
<nav class="navbar navbar-inverse fixed-top" id="sidebar-wrapper" role="navigation">
    <ul class="nav sidebar-nav">
        <div class="sidebar-header">
            <div class="sidebar-brand">
                <a href="Inicio.jsp">LAVAQUITA</a>
            </div>
        </div>
        <li><a href="Inicio.jsp#home">Inicio</a></li>
        <li>
            <a href="${pageContext.request.contextPath}/ServletVenta#ventas">Ventas </a>
        </li>
        <li class="dropdown">
            <a href="${pageContext.request.contextPath}/ServletProducto#productos">Productos </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/ServletPedido#pedidos">Pedidos</a>
        </li>
        <li class="dropdown">
            <a href="${pageContext.request.contextPath}/ServletProveedor#proveedores">Proveedores</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/ServletCliente#clientes">Clientes</span></a>
        </li>
        <li><a href="${pageContext.request.contextPath}/index.jsp#Sesion">Cerrar sesion</a></li>
    </ul>
</nav>
<div id="page-content-wrapper">
    <button type="button" class="hamburger animated fadeInLeft is-closed" data-toggle="offcanvas">
        <span class="hamb-top"></span>
        <span class="hamb-middle"></span>
        <span class="hamb-bottom"></span>
    </button>

</div>
