package com.geoffrey.datastructure.sort.impl;

import com.geoffrey.datastructure.array.DisorderedArray;
import com.geoffrey.datastructure.sort.Sort;

/**
 * @author Geoffrey.Yip
 * @date 2018/4/26 21:54
 * @since 冒泡排序 算法复杂度：O(N²)
 */
public class BubbleSort implements Sort {

    /**
     * 冒泡排序实现
     *
     * @param array 排序的数组
     */
    @Override
    public void doSort(DisorderedArray array) {
        for (int i = array.size() - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array.get(j) > array.get(j + 1)) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    /**
     * 交换索引对应值的位置
     *
     * @param array       数组
     * @param beforeIndex 第一个索引
     * @param afterIndex  第二个索引
     */
    private void swap(DisorderedArray array, int beforeIndex, int afterIndex) {
        long temp = array.get(beforeIndex);
        array.set(beforeIndex, array.get(afterIndex));
        array.set(afterIndex, temp);
    }
}
