package lecture.section4_hashMap_treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Find_all_anagrams {
    public int solution(String target, String str){
        HashMap<Character, Integer> tarMap = new HashMap<>(); // 대조군
        HashMap<Character, Integer> varMap = new HashMap<>(); // 실험군
        char[] arr = str.toCharArray();
        boolean flag;
        int i, cnt = 0, start = 0, end;

        for(char c : target.toCharArray()){
            tarMap.put(c, tarMap.getOrDefault(c, 0)+1);
        }
        for(i = 0; i < target.length()-1; i++){
            varMap.put(arr[i], varMap.getOrDefault(arr[i], 0)+1);
        }

        while(start + target.length() <= str.length()){
            flag = true;
            end = start + target.length() - 1;
            varMap.put(arr[end], varMap.getOrDefault(arr[end], 0)+1);

            for(char c : tarMap.keySet()){
//                System.out.print("key : " + c);
//                System.out.print(", var : " + varMap.get(c));
//                System.out.println(", tar : " + tarMap.get(c));
                if(!varMap.containsKey(c) || (varMap.get(c) != tarMap.get(c))) flag = false;
            }

            varMap.put(arr[start], varMap.get(arr[start]) - 1);
            if(varMap.get(arr[start]) == 0) varMap.remove(arr[start]);
            start++;
            if(flag) cnt++;

        }

        return cnt;
    }
    public static void main(String[] args) throws IOException {
        Find_all_anagrams f = new Find_all_anagrams();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String target = br.readLine();

        System.out.println(f.solution(target, str));
    }
}
