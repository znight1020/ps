package solved.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SnakeBird {
    static int[] fruitHeight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int i = 0;
        fruitHeight = new int[N];

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            fruitHeight[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        Arrays.sort(fruitHeight);
        for(i = 0; i < fruitHeight.length; i++){
            if(L >= fruitHeight[i]) L++;
            else if(L < fruitHeight[i]) break;
        }

        System.out.print(L);
    }
}
