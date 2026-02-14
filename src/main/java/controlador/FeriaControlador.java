/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.*;
import java.util.Scanner;

/**
 *
 * @author juanr
 */
public class FeriaControlador {

    private FeriaEmpresarial feria = new FeriaEmpresarial();

    /**
     * Si el usuario ingresa algo que no es un numero, vuelve a pedir el dato.
     */
    public int leerEntero(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Debes ingresar un numero.");
            }
        }
    }

    /**
     * Registra una nueva empresa en la feria.
     */
    public void registrarEmpresa(Scanner sc) {
        System.out.print("Nombre: ");
        String n = sc.nextLine();
        System.out.print("Sector: ");
        String s = sc.nextLine();
        System.out.print("Correo: ");
        String c = sc.nextLine();
        feria.empresas.add(new Empresa(n, s, c));
        System.out.println("Empresa registrada correctamente.");
    }

    /**
     * Muestra todas las empresas registradas.
     */
    public void listarEmpresas() {
        feria.empresas.forEach(System.out::println);
    }

    /**
     * Permite editar los datos de una empresa existente.
     */
    public void editarEmpresa(Scanner sc) {
        System.out.print("Nombre empresa: ");
        String n = sc.nextLine();
        for (Empresa e : feria.empresas) {
            if (e.getNombre().equalsIgnoreCase(n)) {
                System.out.print("Nuevo sector: ");
                String s = sc.nextLine();
                System.out.print("Nuevo correo: ");
                String c = sc.nextLine();
                e.editar(s, c);
                System.out.println("Empresa editada.");
                return;
            }
        }
        System.out.println("Empresa no encontrada.");
    }

    /**
     * Elimina una empresa por su nombre.
     */
    public void eliminarEmpresa(Scanner sc) {
        System.out.print("Nombre empresa: ");
        String n = sc.nextLine();
        boolean eliminado = feria.empresas.removeIf(e -> e.getNombre().equalsIgnoreCase(n));
        System.out.println(eliminado ? "Empresa eliminada." : "Empresa no encontrada.");
    }

    /**
     * Muestra los comentarios y calificaciones que tiene una empresa en su stand.
     */
    public void verComentariosEmpresa(Scanner sc) {
        System.out.print("Nombre empresa: ");
        String nombre = sc.nextLine();

        for (Empresa e : feria.empresas) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {

                if (e.getStand() == null) {
                    System.out.println("Esta empresa no tiene stand asignado.");
                    return;
                }

                if (e.getComentarios().isEmpty()) {
                    System.out.println("No hay comentarios para este stand.");
                    return;
                }

                System.out.println("Comentarios del stand " + e.getStand().getNumero());
                for (Comentario c : e.getComentarios()) {
                    System.out.println(c);
                }
                return;
            }
        }

        System.out.println("Empresa no encontrada.");
    }

    /**
     * Lista todos los stands disponibles.
     */
    public void listarStandsDisponibles() {
        feria.stands.stream().filter(s -> !s.isOcupado()).forEach(System.out::println);
    }

    /**
     * Lista todos los stands ocupados.
     */
    public void listarStandsOcupados() {
        feria.stands.stream().filter(Stand::isOcupado).forEach(System.out::println);
    }

    /**
     * Asigna un stand disponible a una empresa.
     */
    public void asignarStand(Scanner sc) {
        listarEmpresas();
        System.out.print("Empresa: ");
        String n = sc.nextLine();

        Empresa empresa = feria.empresas.stream()
                .filter(e -> e.getNombre().equalsIgnoreCase(n)).findFirst().orElse(null);

        if (empresa == null) {
            System.out.println("Empresa no encontrada.");
            return;
        }

        listarStandsDisponibles();
        System.out.print("Numero stand: ");
        int num = leerEntero(sc);

        for (Stand s : feria.stands) {
            if (s.getNumero() == num && !s.isOcupado()) {
                s.setEmpresa(empresa);
                empresa.setStand(s);
                System.out.println("Stand asignado correctamente.");
                return;
            }
        }
        System.out.println("Stand invalido o ya ocupado.");
    }

    /**
     * Registra un visitante.
     */
    public void registrarVisitante(Scanner sc) {
        System.out.print("Nombre: ");
        String n = sc.nextLine();
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Correo: ");
        String c = sc.nextLine();
        feria.visitantes.add(new Visitante(n, id, c));
        System.out.println("Visitante registrado.");
    }

    /**
     * Lista todos los visitantes.
     */
    public void listarVisitantes() {
        feria.visitantes.forEach(System.out::println);
    }

    /**
     * Edita un visitante por su ID.
     */
    public void editarVisitante(Scanner sc) {
        System.out.print("ID visitante: ");
        String id = sc.nextLine();
        for (Visitante v : feria.visitantes) {
            if (v.getId().equals(id)) {
                System.out.print("Nuevo nombre: ");
                String n = sc.nextLine();
                System.out.print("Nuevo correo: ");
                String c = sc.nextLine();
                v.editar(n, c);
                System.out.println("Visitante editado.");
                return;
            }
        }
        System.out.println("Visitante no encontrado.");
    }

    /**
     * Elimina un visitante.
     */
    public void eliminarVisitante(Scanner sc) {
        System.out.print("ID visitante: ");
        String id = sc.nextLine();
        boolean eliminado = feria.visitantes.removeIf(v -> v.getId().equals(id));
        System.out.println(eliminado ? "Visitante eliminado." : "Visitante no encontrado.");
    }

    /**
     * Permite a un visitante dejar un comentario y calificacion en un stand.
     */
    public void visitarStand(Scanner sc) {
        System.out.print("ID visitante: ");
        String id = sc.nextLine();
        Visitante v = feria.visitantes.stream()
                .filter(x -> x.getId().equals(id)).findFirst().orElse(null);

        if (v == null) {
            System.out.println("Visitante no existe.");
            return;
        }

        listarStandsOcupados();
        System.out.print("Numero stand: ");
        int num = leerEntero(sc);

        for (Stand s : feria.stands) {
            if (s.getNumero() == num && s.isOcupado()) {
                System.out.print("Fecha: ");
                String f = sc.nextLine();
                System.out.print("Calificacion (1-5): ");
                int cal = leerEntero(sc);
                System.out.print("Comentario: ");
                String t = sc.nextLine();

                Comentario c = new Comentario(v.getNombre(), f, cal, t);
                s.getEmpresa().getComentarios().add(c);
                v.getStandsVisitados().add(s);
                System.out.println("Comentario registrado.");
                return;
            }
        }
        System.out.println("Stand no valido.");
    }

    /**
     * Reporte general de empresas y comentarios.
     */
    public void reporteEmpresas() {
        for (Empresa e : feria.empresas) {
            System.out.println(e);
            e.getComentarios().forEach(System.out::println);
        }
    }

    /**
     * Reporte general de visitantes y stands visitados.
     */
    public void reporteVisitantes() {
        for (Visitante v : feria.visitantes) {
            System.out.println(v);
            v.getStandsVisitados().forEach(s -> System.out.println("  Visito stand " + s.getNumero()));
        }
    }
}
