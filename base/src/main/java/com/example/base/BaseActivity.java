package com.example.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.base.mvp.BaseModel;
import com.example.base.mvp.BasePresenter;
import com.example.base.mvp.IBaseView;


public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    public P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayoutId());
        initView();
        presenter = initPresenter();
        if (presenter != null) {
            presenter.attch(initModel(), this);
        }
        initData();

    }

    // 数据

    protected abstract void initData();

    //初始化子类model

    protected abstract BaseModel initModel();

    //初始化view

    protected abstract void initView();

    // 让子类初始化p

    protected abstract P initPresenter();

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


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detach();
        }
    }
}
