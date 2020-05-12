public class _677MapSumPairs {
    private class Node{
        Node[] children = new Node[26];
        int value;
    }

    private Node root = new Node();

    public _677MapSumPairs(){

    }

    private int indexForChar(char c){
        return c - 'a';
    }

    public void insert(String key, int val){
        insert(key, root, val);
    }

    public void insert(String key, Node node, int val){
        if (node == null)
            return;
        if (key.length() == 0){
            node.value = val;
            return;
        }
        int index = indexForChar(key.charAt(0));
        if (node.children[index] == null){
            node.children[index] = new Node();
        }
        insert(key.substring(1), node.children[index], val);
    }

    public int sum(String prefix){
        return sum(prefix, root);
    }

    private int sum(String prefix, Node node){
        if (node == null)
            return 0;
        if (prefix.length() != 0){
            int index = indexForChar(prefix.charAt(0));
            return sum(prefix.substring(1), node.children[index]);
        }
        int sum = node.value;
        for (Node n : node.children){
            sum += sum(prefix, n);
        }
        return sum;
    }
}
