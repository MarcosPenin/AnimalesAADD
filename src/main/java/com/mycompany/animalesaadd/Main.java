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

    static Scanner sc = new Scanner(System.in);
    static byte opcion, opcion2, opcion3;
    static Menu miMenu = new Menu(opciones());
    static Menu perroGato = new Menu(perroGato());
    static Menu siNo = new Menu(siNo());

    public static void main(String args[]) throws IOException, ClassNotFoundException {

        System.out.println("*********************************************************************************************");
        System.out.println("*******************************JUEGO DE ANIMALES*********************************");
        do {
            System.out.println("*********************************************************************************************");
            miMenu.printMenu();
            opcion = ControlData.lerByte(sc);

            switch (opcion) {
                case 1:
                    anadirAnimal();
                    break;
                case 2:
                    OperacionesAnimales.guardarDatos();
                    break;
                case 3:
                    OperacionesAnimales.leerDatos();
                    break;
            }
        } while (opcion != 4);
    }

    static void anadirAnimal() {
        System.out.println("¿Es un perro o un gato?");
        perroGato.printMenu();
        opcion2 = ControlData.lerByte(sc);
        System.out.println("Introduce el nombre");
        String nombre = ControlData.lerString(sc);
        System.out.println("Introduce la edad");
        int edad = ControlData.lerInt(sc);
        
        if (opcion2 == 1) {
            System.out.println("¿Tiene el rabo largo?");
            opcion3 = ControlData.lerByte(sc);
            Perro miPerro = new Perro();
            if (opcion3 == 1) {
                miPerro = new Perro(nombre, edad, true);
            } else if (opcion3 == 2) {
                miPerro = new Perro(nombre, edad, false);
            }
            if (OperacionesAnimales.addPerro(miPerro)) {
                System.out.println("Se ha añadido el perro");
            } else {
                System.out.println("Lo siento, solo se pueden almacenar cinco perros en cada sesión");
            }

        } else if (opcion2 == 2) {
            System.out.println("¿Tiene los bigotes largos?");
            opcion3 = ControlData.lerByte(sc);
            Gato miGato = new Gato();
            if (opcion3 == 1) {
                miGato = new Gato(nombre, edad, true);
            } else if (opcion3 == 2) {
                miGato = new Gato(nombre, edad, false);
            }
            if (OperacionesAnimales.addGato(miGato)) {
                System.out.println("Se ha añadido el gato");
            } else {
                System.out.println("Lo siento, solo se pueden almacenar cinco gatos en cada sesión");
            }
        }
    }

    static ArrayList<String> opciones() {

        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("Añadir un animal");
        opciones.add("Guardar los animales introducidos");
        opciones.add("Recuperar todos los animales");
        opciones.add("Finalizar");

        return opciones;
    }

    static ArrayList<String> perroGato() {
        ArrayList<String> perroGato = new ArrayList<String>();
        perroGato.add("Perro");
        perroGato.add("Gato");
        return perroGato;
    }

    static ArrayList<String> siNo() {
        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("Sí");
        opciones.add("No");
        return opciones;
    }
}
