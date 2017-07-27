package gt.edu.miumg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MenuActivity extends AppCompatActivity {
    private Intent iTeacher, iAddStudent, iAddNotas, iAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        iTeacher = new Intent(this, TeacherActivity.class);
        iAddStudent = new Intent(this, AddStudentActivity.class);
        iAddNotas = new Intent(this, NotasActivity.class);
        iAbout = new Intent(this, AboutActivity.class);
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

    public void about(View view) {
        startActivity(iAbout);
    }
}
