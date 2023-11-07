package lecture.section8_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baduki_riding {
    static int limit;
    static int answer = Integer.MIN_VALUE;

    public void DFS(int index, int[] arr, int sum){
        if(index >= arr.length || sum > limit) return;
        else{
            sum += arr[index];
            if(sum > answer && sum <= limit) answer = sum;

            DFS(index+1, arr, sum);
            DFS(index+1, arr, sum - arr[index]);
        }
    }
    public static void main(String[] args) throws IOException {
        Baduki_riding b = new Baduki_riding();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arr;

        st = new StringTokenizer(br.readLine());
        limit = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());
        arr = new int[size];

        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        b.DFS(0, arr, 0);
        System.out.println(answer);
    }
}
