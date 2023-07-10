
package Web;

import Data.ProductoDAO;
import Data.ProveedorDAO;
import Main.Producto;
import Main.Proveedor;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletProducto")
public class ServletProducto extends HttpServlet{
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarProducto(request, response);
                    break;
                case "eliminar":
                    this.eliminarProducto(request, response);
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
        List<Producto> productos = new ProductoDAO().listar();
        List<Proveedor> proveedores = new ProveedorDAO().listar();
        System.out.println("productos = " + productos);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("productos", productos);
        sesion.setAttribute("proveedores", proveedores);
        sesion.setAttribute("totalProductos", productos.size());
        //sesion.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
        request.getRequestDispatcher("productos.jsp").forward(request, response);
        //response.sendRedirect("productos.jsp");
    }

    /*private double calcularSaldoTotal(List<Cliente> clientes) {
        double saldoTotal = 0;
        for (Cliente cliente : clientes) {
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;
    }*/

    private void editarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos el idCliente
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
        Producto productos = new ProductoDAO().encontrar(new Producto(idProducto));
        request.setAttribute("productos", productos);
        String jspEditar = "/WEB-INF/Paginas/Producto/ModificarProducto.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarProducto(request, response);
                    break;
                case "modificar":
                    this.modificarProducto(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario agregarCliente
        String descripcion = request.getParameter("descripcion");
        float precio = Float.parseFloat(request.getParameter("precio"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        String idProveedor = request.getParameter("idProveedor");
        /*double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }*/

        //Creamos el objeto de cliente (modelo)
        Producto producto = new Producto(descripcion, precio, cantidad, idProveedor);

        //Insertamos el nuevo objeto en la base de datos
        int registrosModificados = new ProductoDAO().insertar(producto);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }

    private void modificarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
        String descripcion = request.getParameter("descripcion");
        float precio = Float.parseFloat(request.getParameter("precio"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        String idProveedor =request.getParameter("idProveedor");
        /*double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }*/

        //Creamos el objeto de cliente (modelo)
        Producto producto = new Producto(idProducto, descripcion, precio, cantidad, idProveedor);

        //Modificar el  objeto en la base de datos
        int registrosModificados = new ProductoDAO().actualizar(producto);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
    
        private void eliminarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario editarCliente
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
     

        //Creamos el objeto de cliente (modelo)
        Producto producto = new Producto(idProducto);

        //Eliminamos el  objeto en la base de datos
        int registrosModificados = new ProductoDAO().eliminar(producto);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
}
