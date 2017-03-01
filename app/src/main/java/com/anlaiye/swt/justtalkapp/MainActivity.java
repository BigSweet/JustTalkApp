package com.anlaiye.swt.justtalkapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.anlaiye.swt.justtalkapp.fragment.ChatListFrament;
import com.anlaiye.swt.justtalkapp.fragment.ContactFrament;
import com.anlaiye.swt.justtalkapp.fragment.MoreFragment;
import com.anlaiye.swt.justtalkapp.util.TabUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 介绍：这里写介绍
 * 作者：sweet
 * 邮箱：sunwentao@imcoming.cn
 * 时间: 2017/3/1
 */
public class MainActivity extends AppCompatActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener {
    private List<Tab> mTabs;
    private ActionBar mActionBar;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        initTabs();
        initActionBar();

    }

    private void initTabs() {
        mTabs = new ArrayList<Tab>(3);

        mTabs.add(new Tab(R.string.chart, ChatListFrament.class));
        mTabs.add(new Tab(R.string.contact, ContactFrament.class));
        mTabs.add(new Tab(R.string.more, MoreFragment.class));

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }




    @Override
    public void onPageScrolled(int i, float v, int i2) {

    }

    @Override
    public void onPageSelected(int i) {

        //设置当前要显示的View
        mViewPager.setCurrentItem(i);
        //选中对应的Tab
        mActionBar.selectTab(mActionBar.getTabAt(i));
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

 /*   @Override
    public void unReadMsgCount(int count) {

        TabUtils.updateTabBadge(mActionBar.getTabAt(0),count);

    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.menu_actionbar, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        return super.onOptionsItemSelected(item);
    }

    public class Tab {

        public Tab() {
        }

        public Tab(int txt, Class fragment) {

            this.txt = txt;
            this.fragment = fragment;
        }


        private int txt;
        private Class fragment;


        public int getTxt() {
            return txt;
        }

        public void setTxt(int txt) {
            this.txt = txt;
        }

        public Class getFragment() {
            return fragment;
        }

        public void setFragment(Class fragment) {
            this.fragment = fragment;
        }
    }

    private void initActionBar() {

        mActionBar = getSupportActionBar();

        mActionBar.setDisplayHomeAsUpEnabled(false);
        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


        for (Tab t : mTabs) {

            ActionBar.Tab tab = mActionBar.newTab();

            tab.setCustomView(TabUtils.renderTabView(this, t.getTxt(), 0));
            tab.setTabListener(this);
            mActionBar.addTab(tab);
        }


        mViewPager.setAdapter(new TabFragmentPagerAdapter(getSupportFragmentManager()));
        mViewPager.setOnPageChangeListener(this);

//        TabUtils.updateTabBadge(mActionBar.getTabAt(1),10);
//        TabUtils.updateTabBadge(mActionBar.getTabAt(2),30);
    }


    class TabFragmentPagerAdapter extends FragmentPagerAdapter {


        public TabFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {

            Fragment fragment = null;

            try {
                fragment = (Fragment) mTabs.get(i).getFragment().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return mTabs.size();
        }


    }
}
