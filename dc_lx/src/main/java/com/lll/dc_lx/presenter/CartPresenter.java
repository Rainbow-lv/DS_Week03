package com.lll.dc_lx.presenter;

import com.lll.dc_lx.bean.Result;
import com.lll.dc_lx.core.BasePresenter;
import com.lll.dc_lx.core.DataCall;
import com.lll.dc_lx.model.CarModel;

public class CartPresenter extends BasePresenter {
    public CartPresenter(DataCall dataCall) {
        super(dataCall);
    }


    @Override
    protected Result getData(Object... args) {
        Result result = CarModel.goodsList();//调用网络请求获取数据
        return result;
    }
}
