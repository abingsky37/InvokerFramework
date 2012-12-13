package com.alibaba.invoker;

/**
 * 类Result.java的实现描述：封装一个调用结果
 * 
 * @author yubing.linyb 2012-11-1 下午3:17:01
 */
public interface Result<T> {

    T get();
}
