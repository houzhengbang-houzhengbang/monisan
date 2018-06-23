package com.example.asus.monisan.p;



import com.example.asus.monisan.m.bean.CarBean;
import com.example.asus.monisan.m.model.CarModel;
import com.example.asus.monisan.v.interfaces.CarInterface;
import com.example.base.mvp.BasePresenter;

public class CarPresenter extends BasePresenter<CarModel, CarInterface> {


    public void PCar() {


        model.MCar(new CarModel.IMCar() {
            @Override
            public void IMca(CarBean carBean) {
                view.onCarSuccess(carBean);
            }
        });
    }
}
