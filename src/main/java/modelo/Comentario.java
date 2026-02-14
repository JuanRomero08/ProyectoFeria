/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author juanr
 */
public class Comentario {

    private String visitante;
    private String fecha;
    private int calificacion;
    private String texto;

    public Comentario(String visitante, String fecha, int calificacion, String texto) {
        this.visitante = visitante;
        this.fecha = fecha;
        this.calificacion = calificacion;
        this.texto = texto;
    }

    public int getCalificacion() {
        return calificacion;
    }

    @Override
    public String toString() {
        return visitante + " | " + fecha + " | " + calificacion + " | " + texto;
    }
}
