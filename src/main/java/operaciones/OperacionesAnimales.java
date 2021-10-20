package operaciones;

import POJO.Gato;
import POJO.Perro;

public class OperacionesAnimales {

    Perro[] perros = new Perro[4];
    Gato[] gatos = new Gato[4];

    public boolean addPerro(Perro perro) {
        boolean flag = true;
        for (int x = 0; x < perros.length; x++) {
            if (perros[x] == null) {
                perros[x] = perro;
                break;
            } else {
                flag = false;
            }
        }
        return flag;

    }

    public boolean addGato(Gato gato) {
        boolean flag = true;
        for (int x = 0; x < gatos.length; x++) {
            if (gatos[x] == null) {
                gatos[x] = gato;
                break;
            } else {
                flag = false;
            }
        }
        return flag;
    }
}


