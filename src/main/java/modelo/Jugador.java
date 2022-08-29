/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author LENOVO
 */
public class Jugador {
    private String nombreJugador;
    private String actividad;
    private String fecha;
    private int acierto;
    private int NOacierto;
    private int tiempo;

    public Jugador(String nombreJugador, String actividad, String fecha, int acierto, int NOacierto, int tiempo) {
        this.nombreJugador = nombreJugador;
        this.actividad = actividad;
        this.fecha = fecha;
        this.acierto = acierto;
        this.NOacierto = NOacierto;
        this.tiempo = tiempo;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getAcierto() {
        return acierto;
    }

    public void setAcierto(int acierto) {
        this.acierto = acierto;
    }

    public int getNOacierto() {
        return NOacierto;
    }

    public void setNOacierto(int NOacierto) {
        this.NOacierto = NOacierto;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "Jugador{" + "actividad=" + actividad + ", fecha=" + fecha + ", acierto=" + acierto + ", NOacierto=" + NOacierto + ", tiempo=" + tiempo + '}';
    }
}
