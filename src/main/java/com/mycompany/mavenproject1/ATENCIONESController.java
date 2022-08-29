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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Actividad;
import modelo.Atencion;
import modelo.Cita;

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
    private TableColumn<Atencion, String> fechaColumn;
    @FXML
    private TableColumn<Atencion, String> clienteColumn;
    @FXML
    private TableColumn<Atencion, String> tiempoColumn;
    @FXML
    private TableColumn<Atencion, String> terapistaColumn;
    @FXML
    private TableView<Atencion> atencionesTableView;
     @FXML
    private Button menuButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarAtenciones();
        buscarButton.setOnMouseClicked(e->{
           
        });
        menuButton.setOnMouseClicked(e->{
            try {
                App.setRoot("MENU");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
           
        });
        // TODO
    }
    public void cargarAtenciones(){
        clienteColumn.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        terapistaColumn.setCellValueFactory(new PropertyValueFactory<>("empleado"));
        tiempoColumn.setCellValueFactory(new PropertyValueFactory<>("duracionAtencion"));
        fechaColumn.setCellValueFactory(new PropertyValueFactory<>("cita"));
        
        atencionesTableView.getItems().addAll(Atencion.cargarListaAtencion("src\\main\\resources\\TXT\\atenciones.txt"));
    }
    
}
