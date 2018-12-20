package com.lll.dc_lx.core;

import com.lll.dc_lx.bean.Result;

public interface DataCall<T> {
    void success(T data);

    void fail(Result result);
}
