package com.geoffrey.datastructure.sort;

import com.geoffrey.datastructure.BaseTest;
import com.geoffrey.datastructure.array.DisorderedArray;
import org.junit.Test;

/**
 * @author Geoffrey.Yip
 * @date 2018/4/26 23:42
 * @since 选择排序测试
 */

public class SelectionSortTest extends BaseTest {
    @Test
    public void testSort() {
        DisorderedArray array = new DisorderedArray(10, SortEnum.SELECTION.getImplement());
        //random array
        super.fillRandomArrayValue(array);
        //sort
        array.sort();
        //show cosole
        array.display();
        //assert sort finish
        super.assertSortFinish(array);
    }
}
