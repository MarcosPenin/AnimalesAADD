package POJO;

import java.io.Serializable;

public class Gato extends Animal implements Serializable {

      /**Propiedades específicas. En el caso del lenguaje, decidí inicializarla automáticamente, 
     * ya que en principio todos los gatos van a hacer MIAU. 
     */
    
    private String lenguaje = "MIAU";
    private boolean bigotesLargos;

    public Gato() {
    }

    //Constructor con el atributo específico de la clase
    
    public Gato(String nombre, int edad, boolean bigotesLargos) {
        super(nombre, edad);
        this.bigotesLargos = bigotesLargos;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public boolean isBigotesLargos() {
        return bigotesLargos;
    }

    public void setBigotesLargos(boolean bigotesLargos) {
        this.bigotesLargos = bigotesLargos;
    }   
}
