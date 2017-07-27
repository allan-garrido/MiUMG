package gt.edu.miumg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by allan on 23/07/2017.
 */

public class Estudiante {
    private String nombre;
    private int edad;
    private List<Asignatura> materias;

    public Estudiante() {
        materias = new ArrayList<>();
    }

    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        materias = new ArrayList<>();
    }

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

    public List<Asignatura> getMaterias() {
        return materias;
    }

    public void addMateria(Asignatura a){
        materias.add(a);
    }
}
