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

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class TernaryController implements Initializable {

    @FXML
    private VBox rootVBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            eligirNivel();
        } catch (FileNotFoundException ex) {
            System.out.println("QUE PASAAAAAAAAAAAAAAAAAAA");
            ex.printStackTrace();
        }
        
    }    
    
    public void eligirNivel() throws FileNotFoundException {
//        root.getChildren().clear();
        
        Label jugador = new Label("JUGADOR "+" "+App.nombreJugador.toUpperCase());
        jugador.setStyle("-fx-font-size: 50px; -fx-font-family: Arial Narrow; -fx-font-weight: bold;");
        
        HBox root = new HBox();
        //##NIVEL 1
        FileInputStream inputUNO = new FileInputStream("src\\main\\resources\\com\\mycompany\\mavenproject1\\DINOSAURIO.jpg");
        Image imgUNO = new Image(inputUNO,200,300, false, false);
        ImageView imagenUNO = new ImageView(imgUNO);
        Label unoNivel = new Label("NIVEL 1");
        unoNivel.setStyle("-fx-font-size: 14px; -fx-font-family: Arial Narrow; -fx-font-weight: bold;");
        Button unoBoton = new Button("PRINCIPIANTE");
        unoBoton.setStyle("-fx-background-color:red; -fx-text-fill:white; -fx-font-size: 30px; ");
        VBox nivelUNO = new VBox(imagenUNO,unoNivel,unoBoton);
        nivelUNO.setAlignment(Pos.CENTER);
        nivelUNO.setSpacing(15);
        nivelUNO.setPadding(new Insets(10, 0, 10, 0));
        
        unoBoton.setOnMouseClicked(e -> {
            App.numeroElementos = 12;
            App.numeroColumna = 4;
            App.numeroFila = 3;
            try {
                App.setRoot("secondary");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        
        //##NIVEL 2

        FileInputStream inputDOS = new FileInputStream("src\\main\\resources\\com\\mycompany\\mavenproject1\\PORTADAINTERMEDIO.jpg");
        Image imgDOS = new Image(inputDOS,200,300, false, false);
        ImageView imagenDOS = new ImageView(imgDOS);
        Label dosNivel = new Label("NIVEL 2");
        dosNivel.setStyle("-fx-font-size: 14px; -fx-font-family: Arial Narrow; -fx-font-weight: bold;");
        Button dosBoton = new Button("INTERMEDIO");
        dosBoton.setStyle("-fx-background-color:red; -fx-text-fill:white; -fx-font-size: 30px;");
        VBox nivelDOS = new VBox(imagenDOS,dosNivel,dosBoton);
        nivelDOS.setAlignment(Pos.CENTER);
        nivelDOS.setSpacing(15);
        nivelDOS.setPadding(new Insets(10, 0, 10, 0));
        
        dosBoton.setOnMouseClicked(e -> {
            App.numeroElementos = 18;
            App.numeroColumna = 6;
            App.numeroFila = 3;
            
            try {
                App.setRoot("secondary");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        
        });
        
        //##NIVEL 3

        FileInputStream  inputTRES = new FileInputStream("src\\main\\resources\\com\\mycompany\\mavenproject1\\PORTADAAVANZADO.jpg");
        Image imgTRES = new Image(inputTRES,200,300, false, false);
        ImageView imagenTRES = new ImageView(imgTRES);
        Label tresNivel = new Label("NIVEL 3");
        tresNivel.setStyle("-fx-font-size: 14px; -fx-font-family: Arial Narrow; -fx-font-weight: bold;");
        Button tresBoton = new Button("AVANZADO");
        tresBoton.setStyle("-fx-background-color:red; -fx-text-fill:white; -fx-font-size: 30px;");
        VBox nivelTRES = new VBox(imagenTRES,tresNivel,tresBoton);
        nivelTRES.setAlignment(Pos.CENTER);
        nivelTRES.setSpacing(15);
        nivelTRES.setPadding(new Insets(10, 0, 10, 0));
        tresBoton.setOnMouseClicked(e -> {
            App.numeroElementos = 24;
            App.numeroColumna = 8;
            App.numeroFila = 3;
            
            try {
                App.setRoot("secondary");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        
        });
        
      
        root.getChildren().addAll(nivelUNO,nivelDOS,nivelTRES);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(15);
        root.setPadding(new Insets(10, 20, 10, 20));
        
        rootVBox.getChildren().addAll(jugador,root);
        rootVBox.setAlignment(Pos.CENTER);
        rootVBox.setSpacing(15);
        rootVBox.setPadding(new Insets(20, 0, 20, 0));
    }
}
