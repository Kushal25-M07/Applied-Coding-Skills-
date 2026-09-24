import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int level, List<Integer> result) {
        if (node == null) {
            return;
        }

        // If this is the first time we visit this level, add the node's value
        if (level == result.size()) {
            result.add(node.val);
        }

        // Prioritize right branch first
        dfs(node.right, level + 1, result);
        dfs(node.left, level + 1, result);
    }
}
