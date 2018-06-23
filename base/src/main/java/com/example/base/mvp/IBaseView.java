package com.example.base.mvp;


public interface IBaseView {
    void showLoading();
    void hideLoading();
    void serverFail(String msg);
}
