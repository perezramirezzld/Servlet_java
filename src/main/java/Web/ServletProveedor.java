/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Main.Proveedor;
import Data.ProveedorDAO;

/**
 *
 * @author soybi
 */
@WebServlet("/ServletProveedor")
public class ServletProveedor extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarProveedor(request, response);
                    break;
                case "eliminar":
                    this.eliminarProveedor(request, response);
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
        List<Proveedor> proveedores = new ProveedorDAO().listar();
        System.out.println("proveedores = " + proveedores);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("proveedores", proveedores);
        sesion.setAttribute("totalProveedores", proveedores.size());
        //sesion.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
        request.getRequestDispatcher("proveedores.jsp").forward(request, response);
        //response.sendRedirect("proveedores.jsp");
    }

    /*private double calcularSaldoTotal(List<Cliente> clientes) {
        double saldoTotal = 0;
        for (Cliente cliente : clientes) {
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;
    }*/

    private void editarProveedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos el idCliente
        int idProveedor = Integer.parseInt(request.getParameter("idProveedor"));
        Proveedor proveedores = new ProveedorDAO().encontrar(new Proveedor(idProveedor));
        request.setAttribute("proveedores", proveedores);
        String jspEditar = "/WEB-INF/Paginas/Proveedor/ModificarProveedor.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarProveedor(request, response);
                    break;
                case "modificar":
                    this.modificarProveedor(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarProveedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario agregarCliente
        String nombre = request.getParameter("nombre");
        String apellidoP = request.getParameter("apellido_paterno");
        String apellidoM = request.getParameter("apellido_materno");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String marca = request.getParameter("marca");
        /*double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }*/

        //Creamos el objeto de cliente (modelo)
        Proveedor proveedor = new Proveedor(nombre, apellidoP, apellidoM, telefono, direccion, marca);

        //Insertamos el nuevo objeto en la base de datos
        int registrosModificados = new ProveedorDAO().insertar(proveedor);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }

    private void modificarProveedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario editarCliente
        int idProveedor = Integer.parseInt(request.getParameter("idProveedor"));
        String nombre = request.getParameter("nombre");
        String apellidoP = request.getParameter("apellido_paterno");
        String apellidoM = request.getParameter("apellido_materno");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String marca = request.getParameter("marca");
        /*double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }*/

        //Creamos el objeto de cliente (modelo)
        Proveedor proveedor = new Proveedor(idProveedor, nombre, apellidoP, apellidoM, telefono, direccion, marca);

        //Modificar el  objeto en la base de datos
        int registrosModificados = new ProveedorDAO().actualizar(proveedor);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
    
        private void eliminarProveedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario editarCliente
        int idProveedor = Integer.parseInt(request.getParameter("idProveedor"));
     

        //Creamos el objeto de cliente (modelo)
        Proveedor proveedor = new Proveedor(idProveedor);

        //Eliminamos el  objeto en la base de datos
        int registrosModificados = new ProveedorDAO().eliminar(proveedor);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
}
