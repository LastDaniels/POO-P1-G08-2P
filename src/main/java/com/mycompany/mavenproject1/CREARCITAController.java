/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import modelo.Cita;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Servicio;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class CREARCITAController implements Initializable {

    @FXML
    private TextField nombreTextField;
    @FXML
    private TextField terapistaTextField;
    @FXML
    private TextField servicioTextField;
    @FXML
    private TextField horaTextField;
    @FXML
    private TextField empleadoTextField;
    @FXML
    private DatePicker fechaDatePicker;
    @FXML
    private Button guardarButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        crearCita();
        // TODO
    }
    
    public void crearCita(){
        LocalDateTime datetime = LocalDateTime.now();
        LocalDate local = datetime.toLocalDate();
        String localdate = String.valueOf(local);
        
        guardarButton.setOnMouseClicked(e->{
            
            //####################################
            String nombre = nombreTextField.getText();
            String terapista = terapistaTextField.getText();
            String servicio = servicioTextField.getText();
            //#############FORMATO DE HORA hh:mm
            String hora = horaTextField.getText();
            String empleado = empleadoTextField.getText();
            String fecha = String.valueOf(fechaDatePicker.getValue());
            
            if (nombre.isEmpty() || terapista.isEmpty() || servicio.isEmpty() || hora.isEmpty() || empleado.isEmpty() || fecha.isEmpty()){
                mostrarAlerta(Alert.AlertType.WARNING, "Datos Incompletos");           
            }else if(!nombre.matches("[' 'A-Za-z]+")){
                mostrarAlerta(Alert.AlertType.ERROR, "Ingrese Valores Validos: nombre");
            }else if(!terapista.matches("[' 'A-Za-z]+")){
                mostrarAlerta(Alert.AlertType.ERROR, "Ingrese Valores Validos: terapista");
            }else if(!servicio.matches("[' 'A-Za-z]+")){
                mostrarAlerta(Alert.AlertType.ERROR, "Ingrese Valores Validos: servicio");
            }else if(!hora.matches("[:0-9]{5}")){
                mostrarAlerta(Alert.AlertType.ERROR, "Ingrese Valores Validos: hora");
            }else if(!empleado.matches("[' 'A-Za-z]+")){
                mostrarAlerta(Alert.AlertType.ERROR, "Ingrese Valores Validos: empleado");
            }else if(fecha.matches("[-0-9]{9}")){
                try {
                    SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date1 = sdformat.parse(fecha);
                    Date date2 = sdformat.parse(localdate);
                    if (date1.after(date2)) {
                        System.out.println(
                            "Date-1 is after Date-2");
                    }else{
                        System.out.println(
                            "Date-1 NO IS after Date-2");
                        mostrarAlerta(Alert.AlertType.ERROR, "La fecha no puede ser menor: fecha");
                    }
                } catch (ParseException ex) {
                    }
            }else{
                Cliente clientes = new Cliente(nombre);
                Empleado empleados = new Empleado(empleado);
                Servicio servicios = new Servicio(servicio);
                Cita citas = new Cita(clientes, fecha, hora, empleados, servicios);
                System.out.println("#######################");
                System.out.println(citas);
                Cita.actualizarCita(citas);
                try {
                App.setRoot("CITAS");
                } catch (IOException ex) {
                ex.printStackTrace();
                }
            }
            
        });

    }
    public static void mostrarAlerta(Alert.AlertType tipo, String mensaje) {
        Alert alert = new Alert(tipo);

        alert.setTitle("Resultado de operacion");
        alert.setHeaderText("Notificacion");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
