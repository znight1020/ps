package lecture.section4_hashMap_treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Anagram_hashmap {

    public String solution(String str1, String str2){
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        boolean flag = true;

        for(char c : str1.toCharArray()){
            map1.put(c, map1.getOrDefault(c, 0)+1);
        }
        for(char c : str2.toCharArray()){
            map2.put(c, map2.getOrDefault(c, 0)+1);
        }

        for(char key : map1.keySet()){
            if(!map2.containsKey(key) || (map2.get(key) != map1.get(key)) ) {
                //System.out.print("map1.getValue : " + map1.get(key));
                //System.out.println(", map2.getValue : " + map2.get(key));
                flag = false;
            }
        }
        if(flag == false) return "NO";
        else return "YES";
    }
    public static void main(String[] args) throws IOException {
        Anagram_hashmap a = new Anagram_hashmap();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        System.out.println(a.solution(str1, str2));
    }

}
