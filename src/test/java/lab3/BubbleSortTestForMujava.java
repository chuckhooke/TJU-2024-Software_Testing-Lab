package lab3;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BubbleSortTestForMujava {

    private BubbleSort solution;

    @Before
    public void setUp() {
        solution = new BubbleSort();
    }

    // 1.空数组
    @Test
    public void testCase1() {
        assertArrayEquals(new int[]{}, solution.bubbleSort(new int[]{}));
    }

    // 2.长度为1的数组
    @Test
    public void testCase2() {
        assertArrayEquals(new int[]{1}, solution.bubbleSort(new int[]{1}));
    }

    // 3.已排序的数组1
    @Test
    public void testCase3() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, solution.bubbleSort(new int[]{1, 2, 3, 4, 5}));
    }

    // 4.已排序的数组2
    @Test
    public void testCase4() {
        assertArrayEquals(new int[]{4, 8, 15, 68}, solution.bubbleSort(new int[]{4, 8, 15, 68}));
    }

    // 5.有重复元素的数组
    @Test
    public void testCase5() {
        assertArrayEquals(new int[]{1, 1, 1, 7, 10}, solution.bubbleSort(new int[]{7, 10, 1, 1, 1}));
    }

    // 6.含0的数组
    @Test
    public void testCase6() {
        assertArrayEquals(new int[]{0, 8, 10}, solution.bubbleSort(new int[]{0, 10, 8}));
    }

    // 7.纯负数的数组
    @Test
    public void testCase7() {
        assertArrayEquals(new int[]{-110, -10, -9, -1}, solution.bubbleSort(new int[]{-1, -9, -110, -10}));
    }

    // 8.有正数和负数的数组
    @Test
    public void testCase8() {
        assertArrayEquals(new int[]{-9, -8, 1, 50}, solution.bubbleSort(new int[]{-8, 1, 50, -9}));
    }

    // 9.有正数和负数和0的数组
    @Test
    public void testCase9() {
        assertArrayEquals(new int[]{-40, -9, 0, 1, 50}, solution.bubbleSort(new int[]{0, 1, -9, 50, -40}));
    }

    // 10.逆序数组1
    @Test
    public void testCase10() {
        assertArrayEquals(new int[]{1, 55, 70, 80, 90}, solution.bubbleSort(new int[]{90, 80, 70, 55, 1}));
    }

    // 11.逆序数组2
    @Test
    public void testCase11() {
        assertArrayEquals(new int[]{-99, -8, 1, 4, 5}, solution.bubbleSort(new int[]{5, 4, 1, -8, -99}));
    }

    // 12.乱序数组1
    @Test
    public void testCase12() {
        assertArrayEquals(new int[]{-99, -89, 5, 40, 100}, solution.bubbleSort(new int[]{5, 40, 100, -89, -99}));
    }

    // 13.乱序数组2
    @Test
    public void testCase13() {
        assertArrayEquals(new int[]{-90, 0, 4, 58, 66, 690}, solution.bubbleSort(new int[]{-90, 4, 66, 690, 58, 0}));
    }

    // 14.含有极大值的数组
    @Test
    public void testCase14() {
        assertArrayEquals(new int[]{1, 2, 3, 2147483647}, solution.bubbleSort(new int[]{1, 2, 2147483647, 3}));
    }

    // 15.含有极小值的数组
    @Test
    public void testCase15() {
        assertArrayEquals(new int[]{-2147483648, 1, 2, 3}, solution.bubbleSort(new int[]{1, -2147483648, 2, 3}));
    }

}