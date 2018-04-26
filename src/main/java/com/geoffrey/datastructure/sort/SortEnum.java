package com.geoffrey.datastructure.sort;

import com.geoffrey.datastructure.sort.impl.BubbleSort;

/**
 * @author Geoffrey.Yip
 * @date 2018/4/26 23:23
 * @since 排序枚举
 */
public enum SortEnum {
    /**冒泡排序**/
    BUBBLE(new BubbleSort());

    private Sort sort;

    SortEnum(Sort sort) {
        this.sort = sort;
    }

    public Sort getImplement() {
        return sort;
    }
}
