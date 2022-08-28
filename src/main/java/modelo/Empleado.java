/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author LENOVO
 */
public class Empleado extends Persona{
    private String estado;
    

    public Empleado(String cedula, String nombre, String telefono, String email, String estado) {
        super(cedula, nombre, telefono, email);
        this.estado = estado;
    }
}