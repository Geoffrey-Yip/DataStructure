package com.geoffrey.datastructure.array;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author Geoffrey.Yip
 * @date 2018/4/26 21:21
 * @since 抽象数组
 */
public abstract class AbstractArray {
    /**
     * 持有的数组对象
     */
    protected long[] array;
    /**
     * 双重含义：
     * 1.当前数组已使用的空间大小
     * 2.下一个未使用空间的索引
     */
    protected Integer nextElem;

    /**
     * 获取该值在数组中的索引
     * @param searchValue 查询的值
     * @return 数组中这个值的索引
     */
    public abstract Optional<Integer> find(long searchValue);


    /**
     * 插入值
     * @param insertValue 插入的值
     */
    public abstract void insert(long insertValue);

    /**
     * 排序
     */
    public abstract void sort();


    /**
     * 删除值
     * @param deleteValue 删除的值
     * @return 删除结果
     */
    public boolean delete(long deleteValue){
        Optional<Integer> index = this.find(deleteValue);
        //不存在滴
        if (!index.isPresent()) {
            return false;
        }
        //将当前索引后面的值往前推一个位置
        for (int i = index.get(); i < this.nextElem; i++) {
            this.array[i] = this.array[i + 1];
        }
        //size--
        this.nextElem--;

        System.out.println("delete value :" + deleteValue);
        this.display();
        return true;
    }


    /**
     * 初始化数组
     *
     * @param size 初始化数组空间
     */
    public AbstractArray(Integer size) {
        this.array = new long[size];
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
