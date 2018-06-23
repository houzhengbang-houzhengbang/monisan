package com.example.asus.monisan.v.interfaces;


import com.example.asus.monisan.m.bean.AddBean;
import com.example.asus.monisan.m.bean.ParticularsBean;
import com.example.base.mvp.IBaseView;

public interface ParticularsInterface extends IBaseView {
    void onParticularsSuccess(ParticularsBean particularsBean);
    void onaddSuccess(AddBean addBean);
}
