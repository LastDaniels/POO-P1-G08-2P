/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
    private void editarEmpleado()throws Exception{
        boolean flag = false;
        ArrayList<Empleado> empleados = Empleado.cargarEmpleados("src/main/resources/TXT/empleados.txt");
        for(int i =0 ; i<empleados.size();i++){
            if(txCed.getText().equals(empleados.get(i).getCedula())){
                empleados.get(i).setNombre(txNombre.getText());
                empleados.get(i).setTelefono(txTelf.getText());
                empleados.get(i).setEmail(txEmail.getText());
                i=empleados.size();
            flag = true;}else if (i == empleados.size() - 1) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                    alert.setHeaderText("Resultado de la operación");
                    alert.setContentText("Empleado no encontrado");

                    alert.showAndWait();
                    App.setRoot("editEmpleado");
                    
             }}
        if (flag==true){
                try {
                    FileWriter writer = new FileWriter(new File("src/main/resources/TXT/empleados.txt"));
                    BufferedWriter bw = new BufferedWriter(writer);
                    bw.write("cedula, nombre, telefono, correo, estado");
                    bw.newLine();
                    for(int x=0; x<empleados.size();x++){
                        bw.write(empleados.get(x).getCedula()+", "+
                        empleados.get(x).getNombre()+", "+
                        empleados.get(x).getTelefono()+", "+
                        empleados.get(x).getEmail()+", "+
                        empleados.get(x).getEstado());
                        bw.newLine();
                    }
                    bw.close();
                    System.out.println(empleados.toString());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Resultado de la operación");
                    alert.setContentText("Empleado Editado Exitosamente");

                    alert.showAndWait();
                    App.setRoot("MENU");
                } catch (IOException ioe) {
                    ioe.printStackTrace();
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
            alert.setContentText("Nuevo Empleado agregado exitosamente");

            alert.showAndWait();
            App.setRoot("MENU");

        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        } 
    }
    
    @FXML
    private void eliminarEmpleado()throws Exception{
        ArrayList<Empleado> empleados = Empleado.cargarEmpleados("src/main/resources/TXT/empleados.txt");
        boolean flag = false;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText("¿Estas seguro de confirmar la acción?");
        Optional<ButtonType> action = alert.showAndWait();
        
        if(action.get() == ButtonType.OK) {        

        for(int i =0 ; i<empleados.size();i++){
            if(txCed.getText().equals(empleados.get(i).getCedula())){
                empleados.get(i).setEstado("Inactivo");
                i=empleados.size();
                flag = true;}
            else if (i == empleados.size() - 1) {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Information Dialog");
                    alert2.setHeaderText("Resultado de la operación");
                    alert2.setContentText("Empleado no encontrado");

                    alert2.showAndWait();
                    App.setRoot("elimEmp");
                    
             }}}
        if(flag==true){
                try {
                    FileWriter writer = new FileWriter(new File("src/main/resources/TXT/empleados.txt"));
                    BufferedWriter bw = new BufferedWriter(writer);
                        bw.write("cedula, nombre, telefono, correo, estado");
                    bw.newLine();
                    for(int x=0; x<empleados.size();x++){
                        bw.write(empleados.get(x).getCedula()+", "+
                        empleados.get(x).getNombre()+", "+
                        empleados.get(x).getTelefono()+", "+
                        empleados.get(x).getEmail()+", "+
                        empleados.get(x).getEstado());
                        bw.newLine();
                    }
                    bw.close();
                    System.out.println(empleados.toString());
                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setTitle("Information Dialog");
                    alert2.setHeaderText("Resultado de la operación");
                    alert2.setContentText("Empleado en estado Inactivo");

                    alert2.showAndWait();
                    App.setRoot("MENU");
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
        }
    }
        
        @FXML
        public void switchToEmpleados() throws Exception {
            App.setRoot("empleados");
        }
    
}

