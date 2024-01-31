package solved.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HoneyPicking {
    static int[] arr;

    static int[] answer = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // arr[0]: 양끝에 벌, 가운데 어디든 벌통(i)
        target =
        // arr[1]: 왼쪽에 벌, 오른쪽 벌통
        // arr[2]: 오른쪽에 벌, 왼쪽 벌통


    }
}
