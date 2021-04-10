package com.example.qq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener {
    FragmentManager fm;
    FragmentTransaction ft;
    Button bt1,bt2,bt3,bt4;
    TextView tv1,tv2,tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        fm = getSupportFragmentManager();
        bt1=findViewById(R.id.xx);
        bt2=findViewById(R.id.lxr);
        bt3=findViewById(R.id.dt);
        bt4=findViewById(R.id.la4);
        tv1=findViewById(R.id.xiaoxi);
        tv2=findViewById(R.id.lianxiren);
        tv3=findViewById(R.id.dongtai);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        fm=getSupportFragmentManager();
        ft=fm.beginTransaction();
        ft.replace(R.id.content,new MainActivity11());
        ft.commit();
    }
    public void onClick(View v){
        ft=fm.beginTransaction();
        switch (v.getId()){
            case R.id.xx:
                ft.replace(R.id.content,new MainActivity11());
                changeImg();
                bt1.setBackgroundResource(R.drawable.x2);
                tv1.setVisibility(View.VISIBLE);
                break;
            case R.id.lxr:
                ft.replace(R.id.content,new MainActivity12());
                changeImg();
                tv2.setVisibility(View.VISIBLE);
                bt2.setBackgroundResource(R.drawable.l2);
                break;
            case R.id.dt:
                ft.replace(R.id.content,new MainActivity13());
                changeImg();
                tv3.setVisibility(View.VISIBLE);
                bt3.setBackgroundResource(R.drawable.d2);
                break;
            case  R.id.la4:
                Intent intent=new Intent(MainActivity4.this,MainActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        ft.commit();
    }
    public void changeImg(){
        bt1.setBackgroundResource(R.drawable.x1);
        bt2.setBackgroundResource(R.drawable.l1);
        bt3.setBackgroundResource(R.drawable.d1);
        tv1.setVisibility(View.INVISIBLE);
        tv2.setVisibility(View.INVISIBLE);
        tv3.setVisibility(View.INVISIBLE);
    }
}