package com.bw.huyanyan.activit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.bw.huyanyan.R;
import com.bw.huyanyan.fragment.FragmentFive;
import com.bw.huyanyan.fragment.FragmentFor;
import com.bw.huyanyan.fragment.FragmentOnet;
import com.bw.huyanyan.fragment.FragmentThree;
import com.bw.huyanyan.fragment.FragmentTwo;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private TabLayout tab;
    ArrayList<String> tabs = new ArrayList<>();
    ArrayList<Fragment> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        //找控件
        vp = findViewById(R.id.vp);
        tab = findViewById(R.id.tab);
        tabs.add("首页");
        tabs.add("朋友圈");
        tabs.add("购物车");
        tabs.add("订单");
        tabs.add("我的");
        tab.addTab(tab.newTab().setText(tabs.get(0)));
        tab.addTab(tab.newTab().setText(tabs.get(1)));
        tab.addTab(tab.newTab().setText(tabs.get(2)));
        tab.addTab(tab.newTab().setText(tabs.get(3)));
        tab.addTab(tab.newTab().setText(tabs.get(4)));

        FragmentOnet fragmentOnet = new FragmentOnet();
        FragmentTwo fragmentTwo = new FragmentTwo();
        FragmentThree fragmentThree = new FragmentThree();
        FragmentFor fragmentFor = new FragmentFor();
        FragmentFive fragmentFive = new FragmentFive();
        list.add(fragmentOnet);
        list.add(fragmentTwo);
        list.add(fragmentThree);
        list.add(fragmentFor);
        list.add(fragmentFive);
        //创建适配器
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager());
        vp.setAdapter(myFragmentAdapter);
        tab.setupWithViewPager(vp);

    }
    public class MyFragmentAdapter extends FragmentPagerAdapter{
        public MyFragmentAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabs.get(position);
        }
    }
}
