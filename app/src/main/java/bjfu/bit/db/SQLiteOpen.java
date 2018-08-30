package bjfu.bit.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteOpen extends SQLiteOpenHelper {

    private static final String DB_NAME = "user.db";
    private static final String TABLE_NAME = "info";
    //在SQLite里用作特殊标识的要加下划线(主键)
    private static final String INFO_COL_ID = "_id";
    private static final String INFO_COL_VISION = "vision";
    private static final String INFO_COL_YEAR = "year";
    private static final String INFO_COL_MONTH = "month";
    private static final String INFO_COL_DAY = "day";

    public SQLiteOpen(Context context) {
        //版本号不能为0
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //如果没有数据库及数据表 就会在OnCreate里自动创建
        StringBuilder sql = new StringBuilder();
        sql.append("Create table if not exists ");
        sql.append(TABLE_NAME + " ( ");
        // autoincrement 这一行自动增长
        sql.append(INFO_COL_ID + " integer primary key autoincrement, ");
        sql.append(INFO_COL_VISION + " varchar(10),");
        sql.append(INFO_COL_YEAR + " varchar(10),");
        sql.append(INFO_COL_MONTH + " varchar(10),");
        sql.append(INFO_COL_DAY + " varchar(10) ");
        sql.append(" ) ");
        //执行SQL
        db.execSQL(sql.toString());
    }

    //数据库更新升级
    // 通过版本号Version 删除以前的表  然后重新调用OnCreate
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //删除表（delete是删除表里的数据）
        String sql = " drop table if exists " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

    public boolean insertData(String vision, String year, String month, String day) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(INFO_COL_VISION, vision);
        contentValues.put(INFO_COL_YEAR, year);
        contentValues.put(INFO_COL_MONTH, month);
        contentValues.put(INFO_COL_DAY, day);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
}
