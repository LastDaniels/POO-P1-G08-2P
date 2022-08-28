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
import modelo.Representante;

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
        boolean flag1 = false;
        boolean flag2 = false;
        
        ArrayList<Cliente> clientes = Cliente.cargarClientes("src/main/resources/TXT/clientes.txt");
        ArrayList<Representante> representantes = Representante.cargarRepresentantes("src/main/resources/TXT/representantes.txt");
        
        for(int i =0 ; i<clientes.size();i++){
            
            if(txtCedulaCl.getText().equals(clientes.get(i).getCedula())){
                clientes.get(i).setNombre(txtNombreCl.getText());
                clientes.get(i).setTelefono(txtPhoneCl.getText());
                clientes.get(i).setEmail(txtEmailCl.getText());
                //clientes.get(i).getCedulaRepresentante();
                
                
                for(int j =0 ; j<representantes.size();j++){
                    
                    if(txtCedulaRep.getText().equals(representantes.get(j).getCedula())){
                        representantes.get(j).setNombre(txtNombreRep.getText());
                        representantes.get(j).setTelefono(txtPhoneRep.getText());
                        representantes.get(j).setEmail(txtEmailRep.getText());
                        j=clientes.size();
                        flag2 = true; 
                        
                    }else if (j == representantes.size() - 1) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Information Dialog");
                            alert.setHeaderText("Resultado de la operación");
                            alert.setContentText("Representante no encontrado");

                            alert.showAndWait();
                            //App.setRoot("editarCliente");
                    }
                }
                
                if (flag2==true){
                    
                        try {
                            FileWriter writer1 = new FileWriter(new File("src/main/resources/TXT/representantes.txt"));
                            BufferedWriter bw1 = new BufferedWriter(writer1);
                            bw1.write("cedula, nombre, telefono, correo");
                            bw1.newLine();
                            
                            for(int z=0; z<representantes.size();z++){
                                bw1.write(representantes.get(z).getCedula()+", "+
                                representantes.get(z).getNombre()+", "+
                                representantes.get(z).getTelefono()+", "+
                                representantes.get(z).getEmail());
                                bw1.newLine();
                            }
                            
                            bw1.close();
                            System.out.println(representantes.toString());
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Information Dialog");
                            alert.setHeaderText("Resultado de la operación");
                            alert.setContentText("Representante Editado Exitosamente");

                            alert.showAndWait();
                            //App.setRoot("clientes");
                            
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                }
                i=clientes.size();
                flag1 = true;
                
            }else if (i == clientes.size() - 1) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                    alert.setHeaderText("Resultado de la operación");
                    alert.setContentText("Cliente no encontrado");

                    alert.showAndWait();
                    App.setRoot("editarCliente");
                    
            }
        }
        if (flag1==true){
                try {
                    FileWriter writer2 = new FileWriter(new File("src/main/resources/TXT/clientes.txt"));
                    BufferedWriter bw2 = new BufferedWriter(writer2);
                    bw2.write("cedula, nombre, telefono, correo, cedulaRepresentante");
                    bw2.newLine();
                    for(int x=0; x<clientes.size();x++){
                        bw2.write(clientes.get(x).getCedula()+", "+
                        clientes.get(x).getNombre()+", "+
                        clientes.get(x).getTelefono()+", "+
                        clientes.get(x).getEmail()+", "+
                        clientes.get(x).getCedulaRepresentante());
                        bw2.newLine();
                    }
                    bw2.close();
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
        ArrayList<Cliente> clientes = Cliente.cargarClientes("src/main/resources/TXT/clientes.txt");
        ArrayList<Representante> representantes = Representante.cargarRepresentantes("src/main/resources/TXT/representantes.txt");
        System.out.println("Guardando cliente");
        
        Cliente cl = new Cliente(txtCedulaCl.getText(), 
                                  txtNombreCl.getText(), 
                                  txtPhoneCl.getText(),
                                  txtEmailCl.getText(),
                                  txtCedulaRep.getText());
        clientes.add(cl);
        Representante r = new Representante(txtCedulaRep.getText(), 
                                  txtNombreRep.getText(), 
                                  txtPhoneRep.getText(),
                                  txtEmailRep.getText());
        representantes.add(r);
        
        System.out.println("Nuevo Cliente:" + cl);
        
        
        try {
        FileWriter writer1 = new FileWriter("src/main/resources/TXT/clientes.txt", true);
        BufferedWriter bw1 = new BufferedWriter(writer1);
        bw1.write(cl.getCedula()+", "+
                 cl.getNombre()+", "+
                 cl.getTelefono()+", "+
                 cl.getEmail()+", "+
                 cl.getCedulaRepresentante());
        bw1.newLine();
        
        bw1.close();
        
        FileWriter writer2 = new FileWriter("src/main/resources/TXT/representantes.txt", true);
        BufferedWriter bw2 = new BufferedWriter(writer2);
        bw2.write(r.getCedula()+", "+
                 r.getNombre()+", "+
                 r.getTelefono()+", "+
                 r.getEmail());
        
        bw2.newLine();
        
        bw2.close();

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
