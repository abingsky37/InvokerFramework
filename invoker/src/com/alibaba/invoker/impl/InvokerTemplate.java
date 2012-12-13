package com.alibaba.invoker.impl;

import com.alibaba.invoker.Invoker;
import com.alibaba.invoker.Result;

/**
 * 类InvokerTemplate.java的实现描述：调用模板类
 * 
 * @author yubing.linyb 2012-11-1 下午3:17:57
 */
public abstract class InvokerTemplate<T> implements Invoker<T> {

    protected InvokerDelegate invokerDelegate;

    public void setInvokerDelegate(InvokerDelegate invokerDelegate) {
        this.invokerDelegate = invokerDelegate;
    }

    public Result<T> invoke() {
        return invokerDelegate.invoke(this);
    }
}
