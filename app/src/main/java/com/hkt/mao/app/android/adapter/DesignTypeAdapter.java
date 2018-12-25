package com.hkt.mao.app.android.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hkt.mao.app.android.R;

import java.util.List;

public class DesignTypeAdapter extends BaseQuickAdapter<Integer,BaseViewHolder> {
    public DesignTypeAdapter(int layoutResId, @Nullable List<Integer> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Integer item) {
        helper.setBackgroundRes(R.id.design_img,item);
    }
}
