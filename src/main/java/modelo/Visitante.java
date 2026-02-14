/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author juanr
 */
public class Visitante {

    private String nombre;
    private String id;
    private String correo;
    private ArrayList<Stand> standsVisitados = new ArrayList<>();

    public Visitante(String nombre, String id, String correo) {
        this.nombre = nombre;
        this.id = id;
        this.correo = correo;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Stand> getStandsVisitados() {
        return standsVisitados;
    }

    public void editar(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    @Override
    public String toString() {
        return nombre + " | " + id + " | " + correo;
    }
}
