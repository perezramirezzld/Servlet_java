/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Main.Venta;
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
public class VentaDAO {
            
    private static final String SQL_SELECT = "SELECT venta_id, fecha_venta, cliente_id, producto_id, cantidad, total"
            + " FROM ventas";

    private static final String SQL_SELECT_BY_ID = "SELECT venta_id, fecha_venta, cliente_id, producto_id, cantidad, total"
            + " FROM ventas WHERE venta_id = ?";

    private static final String SQL_INSERT = "INSERT INTO ventas(fecha_venta, cliente_id, producto_id, cantidad, total) "
            + " VALUES(?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE ventas "
            + " SET fecha_venta=?, cliente_id=?, producto_id=?, cantidad=?, total=? WHERE venta_id=?";

    private static final String SQL_DELETE = "DELETE FROM ventas WHERE venta_id = ?";

    public List<Venta> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Venta venta = null;
        List<Venta> ventas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idVenta = rs.getInt("venta_id");
                String fechaVenta = rs.getString("fecha_venta");
                String clienteId = rs.getString("cliente_id");
                String productoId = rs.getString("producto_id");
                int cantidad = rs.getInt("cantidad");
                float total = rs.getFloat("total");

                venta = new Venta(idVenta, fechaVenta, clienteId, productoId, cantidad, total);
                ventas.add(venta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);           
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return ventas;
    }

    public Venta encontrar(Venta venta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, venta.getIdVenta());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            String fechaVenta = rs.getString("fecha_venta");
            String clienteId = rs.getString("cliente_id");
            String productoId = rs.getString("producto_id");
            int cantidad = rs.getInt("cantidad");
            float total = rs.getFloat("total");

            venta.setFechaVenta(fechaVenta);
            venta.setIdCliente(clienteId);
            venta.setIdProducto(productoId);
            venta.setCantidad(cantidad);
            venta.setTotal(total);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }  catch (ClassNotFoundException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return venta;
    }

    public int insertar(Venta venta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, venta.getFechaVenta());
            stmt.setString(2, venta.getIdCliente());
            stmt.setString(3, venta.getIdProducto());
            stmt.setInt(4, venta.getCantidad());
            stmt.setFloat(5, venta.getTotal());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int actualizar(Venta venta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, venta.getFechaVenta());
            stmt.setString(2, venta.getIdCliente());
            stmt.setString(3, venta.getIdProducto());
            stmt.setInt(4, venta.getCantidad());
            stmt.setFloat(5, venta.getTotal());
            stmt.setInt(6, venta.getIdVenta());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }  catch (ClassNotFoundException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int eliminar(Venta venta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, venta.getIdVenta());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }  catch (ClassNotFoundException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
}
