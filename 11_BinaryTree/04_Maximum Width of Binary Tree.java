/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair<K, V> {
         K key;
         V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
         if (root == null) {
            return 0;
        }

        int maxWidth = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int firstIndex = queue.peek().getValue();
            int lastIndex = firstIndex;

            for (int i = 0; i < levelSize; i++) {
                Pair<TreeNode, Integer> current = queue.poll();
                TreeNode node = current.getKey();
                lastIndex = current.getValue(); 

                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, 2 * lastIndex));
                }
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, 2 * lastIndex + 1));
                }
            }

            int currentWidth = lastIndex - firstIndex + 1;
            maxWidth = Math.max(maxWidth, currentWidth);
        }

        return maxWidth;
    }
}
