package com.geoffrey.datastructure.stack.impl;

import com.geoffrey.datastructure.stack.Stack;

import java.util.Arrays;

/**
 * @author Geoffrey.Yip
 * @date 2018/4/27 23:04
 * @since 数组实现的栈
 */
public class ArrayStack implements Stack<Long> {

    /**
     * 用户储存栈元素的数组
     **/
    private long[] values;
    /**
     * 栈的空间大小
     **/
    private int size;
    /**
     * 栈顶空间索引，也是栈空间使用大小
     **/
    private int top;

    public ArrayStack(int size) {
        values = new long[size];
        this.size = size;
        top = 0;
    }

    @Override
    public void push(Long value) {
        if (top >= size) {
            throw new IllegalStateException("Push fail,stack is full.");
        }
        values[top++] = value;
    }

    @Override
    public Long pop() {
        if (top == 0) {
            throw new IllegalStateException("Stack is empty!");
        }
        return values[--top];
    }

    @Override
    public Long peek() {
        if (top == 0) {
            throw new IllegalStateException("Stack is empty!");
        }
        return values[top - 1];
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"values\":")
                .append(Arrays.toString(values));
        sb.append(",\"size\":")
                .append(size);
        sb.append(",\"top\":")
                .append(top);
        sb.append('}');
        return sb.toString();
    }
}
