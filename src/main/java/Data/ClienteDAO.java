/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Main.Cliente;
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
public class ClienteDAO {
    
    private static final String SQL_SELECT = "SELECT cliente_id, nombre, apellido_paterno, apellido_materno, telefono, correo"
            + " FROM clientes";

    private static final String SQL_SELECT_BY_ID = "SELECT cliente_id, nombre, apellido_paterno, apellido_materno, telefono, correo "
            + " FROM clientes WHERE cliente_id = ?";

    private static final String SQL_INSERT = "INSERT INTO clientes(nombre, apellido_paterno, apellido_materno, telefono, correo) "
            + " VALUES(?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE clientes "
            + " SET nombre=?, apellido_paterno=?, apellido_materno=?, telefono=?, correo=? WHERE cliente_id=?";

    private static final String SQL_DELETE = "DELETE FROM clientes WHERE cliente_id = ?";

    public List<Cliente> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idCliente = rs.getInt("cliente_id");
                String nombre = rs.getString("nombre");
                String apellidoP = rs.getString("apellido_paterno");
                String apellidoM = rs.getString("apellido_materno");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");

                cliente = new Cliente(idCliente, nombre, apellidoP, apellidoM, telefono, correo);
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);           
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return clientes;
    }

    public Cliente encontrar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, cliente.getIdCliente());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            String nombre = rs.getString("nombre");
            String apellidoP = rs.getString("apellido_paterno");
            String apellidoM = rs.getString("apellido_materno");
            String telefono = rs.getString("telefono");
            String correo = rs.getString("correo");

            cliente.setNombre(nombre);
            cliente.setApellidoP(apellidoP);
            cliente.setApellidoM(apellidoM);
            cliente.setTelefono(telefono);
            cliente.setCorreo(correo);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }  catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cliente;
    }

    public int insertar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellidoP());
            stmt.setString(3, cliente.getApellidoM());
            stmt.setString(4, cliente.getTelefono());
            stmt.setString(5, cliente.getCorreo());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int actualizar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellidoP());
            stmt.setString(3, cliente.getApellidoM());
            stmt.setString(4, cliente.getTelefono());
            stmt.setString(5, cliente.getCorreo());
            stmt.setInt(6, cliente.getIdCliente());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }  catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int eliminar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getIdCliente());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }  catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
}
