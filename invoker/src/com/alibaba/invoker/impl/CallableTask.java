package com.alibaba.invoker.impl;

import java.util.concurrent.Callable;

import com.alibaba.invoker.Invoker;

/**
 * ��CallableTask.java��ʵ���������첽���������װ
 * 
 * @author yubing.linyb 2012-11-1 ����3:19:27
 */
public class CallableTask<V> implements Callable<V> {

    Invoker<V> t;

    public CallableTask(Invoker<V> t){
        this.t = t;
    }

    public void setT(Invoker<V> t) {
        this.t = t;
    }

    @Override
    public V call() throws Exception {
        // TODO Auto-generated method stub
        return t.invokeDirectly();
    }

}
