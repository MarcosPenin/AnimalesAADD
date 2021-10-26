package com.mycompany.animalesaadd;

import POJO.Animal;
import POJO.Gato;
import POJO.Perro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import operaciones.OperacionesAnimales;
import utilidades.ControlData;
import utilidades.Menu;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static byte opcion, opcion2, opcion3;
    static Menu miMenu = new Menu(opciones());
    static Menu miMenu = new Menu(perroGato());
    static Menu miMenu = new Menu(siNO());

    public static void main(String args[]) throws IOException, ClassNotFoundException {

        System.out.println("*********************************************************************************************");
        System.out.println("*******************************JUEGO DE ANIMALES*********************************");

        do {
            System.out.println("*********************************************************************************************");

            opcion = ControlData.lerByte(sc);

            switch (opcion) {
                case 1:
                    System.out.println("¿Es un perro o un gato?");
                    

            }

            Perro perro1 = new Perro("Chispa", 2, true);
            Perro perro2 = new Perro("Chuski", 2, false);
            Perro perro3 = new Perro("Albóndiga", 2, true);
            Perro perro4 = new Perro("Olivia", 2, true);
            Perro perro5 = new Perro("Yuri", 2, false);
            Perro perro6 = new Perro("Canelón", 2, true);

            Gato gato1 = new Gato("Manganesa", 3, false);
            Gato gato2 = new Gato("Policarpa", 3, true);

            OperacionesAnimales.addPerro(perro1);
            OperacionesAnimales.addPerro(perro2);
            OperacionesAnimales.addPerro(perro3);
            OperacionesAnimales.addPerro(perro4);
            OperacionesAnimales.addPerro(perro5);
            OperacionesAnimales.addPerro(perro6);

            OperacionesAnimales.addGato(gato1);
            OperacionesAnimales.addGato(gato2);

            Animal[] animales = new Animal[5];

            Animal[] gatos = new Animal[2];

            animales = OperacionesAnimales.perros;

            gatos = OperacionesAnimales.gatos;

            OperacionesAnimales.guardarDatos("Animales.txt");
            OperacionesAnimales.leerDatos("Animales.txt");

        } while (opcion != 0);
    }

    static ArrayList<String> opciones() {

        ArrayList<String> opciones = new ArrayList<String>() {
            {
                add("Añadir un perro");
                add("Añadir un gato");
                add("Guardar animales");
                add("Recuperar animales guardados");
                add("Finalizar");
            }
        };
        return opciones;
    }

    static ArrayList<String> perroGato() {
        ArrayList<String> opciones = new ArrayList<String>() {
            {
                add("Perro");
                add("Gato");
            }
        };
        return opciones;
    }

    static ArrayList<String> siNo() {
        ArrayList<String> opciones = new ArrayList<String>() {
            {
                add("Sí");
                add("No");
            }
        };
        return opciones;
    }

}
