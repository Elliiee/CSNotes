import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        wordList.add(beginWord);
        int N = wordList.size();
        int start = N - 1;
        int end = 0;
        while (end < N && !wordList.get(end).equals(endWord))
            end++;
        if (end == N)
            return 0;
        List<Integer>[] graphic = buildGraph(wordList);
        return getShortestPath(graphic, start, end);
    }


    private boolean isConnect(String s1, String s2){
        int diffCnt = 0;
        for (int i = 0; i < s1.length() && diffCnt <= 1; i++){
            if (s1.charAt(i) != s2.charAt(i))
                diffCnt++;
        }
        return diffCnt == 1;
    }

    private List<Integer>[] buildGraph(List<String> wordList){
        int N = wordList.size();
        List<Integer>[] graph = new List[N];
        for (int i = 0; i < N; i++){
            graph[i] = new ArrayList<>();
            for (int j = 0; j < N; j++){
                if (isConnect(wordList.get(i), wordList.get(j)))
                    graph[i].add(j);
            }
        }
        return graph;
    }

    private int getShortestPath(List<Integer>[] graph, int start, int end){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[graph.length];
        queue.add(start);
        marked[start] = true;
        int path = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            path++;
            while (size-- > 0){
                int cur = queue.poll();
                for (int next : graph[cur]){
                    if (next == end)
                        return path;
                    if (marked[next])
                        continue;
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return 0;
    }
}
