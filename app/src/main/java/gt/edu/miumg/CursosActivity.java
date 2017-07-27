package gt.edu.miumg;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CursosActivity extends AppCompatActivity {

    private List<Curso> cursos;
    private ArrayAdapter<Curso> adapterCursos;
    private AdminSQLiteOpenHelperCurso adminCursos;

    private EditText nom_curso;
    private ListView list_cursos;

    private Button btn_add_curso;
    private Button btn_del_curso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos);

        nom_curso = (EditText) findViewById(R.id.et1Curso);
        list_cursos = (ListView) findViewById(R.id.lv1Cursos);
        btn_add_curso = (Button) findViewById(R.id.btn1AddCurso);
        btn_del_curso = (Button) findViewById(R.id.btn1DelCurso);

        cursos = new ArrayList<>();
        adapterCursos = new ArrayAdapter<Curso>(this, android.R.layout.simple_list_item_1, cursos);
        list_cursos.setAdapter(adapterCursos);
        adminCursos = new AdminSQLiteOpenHelperCurso(this,"administracion",null,1);
        showAllCursos();
    }

    public void addCurso (View view) {
        SQLiteDatabase db = adminCursos.getWritableDatabase();
        String nombCurso = nom_curso.getText().toString();

        ContentValues tupla = new ContentValues();
        tupla.put("nombreCurso",nombCurso);

        db.insert("curso",null,tupla);
        db.close();

        Toast.makeText(this,"Curso creado", Toast.LENGTH_SHORT).show();
        showAllCursos();

        nom_curso.setText("");
    }

    public void showAllCursos(){
        String queryCursos = "select * from curso";
        SQLiteDatabase db = adminCursos.getReadableDatabase();
        cursos.clear();

        Cursor c = db.rawQuery(queryCursos,null);

        while (c.moveToNext()){
            Curso cTemp = new Curso();
            cTemp.setNomCurso(c.getString(c.getColumnIndex("nombreCurso")));
            cursos.add(cTemp);
        }

        adapterCursos.notifyDataSetChanged();
    }

    public void elimCurso (View view) {
        SQLiteDatabase db = adminCursos.getWritableDatabase();

        String nomCursoElim;
        nomCursoElim = nom_curso.getText().toString();

        db.execSQL("delete from curso where nombreCurso= '"+nomCursoElim+"'");

        adapterCursos.notifyDataSetChanged();

        //db.delete("curso","nombreCurso="+nomCursoElim, null);
        Toast.makeText(this, "Asignatura eliminada", Toast.LENGTH_SHORT).show();

        //int cant = db.delete("curso","nombreCurso="+nomCursoElim, null);

        //if (cant==1)
          //  Toast.makeText(this, "Asignatura eliminada", Toast.LENGTH_SHORT).show();
        //else
          //  Toast.makeText(this, "No existe la asignatura " + nomCursoElim, Toast.LENGTH_SHORT).show();

        db.close();

        showAllCursos();

        nom_curso.setText("");
    }

}
