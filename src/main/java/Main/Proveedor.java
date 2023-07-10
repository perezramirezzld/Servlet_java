/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author soybi
 */
public class Proveedor extends Persona{
    private int idProveedor;
    private String direccion;
    private String marca;

    public Proveedor() {
    }

    public Proveedor(String nombre, String apellidoP, String apellidoM, String telefono, String direccion, String marca) {
        super(nombre, apellidoP, apellidoM, telefono);
        this.direccion = direccion;
        this.marca = marca;
    }

    public Proveedor(int idProveedor, String nombre, String apellidoP, String apellidoM, String telefono,String direccion, String marca) {
        super(nombre, apellidoP, apellidoM, telefono);
        this.idProveedor = idProveedor;
        this.direccion = direccion;
        this.marca = marca;
    }

    public Proveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Proveedor{");
        sb.append("idProveedor=").append(idProveedor);
        sb.append(", direccion=").append(direccion);
        sb.append(", marca=").append(marca);
        sb.append('}');
        return sb.toString();
    }
    
    public String[] listString(){
        String[] r = {
            ""+idProveedor,
            getNombre(),
            getApellidoP(),
            getApellidoM(),
            getTelefono(),
            getDireccion(),
            getMarca()
        };
    return r;
    }
}
