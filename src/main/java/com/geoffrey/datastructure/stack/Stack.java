package com.geoffrey.datastructure.stack;

/**
 * @author Geoffrey.Yip
 * @date 2018/4/27 22:53
 * @since 栈接口
 */
public interface Stack<T> {

    /**
     * 入栈
     * @param value value
     */
    void push(T value);

    /**
     * 出栈
     * @return value
     */
    T pop();

    /**
     * 查看栈顶值
     * @return value
     */
    T peek();

    /**
     * 获取栈内元素数量
     * @return value size
     */
    int size();
}
