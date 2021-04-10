package com.example.qq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity {
    EditText et6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        Button la6=findViewById(R.id.la6);
        et6=findViewById(R.id.num1);
        la6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity6.this,MainActivity.class);
                startActivity(intent);
            }
        });
        Button xiayibu=findViewById(R.id.xiayibu);
        xiayibu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myhad6(v)==1){
                    Intent intent=new Intent(MainActivity6.this,MainActivity10.class);
                    intent.putExtra("number6",et6.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
    public int myhad6(View v) {
        //判断账号/密码是否有输入的处理...
        MainActivity.DbHelper helper = new MainActivity.DbHelper(this, "test.db", null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.query("QQ", null, "phone=?", new String[]{et6.getText().toString()}, null, null, null);
        //如果有查询到数据
        if (c != null && c.getCount() >= 1) {
            return 1;
        }
        //如果没有查询到数据
        else {
            Toast.makeText(this, "输入手机号错误，请重新输入或注册", Toast.LENGTH_SHORT).show();
            return 0;
        }
    }
}