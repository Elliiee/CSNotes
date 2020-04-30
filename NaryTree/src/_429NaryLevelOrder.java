import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _429NaryLevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> row = new ArrayList<>();
            while (size-- > 0){
                Node node = queue.poll();
                row.add(node.val);
                if (node.children != null){
                    queue.addAll(node.children);
                }
            }
            result.add(row);
        }
        return result;
    }
}
