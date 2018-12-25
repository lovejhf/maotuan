package com.hkt.mao.app.android.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hkt.mao.app.android.R;
import com.hkt.mao.app.android.base.BaseFragment;


public class WishFragment extends BaseFragment {
    private View rootView ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView==null){
            rootView = inflater.inflate(R.layout.fragment_home,container,false);
        }
        return rootView;
    }
}
