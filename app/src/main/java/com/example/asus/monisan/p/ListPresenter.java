package com.example.asus.monisan.p;


import com.example.asus.monisan.m.bean.ListBean;
import com.example.asus.monisan.m.model.ListModel;
import com.example.asus.monisan.v.interfaces.ListInterface;
import com.example.base.mvp.BasePresenter;


public class ListPresenter extends BasePresenter<ListModel,ListInterface> {


    public void listp() {
        model.listP( new ListModel.Imodelview() {
            @Override
            public void listm(ListBean listBean) {
                view.onHomeSuccess(listBean);
            }
        });

    }



}
