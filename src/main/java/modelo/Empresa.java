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
public class Empresa {

    private String nombre;
    private String sector;
    private String correo;
    private Stand stand;
    private ArrayList<Comentario> comentarios = new ArrayList<>();

    public Empresa(String nombre, String sector, String correo) {
        this.nombre = nombre;
        this.sector = sector;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public void editar(String sector, String correo) {
        this.sector = sector;
        this.correo = correo;
    }

    @Override
    public String toString() {
        return nombre + " | " + sector + " | " + correo
                + " | Stand: " + (stand == null ? "Sin asignar" : stand.getNumero());
    }
}
