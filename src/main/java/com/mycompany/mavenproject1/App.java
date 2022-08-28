package com.mycompany.mavenproject1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Jugador;
import modelo.Representante;



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
    

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("MENU"), 1110, 640);
        stage.setScene(scene);
        stage.setTitle("JUGUEMOS BINGO");
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
        
        final String NOMBRE_ARCHIVO = "src\\main\\resources\\com\\mycompany\\mavenproject1\\entrada.mp3";
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
        
//        System.out.println(Empleado.cargarEmpleados("src\\main\\resources\\TXT\\empleados.txt"));
        //System.out.println(Cliente.cargarClientes("src\\main\\resources\\TXT\\clientes.txt"));
        //System.out.println(Representante.cargarRepresentantes("src\\main\\resources\\TXT\\clientes.txt"));
        
    }
    
}
