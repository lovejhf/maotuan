package com.hkt.mao.app.android.channel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.hkt.mao.app.android.R;

import java.util.LinkedHashMap;
import java.util.Map;

public class ChannelViewActivity extends AppCompatActivity implements ChannelView.OnChannelListener {
    private String TAG = getClass().getSimpleName();
    private ChannelView channelView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel_view);

        channelView = findViewById(R.id.channelView);
        init();
    }

    private void init() {
        String[] myChannel = {"要闻", "视频", "新时代", "娱乐", "体育", "军事", "NBA", "国际"};
        String[] recommendChannel0 = {"综艺", "美食", "育儿", "冰雪", "必读", "政法网事", "都市",
                "NFL", "韩流"};
//        String[] recommendChannel = {"问答", "文化", "佛学", "股票", "动漫", "理财", "情感", "职场", "旅游"};
//        String[] recommendChannel2 = {"家居", "电竞", "数码", "星座", "教育", "美容", "电视剧",
//                "搏击", "健康"};

        Map<String, String[]> channels = new LinkedHashMap<>();
        channels.put("我的频道", myChannel);
        channels.put("推荐频道", recommendChannel0);
//        channels.put("国内", recommendChannel);
//        channels.put("国外", recommendChannel2);

        channelView.setFixedChannel(-1);
        channelView.setChannels(channels);
        channelView.setMyChannelBelong(1, 2);
        channelView.setMyChannelBelong(1, 3);
//        channelView.setMyChannelBelong(5, 4);
//        channelView.setMyChannelBelong(7, 3);
//        channelView.setMyChannelBelong(0, 2);
        channelView.setChannelNormalBackground(R.drawable.bg_channel_normal);
        channelView.setChannelSelectedBackground(R.drawable.bg_channel_selected);
        channelView.setChannelFocusedBackground(R.drawable.bg_channel_focused);
        channelView.setOnChannelItemClickListener(this);

    }

    @Override
    public void channelItemClick(int itemId, String channel) {
        Log.i(TAG, itemId + ".." + channel);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        channelView.getMyChannel();
    }
}
