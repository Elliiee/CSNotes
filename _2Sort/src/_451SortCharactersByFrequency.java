import java.util.*;

public class _451SortCharactersByFrequency {
    // 1. Array and sort
    public String frequencySort(String s){
        if (s == null || s.isEmpty())
            return s;

        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        List<String> charStrings = new ArrayList<>();
        StringBuilder currentString = new StringBuilder();
        currentString.append(chars[0]);
        for (int i = 1; i < chars.length; i++){
            if (chars[i] != chars[i-1]){
                charStrings.add(currentString.toString());
                currentString = new StringBuilder();
            }
            currentString.append(chars[i]);
        }
        charStrings.add(currentString.toString());

        Collections.sort(charStrings, (a, b) -> b.length() - a.length());

        StringBuilder sb = new StringBuilder();
        for (String str : charStrings)
            sb.append(str);

        return sb.toString();
    }

    // 2. Hash Map O(nlogn) O(n)
    public String frequencySortII(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray())
            counts.put(c, counts.getOrDefault(c, 0) + 1);

        List<Character> characters = new ArrayList<>(counts.keySet());
        Collections.sort(characters, (a, b) -> counts.get(b) - counts.get(a));

        StringBuilder sb = new StringBuilder();
        for (char c : characters){
            int copies = counts.get(c);
            for (int i = 0; i < copies; i++)
                sb.append(c);
        }

        return sb.toString();
    }

    // 3. Bucket Sort, O(n), O(n)
    public String frequencySortIII(String s) {
        if (s == null || s.isEmpty()) return s;

        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray())
            counts.put(c, counts.getOrDefault(c, 0) + 1);

        int maximumFrequency = Collections.max(counts.values());

        List<List<Character>> buckets = new ArrayList<>();
        for (int i = 0; i <= maximumFrequency; i++)
            buckets.add(new ArrayList<Character>());
        for (Character key : counts.keySet()){
            int freq = counts.get(key);
            buckets.get(freq).add(key);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = buckets.size() - 1; i >= 1; i--) {
            for (Character c : buckets.get(i)) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }

    // 4. PriorityQueue
    public String frequencySortIV(String s) {
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        Map<Character, Integer> frequency = new HashMap<>();
        for (Character c : s.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        maxHeap.addAll(frequency.entrySet());
        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() > 0) {
            Map.Entry<Character, Integer> entry = maxHeap.remove();
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}
