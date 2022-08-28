/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.IOException;
import java.io.InputStream;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import modelo.Empleado;
import modelo.Persona;
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
    
    public void llenarTableView() {
        tvEmpleados.getItems().setAll(Empleado.cargarEmpleados("src/main/resources/TXT/empleados.txt"));
    }
    
    @FXML
    private void mostrarDetalle() {
        Empleado e = (Empleado) tvEmpleados.getSelectionModel().getSelectedItem();
        //se puede recuperar el indice del elemento recuperado con getSelectedIndex
        System.out.println(tvEmpleados.getSelectionModel().getSelectedIndex());
        System.out.println(e);

        
        
    }
    @FXML
    public void agregarEmpleado() throws Exception{
        
    }
}
