package com.hkt.mao.app.android.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.gyf.barlibrary.ImmersionBar;
import com.hkt.mao.app.android.R;
import com.hkt.mao.app.android.adapter.DesignTypeAdapter;
import com.hkt.mao.app.android.adapter.MenuAdapter;
import com.hkt.mao.app.android.base.BaseFragment;
import com.hkt.mao.app.android.base.HeaderViewPagerFragment;
import com.hkt.mao.app.android.glide.GlideImageLoader;
import com.hkt.mao.app.android.view.BannerCircle;
import com.hkt.mao.app.android.view.SlidingTabLayoutView;
import com.lzy.widget.HeaderViewPager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class HomeFragment extends BaseFragment {
    @BindView(R.id.banner)
    BannerCircle banner;
    Unbinder unbinder;
    @BindView(R.id.title)
    LinearLayout title;
    @BindView(R.id.home_menu)
    RecyclerView homeMenu;
    @BindView(R.id.design_type_list)
    RecyclerView designTypeList;
    @BindView(R.id.tab)
    SlidingTabLayoutView tab;
    @BindView(R.id.pager)
    ViewPager viewpager;
    //    @BindView(R.id.smart_refresh_layout)
//    SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.scrollableLayout)
    HeaderViewPager scrollableLayout;
    @BindView(R.id.rotate_header_web_view_frame)
    PtrClassicFrameLayout mPtrFrame;
    private View rootView;
    private List<String> images = new ArrayList<>();
    private Integer[] designList = {R.mipmap.bg_design_01, R.mipmap.bg_design_02, R.mipmap.bg_design_03};
    private String[] messageTitles = {"全部", "全部", "全部", "全部"};
    public List<HeaderViewPagerFragment> fragments;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_home, container, false);
        }
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImmersionBar.setTitleBar(getActivity(), title);
        MenuAdapter adapter = new MenuAdapter(R.layout.item_home_menu, getMenus());
        homeMenu.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        designTypeList.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        designTypeList.setNestedScrollingEnabled(false);
        homeMenu.setNestedScrollingEnabled(false);
        DesignTypeAdapter designTypeAdapter = new DesignTypeAdapter(R.layout.item_design_type, Arrays.asList(designList));
        designTypeList.setAdapter(designTypeAdapter);
        homeMenu.setAdapter(adapter);
        images.add("https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png");
        images.add("https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png");
        fragments = new ArrayList<>();
        for (int i = 0; i < messageTitles.length; i++) {
            fragments.add(new DesignStyleFragment());
        }
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        MessageAdapter messageAdapter = new MessageAdapter(getChildFragmentManager());
        viewpager.setAdapter(messageAdapter);
        tab.setViewPager(viewpager);
        tab.setTextBold(2);
        scrollableLayout.canPtr();
        scrollableLayout.setCurrentScrollableContainer(fragments.get(0));
        viewpager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                scrollableLayout.setCurrentScrollableContainer(fragments.get(position));
            }
        });

        mPtrFrame.setLastUpdateTimeRelateObject(this);
        mPtrFrame.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return scrollableLayout.canPtr();
//                return PtrDefaultHandler.checkContentCanBePulledDown(frame, mScrollLayout, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                mPtrFrame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPtrFrame.refreshComplete();
                    }
                }, 100);
            }
        });

        // the following are default settings
        mPtrFrame.setResistance(1.7f);
        mPtrFrame.setRatioOfHeaderHeightToRefresh(1.2f);
        mPtrFrame.setDurationToClose(200);
        mPtrFrame.setDurationToCloseHeader(1000);
        // default is false
        mPtrFrame.setPullToRefresh(false);
        // default is true
        mPtrFrame.setKeepHeaderWhenRefresh(true);
        mPtrFrame.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPtrFrame.autoRefresh();
            }
        }, 100);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private List<Pair<String, Integer>> getMenus() {
        List<Pair<String, Integer>> menus = new ArrayList<>();
        menus.add(new Pair<>("设计师", R.mipmap.ic_designer));
        menus.add(new Pair<>("装修公司", R.mipmap.ic_renovation_company));
        menus.add(new Pair<>("挑尖货", R.mipmap.ic_best_goods));
        menus.add(new Pair<>("逛门店", R.mipmap.ic_shop_around));
        return menus;
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

            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return messageTitles.length;
        }

    }
}
