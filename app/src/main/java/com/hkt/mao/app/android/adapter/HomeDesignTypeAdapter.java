package com.hkt.mao.app.android.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hkt.mao.app.android.R;
import com.hkt.mao.app.android.bean.DesignTypeVo;

import java.util.List;

public class HomeDesignTypeAdapter extends BaseQuickAdapter<DesignTypeVo,BaseViewHolder> {
    public HomeDesignTypeAdapter(int layoutResId, @Nullable List<DesignTypeVo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DesignTypeVo item) {
        helper.setText(R.id.name,item.getName());
        helper.setText(R.id.sub,item.getProjectName());
    }
}
