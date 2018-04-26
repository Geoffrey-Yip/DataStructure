package com.geoffrey.datastructure.array;

import java.util.Optional;

/**
 * @author Geoffrey.Yip
 * @date 2018/4/23 21:48
 * @since 有序数组
 */
public class OrderedArray extends AbstractArray {


    public OrderedArray(Integer size) {
        super(size);
    }

    /**
     * 查询数据【二分查找】
     *
     * @param searchValue 需要查询的数据
     * @return 查询到的数据的索引
     */
    @Override
    public Optional<Integer> find(long searchValue) {
        int lowerBound = 0;
        int upperBound = this.nextElem - 1;
        long currValue;

        while (true) {
            if (lowerBound > upperBound) {
                return Optional.empty();
            }
            //找到中间的节点
            int currIndex = (lowerBound + upperBound) / 2;
            currValue = this.array[currIndex];
            //直接命中
            if (searchValue == currValue) {
                return Optional.of(currIndex);
            }
            //当前值小于中位值，缩小上限
            if (searchValue < currValue) {
                upperBound = currIndex - 1;
            } else {
                //当前大小于中位值，增大下限
                lowerBound = currIndex + 1;
            }
        }
    }

    /**
     * 插入
     *
     * @param insertValue 要插入的数据
     */
    @Override
    public void insert(long insertValue) {
        if (nextElem >= array.length) {
            throw new IllegalStateException("元素已满");
        }
        //找到刚好比该元素大的索引 GreaterThanValue
        int gtIndex = 0;
        for (; gtIndex < this.nextElem; gtIndex++) {
            if (this.array[gtIndex] > insertValue) {
                break;
            }
        }
        //查询到的索引以后的元素都往后移一位
        for (int i = this.nextElem; i > gtIndex; i--) {
            this.array[i] = this.array[i - 1];
        }
        //占位
        this.array[gtIndex] = insertValue;
        //size+1
        this.nextElem++;

        System.out.println("insert value :" + insertValue);
        this.display();
    }
}
