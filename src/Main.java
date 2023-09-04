import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>(); // List of Lists created
        if (root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();// will store nodes
        queue.add(root);
        int level = 0; // start level

        while ( !queue.isEmpty() ) { // if queue isn't empty, means need to create a new sublist in 'levels' to hold node
            levels.add(new ArrayList<Integer>());

            int level_length = queue.size(); // storage variable for queue size before any child nodes added. since
            // FIFO, we only remove and check nodes of that level
            for(int i = 0; i < level_length; ++i) {
                TreeNode node = queue.remove();
                levels.get(level).add(node.val); // add its value to subList at index 'level'
                if (node.left != null) queue.add(node.left); // add children
                if (node.right != null) queue.add(node.right);
            }
            level++;
        }
        return levels;
    }
}