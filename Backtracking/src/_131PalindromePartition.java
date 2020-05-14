import java.util.ArrayList;
import java.util.List;

public class _131PalindromePartition {

    public List<List<String>> partition(String s){
        List<List<String>> partitions = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        doPartition(s, partitions, temp);
        return partitions;
    }

    private void doPartition(String s, List<List<String>> partitions, List<String> temp){
        if (s.length() == 0){
            partitions.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < s.length(); i++){
            if (isPalindrome(s, 0, i)){
                temp.add(s.substring(0, i + 1));
                doPartition(s.substring(i + 1), partitions, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int begin, int end){
        while (begin < end){
            if (s.charAt(begin++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
/*
Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.
 */
