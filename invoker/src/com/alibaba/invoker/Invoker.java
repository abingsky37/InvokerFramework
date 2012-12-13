package com.alibaba.invoker;

/**
 * ��Invker.java��ʵ������������һ�ε���
 * 
 * @author yubing.linyb 2012-11-1 ����3:05:45
 */
public interface Invoker<T> {

    /**
     * �����һ�ε��õ��ڲ��߼����ɾ���ҵ���߼�ʵ��
     * 
     * @return
     */
    T invokeDirectly();

    /**
     * ��ܷ�װ�ĵ��ã��ڲ������{@code Invker.internalInvoke()},�����ϴ����װ�߼���
     * 
     * @return
     */
    Result<T> invoke();
}
