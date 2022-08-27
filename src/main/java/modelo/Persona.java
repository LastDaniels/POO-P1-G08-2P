/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author LENOVO
 */
public class Persona {
    private String cedula;
    private String nombre;
    private String telefono;
    private String email;
    
    public String getCedula(){
        return cedula;
    }
    
    public void setCedula(String dni){
        this.cedula = dni;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String name){
        this.nombre = name;
    }
    
    public String getTelefono(){
        return telefono;
    }
    
    public void setTelefono(String tel){
        this.telefono = tel;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    //constructor Persona
    public Persona(String cedula, String nombre, String telefono, String email){
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;    
    }
}//end Persona

