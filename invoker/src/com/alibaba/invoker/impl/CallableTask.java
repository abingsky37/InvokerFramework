package com.alibaba.invoker.impl;

import java.util.concurrent.Callable;

import com.alibaba.invoker.Invoker;

/**
 * 类CallableTask.java的实现描述：异步调用任务封装
 * 
 * @author yubing.linyb 2012-11-1 下午3:19:27
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
