/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
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
import modelo.Servicio;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class NewServicioController {
    
    @FXML
    TextField txNombreOld;
    
    @FXML
    TextField txNombre;
    
    @FXML
    TextField txCedula;
    
    @FXML
    TextField txDuracion;
    
    @FXML
    TextField txPrecio;
    
    @FXML
    TextField txEstado;
    
    @FXML
    private void editarServicio()throws Exception{
        ArrayList<Empleado> empleados = Empleado.cargarEmpleados("src/main/resources/TXT/empleados.txt");//cargar la lista del archivo
        boolean flag = false;
        ArrayList<Servicio> servicios = Servicio.cargarServicios("src/main/resources/TXT/servicios.txt");
        
        for(int i =0 ; i<servicios.size();i++){
            if(txNombreOld.getText().equals(servicios.get(i).getNombre())){
                for(int y =0; y<empleados.size();y++){
                    if(txCedula.getText().equals(empleados.get(y).getCedula())){
                        servicios.get(i).setNombre(txNombre.getText());
                        servicios.get(i).setDuracion(Integer.parseInt(txDuracion.getText()));
                        servicios.get(i).setEmpleado(empleados.get(y));
                        servicios.get(i).setPrecio(Double.parseDouble(txPrecio.getText()));
                        i=servicios.size();
                        y=empleados.size();
                        flag = true;
                    }else if(y==empleados.size()-1){
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Information Dialog");
                            alert.setHeaderText("Resultado de la operación");
                            alert.setContentText("Empleado no encontrado");

                            alert.showAndWait();
                            App.setRoot("editServicios");}}}
            else if (i == servicios.size() - 1) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                    alert.setHeaderText("Resultado de la operación");
                    alert.setContentText("Empleado no encontrado");

                    alert.showAndWait();
                    App.setRoot("editEmpleado");
                    
             }}
        if (flag==true){
                try {
                    FileWriter writer = new FileWriter(new File("src/main/resources/TXT/servicios.txt"));
                    BufferedWriter bw = new BufferedWriter(writer);
                    bw.write("nombre,empleado,duracion,precio,estado");
                    bw.newLine();
                    for(int x=0; x<servicios.size();x++){
                        bw.write(servicios.get(x).getNombre()+","+
                        servicios.get(x).getNombreEmpleado()+","+
                        servicios.get(x).getDuracion()+","+
                        servicios.get(x).getPrecio()+","+
                        servicios.get(x).getEstado());
                        bw.newLine();
                    }
                    bw.close();
                    System.out.println(servicios.toString());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Resultado de la operación");
                    alert.setContentText("Servicio Editado Exitosamente");

                    alert.showAndWait();
                    App.setRoot("MENU");
                    
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
        }   
                
    }
        
    
    
    
    @FXML
    private void guardarServicio() throws Exception{
        ArrayList<Empleado> empleados = Empleado.cargarEmpleados("src/main/resources/TXT/empleados.txt");//cargar la lista del archivo
        System.out.println("Guardando empleado");
        ArrayList<Servicio> servicios = Servicio.cargarServicios("src/main/resources/TXT/servicios.txt");//cargar la lista del archivo
        for(int y =0; y<empleados.size();y++){
                    if(txCedula.getText().equals(empleados.get(y).getCedula())){
                            Servicio s = new Servicio(txNombre.getText(),
                                                        empleados.get(y).getNombre(),
                                                        empleados.get(y),
                                                        Integer.parseInt(txDuracion.getText()), 
                                                        Double.parseDouble(txPrecio.getText()),
                                                        "Activo"
                                                        );
                            servicios.add(s);
                          
                            
                            try {
                                FileWriter writer = new FileWriter("src/main/resources/TXT/servicios.txt", true);
                                BufferedWriter bw = new BufferedWriter(writer);
                                bw.write(s.getNombre()+","+
                                s.getNombreEmpleado()+","+
                                s.getDuracion()+","+
                                s.getPrecio()+","+
                                s.getEstado());
                                bw.newLine();
        
                                bw.close();

            //mostrar informacion
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Nuevo Empleado agregado exitosamente");

            alert.showAndWait();
            App.setRoot("MENU");
            y=empleados.size();               
        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        } }
                    
                    else if(y==empleados.size()-1){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                    alert.setHeaderText("Resultado de la operación");
                    alert.setContentText("Servicio no encontrado");

                    alert.showAndWait();
                    App.setRoot("elimEmp");
        
                    }
        }
    }
    
    @FXML
    private void eliminarServicio()throws Exception{
        boolean flag = false;
        ArrayList<Servicio> servicios = Servicio.cargarServicios("src/main/resources/TXT/servicios.txt");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText("¿Estas seguro de confirmar la acción?");
        Optional<ButtonType> action = alert.showAndWait();
        
        if(action.get() == ButtonType.OK) {
        for(int i =0 ; i<servicios.size();i++){
            if(txNombre.getText().equals(servicios.get(i).getNombre())){
                servicios.get(i).setEstado("Inactivo");
                i=servicios.size();
                flag = true;}
            else if (i == servicios.size() - 1) {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Information Dialog");
                    alert2.setHeaderText("Resultado de la operación");
                    alert2.setContentText("Servicio no encontrado");

                    alert2.showAndWait();
                    App.setRoot("elimEmp");
                    
             }}}
        if(flag==true){
                try {
                    FileWriter writer = new FileWriter(new File("src/main/resources/TXT/servicios.txt"));
                    BufferedWriter bw = new BufferedWriter(writer);
                    bw.write("nombre,empleado,duracion,precio,estado");
                    bw.newLine();
                    for(int x=0; x<servicios.size();x++){
                        bw.write(servicios.get(x).getNombre()+","+
                        servicios.get(x).getNombreEmpleado()+","+
                        servicios.get(x).getDuracion()+","+
                        servicios.get(x).getPrecio()+","+
                        servicios.get(x).getEstado());
                        bw.newLine();
                    }
                    bw.close();
                    System.out.println(servicios.toString());
                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setTitle("Information Dialog");
                    alert2.setHeaderText("Resultado de la operación");
                    alert2.setContentText("Servicio en estado Inactivo");

                    alert2.showAndWait();
                    App.setRoot("MENU");
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
        }
    }
        
        @FXML
        public void switchToServicios() throws Exception {
            App.setRoot("servicios");
        }
   
    
}

