package com.example.asus.monisan.v.activity;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.asus.monisan.R;
import com.example.asus.monisan.m.bean.CarBean;
import com.example.asus.monisan.m.model.CarModel;
import com.example.asus.monisan.p.CarPresenter;
import com.example.asus.monisan.v.adapter.Car_List_RecyAdapter;
import com.example.asus.monisan.v.adapter.List_RecyAdapter;
import com.example.asus.monisan.v.interfaces.CarInterface;
import com.example.base.BaseActivity;
import com.example.base.mvp.BaseModel;
import com.example.base.mvp.BasePresenter;

public class CarListActivity extends BaseActivity<CarPresenter> implements CarInterface {

    RecyclerView car_recy;
    private Car_List_RecyAdapter adapter;

    @Override
    protected BaseModel initModel() {
        return new CarModel();
    }

    @Override
    protected CarPresenter initPresenter() {
        return new CarPresenter();
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_car_list;
    }

    @Override
    protected void initView() {
         car_recy = findViewById(R.id.car_recy);
    }

    @Override
    protected void initData() {

        adapter = new Car_List_RecyAdapter(CarListActivity.this);
        car_recy.setAdapter(adapter);
        //布局管理器
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CarListActivity.this);
        car_recy.setLayoutManager(linearLayoutManager);


        presenter.PCar();
    }


    @Override
    public void onCarSuccess(CarBean carBean) {
        adapter.setData(carBean.getData().get(9).getList());
    }
}
