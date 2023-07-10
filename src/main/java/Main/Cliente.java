/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author soybi
 */
public class Cliente extends Persona{
    private int idCliente;
    private String correo;

    public Cliente() {
    }

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(String nombre, String apellidoP, String apellidoM, String telefono, String correo) {
        super(nombre, apellidoP, apellidoM, telefono);
        this.correo = correo;
    }

    public Cliente(int idCliente, String nombre, String apellidoP, String apellidoM, String telefono, String correo) {
        super(nombre, apellidoP, apellidoM, telefono);
        this.idCliente = idCliente;
        this.correo = correo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("idCliente=").append(idCliente);
        sb.append(", correo=").append(correo);
        sb.append('}');
        return sb.toString();
    }
    
    public String[] listString(){
        String[] r = {
            ""+idCliente,
            getNombre(),
            getApellidoP(),
            getApellidoM(),
            getTelefono(),
            getCorreo()
        };
    return r;
    }
}
