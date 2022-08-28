/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelo.Cliente;

/**
 * FXML Controller class
 *
 * @author Carlos Saikotek
 */
public class NewClienteController  {

    @FXML
    private TextField txtCedulaCl;
    @FXML
    private TextField txtNombreCl;
    @FXML
    private TextField txtPhoneCl;
    @FXML
    private TextField txtEmailCl;
    @FXML
    private TextField txtCedulaRep;
    @FXML
    private TextField txtNombreRep;
    @FXML
    private TextField txtPhoneRep;
    @FXML
    private TextField txtEmailRep;
    @FXML
    private Button guardarButton;
    @FXML
    private Button cancelarButton;

@FXML
    private void editarCliente()throws Exception{
        boolean flag = false;
        ArrayList<Cliente> clientes = Cliente.cargarClientes("src/main/resources/TXT/clientes.txt");
        for(int i =0 ; i<clientes.size();i++){
            if(txtCedulaCl.getText().equals(clientes.get(i).getCedula())){
                clientes.get(i).setNombre(txtNombreCl.getText());
                clientes.get(i).setTelefono(txtPhoneCl.getText());
                clientes.get(i).setEmail(txtEmailCl.getText());
                i=clientes.size();
            flag = true;}else if (i == clientes.size() - 1) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                    alert.setHeaderText("Resultado de la operación");
                    alert.setContentText("Cliente no encontrado");

                    alert.showAndWait();
                    App.setRoot("editarCliente");
                    
             }}
        if (flag==true){
                try {
                    FileWriter writer = new FileWriter(new File("src/main/resources/TXT/clientes.txt"));
                    BufferedWriter bw = new BufferedWriter(writer);
                    bw.write("cedula, nombre, telefono, correo, cedulaRepresentante");
                    bw.newLine();
                    for(int x=0; x<clientes.size();x++){
                        bw.write(clientes.get(x).getCedula()+", "+
                        clientes.get(x).getNombre()+", "+
                        clientes.get(x).getTelefono()+", "+
                        clientes.get(x).getEmail()+", "+
                        clientes.get(x).getCedulaRepresentante());
                        bw.newLine();
                    }
                    bw.close();
                    System.out.println(clientes.toString());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Resultado de la operación");
                    alert.setContentText("Cliente Editado Exitosamente");

                    alert.showAndWait();
                    App.setRoot("clientes");
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
        }
                
    }
        
    
    
    
    @FXML
    private void guardarCliente() {
        ArrayList<Cliente> clientes = Cliente.cargarClientes("src/main/resources/TXT/clientes.txt");//cargar la lista del archivo
        System.out.println("Guardando cliente");
        
        Cliente cl = new Cliente(txtCedulaCl.getText(), 
                                  txtNombreCl.getText(), 
                                  txtPhoneCl.getText(),
                                  txtEmailCl.getText(),
                                  txtCedulaRep.getText());
        clientes.add(cl);
        System.out.println("Nuevo Cliente:" + cl);
        
        //serializar la lista
        try {
        FileWriter writer = new FileWriter("src/main/resources/TXT/empleados.txt", true);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write(cl.getCedula()+", "+
                 cl.getNombre()+", "+
                 cl.getTelefono()+", "+
                 cl.getEmail()+", "+
                 cl.getCedulaRepresentante());
        bw.newLine();
        
        bw.close();

            //mostrar informacion
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Nuevo Cliente agregado exitosamente");

            alert.showAndWait();
            App.setRoot("clientes");

        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        } 
    }
    

        
        @FXML
        public void switchToClientes() throws Exception {
            App.setRoot("clientes");
        }
    
   
    
}
