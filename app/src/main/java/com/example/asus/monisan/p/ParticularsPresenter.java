package com.example.asus.monisan.p;


import com.example.asus.monisan.m.bean.AddBean;
import com.example.asus.monisan.m.bean.ParticularsBean;
import com.example.asus.monisan.m.model.ParticularsModel;
import com.example.asus.monisan.v.interfaces.ParticularsInterface;
import com.example.base.mvp.BasePresenter;

public class ParticularsPresenter extends BasePresenter<ParticularsModel, ParticularsInterface> {


    public void PParticulars(String pid) {

      //  Log.e("123", "PParticulars: "+pid );
        model.MParticulars(pid,new ParticularsModel.IMParticulars() {
            @Override
            public void IMParticular(ParticularsBean particularsBean) {
                view.onParticularsSuccess(particularsBean);
            }
        });

    }

    public void PAdd(String pid) {


        model.MAdd(pid, new ParticularsModel.IMAdd() {
            @Override
            public void IMad(AddBean addBean) {
                view.onaddSuccess(addBean);
            }
        });

    }
}
