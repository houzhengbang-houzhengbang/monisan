package com.example.asus.monisan.m.api;


import com.example.asus.monisan.m.bean.AddBean;
import com.example.asus.monisan.m.bean.CarBean;
import com.example.asus.monisan.m.bean.ListBean;
import com.example.asus.monisan.m.bean.ParticularsBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {


    //列表
    //http://120.27.23.105/product/getProducts?pscid=1
    @GET("product/getProducts?pscid=1")
    Observable<ListBean> getList();

    //详情
    //http://120.27.23.105/product/getProductDetail?pid=1
    @GET("product/getProductDetail")
    Observable<ParticularsBean> getparticulars(@Query("pid") String pid);

    //https://www.zhaoapi.cn/product/addCart?uid=15005&pid=2
    @GET("product/addCart?uid=15005")
    Observable<AddBean> getAdd(@Query("pid") String pid);



    //https://www.zhaoapi.cn/product/getCarts?uid=15005
    @GET("product/getCarts?uid=15005")
    Observable<CarBean> getCar();
}
