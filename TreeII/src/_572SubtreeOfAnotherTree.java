public class _572SubtreeOfAnotherTree {
    public boolean isSubTree(TreeNode s, TreeNode t){
        if (s == null) return false;

        return isSubtreeWithRoot(s, t) || isSubTree(s.left, t) || isSubTree(s.right, t);
    }

    private boolean isSubtreeWithRoot(TreeNode s, TreeNode t){
        if (t == null && s == null) return true;
        if (t == null || s == null) return false;
        if (t.val != s.val) return false;

        return isSubTree(s.left, t.left) && isSubtreeWithRoot(s.right, t.right);
    }
}
/*
check if tree t is the subtree of tree s.
 */
