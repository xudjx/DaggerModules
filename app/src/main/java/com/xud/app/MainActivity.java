package com.xud.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.xud.base.core.BaseActivity;
import com.xud.modulea.ui.BusinessAMainFragment;
import com.xud.moduleb.ui.BusinessBMainFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.viewpager);
        initTabLayout();
    }

    private void initTabLayout() {
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }

    public class MyAdapter extends FragmentPagerAdapter {

        private final int PAGE_COUNT = 2;
        private String[] tabTitle = new String[] {"模块A", "模块B"};
        private Context mContext;
        private List<Fragment> mFragmentTab;

        public MyAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.mContext = context;
            mFragmentTab = new ArrayList<>();
            mFragmentTab.add(new BusinessAMainFragment());
            mFragmentTab.add(new BusinessBMainFragment());
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentTab.get(position);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitle[position];
        }
    }
}
