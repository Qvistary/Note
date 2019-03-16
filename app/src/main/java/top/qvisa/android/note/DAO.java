package top.qvisa.android.note;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

public class DAO {

    private final MyDatabaseHelper mDb;


    public DAO(Context context) {
        mDb = new MyDatabaseHelper(context);

    }

    public void insert(String title,String Content) {
        SQLiteDatabase db = mDb.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("title", title);
        values.put("content", Content);
        db.insert("Note", null, values);
        values.clear();

    }

    public void update(String title,String Content) {
        ContentValues values = new ContentValues();
        SQLiteDatabase db = mDb.getReadableDatabase();

        values.put("content",Content);
        db.update("Note",values,title,null); //没有测试


    }

    public void delete() {

    }

    public void query(List<Note> mNoteList) {
        SQLiteDatabase sqLiteDatabase=mDb.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.query("Note",null,null,null,null,null,null);
        cursor.moveToFirst();
        do{
            String title=cursor.getString(cursor.getColumnIndex("title"));
            String content=cursor.getString(cursor.getColumnIndex("content"));
            Note note=new Note(title,content);
            mNoteList.add(note);
        }while (cursor.moveToNext());
        cursor.close();
    }
}
