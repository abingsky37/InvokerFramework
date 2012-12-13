package com.alibaba.invoker.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.alibaba.invoker.Invoker;
import com.alibaba.invoker.Result;

/**
 * 类InvokerDelegate.java的实现描述：调用代理对象
 * 
 * <pre>
 * 一次调用的详细描述，包括超时时间、是否同步、异常处理等。
 * 
 * @author yubing.linyb 2012-11-1 下午3:18:20
 */
public class InvokerDelegate {

    public static ExecutorService executorService = Executors.newCachedThreadPool();
    private int                   timeout         = -1;                             // 超时时间
    private boolean               isSync;                                           // 是否同步
    private boolean               eatException;                                     // 是否吃掉异常
    private Object                mockResult;                                       // mock的结果，如果不为空在发生异常是会返回mock对象

    public <T> Result<T> invoke(Invoker<T> t) {
        if (isSync) {// 同步调用
            if (eatException) {// 吃掉异常
                try {
                    return new SyncResult<T>(t.invokeDirectly());
                } catch (Throwable e) {
                    // 统一日志
                    return null;
                }
            }
            return new SyncResult<T>(t.invokeDirectly());
        } else {

            CallableTask<T> task = new CallableTask<T>(t);
            Future<T> f = executorService.submit(task);
            return new AsyncResult<T>(f, timeout);
        }
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public boolean isSync() {
        return isSync;
    }

    public void setSync(boolean isSync) {
        this.isSync = isSync;
    }

    public boolean isEatException() {
        return eatException;
    }

    public void setEatException(boolean eatException) {
        this.eatException = eatException;
    }

    public Object getMockResult() {
        return mockResult;
    }

    public void setMockResult(Object mockResult) {
        this.mockResult = mockResult;
    }

}
