import java.util.*;

public class _140WordBreakII {
    protected Set<String> wordSet; 
    protected HashMap<String, List<List<String>>> memo; 
    
    public List<String> wordBreak(String s, List<String> wordDict){
        wordSet = new HashSet<>(); 
        for (String word : wordDict){
            wordSet.add(word); 
        }
        memo = new HashMap<>(); 
        
        _wordBreak_topdown(s);

        List<String> ret = new ArrayList<>();
        for (List<String> words : memo.get(s)){
            StringBuffer sentence = new StringBuffer();
            for (String word : words){
                sentence.insert(0, word);
                sentence.insert(0, " ");
            }
            ret.add(sentence.toString().strip());
        }
        return ret;
    }

    protected List<List<String>> _wordBreak_topdown(String s) {
        if (s.equals("")){
            List<List<String>> solutions = new ArrayList<>();
            solutions.add(new ArrayList<>());
            return solutions;
        }

        if (memo.containsKey(s)){
            return memo.get(s);
        }
        else {
            List<List<String>> solutions = new ArrayList<>();
            memo.put(s, solutions);
        }

        for (int endIndex = 1; endIndex <= s.length(); endIndex++){
            String word = s.substring(0, endIndex); // prefix;
            if (wordSet.contains(word)){ // matched prefix in the dictionary
                List<List<String>> subsentences = _wordBreak_topdown(s.substring(endIndex));  // recursion

                for (List<String> subsentence : subsentences){
                    List<String> newSentence = new ArrayList<>(subsentence);
                    newSentence.add(word); // ? so the word is added to the end of the sentence ? don't understand.
                    memo.get(s).add(newSentence);
                }
            }
        }
        return memo.get(s);
    }
}
