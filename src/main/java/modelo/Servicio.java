/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class Servicio implements Serializable{
    private String nombre;
    private String nombreEmpleado;
    private Empleado empleado;
    private int duracion;
    private double precio;
    private String estado;
    //private String nEmpleado;
    
    public Servicio(String nombre, String nombreEmpleado, Empleado empleado, int duracion, double precio, String estado) {
        this.nombre = nombre;
        //this.empleado = empleado;
        this.duracion = duracion;
        this.precio = precio;
        this.estado = estado;
        this.nombreEmpleado = nombreEmpleado;
    
    }

    public Servicio(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nombre;
    }
    

//    @Override
//    public String toString() {
//        return "Servicio{" + "nombre=" + nombre + ", empleado=" +  ", duracion=" + duracion + ", precio=" + precio + ", estado=" + estado + '}';
//    }
    
    public static ArrayList<Servicio> cargarServicios(String ruta){
        ArrayList<Servicio> servicios = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(ruta))){
            String sCurrentLine;
            
            br.readLine();
            while((sCurrentLine = br.readLine())!=null){
                String[] datos = sCurrentLine.split(",");
                Empleado empleado = new Empleado(datos[1]);
                Servicio e = new Servicio(datos[0],datos[1],empleado, Integer.valueOf(datos[2]),Double.valueOf(datos[3]),datos[4]);
                servicios.add(e);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no existe");
        } catch (IOException   ex) {
            System.out.println("Error io:"+ex.getMessage());
        } 
        return servicios;
    }
}