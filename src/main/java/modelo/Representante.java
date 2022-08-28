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
public class Representante extends Persona implements Comparable<Representante>{
    
     //constructor Representante
    public Representante(String cedula, String nombre, String telefono, String email){
        super(cedula, nombre, telefono, email);
    }
    
    @Override
    public int compareTo(Representante r) {
        return getNombre().compareTo(r.getNombre());
    }
    
    public static ArrayList<Representante> cargarRepresentantes(String ruta){
        ArrayList<Representante> representantes = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(ruta))){
            String sCurrentLine;
            
            br.readLine();
            while((sCurrentLine = br.readLine())!=null){
                String[] datos = sCurrentLine.split(", ");
                Representante r = new Representante(datos[0], datos[1], datos[2], datos[3]);
                representantes.add(r);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no existe");
        } catch (IOException   ex) {
            System.out.println("Error io:"+ex.getMessage());
        } 
        return representantes;
    }
}
