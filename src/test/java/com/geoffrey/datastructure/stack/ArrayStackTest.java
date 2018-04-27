package com.geoffrey.datastructure.stack;

import com.geoffrey.datastructure.BaseTest;
import com.geoffrey.datastructure.stack.impl.ArrayStack;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Geoffrey.Yip
 * @date 2018/4/27 23:17
 * @since 数组实现的栈单元测试
 */
public class ArrayStackTest extends BaseTest {

    private static final int STACK_SIZE = 10;


    @Test
    public void testPushAndPop() {
        Stack<Long> stack = new ArrayStack(STACK_SIZE);
        long[] randomArray = super.randomArray(STACK_SIZE);
        //push
        Arrays.stream(randomArray).forEach(stack::push);
        //display
        System.out.println(stack.toString());
        //assert push successfully
        Assert.assertEquals(stack.size(), STACK_SIZE);

        //断言后进先出
        for (int out = STACK_SIZE - 1; out >= 0; out--) {
            Assert.assertEquals(new Long(randomArray[out]),stack.pop());
        }
    }

    @Test
    public void testPeek() {
        Stack<Long> stack = new ArrayStack(STACK_SIZE);
        long[] randomArray = super.randomArray(STACK_SIZE);
        //push
        Arrays.stream(randomArray).forEach(stack::push);

        //assert peek stack top is unchance.
        Assert.assertEquals(stack.peek(), Long.valueOf(randomArray[STACK_SIZE - 1]));
        Assert.assertEquals(stack.peek(), Long.valueOf(randomArray[STACK_SIZE - 1]));
    }

    @Test(expected = IllegalStateException.class)
    public void testPushFail(){
        Stack<Long> stack = new ArrayStack(STACK_SIZE);
        //push to full
        Arrays.stream(super.randomArray(STACK_SIZE)).forEach(stack::push);
        //stack is full
        stack.push(1L);
    }

    @Test(expected = IllegalStateException.class)
    public void testPopFail() {
        //Empty stack do pop will be fail
        new ArrayStack(STACK_SIZE).pop();
    }

    @Test(expected = IllegalStateException.class)
    public void testPeekFail() {
        //Empty stack do peek will be fail
        new ArrayStack(STACK_SIZE).peek();
    }

}
