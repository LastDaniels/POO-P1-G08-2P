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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Empleado;

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
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        guardarButton.setOnMouseClicked(e->{
           
        });
        
        realizarButton.setOnMouseClicked(e->{
            try {
                App.setRoot("primary");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
           
        });
        
        // TODO
    }    
    
}
