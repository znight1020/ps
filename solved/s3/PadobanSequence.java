package solved.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PadobanSequence {
    static long[] arr = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] qArr = new int[T+1];

        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        for(int i = 1; i <= T; i++) qArr[i] = Integer.parseInt(br.readLine());
        int max = Arrays.stream(qArr).max().getAsInt();
        for(int i = 4; i <= max; i++) arr[i] = arr[i-2] + arr[i-3];
        for(int i = 1; i <= qArr.length-1; i++) sb.append(arr[qArr[i]]).append("\n");
        System.out.print(sb);

/*        int i = 0;
        for(long x : arr){

            System.out.println("f( + " + i + " ): "  + x);
            i++;
        }*/
    }
}
