package POJO;

import java.io.Serializable;

public class Perro extends Animal implements Serializable {

    private String lenguaje = "GUAU";
    private boolean raboLargo;

    public Perro(){}
    
    public Perro(String nombre,int edad,boolean raboLargo){
        super(nombre,edad);
        this.raboLargo=raboLargo;       
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
