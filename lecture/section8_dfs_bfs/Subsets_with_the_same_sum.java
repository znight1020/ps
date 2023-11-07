package lecture.section8_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Subsets_with_the_same_sum {
    static int allSum;
    static int[] arr;
    static String answer = "NO";
    public void DFS(int index, int sum){
        if(index >= arr.length) return;
        sum += arr[index];

        if(allSum - sum == sum) {
            answer = "YES";
            return;
        }
        else{
            DFS(index+1, sum);
            DFS(index+1, sum-arr[index]);
        }
    }
    public String solution(int[] arr){
        allSum = Arrays.stream(arr).sum();
        DFS(0, 0);

        return answer;
    }


    public static void main(String[] args) throws IOException {
        Subsets_with_the_same_sum s = new Subsets_with_the_same_sum();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        arr = new int[num];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(s.solution(arr));
    }
}
