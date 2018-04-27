package com.geoffrey.datastructure.queue;

/**
 * @author Geoffrey.Yip
 * @date 2018/4/27 23:40
 * @since 队列
 */
public interface Queue<E> {

    /**
     * 插入队尾
     * @param value 插入的值
     */
    void insert(E value);

    /**
     * 移除并返回队头
     * @return value
     */
    E remove();

    /**
     * 查看队头
     * @return value
     */
    E peek();
}
