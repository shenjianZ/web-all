package com.aisi.schedule.test;

import com.aisi.schedule.util.MD5Util;
import org.junit.jupiter.api.Test;

public class TestMD5Util {
    @Test
    public void testEncrypt(){
        String encrypt = MD5Util.encrypt("111111");
        System.out.println(encrypt);
    }
}
