package com.geoffrey.datastructure.array;

import com.geoffrey.datastructure.BaseTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Geoffrey.Yip
 * @date 2018/4/26 21:35
 * @since 无序数组测试
 */

public class DisorderedArrayTest extends BaseTest {

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
}
