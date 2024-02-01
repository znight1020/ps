package solved.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {
    static int answer = 0;
    static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()); // i
        c = Integer.parseInt(st.nextToken()); // j

        solution((int)Math.pow(2, N) * (int)Math.pow(2, N)); // 8 * 8 = 64
    }

    static void solution(int length){
        int temp = length / 4;
        System.out.println(answer);

        // 4개로 나누기
        if(r < length / 2 && c < length / 2) { // 1 사분면
            solution(length / 2);
        }
        else if(r < length / 2 && c >= length / 2) { // 2 사분면
            answer += temp;
            solution(length / 2);
        }
        else if(r >= length / 2 && c < length / 2) { // 3 사분면
            answer += temp * 2;
            solution(length / 2);
        }
        else if(r >= length / 2 && c >= length / 2) { // 4 사분면
            answer += temp * 3;
            solution(length / 2);
        }

    }
}
