import java.util.HashMap;

public class _91DecodeWays {
    HashMap<Integer, Integer> memo = new HashMap<>();

    private int recursiveMemo(int index, String str){
        // If you reach the end of the string, return 1 for success.
        if (index == str.length())
            return 1;

        // If the string starts with a zero, it can't be decoded.
        if (str.charAt(index) == '0')
            return 0;

        // What is this for ?
        if (index == str.length() - 1)
            return 1;

        if (memo.containsKey(index))
            return memo.get(index); // memoization to avoid process the same sub-string

        int ans = recursiveMemo(index + 1, str); // recursion for 1 digits

        if (Integer.parseInt(str.substring(index, index + 2)) <= 26)
            ans += recursiveMemo(index + 2, str); // recursion for 2 digits

        memo.put(index, ans);

        return ans;
    }

    public int numDecodingsI(String s) {
        if (s == null || s.length() == 0)
            return 0;

        return recursiveMemo(0, s);
    }
}
