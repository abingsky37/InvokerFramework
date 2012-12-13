package com.alibaba.invoker.impl;

import com.alibaba.invoker.Invoker;
import com.alibaba.invoker.Result;

/**
 * ��InvokerTemplate.java��ʵ������������ģ����
 * 
 * @author yubing.linyb 2012-11-1 ����3:17:57
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
