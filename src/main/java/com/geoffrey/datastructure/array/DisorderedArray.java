package com.geoffrey.datastructure.array;

import com.geoffrey.datastructure.sort.Sort;

import java.util.Optional;

/**
 * @author Geoffrey.Yip
 * @date 2018/4/26 21:29
 * @since 无序数组
 */
public class DisorderedArray extends AbstractArray  {

    /**选择的排序方法**/
    private Sort sort;

    public DisorderedArray(Integer size, Sort sort) {
        super(size);
        this.sort = sort;
    }

    /**
     * 获取数组值
     *
     * @param index 索引
     * @return 数组值
     */
    public long get(Integer index) {
        if (index >= nextElem) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return this.array[index];
    }

    /**
     * 设置数组的值
     *
     * @param index 索引
     * @param value 数组的值
     */
    public void set(Integer index, long value) {
        if (index > this.array.length) {
            throw new IndexOutOfBoundsException("索引太大");
        }
        this.array[index] = value;
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
        this.sort.doSort(this);
    }
}
