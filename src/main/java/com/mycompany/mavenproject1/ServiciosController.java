/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Empleado;
import modelo.Servicio;


/**
 * FXML Controller class
 *
 * @author Daniel
 * 
 * 
 */
public class ServiciosController  {
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
    private TableColumn<Servicio, String> empleadoColumn;

    @FXML
    private TableColumn<Servicio, String> precioColumn;

    @FXML
    private TableView<Servicio> serviciosTableView;

    /**
     * Initializes the controller class.
     */
    
    public void initialize() {
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        empleadoColumn.setCellValueFactory(new PropertyValueFactory<>("nombreEmpleado"));
        duracionColumn.setCellValueFactory(new PropertyValueFactory<>("duracion"));
        precioColumn.setCellValueFactory(new PropertyValueFactory<>("precio"));
        estadoColumn.setCellValueFactory(new PropertyValueFactory<>("estado"));
        
        
        serviciosTableView.getItems().setAll(Servicio.cargarServicios("src/main/resources/TXT/servicios.txt"));
     
    }   
    @FXML
    private void editarServicio() throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("editServicio.fxml"));//no tiene el controlador especificado
        NewServicioController ct = new NewServicioController();

        fxmlLoader.setController(ct);//se asigna el controlador

        App.setRoot("editServicio");
        ArrayList<Servicio> servicios = Servicio.cargarServicios("src/main/resources/TXT/servicios.txt");
        for(Servicio servicio:servicios){
            System.out.println(servicio.toString());
        }
    }

    @FXML
    private void eliminarServicio() throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("elimServicio.fxml"));//no tiene el controlador especificado
        NewServicioController ct = new NewServicioController();

        fxmlLoader.setController(ct);//se asigna el controlador

        App.setRoot("elimServicio");
        
    }
    @FXML
    public void nuevoServicio() throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("agregarServicio.fxml"));//no tiene el controlador especificado
        NewServicioController ct = new NewServicioController();

        fxmlLoader.setController(ct);//se asigna el controlador

        App.setRoot("agregarServicio");


    }
    
    @FXML
    public void cancelar() throws Exception{
        App.setRoot("MENU");
    }
}
