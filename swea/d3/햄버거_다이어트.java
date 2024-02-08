package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Item{
    int p, c;
    Item(int p, int c){
        this.p = p; this.c = c;
    }
}
public class 햄버거_다이어트 {
    static int T, N, L, max;
    static Item[] src;
    static boolean[] select;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int  t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            src = new Item[N];
            select = new boolean[N];

            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                src[i] = new Item( Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) );

            }
            // 풀이
            max = 0;

            subset(0);
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.println(sb);

    }

    static void subset(int srcIndex){
        // 기저조건
        if(srcIndex == N){
            // complete code
            // 부분집합의 한 경우가 완성
            int cal = 0;
            int point = 0;

            for(int i = 0; i < N; i++){
                if ( ! select[i] ) continue;
                cal += src[i].c;
                point += src[i].p;
            }
            // 조건에 맞는 max 갱신
            if( cal <= L ) max = Math.max(max, point);
            return;
        }
        select[srcIndex] = true; // 선택
        subset(srcIndex+1);
        select[srcIndex] = false; // 비선택
        subset(srcIndex+1);
    }
}
