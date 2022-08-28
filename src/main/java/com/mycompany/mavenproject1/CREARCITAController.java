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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class CREARCITAController implements Initializable {

    @FXML
    private TextField nombreTextField;
    @FXML
    private TextField terapistaTextField;
    @FXML
    private TextField servicioTextField;
    @FXML
    private TextField horaTextField;
    @FXML
    private TextField empleadoTextField;
    @FXML
    private DatePicker fechaDatePicker;
    @FXML
    private Button guardarButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        guardarButton.setOnMouseClicked(e->{
            try {
                App.setRoot("CITAS");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        // TODO
    }    
    
}
