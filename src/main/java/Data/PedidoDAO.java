/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Main.Pedido;
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
public class PedidoDAO {
            
    private static final String SQL_SELECT = "SELECT pedido_id, fecha_pedido, cantidad, producto_id, provider_id"
            + " FROM pedidos";

    private static final String SQL_SELECT_BY_ID = "SELECT pedido_id, fecha_pedido, cantidad, producto_id, provider_id"
            + " FROM pedidos WHERE pedido_id = ?";

    private static final String SQL_INSERT = "INSERT INTO pedidos(fecha_pedido, cantidad, producto_id, provider_id) "
            + " VALUES(?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE pedidos "
            + " SET fecha_pedido=?, cantidad=?, producto_id=?, provider_id=? WHERE pedido_id=?";

    private static final String SQL_DELETE = "DELETE FROM pedidos WHERE pedido_id = ?";

    public List<Pedido> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pedido pedido = null;
        List<Pedido> pedidos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPedido = rs.getInt("pedido_id");
                String fechaPedido = rs.getString("fecha_pedido");
                int cantidad = rs.getInt("cantidad");
                String productId = rs.getString("producto_id");
                String providerId = rs.getString("provider_id");

                pedido = new Pedido(idPedido, fechaPedido, cantidad, productId, providerId);
                pedidos.add(pedido);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);           
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return pedidos;
    }

    public Pedido encontrar(Pedido pedido) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, pedido.getIdPedido());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            String fechaPedido = rs.getString("fecha_pedido");
            int cantidad = rs.getInt("cantidad");
            String productId = rs.getString("producto_id");
            String providerId = rs.getString("provider_id");

            pedido.setFechaPedido(fechaPedido);
            pedido.setCantidad(cantidad);
            pedido.setIdProducto(productId);
            pedido.setIdProveedor(providerId);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }  catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return pedido;
    }

    public int insertar(Pedido pedido) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, pedido.getFechaPedido());
            stmt.setInt(2, pedido.getCantidad());
            stmt.setString(3, pedido.getIdProducto());
            stmt.setString(4, pedido.getIdProveedor());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int actualizar(Pedido pedido) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, pedido.getFechaPedido());
            stmt.setInt(2, pedido.getCantidad());
            stmt.setString(3, pedido.getIdProducto());
            stmt.setString(4, pedido.getIdProveedor());
            stmt.setInt(5, pedido.getIdPedido());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }  catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int eliminar(Pedido pedido) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, pedido.getIdPedido());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }  catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
}
