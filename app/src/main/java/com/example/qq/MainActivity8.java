package com.example.qq;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity8 extends Activity {
    int i;
    View v;
    String id8,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        final Button button = findViewById(R.id.kuaisu);
        final Button button1 = findViewById(R.id.woyi);
        final RelativeLayout rl5 = findViewById(R.id.rl5);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ContentUtil.sendSmsWithBody(MainActivity8.this, "1069070069", "ZM1138");
                button.setBackground(getResources().getDrawable(R.drawable.b));
                button1.setBackground(getResources().getDrawable(R.drawable.b));
                rl5.setVisibility(View.VISIBLE);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity8.this,MainActivity9.class);
                phone=myhad(v);
                intent.putExtra("phone8",phone);
                intent.putExtra("QQid8",id8);
                startActivity(intent);
            }
        });
    }
    public String myhad(View v) {
        MainActivity.DbHelper helper = new MainActivity.DbHelper(this, "test.db", null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();
        Bundle bundle = getIntent().getExtras();
        id8=bundle.getString("QQid7");
        Cursor c = db.query("QQ", null, "QQid=?", new String[]{id8}, null, null, null);
        c.moveToFirst();
        if(c != null && c.getCount() >= 1){
            phone=c.getString(c.getColumnIndex("phone"));
            c.close();
            return phone;
        }
        else
            return null;
    }
}