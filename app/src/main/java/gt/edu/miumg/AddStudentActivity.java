package gt.edu.miumg;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddStudentActivity extends AppCompatActivity {
    EditText et1, et2;
    ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);

        lv1 = (ListView) findViewById(R.id.lv1);
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
}
