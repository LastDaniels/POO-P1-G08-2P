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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modelo.Servicio;


/**
 * FXML Controller class
 *
 * @author Daniel
 * 
 * 
 */
public class ServiciosController implements Initializable {
    @FXML
    private Button agregarButton;

    @FXML
    private TableColumn<Servicio, String> duracionColumn;

    @FXML
    private Button editarButton;

    @FXML
    private Button eliminarButton;

    @FXML
    private TableColumn<Servicio, String> estadoColumn;

    @FXML
    private TableColumn<Servicio, String> nombreColumn;

    @FXML
    private TableColumn<Servicio, String> precioColumn;

    @FXML
    private TableView<Servicio> serviciosTableView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
