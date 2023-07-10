/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author soybi
 */
public class Producto{
    private int idProducto;
    private String descripcion;
    private float precio;
    private int cantidad;
    private String idProveedor;

    public Producto() {
    }

    public Producto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(String descripcion, float precio, int cantidad, String idProveedor) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.idProveedor = idProveedor;
    }

    public Producto(int idProducto, String descripcion, float precio, int cantidad, String idProveedor) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.idProveedor = idProveedor;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{");
        sb.append("idProducto=").append(idProducto);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", precio=").append(precio);
        sb.append(", cantidad=").append(cantidad);
        sb.append(", idProveedor=").append(idProveedor);
        sb.append('}');
        return sb.toString();
    }
    
    public String[] listString(){
        String[] r = {
            ""+getIdProducto(),
            ""+getDescripcion(),
            ""+getPrecio(),
            ""+getCantidad(),
            ""+getIdProveedor()
        };
    return r;
    }
}
