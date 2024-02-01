package solved.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class DNAPassword {

    static int answer = 0;
    static int S; // 문자열
    static int P; // 부분문자열
    static int[] conditionArr = new int[4];
    static char[] arr = {'A', 'C', 'G', 'T'};
    static void solution(char[] cString){
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 0); map.put('C', 0); map.put('G', 0); map.put('T', 0);
        int start = 0;
        int end = start + P - 1;
        boolean flag = true;

        for(int i = start; i <= end; i++)
            map.put(cString[i], map.getOrDefault(cString[i], 0) + 1);
        for(int i = 0; i < conditionArr.length; i++)
            if(map.get(arr[i]) < conditionArr[i]) flag = false;
        if(flag) answer++;
        start++;
        end++;

        while(end < S){
            flag = true;

            map.put(cString[start-1], map.get(cString[start-1])-1);
            map.put(cString[end], map.get(cString[end])+1);

//            for(char c : map.keySet()){
//                System.out.print(c + ": " + map.get(c) + " ");
//            }
//            System.out.println();
            for(int i = 0; i < conditionArr.length; i++)
                if(map.get(arr[i]) < conditionArr[i]) flag = false;

            if(flag) answer++;
            start++;
            end++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        char[] cString = str.toCharArray();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < conditionArr.length; i++) conditionArr[i] = Integer.parseInt(st.nextToken());

        solution(cString);

        System.out.print(answer);
    }
}
