package com.hkt.mao.app.android.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.gyf.barlibrary.ImmersionBar;
import com.hkt.mao.app.android.R;
import com.hkt.mao.app.android.adapter.MenuAdapter;
import com.hkt.mao.app.android.adapter.MineMenuAdapter;
import com.hkt.mao.app.android.base.BaseFragment;
import com.hkt.mao.app.android.bean.MineDataVo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MineFragment extends BaseFragment {
    @BindView(R.id.menus)
    RecyclerView menus;
    Unbinder unbinder;
    @BindView(R.id.tool_list)
    RecyclerView toolList;
    @BindView(R.id.root_view_title)
    RelativeLayout rootViewTitle;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_mine, container, false);
        }
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        menus.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        MineMenuAdapter mineMenuAdapter = new MineMenuAdapter(R.layout.item_data_follow, getMenu());
        menus.setAdapter(mineMenuAdapter);
        ImmersionBar.setTitleBar(getActivity(), rootViewTitle);
        toolList.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        MenuAdapter adapter = new MenuAdapter(R.layout.item_home_menu, getTools());
        toolList.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private List<MineDataVo> getMenu() {
        List<MineDataVo> list = new ArrayList<>();
        list.add(new MineDataVo("优惠券", "2"));
        list.add(new MineDataVo("收藏", "8"));
        list.add(new MineDataVo("删除", "10"));
        return list;
    }
    private List<Pair<String, Integer>> getTools() {
        List<Pair<String, Integer>> menus = new ArrayList<>();
        menus.add(new Pair<>("签到", R.mipmap.ic_mine_sign));
        menus.add(new Pair<>("意见反馈", R.mipmap.ic_mine_opinion));
        menus.add(new Pair<>("邀请好友", R.mipmap.ic_mine_invite_frind));
        menus.add(new Pair<>("计算器", R.mipmap.ic_mine_calculator));
        menus.add(new Pair<>("预约记录", R.mipmap.ic_mine_recode));
        menus.add(new Pair<>("我的评论", R.mipmap.ic_mine_comment));
        menus.add(new Pair<>("顾客之声", R.mipmap.ic_mine_customer));
        menus.add(new Pair<>("帮助", R.mipmap.ic_mine_help));
        return menus;
    }
}
