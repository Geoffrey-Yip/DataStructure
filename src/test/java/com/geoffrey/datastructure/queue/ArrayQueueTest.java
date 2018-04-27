package com.geoffrey.datastructure.queue;

import com.geoffrey.datastructure.BaseTest;
import com.geoffrey.datastructure.queue.impl.ArrayQueue;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Geoffrey.Yip
 * @date 2018/4/28 0:14
 * @since 数组实现的队列测试
 */
public class ArrayQueueTest extends BaseTest {

    private static final Integer QUEUE_SIZE = 10;

    @Test
    public void testInsertAndRemove() {
        //init
        Queue<Long> queue = new ArrayQueue(QUEUE_SIZE);
        long[] randomArray = super.randomArray(QUEUE_SIZE);
        Arrays.stream(randomArray).forEach(queue::insert);
        ((ArrayQueue) queue).display();

        //assert insert successfully
        Assert.assertEquals(((ArrayQueue) queue).size(),QUEUE_SIZE);

        //剩下一个
        for (int i = 0; i < randomArray.length - 1; i++) {
            Assert.assertEquals(Long.valueOf(randomArray[i]),queue.remove());
        }
        ((ArrayQueue) queue).display();

        //再插入一个值，判断这个值是不是跑到数组头部去了
        queue.insert(9999L);
        ((ArrayQueue) queue).display();
        //移除两次就能拿到刚才插入的值
        queue.remove();
        Assert.assertEquals(queue.remove().longValue(),9999L);
    }

    @Test
    public void testPeek() {
        Queue<Long> queue = new ArrayQueue(QUEUE_SIZE);
        long[] randomArray = super.randomArray(QUEUE_SIZE);
        //insert
        Arrays.stream(randomArray).forEach(queue::insert);

        //assert peek queue top is unchance.
        Assert.assertEquals(queue.peek(), Long.valueOf(randomArray[0]));
        Assert.assertEquals(queue.peek(), Long.valueOf(randomArray[0]));
    }

    @Test(expected = IllegalStateException.class)
    public void testInsertFail(){
        Queue<Long> queue = new ArrayQueue(QUEUE_SIZE);
        //push to full
        Arrays.stream(super.randomArray(QUEUE_SIZE)).forEach(queue::insert);
        //queue is full
        queue.insert(1L);
    }

    @Test(expected = IllegalStateException.class)
    public void testPopFail() {
        //Empty queue do pop will be fail
        new ArrayQueue(QUEUE_SIZE).remove();
    }

    @Test(expected = IllegalStateException.class)
    public void testPeekFail() {
        //Empty queue do peek will be fail
        new ArrayQueue(QUEUE_SIZE).peek();
    }
}
