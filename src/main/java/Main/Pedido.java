/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author soybi
 */
public class Pedido {
    private int idPedido;
    private String fechaPedido;
    private int cantidad;
    private String idProducto;
    private String idProveedor;

    public Pedido() {
    }

    public Pedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Pedido(String fechaPedido, int cantidad, String idProducto, String idProveedor) {
        this.fechaPedido = fechaPedido;
        this.cantidad = cantidad;
        this.idProducto = idProducto;
        this.idProveedor = idProveedor;
    }

    public Pedido(int idPedido, String fechaPedido, int cantidad, String idProducto, String idProveedor) {
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        this.cantidad = cantidad;
        this.idProducto = idProducto;
        this.idProveedor = idProveedor;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
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
        sb.append("Pedido{");
        sb.append("idPedido=").append(idPedido);
        sb.append(", fechaPedido=").append(fechaPedido);
        sb.append(", cantidad=").append(cantidad);
        sb.append(", idProducto=").append(idProducto);
        sb.append(", idProveedor=").append(idProveedor);
        sb.append('}');
        return sb.toString();
    }
    
    public String[] listString(){
        String[] r = {
            ""+getIdPedido(),
            ""+getFechaPedido(),
            ""+getCantidad(),
            ""+getIdProducto(),
            ""+getIdProveedor()
        };
    return r;
    }  
    
}
