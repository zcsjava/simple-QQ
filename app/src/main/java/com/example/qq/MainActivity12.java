package com.example.qq;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity12 extends Fragment implements View.OnClickListener{
    ViewPager vp;
    List<View> viewList;
    TextView t0,t1,t2,t3,t4;
    View v0,v1,v2,v3,v4;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main12, container, false);
        vp = v.findViewById(R.id.vp);
        viewList = new ArrayList<>();
        layout layout=new layout();
        layout1 layout1=new layout1();
        layout2 layout2=new layout2();
        layout3 layout3=new layout3();
        layout4 layout4=new layout4();
        v0=layout.ViewHaoyou(getActivity());
        v1=layout1.ViewFenzu(getActivity());
        v2=layout2.ViewQunliao(getActivity());
        v3=layout3.ViewShebei(getActivity());
        v4=layout4.ViewTongxunlu(getActivity());
        t0=v.findViewById(R.id.friend);
        t1=v.findViewById(R.id.group);
        t2=v.findViewById(R.id.groupchat);
        t3=v.findViewById(R.id.install);
        t4=v.findViewById(R.id.addressbook);
        t0.setOnClickListener(this);
        t1.setOnClickListener(this);
        t2.setOnClickListener(this);
        t3.setOnClickListener(this);
        t4.setOnClickListener(this);
        viewList.add(v0);
        viewList.add(v1);
        viewList.add(v2);
        viewList.add(v3);
        viewList.add(v4);
        vp.setAdapter(new MyAdapter());
        vp.addOnPageChangeListener(new Myonpage());
        return v;
    }
    public void changeImg() {
        t0.setBackground(getResources().getDrawable(R.drawable.white));
        t1.setBackground(getResources().getDrawable(R.drawable.white));
        t2.setBackground(getResources().getDrawable(R.drawable.white));
        t3.setBackground(getResources().getDrawable(R.drawable.white));
        t4.setBackground(getResources().getDrawable(R.drawable.white));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.friend:
                vp.setCurrentItem(0);
                changeImg();
                t0.setBackground(getResources().getDrawable(R.drawable.bluetype));
                break;
            case R.id.group:
                vp.setCurrentItem(1);
                changeImg();
                t1.setBackground(getResources().getDrawable(R.drawable.bluetype));
                break;
            case R.id.groupchat:
                vp.setCurrentItem(2);
                changeImg();
                t2.setBackground(getResources().getDrawable(R.drawable.bluetype));
                break;
            case R.id.install:
                vp.setCurrentItem(3);
                changeImg();
                t3.setBackground(getResources().getDrawable(R.drawable.bluetype));
                break;
            case R.id.addressbook:
                vp.setCurrentItem(4);
                changeImg();
                t4.setBackground(getResources().getDrawable(R.drawable.bluetype));
                break;
        }
    }

    class MyAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View viewList, @NonNull Object object) {
            return viewList == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            container.addView(viewList.get(position));
            return viewList.get(position);
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView(viewList.get(position));
        }
    }
    public class Myonpage implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    changeImg();
                    t0.setBackground(getResources().getDrawable(R.drawable.bluetype));
                    break;
                case 1:
                    changeImg();
                    t1.setBackground(getResources().getDrawable(R.drawable.bluetype));
                    break;
                case 2:
                    changeImg();
                    t2.setBackground(getResources().getDrawable(R.drawable.bluetype));
                    break;
                case 3:
                    changeImg();
                    t3.setBackground(getResources().getDrawable(R.drawable.bluetype));
                    break;
                case 4:
                    changeImg();
                    t4.setBackground(getResources().getDrawable(R.drawable.bluetype));
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}