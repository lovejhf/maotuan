package com.hkt.mao.app.android.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.hkt.mao.app.android.R;
import com.hkt.mao.app.android.base.BaseActivity;
import com.hkt.mao.app.android.ui.fragment.DesignStyleFragment;
import com.hkt.mao.app.android.ui.fragment.HomeFragment;
import com.hkt.mao.app.android.view.SlidingTabLayoutView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.tab)
    SlidingTabLayoutView tab;
    @BindView(R.id.pager)
    ViewPager pager;
    private String[] messageTitles = {"全部", "全部", "全部", "全部", "全部", "全部", "全部"};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        MessageAdapter messageAdapter = new MessageAdapter(getSupportFragmentManager());
        pager.setAdapter(messageAdapter);
        tab.setViewPager(pager);
        tab.setTextBold(2);
    }

    public class MessageAdapter extends FragmentPagerAdapter {


        public MessageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return messageTitles[position];
        }


        @Override
        public Fragment getItem(int position) {
            DesignStyleFragment designStyleFragment = new DesignStyleFragment();
            return designStyleFragment;
        }

        @Override
        public int getCount() {
            return messageTitles.length;
        }

    }
}
