package com.mycompany.mavenproject1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class PrimaryController implements Initializable{

    @FXML
    private VBox root;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            cargarPortada();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }
    public void cargarPortada() throws FileNotFoundException{

        FileInputStream input = new FileInputStream("src\\main\\resources\\com\\mycompany\\mavenproject1\\text.gif");
        Image img = new Image(input,600,140, false, false);
        ImageView imagen = new ImageView(img);
        
        Label jugador = new Label("NOMBRE JUGADOR");
        jugador.setStyle("-fx-font-size: 14px; -fx-font-family: Arial Narrow; -fx-font-weight: bold;");
        
        TextField nombre = new TextField();
        nombre.setPromptText("INGRESA TU NOMBRE PARA EMPEZAR O NICKNAME");
      
        
        Label formato = new Label();
        formato.setStyle("-fx-font-size: 14px; -fx-font-family: Arial Narrow; -fx-font-weight: bold;");
        
        Button boton = new Button("Jugar");
        boton.setStyle("-fx-background-color:red; -fx-text-fill:white; -fx-font-size: 30px; ");

        root.getChildren().addAll(imagen,jugador,nombre,formato,boton);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10, 600, 10, 600));
        
        boton.setOnMouseClicked(e -> {
            //##PROBLEMAS PARA SEGUIR
            String nickname = nombre.getText();
            Pattern pattern = Pattern.compile("[A-Za-z]+");
            Matcher mather = pattern.matcher(nickname);
            if ((nombre.getText()).isEmpty()){
                formato.setText("INGRESA TU NOMBRE");
            }
            else if(!mather.find()){
                formato.setText("INGRESA UN NOMBRE VALIDO SIN ESPACIO");
            }else{
                App.nombreJugador = nickname.toUpperCase();
                try {
                App.setRoot("ternary");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            }
            
        });
    }

}
