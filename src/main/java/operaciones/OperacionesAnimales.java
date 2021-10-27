/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import POJO.Animal;
import POJO.Gato;
import POJO.Perro;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author a20marcosgp
 */
public class OperacionesAnimales {

    public static Perro[] perros = new Perro[5];
    public static Gato[] gatos = new Gato[5];
    final static String ruta = "Archivo.txt";

    public static boolean addPerro(Perro perro) {
        boolean flag = false;
        for (int x = 0; x < perros.length; x++) {
            if (perros[x] == null) {
                perros[x] = perro;
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static boolean addGato(Gato gato) {
        boolean flag = false;
        for (int x = 0; x < gatos.length; x++) {
            if (gatos[x] == null) {
                gatos[x] = gato;
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * Dispondrá de un método guardarAnimalesADisco(String fichero) en el que se
     * guardarán todos los objetos que se encuentren en los dos arrays (perros /
     * gatos). Como no sabemos crear arrays dinámicos, escribiremos en el
     * fichero, antes de los objetos, el número de objetos total que vamos a
     * escribir.*
     */
    public static void guardarDatos() throws IOException {

        File archivo = new File(ruta);
        for (Animal x : perros) {

            if (!archivo.exists()) {
                archivo.createNewFile();
                ObjectOutputStream mos = new ObjectOutputStream(new FileOutputStream(ruta, true));
                mos.writeObject(x);
            } else {
                MiObjectOutputStream mios = new MiObjectOutputStream(new FileOutputStream(ruta, true));
                mios.writeObject(x);
            }
        }
        for (Animal x : gatos) {
            if (!archivo.exists()) {
                archivo.createNewFile();
                ObjectOutputStream mos = new ObjectOutputStream(new FileOutputStream(ruta, true));
                mos.writeObject(x);
            } else {
                MiObjectOutputStream mios = new MiObjectOutputStream(new FileOutputStream(ruta, true));
                mios.writeObject(x);
            }

        }
    }

    public static void leerDatos() throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream(ruta);
        ObjectInputStream ois = new ObjectInputStream(fis);
        int contador = 1;
        while (fis.available() > 0) {
            Animal animalLeido = (Animal) ois.readObject();
            
            if (animalLeido instanceof Perro) {
                if (((Perro) animalLeido).isRaboLargo()) {
                    System.out.println("El animal número " + contador + " es un perro, se llama " + animalLeido.getNombre() + ", tiene "
                            + animalLeido.getEdad() + " años y el rabo largo. Hace " + ((Perro) animalLeido).getLenguaje());
                } else {
                    System.out.println("El animal número " + contador + " es un perro, se llama " + animalLeido.getNombre() + ", tiene "
                            + animalLeido.getEdad() + " años y el rabo corto. Hace " + ((Perro) animalLeido).getLenguaje());
                }
                contador++;
            } else if (animalLeido instanceof Gato) {
                if (((Gato) animalLeido).isBigotesLargos()) {
                    System.out.println("El animal número " + contador + " es un gato, se llama " + animalLeido.getNombre() + ", tiene "
                            + animalLeido.getEdad() + " años y los bigotes largos. Hace " + ((Gato) animalLeido).getLenguaje());
                } else {
                    System.out.println("El animal número " + contador + " es un gato, se llama " + animalLeido.getNombre() + ", tiene "
                            + animalLeido.getEdad() + " años y los bigotes cortos. Hace " + ((Gato) animalLeido).getLenguaje());
                }
                contador++;
            }

        }

    }

}
