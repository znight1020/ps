package solved.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DoyungFood {
    static int N, answer = Integer.MAX_VALUE;
    static int[] src;
    static ArrayList<Integer> t1Arr = new ArrayList<>();
    static ArrayList<Integer> t2Arr = new ArrayList<>();
    static boolean[] checked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        checked = new boolean[N];
        int t1, t2; // t1 신맛(곱), t2 쓴맛(합)

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            t1 = Integer.parseInt(st.nextToken());
            t2 = Integer.parseInt(st.nextToken());

            t1Arr.add(t1);
            t2Arr.add(t2);
        }
        src = new int[N];

        subset(0);
        System.out.println(answer);
    }
    static void subset(int srcIndex){
        if(srcIndex == src.length){
            int cnt = 0;
            for(int i = 0; i < checked.length; i++){
                if(!checked[i]) cnt++;
            }
            if(cnt == checked.length ) return;
            else answer = Math.min(answer, solution());
            return;
        }

        checked[srcIndex] = true;
        subset(srcIndex+1);
        checked[srcIndex] = false;
        subset(srcIndex+1);
    }

    static int solution(){
        int t1Multi = 1;
        int t2Sum = 0;
        for(int i = 0; i < src.length; i++){
            if(checked[i]) {
                t1Multi *= t1Arr.get(i);
                t2Sum += t2Arr.get(i);
            }
        }
        return Math.abs(t1Multi - t2Sum) ;
    }
}
