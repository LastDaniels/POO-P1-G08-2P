/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modelo.Actividad;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class CONSULTARACTIVIDADController implements Initializable {

    @FXML
    private Label clienteLabel;
    @FXML
    private TableColumn<Actividad, String> actividadColumn;
    @FXML
    private TableColumn<Actividad, String> fechaColumn;
    @FXML
    private TableColumn<Actividad, String> aciertosColumn;
    @FXML
    private TableColumn<Actividad, String> fallosColumn;
    @FXML
    private TableColumn<Actividad, String> tiempoColumn;
    @FXML
    private TableView<Actividad> actividadesTableView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
