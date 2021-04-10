package com.example.qq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {
    EditText zh5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Button la5=findViewById(R.id.la5);
        zh5=findViewById(R.id.zh5);
        la5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity5.this,MainActivity.class);
                startActivity(intent);
            }
        });
        Button a1=findViewById(R.id.a1);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myhad5(v)==1){
                    Intent intent=new Intent(MainActivity5.this,MainActivity7.class);
                    intent.putExtra("QQid5",zh5.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
    public int myhad5(View v) {
        //判断账号/密码是否有输入的处理...
        MainActivity.DbHelper helper = new MainActivity.DbHelper(this, "test.db", null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.query("QQ", null, "QQid=?", new String[]{zh5.getText().toString()}, null, null, null);
        //如果有查询到数据
        if (c != null && c.getCount() >= 1) {
            return 1;
        }
        //如果没有查询到数据
        else {
            Toast.makeText(this, "输入账号错误，请重新输入或注册", Toast.LENGTH_SHORT).show();
            return 0;
        }
    }
}