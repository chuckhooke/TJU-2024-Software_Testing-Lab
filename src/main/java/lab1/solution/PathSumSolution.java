package lab1.solution;

import lab1.BinaryTree;
import lab1.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumSolution implements Solution {

    // 所有目标路径的叶子节点
    private  static List<TreeNode<Integer>> targetNodes = new ArrayList<>();
    // 当前考虑的目标路径
    private  static List<TreeNode<Integer>> targetPath = new ArrayList<>();
    // 用于剪枝的flag 当找到目标节点后 就直接跳过后续搜索
    private static boolean found = false;

    @Override
    public List<List<Integer>> pathSum(Integer[] nodes, int targetSum) {

        initialize();

        List<List<Integer>> setOfTargetPath = new ArrayList<>();
        BinaryTree<Integer> tree = new BinaryTree<>(nodes);

        pathSum(tree.root, targetSum, 0);

        for (TreeNode<Integer> treeNode : targetNodes) {
            tarcePath(tree.root, treeNode, new ArrayList<>());
            List<Integer> resultOfListInteger = changeListType(targetPath);
            setOfTargetPath.add(resultOfListInteger);
            found = false;
        }

        return setOfTargetPath;
    }

    public static void pathSum(TreeNode<Integer> node, int targetSum, int currentSum) {

        if (node == null) {
            return;
        }
        currentSum += node.val;
        if (currentSum == targetSum && node.left == null && node.right == null) {targetNodes.add(node);}
        pathSum(node.left, targetSum, currentSum);
        pathSum(node.right, targetSum, currentSum);
    }

    public static void tarcePath(TreeNode<Integer> node, TreeNode<Integer> targetNode, List<TreeNode<Integer>> result) {

        if (node == null || found) {
            return;
        }
        else{
            result.add(node);
        }
        if (node.equals(targetNode)){
            found = true;
            // 只有把实例赋给targetPath 而不是引用，targetPath才会随result的改变而改变
            targetPath = new ArrayList<>(result);
            return;
        }
        tarcePath(node.left, targetNode, result);
        tarcePath(node.right, targetNode, result);
        result.remove(node);

    }

    public static List<Integer> changeListType(List<TreeNode<Integer>> source){
        List<Integer> result = new ArrayList<>();
        for (TreeNode<Integer> node : source){
            result.add(node.val);
        }
        return result;
    }

    public void initialize (){
        targetNodes.clear();
        targetPath.clear();
        found = false;
    }
}
