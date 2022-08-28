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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class MENUController implements Initializable {

    @FXML
    private Button serviciosButton;
    @FXML
    private Button citasButton;
    @FXML
    private Button atencionesButton;
    @FXML
    private Button empleadosButton;
    @FXML
    private Button clientesButton;
    @FXML
    private Button salirButton;
    @FXML
    private ImageView imagenImageView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        serviciosButton.setOnMouseClicked(e->{
            try {
                App.setRoot("servicios");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        citasButton.setOnMouseClicked(e->{
            try {
                App.setRoot("CITAS");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        atencionesButton.setOnMouseClicked(e->{
            try {
                App.setRoot("ATENCIONES");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        empleadosButton.setOnMouseClicked(e->{
            try {
                App.setRoot("empleados");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        clientesButton.setOnMouseClicked(e->{
            try {
                App.setRoot("clientes");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        salirButton.setOnMouseClicked(e->{
            Stage stage = (Stage) salirButton.getScene().getWindow();
            stage.close();
        });
        // TODO
    }    
    
}
