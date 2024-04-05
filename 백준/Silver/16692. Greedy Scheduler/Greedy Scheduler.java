import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static Queue<Integer> customers = new LinkedList<>();
    static int[] cashier;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        cashier = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++) customers.add(Integer.parseInt(st.nextToken()));

        while(!customers.isEmpty()){
            int temp = customers.poll(), min = Integer.MAX_VALUE, idx = -1;
            boolean flag = false;

            for(int i = 0; i < N; i++){
                if(cashier[i] == 0) {
                    cashier[i] += temp;
                    sb.append(i+1).append(" ");
                    flag = true;
                    break;
                }
                if(min > cashier[i]){
                    min = cashier[i];
                    idx = i;
                }
            }
            if(!flag) {
                for(int i = 0; i < N; i++) cashier[i] -= min;
                cashier[idx] += temp;
                sb.append(idx+1).append(" ");
            }
        }
        System.out.print(sb);
    }
}
