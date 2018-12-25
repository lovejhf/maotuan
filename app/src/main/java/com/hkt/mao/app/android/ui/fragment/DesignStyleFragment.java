package com.hkt.mao.app.android.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hkt.mao.app.android.R;
import com.hkt.mao.app.android.adapter.DesignTypeAdapter;
import com.hkt.mao.app.android.adapter.HomeDesignTypeAdapter;
import com.hkt.mao.app.android.base.BaseFragment;
import com.hkt.mao.app.android.base.HeaderViewPagerFragment;
import com.hkt.mao.app.android.bean.DesignTypeVo;
import com.mcxiaoke.bus.Bus;
import com.mcxiaoke.bus.annotation.BusReceiver;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DesignStyleFragment extends HeaderViewPagerFragment {
    @BindView(R.id.design_type_list)
    RecyclerView designTypeList;
    Unbinder unbinder;
    private View rootView;
    private HomeDesignTypeAdapter designTypeAdapter;
    private List<DesignTypeVo> list = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_design_style, container, false);
        }
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @BusReceiver
    public void onMainThread(RefreshLayout refreshLayout) {
        loadMore();
        refreshLayout.finishLoadMore();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bus.getDefault().register(this);
        designTypeList.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.add(new DesignTypeVo("name1","项目名称1"));
        list.add(new DesignTypeVo("name2","项目名称2"));
        list.add(new DesignTypeVo("name3","项目名称3"));
        list.add(new DesignTypeVo("name4","项目名称4"));
        designTypeAdapter = new HomeDesignTypeAdapter(R.layout.item_home_design_type, list);
        designTypeList.setAdapter(designTypeAdapter);
        designTypeAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                    loadMore();
            }
        },designTypeList);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        Bus.getDefault().unregister(this);
    }

    private void loadMore() {
        designTypeAdapter.addData(list);
        designTypeAdapter.loadMoreFail();
    }

    @Override
    public View getScrollableView() {
        return designTypeList;
    }
}
