package com.hkt.mao.app.android.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hkt.mao.app.android.R;
import com.hkt.mao.app.android.bean.MineDataVo;

import java.util.List;

public class MineMenuAdapter extends BaseQuickAdapter<MineDataVo,BaseViewHolder> {
    public MineMenuAdapter(int layoutResId, @Nullable List<MineDataVo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MineDataVo item) {
        helper.setText(R.id.count,item.getCount());
        helper.setText(R.id.name,item.getName());
    }
}
