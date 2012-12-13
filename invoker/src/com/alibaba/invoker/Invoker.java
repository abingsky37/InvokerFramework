package com.alibaba.invoker;

/**
 * 类Invker.java的实现描述：代表一次调用
 * 
 * @author yubing.linyb 2012-11-1 下午3:05:45
 */
public interface Invoker<T> {

    /**
     * 具体的一次调用的内部逻辑，由具体业务逻辑实现
     * 
     * @return
     */
    T invokeDirectly();

    /**
     * 框架封装的调用，内部会调用{@code Invker.internalInvoke()},并加上代理封装逻辑。
     * 
     * @return
     */
    Result<T> invoke();
}
