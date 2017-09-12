package com.dgl.www.kaiwei.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.dgl.www.kaiwei.R;
import com.dgl.www.kaiwei.adapter.MyAdapter;
import com.dgl.www.kaiwei.fragment.FragmentIHome;
import com.dgl.www.kaiwei.fragment.MyFragmentTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dugaolong on 17/3/21.
 */

public class TabLayoutActivity extends AppCompatActivity {
    public static final String TAG = "TabLayoutActivity";
    private TabLayout mTabLayout ;
    private ViewPager mViewPager ;

    private List<Fragment> list_Fragments ;
    private List<String> list_Titles ;

    private MyAdapter mMyAdapter ;
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.tablayout);
        initView();
        getData();
        initData();
    }

    private void initView() {
        mTabLayout = (TabLayout)findViewById(R.id.tablayout);
        mViewPager = (ViewPager)findViewById(R.id.viewpager);
    }


    private void initData() {
        list_Fragments = new ArrayList<>();
        list_Titles = new ArrayList<>();

//        list_Fragments.add(new MyFragmentOne(this));
        list_Fragments.add(new FragmentIHome(this,"http://www.btcar.net/search/"+data+"_ctime_1.html"));
        list_Fragments.add(new MyFragmentTwo(this,"http://www.bthai.net/list/"+data+"-s1d-1.html"));

        list_Titles.add("1a");
        list_Titles.add("2a");

        mMyAdapter = new MyAdapter(getSupportFragmentManager(),list_Fragments,list_Titles);
        mViewPager.setAdapter(mMyAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }


    public void getData() {

        this.data = getIntent().getStringExtra("data");
    }
}
