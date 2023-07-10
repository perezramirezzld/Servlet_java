package Web;

import Data.ClienteDAO;
import Data.ProductoDAO;
import Data.VentaDAO;
import Main.Cliente;
import Main.Producto;
import Main.Venta;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletVenta")
public class ServletVenta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarVenta(request, response);
                    break;
                case "eliminar":
                    this.eliminarVenta(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Venta> ventas = new VentaDAO().listar();
        List<Producto> productos = new ProductoDAO().listar();
        List<Cliente> clientes = new ClienteDAO().listar();
        System.out.println("ventas = " + ventas);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("ventas", ventas);
        sesion.setAttribute("productos", productos);
        sesion.setAttribute("clientes", clientes);
        sesion.setAttribute("totalVentas", ventas.size());
        //sesion.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
        request.getRequestDispatcher("ventas.jsp").forward(request, response);
        //response.sendRedirect("Inicio.jsp");
    }

    /*private double calcularSaldoTotal(List<Cliente> clientes) {
        double saldoTotal = 0;
        for (Cliente cliente : clientes) {
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;
    }*/
    private void editarVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos el idCliente
        int idVenta = Integer.parseInt(request.getParameter("idVenta"));
        Venta ventas = new VentaDAO().encontrar(new Venta(idVenta));
        request.setAttribute("ventas", ventas);
        String jspEditar = "/WEB-INF/Paginas/Venta/ModificarVenta.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarVenta(request, response);
                    break;
                case "modificar":
                    this.modificarVenta(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        //recuperamos los valores del formulario "AgregarVenta"
        String fechaVenta = request.getParameter("fecha_venta");
        String clienteId = request.getParameter("cliente_id");
        String productoId = request.getParameter("producto_id");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));

        //Obtenemos la info del producto que seleccionamos con el combobox
        Producto p = new Producto(Integer.parseInt(productoId));
        List<Producto> productos = new ProductoDAO().listar();
        for (Producto x : productos) {
            if (x.getIdProducto() == Integer.parseInt(productoId)) {
                p = x;
            }
        }
        if (cantidad <= p.getCantidad()) {
            //Quitamos la cantidad de la venta que acabamos de hacer
            int aux = p.getCantidad() - cantidad;
            ProductoDAO po = new ProductoDAO();
            int y = po.actualizar(new Producto(p.getIdProducto(), p.getDescripcion(), p.getPrecio(), aux, p.getIdProveedor()));
            //Calculamos el total de la venta
            float total = cantidad * p.getPrecio();
            //Creamos el objeto de venta (modelo)
            Venta venta = new Venta(fechaVenta, clienteId, productoId, cantidad, total);
            //Insertamos la nueva venta en la base de datos
            int registrosModificados = new VentaDAO().insertar(venta);
            System.out.println("registrosModificados = " + registrosModificados);
            //Redirigimos hacia accion por default
            this.accionDefault(request, response);
            System.out.println(p.getCantidad());
        } else {
            //Para no hacer la venta, se manda a la accion default solamente
            this.accionDefault(request, response);
        }
    }

//    private Producto encontrarProducto(int i){
//        Producto prop = new Producto(i);
//        List<Producto> productos = new ProductoDAO().listar();
//        for(Producto x: productos){
//            if(x.getIdProducto() == i){
//                prop = x;
//            }
//        }
//        return prop;
//    }
    private void modificarVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario editarCliente
        int idVenta = Integer.parseInt(request.getParameter("idVenta"));
        String fechaVenta = request.getParameter("fecha_venta");
        String clienteId = request.getParameter("cliente_id");
        String productoId = request.getParameter("producto_id");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));

        //Obtenemos la info del producto que seleccionamos con el combobox
        Producto p = new Producto(Integer.parseInt(productoId));
        List<Producto> productos = new ProductoDAO().listar();
        for (Producto x : productos) {
            if (x.getIdProducto() == Integer.parseInt(productoId)) {
                p = x;
            }
        }
        if (cantidad <= p.getCantidad()) {
            //Quitamos la cantidad de la venta que acabamos de hacer
            int aux = p.getCantidad() - cantidad;
            ProductoDAO po = new ProductoDAO();
            int y = po.actualizar(new Producto(p.getIdProducto(), p.getDescripcion(), p.getPrecio(), aux, p.getIdProveedor()));
            //Calculamos el total de la venta
            float total = cantidad * p.getPrecio();

            Venta venta = new Venta(idVenta, fechaVenta, clienteId, productoId, cantidad, total);

            //Modificar el  objeto en la base de datos
            int registrosModificados = new VentaDAO().actualizar(venta);
            System.out.println("registrosModificados = " + registrosModificados);

            //Redirigimos hacia accion por default
            this.accionDefault(request, response);
        }
        else{
            //Para no hacer la venta, se manda a la accion default solamente
            this.accionDefault(request, response);
        }
    }

    private void eliminarVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario editarCliente
        int idVenta = Integer.parseInt(request.getParameter("idVenta"));
        //Obtenemos la venta
        Venta v = new Venta(idVenta);
        List<Venta> ventas = new VentaDAO().listar();
        for (Venta z : ventas){
            if (z.getIdVenta() == idVenta){
                v = z;
            }
        }
        //Obtenemos la info del producto que seleccionamos con el combobox
        Producto p = new Producto(Integer.parseInt(v.getIdProducto()));
        List<Producto> productos = new ProductoDAO().listar();
        for (Producto x : productos) {
            if (x.getIdProducto() == Integer.parseInt(v.getIdProducto())) {
                p = x;
            }
        }
        //Sumamos la cantidad de la venta que acabamos de hacer
            int aux = p.getCantidad() + v.getCantidad();
            ProductoDAO po = new ProductoDAO();
            int y = po.actualizar(new Producto(p.getIdProducto(), p.getDescripcion(), p.getPrecio(), aux, p.getIdProveedor()));
        //Creamos el objeto de cliente (modelo)
        Venta venta = new Venta(idVenta);
        //Eliminamos el  objeto en la base de datos
        int registrosModificados = new VentaDAO().eliminar(venta);
        System.out.println("registrosModificados = " + registrosModificados);
        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
}
