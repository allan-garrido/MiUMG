package gt.edu.miumg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {
    Intent iTeacher, iAddStudent, iAddNotas, iCursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        iTeacher = new Intent(this, TeacherActivity.class);
        iAddStudent = new Intent(this, AddStudentActivity.class);
        iAddNotas = new Intent(this, NotasActivity.class);
        iCursos = new Intent(this, CursosActivity.class);
    }

    public void datosprofe(View view) {
        startActivity(iTeacher);
    }

    public void datosestudiante(View view) {
        startActivity(iAddStudent);
    }

    public void ingresarnotas(View view) {
        startActivity(iAddNotas);
    }

    public void irCursos(View view){startActivity(iCursos); }
}
