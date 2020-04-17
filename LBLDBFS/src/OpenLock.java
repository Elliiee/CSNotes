import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenLock {
    String plusOne(String s, int j){
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }

    String minusOne(String s, int j){
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }

    int openLock(String[] deadends, String target){
        Set<String> des = new HashSet<>();
        for (String s : des)
            des.add(s);

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int step = 0;
        queue.offer("0000");
        visited.add("0000");
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                String cur = queue.poll();

                if (des.contains(cur))
                    continue;
                if (cur.equals(target))
                    return step;

                for (int j = 0; j < 4; j++){
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)){
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)){
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
