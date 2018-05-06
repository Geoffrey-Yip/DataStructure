package com.geoffrey.datastructure.link;

/**
 * @author Geoffrey.Yip
 * @date 2018/5/6 13:05
 * @since 单链表
 */
public class AloneLinkList<T> {

    /**链表头**/
    private Link<T> first;
    /**链表大小**/
    private int size;

    /**
     * 插入元素到任意位置
     * @param index 位置索引
     * @param value 元素
     */
    public void insert(int index, T value) {
        if (index > this.size) {
            throw new IllegalStateException("插入索引无效");
        }
        //当前元素为空
        if (index == 0) {
            this.insertFirst(value);
            return;
        }
        //当前索引前节点
        Link<T> before = first;
        for (int i = 1; i < index; i++) {
            before = before.getNext();
        }
        //当前索引节点
        Link<T> after = before.getNext();
        //将前节点链接到新插入节点
        //将新插入节点连接到旧索引节点
        before.setNext(new Link<>(value, after));
        size++;
    }

    /**
     * 根据索引删除元素
     *
     * @param index 索引
     */
    public boolean delete(int index) {
        if (index >= this.size || index < 0) {
            return false;
        }
        //删除的是第一个元素
        if (index == 0) {
            this.first = this.first.getNext();
            size--;
            return true;
        }
        //找到要删除的元素的前一个元素
        Link<T> beforeLink = this.find(index - 1);
        beforeLink.setNext(beforeLink.getNext().getNext());
        size--;
        return true;
    }

    /**
     * 查找元素
     * @param index 元素索引
     * @return 查找结果
     */
    public Link<T> find(int index) {
        if (index >= this.size || index < 0) {
            return null;
        }
        Link<T> find = first;
        for (int i = 0; i < index; i++) {
            find = find.getNext();
        }
        return find;
    }

    /**
     * 插入元素到头部
     * @param value 元素
     */
    public void insertFirst(T value) {
        this.first = new Link<>(value, this.first);
        size ++;
    }

    /**
     * 获取链表长度
     * @return 链表长度
     */
    public int size(){
        return this.size;
    }


    /**
     * 链表是否为空
     *
     * @return 链表是否为空
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    public void displayList() {
        StringBuilder sb = new StringBuilder("AloneLinkList:");
        Link<T> first = this.first;
        if (first == null) {
            sb.append("[]");
        } else {
            sb.append(first.getValue());
            Link<T> next = first.getNext();
            while (next != null) {
                sb.append(",").append(next.getValue());
                next = next.getNext();
            }
        }
        System.out.println(sb.toString());
    }

}
