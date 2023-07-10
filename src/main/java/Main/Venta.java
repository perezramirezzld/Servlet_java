/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author soybi
 */
public class Venta {
    private int idVenta;
    private String fechaVenta;
    private String idProducto;
    private String idCliente;
    private int cantidad;
    private float total;

    public Venta() {
    }

    public Venta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Venta(String fechaVenta, String idProducto, String idCliente, int cantidad, float total) {
        this.fechaVenta = fechaVenta;
        this.idProducto = idProducto;
        this.idCliente = idCliente;
        this.cantidad = cantidad;
        this.total = total;
    }

    public Venta(int idVenta, String fechaVenta, String idProducto, String idCliente, int cantidad, float total) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.idProducto = idProducto;
        this.idCliente = idCliente;
        this.cantidad = cantidad;
        this.total = total;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Venta{");
        sb.append("idVenta=").append(idVenta);
        sb.append(", fechaVenta=").append(fechaVenta);
        sb.append(", idProducto=").append(idProducto);
        sb.append(", idCliente=").append(idCliente);
        sb.append(", cantidad=").append(cantidad);
        sb.append(", total=").append(total);
        sb.append('}');
        return sb.toString();
    }
    public String[] listString(){
        String[] r = {
            ""+getIdVenta(),
            ""+getFechaVenta(),
            ""+getIdProducto(),
            ""+getIdCliente(),
            ""+getCantidad(),
            ""+getTotal()
        };
    return r;
    }
}
