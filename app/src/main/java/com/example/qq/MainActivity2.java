package com.example.qq;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;
public class MainActivity2 extends AppCompatActivity {
    private TextView chongxin,tp1;
    private EditText input_all;
    private  int i=10;
    Handler mangler;
    private String num,id2;
    private  TextView back2;
    @SuppressLint("HandlerLeak")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        back2    = findViewById(R.id.la2);
        chongxin = findViewById(R.id.chongxin);
        Bundle bundle = getIntent().getExtras();
        id2=bundle.getString("number");
        tp1=findViewById(R.id.pn2);
        tp1.setText(id2);
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,MainActivity1.class);
                startActivity(intent); }});

        input_all=findViewById(R.id.ip0);
        input_all.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                String sum=input_all.getText().toString();
                if(sum.equals(num)) {
                    Bundle bundle = getIntent().getExtras();
                    id2=bundle.getString("number");
                    Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                    intent.putExtra("id2",id2);
                    startActivity(intent);
                }
            }
        });
        tongzhi();

        mangler = new MyHander() {
            public void handleMessage(Message msg) {
                chongxin.setText("重新发送");
                if (msg.what >0) {
                    chongxin.setText(chongxin.getText().toString() + msg.what + "s");
                }
            }
        };

        new Thread(){
            public void run(){
                while(i>=0){
                    Message message=new Message();
                    message.what=i;
                    mangler.sendMessage(message);
                    i--;
                    SystemClock.sleep(1000);
                }
                if(i==-1){
                    chongxin.setTextColor(getResources().getColor(R.color.blue));
                }
                super.run();
            }
        }.start();

        chongxin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tongzhi();
                i=10;
                chongxin.setTextColor(getResources().getColor(R.color.white_blue));
                new Thread() {
                    public void run() {
                        while (i >= 0) {
                            Message message = new Message();
                            message.what = i;
                            mangler.sendMessage(message);
                            i--;
                            SystemClock.sleep(1000);
                        }
                        if (i == -1) {
                            chongxin.setTextColor(getResources().getColor(R.color.blue));
                        }
                        super.run();
                    }
                }.start();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void tongzhi(){
        final NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        String id= getchannelId("my_id","my_name", NotificationManager.IMPORTANCE_HIGH);
        final Notification.Builder nf = new Notification.Builder(this,id);
        nf.setSmallIcon(R.mipmap.ic_launcher);
        Random random=new Random();
        int i=Math.abs(random.nextInt()%1000000);
        while(i<100000)
            i=Math.abs(random.nextInt()%1000000);
        num=String.valueOf(i);
        nf.setContentTitle("验证码");
        nf.setContentText(num);
        nm.notify(1,nf.build());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getchannelId(String id, String name, int i) {
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(id, name, i);
            nm.createNotificationChannel(channel);
            return id;
        } else {
            return null;
        }
    }

    private static class MyHander extends Handler {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    }
}
