package com.geoffrey.datastructure.array;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author Geoffrey.Yip
 * @date 2018/4/23 21:48
 * @since 有序数组
 */
public class OrderedArray {
    /**
     * 持有的数组对象
     */
    private long[] array;
    /**
     * 双重含义：
     * 1.当前数组已使用的空间大小
     * 2.下一个未使用空间的索引
     */
    private Integer nextElem;

    /**
     * 初始化有序数组
     *
     * @param size 初始化数组空间
     */
    public OrderedArray(Integer size) {
        array = new long[size];
        this.nextElem = 0;
    }

    /**
     * 获取数组已使用大小
     *
     * @return 数组大小
     */
    public int size() {
        return this.nextElem;
    }

    /**
     * 查询数据【二分查找】
     *
     * @param searchValue 需要查询的数据
     * @return 查询到的数据的索引
     */
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

    /**
     * 删除数组元素
     *
     * @param deleteValue 要删除的元素
     * @return 操作结果
     */
    public boolean delete(long deleteValue) {
        Optional<Integer> indexOptional = this.find(deleteValue);
        //不存在滴
        if (!indexOptional.isPresent()) {
            return false;
        }
        Integer index = indexOptional.get();
        //将当前索引后面的值往前推一个位置
        for (int i = index; i < this.nextElem; i++) {
            this.array[i] = this.array[i + 1];
        }
        //size--
        this.nextElem--;

        System.out.println("delete value :" + deleteValue);
        this.display();
        return true;
    }

    /**
     * 显示数组详情
     */
    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"array\":")
                .append(Arrays.toString(array));
        sb.append(",\"nextElem\":")
                .append(nextElem);
        sb.append('}');
        return sb.toString();
    }
}
