/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class Indices {
    public int column;
    public int row;

    public Indices(int column, int row) {
        this.column = column;
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString() {
        return "Indices{" + "column=" + column + ", row=" + row + '}';
    }
    
    public static ArrayList<Indices> listaIndice(int indice1, int indice2){
        ArrayList<Indices> indices = new ArrayList<>();
        int[][] matriz = new int[indice1][indice2]; 
        for (int i = 0; i < indice1; i++)		
                for (int j = 0; j < indice2; j++){
                    Indices par = new Indices(i,j);
                    indices.add(par);
                }
        return indices;
    }
}
