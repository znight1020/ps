package solved.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CreatingPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;

        String str = br.readLine();
        char[] nameArr = str.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < nameArr.length; i++){
            map.put(nameArr[i], map.getOrDefault(nameArr[i], 0) + 1);
        }

        List<Character> list = new ArrayList<>(map.keySet());
        list.sort(Character::compareTo);

        Queue<Character> q = new LinkedList<>();
        Stack<Character> s = new Stack<>();

        for(char c : map.keySet()){
            if(map.get(c) % 2 == 1) flag = false;
        } // 짝수 길이인데 같은 문자가 짝수개가 아니면 팰린드롬 만들 수 없음

        // A A B B
        // str의 길이 == 짝수 스택AB 큐BA
        for(char c : map.keySet()){ // 왼쪽은 큐?
            q.add(c);
            s.add(c);

            map.put(c, map.get(c) - 2);
            if(map.get(c) == 0) map.remove(c); // 다 썼으면 삭제
        }


        if(flag == false) System.out.println("I'm Sorry Hansoo");
        else System.out.println();
    }
}
