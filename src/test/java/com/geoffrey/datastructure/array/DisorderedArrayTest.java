package com.geoffrey.datastructure.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Geoffrey.Yip
 * @date 2018/4/26 21:35
 * @since 无序数组测试
 */

public class DisorderedArrayTest {

    @Test
    public void testInsertAndFind() {
        long[] randomArray = randomArray(5);
        DisorderedArray array = new DisorderedArray(10);

        for (int i = 0; i < randomArray.length; i++) {
            array.insert(randomArray[i]);
        }
        //assert insert success
        Assert.assertEquals(randomArray.length, array.size());

        for (int i = 0; i < randomArray.length; i++) {
            //Assert insert order is unchance.
            Assert.assertEquals(randomArray[i],array.get(i));
        }
    }


    private long[] randomArray(int size) {
        long[] randomArray = new long[size];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = new Random().nextInt(500);
        }
        System.out.println("Random Array ：" + Arrays.toString(randomArray));
        return randomArray;
    }
}
