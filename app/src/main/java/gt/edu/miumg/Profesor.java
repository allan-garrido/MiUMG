package gt.edu.miumg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by allan on 23/07/2017.
 */

public class Profesor {
    private String nombre, especialidad;
    private List<Estudiante> estudiantes;

    public Profesor() {
        this.estudiantes = new ArrayList<>();
    }

    public Profesor(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.estudiantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void addEstudiante(Estudiante e) {
        this.estudiantes.add(e);
    }
}
