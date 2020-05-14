import java.util.Arrays;

public class _785IsGraphBipartite {
    public boolean isBipartite(int[][] graph){
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int i = 0; i < graph.length; i++){
            if (colors[i] == -1 && !isBipartite(i, 0, colors, graph)){
                return false;
            }
        }
        return true;
    }

    private boolean isBipartite(int curNode, int curColor, int[] colors, int[][] graph){
        if (colors[curNode] != -1){
            return colors[curNode] == curColor;
        }
        colors[curNode] = curColor;
        for (int nextNode : graph[curNode]){
            if (!isBipartite(nextNode, 1 - curColor, colors, graph)){
                return false;
            }
        }
        return true;
    }
}
/*
如果可以用两种颜色对图中的节点进行着色，并且保证相邻的节点颜色不同，那么这个图就是二分图。
 */
