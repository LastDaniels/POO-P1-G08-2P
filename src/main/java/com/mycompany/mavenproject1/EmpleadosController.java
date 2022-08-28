/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import modelo.Empleado;
/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class EmpleadosController  {
    
    @FXML
    Button btnAgregar;
    
    @FXML
    Button btnEditar;
    
    @FXML
    Button btnEliminar;
    @FXML
    TableView<Empleado> tvEmpleados;
    @FXML
    private TableColumn<Empleado, String> colCedula;
    @FXML
    private TableColumn<Empleado, String> colNombre;
    @FXML
    private TableColumn<Empleado, String> colTelf;
    @FXML
    private TableColumn<Empleado, String> colCorreo;
    @FXML
    private TableColumn<Empleado, String> colEstado;
    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colTelf.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("email"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        
        tvEmpleados.getItems().setAll(Empleado.cargarEmpleados("src/main/resources/TXT/empleados.txt"));
        
        
    }  
    
    
    

    
    @FXML
    private void editarEmpleado() throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("editEmpleado.fxml"));//no tiene el controlador especificado
        NewEmpleadoController ct = new NewEmpleadoController();

        fxmlLoader.setController(ct);//se asigna el controlador

        App.setRoot("editEmpleado");
    }

    @FXML
    private void eliminarEm() throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("elimEmp.fxml"));//no tiene el controlador especificado
        NewEmpleadoController ct = new NewEmpleadoController();

        fxmlLoader.setController(ct);//se asigna el controlador

        App.setRoot("elimEmp");
        
    }
    @FXML
    public void nuevoEmpleado() throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("aggEmpleado.fxml"));//no tiene el controlador especificado
        NewEmpleadoController ct = new NewEmpleadoController();

        fxmlLoader.setController(ct);//se asigna el controlador

        App.setRoot("aggEmpleado");


    }
    
    @FXML
    public void cancelar() throws Exception{
        App.setRoot("MENU");
    }
    
}
