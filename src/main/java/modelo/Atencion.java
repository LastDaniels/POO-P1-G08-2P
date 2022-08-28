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
public class Atencion {
    private Cliente cliente;
    private Empleado empleado;
    private int duracionAtencion; //duracion real de la atencion
    private Cita cita;
    

    public Atencion(Cliente cliente, Empleado empleado, int duracionAtencion, Cita cita) {
        this.cliente = cliente;
        this.empleado = empleado;
        this.duracionAtencion = duracionAtencion;
        this.cita = cita; 
    }
    // Consulta de una atencion por medio de la cedula
    public static void consultarAtencion(ArrayList<Atencion> atenciones){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la consulta. "
                + "Puede consultar por cedula del empleado, cedula del cliente, o fecha de la cita[dd/mm/yy].");
        String consulta = sc.nextLine();

        for(int i=0; i<atenciones.size();i++){
            if((consulta.equals(atenciones.get(i).getCliente().getCedula())) || (consulta.equals(atenciones.get(i).getEmpleado().getCedula()))||
                    (consulta.equals(atenciones.get(i).getCita().getFecha()))){
                System.out.println("Cliente: " + atenciones.get(i).getCliente().getNombre()+", Empleado: "+atenciones.get(i).getEmpleado().getNombre()
                +", Duracion: "+atenciones.get(i).getDuracionAtencion()+ ", Fecha: "+atenciones.get(i).getCita().getFecha()+", Hora: "+atenciones.get(i).getCita().getTime()
                + ", Servicio: "+ atenciones.get(i).getCita().getServicio());//.getNombre()
                //########################################33
                         }
        }


        
    }
    
    public static void registrarAtencion(ArrayList<Atencion> atenciones , ArrayList<Cita> citas, ArrayList<Empleado> empleados){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese numero de cedula del cliente: ");
        String cedula = sc.nextLine();
        //Se busca la cedula dentro de las citas
        for(int i =0; i< citas.size(); i++){
            if(cedula.equals(citas.get(i).getCliente().getCedula())){
                System.out.println("Ingrese la cedula del empleado que realizo la atencion: ");
                String empleado = sc.nextLine();
                for(int j = 0; j<empleados.size(); j++){
                    if(empleado.equals(empleados.get(j).getCedula())){
                        System.out.println("Ingrese la duracion de la atencion en minutos: ");
                        int duracion = sc.nextInt();
                        sc.nextLine();
                        atenciones.add(new Atencion(citas.get(i).getCliente(),empleados.get(j), duracion, citas.get(i)));
                    }else if (i == empleados.size() - 1) {
                        System.out.println("No se encontro empleado con esa cedula.");
                    }
                }
            } else if (i == citas.size() - 1){
                System.out.println("No se encontro cita para ese cliente.");
            } 
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getDuracionAtencion() {
        return duracionAtencion;
    }

    public void setDuracionAtencion(int duracionAtencion) {
        this.duracionAtencion = duracionAtencion;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }
    
    @Override
    public String toString(){
        return "";
    }   
    
}
