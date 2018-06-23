package com.example.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.base.mvp.BaseModel;
import com.example.base.mvp.BasePresenter;
import com.example.base.mvp.IBaseView;

public abstract class BaseFragment<F extends BasePresenter> extends Fragment implements IBaseView {
    public F f;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(bindLayoutId(), container, false);

        initView(view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        f = initPresenter();
        if (f != null) {
            f.attch(initModel(), this);
        }
        initData();
    }

    //数据

    protected abstract void initData();

    // 初始化子类model

    protected abstract BaseModel initModel();

    //初始化view

    protected abstract void initView(View view);

    // 让子类初始化p

    protected abstract F initPresenter();

    //绑定资源

    protected abstract int bindLayoutId();

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void serverFail(String msg) {

    }


/*    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (p!= null) {
            p.detach();
        }
    }*/
}