package lab3;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BackPackTestForMujava {

    private BackPack solution;

    @Before
    public void setUp() {
        solution = new BackPack();
    }

    // 1.物品数组为空
    @Test
    public void testCase1() {
        assertEquals(0, solution.backPack(new int[]{}, new int[]{}, 10));
    }

    // 2.背包容量为空
    @Test
    public void testCase2() {
        assertEquals(0, solution.backPack(new int[]{1,2,3}, new int[]{1,2,3}, 0));
    }

    // 3.物品数组和背包容量都为空
    @Test
    public void testCase3() {
        assertEquals(0, solution.backPack(new int[]{}, new int[]{}, 0));
    }

    // 4.物品数量为1 且背包容量不够装下该物品
    @Test
    public void testCase4() {
        assertEquals(0, solution.backPack(new int[]{4}, new int[]{4}, 1));
    }

    // 5.物品数量为1 且背包容量正好够装下该物品
    @Test
    public void testCase5() {
        assertEquals(4, solution.backPack(new int[]{4}, new int[]{4}, 4));
    }

    // 6.物品数量为1 且背包容量足够装下该物品
    @Test
    public void testCase6() {
        assertEquals(4, solution.backPack(new int[]{4}, new int[]{4}, 5));
    }

    // 7.背包容量不够装下任一物品
    @Test
    public void testCase7() {
        assertEquals(0, solution.backPack(new int[]{4,8,10}, new int[]{1,1,1}, 2));
    }

    // 8.多个物品 背包容量足够装下全部物品
    @Test
    public void testCase8() {
        assertEquals(60, solution.backPack(new int[]{1,2,5}, new int[]{5,50,5}, 10));
    }

    // 9.多个物品 背包容量正好够装下全部物品
    @Test
    public void testCase9() {
        assertEquals(20, solution.backPack(new int[]{1,5,9}, new int[]{7,5,8}, 15));
    }

    // 10.多个物品 背包容量不够装下全部物品
    @Test
    public void testCase10() {
        assertEquals(8, solution.backPack(new int[]{10,2,7}, new int[]{5,7,8}, 8));
    }

    // 11.背包容量够装下唯一物品
    @Test
    public void testCase11() {
        assertEquals(6, solution.backPack(new int[]{10,2,1}, new int[]{40,50,6}, 1));
    }

    // 12.所有物品重量相同 价值不同
    @Test
    public void testCase12() {
        assertEquals(7, solution.backPack(new int[]{2,2,2,2}, new int[]{1,2,3,4}, 4));
    }

    // 13.所有物品重量不同 价值相同
    @Test
    public void testCase13() {
        assertEquals(2, solution.backPack(new int[]{5,4,9,10}, new int[]{1,1,1,1}, 10));
    }

    // 14.物品重量含有0
    @Test
    public void testCase14() {
        assertEquals(16, solution.backPack(new int[]{0,2,5}, new int[]{10,5,1}, 8));
    }

    // 15.物品价值含有0
    @Test
    public void testCase15() {
        assertEquals(15, solution.backPack(new int[]{1,2,5}, new int[]{10,5,0}, 8));
    }

    //  16.含有极大值
    @Test
    public void testCase16() {
        assertEquals(2147483647, solution.backPack(new int[]{1, 2, 3}, new int[]{2147483644, 1, 2}, 10));
    }

    // 17.相同总价值但不同组合的物品
    @Test
    public void testCase17() {
        assertEquals(10, solution.backPack(new int[]{1, 2, 5, 7}, new int[]{1, 5, 5, 10}, 7));
    }
}
