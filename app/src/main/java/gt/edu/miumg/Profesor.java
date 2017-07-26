package gt.edu.miumg;

/**
 * Created by allan on 26/07/2017.
 */

public class Profesor {
    private String nombre, especialidad;

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

    public Profesor(String nombre, String especialidad) {

        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public Profesor() {

    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " Especialidad: " + especialidad;
    }
}
