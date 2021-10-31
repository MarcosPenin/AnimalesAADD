package com.mycompany.animalesaadd;

import utilidades.Menu;
import POJO.Animal;
import POJO.Gato;
import POJO.Perro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import operaciones.OperacionesAnimales;
import utilidades.ControlData;

public class Main {

    public static void main(String args[]) {

        System.out.println("*********************************************************************************************");
        System.out.println("*******************************JUEGO DE ANIMALES*********************************");
        System.out.println("*********************************************************************************************");
        System.out.println("Escoja la operación que desea realizar. Recuerde que solo puede guardar un máximo\n "
                + "de cinco perros o cinco gatos en una misma operación");
        do {
            System.out.println("*********************************************************************************************");
            miMenu.printMenu();
            opcion = ControlData.lerByte(sc);
            miMenu.rango(opcion);
            switch (opcion) {
                case 1 ->
                    anadirAnimal();
                case 2 ->
                    OperacionesAnimales.guardarDatos();
                case 3 ->
                    OperacionesAnimales.leerDatos();
            }
        } while (opcion != 4);
    }

    /**
     * Este método pide los datos al usuario, crea el animal especificado y lo
     * añade al array correspondiente siempre y cuando no haya guardado ya cinco
     * instancias de ese animal.
     *
     */
    static void anadirAnimal() {
        do {
            System.out.println("¿Es un perro o un gato?");
            perroGato.printMenu();
            opcion2 = ControlData.lerByte(sc);
        } while (!perroGato.rango(opcion2));

        System.out.println("Introduce el nombre");
        String nombre = ControlData.lerString(sc);
        System.out.println("Introduce la edad");
        int edad = ControlData.lerInt(sc);

        if (opcion2 == 1) {
            System.out.println("¿Tiene el rabo largo?");
            do {
                siNo.printMenu();
                opcion3 = ControlData.lerByte(sc);
            } while (!siNo.rango(opcion3));
            Perro miPerro = new Perro();
            if (opcion3 == 1) {
                miPerro = new Perro(nombre, edad, true);
            } else if (opcion3 == 2) {
                miPerro = new Perro(nombre, edad, false);
            }
            if (OperacionesAnimales.addPerro(miPerro)) {
                System.out.println("Se ha añadido el perro");
            } else {
                System.out.println("Lo siento, solo se pueden almacenar cinco perros al mismo tiempo. Guarde los animales "
                        + "que ha introducido para poder continuar");
            }

        } else if (opcion2 == 2) {
            do {
                System.out.println("¿Tiene los bigotes largos?");
                siNo.printMenu();
                opcion3 = ControlData.lerByte(sc);
            } while (!siNo.rango(opcion3));

            Gato miGato = new Gato();
            if (opcion3 == 1) {
                miGato = new Gato(nombre, edad, true);
            } else if (opcion3 == 2) {
                miGato = new Gato(nombre, edad, false);
            }
            if (OperacionesAnimales.addGato(miGato)) {
                System.out.println("Se ha añadido el gato");
            } else {
                System.out.println("Lo siento, solo se pueden almacenar cinco gatos al mismo tiempo. Guarde los animales que ha introducido"
                        + "para poder continuar");
            }
        }
    }

    static Scanner sc = new Scanner(System.in);
    static byte opcion, opcion2, opcion3;
    static Menu miMenu = new Menu(opciones());
    static Menu perroGato = new Menu(perroGato());
    static Menu siNo = new Menu(siNo());

    static ArrayList<String> opciones() {

        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("Añadir un animal");
        opciones.add("Guardar los animales introducidos");
        opciones.add("Recuperar todos los animales");
        opciones.add("Finalizar");

        return opciones;
    }

    static ArrayList<String> perroGato() {
        ArrayList<String> perroGato = new ArrayList<>();
        perroGato.add("Perro");
        perroGato.add("Gato");
        return perroGato;
    }

    static ArrayList<String> siNo() {
        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("Sí");
        opciones.add("No");
        return opciones;
    }
}
