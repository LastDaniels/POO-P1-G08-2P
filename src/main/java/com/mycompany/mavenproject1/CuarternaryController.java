/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class CuarternaryController implements Initializable {

    @FXML
    private VBox rootVBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            Score();
            // TODO
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }    
    
    public void Score() throws FileNotFoundException{

        FileInputStream  copa = new FileInputStream("src\\main\\resources\\com\\mycompany\\mavenproject1\\MEDALLA.png");
        Image trofeo = new Image(copa,200,300, false, false);
        ImageView imagenCopa = new ImageView(trofeo);

        FileInputStream  medalla = new FileInputStream("src\\main\\resources\\com\\mycompany\\mavenproject1\\MEDALLA.png");
        Image premio = new Image(medalla,200,300, false, false);
        ImageView imagenMedalla = new ImageView(premio);
        
        Label nombre = new Label("JUGADOR "+" "+App.nombreJugador.toUpperCase());
        nombre.setStyle("-fx-font-size: 14px; -fx-font-family: Arial Narrow; -fx-font-weight: bold;");
        
        Label correctas = new Label("NÚMERO DE ACIERTOS: "+String.valueOf(App.correctas));
        correctas.setStyle("-fx-font-size: 14px; -fx-font-family: Arial Narrow; -fx-font-weight: bold;");
        
        Label incorrectas = new Label("NÚMERO DE FALLIDO: "+String.valueOf(App.incorrectas));
        incorrectas.setStyle("-fx-font-size: 14px; -fx-font-family: Arial Narrow; -fx-font-weight: bold;");
        
        
        HBox score = new HBox(imagenMedalla,nombre,correctas,incorrectas);
        score.setAlignment(Pos.CENTER);
        score.setSpacing(15);
        score.setPadding(new Insets(10, 20, 10, 20));
        
        Button partida = new Button("OTRO INTENTO");
        partida.setStyle("-fx-background-color:red; -fx-text-fill:white; -fx-font-size: 30px;");
        Button salir = new Button("SALIR");
        salir.setStyle("-fx-background-color:red; -fx-text-fill:white; -fx-font-size: 30px;");
        partida.setOnMouseClicked(e -> {
            try {
                App.setRoot("ternary");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        
        salir.setOnMouseClicked(e -> {
            Stage stage = (Stage) salir.getScene().getWindow();
            stage.close();
        });
        
        HBox cambio = new HBox(partida,salir);
        cambio.setAlignment(Pos.CENTER);
        cambio.setSpacing(15);
        cambio.setPadding(new Insets(10, 20, 10, 20));
        
        rootVBox.getChildren().addAll(imagenCopa,score,cambio);
        rootVBox.setAlignment(Pos.CENTER);
        rootVBox.setSpacing(15);
        rootVBox.setPadding(new Insets(20, 0, 20, 0));
    
    }
    
    
}
