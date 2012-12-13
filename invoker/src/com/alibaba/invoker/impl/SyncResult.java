package com.alibaba.invoker.impl;

import com.alibaba.invoker.Result;

/**
 * ��SyncResult.java��ʵ��������ͬ�����ý����װ
 * 
 * @author yubing.linyb 2012-11-1 ����3:17:41
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
