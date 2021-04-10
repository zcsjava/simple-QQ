package com.example.qq;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class layout1 {
    List<Map<String,String>> groupDtata=new ArrayList<Map<String, String>>();
    List<List<Map<String,String>>> childData=new ArrayList<List<Map<String,String>>>();
    ExpandableListView list;
    Activity activity;
    TextView t1,t2;
    public View ViewFenzu(Activity activity) {
        this.activity = activity;
        View view = View.inflate(activity.getApplicationContext(), R.layout.layout1, null);
        initData();
        list = view.findViewById(R.id.la1);
        list.setAdapter(new ExAdapter(activity.getApplicationContext()));
        return view;
    }
    public void initData()
    {
        for(int i=1;i<6;i++)
        {
            Map<String,String> groupMap=new HashMap<String,String>();
            groupDtata.add(groupMap);
            List<Map<String,String>> childMap=new ArrayList<Map<String,String>>();
            for (int j=1;j<6;j++)
            {
                Map<String, String> curChildMap = new HashMap<String, String>();
                childMap.add(curChildMap);
            }
            childData.add(childMap);
        }
    }
    class ExAdapter extends BaseExpandableListAdapter {
        Context context;
        public  ExAdapter(Context context)
        {
            super();
            this.context=context;
        }
        @Override
        public int getGroupCount() {
            return groupDtata.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return childData.get(groupPosition).size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return null;
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return null;
        }

        @Override
        public long getGroupId(int groupPosition) {
            return 0;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            View v=convertView;
            if(v==null)
                v=View.inflate(context,R.layout.group,null);
            TextView t1=v.findViewById(R.id.textGroup);
            t1.setText("     第"+groupPosition+"组");
            return v;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                LayoutInflater inflater = LayoutInflater.from(context);
                view = inflater.inflate(R.layout.list, null);
            }
            final int index = groupPosition;
            t1 = view.findViewById(R.id.wm);
            t2 = view.findViewById(R.id.xiaoxi);
            t1.setText("我是好友" + groupPosition + "号");
            t2.setText("好友" + groupPosition + "号");
            return view;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }
}
