import java.util.Arrays;
import java.util.Stack;

public class _785IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int start = 0; start < n; start++){
            if (color[start] == -1){
                Stack<Integer> stack = new Stack<>();
                stack.push(start);
                color[start] = 0;

                while (!stack.isEmpty()){
                    Integer node = stack.pop();
                    for(int nei : graph[node]){
                        if (color[nei] == -1){
                            stack.push(nei);
                            color[nei] = color[node] ^ 1;
                        }
                        else if (color[nei] == color[node]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean isBipartiteII(int[][] graph){
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
