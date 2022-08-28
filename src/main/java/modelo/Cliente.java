/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author LENOVO
 */
import java.util.ArrayList;


public class Cliente extends Persona{
    private ArrayList<Cliente> clientes;
    private ArrayList<Representante> representantes;
    private Representante representante;
    
    public Representante getRepresentante(){
        return representante;
    }
    
    public void setRepresentante(Representante representante){
        this.representante = representante;
    }
    
    
    //Constructor Cliente
    public Cliente(String cedula, String nombre, String telefono, String email, Representante representante){
        super(cedula, nombre, telefono, email);
        this.representante = representante;
    }
    
}
