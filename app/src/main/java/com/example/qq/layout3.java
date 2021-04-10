package com.example.qq;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class layout3 {
    Activity activity;
    ListView list;
    TextView t1,t2;
    public View ViewShebei(Activity activity) {
        this.activity = activity;
        View view = View.inflate(activity.getApplicationContext(), R.layout.layout3, null);
        list = view.findViewById(R.id.list3);
        list.setAdapter(new MyAdapter3(activity.getApplicationContext()));
        return view;
    }
    class MyAdapter3 extends BaseAdapter {
        private Context ct;

        public MyAdapter3(Context context) {
            this.ct = context;
        }

        @Override
        public int getCount() {
            return 30;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View v;
            if (view != null) {
                v = view;
            } else {
                v = View.inflate(ct, R.layout.list, null);
            }
            final int index = i;
            t1 = v.findViewById(R.id.wm);
            t2 = v.findViewById(R.id.xiaoxi);
            t1.setText("我是设备" + i + "号");
            t2.setText("设备" + i + "号");
            return v;
        }
    }
}
