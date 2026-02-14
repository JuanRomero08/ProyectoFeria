/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author juanr
 */
public class Stand {

    private int numero;
    private String ubicacion;
    private String tamaño;
    private Empresa empresa;

    public Stand(int numero, String ubicacion, String tamaño) {
        this.numero = numero;
        this.ubicacion = ubicacion;
        this.tamaño = tamaño;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isOcupado() {
        return empresa != null;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Stand " + numero + " | " + ubicacion + " | " + tamaño
                + " | " + (isOcupado() ? "Ocupado" : "Disponible");
    }
}
