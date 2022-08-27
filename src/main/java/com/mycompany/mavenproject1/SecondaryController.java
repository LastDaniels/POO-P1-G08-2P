package com.mycompany.mavenproject1;

import java.io.File;
import modelo.Indices;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SecondaryController implements Initializable {
    
    
    
    public static ArrayList<String> LISTA;
    

    @FXML
    private Button secondaryButton;
    @FXML
    private HBox cajaHBox;
    @FXML
    private Label numeroLabel;
    
    Button btnProd = new Button();
    Button btnProd1 = new Button();
    Button btnProd2 = new Button();

    int numero = 0;
    
//    @FXML
//    private void switchToPrimary() throws IOException {
//        App.setRoot("primary");
//    }
      

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SecondaryController.LISTA = (ArrayList<String>) numeros(App.numeroElementos);
        segundo();
        tablaBingo();
        try {
            portadaGanadora();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        portadaIcono();
        
        numeroLabel.setPrefSize(150, 150);
        numeroLabel.setStyle("-fx-font-size: 50px;");
        numeroLabel.setText(LISTA.get(0));

    }

    public void tablaBingo(){
        
        cajaHBox.getChildren().clear();
        GridPane tabla = new GridPane();
        List<String> n = numeros(App.numeroElementos);
        ArrayList<String> listaNumeros = (ArrayList<String>) n;
        ArrayList<Indices> listaIndices = Indices.listaIndice(App.numeroColumna, App.numeroFila);
        for (int i=0; i<listaNumeros.size(); i++){
            Button boton = new Button();
//            boton.setPrefHeight(i);
            boton.setPrefSize(130, 130);
           
            boton.setText(listaNumeros.get(i));
            boton.setStyle("-fx-font-family: Arial Narrow; -fx-font-weight: bold;");
            boton.setStyle("-fx-font-size: 40px;");
 
            tabla.add(boton, (listaIndices.get(i)).getColumn(), (listaIndices.get(i)).getRow());
            //---------------------------------------
            boton.setOnMouseClicked(e -> {
            if (boton.getText().equals(LISTA.get(numero))){
                    boton.setStyle("-fx-background-image: url('https://i.pinimg.com/736x/5f/4b/21/5f4b21c376bf85db113dbf1b0c083d16.jpg'); -fx-background-size:cover;");
                    App.correctas++;
                    App.tiempo++;
                    btnProd.setText("Correctas: "+String.valueOf(App.correctas));
                    btnProd2.setText(" Tiempo: 00:00:"+String.valueOf(App.tiempo));
                    
            //boton.setStyle("-fx-background-color:blue; -fx-text-fill:white;");
            if (numero < LISTA.size()-1){
                numero++;
                numeroLabel.setText(LISTA.get(numero));
            }else{
                numeroLabel.setText(" ");
                try {
                App.setRoot("cuarternary");
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            } 
        }
        else{
            System.out.println("INTENTO FALLIDO");
            App.incorrectas++;
            App.tiempo++;
            btnProd1.setText("Incorrectas: "+String.valueOf(App.incorrectas));
            btnProd2.setText(" Tiempo: 00:00:"+String.valueOf(App.tiempo));
        }
            });
            //-----------------------------------------
            }
        cajaHBox.getChildren().add(tabla);
        
        
        
    }
    
    public static List<String> numeros(int cantidad){
        List<String> numbers = new ArrayList<>(cantidad);
        for (int i=1;i<cantidad+1;i++){
                numbers.add(String.valueOf(i));
        }
        Collections.shuffle(numbers);
        return numbers;
    }
    
    public void portadaGanadora() throws FileNotFoundException{
        FileInputStream input = new FileInputStream("src\\main\\resources\\com\\mycompany\\mavenproject1\\Ganador.png");
        Image img = new Image(input,800,400, true, true);
        ImageView imga = new ImageView(img);
        cajaHBox.getChildren().add(imga);

    }
    public void portadaIcono(){
        
        btnProd2.setText(" Tiempo: 00:00:00");
        try{
            FileInputStream  input = new FileInputStream("src\\main\\resources\\com\\mycompany\\mavenproject1\\ICONORELOJ.png");
            Image img = new Image(input,50,50,false,false);
            ImageView imageView = new ImageView(img);
            btnProd2.setGraphic(imageView);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        btnProd.setText(" Correcto: 0");
        try{
            FileInputStream  input = new FileInputStream("src\\main\\resources\\com\\mycompany\\mavenproject1\\VISTOMALO.png");
            Image img = new Image(input,50,50,false,false);
            ImageView imageView = new ImageView(img);
            btnProd.setGraphic(imageView);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
        btnProd1.setText(" Incorrecto: 0");
        try{
            FileInputStream  input = new FileInputStream("src\\main\\resources\\com\\mycompany\\mavenproject1\\VISTOBUENO.png");
            Image img = new Image(input,50,50,false,false);
            ImageView imageView = new ImageView(img);
            btnProd1.setGraphic(imageView);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        cajaHBox.getChildren().add(new VBox(btnProd2,btnProd,btnProd1));
        cajaHBox.setAlignment(Pos.CENTER);

    }
    public void segundo(){
        
        final String NOMBRE_ARCHIVO = "src\\main\\java\\com\\mycompany\\mavenproject1\\entrada.mp3";
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
    
}