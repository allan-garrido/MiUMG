package gt.edu.miumg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by allan on 24/07/2017.
 */

public class bdEstudianteHelper extends SQLiteOpenHelper {
    public bdEstudianteHelper (Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nombre, factory, version);
    }

    @Override
    public  void onCreate(SQLiteDatabase db) {
        db.execSQL("create table estudiante(nombre text primary key, edad int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int version1, int version2) {
        db.execSQL("drop table if exists profesor");
        db.execSQL("create table estudiante(nombre text primary key, edad int)");
    }
}
