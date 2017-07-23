package gt.edu.miumg;

/**
 * Created by ALLAN GARRIDO on 23/07/2017.
 */

public class Asignatura {
    private float primerparcial,segundoparcial,zona,examenfinal;

    public float getPrimerparcial() {
        return primerparcial;
    }

    public void setPrimerparcial(float primerparcial) {
        this.primerparcial = primerparcial;
    }

    public float getSegundoparcial() {
        return segundoparcial;
    }

    public void setSegundoparcial(float segundoparcial) {
        this.segundoparcial = segundoparcial;
    }

    public float getZona() {
        return zona;
    }

    public void setZona(float zona) {
        this.zona = zona;
    }

    public float getExamenfinal() {
        return examenfinal;
    }

    public void setExamenfinal(float examenfinal) {
        this.examenfinal = examenfinal;
    }

    public Asignatura(float primerparcial, float segundoparcial, float zona, float examenfinal) {

        this.primerparcial = primerparcial;
        this.segundoparcial = segundoparcial;
        this.zona = zona;
        this.examenfinal = examenfinal;
    }

    public Asignatura() {

    }
}
