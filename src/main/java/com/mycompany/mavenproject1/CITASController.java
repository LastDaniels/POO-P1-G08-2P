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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Cita;
import modelo.Cliente;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class CITASController implements Initializable {

    @FXML
    private TextField nombreTextField;
    @FXML
    private DatePicker fechaDatePicker;
    @FXML
    private Button buscarButton;
    @FXML
    private TableView<Cita> citasTableView;
    @FXML
    private TableColumn<Cita, String> nombreColumn;
    @FXML
    private TableColumn<Cita, String> terapsitaColumn;
    @FXML
    private TableColumn<Cita, String> serviciosColumn;
    @FXML
    private TableColumn<Cita, String> fechaColumn;
    @FXML
    private TableColumn<Cita, String> horaColumn;
    @FXML
    private Button crearButton;
    @FXML
    private Button registrarButton;
    @FXML
    private Button consultarButton;
    @FXML
    private Button menuButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //mostrarAlerta(Alert.AlertType.INFORMATION, "Seleccione un registro");
        cargarCitaRegistro();
        crearAtencion();
        bucarCita();
        
        crearButton.setOnMouseClicked(e->{
            try {
                App.setRoot("CREARCITA");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        
        consultarButton.setOnMouseClicked(e->{
            try {
                App.setRoot("CONSULTARACTIVIDAD");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
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
    
    public void cargarCitaRegistro(){
    nombreColumn.setCellValueFactory(new PropertyValueFactory<>("cliente"));
    terapsitaColumn.setCellValueFactory(new PropertyValueFactory<>("empleado"));
    serviciosColumn.setCellValueFactory(new PropertyValueFactory<>("servicio"));
    fechaColumn.setCellValueFactory(new PropertyValueFactory<>("fecha"));
    horaColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
    citasTableView.getItems().setAll(Cita.recuperarDataCita());
    }
    
    public void crearAtencion(){
        
        registrarButton.setOnMouseClicked(e->{
                App.citas = (Cita) citasTableView.getSelectionModel().getSelectedItem();
                try {
                    App.setRoot("REGISTRARATENCION");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            
        });
    }
    public void bucarCita(){
        buscarButton.setOnMouseClicked(e->{
            String nombre = nombreTextField.getText();
            String fecha = String.valueOf(fechaDatePicker.getValue());
            if(nombre.isEmpty() || fecha.isEmpty()){
                mostrarAlerta(Alert.AlertType.ERROR, "Ingrese datos");
            }else{
                cargarCitaRegistroBusqueda(nombre, fecha);
                
            }
        });
    }
    
    public void cargarCitaRegistroBusqueda(String nombre, String fecha){
        
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        terapsitaColumn.setCellValueFactory(new PropertyValueFactory<>("empleado"));
        serviciosColumn.setCellValueFactory(new PropertyValueFactory<>("servicio"));
        fechaColumn.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        horaColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        for (Cita c:Cita.recuperarDataCita()){
//            Cliente n = new Cliente(nombre);
//            Cita f = new Cita(fecha);
            if(nombre.equals(c.getCliente()) || fecha.equals(c.getFecha())){
                citasTableView.getItems().setAll(c);
            }else{
                mostrarAlerta(Alert.AlertType.INFORMATION, "NO SE HA ENCONTRADO REGISTRO DE CITA");
            }
        } 
    }
    public static void mostrarAlerta(Alert.AlertType tipo, String mensaje) {
        Alert alert = new Alert(tipo);

        alert.setTitle("Resultado de operacion");
        alert.setHeaderText("Notificacion");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
