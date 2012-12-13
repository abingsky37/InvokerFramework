package com.alibaba.invoker.sample;

import com.alibaba.invoker.Result;
import com.alibaba.invoker.impl.InvokerDelegate;
import com.alibaba.invoker.impl.InvokerTemplate;

public class InvokeSample {

    MemberService memberService = new MemberService();

    public void invokeDirectory() {
        long s = System.currentTimeMillis();
        int t1 = memberService.countMember();
        int t2 = memberService.countMember();
        System.out.println("r1:" + t1);
        System.out.println("r2:" + t2);
        long e = System.currentTimeMillis();

        System.out.println("time used£º" + (e - s));
    }

    public void invokeByInvoker() {
        InvokerDelegate delegate = new InvokerDelegate();
        delegate.setSync(false);
        delegate.setEatException(true);
        InvokerTemplate<Integer> countMemberInvoker = new InvokerTemplate<Integer>() {

            @Override
            public Integer invokeDirectly() {
                return memberService.countMember();
            }
        };

        countMemberInvoker.setInvokerDelegate(delegate);

        long s = System.currentTimeMillis();
        Result<Integer> r1 = countMemberInvoker.invoke();
        Result<Integer> r2 = countMemberInvoker.invoke();
        System.out.println("r1:" + r1.get());
        System.out.println("r2:" + r2.get());
        long e = System.currentTimeMillis();
        System.out.println("time used£º" + (e - s));
    }

    public static void main(String[] args) {
        InvokeSample sample = new InvokeSample();
        sample.invokeDirectory();
        sample.invokeByInvoker();
    }
}
