package com.alibaba.invoker.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.alibaba.invoker.Invoker;
import com.alibaba.invoker.Result;

/**
 * ��InvokerDelegate.java��ʵ�����������ô������
 * 
 * <pre>
 * һ�ε��õ���ϸ������������ʱʱ�䡢�Ƿ�ͬ�����쳣����ȡ�
 * 
 * @author yubing.linyb 2012-11-1 ����3:18:20
 */
public class InvokerDelegate {

    public static ExecutorService executorService = Executors.newCachedThreadPool();
    private int                   timeout         = -1;                             // ��ʱʱ��
    private boolean               isSync;                                           // �Ƿ�ͬ��
    private boolean               eatException;                                     // �Ƿ�Ե��쳣
    private Object                mockResult;                                       // mock�Ľ���������Ϊ���ڷ����쳣�ǻ᷵��mock����

    public <T> Result<T> invoke(Invoker<T> t) {
        if (isSync) {// ͬ������
            if (eatException) {// �Ե��쳣
                try {
                    return new SyncResult<T>(t.invokeDirectly());
                } catch (Throwable e) {
                    // ͳһ��־
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
