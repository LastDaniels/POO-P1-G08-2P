/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Atencion;
import modelo.Cita;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Servicio;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class REGISTRARATENCIONController implements Initializable {

    @FXML
    private Label horaLabel;
    @FXML
    private Label clienteLabel;
    @FXML
    private TextField tiempoTextField;
    @FXML
    private ComboBox<Empleado> terapistaComboBox;
    @FXML
    private Button guardarButton;
    @FXML
    private Button realizarButton;

    /**
     * Initializes the controller class.
     * C:\Users\LENOVO\Desktop\POO-P1-G08-2P\src\main\resources\TXT\servicios.txt
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        horaLabel.setText(App.citas.getFecha()+App.citas.getTime());
        clienteLabel.setText(String.valueOf(App.citas.getCliente()));
        for (Servicio s: Servicio.cargarServicios("src\\main\\resources\\TXT\\servicios.txt")){
            terapistaComboBox.getItems().add(s.getEmpleado());
        
        }
        
    }    
    public void guaradarAtención(){
        guardarButton.setOnMouseClicked(e->{
            String tiempoReal = tiempoTextField.getText();
            if(tiempoReal.isEmpty()){
                mostrarAlerta(Alert.AlertType.ERROR, "Ingrese un valor");
            }else{
                Cita c = new Cita(App.citas.getFecha(),App.citas.getTime());
                Cliente cli = new Cliente(String.valueOf(App.citas.getCliente()));
                Empleado em = new Empleado(String.valueOf(App.citas.getEmpleado()));
                
                
                Atencion a = new Atencion(cli,em,Integer.valueOf(tiempoReal),c);
            
            }
           
        });
        
        realizarButton.setOnMouseClicked(e->{
            try {
                App.setRoot("primary");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
           
        });
    
    }
    public static void mostrarAlerta(Alert.AlertType tipo, String mensaje) {
        Alert alert = new Alert(tipo);

        alert.setTitle("Resultado de operacion");
        alert.setHeaderText("Notificacion");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}

