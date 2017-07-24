package gt.edu.miumg;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TeacherActivity extends AppCompatActivity {
    EditText et1, et2;
    ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        lv1 = (ListView) findViewById(R.id.lv1);
    }

    public void guardarteacher(View view){
        bdProfesorHelper bdProfesorHelper = new bdProfesorHelper(this, "profesor", null, 1);
        SQLiteDatabase bdProfesor = bdProfesorHelper.getReadableDatabase();
        ContentValues tupla = new ContentValues();
        tupla.put("nombre", et1.getText().toString().trim());
        tupla.put("especialidad", et2.getText().toString().trim());
        ArrayList<String> nombre = new ArrayList<>();
        ArrayList<String> especialidad = new ArrayList<>();
        ArrayAdapter<String> ladapter1, ladapter2;
        ListAdapter la;

        bdProfesor.insert("profesor",null,tupla);

        et1.setText("");
        et2.setText("");

        Toast.makeText(this, "Profesor agregado", Toast.LENGTH_SHORT).show();

        Cursor bdCursor = bdProfesor.rawQuery("select * from profesor;",null);

        nombre.clear();
        especialidad.clear();

        if (bdCursor.moveToFirst()) {
            do {
                nombre.add(bdCursor.getString(bdCursor.getColumnIndex("nombre")));
                especialidad.add(bdCursor.getString(bdCursor.getColumnIndex("especialidad")));
            } while (bdCursor.moveToNext());
            ladapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombre);

            lv1.setAdapter(ladapter1);
        }

        bdProfesor.close();
    }
}