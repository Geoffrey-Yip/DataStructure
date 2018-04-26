package com.geoffrey.datastructure.sort.impl;

import com.geoffrey.datastructure.array.DisorderedArray;
import com.geoffrey.datastructure.sort.Sort;

/**
 * @author Geoffrey.Yip
 * @date 2018/4/26 23:56
 * @since 插入排序，比较适合局部有序的情况
 * 比较次数：O(N²) 交换次数：O(N²) 算法复杂度：O(N²)
 */
public class InsertionSort implements Sort {

    @Override
    public void doSort(DisorderedArray array) {
        //外圈循环一次就有一个小的值有序排到前面，所以外圈是从左往右缩减
        for (int out = 0; out < array.size(); out++) {
            //存放临时值
            long temp = array.get(out);
            int in = out;
            //当发现自身不是第一个并且左边的值比自己大时
            while (in > 0 && array.get(in - 1) >= temp) {
                //将左边的值放到自己的位置
                array.set(in, array.get(in - 1));
                //自己左移一个位置，继续循环
                --in;
            }
            //把自己的值赋值给最终移动的位置
            array.set(in, temp);
        }
    }
}
