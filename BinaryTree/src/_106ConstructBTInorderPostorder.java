import java.util.HashMap;

public class _106ConstructBTInorderPostorder {
    int postLastIndex;
    int[] postorder;
    int[] inorder;
    HashMap<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode helper(int inLeft, int inRight){
        if (inLeft > inRight)
            return null;

        int rootVal = postorder[postLastIndex];
        TreeNode root = new TreeNode(rootVal);

        int inorderIndex = indexMap.get(rootVal);

        postLastIndex--;
        root.right = helper(inorderIndex + 1, inRight);
        root.left = helper(inLeft, inorderIndex - 1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder){
        this.inorder = inorder;
        this.postorder = postorder;

        postLastIndex = postorder.length - 1;

        int index = 0;
        for (Integer val : inorder){
            indexMap.put(val, index++);
        }

        return helper(0, inorder.length - 1);
    }
}
