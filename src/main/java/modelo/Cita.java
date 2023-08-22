/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Cita implements Serializable{
    private Cliente cliente;
    private String fecha; //formato dd/mm/aa
    private String time; //formato hh:mm 
    private Empleado empleado;
    private Servicio servicio;

    public Cita(Cliente cliente, String fecha, String time, Empleado empleado, Servicio servicio) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.time = time;
        this.empleado = empleado;
        this.servicio = servicio;
    }

    public Cita(String fecha, String time) {
        this.fecha = fecha;
        this.time = time;
    }

    public Cita(String fecha) {
        this.fecha = fecha;
    }
    

    @Override
    public String toString() {
        return fecha +" " + time;
    }
   
    
    //metodo crear cita //Date fecha, LocalTime time, 
    public static void crearCita(ArrayList <Cita> citas, ArrayList<Cliente> clientes, ArrayList<Empleado> empleados, ArrayList<Servicio> servicios){
        Scanner entrada = new Scanner(System.in);
        System.out.println("***Crear Cita***");
        
        System.out.println("Ingrese cedula del cliente: ");
        String cedula1 = entrada.nextLine();
        int i;
        for (i = 0; i<clientes.size(); ++i){
            if (cedula1.equals(clientes.get(i).getCedula())){
                System.out.println("Ingrese el servicio: ");
                String asistencia = entrada.nextLine();
                for (int a = 0; a<servicios.size(); a++){
                    if (asistencia.equals(servicios.get(a))){//.getNombre()
                        //########################3
                        int x=0;
                        while (x<citas.size()){
                            System.out.println("Ingrese fecha cita con formato dd/mm/aa: ");
                            String fecha = entrada.nextLine();
                   
                            System.out.println("Ingrese hora cita con formato hh:mm: ");
                            String time = entrada.nextLine();
                            for(int j =0; j < citas.size();j++){
                                for(int e =0; e < citas.size(); e++){
                                    if(fecha.equals(citas.get(j).getFecha())&& time.equals(citas.get(e).getTime())){
                                        System.out.println("Horario no diaponible");
                                    }
                                    else {
//                                        citas.add(new Cita(clientes.get(i), fecha, time, servicios.get(a).getEmpleado(), servicios.get(a)));
                                        //citas.add(new Cita(clientes.get(i), fecha, time, servicios.get(a).getEmpleado(), servicios.get(a)));
                                        //########################################3333
                                        x = citas.size();
                                        e = citas.size();
                                        j = citas.size();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    //eliminar cita
    public static void eliminarCita(ArrayList <Cita> citas){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese cedula del cliente: ");
        String cedula2 = entrada.nextLine();
        //String fechaActual = "15/7/2022";
        ArrayList<String> fechas = new ArrayList<>();
        System.out.println("Fechas de citas pedientes: ");
        for (int i = 0; i < citas.size(); ++i) {
            if (cedula2.equals(citas.get(i).getCliente().getCedula())) {
                System.out.println(citas.get(i).getFecha());
                fechas.add(citas.get(i).getFecha());
                //if (citas.getFecha()<fechaActual){ 
            }
        }
        if (fechas.isEmpty()) {
            System.out.println("No hay mas citas pendientes");
        } else {
            System.out.println("Escriba la fecha de la cita que desea eliminar [dd/mm/yy].");
            String fecha = entrada.nextLine();
            for (int i = 0; i < citas.size(); i++) {
                if (fecha.equals(citas.get(i).getFecha()) && cedula2.equals(citas.get(i).getCliente().getCedula())) {
                    citas.remove(i);
                }
            }

        }
    }

           
    public static void consultarCita(ArrayList <Cita> citas){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese fecha de la cita con formato dd/mm/aa: ");
        String fecha = entrada.nextLine();
        for (int e = 0; e<citas.size(); ++e){
            if (fecha.equals(citas.get(e).getFecha())){
                System.out.println("Cliente: "+ citas.get(e).getCliente().getNombre()+", Fecha: "+citas.get(e).getFecha()
                        +", Hora: "+citas.get(e).getTime()+", Servicio: "+citas.get(e).getServicio());//.getNombre()
                //###########################################################
            }else if (e == citas.size() - 1){
                System.out.println("No hay mas citas agendadas");
            }
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public String getTime() {
        return time;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Servicio getServicio() {
        return servicio;
    }
    
    //CREAR EL ARCHIVO dataRegistros
    public static void crearDataCita(){
        //AL PRINCIPIO SE GUARDA UN OBJETO DE TIPO ARRAYLIST VACIO PERO NO REGISTRA NADA NINGUNCARACTER 
        //AL PRINCIPIO ME SALIO UNA EXCEPCION QUE NO ENCONTRABA EL FICHERO
        ArrayList<Cita> lista = new ArrayList<>();
        try(ObjectOutputStream escribir = new ObjectOutputStream (new FileOutputStream("src\\main\\resources\\TXT\\dataCita.txt"))){
            escribir.writeObject(lista);
            escribir.flush();
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    //RECUPERANDO dataCita
    public static ArrayList<Cita> recuperarDataCita(){
        ArrayList<Cita> listaCitas = new ArrayList<>();
        try(ObjectInputStream leer = new ObjectInputStream(new FileInputStream("src\\main\\resources\\TXT\\dataCita.txt"))){
            listaCitas = (ArrayList<Cita>)leer.readObject();
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return listaCitas;
        }
    public static void actualizarCita(Cita c){
            ArrayList<Cita> citaActualizada = recuperarDataCita();
            citaActualizada.add(c);
            try(ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("src\\main\\resources\\TXT\\dataCita.txt"))){
                escribir.writeObject(citaActualizada);
                escribir.flush();
            }
            catch(FileNotFoundException e){
                System.err.println(e.getMessage());
            }
            catch(IOException e){
                System.err.println(e.getMessage());
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }    
    
}
