package com.alibaba.invoker.impl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.alibaba.invoker.Result;

/**
 * 类AsyncResult.java的实现描述：异步调用结果封装
 * 
 * @author yubing.linyb 2012-11-1 下午3:17:22
 */
public class AsyncResult<T> implements Result<T> {

    private Future<T> a;
    private long      timeout; // 超时时间 毫秒

    public AsyncResult(Future<T> a, long timeout){
        this.a = a;
        this.timeout = timeout;
    }

    public T get() {
        try {
            if (timeout > 0) {
                return a.get(timeout, TimeUnit.MICROSECONDS);
            } else {
                return a.get();
            }

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TimeoutException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public void set(Future<T> a) {
        this.a = a;
    }

}
