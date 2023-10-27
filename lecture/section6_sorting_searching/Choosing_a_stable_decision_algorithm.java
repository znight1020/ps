package lecture.section6_sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Choosing_a_stable_decision_algorithm {
    public int count(int[] arr, int distance){
        int cnt = 1;
        int first = arr[0];
        for(int x : arr){
            if(x - first >= distance) {
                cnt++;
                first = x;
            }
        }
        return cnt;
    }
    public int solution(int[] arr, int horse){
        int answer = 0, mid;
        Arrays.sort(arr);
        int lt = Arrays.stream(arr).min().getAsInt();
        int rt = Arrays.stream(arr).max().getAsInt();

        while(lt <= rt){
            mid = (lt+rt) / 2;
            //System.out.println("mid: " + mid);

            if(count(arr, mid) < horse){
                rt = mid-1;
            } else{
                answer = mid;
                lt = mid+1;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Choosing_a_stable_decision_algorithm c = new Choosing_a_stable_decision_algorithm();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int horse = Integer.parseInt(st.nextToken());

        int[] arr = new int[size];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < size; i++) arr[i] = Integer.parseInt(st.nextToken());

        System.out.println(c.solution(arr, horse));
    }
}
