package bjfu.bit.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class SQLiteOperate {
    private SQLiteOpen sqLiteOpen;

    public SQLiteOperate(Context context) {
        sqLiteOpen = new SQLiteOpen(context);
    }

    //插入数据
    public void insert(Data data) {
        //得到一个可写的数据库
        SQLiteDatabase db = sqLiteOpen.getWritableDatabase();
        //ContentValues 键值的用法   key要跟列名一致
        ContentValues cv = new ContentValues();
        cv.put("vision", data.getVision());
        cv.put("day", data.getDay());
        cv.put("month", data.getMonth());
        cv.put("year", data.getYear());
        db.insert("info", null,cv);
        db.close();
    }

    //查询一条数据
    public Data searchUser(String id) {
        SQLiteDatabase db = sqLiteOpen.getReadableDatabase();
        // ?为占位符  用下一个参数来匹配
        Cursor cs = db.query("info", null, "_id = ? ", new String[]{id}, null, null, null);
        Data data = null;
        if (cs.moveToNext()) {
            data = new Data();
            data.setId(cs.getInt(cs.getColumnIndex("_id")));
            data.setVision(cs.getInt(cs.getColumnIndex("vision")));
            data.setYear(cs.getInt(cs.getColumnIndex("year")));
            data.setMonth(cs.getInt(cs.getColumnIndex("month")));
            data.setDay(cs.getInt(cs.getColumnIndex("day")));
        }
        cs.close();
        db.close();
        return data;
    }

    //查询所有数据
    public List search() {
        SQLiteDatabase db = sqLiteOpen.getReadableDatabase();
        Cursor cs = db.query("info", null, null, null, null, null, null);
        Data data = null;
        List<Data>   list = new ArrayList<>();
        while (cs.moveToNext()) {
            data = new Data();
            // cs.getColumnIndex("_id")   id 这一列结果中的下标
            data.setId(cs.getInt(cs.getColumnIndex("_id")));
            data.setVision(cs.getInt(cs.getColumnIndex("vision")));
            data.setYear(cs.getInt(cs.getColumnIndex("year")));
            data.setMonth(cs.getInt(cs.getColumnIndex("month")));
            data.setDay(cs.getInt(cs.getColumnIndex("day")));
            list.add(data);
        }
        //关闭结果集
        cs.close();
        //关闭数据库
        db.close();
        return list;
    }

    //删除所有数据
    public void delete() {
        SQLiteDatabase db = sqLiteOpen.getWritableDatabase();
        db.delete("info", null, null);
        db.close();
    }

    //删除一条数据
    public void deleteUser(String id) {
        SQLiteDatabase db = sqLiteOpen.getWritableDatabase();
        db.delete("info", "_id= ? ", new String[]{id});
        db.close();
    }

    //修改数据
    public void update(Data data) {
        SQLiteDatabase db = sqLiteOpen.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("vision", data.getVision());
        cv.put("year", data.getYear());
        cv.put("month", data.getMonth());
        cv.put("day", data.getDay());
        String id = String.valueOf(data.getId());
        db.update("info", cv, "_id= ? ", new String[]{id});
        db.close();
    }

}
