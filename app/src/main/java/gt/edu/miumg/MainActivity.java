package gt.edu.miumg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2;
    Intent iMenu, iStudent;
    public Profesor profesor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);

        iMenu = new Intent(this, MenuActivity.class);
        iStudent = new Intent(this, StudentActivity.class);

        profesor = new Profesor();
    }

    public void iniciarSesion(View view) {
        if (et1.getText().toString().equalsIgnoreCase("") || et2.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(this, "No se puede iniciar sesión", Toast.LENGTH_SHORT).show();
        } else {
            String set1 = et1.getText().toString();
            String set2 = et2.getText().toString();

            if (set1.endsWith("@catedratico.gt") && set2.equalsIgnoreCase("posgrado")) {
                Toast.makeText(this, "Acceso Catedrático", Toast.LENGTH_SHORT).show();

                startActivity(iMenu);
            } else {
                Toast.makeText(this, "Acceso gt.edu.miumg.Estudiante", Toast.LENGTH_SHORT).show();
                startActivity(iStudent);
            }
        }
    }
}
