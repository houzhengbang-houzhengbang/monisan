package com.example.asus.monisan.m.model;


import android.util.Log;

import com.example.asus.monisan.m.api.ApiService;
import com.example.asus.monisan.m.bean.ListBean;
import com.example.asus.monisan.m.netUtil.RetrofitUtil;
import com.example.base.mvp.BaseModel;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListModel extends BaseModel {

    public void listP( final Imodelview imodelview) {

        ApiService retrofitInterface = RetrofitUtil.getInstance().getRetrofitInterface();
        Observable<ListBean> getlis = retrofitInterface.getList();
        getlis.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ListBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ListBean listBean) {
                if (listBean != null) {
                    imodelview.listm(listBean);
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.e("123", "onError: "+e );
            }

            @Override
            public void onComplete() {

            }
        });
    }



    public interface Imodelview {
        void listm(ListBean ListBean);
    }
}