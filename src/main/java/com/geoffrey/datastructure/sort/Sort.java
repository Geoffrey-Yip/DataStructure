package com.geoffrey.datastructure.sort;

import com.geoffrey.datastructure.array.DisorderedArray;

/**
 * @author Geoffrey.Yip
 * @date 2018/4/26 21:49
 * @since 排序接口
 */
public interface Sort {

    /**
     * 排序方法
     * @param array 排序的数组
     */
    void doSort(DisorderedArray array);

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
