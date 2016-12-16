package com.tangcco.application22;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.tangcco.application22.view.MarqueeView;

import java.util.ArrayList;
import java.util.List;


public class AutoTextActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_text2);
        MarqueeView marqueeView = (MarqueeView) findViewById(R.id.marqueeView);

        List<String> info = new ArrayList<>();
        info.add("1. 大家好，我是孙福生。");
        info.add("2. 欢迎大家关注我哦！");
        info.add("3. GitHub帐号：sfsheng0322");
        info.add("4. 新浪微博：孙福生微博");
        info.add("5. 个人博客：sunfusheng.com");
        info.add("6. 微信公众号：孙福生");
        marqueeView.startWithList(info);

        marqueeView.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, TextView textView) {
                //执行需求的业务逻辑
                Toast.makeText(AutoTextActivity.this, "点击了第" + position + "条公告", Toast.LENGTH_SHORT).show();
            }
        });
        MarqueeView marqueeView2 = (MarqueeView) findViewById(R.id.marqueeView2);
        List<String> info1 = new ArrayList<>();
        info1.add("你好！");
        info1.add("你能");
        info1.add("打架吗");
        marqueeView2.startWithList(info);
        marqueeView2.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, TextView textView) {
                Toast.makeText(AutoTextActivity.this, "点击了第" + position + "条公告", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
