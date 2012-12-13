package com.alibaba.invoker.sample;

public class MemberService {

    @SuppressWarnings("static-access")
    public int countMember() {
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 100;
    }
}
