/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Main.Proveedor;
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
public class ProveedorDAO {
        
    private static final String SQL_SELECT = "SELECT proveedor_id, nombre, apellido_paterno, apellido_materno, telefono, direccion, marca"
            + " FROM proveedores";

    private static final String SQL_SELECT_BY_ID = "SELECT proveedor_id, nombre, apellido_paterno, apellido_materno, telefono, direccion, marca "
            + " FROM proveedores WHERE proveedor_id = ?";

    private static final String SQL_INSERT = "INSERT INTO proveedores(nombre, apellido_paterno, apellido_materno, telefono, direccion, marca) "
            + " VALUES(?, ?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE proveedores"
            + " SET nombre=?, apellido_paterno=?, apellido_materno=?, telefono=?, direccion=?, marca=? WHERE proveedor_id=?";

    private static final String SQL_DELETE = "DELETE FROM proveedores WHERE proveedor_id = ?";

    public List<Proveedor> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Proveedor proveedor = null;
        List<Proveedor> proveedores = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idProveedor = rs.getInt("proveedor_id");
                String nombre = rs.getString("nombre");
                String apellidoP = rs.getString("apellido_paterno");
                String apellidoM = rs.getString("apellido_materno");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                String marca = rs.getString("marca");

                proveedor = new Proveedor(idProveedor, nombre, apellidoP, apellidoM, telefono, direccion, marca);
                proveedores.add(proveedor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);           
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return proveedores;
    }

    public Proveedor encontrar(Proveedor proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, proveedor.getIdProveedor());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            String nombre = rs.getString("nombre");
            String apellidoP = rs.getString("apellido_paterno");
            String apellidoM = rs.getString("apellido_materno");
            String telefono = rs.getString("telefono");
            String direccion = rs.getString("direccion");
            String marca = rs.getString("marca");

            proveedor.setNombre(nombre);
            proveedor.setApellidoP(apellidoP);
            proveedor.setApellidoM(apellidoM);
            proveedor.setTelefono(telefono);
            proveedor.setDireccion(direccion);
            proveedor.setMarca(marca);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }  catch (ClassNotFoundException ex) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return proveedor;
    }

    public int insertar(Proveedor proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, proveedor.getNombre());
            stmt.setString(2, proveedor.getApellidoP());
            stmt.setString(3, proveedor.getApellidoM());
            stmt.setString(4, proveedor.getTelefono());
            stmt.setString(5, proveedor.getDireccion());
            stmt.setString(6, proveedor.getMarca());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int actualizar(Proveedor proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, proveedor.getNombre());
            stmt.setString(2, proveedor.getApellidoP());
            stmt.setString(3, proveedor.getApellidoM());
            stmt.setString(4, proveedor.getTelefono());
            stmt.setString(5, proveedor.getDireccion());
            stmt.setString(6, proveedor.getMarca());
            stmt.setInt(7, proveedor.getIdProveedor());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }  catch (ClassNotFoundException ex) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int eliminar(Proveedor proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, proveedor.getIdProveedor());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }  catch (ClassNotFoundException ex) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
}
