package gt.edu.miumg;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class TeacherActivity extends AppCompatActivity {
    private List<Profesor> profesores;
    private ArrayAdapter<Profesor> adapterProfesor;
    private bdProfesorHelper adminProfesores;

    EditText et1, et2;
    ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        lv1 = (ListView) findViewById(R.id.lv1);

        profesores = new ArrayList<>();
        adapterProfesor = new ArrayAdapter<Profesor>(this, android.R.layout.simple_list_item_1, profesores);
        lv1.setAdapter(adapterProfesor);
        adminProfesores = new bdProfesorHelper(this, "MiUMG", null, 1);

        showAll();
    }

    public void guardarteacher(View view){
        SQLiteDatabase bdProfesor = adminProfesores.getWritableDatabase();

        String nombre = et1.getText().toString().trim();
        String especialidad = et2.getText().toString().trim();

        ContentValues tupla = new ContentValues();
        tupla.put("nombre", nombre);
        tupla.put("especialidad", especialidad);
        //List<Map<String,String>> valores = new ArrayList<>();

        bdProfesor.insert("profesor",null,tupla);
        bdProfesor.close();

        et1.setText("");
        et2.setText("");

        Toast.makeText(this, "Profesor agregado", Toast.LENGTH_SHORT).show();

        showAll();
    }

    public void showAll() {
        SQLiteDatabase bdProfesor = adminProfesores.getReadableDatabase();

        adapterProfesor.clear();

        Cursor c = bdProfesor.rawQuery("select * from profesor;", null);

        while(c.moveToNext()) {
            Profesor pTemp = new Profesor();

            pTemp.setNombre(c.getString(c.getColumnIndex("nombre")));
            pTemp.setEspecialidad(c.getString(c.getColumnIndex("especialidad")));

            adapterProfesor.add(pTemp);
        }
        adapterProfesor.notifyDataSetChanged();
    }
}
