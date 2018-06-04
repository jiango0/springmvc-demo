package com.test;

public class TestMain33 {

    public enum TestTT {

        WECHAT_MALL,  //微信商城
        ALL_IN_ONE_MACHINE,  //一体机
        SWIPE_MACHINE, //机台扫码
        BOSS_ORDER,  //BOSS订单
        KOU_BEI //口碑

    }

    public static void main(String[] args) {
        System.out.println(TestTT.WECHAT_MALL.ordinal());
        System.out.println(TestTT.WECHAT_MALL.name());
    }



}
