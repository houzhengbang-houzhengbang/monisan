package com.example.asus.monisan.v.activity;


import android.graphics.Color;

import com.example.asus.monisan.R;
import com.example.asus.monisan.m.model.MainModel;
import com.example.asus.monisan.p.MainPresenter;
import com.example.asus.monisan.v.fragment.FragmentList;
import com.example.asus.monisan.v.fragment.Fragmentvideo;
import com.example.base.BaseActivity;
import com.example.base.mvp.BaseModel;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends BaseActivity<MainPresenter> {


    private BottomTabBar bottombar;

    @Override
    protected BaseModel initModel() {
        return new MainModel();
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {


        bottombar = findViewById(R.id.bottombar);

    }

    @Override
    protected void initData() {

        bottombar.init(getSupportFragmentManager())
                .setImgSize(100,100)
                .setFontSize(0)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem( "视频", R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,Fragmentvideo.class)
                .addTabItem( "列表", R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,FragmentList.class)
                .isShowDivider(false);

    }


}
