package gt.edu.miumg;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddStudentActivity extends AppCompatActivity {
    EditText et1, et2;
    ListView lv1;
    Spinner sp1;
    String spSelected;

    private bdProfesorHelper adminProfesores;
    private bdEstudianteHelper adminEstudiantes;
    private List<Profesor> profesores;
    private List<Estudiante> estudiantes;
    private ArrayAdapter<Profesor> adapterProfesor;
    private ArrayAdapter<Estudiante> adapterEstudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        lv1 = (ListView) findViewById(R.id.lv1);
        sp1 = (Spinner) findViewById(R.id.sp1);

        profesores = new ArrayList<>();
        adapterProfesor = new ArrayAdapter<Profesor>(this, android.R.layout.simple_list_item_1,profesores);
        adminProfesores = new bdProfesorHelper(this, "MiUMG",null,1);
        adapterProfesor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapterProfesor);

        estudiantes = new ArrayList<>();
        adapterEstudiante = new ArrayAdapter<Estudiante>(this,android.R.layout.simple_list_item_1,estudiantes);
        adminEstudiantes = new bdEstudianteHelper(this, "MiUMG",null,1);

        showProfesores();

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spSelected = parent.getSelectedItem().toString();
                Toast.makeText(AddStudentActivity.this, "Profesor " + spSelected, Toast.LENGTH_SHORT).show();
            }
            public void onNothingSelected(AdapterView<?> parent) {}}
        );
    }

    public void addStudent(View view) {
        bdEstudianteHelper bdEstudianteHelper = new bdEstudianteHelper(this, "estudiante", null, 1);
        SQLiteDatabase bdEstudiante = bdEstudianteHelper.getReadableDatabase();
        ContentValues tupla = new ContentValues();
        tupla.put("nombre", et1.getText().toString().trim());
        tupla.put("edad", Integer.parseInt(et2.getText().toString().trim()));
        List<Map<String,String>> valores = new ArrayList<>();

        bdEstudiante.insert("estudiante", null, tupla);

        et1.setText("");
        et2.setText("");

        Toast.makeText(this, "Estudiante agregado", Toast.LENGTH_SHORT).show();

        Cursor bdCursor = bdEstudiante.rawQuery("select * from estudiante;", null);

        if (bdCursor.moveToFirst()) {
            do {
                Map<String,String> lineas = new HashMap<>(2);

                lineas.put("First Line",bdCursor.getString(bdCursor.getColumnIndex("nombre")));
                lineas.put("Second Line",bdCursor.getString(bdCursor.getColumnIndex("edad")));
                valores.add(lineas);
            } while (bdCursor.moveToNext());
            SimpleAdapter sa = new SimpleAdapter(this, valores, android.R.layout.simple_list_item_2, new String[] {"First Line","Second Line"}, new int[] {android.R.id.text1, android.R.id.text2});

            lv1.setAdapter(sa);
        }

        bdEstudiante.close();
    }

    public void showProfesores(){
        SQLiteDatabase bdProfesor = adminProfesores.getReadableDatabase();

        adapterProfesor.clear();

        Cursor c = bdProfesor.rawQuery("select * from profesor;", null);

        while(c.moveToNext()){
            Profesor pTemp = new Profesor();

            pTemp.setNombre(c.getString(c.getColumnIndex("nombre")));
            pTemp.setEspecialidad(c.getString(c.getColumnIndex("especialidad")));

            adapterProfesor.add(pTemp);
        }
        bdProfesor.close();
        adapterProfesor.notifyDataSetChanged();
    }


    public void showEstudiantes() {
        Toast.makeText(this, "Profesor: " + spSelected, Toast.LENGTH_SHORT).show();
    }
}
