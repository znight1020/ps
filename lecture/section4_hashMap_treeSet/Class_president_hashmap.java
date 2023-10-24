package lecture.section4_hashMap_treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Class_president_hashmap {
    public char solution(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        char president = ' ';
        for(char c : str.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(char c : map.keySet()){
            if(map.get(c) > max) {
                max = map.get(c);
                president = c;
            }
        }
        return president;
    }
    public static void main(String[] args) throws IOException {
        Class_president_hashmap c = new Class_president_hashmap();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();

        System.out.println(c.solution(str));
    }
}
