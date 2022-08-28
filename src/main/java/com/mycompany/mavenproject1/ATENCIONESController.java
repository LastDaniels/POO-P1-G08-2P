/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import modelo.Actividad;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class ATENCIONESController implements Initializable {

    @FXML
    private TextField empleadoTextField;
    @FXML
    private TextField clienteTextField;
    @FXML
    private DatePicker fechaDatePicker;
    @FXML
    private Button buscarButton;
    @FXML
    private TableColumn<Actividad, String> fechaColumn;
    @FXML
    private TableColumn<Actividad, String> clienteColumn;
    @FXML
    private TableColumn<Actividad, String> tiempoColumn;
    @FXML
    private TableColumn<Actividad, String> terapistaColumn;
    @FXML
    private TableView<Actividad> atencionesTableView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buscarButton.setOnMouseClicked(e->{
           
        });
        // TODO
    }    
    
}
