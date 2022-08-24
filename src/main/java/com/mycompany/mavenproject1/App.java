package com.mycompany.mavenproject1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;



public class App extends Application {
    
    public static String nombreJugador;
    
    public static int numeroElementos;
    public static int numeroColumna;
    public static int numeroFila;
    
    //##RESULTADO FINAL
    public static int correctas;
    public static int incorrectas;
    public static int tiempo;

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 1110, 640);
        stage.setScene(scene);
        stage.setTitle("JUGUEMOS BINGO");
        //###SE ESTABLECIO ICONO DE VENTANA
        FileInputStream input = null;
        try {
            input = new FileInputStream("src/main/java/com/mycompany/mavenproject1/ICONOventana.png");
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro la imagen "+e);
        }
        Image img = new Image(input,50,50,true,true);
        stage.getIcons().add(img);
        stage.setScene(scene);
        stage.show();
        
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        
        final String NOMBRE_ARCHIVO = "src\\main\\java\\com\\mycompany\\mavenproject1\\Dinosaur.mp3";
        File archivo = null;
        try {
            archivo = new File(NOMBRE_ARCHIVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Media audio = new Media(archivo.toURI().toString());
        
        MediaPlayer reproductor = new MediaPlayer(audio);
        
        reproductor.play();

        
        launch();
        
        
        System.out.println(correctas+ " "+ incorrectas);
        System.out.println(nombreJugador);
    }

}