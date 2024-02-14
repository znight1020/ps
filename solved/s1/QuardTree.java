package solved.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QuardTree {
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i < N ; i++)
            map[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();


        solution(0,0,N);
        System.out.println(sb);
    }

    static void solution(int y, int x, int length){
        int size = length * length;
        int zeroCount = 0, oneCount = 0;

        for(int i = y; i < y+length; i++){
            for(int j = x; j < x+length; j++){
                if(map[i][j] == 0) zeroCount++;
                else oneCount++;
            }
        }

        if(zeroCount == size) sb.append(0);
        else if(oneCount == size) sb.append(1);
        else{
            sb.append("(");
            solution(y, x, length / 2); // 1사분면
            solution(y, x + length / 2, length / 2);// 2사분면
            solution(y + length / 2, x, length / 2);// 3사분면
            solution(y + length / 2, x + length / 2, length / 2);// 4사분면
            sb.append(")");
        }
    }
}
