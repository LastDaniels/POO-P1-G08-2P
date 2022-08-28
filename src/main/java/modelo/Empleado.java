/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
    
    public String getCedula(){
        return super.getCedula();   
    }
    
    public String getNombre(){
        return super.getNombre();
    }
    
    public String getTelefono(){
        return super.getTelefono();
    }
    
    public String getEmail(){
        return super.getEmail();
    }
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return super.toString() + ", Empleado{" + "estado=" + estado + '}'+"}";
    }
//    @Override
//    public String toString() {
//        return  super.getCedula()+super.getNombre()+super.getTelefono()+super.getEmail()+ estado;
//    }
    
    public static ArrayList<Empleado> cargarEmpleados(String ruta){
        ArrayList<Empleado> empleados = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(ruta))){
            String sCurrentLine;
            
            br.readLine();
            while((sCurrentLine = br.readLine())!=null){
                String[] datos = sCurrentLine.split(",");
                Empleado e = new Empleado(datos[0], datos[1], datos[2], datos[3], datos[4]);
                empleados.add(e);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no existe");
        } catch (IOException   ex) {
            System.out.println("Error io:"+ex.getMessage());
        } 
        //System.out.println(empleados.toString());
        return empleados;
    }
}