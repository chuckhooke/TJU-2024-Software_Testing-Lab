package lab1;

import lab1.solution.PathSumSolution;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Integer[] nodes = {5,4,8,12,null,13,4,7,2,null,null,5,1};
        Integer[] nodes = {1, 3, 5, 7, 9, null, 7, 11, 12, null, null, null, null};
        BinaryTree<Integer> tree = new BinaryTree<>(nodes);

        tree.printLevelOrder();

        PathSumSolution solution = new PathSumSolution();
        List<List<Integer>> results = solution.pathSum(nodes, 13);
        System.out.println(results);
    }

}