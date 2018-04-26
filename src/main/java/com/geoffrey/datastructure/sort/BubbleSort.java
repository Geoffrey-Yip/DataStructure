package com.geoffrey.datastructure.sort;

import com.geoffrey.datastructure.array.DisorderedArray;

/**
 * @author Geoffrey.Yip
 * @date 2018/4/26 21:54
 * @since 冒泡排序 算法复杂度：O(N²)
 */
public interface BubbleSort extends Sort {

    /**
     * 冒泡排序实现
     *
     * @param array 排序的数组
     */
    @Override
    default void doSort(DisorderedArray array) {
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
    default void swap(DisorderedArray array, int beforeIndex, int afterIndex) {
        long temp = array.get(beforeIndex);
        array.set(beforeIndex, array.get(afterIndex));
        array.set(afterIndex, temp);
    }
}
