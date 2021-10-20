
package POJO;

public class Gato extends Animal {
    
    private String lenguaje="MIAU";
    private boolean bigotesLargos;
    
    public Gato(String nombre,int edad,boolean bigotesLargos){
        super(nombre,edad);
        this.bigotesLargos=bigotesLargos;
    
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
