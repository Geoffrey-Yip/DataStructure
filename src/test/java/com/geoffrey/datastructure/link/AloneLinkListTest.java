package com.geoffrey.datastructure.link;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * @author Geoffrey.Yip
 * @date 2018/5/6 13:43
 * @since 单链表测试
 */
public class AloneLinkListTest {

    @Test
    public void testInsertFirst() {
        AloneLinkList<Integer> linkList = new AloneLinkList<>();
        for (int i = 0; i < 10; i++) {
            linkList.insertFirst(new Random().nextInt(10));
        }
        linkList.displayList();

        //assert insert successfully.
        Assert.assertEquals(linkList.size(), 10);
        Assert.assertFalse(linkList.isEmpty());
    }

    @Test
    public void testInsert() {
        AloneLinkList<Integer> linkList = new AloneLinkList<>();
        for (int i = 0; i < 10; i++) {
            linkList.insert(i, new Random().nextInt(10));
        }
        linkList.displayList();

        //assert insert successfully.
        Assert.assertEquals(linkList.size(), 10);
        Assert.assertFalse(linkList.isEmpty());
    }

    @Test(expected = IllegalStateException.class)
    public void testInsertFail() {
        AloneLinkList<Integer> linkList = new AloneLinkList<>();
        linkList.insert(0,new Random().nextInt(10));
        linkList.insert(1,new Random().nextInt(10));
        linkList.insert(2,new Random().nextInt(10));

        linkList.displayList();

        //assert insert successfully.
        Assert.assertEquals(linkList.size(), 3);

        //jump index insert
        linkList.insert(4,new Random().nextInt(10));
    }

    @Test
    public void find() {
        AloneLinkList<Integer> linkList = new AloneLinkList<>();
        for (int i = 0; i < 10; i++) {
            linkList.insert(i, new Random().nextInt(10));
        }
        Integer insertValue = new Random().nextInt(100);
        linkList.insert(linkList.size(), insertValue);

        linkList.displayList();

        //assert find
        Assert.assertEquals(insertValue, linkList.find(linkList.size() - 1).getValue());
    }


    @Test
    public void delete(){
        AloneLinkList<Integer> linkList = new AloneLinkList<>();

        //delete empty linklist will be return false
        Assert.assertFalse(linkList.delete(0));

        //init linklist
        for (int i = 0; i < 10; i++) {
            linkList.insert(i, new Random().nextInt(10));
        }

        //do delete
        boolean success = linkList.delete(0);

        //assert delete successfully
        Assert.assertTrue(success);
        Assert.assertEquals(linkList.size(),9);
    }
}
