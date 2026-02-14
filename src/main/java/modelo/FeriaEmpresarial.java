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
public class FeriaEmpresarial {

    public ArrayList<Empresa> empresas = new ArrayList<>();
    public ArrayList<Stand> stands = new ArrayList<>();
    public ArrayList<Visitante> visitantes = new ArrayList<>();

    public FeriaEmpresarial() {
        stands.add(new Stand(1, "Pabellon A", "Pequeño"));
        stands.add(new Stand(2, "Pabellon B", "Mediano"));
        stands.add(new Stand(3, "Pabellon C", "Grande"));
    }
}
