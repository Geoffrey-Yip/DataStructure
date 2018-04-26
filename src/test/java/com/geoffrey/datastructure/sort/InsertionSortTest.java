package com.geoffrey.datastructure.sort;

import com.geoffrey.datastructure.BaseTest;
import com.geoffrey.datastructure.array.DisorderedArray;
import org.junit.Test;

import java.util.Random;

/**
 * @author Geoffrey.Yip
 * @date 2018/4/27 0:09
 * @since 插入排序测试
 */
public class InsertionSortTest extends BaseTest {

    @Test
    public void testSort() {
        DisorderedArray array = new DisorderedArray(10, SortEnum.INSERTION.getImplement());
        //模拟局部有序的情况
        array.insert(1);
        array.insert(2);
        array.insert(3);
        array.insert(4);
        for (int i = 0; i < 6; i++) {
            array.insert(new Random().nextInt(500));
        }
        //sort
        array.sort();
        //show cosole
        array.display();
        //assert sort finish
        super.assertSortFinish(array);
    }
}
