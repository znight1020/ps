package g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class OrdinaryBackpack {
    static int answer = 0;

    int solution(int K){
        // 선택된 요소들의 무게의 합이 총 무게를 넘지 않을 때
        return answer;
    }
    public static void main(String[] args) throws IOException{
        OrdinaryBackpack o = new OrdinaryBackpack();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<Integer, Integer> map = new HashMap<>();
        int weight, value; // 무게, 가치
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 개수
        int K = Integer.parseInt(st.nextToken()); // 최대 무게

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            weight = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());
            map.put(weight, value);
        }
        List<Integer> keyList = new ArrayList(map.keySet());
        //keyList.sort((s1, s2) -> s1.compareTo(s2));
        keyList.sort(Integer::compareTo);
        o.solution(K);
        
    }
    
}
