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
import com.xud.componentlib.router.Router;
import com.xud.componentservice.modulea.BusinessAService;
import com.xud.componentservice.moduleb.BusinessBService;
import com.xud.componentservice.modulekotlin.KotlinService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    BusinessAService businessAService;
    BusinessBService businessBService;
    KotlinService kotlinService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        businessAService = Router.getInstance().getService(BusinessAService.class);
        businessBService = Router.getInstance().getService(BusinessBService.class);
        kotlinService = Router.getInstance().getService(KotlinService.class);
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

        private final int PAGE_COUNT = 3;
        private String[] tabTitle = new String[] {"模块A", "模块B", "Kotlin"};
        private Context mContext;
        private List<Fragment> mFragmentTab;

        public MyAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.mContext = context;
            mFragmentTab = new ArrayList<>();
            mFragmentTab.add(businessAService.getMainFragment());
            mFragmentTab.add(businessBService.getMainFragment());
            mFragmentTab.add(kotlinService.getMainFragment());
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
