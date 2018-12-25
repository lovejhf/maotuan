package com.hkt.mao.app.android;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.heima.tabview.library.TabView;
import com.heima.tabview.library.TabViewChild;
import com.hkt.mao.app.android.base.BaseActivity;
import com.hkt.mao.app.android.ui.fragment.HomeFragment;
import com.hkt.mao.app.android.ui.fragment.MineFragment;
import com.hkt.mao.app.android.ui.fragment.ShopTypeFragment;
import com.hkt.mao.app.android.ui.fragment.WishFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tabView)
    TabView tabView;
    private List<TabViewChild> tabViewChildList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        TabViewChild home = new TabViewChild(R.mipmap.ic_home_n, R.mipmap.ic_home, "首页", new HomeFragment());
        TabViewChild type = new TabViewChild(R.mipmap.ic_home_type_n, R.mipmap.ic_home_type, "分类", new ShopTypeFragment());
        TabViewChild wish = new TabViewChild(R.mipmap.ic_home_wish_n, R.mipmap.ic_home_wish, "心愿单", new WishFragment());
        TabViewChild mine = new TabViewChild(R.mipmap.ic_home_mine_n, R.mipmap.ic_home_mine, "我的", new MineFragment());
        tabViewChildList.add(home);
        tabViewChildList.add(type);
        tabViewChildList.add(wish);
        tabViewChildList.add(mine);
        tabView.setTabViewChild(tabViewChildList, getSupportFragmentManager());
        tabView.setOnTabChildClickListener(new TabView.OnTabChildClickListener() {
            @Override
            public void onTabChildClick(int position, ImageView currentImageIcon, TextView currentTextView) {
                if (position == 0 || position == 2) {
                    setAnimal(currentImageIcon,currentTextView);

                } else {
                    setAnimalY(currentImageIcon,currentTextView);
                }
            }
        });
    }

    private void setAnimal(View view,View view1) {
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "scaleX", 0.75f, 1.3f, 1f, 1.2f, 1f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(view, "scaleY", 0.75f, 1.3f, 1f, 1.2f, 1f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(view1, "scaleX", 0.75f, 1.3f, 1f, 1.2f, 1f);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(view1, "scaleY", 0.75f, 1.3f, 1f, 1.2f, 1f);
        set.playTogether(animator1, animator2);
        set.playTogether(animator3, animator4);
        set.setDuration(800);
        set.start();
    }
    private void setAnimalY(ImageView imageView,View view) {
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator icon_anim = ObjectAnimator.ofFloat(imageView, "rotationY", 0.0F, 359.0F);
        ObjectAnimator icon_anim1 = ObjectAnimator.ofFloat(view, "rotationY", 0.0F, 359.0F);
        set.playTogether(icon_anim);
        set.playTogether(icon_anim1);
        set.setDuration(800);
        set.start();
    }

    @Override
    public boolean swipeBackPriority() {
        return false;
    }
}
