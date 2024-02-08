package solved.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SixEquations {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c1, c2, c3, c4, c5, c6;
        c1 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        c3 = Integer.parseInt(st.nextToken());
        c4 = Integer.parseInt(st.nextToken());
        c5 = Integer.parseInt(st.nextToken());
        c6 = Integer.parseInt(st.nextToken());

        int x1=1, x2=1, x3=1, x5=1, x6=1, x7=1;

        // 먼저 구해야 하는 수 x1, x2 구하면 x3, x4 계산가능

        // x6 구하면 x5, x7 계산가능

        // x1 != x3, x5 != x7

        int x4 = c4 * x1; // x1이 정의된 후 선언가능




    }
}
