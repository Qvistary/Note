package top.qvisa.android.note;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_Table_Note = "create table Note ("
            + "id integer primary key autoincrement,"
            + "title text,"
            + "content text)";
    private static final String TAG = "MyDatabaseHelper" ;

    private Context mContext;

    public MyDatabaseHelper(Context context) {
        super(context, "NoteDB.db", null, 1);
        mContext = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_Table_Note);
        Log.d(TAG,"CREATE ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Note");
        onCreate(db);
        Log.d(TAG,"Update ");
    }
}
