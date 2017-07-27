package gt.edu.miumg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {
    Intent iTeacher, iAddStudent, iAddNotas, iReporte, iSalir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        iTeacher = new Intent(this, TeacherActivity.class);
        iAddStudent = new Intent(this, AddStudentActivity.class);
        iAddNotas = new Intent(this,NotasActivity.class);
        iReporte = new Intent(this,ReporteActivity.class);
        iSalir = new Intent(this,MainActivity.class);
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

    public void reporte(View view) { startActivity(iReporte);}

    public void salir(View view) { startActivity(iSalir);}

}
