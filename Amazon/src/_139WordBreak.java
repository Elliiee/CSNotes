import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139WordBreak {
    // Approach 1 Brute Force
    // Recursion and Backtracking
    public boolean wordBreak(String s, List<String> wordDict){
        return word_Break(s, new HashSet<>(wordDict), 0);
    }
    public boolean word_Break(String s, Set<String> wordDict, int start){
        if (start == s.length())
            return true;

        for (int end = start + 1; end <= s.length(); end++){
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end))
                return true;
        }

        return false;
    }


    // Approach 2 Recursion with Memoization
    public boolean wordBreakII(String s, List<String> wordDict){
        return word_BreakII(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    public boolean word_BreakII(String s, Set<String> wordDict, int start, Boolean[] memo){ // use caption Boolean
        if (start == s.length())
            return true;

        if (memo[start] != null) // use caption Boolean so it can use "null"
            return memo[start];

        for (int end = start + 1; end <= s.length(); end++){
            if (wordDict.contains(s.substring(start, end)) && word_BreakII(s, wordDict, end, memo)){
                memo[start] = true;
                return memo[start];
            }
                //return memo[start] = true; // confusing, sets the value and also return the value
        }

        //return memo[start] = false;
        memo[start] = false;
        return memo[start];
    }
}
