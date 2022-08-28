/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Servicio {
    private String nombre;
    private Empleado empleado;
//    private Atencion atencion;
    private int duracion;
    private double precio;
    private String estado;
 
    
    public Servicio(String nombre, Empleado empleado, int duracion, double precio, String estado) {
        this.nombre = nombre;
        this.empleado = empleado;
        this.duracion = duracion;
        this.precio = precio;
        this.estado = estado;
    }
    public static void agregarServicio(ArrayList<Servicio> servicios, ArrayList<Empleado> empleados) {
        System.out.println("Ingrese los datos del servicio.");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese nombre del servicio: ");
        String servicio = sc.nextLine();
        
        System.out.println("Ingrese la duración en minutos: ");
        int duracion = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Ingrese el precio del servicio: ");
        double precio = sc.nextDouble();
        sc.nextLine();
        boolean x= true;
        while(x==true){
            System.out.println("Ingrese cedula del empleado que realizará el servicio: ");
            String cedula = sc.nextLine();
            int i =0;
            while (i< servicios.size()){
            
                if(cedula.equals(empleados.get(i).getCedula())){
                    servicios.add(new Servicio(servicio, empleados.get(i),duracion,precio,"Activo"));
                    i = servicios.size();
                    x=false;
                }else if (i == empleados.size() - 1) {
                    System.out.println("No se encontro empleado con esa cedula");
                }i++;
            }
        }
    }
    
    public static void editarServicio(ArrayList<Servicio> servicios){
        boolean x= true;
        Scanner sc = new Scanner(System.in);
        while(x){
        System.out.println("Ingrese el nombre del servicio a cambiar: ");
        String nombreAnterior = sc.nextLine();
        
        System.out.println("Ingrese el nuevo nombre: ");
        String nombreNuevo = sc.nextLine();
        
        System.out.println("Ingrese la duración en minutos: ");
        int duracion = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Ingrese el precio del servicio: ");
        double precio = sc.nextDouble();
        sc.nextLine();
        
        for(int i =0 ; i<servicios.size();i++){
            if(nombreAnterior.equals(servicios.get(i).getNombre())){
                servicios.get(i).setNombre(nombreNuevo);
                servicios.get(i).setDuracion(duracion);
                servicios.get(i).setPrecio(precio);
                i=servicios.size();
                x=false;
                System.out.println("Servicio en estado activo.");

            } else if (i == servicios.size() - 1)  {
                System.out.println("No se encontro ese servicio.");
            }
        }
    }
    }
    public static void eliminarServicio (ArrayList<Servicio> servicios){
        Scanner sc = new Scanner(System.in);
        boolean x=true; 
        while(x){
        System.out.println("Ingrese el nombre del servicio a eliminar: ");
         String nombreEliminar = sc.nextLine();
         for(int i=0; i<servicios.size();i++){
             if(nombreEliminar.equals(servicios.get(i).getNombre())){
                 servicios.get(i).setEstado("Inactivo");
                 i = servicios.size();
                 x = false;
                 System.out.println("Servicio en estado inactivo.");
             }else if (i == servicios.size() - 1) {
                 System.out.println("No se encontro ese servicio.");
             }             
         }
        
        }
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

//    public Atencion getAtencion() {
//        return atencion;
//    }
//
//    public void setAtencion(Atencion atencion) {
//        this.atencion = atencion;
//    }

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
    
    
    
}
