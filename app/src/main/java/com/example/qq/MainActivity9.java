package com.example.qq;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity9 extends AppCompatActivity {
    TextView password1,password2;
    String id9,phone9;
    private Button login1;
    private TextView t1;
    private TextView t2;
    private ImageView eye;
    private String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
    private String regnum="1234567890";
    private String rezimu="qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
    private int zifu;
    private int shuzi;
    private int zimu;
    private int password_lenth;
    private String last;
    private  String currlast;
    private  boolean eyes=false;
    public Button back5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        password1=findViewById(R.id.password1);
        password2=findViewById(R.id.password2);

        eye=findViewById(R.id.eyes);
        eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!eyes){
                    password1.setInputType(InputType.TYPE_NUMBER_VARIATION_PASSWORD);
                    eye.setBackgroundResource(R.drawable.yan1);
                    eyes=true;
                }
                else
                {password1.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    eye.setBackgroundResource(R.drawable.yan);
                    eyes=false;}
            }});
        final MyDAO mydao=new MyDAO(this);
        login1=findViewById(R.id.login1);
        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (password1.getText().toString().length() >= 8 && ((zifu > 0 & zimu > 0) || (shuzi > 0 && zimu > 0) || (zifu > 0 && shuzi > 0))) {
                    Bundle bundle = getIntent().getExtras();
                    phone9 = bundle.getString("phone8");
                    id9 = bundle.getString("QQid8");
                    mydao.update(phone9, id9, password1.getText().toString(), phone9);
                    Intent intent = new Intent();
                    intent.setClass(MainActivity9.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        t1=findViewById(R.id.radio1);
        t2=findViewById(R.id.radio2);
        xiahua(-200);

        password1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xiahua(0);
                t1.setVisibility(View.VISIBLE);
                t2.setVisibility(View.VISIBLE);
            }
        });

        password1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) {
                if(password1.getText().toString().length()!=0) //判断是否为空
                    currlast=String.valueOf(s).substring(s.length() - 1);
                else
                {currlast=String.valueOf(s);}
                if (password_lenth > password1.getText().toString().length())//判断是否进行删除操作
                    shanjian(last);
                else
                    panduan(currlast);
                last = currlast;
                if (password1.getText().toString().length() >= 8)
                    t1.setText("✔密码由8-16位字符、或符号组成");
                else t1.setText("⚪密码由8-16位字符、或符号组成");
                if((zifu>0&zimu>0)||(shuzi>0&&zimu>0)||(zifu>0&&shuzi>0))
                    t2.setText("✔至少含2中以上字符");
                else
                    t2.setText("⚪至少含2中以上字符");
                if(password1.getText().toString().length() >= 8&&((zifu>0&zimu>0)||(shuzi>0&&zimu>0)||(zifu>0&&shuzi>0))) {
                    login1.setBackgroundColor(getResources().getColor(R.color.blue));
                }
                else login1.setBackgroundColor(getResources().getColor(R.color.white_blue));
                password_lenth=password1.getText().toString().length();
            }
        });
    }

    public void xiahua(int y)
    {
        TranslateAnimation translateAnimation=new TranslateAnimation(0,1,0,y);
        translateAnimation.setDuration(100);
        translateAnimation.setFillAfter(true);
        login1=findViewById(R.id.login1);
        login1.setAnimation(translateAnimation);
        login1.setVisibility(View.VISIBLE);
    }

    public void panduan(String s)
    {
        if(regEx.indexOf(s)!=-1)
            zifu=zifu+1;
        if(regnum.indexOf(s)!=-1)
            shuzi=shuzi+1;
        if(rezimu.indexOf(s)!=-1)
            zimu=zimu+1;
    }

    public void  shanjian(String s)
    {
        if(regEx.indexOf(s)!=-1)
            zifu=zifu-1;
        if(regnum.indexOf(s)!=-1)
            shuzi=shuzi-1;
        if(rezimu.indexOf(s)!=-1)
            zimu=zimu-1;
    }
}