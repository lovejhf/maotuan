package com.hkt.mao.app.android.adapter;

import android.support.annotation.Nullable;
import android.util.Pair;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hkt.mao.app.android.R;

import java.util.List;

public class MenuAdapter extends BaseQuickAdapter<Pair<String,Integer>,BaseViewHolder> {
    public MenuAdapter(int layoutResId, @Nullable List<Pair<String, Integer>> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Pair<String, Integer> item) {
        helper.setText(R.id.name,item.first);
        helper.setBackgroundRes(R.id.image,item.second);
    }
}
