package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CardGame {
    static int[] gyu0 = new int[9];
    static boolean[] vtd = new boolean[19];
    static ArrayList<Integer> in0Possible;
    static int victory, lose;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int i;
        for(int t = 1; t <= T; t++){
            victory = 0; lose = 0;
            in0Possible = new ArrayList<>();
            int[] in0 = new int[9];
            for(i = 1; i <= 18; i++) in0Possible.add(i);

            st = new StringTokenizer(br.readLine());
            i = 0;

            while(st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                gyu0[i] = num;
                in0Possible.remove((Integer) num);
                i++;
            }

            perm(0, in0);

            System.out.println("#" + t + " " + victory + " " + lose);
        }
    }

    static void perm(int L, int[] in0){
        if(L == 9){
            int gyu = 0, in = 0;

            for(int i = 0; i < L; i++){
                if(gyu0[i] > in0[i]) gyu += gyu0[i] + in0[i];
                else in += gyu0[i] + in0[i];
            }
            if(gyu > in) victory++;
            else if(gyu < in) lose++;
            return;
        }

        for(int i = 0; i < 9; i++){
            if(!vtd[in0Possible.get(i)]){
                vtd[in0Possible.get(i)] = true;
                in0[L] = in0Possible.get(i);
                perm(L+1, in0);
                vtd[in0Possible.get(i)] = false;
            }

        }
    }
}
