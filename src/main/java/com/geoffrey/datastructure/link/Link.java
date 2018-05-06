package com.geoffrey.datastructure.link;

/**
 * @author Geoffrey.Yip
 * @date 2018/5/6 13:05
 * @since 链表节点
 */
public class Link<T> {

    /**节点元素**/
    private T value;
    /**下一个节点**/
    private Link<T> next;

    public Link(T value, Link<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Link<T> getNext() {
        return next;
    }

    public void setNext(Link<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"value\":")
                .append(value);
        sb.append(",\"next\":")
                .append(next);
        sb.append('}');
        return sb.toString();
    }
}
