package com.example.asus.monisan.m.model;



import android.util.Log;

import com.example.asus.monisan.m.api.ApiService;
import com.example.asus.monisan.m.bean.AddBean;
import com.example.asus.monisan.m.bean.ParticularsBean;
import com.example.asus.monisan.m.netUtil.RetrofitUtil;
import com.example.base.mvp.BaseModel;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class ParticularsModel extends BaseModel {


    public void MParticulars(String pid, final IMParticulars imParticulars) {
        ApiService retrofitInterface = RetrofitUtil.getInstance().getRetrofitInterface();
        Observable<ParticularsBean> getparticu = retrofitInterface.getparticulars(pid);

        getparticu.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ParticularsBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ParticularsBean particularsBean) {
                if (particularsBean != null) {
                    Log.e("123", "onNext: "+particularsBean.getData());
                    imParticulars.IMParticular(particularsBean);
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.e("error", " " + e);
            }

            @Override
            public void onComplete() {

            }
        });
    }

    public interface IMParticulars {
        void IMParticular(ParticularsBean particularsBean);
    }


    public void MAdd(String pid, final IMAdd imAdd) {
        ApiService retrofitInterface = RetrofitUtil.getInstance().getRetrofitInterface();
        Observable<AddBean> geta = retrofitInterface.getAdd(pid);

        geta.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AddBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(AddBean addBean) {
                if ( addBean!= null) {
                    imAdd.IMad(addBean);
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.e("error", " " + e);
            }

            @Override
            public void onComplete() {

            }
        });
    }

    public interface IMAdd {
        void IMad(AddBean addBean);
    }


}