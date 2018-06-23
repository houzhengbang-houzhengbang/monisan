package com.example.asus.monisan.v.interfaces;


import com.example.asus.monisan.m.bean.CarBean;
import com.example.asus.monisan.m.bean.ParticularsBean;
import com.example.base.mvp.IBaseView;

public interface CarInterface extends IBaseView {
    void onCarSuccess(CarBean carBean);
}
