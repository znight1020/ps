import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 1, idx = 1, sum = 0;
        while(idx < 1001){
            // 고정 수
            for(int i = 0; i < cnt; i++){
                if(idx > 1000) break;
                arr[idx] = cnt;
                idx++;
            }
            cnt++;
        }
        int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());
        for(int i = start; i <= end; i++) sum += arr[i];
        System.out.print(sum);
    }
}
