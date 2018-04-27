package com.geoffrey.datastructure.queue.impl;

import com.geoffrey.datastructure.queue.Queue;

import java.util.Arrays;

/**
 * @author Geoffrey.Yip
 * @date 2018/4/27 23:46
 * @since 数组实现的队列
 */
public class ArrayQueue implements Queue<Long> {

    /**
     * 用户储存栈元素的数组
     **/
    private long[] values;
    /**
     * 当前队列已使用大小
     */
    private int size;
    /**
     * 队列头所在的索引
     */
    private int headIndex;
    /**
     * 下一个元素插入的索引位置
     */
    private int nextElem;

    public ArrayQueue(int size) {
        this.values = new long[size];
        this.size = 0;
        this.headIndex = 0;
        this.nextElem = 0;
    }

    @Override
    public void insert(Long value) {
        if (size == values.length) {
            throw new IllegalStateException("Queue is full.");
        }
        //已经到了末端，又从数组头部开始插入
        if (nextElem == values.length) {
            nextElem = 0;
        }
        this.values[nextElem++] = value;
        size++;
    }

    @Override
    public Long remove() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty.");
        }
        long headValue = values[headIndex];
        //判断队头索引是不是到数组最尾端
        if (headIndex == values.length - 1) {
            headIndex = 0;
        } else {
            headIndex ++;
        }
        size--;
        return headValue;
    }

    @Override
    public Long peek() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty.");
        }
        return values[headIndex];
    }

    public Integer size() {
        return this.size;
    }

    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"values\":")
                .append(Arrays.toString(values));
        sb.append(",\"size\":")
                .append(size);
        sb.append(",\"headIndex\":")
                .append(headIndex);
        sb.append(",\"nextElem\":")
                .append(nextElem);
        sb.append('}');
        return sb.toString();
    }
}
