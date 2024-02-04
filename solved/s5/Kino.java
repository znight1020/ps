package solved.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Kino {
    static int answer = 1; // Mirko 자신을 포함한 그룹
    static List<Integer> arr;
    static int N;
    static Set<Integer> set = new HashSet<>();
    static void solution(){
//        // 사람의 수?
//        answer = set.stream().sorted().reduce(1, (sum, n) -> {
//            if(sum+n <= N) return sum + n;
//            else return sum;
//        });

        // 최소가 되는 그룹의 수 ?
        arr.sort(Integer::compareTo);
        int min = answer;
        for(int i = 1; i < arr.size(); i++){
            if(min <= N && min + arr.get(i) - 1 <= N && min + arr.get(i-1) >= min + arr.get(i))  // 최소가 되는 그룹들의 개수?
            {
                answer++;
                min = arr.get(i) - 1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();

        for(int i = 0; i < N; i++){
            int group = Integer.parseInt(br.readLine());
            arr.add(group);
        }

        solution();

        System.out.println(answer);
    }
}
