import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static boolean flag = false, errorFlag;
    static StringBuilder sb = new StringBuilder();
    static char[] orderList;
    static ArrayDeque<Integer> dq = new ArrayDeque<>();
    static String[] numArray;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            errorFlag = false; flag = false; dq.clear();
            orderList = br.readLine().toCharArray();
            N = Integer.parseInt(br.readLine());
            String str = br.readLine();

            str = str.replace('[', ' ');
            str = str.replace(']', ' ');
            str = str.trim();

            numArray = str.split(",");
            for(int i = 0; i < N; i++) dq.add(Integer.parseInt(numArray[i]));

            com();

            if(!errorFlag) {
                int size = dq.size();
                sb.append("[");
                if(flag){
                    for(int i = 0; i < size; i++) {
                        sb.append(dq.pollLast());
                        if(i != size-1) sb.append(",");
                    }
                } else {
                    for(int i = 0; i < size; i++) {
                        sb.append(dq.pollFirst());
                        if(i != size-1) sb.append(",");
                    }
                }
                sb.append("]");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void com(){
        for(int i = 0; i < orderList.length; i++){
            if(orderList[i] == 'R') flag = !flag;

            else{
                if(dq.isEmpty()) {
                    sb.append("error");
                    errorFlag = true;
                    return;
                }

                if(!flag) dq.pollFirst(); // 정순
                else dq.pollLast();
            }

        }
    }
}
