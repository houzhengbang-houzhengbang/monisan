package com.example.asus.monisan.m.model;



import android.util.Log;

import com.example.asus.monisan.m.api.ApiService;
import com.example.asus.monisan.m.bean.CarBean;
import com.example.asus.monisan.m.bean.ParticularsBean;
import com.example.asus.monisan.m.netUtil.RetrofitUtil;
import com.example.base.mvp.BaseModel;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class CarModel extends BaseModel {


    public void MCar(final IMCar imCar) {
        ApiService retrofitInterface = RetrofitUtil.getInstance().getRetrofitInterface();
        Observable<CarBean> getc = retrofitInterface.getCar();

        getc.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CarBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(CarBean carBean) {
                if (carBean != null) {
                    imCar.IMca(carBean);
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

    public interface IMCar {
        void IMca(CarBean carBean);
    }


}