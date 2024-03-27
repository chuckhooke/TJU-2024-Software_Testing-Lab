package lab1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

public class BinaryTree<T> {
    public TreeNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(T[] nodes) {
        GenerateTree(nodes);
    }


    public void GenerateTree(T[] nodes) {
        if (nodes.length == 0 || nodes[0] == null) {
            this.root = null;
            return;
        }

        this.root = new TreeNode<>(nodes[0]);
        Deque<TreeNode<T>> queue = new ArrayDeque<>();
        queue.offer(this.root);

        int i = 1;
        while (i < nodes.length && !queue.isEmpty()) {
            TreeNode<T> current = queue.poll();

            if (i < nodes.length && nodes[i] != null) {
                current.left = new TreeNode<>(nodes[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < nodes.length && nodes[i] != null) {
                current.right = new TreeNode<>(nodes[i]);
                queue.offer(current.right);
            }
            i++;
        }
    }

    // show the tree in level order
    public void printLevelOrder() {
        if (this.root == null) {
            System.out.println("The tree is empty");
            return;
        }

        Deque<Optional<TreeNode<T>>> queue = new ArrayDeque<>();
        queue.offer(Optional.of(this.root));

        int height = treeHeight(this.root);
        int level = 0;

        while (!queue.isEmpty() && level < height) {
            int levelLength = queue.size(); // 当前层的节点数量

            for (int i = 0; i < levelLength; i++) {
                Optional<TreeNode<T>> currentOptional = queue.poll();
                if (!currentOptional.isPresent()) {
                    System.out.print("null ");
                    queue.offer(Optional.empty());
                    queue.offer(Optional.empty());
                } else {
                    TreeNode<T> current = currentOptional.get();
                    System.out.print(current.val + " ");
                    queue.offer(Optional.ofNullable(current.left));
                    queue.offer(Optional.ofNullable(current.right));
                }
            }
            System.out.println();
            level++;
        }
    }

    private int treeHeight(TreeNode<T> root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(treeHeight(root.left), treeHeight(root.right));
    }
}
