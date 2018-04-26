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
}
