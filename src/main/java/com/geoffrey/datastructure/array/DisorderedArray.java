package com.geoffrey.datastructure.array;

import com.geoffrey.datastructure.sort.BubbleSort;

import java.util.Optional;

/**
 * @author Geoffrey.Yip
 * @date 2018/4/26 21:29
 * @since 无序数组
 */
public class DisorderedArray extends AbstractArray implements BubbleSort {

    public DisorderedArray(Integer size) {
        super(size);
    }

    public long get(Integer index) {
        if (index >= nextElem) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return this.array[index];
    }

    @Override
    public Optional<Integer> find(long searchValue) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchValue) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    @Override
    public void insert(long insertValue) {
        if (nextElem >= array.length) {
            throw new IllegalStateException("元素已满");
        }
        this.array[nextElem] = insertValue;
        this.nextElem++;
    }

    @Override
    public void sort() {
        this.doSort(this.array);
    }
}
