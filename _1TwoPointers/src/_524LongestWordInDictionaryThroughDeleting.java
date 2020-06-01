import java.util.List;

public class _524LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String target : d){
            int l1 = longestWord.length(), l2 = target.length();

            // if it's not the longest or not the smallest lexicographical one, continue to another new loop.
            if (l1 > l2 || l1 == l2 && longestWord.compareTo(target) < 0)
                continue; // jump out of this loop continue with the next loop;

            if (isSubstr(s, target))
                longestWord = target;
        }
        return longestWord;
    }

    private boolean isSubstr(String s, String t){
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()){
            if (s.charAt(i) == t.charAt(j))
                j++;
            i++;
        }

        return j == t.length(); // j has been increased extra 1 by ++ sight, so it should equal to the length.
    }
}
