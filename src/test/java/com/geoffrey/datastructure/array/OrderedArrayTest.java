package com.geoffrey.datastructure.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

/**
 * @author Geoffrey.Yip
 * @date 2018/4/23 23:10
 * @since 有序数组测试
 */
public class OrderedArrayTest {

    @Test
    public void testSize() {
        OrderedArray array = new OrderedArray(10);

        //empty array assert
        Assert.assertEquals(array.size(), 0);

        long[] randomArray = this.randomArray(10);
        Arrays.stream(randomArray).forEach(array::insert);

        //not empty array assert
        Assert.assertEquals(array.size(), randomArray.length);
    }

    @Test
    public void testInsert() {
        OrderedArray array = new OrderedArray(10);

        array.insert(1);
        array.insert(3);
        array.insert(2);

        //find '3' index
        Optional<Integer> indexOptional = array.find(3);

        //assert '3' index exists
        Assert.assertTrue(indexOptional.isPresent());
        //assert ordered
        Assert.assertEquals(indexOptional.get(), new Integer(2));
    }


    @Test(expected = IllegalStateException.class)
    public void testInsertWithArrayFull() {
        OrderedArray array = new OrderedArray(3);
        array.insert(1);
        array.insert(3);
        array.insert(2);
        array.insert(4);
    }


    @Test(timeout = 1000)
    public void testDelete() {
        long[] randomArray = randomArray(10);
        OrderedArray array = new OrderedArray(15);
        Arrays.stream(randomArray).forEach(array::insert);

        //assert size equals
        Assert.assertEquals(randomArray.length, array.size());

        //remove first value
        boolean delete = array.delete(randomArray[0]);

        Assert.assertTrue(delete);

        //assert array size decrement
        Assert.assertEquals(array.size(), randomArray.length - 1);
    }

    @Test
    public void test(){
        OrderedArray array = new OrderedArray(15);
        int[] value = new int[]{252, 197, 110, 423, 74, 469, 316, 335, 117, 135};
        Arrays.stream(value).forEach(array::insert);

        array.find(252);
    }


    private long[] randomArray(int size) {
        long[] randomArray = new long[size];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = new Random().nextInt(500);
        }
        System.out.println("Random Array ：" + Arrays.toString(randomArray));
        return randomArray;
    }
}
