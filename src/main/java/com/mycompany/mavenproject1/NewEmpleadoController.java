/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import modelo.Empleado;

/**
 *
 * @author Daniel
 */
public class NewEmpleadoController {
    
    @FXML
    TextField txCed;
    
    @FXML
    TextField txNombre;
    
    @FXML
    TextField txTelf;
    
    @FXML
    TextField txEmail;
    
    
    @FXML
    private void editarEmpleado(){
        ArrayList<Empleado> empleados = Empleado.cargarEmpleados("src/main/resources/TXT/empleados.txt");
        for(Empleado e: empleados){
            if (e.getCedula().equals(txCed.getText())){
                e.setNombre(txNombre.getText());
                e.setTelefono(txTelf.getText());
                e.setEmail(txEmail.getText());
                try {
                    FileWriter writer = new FileWriter("src/main/resources/TXT/empleados.txt");
                    BufferedWriter bw = new BufferedWriter(writer);
                    for(int i=0; i<empleados.size();i++){
                        bw.write(empleados.get(i).getCedula()+", "+
                        empleados.get(i).getNombre()+", "+
                        empleados.get(i).getTelefono()+", "+
                        empleados.get(i).getEmail()+", "+
                        empleados.get(i).getEstado());
                        bw.newLine();
                    }
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Resultado de la operación");
                    alert.setContentText("Cliente Editado Exitosamente");

                    alert.showAndWait();
                    App.setRoot("MENU");
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }
    
    
    @FXML
    private void guardarEmpleado() {
        ArrayList<Empleado> empleados = Empleado.cargarEmpleados("src/main/resources/TXT/empleados.txt");//cargar la lista del archivo
        System.out.println("Guardando empleado");
        
        Empleado e = new Empleado(txCed.getText(), 
                                  txNombre.getText(), 
                                  txTelf.getText(),
                                  txEmail.getText(),
                                  "Activo");
        empleados.add(e);//agregar empleado a la lista
        System.out.println("Nuevo Empleado:" + e);
        
        //serializar la lista
        try {
        FileWriter writer = new FileWriter("src/main/resources/TXT/empleados.txt", true);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write(e.getCedula()+", "+
                 e.getNombre()+", "+
                 e.getTelefono()+", "+
                 e.getEmail()+", "+
                 e.getEstado());
        bw.newLine();
        
        bw.close();

            //mostrar informacion
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Nueva persona agregada exitosamente");

            alert.showAndWait();
            App.setRoot("MENU");

        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        } 
    }
}
