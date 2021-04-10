package com.example.qq;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qq.R;

public class MainActivity1 extends AppCompatActivity {
    private Spinner spinner;
    private EditText number;
    private CheckBox checkBox;
    private MyDAO myDAO;
    Button back;
    Button next;
    Toast toast;
    Button zc;
    String s;
    String ss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        myDAO=new MyDAO(this);
        number  =findViewById(R.id.number);
        spinner =findViewById(R.id.dianhua);
        checkBox=findViewById(R.id.cb1);
        zc   =findViewById(R.id.zc);
        next =findViewById(R.id.xiayibu);
        back =findViewById(R.id.layout);
        final String[] arr = {"+86", "+852", "853", "886"};
        ArrayAdapter<String> ad = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, arr);

        spinner.setAdapter(ad);
        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view, int position, long id) {
                ss=arr[position];
                arg0.setVisibility(View.VISIBLE);
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                } else {
                    toast = Toast.makeText(getApplicationContext(), "请同意用户协议和隐私保护", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP, 0, 10);
                    toast.show();
                }
            }
        });

        number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                if (number.getText().toString().length() == 11 && checkBox.isChecked())
                    next.setBackground(getResources().getDrawable(R.drawable.bluetype));
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()==true)
                {
                    myDAO.add(number.getText().toString(),number.getText().toString(),null,null);
                    Intent intent = new Intent(MainActivity1.this, MainActivity2.class);
                    intent.putExtra("number",number.getText().toString());
                    startActivity(intent);
                }
              else
                  dl(v);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity1.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
    public void xyb (View view) {
        if (number.getText().toString().length() == 11 && checkBox.isChecked()) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setIcon(R.mipmap.ic_launcher);
            dialog.setTitle("用户协议");
            dialog.setMessage("请遵守用户协议");
            dialog.setPositiveButton("同意", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    s=number.getText().toString();
                    Intent intent = new Intent(MainActivity1.this, MainActivity2.class);
                    Bundle bd =new Bundle();
                    bd.putString("number",s);
                    bd.putString("spinner",ss);
                    intent.putExtras(bd);
                    startActivity(intent); }});
            dialog.setNegativeButton("拒绝", null);
            dialog.show();
        }
    }

    public void xieyi (View view){
        AlertDialog.Builder xy=new AlertDialog.Builder(this);
        xy.setIcon(R.mipmap.ic_launcher);
        xy.setTitle("用户协议和隐私协议");
        xy.setMessage("请你务必审慎阅读、充分理解“服务协议”和“隐私协议”各条款。");
        xy.setNegativeButton("我已阅读",null);
        xy.show();
    }

    public void zc(View view){
        AlertDialog.Builder zc=new AlertDialog.Builder(this);
        zc.setIcon(R.mipmap.ic_launcher);
        zc.setTitle("用户协议和隐私协议");
        zc.setMessage("请你务必审慎阅读、充分理解“服务协议”和“隐私协议”各条款。");
        zc.setNegativeButton("我已阅读",null);
        zc.show();
    }
    public void dl(View view) {
        AlertDialog.Builder dl=new AlertDialog.Builder(this);
        dl.setIcon(R.mipmap.ic_launcher);
        dl.setTitle("注意");
        dl.setMessage("请勾选✔按钮。");
        dl.setNegativeButton("确定",null);
        dl.show();
    }
}