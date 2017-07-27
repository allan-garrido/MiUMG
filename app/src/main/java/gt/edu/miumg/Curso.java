package gt.edu.miumg;

/**
 * Created by alumno on 26/07/2017.
 */

public class Curso {
    private String nomCurso;

    public Curso(String nomCurso) {
        this.nomCurso = nomCurso;
    }

    public String getNomCurso() {
        return nomCurso;
    }

    public void setNomCurso(String nomCurso) {
        this.nomCurso = nomCurso;
    }

    public Curso (){

    }

    @Override
    public String toString(){
        return "Nombre curso: " + nomCurso;
    }

}
