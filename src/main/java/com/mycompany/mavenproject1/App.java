package com.mycompany.mavenproject1;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import modelo.Cita;
import modelo.Jugador;



public class App extends Application {
    
    public static ArrayList<Jugador> jugadores = new ArrayList<>();
    //##NOMBRE DEL JUGADOR 
    public static String nombreJugador;
    //##CANTIDAD DE ELEMENTO EN CADA NIVEL DEL BINGO
    public static int numeroElementos;
    public static int numeroColumna;
    public static int numeroFila;
    //##RESULTADO FINAL
    public static int correctas;
    public static int incorrectas;
    public static int tiempo;
    public static Cita citas;

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("MENU"), 1110, 640);
        stage.setScene(scene);
        stage.setTitle("BIENVENIDO A TERAPIA");
        //###SE ESTABLECIO ICONO DE VENTANA
        FileInputStream input = null;
        try {
            input = new FileInputStream("src/main/resources/com/mycompany/mavenproject1/ICONOventana.png");
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
        
        launch();
    }
    
}
