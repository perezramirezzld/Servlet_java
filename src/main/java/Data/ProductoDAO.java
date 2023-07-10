/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Main.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author soybi
 */
public class ProductoDAO {
    
    private static final String SQL_SELECT = "SELECT producto_id, descripcion, precio, cantidad, proveedor_id"
            + " FROM productos";

    private static final String SQL_SELECT_BY_ID = "SELECT producto_id, descripcion, precio, cantidad, proveedor_id "
            + " FROM productos WHERE producto_id = ?";

    private static final String SQL_INSERT = "INSERT INTO productos(descripcion, precio, cantidad, proveedor_id) "
            + " VALUES(?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE productos "
            + " SET descripcion=?, precio=?, cantidad=?, proveedor_id=? WHERE producto_id=?";

    private static final String SQL_DELETE = "DELETE FROM clientes WHERE producto_id = ?";

    public List<Producto> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto = null;
        List<Producto> productos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idProducto = rs.getInt("producto_id");
                String descripcion = rs.getString("descripcion");
                float precio = rs.getFloat("precio");
                int cantidad = rs.getInt("cantidad");
                String proveedor_id = rs.getString("proveedor_id");
                
                producto = new Producto(idProducto, descripcion, precio, cantidad, proveedor_id);
                productos.add(producto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);           
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return productos;
    }

    public Producto encontrar(Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, producto.getIdProducto());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            String descripcion = rs.getString("descripcion");
            float precio = rs.getFloat("precio");
            int cantidad = rs.getInt("cantidad");
            String proveedor_id = rs.getString("proveedor_id");

            producto.setDescripcion(descripcion);
            producto.setPrecio(precio);
            producto.setCantidad(cantidad);
            producto.setIdProveedor(proveedor_id);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }  catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return producto;
    }

    public int insertar(Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, producto.getDescripcion());
            stmt.setFloat(2, producto.getPrecio());
            stmt.setInt(3, producto.getCantidad());
            stmt.setString(4, producto.getIdProveedor());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int actualizar(Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, producto.getDescripcion());
            stmt.setFloat(2, producto.getPrecio());
            stmt.setInt(3, producto.getCantidad());
            stmt.setString(4, producto.getIdProveedor());
            stmt.setInt(5, producto.getIdProducto());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }  catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int eliminar(Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, producto.getIdProducto());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }  catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
}
