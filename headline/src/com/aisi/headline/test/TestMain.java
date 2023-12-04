package com.aisi.headline.test;

import com.aisi.headline.util.JwtHelper;
import org.junit.jupiter.api.Test;

public class TestMain {

    @Test
    public  void testAll() throws InterruptedException {
        String token = JwtHelper.createToken(1L);
        System.out.println(token);
        System.out.println(JwtHelper.isExpiration(token));
        Thread.sleep(6000);
        System.out.println(JwtHelper.isExpiration(token));
    }
}
