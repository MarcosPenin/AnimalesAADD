package POJO;

import java.io.Serializable;

public abstract class Animal implements Serializable{

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    private String nombre;
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTipo(Animal animal) {
        String respuesta = "";
        if (animal instanceof Perro) {
            respuesta = "Perro";
        } else if (animal instanceof Gato) {
            respuesta = "Gato";
        }
        return respuesta;
    }

}
