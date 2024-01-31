package solved.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HoneyPicking {
    static int[] preArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int answer = Integer.MIN_VALUE;

        preArr = new int[N];
        st = new StringTokenizer(br.readLine());
        preArr[0] = Integer.parseInt(st.nextToken());
        for(int i = 1; i < N; i++){
            preArr[i] = preArr[i-1] + Integer.parseInt(st.nextToken());
        }

        int basket, bee1, bee2;
        int temp1, temp2, temp3;

        for(int i = 1; i < preArr.length - 1; i++){
            // arr[0]: 양끝에 벌, 가운데 어디든 벌통(i)
            basket = i;
            bee1 = 0;
            bee2 = preArr.length-1;
            temp1 = solution1(basket, bee1, bee2);

            // arr[1]: 왼쪽에 벌, 오른쪽 벌통
            basket = preArr.length-1;
            bee2 = i;
            temp2 = solution2(basket, bee1, bee2);

            answer = Math.max(answer, Math.max(temp1, temp2));

            // arr[2]: 오른쪽에 벌, 왼쪽 벌통
            basket = 0;
            bee1 = preArr.length-1;
            temp3 = solution3(basket, bee1, bee2);

            answer = Math.max(answer, temp3);
        }

        System.out.print(answer);
    }

    static int solution1(int basket, int bee1, int bee2){
        int honeyBee1 = preArr[basket] - preArr[bee1];
        int honeyBee2 = preArr[bee2-1] - preArr[basket-1];

        return honeyBee1 + honeyBee2;
    }
    static int solution2(int basket, int bee1, int bee2){
        int honeyBee1 = preArr[basket] - preArr[bee1] - (preArr[bee2] - preArr[bee2-1]);
        int honeyBee2 = preArr[basket] - preArr[bee2];

        return honeyBee1 + honeyBee2;
    }
    static int solution3(int basket, int bee1, int bee2){
        int honeyBee1 = preArr[bee1-1] - (preArr[bee2] - preArr[bee2-1]);
        int honeyBee2 = preArr[bee2-1];

        return honeyBee1 + honeyBee2;
    }
}
