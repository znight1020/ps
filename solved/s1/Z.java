package solved.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {
    static int answer = 0;
    static int N, r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()); // 세로
        c = Integer.parseInt(st.nextToken()); // 가로

        int length = (int)Math.pow(2, N);

        if(length == 4) answer = 2 * r + c - 1;
        else solution(length, length);

        System.out.print(answer);
    }

    static void solution(int rLength, int cLength){
        if((rLength == 1 && cLength == 1) || (r == rLength && c == cLength)) return;

        int tempR = rLength / 2;
        int tempC = cLength / 2;

        System.out.println("rLen: " + rLength + ", cLen: " + cLength + ", answer: " + answer);
        // 4개로 나누기
            if(r < rLength / 2 && c < cLength / 2) { // 1 사분면 = 점수 없음
                solution(rLength / 2, cLength / 2);
            }
            else if(r < rLength / 2 && c >= cLength / 2) { // 2 사분면 = 1 사분면의 점수 획득
                answer += tempR * tempC;
                solution(rLength / 2, cLength / 2);
            }
            else if(r >= rLength / 2 && c < cLength / 2) { // 3 사분면 = 1,2 사분면의 점수 획득
                answer += 2 * tempR * tempC;
                solution(rLength / 2, cLength / 2);
            }
            else if(r >= rLength / 2 && c >= cLength / 2) { // 4 사분면 = 1,2,3 사분면의 점수 획득
                answer += 3 * tempR * tempC;
                solution(rLength / 2, cLength / 2);
            }


//        if(rLength == 1 && cLength == 1) return;
//
//        int tempR = rLength / 2;
//        int tempC = cLength / 2;
//
//        // 4개로 나누기
//        if(r < tempR && c < tempC) { // 1 사분면 = 점수 없음
//            solution(tempR, tempC);
//        }
//        else if(r < tempR) { // 2 사분면 = 1 사분면의 점수 획득
//            answer += tempR * tempC;
//            solution(tempR, tempC);
//        }
//        else if(c < tempC) { // 3 사분면 = 1,2 사분면의 점수 획득
//            answer += 2 * tempR * tempC;
//            solution(tempR, tempC);
//        }
//        else { // 4 사분면 = 1,2,3 사분면의 점수 획득
//            answer += 3 * tempR * tempC;
//            solution(tempR , tempC);
//        }

    }
}
