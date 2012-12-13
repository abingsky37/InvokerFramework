package com.alibaba.invoker.impl;

import com.alibaba.invoker.Result;

/**
 * 类SyncResult.java的实现描述：同步调用结果封装
 * 
 * @author yubing.linyb 2012-11-1 下午3:17:41
 */
public class SyncResult<T> implements Result<T> {

    T a;

    public SyncResult(T a){
        this.a = a;
    }

    public T get() {
        return a;
    }

    public void set(T a) {
        this.a = a;
    }

}
