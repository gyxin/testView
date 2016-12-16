package com.tangcco.application22;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuAdapter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.tangcco.application22.adapter.MyViewPagerAdapter;
import com.tangcco.application22.fragment.ChannelFragment;
import com.tangcco.application22.fragment.RankFragment;
import com.tangcco.application22.fragment.RecommendFragment;
import com.tangcco.application22.fragment.UserFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity {
    private ViewPager mViewPager;
    private MyViewPagerAdapter adapter;
    private FragmentManager fm;
    private RadioGroup rdo;
    private List<Fragment> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        mViewPager = (ViewPager) findViewById(R.id.main_vp);
        fm = getSupportFragmentManager();
        adapter = new MyViewPagerAdapter(fm);
        mData = new ArrayList<Fragment>();
        mData.add(new RecommendFragment(this));
        mData.add(new ChannelFragment(this));
        mData.add(new RankFragment(this));
        mData.add(new UserFragment(this));
        adapter.setData(mData);
        mViewPager.setAdapter(adapter);
        rdo = (RadioGroup) findViewById(R.id.rdo);
        CheckId(R.id.rb_tj);
        ((RadioButton) findViewById(R.id.rb_tj)).setChecked(true);
        rdo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                CheckId(checkedId);
            }
        });
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mViewPager.setCurrentItem(position);
                if (position == 0) {
                    ((RadioButton) findViewById(R.id.rb_tj)).setChecked(true);
                } else if (position == 1) {
                    ((RadioButton) findViewById(R.id.rb_pd)).setChecked(true);
                } else if (position == 2) {
                    ((RadioButton) findViewById(R.id.rb_ph)).setChecked(true);
                } else {
                    ((RadioButton) findViewById(R.id.rb_me)).setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void CheckId(int checkedId) {
        switch (checkedId) {
            case R.id.rb_tj:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.rb_pd:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.rb_ph:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.rb_me:
                mViewPager.setCurrentItem(3);
                break;
        }
    }

}
