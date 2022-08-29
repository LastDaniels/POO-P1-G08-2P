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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Actividad;
import modelo.Jugador;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class CONSULTARACTIVIDADController implements Initializable {

    @FXML
    private Label clienteLabel;
    @FXML
    private TableColumn<Jugador, String> actividadColumn;
    @FXML
    private TableColumn<Jugador, String> fechaColumn;
    @FXML
    private TableColumn<Jugador, String> aciertosColumn;
    @FXML
    private TableColumn<Jugador, String> fallosColumn;
    @FXML
    private TableColumn<Jugador, String> tiempoColumn;
    @FXML
    private TableView<Jugador> actividadesTableView;
    @FXML
    private Button citaButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        citaButton.setOnMouseClicked(e->{
            try {
                App.setRoot("CITAS");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        actividadColumn.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        fechaColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        fallosColumn.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        aciertosColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        tiempoColumn.setCellValueFactory(new PropertyValueFactory<>("estado"));
        
        actividadesTableView.getItems().setAll(App.jugadores);
        // TODO
    }    
    
}
