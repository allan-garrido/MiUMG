package gt.edu.miumg;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReporteActivity extends AppCompatActivity {
    Intent iMenu;
    private Button btmenu;
    ListView lv1;
   private bdEstudianteHelper adminEstudiantes;
    private List<Estudiante> estudiantes;
    private ArrayAdapter<Estudiante> adapterEstudiante;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);

        lv1 = (ListView) findViewById(R.id.lv1);

        estudiantes = new ArrayList<>();
        adapterEstudiante = new ArrayAdapter<Estudiante>(this,android.R.layout.simple_list_item_1,estudiantes);
        adminEstudiantes = new bdEstudianteHelper(this, "MiUMG",null,1);

        iMenu = new Intent(this, MenuActivity.class);
        showEstudiante();
    }

    public void irmenu(View view) {
        startActivity(iMenu);
    }

    public void showEstudiante () {
        bdEstudianteHelper bdEstudianteHelper = new bdEstudianteHelper(this, "estudiante", null, 1);
        SQLiteDatabase bdEstudiante = bdEstudianteHelper.getReadableDatabase();
        List<Map<String,String>> valores = new ArrayList<>();
        Cursor bdCursor = bdEstudiante.rawQuery("select * from estudiante;", null);
        SimpleAdapter sa;
        sa = new SimpleAdapter(this, valores, android.R.layout.simple_list_item_2, new String[] {"First Line","Second Line"}, new int[] {android.R.id.text1, android.R.id.text2});

        if (bdCursor.moveToFirst()) {
            do {
                Map<String,String> lineas = new HashMap<>(2);

                lineas.put("First Line",bdCursor.getString(bdCursor.getColumnIndex("nombre")));
                lineas.put("Second Line",bdCursor.getString(bdCursor.getColumnIndex("edad")));
                valores.add(lineas);
            } while (bdCursor.moveToNext());


            lv1.setAdapter(sa);
        }
        bdEstudiante.close();
        sa.notifyDataSetChanged();

    }

}
