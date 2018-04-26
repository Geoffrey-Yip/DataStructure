package com.geoffrey.datastructure;

import com.geoffrey.datastructure.array.AbstractArray;
import com.geoffrey.datastructure.array.DisorderedArray;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Geoffrey.Yip
 * @date 2018/4/26 22:56
 * @since 通用测试方法
 */
public class BaseTest {

    /**
     * 初始化一个随机值的数组
     *
     * @param size 数组大小
     * @return 随机值数组
     */
    protected long[] randomArray(int size) {
        long[] randomArray = new long[size];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = new Random().nextInt(500);
        }
        System.out.println("Random Array ：" + Arrays.toString(randomArray));
        return randomArray;
    }

    /**
     * 给数组填充随机值 只填充size的80%
     *
     * @param array 数组
     */
    protected void fillRandomArrayValue(AbstractArray array) {
        for (int i = 0; i < array.length()* 0.8; i++) {
            array.insert(new Random().nextInt(500));
        }
    }

    protected void assertSortFinish(DisorderedArray array){
        for (int i = 0; i < array.size(); i++) {
            if (i == array.size() - 1) {
                break;
            }
            Assert.assertTrue("排序失败", array.get(i) <= array.get(i + 1));
        }
    }
}
