package gt.edu.miumg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);

    }

    public void iniciarSesion(View view){
        if (et1.getText().toString().equalsIgnoreCase("") || et2.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(this, "No se puede iniciar sesión", Toast.LENGTH_SHORT).show();
        }
    }
}
