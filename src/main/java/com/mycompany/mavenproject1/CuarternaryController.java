/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.File;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import modelo.Jugador;

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
        
        
        premio();
        
        try {
            Score();
            // TODO
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }    
    
    public void Score() throws FileNotFoundException{
        //##INGRESANDO JUGADORES
//        Jugador candidato = new Jugador(App.nombreJugador.toUpperCase(),App.correctas,App.incorrectas);
//        App.jugadores.add(candidato);

        //##
        listaJugador(App.nombreJugador.toUpperCase(),App.correctas,App.incorrectas,App.tiempo);

        FileInputStream  copa = new FileInputStream("src\\main\\resources\\com\\mycompany\\mavenproject1\\COPA.png");
        Image trofeo = new Image(copa,400,400, false, false);
        ImageView imagenCopa = new ImageView(trofeo);
        
        VBox miniroot = new VBox();
        for (Jugador j: App.jugadores){
            if((App.nombreJugador).equals(j.getJugador())){
                
                FileInputStream  medalla = new FileInputStream("src\\main\\resources\\com\\mycompany\\mavenproject1\\MEDALLA.png");
                Image premio = new Image(medalla,100,100, false, false);
                ImageView imagenMedalla = new ImageView(premio);
                
                Label nombre = new Label("JUGADOR "+" "+j.getJugador());
                nombre.setStyle("-fx-font-size: 14px; -fx-font-family: Arial Narrow; -fx-font-weight: bold;");

                Label correctas = new Label("NÚMERO DE ACIERTOS: "+String.valueOf(j.getAcierto()));
                correctas.setStyle("-fx-font-size: 14px; -fx-font-family: Arial Narrow; -fx-font-weight: bold;");

                Label incorrectas = new Label("NÚMERO DE FALLIDO: "+String.valueOf(j.getNOacierto()));
                incorrectas.setStyle("-fx-font-size: 14px; -fx-font-family: Arial Narrow; -fx-font-weight: bold;");
                
                Label tiempo = new Label("TIEMPO EMPLEADO: "+String.valueOf(j.getTiempo())+"s");
                tiempo.setStyle("-fx-font-size: 14px; -fx-font-family: Arial Narrow; -fx-font-weight: bold;");
                
                HBox score = new HBox(imagenMedalla,nombre,correctas,incorrectas,tiempo);
                score.setAlignment(Pos.CENTER);
                score.setSpacing(6);
                score.setPadding(new Insets(10, 20, 10, 20));
                
                miniroot.getChildren().add(score);
            }

        }
        miniroot.setAlignment(Pos.CENTER);
        miniroot.setSpacing(15);
        miniroot.setPadding(new Insets(20, 0, 20, 0));

//        FileInputStream  medalla = new FileInputStream("src\\main\\resources\\com\\mycompany\\mavenproject1\\MEDALLA.png");
//        Image premio = new Image(medalla,100,100, false, false);
//        ImageView imagenMedalla = new ImageView(premio);
//        //##VERIFICAR
//        Label nombre = new Label("JUGADOR "+" "+App.nombreJugador.toUpperCase());
//        nombre.setStyle("-fx-font-size: 14px; -fx-font-family: Arial Narrow; -fx-font-weight: bold;");
//        
//        Label correctas = new Label("NÚMERO DE ACIERTOS: "+String.valueOf(App.correctas));
//        correctas.setStyle("-fx-font-size: 14px; -fx-font-family: Arial Narrow; -fx-font-weight: bold;");
//        
//        Label incorrectas = new Label("NÚMERO DE FALLIDO: "+String.valueOf(App.incorrectas));
//        incorrectas.setStyle("-fx-font-size: 14px; -fx-font-family: Arial Narrow; -fx-font-weight: bold;");
//        
//        
//        HBox score = new HBox(imagenMedalla,nombre,correctas,incorrectas);
//        score.setAlignment(Pos.CENTER);
//        score.setSpacing(15);
//        score.setPadding(new Insets(10, 20, 10, 20));
        
        Button partida = new Button("OTRO INTENTO");
        partida.setStyle("-fx-background-color:green; -fx-text-fill:white; -fx-font-size: 30px;");
        Button reinicio = new Button("REINICIO");
        reinicio.setStyle("-fx-background-color:green; -fx-text-fill:white; -fx-font-size: 30px;");
        Button salir = new Button("SALIR");
        salir.setStyle("-fx-background-color:green; -fx-text-fill:white; -fx-font-size: 30px;");
        
        partida.setOnMouseClicked(e -> {
            App.correctas = 0;
            App.incorrectas = 0;
            App.numeroElementos = 0;
            App.numeroColumna = 0;
            App.numeroFila = 0;
            try {
                App.setRoot("ternary");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        
        reinicio.setOnMouseClicked(e -> {
            App.correctas = 0;
            App.incorrectas = 0;
            App.nombreJugador = null;
            App.numeroElementos = 0;
            App.numeroColumna = 0;
            App.numeroFila = 0;
            try {
                App.setRoot("primary");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        
        
        salir.setOnMouseClicked(e -> {
            Stage stage = (Stage) salir.getScene().getWindow();
            stage.close();
        });
        
        HBox cambio = new HBox(partida,reinicio,salir);
        cambio.setAlignment(Pos.CENTER);
        cambio.setSpacing(15);
        cambio.setPadding(new Insets(10, 20, 10, 20));
        
        rootVBox.getChildren().addAll(imagenCopa,miniroot,cambio);
        rootVBox.setAlignment(Pos.CENTER);
        rootVBox.setSpacing(15);
        rootVBox.setPadding(new Insets(20, 0, 20, 0));
    }
    public void premio(){
        
        final String NOMBRE_ARCHIVO = "src\\main\\java\\com\\mycompany\\mavenproject1\\Ganador.mp3";
        File archivo = null;
        try {
            archivo = new File(NOMBRE_ARCHIVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Media audio = new Media(archivo.toURI().toString());
        
        MediaPlayer reproductor = new MediaPlayer(audio);
        
        reproductor.play();

    }
    public void listaJugador(String nombre, int correctas, int incorrectas, int tiempo){
        Jugador candidato = new Jugador(nombre,correctas,incorrectas,tiempo);
        App.jugadores.add(candidato);
    }
}
