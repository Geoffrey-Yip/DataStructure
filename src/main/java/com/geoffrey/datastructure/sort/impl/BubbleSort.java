package com.geoffrey.datastructure.sort.impl;

import com.geoffrey.datastructure.array.DisorderedArray;
import com.geoffrey.datastructure.sort.Sort;

/**
 * @author Geoffrey.Yip
 * @date 2018/4/26 21:54
 * @since 冒泡排序 比较次数：O(N²) 交换次数：O(N²) 算法复杂度：O(N²)
 */
public class BubbleSort implements Sort {

    @Override
    public void doSort(DisorderedArray array) {
        //外圈循环一次就有一个大的值有序排到后面，所以外圈是从右往左缩减
        for (int out = array.size() - 1; out > 1; out--) {
            //内圈每次都从头开始
            for (int in = 0; in < out; in++) {
                //发现左边比右边大时则交换位置
                if (array.get(in) > array.get(in + 1)) {
                    swap(array, in, in + 1);
                }
            }
        }
    }
}
