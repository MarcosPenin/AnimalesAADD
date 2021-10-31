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
import java.util.Arrays;

/**
 *
 * @author a20marcosgp
 */
public class OperacionesAnimales {

    /**
     * Creo los arrays como privados y sin setters para que solo se puedan
     * modificar desde los métdos específicos
     */
    public static Perro[] perros = new Perro[5];
    private static Gato[] gatos = new Gato[5];
    final static String RUTA = "Archivo.txt";

    /**
     * Para añadir perros recorro el array, guardando el perro que me han pasado
     * por parámetro cuando encuentro una posición vacía. Devuelvo true o false
     * en función de si el perro ha sido añadido
     */
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

    /**
     * Exactamente igual que el anterior
     */
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
     * Creo el archivo si no existe y le paso los dos arrays objeto a objeto.
     * Para acabar, vacío los arrays para que el usuario no pueda guardar dos
     * veces los mismos animales. Doy por sentado que el usuario solo puede
     * guardar cinco perros o cinco gatos en una misma operación, pero puede
     * repetirla las veces que quiera sin necesidad de cerrar la sesión.
     */
    public static void guardarDatos() {
        File archivo = new File(RUTA);
        try {
            for (Animal x : perros) {
                if (!archivo.exists()) {
                    archivo.createNewFile();
                    ObjectOutputStream mos = new ObjectOutputStream(new FileOutputStream(RUTA, true));
                    mos.writeObject(x);
                } else {
                    MiObjectOutputStream mios = new MiObjectOutputStream(new FileOutputStream(RUTA, true));
                    mios.writeObject(x);
                }
            }
            for (Animal x : gatos) {
                if (!archivo.exists()) {
                    archivo.createNewFile();
                    ObjectOutputStream mos = new ObjectOutputStream(new FileOutputStream(RUTA, true));
                    mos.writeObject(x);
                } else {
                    MiObjectOutputStream mios = new MiObjectOutputStream(new FileOutputStream(RUTA, true));
                    mios.writeObject(x);
                }
            }
            System.out.println("Operación realizada ");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Arrays.fill(gatos, null);
        Arrays.fill(perros, null);
    }

    /**
     * Accedo al archivo y voy leyendo los objetos uno a uno. La impresión de
     * información varía en función de si es un perro o un gato y de sus
     * propiedades específicas. También añado un contador para indicar el número
     * del animal dentro del archivo.
     */
    public static void leerDatos() {

        try {
            FileInputStream fis = new FileInputStream(RUTA);
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
        } catch (IOException e) {
                System.out.println("Todavía no se ha introducido ningún animal");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

}
