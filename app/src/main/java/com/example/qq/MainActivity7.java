package com.example.qq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity7 extends AppCompatActivity {
    public ProgressBar progressBar;
    int p=0;
    TextView time;
    Button begin,la7;
    String id7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        progressBar=findViewById(R.id.pro);
        time=findViewById(R.id.bf);
        la7=findViewById(R.id.la7);
        la7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity7.this,MainActivity5.class);
                startActivity(intent);
            }
        });
        begin=findViewById(R.id.begin);
        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (p == 0)
                    new myThread().start();
            }
        });
    }
    public class myThread extends Thread{
        @Override
        public void run() {
            super.run();
            while(true){
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(p==100){
                    Bundle bundle = getIntent().getExtras();
                    id7=bundle.getString("QQid5");
                    Intent intent=new Intent(MainActivity7.this,MainActivity8.class);
                    intent.putExtra("QQid7",id7);
                    startActivity(intent);
                    p=0;
                    break;
                }

                p++;
                progressBar.setProgress(p);//给进度条的当前进度赋值
                time.setText(p+"%");//显示当前进度为多少
            }
        }
    }

}