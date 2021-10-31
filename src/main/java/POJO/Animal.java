package POJO;

import java.io.Serializable;

//Clase padre abstracta, no me interesa que se creen instancias

public abstract class Animal implements Serializable{

    
// Dos constructores, uno con los datos básicos y uno vacío que me vendrá bien en el main

    private String nombre;
    private int edad;
    
    public Animal(){}
    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    //Setters y getters para acceder a las propiedades   

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

    /**Decidí meter el método getTipo en la clase padre.Me pareció más adecuado
     * averiguar el tipo del animal observando a que clase pertenece, sin necesidad
     * de crear una propiedad a mayores
     */
    
    
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
