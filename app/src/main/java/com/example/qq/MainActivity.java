package com.example.qq;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText et,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt0=findViewById(R.id.zc);
        Button button=findViewById(R.id.dl);
        et = findViewById(R.id.zh1);
        et2 = findViewById(R.id.ma1);
        bt0.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity1.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if (myhad(v)==1) {
                    Intent intent = new Intent(MainActivity.this, MainActivityz2.class);
                    startActivity(intent);
                }
            }
        });

    }
    public int myhad(View v) {
        //判断账号/密码是否有输入的处理...
        MainActivity.DbHelper helper = new MainActivity.DbHelper(this, "test.db", null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.query("QQ", null, "QQid=? and password=?", new String[]{et.getText().toString(), et2.getText().toString()}, null, null, null);
        //如果有查询到数据
        if (c != null && c.getCount() >= 1) {
            return 1;
        }
        //如果没有查询到数据
        else {
            Toast.makeText(this, "账号或密码输入错误！", Toast.LENGTH_SHORT).show();
            return 0;
        }
    }
    public void onDialog(View view) {
        final Dialog dialog = new Dialog(this);//可以在style中设定dialog的样式
        dialog.setContentView(R.layout.layou);
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.gravity = Gravity.BOTTOM;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        dialog.getWindow().setAttributes(lp);
        //设置该属性，dialog可以铺满屏幕
        dialog.getWindow().setBackgroundDrawable(null);
        dialog.show();
        slideToUp(dialog.getWindow().findViewById(R.id.layout));
        Button bt1 =dialog.findViewById(R.id.bt1);
        Button bt2 =dialog.findViewById(R.id.bt2);
        Button bt3 =dialog.findViewById(R.id.bt3);
        bt1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(MainActivity.this,MainActivity5.class);
            startActivity(intent);
        }
    });
        bt2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(MainActivity.this,MainActivity6.class);
            startActivity(intent);
        }
    });
        bt3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialog.dismiss();
        }
    });
}

    public static void slideToUp(View view) {
        Animation slide = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                1.0f, Animation.RELATIVE_TO_SELF, 0.0f);

        slide.setDuration(2000);
        slide.setFillAfter(true);
        slide.setFillEnabled(true);
        view.startAnimation(slide);

        slide.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    public static class DbHelper extends SQLiteOpenHelper {
        public static final String TB_NAME = "QQ";  //表名

        //构造方法：第1参数为上下文，第2参数库库名，第3参数为游标工厂，第4参数为版本
        public DbHelper(Context context, String dbname, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, dbname, factory, version);  //创建或打开数据库
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            //当表不存在时，创建表；第一字段为自增长类型
            db.execSQL("CREATE TABLE " +
                    TB_NAME + "( id char(11) primary key," +
                    "phone char(11)," + "QQid char(10),"+ "password varchar(16)"+")");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // 执行SQL命令
            db.execSQL("DROP TABLE IF EXISTS " + TB_NAME);
            onCreate(db);
        }
    }
}
