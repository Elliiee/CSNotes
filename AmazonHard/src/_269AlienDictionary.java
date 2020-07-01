import java.util.*;

public class _269AlienDictionary {
    public String alienOrder(String[] words){
        // step 0 create data structure and find all unique letters
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();
        for (String word : words){
            for (char c : word.toCharArray()){
                counts.put(c, 0); // initially, all counts are 0
                adjList.put(c, new ArrayList<>());
            }
        }

        // step 1 find all edges
        for (int i = 0; i < words.length - 1; i++){
            String word1 = words[i];
            String word2 = words[i + 1]; // so the upper bound is less than length - 1 not equal.
            // check that word2 is not a prefix of word1
            if (word1.length() > word2.length() && word1.startsWith(word2)){ // edge case
                return ""; // return empty String because it's not able to tell the alien order
            }
            // find the first non match and insert the corresponding relation
            for (int j = 0 ; j < Math.min(word1.length(), word2.length()); j++){
                if (word1.charAt(j) != word2.charAt(j)){
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1); // mark the incoming count
                    break; // no need to continue search, only need the first different character
                }
            }
        }

        // Step 2 BFS
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (Character c : counts.keySet()){
            if (counts.get(c).equals(0)){
                queue.add(c); // only add the no incoming count node
            }
        }
        while (!queue.isEmpty()){
            Character c = queue.remove();
            sb.append(c);
            for (Character next : adjList.get(c)){
                counts.put(next, counts.get(next) - 1); // decrease the incoming count for the already processed node
                if (counts.get(next).equals(0)){
                    queue.add(next);
                }
            }
        }

        /*
        we check whether or not all letters were put in the output list.
        if some are missing, this is because we got to a point where all remaining letters had at least
        one edge coming in, which means there must be a cycle! So there won't be any ordering.
         */
        if (sb.length() < counts.size()){ // StringBuilder is using .length() not size() because it's not a String
            return "";
        }
        return sb.toString();
    }


    /*
    Approach 2 DFS
    This time we don't need the incoming count map.
        In a DFS search, nodes are returned once they either have no outgoing links left, or all their outgoing links
        have been visited. Therefore, the order in which nodes are returned by the DFS will be the reverse of a valid
        alphabet order.
        Algorithm:
        So, if we make a reverse adjacency list, after DFS the output order will be correct.
        One issue we need to be careful with is the cycles.
        In directed graph, we often detect cycles by using graph coloring.
        All nodes are while initially, and then become grey once they are visited.
        Once all their outgoing nodes have been fully visited, they become black.
        We know there is a cycle if we enter a node that is currently grey (which should be while).
        Nodes are changed to blank when they are removed from the stack.
     */
    private Map<Character, List<Character>> reverseAdjList = new HashMap<>();
    private Map<Character, Boolean> seen = new HashMap<>();
    private StringBuilder output = new StringBuilder();

    public String alienOrderII(String[] words){
        // step 0 put all unique letters into reverseAdjList as keys;
        for (String word : words){
            for (char c : word.toCharArray()){
                reverseAdjList.putIfAbsent(c, new ArrayList<>()); // new method learned
            }
        }

        // step 1 find all edges and add reverse edges to reverseAdjList;
        for (int i = 0; i < words.length - 1; i++){
            String word1 = words[i];
            String word2 = words[i + 1];
            // check that word2 is not a prefix of word1
            if (word1.length() < word2.length() && word1.startsWith(word2)){
                return ""; // edge case
            }
            // find the first non match and insert the corresponding relation
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++){
                if (word1.charAt(j) != word2.charAt(j)){
                    reverseAdjList.get(word2.charAt(j)).add(word1.charAt(j)); // remember the reverse way
                    break; // no need going further, only need the first unique character
                }
            }
        }

        // step 2 : DFS to build up the output list
        for (Character c : reverseAdjList.keySet()){
            boolean result = dfs(c);
            if (!result)
                return "";
        }

        if (output.length() < reverseAdjList.size()){
            return ""; // there is a cycle.
        }
        return output.toString();
    }

    // return true if no cycles detected
    private boolean dfs(Character c){
        if (seen.containsKey(c)){
            return seen.get(c); // if this node is grey, a cycle has been detected.
        }
        seen.put(c, false);
        for (Character next : reverseAdjList.get(c)){
            boolean result = dfs(next);
            if (!result)
                return false;
        }
        seen.put(c, true);
        output.append(c);
        return true;
    }
}
