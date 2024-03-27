package lab1.solution;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PathSumSolutionTest {

    private PathSumSolution solution;

    @Test
    public void testPathSum_Case1() {

        Integer[] nodes = {8, 5, 7, null, 6, null, null};
        int targetSum = 19;

        solution = new PathSumSolution();

        List<List<Integer>> result = solution.pathSum(nodes, targetSum);

        assertEquals(1, result.size());
        assertArrayEquals(new Integer[]{8, 5, 6}, result.get(0).toArray());
    }


    @Test
    public void testPathSum_Case2() {

        Integer[] nodes = {1, 3, 5, 7, 9, null, 7, 11, 12, null, null, null, null};
        int targetSum = 13;

        solution = new PathSumSolution();

        List<List<Integer>> result = solution.pathSum(nodes, targetSum);

        assertEquals(2, result.size());
        assertArrayEquals(new Integer[]{1, 3, 9}, result.get(0).toArray());
        assertArrayEquals(new Integer[]{1, 5, 7}, result.get(1).toArray());
    }


    @Test
    public void testPathSum_Case3() {

        Integer[] nodes = {1, 3, 5 , 7, 9, null, 7, 11, 12, null, null, null, null};
        int targetSum = 130;

        solution = new PathSumSolution();

        List<List<Integer>> result = solution.pathSum(nodes, targetSum);

        assertEquals(0, result.size());
        assertTrue(result.isEmpty());
    }



}