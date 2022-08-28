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
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Cliente;

/**
 * FXML Controller class
 *
 * @author Carlos 
 */
public class ClientesController implements Initializable{

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

    public void initialize(URL url, ResourceBundle rb) {

        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colNombreRepr.setCellValueFactory(new PropertyValueFactory<>("nombreRepresentante"));
        
        tvClientes.getColumns().setAll(colCedula, colNombre, colPhone, colEmail, colNombreRepr);
        tvClientes.getItems().setAll(Cliente.cargarClientes("src/main/resources/TXT/clientes.txt"));

    }

    public void llenarTableView() {
        tvClientes.getItems().setAll(Cliente.cargarClientes("src/main/resources/TXT/clientes.txt"));
    }

}
