/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author LENOVO
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;


public class Cliente extends Persona implements Comparable<Cliente>, Serializable{
    private String cedulaRepresentante;
    
    public String getCedulaRepresentante(){
        return cedulaRepresentante;
    }
    
    public void setCedulaRepresentante(String cedulaRepresentante){
        this.cedulaRepresentante = cedulaRepresentante;
    }
    
    
    //Constructor Cliente
    public Cliente(String cedula, String nombre, String telefono, String email, String cedulaRepresentante){
        super(cedula, nombre, telefono, email);
        this.cedulaRepresentante = cedulaRepresentante;
    }

    public Cliente(String nombre) {
        super(nombre);
    }
    

    @Override
    public int compareTo(Cliente cl) {
        return getNombre().compareTo(cl.getNombre());
    }

    @Override
    public String toString() {
        return super.toString();
    }

    
    
    

//    @Override
//    public String toString() {
//        return super.toString() +", Cliente{" + "cedulaRepresentante=" + cedulaRepresentante + '}'+"}";
//    }

  
    public static ArrayList<Cliente> cargarClientes(String ruta){
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(ruta))){
            String sCurrentLine;
            
            br.readLine();
            while((sCurrentLine = br.readLine())!=null){
                String[] datos = sCurrentLine.split(",");
                Cliente cl = new Cliente(datos[0], datos[1], datos[2], datos[3], datos[4]);
                clientes.add(cl);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no existe");
        } catch (IOException   ex) {
            System.out.println("Error io:"+ex.getMessage());
        } 
        return clientes;
    }
}
