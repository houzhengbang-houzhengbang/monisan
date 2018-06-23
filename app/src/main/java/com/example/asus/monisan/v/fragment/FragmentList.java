package com.example.asus.monisan.v.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.asus.monisan.R;
import com.example.asus.monisan.m.bean.ListBean;
import com.example.asus.monisan.m.model.ListModel;
import com.example.asus.monisan.p.ListPresenter;
import com.example.asus.monisan.v.adapter.List_RecyAdapter;
import com.example.asus.monisan.v.interfaces.ListInterface;
import com.example.base.BaseFragment;
import com.example.base.mvp.BaseModel;

public class FragmentList extends BaseFragment<ListPresenter> implements ListInterface {


    RecyclerView recy;
    private List_RecyAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        return rootView;
    }
    @Override
    protected int bindLayoutId() {
        return R.layout.fragmentlist;
    }
    @Override
    protected ListPresenter initPresenter() {
        return new ListPresenter();
    }

    @Override
    protected BaseModel initModel() {
        return new ListModel();
    }

    @Override
    protected void initView(View view) {
        recy = view.findViewById(R.id.recy);
    }

    @Override
    protected void initData() {

        adapter = new List_RecyAdapter(getContext());
        recy.setAdapter(adapter);
        //布局管理器
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recy.setLayoutManager(linearLayoutManager);


        f.listp();

    }


    @Override
    public void onHomeSuccess(ListBean listBean) {
        adapter.setData(listBean.getData());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
