package com.example.qq;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

/*
    本类MyDAO调用了打开数据库的助手类DbHelper
    本类MyDAO提供的CRUD针对数据库test.db的表friends
    查询数据库表所有记录的方法：allQuery()
    插入记录的方法：insertInfo(String name,int age)
    删除记录的方法：deleteInfo(String selId)
    修改记录方法：updateInfo(String name,int age,String selId)
*/
public class MyDAO {
    private SQLiteDatabase myDb;  //类的成员
    private MainActivity.DbHelper dbHelper;  //类的成员

    public MyDAO(Context context) {
        dbHelper = new MainActivity.DbHelper(context,"test.db",null,1);
    }
    public void add(String id,String phone,String QQid,String password){  //插入记录
        myDb = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id",id);
        values.put("phone", phone);
        values.put("QQid", QQid);
        values.put("password",password);
        myDb.insert ("QQ",null,values);
    }
    public void update(String phone,String QQid,String password,String id){  //修改记录
        myDb = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id",id);
        values.put("phone", phone);
        values.put("QQid", QQid);
        values.put("password",password);
        myDb.update("QQ",values,"id=?",new String[]{id});
        //上面几行代码的功能可以用下面的一行代码实现
        //myDb.execSQL("update friends set name = ? ,age = ? where _id = ?",new Object[]{name,age,selId});
    }
}
