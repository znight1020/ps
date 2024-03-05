import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> btnList = new ArrayList<>();
    static char[] N;
    static int M;
    static int toIntN;
    static int[] preMax;
    static int[] nextMin;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt, start = 100;
        N = br.readLine().toCharArray();
        preMax = new int[N.length - 1];
        nextMin = new int[N.length + 1];
        toIntN = Integer.parseInt(new String(N));
        M = Integer.parseInt(br.readLine());

        for(int i = 0; i <= 9; i++) btnList.add(i);
        if(M != 0) {
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                int removeNum = Integer.parseInt(st.nextToken());
                int idx = btnList.indexOf(removeNum);
                btnList.remove(idx);
            }
        }

        if(btnList.contains(1)){
            nextMin[0] = 1;
            for(int i = 1; i < nextMin.length; i++) nextMin[i] = btnList.get(0);
            cnt = N.length+1 + Math.abs(intArrToint(nextMin) - toIntN);
            answer = Math.min(cnt, answer);
            //System.out.println("intArrToint(nextMin): " + intArrToint(nextMin) + " , answer: " + answer);
        }

        if(N.length > 1 && !btnList.isEmpty()){
            for(int i = 0; i < preMax.length; i++) preMax[i] = btnList.get(btnList.size()-1);
            cnt = N.length-1 + Math.abs(intArrToint(preMax) - toIntN);
            answer = Math.min(cnt, answer);
            //System.out.println("intArrToint(preMax): " + intArrToint(preMax) + " , answer: " + answer);
        }
        comb(0, 0, new int[N.length], 0);
        cnt = Math.abs(start - toIntN);
        answer = Math.min(cnt, answer);
        System.out.print(answer);
    }

    static void comb(int L, int startIdx, int[] ans, int cnt){
        if(L == N.length){
            int sum = 0, oldCnt = cnt;
            boolean flag = false;

            for(int i = ans.length-1; i >= 0; i--) {
                sum += (int) (ans[ans.length-1 - i] * Math.pow(10, i));
                if(ans[ans.length-1 - i] != 0) flag = true;
                if(!flag) cnt--;
            }
            if(oldCnt != cnt) cnt++;

            cnt += Math.abs(sum - toIntN);
            answer = Math.min(cnt, answer);
            return;
        }

        if(startIdx >= btnList.size()) return;

        for(int i = 0; i < btnList.size(); i++){
            ans[L] = btnList.get(i);
            comb(L+1, i, ans, cnt + 1);
        }
    }

    static int intArrToint(int[] temp){
        int sum = 0;
        for(int i = temp.length-1; i >= 0; i--) sum += (int) (temp[temp.length-1 - i] * Math.pow(10, i));
        return sum;
    }
}
