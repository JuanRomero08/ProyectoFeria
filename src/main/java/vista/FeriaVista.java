/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.FeriaControlador;
import modelo.*;
import java.util.Scanner;

/**
 *
 * @author juanr
 */
public class FeriaVista {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FeriaControlador c = new FeriaControlador();
        int op;

        //Menu principal.
        do {
            System.out.println("FERIA EMPRESARIAL");
            System.out.println("1. Empresas");
            System.out.println("2. Stands");
            System.out.println("3. Visitantes");
            System.out.println("4. Comentarios");
            System.out.println("5. Reportes");
            System.out.println("0. Salir");
            op = c.leerEntero(sc);

            switch (op) {
                case 1 ->
                    menuEmpresa(c, sc);
                case 2 ->
                    menuStand(c, sc);
                case 3 ->
                    menuVisitante(c, sc);
                case 4 ->
                    c.visitarStand(sc);
                case 5 ->
                    menuReporte(c);
            }
        } while (op != 0);
    }

    /**
     * Menu de empresas.
     */
    static void menuEmpresa(FeriaControlador c, Scanner sc) {
        System.out.println("1. Registrar");
        System.out.println("2. Listar");
        System.out.println("3. Editar");
        System.out.println("4. Eliminar");
        System.out.println("5. Ver comentarios del stand");
        int op = c.leerEntero(sc);
        if (op == 1) {
            c.registrarEmpresa(sc);
        }
        if (op == 2) {
            c.listarEmpresas();
        }
        if (op == 3) {
            c.editarEmpresa(sc);
        }
        if (op == 4) {
            c.eliminarEmpresa(sc);
        }
        if (op == 5) {
            c.verComentariosEmpresa(sc);
        }
    }

    /**
     * Menu de stands.
     */
    static void menuStand(FeriaControlador c, Scanner sc) {
        System.out.println("1. Disponibles");
        System.out.println("2. Ocupados");
        System.out.println("3. Asignar");
        int op = c.leerEntero(sc);
        if (op == 1) {
            c.listarStandsDisponibles();
        }
        if (op == 2) {
            c.listarStandsOcupados();
        }
        if (op == 3) {
            c.asignarStand(sc);
        }
    }

    /**
     * Menu de visitantes.
     */
    static void menuVisitante(FeriaControlador c, Scanner sc) {
        System.out.println("1. Registrar");
        System.out.println("2. Listar");
        System.out.println("3. Editar");
        System.out.println("4. Eliminar");
        int op = c.leerEntero(sc);
        if (op == 1) {
            c.registrarVisitante(sc);
        }
        if (op == 2) {
            c.listarVisitantes();
        }
        if (op == 3) {
            c.editarVisitante(sc);
        }
        if (op == 4) {
            c.eliminarVisitante(sc);
        }
    }

    /**
     * Menu de reportes.
     */
    static void menuReporte(FeriaControlador c) {
        System.out.println("1. Empresas + stands + comentarios");
        System.out.println("2. Visitantes + stands visitados");
        Scanner sc = new Scanner(System.in);
        int op = c.leerEntero(sc);
        if (op == 1) {
            c.reporteEmpresas();
        }
        if (op == 2) {
            c.reporteVisitantes();
        }
    }
}
