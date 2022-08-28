/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Cliente;

/**
 * FXML Controller class
 *
 * @author Carlos 
 */
public class ClientesController {

    @FXML
    private Button agregarClienteButton;
    @FXML
    private Button editarClienteButton;
    @FXML
    private TableView<Cliente> tvClientes;
    @FXML
    private TableColumn<Cliente, String> colCedula;
    @FXML
    private TableColumn<Cliente, String> colNombre;
    @FXML
    private TableColumn<Cliente, String> colPhone;
    @FXML
    private TableColumn<Cliente, String> colEmail;
    @FXML
    private TableColumn<Cliente, String> colNombreRepr;
    @FXML
    private Button regresarButton;

    /**
     * Initializes the controller class.
     */

    public void initialize() {

        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colNombreRepr.setCellValueFactory(new PropertyValueFactory<>("cedulaRepresentante"));
        
        tvClientes.getColumns().setAll(colCedula, colNombre, colPhone, colEmail, colNombreRepr);
        tvClientes.getItems().setAll(Cliente.cargarClientes("src/main/resources/TXT/clientes.txt"));

    }

    public void llenarTableView() {
        tvClientes.getItems().setAll(Cliente.cargarClientes("src/main/resources/TXT/clientes.txt"));
    }
    
    @FXML
    private void editarCliente() throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("editarCliente.fxml"));//no tiene el controlador especificado
        NewClienteController ct = new NewClienteController();

        fxmlLoader.setController(ct);//se asigna el controlador

        App.setRoot("editarCliente");
    }

      
    
    @FXML
    public void nuevoCliente() throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("agregarCliente.fxml"));//no tiene el controlador especificado
        NewClienteController ct = new NewClienteController();

        fxmlLoader.setController(ct);//se asigna el controlador

        App.setRoot("agregarCliente");


    }
    
    @FXML
    public void cancelar() throws Exception{
        App.setRoot("MENU");
    }

}
