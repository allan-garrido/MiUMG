package gt.edu.miumg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by allan on 23/07/2017.
 */

public class bdProfesorHelper extends SQLiteOpenHelper {
    public bdProfesorHelper(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table profesor(nombre text primary key, especialidad text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int version1, int version2) {
        db.execSQL("drop table if exists profesor");
        db.execSQL("create table profesor(nombre text primary key, especialidad text)");
    }
}
