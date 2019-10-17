package bo;

import java.io.Serializable;

public class Question implements Serializable {

    private int nombre1;
    private int nombre2;

    public Question() {}

    public Question(int nombre1, int nombre2) {
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
    }

    public int getNombre1() {
        return nombre1;
    }

    public void setNombre1(int nombre1) {
        this.nombre1 = nombre1;
    }

    public int getNombre2() {
        return nombre2;
    }

    public void setNombre2(int nombre2) {
        this.nombre2 = nombre2;
    }
}