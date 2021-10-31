package POJO;

import java.io.Serializable;

public class Perro extends Animal implements Serializable {

    /**Propiedades específicas. En el caso del lenguaje, decidí inicializarla automáticamente, 
     * ya que en principio todos los perros van a hacer GUAU.  
     */
    
    private String lenguaje = "GUAU";
    private boolean raboLargo;

    public Perro() {
    }

   //Constructor con el atributo específico de la clase
    
    public Perro(String nombre, int edad, boolean raboLargo) {
        super(nombre, edad);
        this.raboLargo = raboLargo;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public boolean isRaboLargo() {
        return raboLargo;
    }

    public void setRaboLargo(boolean raboLargo) {
        this.raboLargo = raboLargo;
    }

}
