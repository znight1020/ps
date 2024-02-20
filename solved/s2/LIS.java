package solved.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LIS {
    static int N;
    static int[] arr;
    static ArrayList<Integer> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        solution();
        System.out.print(ans.size());
    }

    static void solution(){
        int idx = 0;
        ans.add(arr[0]);
        while(idx < N-1){
            idx++;
            if(arr[idx] > ans.get(ans.size()-1)) {
                ans.add(arr[idx]);
                continue;
            }
            int check = lowerBound(arr[idx], 0, ans.size());
            ans.set(check, arr[idx]);
        }
    }
    static int lowerBound(int n, int start, int end){
        while(start != end){
            int mid = (start+end) / 2;
            if(ans.get(mid) < n) start = mid + 1;
            else if(ans.get(mid) == n) return mid;
            else end = mid;
        }
        return end;
    }
}
