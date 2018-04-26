package com.geoffrey.datastructure.sort.impl;

import com.geoffrey.datastructure.array.DisorderedArray;
import com.geoffrey.datastructure.sort.Sort;

/**
 * @author Geoffrey.Yip
 * @date 2018/4/26 23:30
 * @since 选择排序 比较次数：O(N²) 交换次数：O(N) 算法复杂度：O(N²)
 */
public class SelectionSort implements Sort {

    @Override
    public void doSort(DisorderedArray array) {
        //外圈循环一次就有一个小的值有序排到前面，所以外圈是从左往右缩减
        for (int i = 0; i < array.size(); i++) {
            //本次循环的一个最小值的临时变量索引
            int temp = i;
            //内圈从外圈开始，每次遍历找到最小的值，并记录
            for (int j = i + 1; j < array.size(); j++) {
                if (array.get(j) < array.get(temp)) {
                    temp = j;
                }
            }
            //循环完毕，将本次需要缩减的外圈位置设置为本次查询到的最小值
            swap(array, i, temp);
        }
    }

}
